/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var cedulaAdministrador = 0;

/**
 * 
 * @returns {undefined}
 */
function iniciarSesion() {

    cedulaAdministrador = document.getElementById("inCedula").value;

    axios.get('/commerceAdmin/admins/' + document.getElementById("inCedula").value)
            .then(function (response) {
                console.log(response.data["contraseñaAdministrador"]);
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

/**
 * 
 * @returns {undefined}
 */
function verificarAdmin() {
    console.log("Hola");
    if (cedulaAdministrador === 0) {
        alert("Al parecer no ha ingresado");
        location.href = "iniciarSesionAdmin.html";
    }
}

/**
 * 
 * @returns {undefined}
 */
function cargarCrearProducto() {
    document.getElementById("title").innerHTML = "Crear nuevo producto";
    document.getElementById("phrase").innerHTML = "Ingresa los siguientes datos para crear un nuevo producto";

    var form = document.getElementById("regForm");
    form.setAttribute("onsubmit", "crearProducto(); return false");

    form.appendChild(crearInput("inNombre", "Nombre"));
    form.appendChild(crearInput("inCategoria", "Categoria"));

    form.appendChild(crearBoton());
}

/**
 * 
 * @param {type} idInput
 * @returns {undefined}
 */
function crearInput(idInput, titulo) {

    var firstDiv = document.createElement("div");
    firstDiv.style.display = "flex";
    firstDiv.style.justifyContent = "center";
    firstDiv.style.alignItems = "center";

    var secondDiv = document.createElement("div");
    secondDiv.className = "input-group mb-3";
    secondDiv.style.width = "30%";

    var thirdDiv = document.createElement("div");
    thirdDiv.className = "input-group-prepend";

    var span = document.createElement("span");
    span.className = "input-group-text";
    span.id = "basic-addon3";
    span.innerHTML = titulo;

    var input = document.createElement("input");
    input.type = "text";
    input.required = true;
    input.className = "form-control";
    input.id = idInput;
    input.ariaDescribedby = "basic-addon3";

    thirdDiv.appendChild(span);
    secondDiv.appendChild(thirdDiv);
    secondDiv.appendChild(input);
    firstDiv.appendChild(secondDiv);

    return firstDiv;
}

/**
 * 
 * @returns {undefined}
 */
function crearBoton() {
    var fourthDiv = document.createElement("div");
    fourthDiv.style.display = "flex";
    fourthDiv.style.justifyContent = "center";
    fourthDiv.style.alignItems = "center";

    var boton = document.createElement("button");
    boton.type = "submit";
    boton.className = "btn btn-secondary";
    boton.style.width = "30%";
    boton.innerHTML = "Enviar";

    fourthDiv.appendChild(boton);

    return fourthDiv;
}

/*
 * 
 */
function crearProducto() {
    axios.post('commerceProducto/registrarproducto', {
        "1": {
            "nombreProducto": document.getElementById("inNombre").value,
            "categoriaProducto": document.getElementById("inCategoria").value
        }
    })
            .then(function (response) {
                console.log(response.data);
            })
}