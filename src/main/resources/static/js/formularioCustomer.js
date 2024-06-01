let boton = document.getElementById("btnRegistrar");
boton.addEventListener("click", evento =>{
    registrarPelicula();
});
let registrarPelicula = async()=>{
    let campos = {};

    campos.name = document.getElementById("name").value;
    campos.last_name = document.getElementById("last_name").value;
    campos.dni = document.getElementById("dni").value;
    campos.birthdate = document.getElementById("birthdate").value;
    campos.phone_number = document.getElementById("phone_number").value;
    campos.address = document.getElementById("address").value;



    const peticion = await fetch("http://localhost:8081/customer",
    {   method: 'POST',
        headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        },
        body: JSON.stringify(campos)
    });
}