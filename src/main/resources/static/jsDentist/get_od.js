window.addEventListener('load', function () {

  (function(){

    //con fetch invocamos a la API de s con el método GET
    //nos devolverá un JSON con una colección de s
    const url = 'http://localhost:8080/dentist';
    const settings = {
      method: 'GET'
    }

    fetch(url,settings)
    .then(response => response.json())
    .then(data => {

      console.log(data);
    //recorremos la colección de s del JSON
       for(dentists of data){
          //por cada odontologos armaremos una fila de la tabla
          //cada fila tendrá un id que luego nos permitirá borrar la fila si eliminamos la odontologos
          var table = document.getElementById("dentistTable");
          var dentistRow =table.insertRow();
          let tr_id = 'tr_' + dentist.id;
          dentistRow.id = tr_id;

          //por cada odontologos creamos un boton delete que agregaremos en cada fila para poder eliminar la misma
          //dicho boton invocara a la funcion de java script deleteByKey que se encargará
          //de llamar a la API para eliminar una odontologos
          let deleteButton = '<button' +
                                    ' id=' + '\"' + 'btn_delete_' + dentist.id + '\"' +
                                    ' type="button" onclick="deleteBy('+dentist.id+')" class="btn btn-danger btn_delete">' +
                                    '&times' +
                                    '</button>';

          //por cada odontologos creamos un boton que muestra el id y que al hacerle clic invocará
          //a la función de java script findBy que se encargará de buscar la odontologos que queremos
          //modificar y mostrar los datos de la misma en un formulario.
          let updateButton = '<button' +
                                    ' id=' + '\"' + 'btn_id_' + dentist.id + '\"' +
                                    ' type="button" onclick="findBy('+dentist.id+')" class="btn btn-info btn_id">' +
                                    dentist.id +
                                    '</button>';

          //armamos cada columna de la fila
          //como primer columna pondremos el boton modificar
          //luego los datos del odontologos
          //como ultima columna el boton eliminar
          dentistRow.innerHTML = '<td>' + updateButton + '</td>' +
                  '<td class=\"td_titulo\">' + dentist.name.toUpperCase() + '</td>' +
                  '<td class=\"td_categoria\">' + dentist.lastName.toUpperCase() + '</td>' +
                  '<td class=\"td_categoria\">' + dentist.license + '</td>' +

                  '<td>' + deleteButton + '</td>';

      };

  })
  })

  (function(){
    let pathname = window.location.pathname;
    if (pathname == "/list_dentists.html") {
        document.querySelector(".nav .nav-item a:last").addClass("active");
    }
  })


  })