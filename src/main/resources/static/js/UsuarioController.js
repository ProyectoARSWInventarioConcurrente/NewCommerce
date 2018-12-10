/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
                    axios.post('/commerceUsuario/mantenerUsuario/' + document.getElementById("inCedula").value)
                            .then(function (response) {
                                console.log(response.data);
                            })
                    //var cedula = pedirCedulaActual();
                    //alert("sirvio cedula: " + cedula);
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
    axios.delete('/commerceUsuario/cerrarSesion/')
            .then(function (response) {
                location.href = "index.html";
            })
            .catch(function (error) {
                alert("Erro, no se puede cerrar sesion")
            })

}

/**
 * 
 * @returns {undefined}
 */
function cargarUsuario() {

    axios.get('/commerceUsuario/usuarioActual/')
            .then(function (response) {
                //console.log(response.data["nombreUsuario"]);
                document.getElementById("nombreUsuarioActual").innerHTML = response.data["nombreUsuario"] + " " + response.data["apellidoUsuario"];
                document.getElementById("calificacionUsuarioActual").innerHTML = " Clasificacion: " + response.data["calificacionUsuario"];
                document.getElementById("saldoUsuarioActual").innerHTML = "Saldo: $" + response.data["saldoUsuario"] + " USD";
                actualizarProductosEnVenta();
                actualizarTransaccionesEnCurso(response.data["cedulaUsuario"]);
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

function actualizarTransaccionesEnCurso(cedula) {
    var tabla = document.getElementById("tablaTransaccionesEnCurso");

    tabla.innerHTML = "<thead><tr><th>Variedad</th><th>Proveedor</th><th>Descripcion</th><th>Metodo</th><th>Fecha</th></tr></thead>" +
            "<tbody id='tbodyTablaTransaccionesEnCursoV'></tbody><tbody id='tbodyTablaTransaccionesEnCursoC'></tbody>"

    var tbodyV = document.getElementById("tbodyTablaTransaccionesEnCursoV");
    axios.get('/commerceTransaccion/transacciones/vendedor/' + cedula)
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
    //document.getElementById("cedulaUsuarioActual").innerHTML = cedulaActual;
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