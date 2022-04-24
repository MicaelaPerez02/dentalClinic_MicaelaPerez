window.addEventListener('load', function () {

   (function(){

     //con fetch invocamos a la API de s con el método GET
     //nos devolverá un JSON con una colección de s
     const url = 'http://localhost:8080/patient';
     const settings = {
       method: 'GET'
     }

     fetch(url,settings)
     .then(response => response.json())
     .then(data => {

       console.log(data);
     //recorremos la colección de s del JSON
        for(patiet of data){
           //por cada pacientes armaremos una fila de la tabla
           //cada fila tendrá un id que luego nos permitirá borrar la fila si eliminamos la pacientes
           var table = document.getElementById("patientTable");
           var patientRow =table.insertRow();
           let tr_id = 'tr_' + patient.id;
           patientRow.id = tr_id;

           //por cada pacientes creamos un boton delete que agregaremos en cada fila para poder eliminar la misma
           //dicho boton invocara a la funcion de java script deleteByKey que se encargará
           //de llamar a la API para eliminar una pacientes
           let deleteButton = '<button' +
                                     ' id=' + '\"' + 'btn_delete_' + patient.id + '\"' +
                                     ' type="button" onclick="deleteBy('+patient.id+')" class="btn btn-danger btn_delete">' +
                                     '&times' +
                                     '</button>';

           //por cada pacientes creamos un boton que muestra el id y que al hacerle clic invocará
           //a la función de java script findBy que se encargará de buscar la pacientes que queremos
           //modificar y mostrar los datos de la misma en un formulario.
           let updateButton = '<button' +
                                     ' id=' + '\"' + 'btn_id_' + patient.id + '\"' +
                                     ' type="button" onclick="findBy('+patient.id+')" class="btn btn-info btn_id">' +
                                     patient.id +
                                     '</button>';

           //armamos cada columna de la fila
           //como primer columna pondremos el boton modificar
           //luego los datos del pacientes
           //como ultima columna el boton eliminar
           patientRow.innerHTML = '<td>' + updateButton + '</td>' +
                   '<td class=\"td_titulo\">' + patient.name.toUpperCase() + '</td>' +
                   '<td class=\"td_categoria\">' + patient.lastName.toUpperCase() + '</td>' +
                   '<td class=\"td_categoria\">' + patient.dni + '</td>' +
                   '<td class=\"td_categoria\">' + patient.email+ '</td>' +
                   '<td>' + deleteButton + '</td>';

       };

   })
   })

   (function(){
     let pathname = window.location.pathname;
     if (pathname == "/list_patients.html.html") {
         document.querySelector(".nav .nav-item a:last").addClass("active");
     }
   })


   })