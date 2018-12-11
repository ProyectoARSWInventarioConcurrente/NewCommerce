/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * @param {cedulaActual} cedula del usuraio actual 
 * @returns {undefined}
 */
function iniciarLocalStorageUsuario(cedulaActual) {

    localStorage.setItem('Actual', cedulaActual);
    //localStorage.removeItem('key');
    //localStorage.clear();
}

/**
 * @param {transaccion} transaccion que crusa el usuario 
 * @returns {undefined}
 */
function iniciarLocalStorageTransaccion(transaccion) {

    localStorage.setItem('Actual', transaccion);
    alert(localStorage.getItem('Actual'));
    //localStorage.removeItem('key');
    //localStorage.clear();
}

/**
 * @param {idProducto} idProducto de la variedad producto
 * @param {idVProducto} idVProducto del producto a vender
 * @returns {undefined}
 */
function guardarProductoLocalStorage(idProducto, idVProducto) {
    localStorage.setItem('A0' + idVProducto, idProducto);
    //alert(localStorage.getItem('A0'+idVProducto));
}

/**
 * @param {idUsuario} idUsuario del proveedor
 * @param {idVProducto} idVProducto del producto a vender
 * @returns {undefined}
 */
function guardarProveedoresLocalStorage(idUsuario, idVProducto) {

    localStorage.setItem(idVProducto, idUsuario);
    //alert('IdProducto: ' + localStorage.getItem(idVProducto));


}




/**
 * 
 * @returns {undefined}
 */
function cerrarLocalStorageUsuario() {

//localStorage.removeItem('key');
    localStorage.clear();
}

function verificarSesion() {
    if (localStorage.length === 0) {
        alert("Debe iniciar Sesion");
        $('#divRegistro').show();
    } else {
        $('#divRegistro').hide();
        location.href = "panelUsuario.html";
    }
}

/**
 * 
 * @returns {undefined}
 */
function registrarUsuario() {

    axios.post('/commerceUsuario/registrarUsuario', {
        "1": {
            cedulaUsuario: document.getElementById("inCedula").value,
            nombreUsuario: document.getElementById("inNombre").value,
            apellidoUsuario: document.getElementById("inApellido").value,
            direccionUsuario: document.getElementById("inDireccion").value,
            telefonoUsuario: document.getElementById("inTelefono").value,
            fechaNacimiento: document.getElementById("inFecha").value,
            correoElectronico: document.getElementById("inCorreo").value,
            contraseñaUsuario: document.getElementById("inContraseña").value
        }
    })
            .then(function (response) {
                console.log(response.data);
            })

}

/**
 * 
 * @returns {undefined}
 */
function iniciarSesion() {
    axios.get('/commerceUsuario/usuarios/' + document.getElementById("inCedula").value)
            .then(function (response) {
                if (response.data["contraseñaUsuario"] === document.getElementById("inContraseña").value) {
                    iniciarLocalStorageUsuario(response.data["cedulaUsuario"])
                    location.href = "panelUsuario.html";
                } else {
                    alert("Contraseña incorrecta");
                }
            })
            .catch(function (error) {
                alert("Este usuario no existe");
            })
}

function cerrarSesion() {
    cerrarLocalStorageUsuario()
    location.href = "index.html";
}



/**
 * 
 * @returns {undefined}
 */
function cargarUsuario() {
    axios.get('/commerceUsuario/usuarios/' + localStorage.getItem('Actual'))
            .then(function (response) {
                document.getElementById("nombreUsuarioActual").innerHTML = response.data["nombreUsuario"] + " " + response.data["apellidoUsuario"];
                document.getElementById("calificacionUsuarioActual").innerHTML = " Clasificacion: " + response.data["calificacionUsuario"];
                document.getElementById("saldoUsuarioActual").innerHTML = "Saldo: $" + response.data["saldoUsuario"] + " USD";
                //Actualizar los productos que estan en venta
                actualizarProductosEnVenta();
                actualizarTransaccionesEnCurso();
                //actualizarAnadirProducto();

                //actualizarHistorialDeTransacciones(response.data["cedulaUsuario"]);
            })
            .catch(function (error) {
                alert("Error, No se pudo cargar usuario");
            })

}



function actualizarProductosEnVenta() {

    var tbody = document.getElementById("tbodyTablaProducto");
    axios.get('/commerceProducto/variedades')
            .then(function (response) {

                for (var x in response.data) {
                    if (response.data[x]["idUsuario"] !== parseInt(localStorage.getItem('Actual'))) {

                        guardarProductoLocalStorage(response.data[x]["idProducto"], response.data[x]["idVProducto"]);
                        guardarProveedoresLocalStorage(response.data[x]["idUsuario"], response.data[x]["idVProducto"]);
                        var filatr = document.createElement("tr");
                        var resultado = response.data[x]["cantidadVProducto"] * response.data[x]["precioProducto"];
                        var idvProducto = "'"+String(response.data[x]["idVProducto"])+"'";
                        filatr.innerHTML = '<td>' + response.data[x]["nombreVProducto"] + '</td>' +
                                '<td id="tdProveedor' + response.data[x]["idVProducto"] + '"></td>' +
                                '<td>' + response.data[x]["cantidadVProducto"] + 'kg, ' + '</td>' +
                                '<td>$' + response.data[x]["precioProducto"] + ' COP (Precio/Kilo)</td>' +
                                '<td><b>$' + resultado + ' COP</b></td>' +
                                '<td>' + response.data[x]["fechaCosecha"] + '</td>' +
                                '<td> <button onclick="crearTransaccion('+ idvProducto +
                                ','+ localStorage.getItem('Actual') + 
                                ','+ response.data[x]["idUsuario"] +
                                ')" class="btn btn-primary">COMPRAR</button> </td>';
                        tbody.appendChild(filatr);
                    }
                }

                for (var i = 0; i < localStorage.length - 1; i++) {
                    agregarProveedor(i);
                }

            })
}

function agregarProveedor(x) {

    var producto = localStorage.key(x);
    if (String(producto).substr(0, 4) === '5c0f') {
        //alert(localStorage.getItem(producto));
        axios.get('/commerceUsuario/usuarios/' + localStorage.getItem(producto))
                .then(function (response) {

                    document.getElementById('tdProveedor' + localStorage.key(x)).innerHTML = response.data["nombreUsuario"] + ' ' +
                            response.data["apellidoUsuario"] + ' ' +
                            '<br> Calificacion' + response.data["calificacionUsuario"];

                })
    }
}

function actualizarTransaccionesEnCurso() {
    var tabla = document.getElementById("tablaTransaccionesEnCurso");
    tabla.innerHTML = "<thead><tr><th>Variedad</th><th>Proveedor</th><th>Descripcion</th><th>Metodo</th><th>Fecha</th></tr></thead>" +
            "<tbody id='tbodyTablaTransaccionesEnCursoV'></tbody><tbody id='tbodyTablaTransaccionesEnCursoC'></tbody>"

    var tbodyV = document.getElementById("tbodyTablaTransaccionesEnCursoV");
    axios.get('/commerceTransaccion/transacciones/vendedor/' + localStorage.getItem('Actual'))
            .then(function (response) {
                var ventasNull = response.data[0];
                for (var x in response.data) {
                    var filatr = document.createElement("tr");
                    for (var y in response.data[x]) {
                        var columna = document.createElement("td");
                        columna.innerHTML = response.data[x][y];
                        filatr.appendChild(columna);
                    }
                    tbodyV.appendChild(filatr);
                }
               

            })

    var tbodyC = document.getElementById("tbodyTablaTransaccionesEnCursoC");
    axios.get('/commerceTransaccion/transacciones/comprador/' + localStorage.getItem('Actual'))
            .then(function (response) {
                var comprasNull = response.data[0];
                for (var x in response.data) {
                    var filatr = document.createElement("tr");
                    for (var y in response.data[x]) {
                        var columna = document.createElement("td");
                        columna.innerHTML = response.data[x][y];
                        filatr.appendChild(columna);
                    }
                    tbodyC.appendChild(filatr);
                }
                

            })
}

function actualizarHistorialDeTransacciones() {
    var tbody = document.getElementById("tbodyTablaHistorialTransacciones");
    axios.get('/commerceTransaccion/transacciones/vendedor/' + localStorage.getItem('Actual'))
            .then(function (response) {
                for (var x in response.data) {
                    var filatr = document.createElement("tr");
                    for (var y in response.data[x]) {
                        var columna = document.createElement("td");
                        columna.innerHTML = response.data[x][y];
                        filatr.appendChild(columna);
                    }
                    tbody.appendChild(filatr);
                }

            })
}






/* 
 * Funciones para controlador de productos
 * 
 */

function actualizarAnadirProducto() {

    document.getElementById("cedulaUsuarioActual").innerHTML = localStorage.getItem('Actual');
    axios.get('/commerceProducto/productos')
            .then(function (response) {
                var selectCategoriaProducto = document.getElementById("selectCategoriaProducto");
                for (var x in response.data) {
                    //alert(response.data[x]["nombreProducto"]);
                    var opt = document.createElement("option");
                    opt.setAttribute("value", response.data[x]["idProducto"]);
                    var text = document.createTextNode(response.data[x]["nombreProducto"]);
                    opt.appendChild(text);
                    selectCategoriaProducto.appendChild(opt);
                    localStorage.setItem('reg'+response.data[x]["idProducto"], response.data[x]["nombreProducto"]);
                }
            })
    

}


function registrarNuevoVariedadProducto() {
    
    
    axios.post('/commerceProducto/registrarvproducto', {
        "1": {
            precioProducto: document.getElementById('precioProducto').value,
            fechaCosecha: document.getElementById("fechaCosecha").value,
            nombreVProducto: localStorage.getItem('reg'+document.getElementById("selectCategoriaProducto").value) + ' ' + document.getElementById("inNombre").value,
            idProducto: document.getElementById("selectCategoriaProducto").value,
            idUsuario: localStorage.getItem('Actual'),
            cantidadVProducto: document.getElementById("cantidadProducto").value

        }
    })
            .then(function (response) {
                console.log(response.data);
                alert("Producto Registrado Exitosamente.");
            })
}


/* 
 * Funciones para controlador ransacciones
 * 
 */
function crearTransaccion(idVProducto, cedulaComprador, cedulaProveedor) {
    alert(idVProducto +' '+ cedulaComprador +' '+ cedulaProveedor);
    axios.post('/commerceTransaccion/crearTransaccion', {
        "1": {          
            cedulaComprador: cedulaComprador,
            cedulaVendedor: cedulaProveedor,
            idVProducto: idVProducto
        }
    })
            .then(function (response) {
                console.log(response.data);
            })
}
