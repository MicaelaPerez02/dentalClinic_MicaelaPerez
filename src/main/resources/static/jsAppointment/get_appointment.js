window.addEventListener('load', function () {

  (function(){

    //con fetch invocamos a la API de s con el método GET
    //nos devolverá un JSON con una colección de s
    const url = 'http://localhost:8080/appointment';
    const settings = {
      method: 'GET'
    }

    fetch(url,settings)
    .then(response => response.json())
    .then(data => {

      console.log(data);
    //recorremos la colección de s del JSON
       for(appointments of data){
          //por cada pacientes armaremos una fila de la tabla
          //cada fila tendrá un id que luego nos permitirá borrar la fila si eliminamos la pacientes
          var table = document.getElementById("appointmentTable");
          var appointmentRow =table.insertRow();
          let tr_id = 'tr_' + appointment.id;
          appointmentRow.id = tr_id;

          //por cada turnos creamos un boton delete que agregaremos en cada fila para poder eliminar la misma
          //dicho boton invocara a la funcion de java script deleteByKey que se encargará
          //de llamar a la API para eliminar una turnos
          let deleteButton = '<button' +
                                    ' id=' + '\"' + 'btn_delete_' + appointment.id + '\"' +
                                    ' type="button" onclick="deleteBy('+appointment.id+')" class="btn btn-danger btn_delete">' +
                                    '&times' +
                                    '</button>';

          //por cada turnos creamos un boton que muestra el id y que al hacerle clic invocará
          //a la función de java script findBy que se encargará de buscar la turnos que queremos
          //modificar y mostrar los datos de la misma en un formulario.
          let updateButton = '<button' +
                                    ' id=' + '\"' + 'btn_id_' + appointment.id + '\"' +
                                    ' type="button" onclick="findBy('+appointment.id+')" class="btn btn-info btn_id">' +
                                    appointment.id +
                                    '</button>';

          //armamos cada columna de la fila
          //como primer columna pondremos el boton modificar
          //luego los datos del turnos
          //como ultima columna el boton eliminar
          appointmentRow.innerHTML = '<td>' + updateButton + '</td>' +
                  '<td class=\"td_titulo\">' + appointment.patient.name.toUpperCase() + '</td>' +
                  '<td class=\"td_categoria\">' + appointment.patient.lastName.toUpperCase() + '</td>' +
                  '<td class=\"td_categoria\">' + appointment.patient.dni + '</td>' +
                  '<td class=\"td_categoria\">' + appointment.patient.email+ '</td>' +
                  '<td class=\"td_categoria\">' + appointment.dentist.name+ '</td>' +
                  '<td class=\"td_categoria\">' + appointment.dentist.lastName +  '</td>' +
                  '<td class=\"td_categoria\">' + appointment.dentist.license +  '</td>' +
                  '<td class=\"td_categoria\">' + appointment.date  + '</td>'  +

                  '<td>' + deleteButton + '</td>';

      };

  })
  })

  (function(){
    let pathname = window.location.pathname;
    if (pathname == "/list_appointments.html") {
        document.querySelector(".nav .nav-item a:last").addClass("active");
    }
  })


  })