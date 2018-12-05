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
                if (response.data["contraseñaUsuario"] === document.getElementById("inContraseña").value) {
                    alert("Incio de sesion correcto");
                } else{
                    alert("Contraseña incorrecta");
                }
            })
            .catch(function (error) {
                alert("Este usuario no existe");
            })
}