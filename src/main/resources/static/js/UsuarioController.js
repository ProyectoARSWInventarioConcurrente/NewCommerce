/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var cedulaUsuario;

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
                    this.cedulaUsuario = document.getElementById("inCedula").value;
                    console.log(this.cedulaUsuario);
                    //alert("cedula" + cedulaUsuario);
                    location.href = "panelUsuario.html";

                } else {
                    alert("Contraseña incorrecta");
                }
            })
            .catch(function (error) {
                alert("Este usuario no existe");
            })
}

/**
 * 
 * @returns {undefined}
 */
function cargarUsuario() {
    axios.get('/commerceUsuario/usuarios/')
            .then(function (response) {
                alert(this.cedulaUsuario);
                /**alert(response.data["nombreUsuario"])
                 document.getElementById("nombreUsuario").value = response.data["nombreUsuario"];
                 document.getElementById("apellidoUsuario").value = response.data["apellidoUsuario"];
                 document.getElementById("nombreUsuario").value = response.data["nombreUsuario"];*/
            })
            .catch(function (error) {
                alert("error al cargar usuario")
            })

}

function actualizarPanelUsuario() {
    var tbody = document.getElementById("tbodyTablaProducto");
    axios.get('/commerceProducto/variedades')
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

function actualizarAnadirProducto() {
    var selectCategoriaProducto = document.getElementById("");
    var cedulaUsuario = document.getElementById("");
    var selectLocalizacion = document.getElementById("");

    axios.get('/commerceProducto/variedades')
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
