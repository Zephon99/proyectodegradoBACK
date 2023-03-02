package com.catolica.parqueos.backend.api.controllers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.catolica.parqueos.backend.api.Response.Response;
import com.catolica.parqueos.backend.api.modelos.UsuariosModel;
import com.catolica.parqueos.backend.api.models.entity.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.catolica.parqueos.backend.api.models.entity.EspacioParqueo;
import com.catolica.parqueos.backend.api.services.IEspacioParqueoService;

@RestController
@RequestMapping("/espacioParqueo")
public class EspacioParqueoController {
	//@CrossOrigin(origins = { "http://localhost:4200" })
		@Autowired
		private IEspacioParqueoService espacioParqueoService;
		
		@GetMapping("/espacioParqueos")
		public List<EspacioParqueo> index() {

			return espacioParqueoService.findAll();
		}
		
		@GetMapping("/espacioParqueos/{id}")
		public ResponseEntity<?> show(@PathVariable Long id) {

			EspacioParqueo process = null;
			Map<String, Object> response = new HashMap<>();
			try {
				process = espacioParqueoService.findById(id);

			} catch (DataAccessException e) {
				response.put("mensaje", "Error al realizar la consulta en la base de datos!");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			if (process == null) {
				response.put("mensaje", "El plan de acción ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<EspacioParqueo>(process, HttpStatus.OK);
		}
		
		@PostMapping("/espacioParqueos")
		public ResponseEntity<?> create(@Valid @RequestBody EspacioParqueo espacioParqueo, BindingResult result) {

			EspacioParqueo espacioParqueoNew = null;
			Map<String, Object> response = new HashMap<>();

			if (result.hasErrors()) {
				List<String> errors = result.getFieldErrors().stream()
						.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
						.collect(Collectors.toList());

				response.put("errors", errors);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

			}
			try {
				espacioParqueoNew = espacioParqueoService.save(espacioParqueo);

			} catch (DataAccessException e) {
				response.put("mensaje", "Error al realizar el insert en la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			response.put("mensaje", "El plan de acción ha sido creado con exito");
			response.put("actionPlan", espacioParqueoNew);

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		}
		
		@PutMapping("/espacioParqueos/{id}")
		public ResponseEntity<?> update(@Valid @RequestBody EspacioParqueo espacioParqueo, BindingResult result, @PathVariable Long id) {

			EspacioParqueo espacioParqueoActual = espacioParqueoService.findById(id);

			EspacioParqueo espacioParqueoUpdated = null;
			Map<String, Object> response = new HashMap<>();

			if (result.hasErrors()) {

				List<String> errors = result.getFieldErrors().stream()
						.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
						.collect(Collectors.toList());

				response.put("errors", errors);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

			}

			if (espacioParqueoActual == null) {
				response.put("mensaje", "Error: no se pudo editar, el plan de acción con el ID: "
						.concat(id.toString().concat(" no existe en la base de datos!")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}

			try {
				espacioParqueoActual.setEspacioParqueoFechaDisponible(espacioParqueo.getEspacioParqueoFechaDisponible());
				espacioParqueoActual.setEspacioParqueoId(espacioParqueo.getEspacioParqueoId());
				espacioParqueoActual.setEspacioParqueoNombre(espacioParqueo.getEspacioParqueoNombre());
				espacioParqueoActual.setEspacioParqueoTamaño(espacioParqueo.getEspacioParqueoTamaño());
				espacioParqueoActual.setEspacioParqueoTipo(espacioParqueo.getEspacioParqueoTipo());
				espacioParqueoActual.setParqueoId(espacioParqueo.getEspacioParqueoId());
								
				espacioParqueoUpdated = espacioParqueoService.save(espacioParqueoActual);

			} catch (DataAccessException e) {
				response.put("mensaje", "Error al actualizar en la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

			}

			response.put("mensaje", "El riesgo ha sido actualizado con exito");
			response.put("actionPlan", espacioParqueoUpdated);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		}
		
		@DeleteMapping("espacioParqueos/{id}")
		public ResponseEntity<?> delete(@PathVariable Long id) {

			Map<String, Object> response = new HashMap<>();

			try {
				espacioParqueoService.delete(id);
			} catch (DataAccessException e) {
				response.put("mensaje", "Error al eliminar en la base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

			}
			response.put("mensaje", "El plan de acción ha sido eliminado con exito");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}

	@RequestMapping(
			value = "getEspacioParqueos",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getEspacioParqueos(){
		Response response = new Response();
		try{
			ArrayList<EspacioParqueo> espacioParqueos = (ArrayList<EspacioParqueo>) espacioParqueoService.findAll();
			response.setData(espacioParqueos);

		}catch (Exception e){
			response.setSuccess(false);
			response.setStatusMessage(e.getMessage());
		}
		return response;
	}

}






