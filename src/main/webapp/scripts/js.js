document.addEventListener('DOMContentLoaded', () => {
  console.log('ready')
  init()
});

function init() {
  onshowapostar()
  // onshowresumen()
}

document.addEventListener('DOMContentLoaded', () => {
  console.log('ready')
  init()
});

function init() {
  onshowapostar()
}

function onshowapostar() {
  const modalApuesta = document.getElementById('modalApuesta');
  if (modalApuesta) {
    modalApuesta.addEventListener('show.bs.modal', (event) => {
      const button = event.relatedTarget;
      const local = button.getAttribute('data-bs-local');
      const visitante = button.getAttribute('data-bs-visitante');

      modalApuesta.querySelector('h5').textContent = local + ' - ' + visitante;

      // Event listener para el envío del formulario
      const formApuesta = modalApuesta.querySelector('#formApuesta');
      formApuesta.addEventListener('submit', (e) => {
        e.preventDefault();
        // Aquí puedes obtener los valores del formulario y enviarlos para crear la apuesta
        const cantidad = formApuesta.querySelector('#cantidad').value;
        // Aquí puedes realizar una acción con la cantidad y otros detalles para crear la apuesta
        crearApuesta(local, visitante, cantidad);
        // Cerrar el modal si es necesario
        // $('#modalApuesta').modal('hide'); // Si estás utilizando Bootstrap
      });
    });
  }
}
 
 function crearApuesta(local, visitante, cantidad) {
  // Realizar una petición AJAX para enviar la información al servidor
  const xhr = new XMLHttpRequest();
  const url = 'tu_servidor/endpoint_para_creacion_de_apuesta';

  // Preparar los datos a enviar al servidor
  const data = {
    local: local,
    visitante: visitante,
    cantidad: cantidad
    // Puedes agregar más detalles según tus necesidades
  };

  xhr.open('POST', url, true);
  xhr.setRequestHeader('Content-Type', 'application/json');

  xhr.onload = () => {
    if (xhr.status === 200) {
      // Lógica de éxito, si es necesario
      console.log('Apuesta creada exitosamente');
      // Puedes realizar acciones adicionales si la creación de la apuesta fue exitosa
      // Cerrar el modal, actualizar la interfaz, etc.
    } else {
      // Manejar errores, si es necesario
      console.error('Error al crear la apuesta');
    }
  };

  // Convertir los datos a formato JSON antes de enviar
  const jsonData = JSON.stringify(data);

  xhr.send(jsonData);
}



	// function onshowresumen() {
	//   const modalResumen = document.getElementById('modalresumen')
	//   if (modalResumen) {
	//     modalResumen.addEventListener('show.bs.modal', (event) => {
	//       const button = event.relatedTarget
	//       const partido = button.getAttribute('data-bs-partido')
	//       const local = button.getAttribute('data- bs-local')
	//       const visitante = button.getAttribute('data-bs-visitante')
	      
	//       modalResumen.querySelector('h5').textContent = local + ' - ' + visitante
	
	//       // AJAX
	//       const xhr = new XMLHttpRequest();
	//       const url = "Controller?op=resumen&partido=" + partido
	//       xhr.open("GET", url, true);
	//       xhr.onload = () => {
	//         if (xhr.status == 200) {
	//           const resumen = modalResumen.querySelector('#resumen')
	//           resumen.innerHTML = xhr.responseText;
	//         }
	 //};
	 //     xhr.send();
	//     })
	//   }
	// }
