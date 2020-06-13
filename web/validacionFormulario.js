var error;

function validar(){

    if (!Validarnombre() || !ValidarApellido() || !ValidarCargo() || !ValidarGenero() || !ValidarCedula()) {

        Validarnombre();
        ValidarApellido();
        ValidarCargo();
        ValidarGenero();
        ValidarCedula();
        return false;
    }
}

function borrar() {
    document.getElementById("mensaje1").innerHTML = "";
    document.getElementById("mensaje2").innerHTML = "";
    document.getElementById("mensaje3").innerHTML = "";
    document.getElementById("mensaje4").innerHTML = "";
    document.getElementById("mensaje5").innerHTML = "";
    document.getElementById("mensaje6").innerHTML = "";
    document.getElementById("mensaje7").innerHTML = "";
}

function Validarnombre() {

    var nombre = document.getElementById("nombre").value;
    error = document.getElementById("mensaje1");
    if (nombre == null || nombre.length == 0 || /^\s+$/.test(nombre)) {
        error.textContent = "Dijita el nombre";
        return false;
    }

}

function ValidarApellido() {

    var apellido = document.getElementById("apellido").value;
    error = document.getElementById("mensaje3");
    if (apellido == null || apellido.length == 0 || /^\s+$/.test(apellido)) {
        error.textContent = "Dijita el apellido";
        return false;
    }

}

function ValidarCargo() {

    var cargo = document.getElementById("opcionCargo").value;
    error = document.getElementById("mensaje2");
    if (cargo == null || cargo == 0) {
        error.textContent = "Seleccione una opcion";
        return false;
    }

}

function ValidarGenero() {

    var genero = document.getElementById("opcionCargo").value;
    error = document.getElementById("mensaje4");
    if (genero == null || genero == 0) {
        error.textContent = "Seleccione una opcion";
        return false;
    }

}

function ValidarCedula() {

    var cedula = document.getElementById("cedula").value;
    error = document.getElementById("mensaje5");
    if (cedula == null || cedula.length == 0 || /^\s+$/.test(cedula)) {
        error.textContent = "Dijita la cedula";
        return false;
    }

}
//clase encargada del select en tiendaOnline.jsp
class tiendaProductos{
    
    mostrarprecio(element) {
        var lista = element.parentElement;//
        console.log(lista.children[2]);//posicion de la etiquete p donde se mostrara el precio del producto. tiendaonline.jsp
        lista.children[2].innerHTML=`precio $: ${element.value}`;
    }
    
}
console.log(document.getElementById('product-cards'));
document.getElementById("product-cards").addEventListener("change", function(e){
    
    const ui = new tiendaProductos();
    ui.mostrarprecio(e.target);
    e.preventDefault();
});

