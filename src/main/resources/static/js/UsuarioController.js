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
    alert(localStorage.getItem('Actual'));
    //localStorage.removeItem('key');
    //localStorage.clear();
}

/**
 * @param {producto} producto  
 * @returns {undefined}
 */
function iniciarLocalStorageProducto(producto) {
    
    localStorage.setItem('Actual', producto);
    alert(localStorage.getItem('Actual'));
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
 * 
 * @returns {undefined}
 */
function cerrarLocalStorageUsuario() {
    
    //localStorage.removeItem('key');
    localStorage.clear();
}

function verificarSesion(){
    if(localStorage.length === 0){
        alert("Debe iniciar Sesion");
        location.href = "panelUsuario.html";
    } else {
        alert("que paso");
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
                console.log(response.data["contraseñaUsuario"]);
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
                actualizarProductosEnVenta();
                actualizarTransaccionesEnCurso();
                //actualizarAnadirProducto();
                //actualizarHistorialDeTransacciones(response.data["cedulaUsuario"]);
            })
            .catch(function (error) {
                alert("Esta pagina requiere iniciar sesion");
                location.href = "index.html";
            })

}


function actualizarProductosEnVenta() {
    var tbody = document.getElementById("tbodyTablaProducto");
    axios.get('/commerceProducto/productos')
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
                if (ventasNull === undefined) {
                    tbodyV.innerHTML = "<tr><td>no hay ventas</td></tr>";
                }

            })

    var tbodyC = document.getElementById("tbodyTablaTransaccionesEnCursoC");
    axios.get('/commerceTransaccion/transacciones/comprador/' + cedula)
            .then(function (response) {
                var comprasNull = response.data[0];
                for (var x in response.data) {
                    var filatr = document.createElement("tr");
                    for (var y in response.data[x]) {
                        var columna = document.createElement("td");
                        columna.innerHTML = response.data[x][y];
                        filatr.appendChild(columna);
                    }
                    tbodyC.innerHTML = "<tr><td>no hay compras</td></tr>";
                    //tbodyC.appendChild(filatr);
                }
                if (comprasNull === undefined) {
                    tbodyC.innerHTML = "<tr><td>no hay Compras</td></tr>";
                }

            })
}

function actualizarHistorialDeTransacciones() {
    var tbody = document.getElementById("tbodyTablaHistorialTransacciones");
    axios.get('/commerceTransaccion/transacciones/vendedor/' + cedulaUsuarioActual)
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
                    alert(response.data[x]["nombreProducto"]);
                    var opt = document.createElement("option");
                    opt.setAttribute("value", response.data[x]["idProducto"]);
                    var text = document.createTextNode(response.data[x]["nombreProducto"]);
                    opt.appendChild(text);
                    alert(opt);

                    selectCategoriaProducto.appendChild(opt);
                }
            })
}