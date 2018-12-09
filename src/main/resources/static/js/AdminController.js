/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @returns {undefined}
 */
function iniciarSesion() {
    axios.get('/commerceAdmin/admins/' + document.getElementById("inCedula").value)
            .then(function (response) {
                if (response.data["contraseñaAdministrador"] === document.getElementById("inContraseña").value) {
                    location.href = "panelAdministrador.html";
                } else {
                    alert("Contraseña incorrecta");
                }
            })
            .catch(function (error) {
                alert("Este administrador no existe")
            })
}
