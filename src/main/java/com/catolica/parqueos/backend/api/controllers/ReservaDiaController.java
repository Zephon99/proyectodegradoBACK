package com.catolica.parqueos.backend.api.controllers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.Valid;

import com.catolica.parqueos.backend.api.Response.Response;
import com.catolica.parqueos.backend.api.modelos.ReservaDiaModel;
import com.catolica.parqueos.backend.api.modelos.ReservaModel;
import com.catolica.parqueos.backend.api.models.entity.Usuarios;
import com.catolica.parqueos.backend.api.services.ReservaDiaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.catolica.parqueos.backend.api.dao.IReservaDiaDao;
import com.catolica.parqueos.backend.api.models.entity.ReservaDia;
import com.catolica.parqueos.backend.api.services.IReservaDiaService;

@RestController
@RequestMapping("/reservadia")
public class ReservaDiaController {
	//@CrossOrigin(origins = { "http://localhost:4200" })
		@Autowired
		private IReservaDiaService reservaDiaService;

		private ReservaDiaServiceImpl reservaDiaServiceImpl;
	@Autowired
	public ReservaDiaController(ReservaDiaServiceImpl reservaDiaServiceImpl) {
		this.reservaDiaServiceImpl = reservaDiaServiceImpl;
	}



	
		/*@GetMapping("/reservasdias")
		public List<ReservaDiaVista> index() {
			
			return  reservaDiaService.search();
		}
		*/
		
		@GetMapping("/cantidadFechas")
		public List<Object> cantidadFechasReservas() {
				
			return  reservaDiaService.cantidadFechasReservas();
		}
		
		@GetMapping("/cantidadDias")
		public List<Object> cantidadDiasReservas() {
				
			return  reservaDiaService.cantidadDiasReservas();
		}
		
		@GetMapping("/cantidadReservasParqueo")
		public List<Object> cantidadReservasParqueo() {
				
			return  reservaDiaService.cantidadReservasParqueo();
		}
		
		@GetMapping("/cantidadParqueoReservas")
		public List<Object> cantidadParqueoReservas() {
				
			return  reservaDiaService.cantidadParqueoReservas();
		}
		
		@GetMapping("/cantidadReservasMes")
		public List<Object> cantidadReservasMes() {
				
			return  reservaDiaService.cantidadReservasMes();
		}
		
		@GetMapping("/cantidadMesReserva")
		public List<Object> cantidadMesReserva() {
				
			return  reservaDiaService.cantidadMesReserva();
		}
		
		@GetMapping("/reservasdias2")
		public List<ReservaDia> index2() {
			List<ReservaDia> lista = reservaDiaService.search2();
			
			return  reservaDiaService.search2();
		}
		
		
		/*@GetMapping("/reservasdias")
		public List<ReservaDia> index() {
			
			return reservaDiaService.findAll();
		}*/
		
		/*@GetMapping("/reservasdias")
		public List<ReservaDiaVista1> index() {
			
			return reservaDiaService.findAllVista();
		}*/
		
		@GetMapping("/reservasdias/{id}")
		public ResponseEntity<?> show(@PathVariable Long id) {

			ReservaDia reservaDia = null;
			Map<String, Object> response = new HashMap<>();
			try {
				reservaDia = reservaDiaService.findById(id);

			} catch (DataAccessException e) {
				response.put("mensaje", "Error al realizar la consulta en la base de datos!");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			if (reservaDia == null) {
				response.put("mensaje", "El plan de acción ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<ReservaDia>(reservaDia, HttpStatus.OK);
		}
		
		@PostMapping("/reservasdias")
		public ResponseEntity<?> create(@Valid @RequestBody ReservaDia reservaDia, BindingResult result) {

			ReservaDia reservaDiaNew = null;
			Map<String, Object> response = new HashMap<>();

			if (result.hasErrors()) {
				List<String> errors = result.getFieldErrors().stream()
						.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
						.collect(Collectors.toList());

				response.put("errors", errors);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

			}

			try {
				reservaDiaNew = reservaDiaService.save(reservaDia);

			} catch (DataAccessException e) {
				response.put("mensaje", "Error al realizar el insert en la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

			}

			response.put("mensaje", "El plan de acción ha sido creado con exito");
			response.put("actionPlan", reservaDiaNew);

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		}
		
		@PutMapping("/reservasdias/{id}")
		public ResponseEntity<?> update(@Valid @RequestBody ReservaDia reservaDia, BindingResult result, @PathVariable Long id) {

			ReservaDia reservaDiaActual = reservaDiaService.findById(id);

			ReservaDia reservaDiaUpdated = null;
			Map<String, Object> response = new HashMap<>();

			if (result.hasErrors()) {

				List<String> errors = result.getFieldErrors().stream()
						.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
						.collect(Collectors.toList());

				response.put("errors", errors);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

			}

			if (reservaDiaActual == null) {
				response.put("mensaje", "Error: no se pudo editar, el plan de acción con el ID: "
						.concat(id.toString().concat(" no existe en la base de datos!")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}

			try {
				reservaDiaActual.setReservaDiaCosto(reservaDia.getReservaDiaCosto());
				reservaDiaActual.setReservaDiaEstado(reservaDia.getReservaDiaEstado());
				reservaDiaActual.setReservaDiaFecha(reservaDia.getReservaDiaFecha());
				reservaDiaActual.setReservaDiaHoraFin(reservaDia.getReservaDiaHoraFin());
				reservaDiaActual.setReservaDiaHoraInicio(reservaDia.getReservaDiaHoraInicio());
				reservaDiaActual.setReservaDiaId(reservaDia.getReservaDiaId());
				reservaDiaActual.setUsuarioId(reservaDia.getUsuarioId());
								
				reservaDiaUpdated = reservaDiaService.save(reservaDiaActual);

			} catch (DataAccessException e) {
				response.put("mensaje", "Error al actualizar en la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

			}

			response.put("mensaje", "El riesgo ha sido actualizado con exito");
			response.put("actionPlan", reservaDiaUpdated);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		}
		
		@DeleteMapping("reservasdias/{id}")
		public ResponseEntity<?> delete(@PathVariable Long id) {

			Map<String, Object> response = new HashMap<>();

			try {
				reservaDiaService.delete(id);
			} catch (DataAccessException e) {
				response.put("mensaje", "Error al eliminar en la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

			}
			response.put("mensaje", "El plan de acción ha sido eliminado con exito");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}


	@RequestMapping(
			value = "getReservaByHoraInicioAndEstado/{reserva_dia_hora_inicio}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getUsuarioByEmail(@PathVariable("reserva_dia_hora_inicio") String reservaHoraInicio){
		Response response = new Response();

		try{

			ArrayList<ReservaDia> reservaDias = reservaDiaServiceImpl.findReservaDiaByReservaDiaHoraInicioAndReservaDiaEstado(reservaHoraInicio,"RESERVADO");

			response.setData(reservaDias);

		}catch (Exception e){
			response.setSuccess(false);
			response.setStatusMessage(e.getMessage());
		}
		return response;
	}

	@RequestMapping(
			value = "createReservaDia",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response createReserva(@RequestBody ReservaDiaModel reservaDiaModel){
		Response response = new Response();
		try{
			reservaDiaServiceImpl.createReservaDia(reservaDiaModel);
		}catch (Exception e){
			response.setSuccess(false);
			response.setStatusMessage(e.getMessage());
		}
		return response;
	}
}






