package com.catolica.parqueos.backend.api.controllers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catolica.parqueos.backend.api.models.entity.Queja;
import com.catolica.parqueos.backend.api.services.IQuejaService;

@RestController
@RequestMapping("/queja")
public class QuejaController {
	@Autowired
	private IQuejaService quejaService;
	@GetMapping("/listaQuejas")
	public List<Queja> listaQuejas() {
		return  quejaService.listaQuejas();
	}
	@GetMapping("/quejas")
	public List<Queja> index() {
		return quejaService.findAll();
	}
	
	@GetMapping("/quejas/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {

		Queja process = null;
		Map<String, Object> response = new HashMap<>();
		try {
			process = quejaService.findById(id);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (process == null) {
			response.put("mensaje", "El plan de acción ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Queja>(process, HttpStatus.OK);
	}
	
	@PostMapping("/parqueos")
	public ResponseEntity<?> create(@Valid @RequestBody Queja queja, BindingResult result) {

		Queja processNew = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

		}

		try {
			processNew = quejaService.save(queja);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}

		response.put("mensaje", "El plan de acción ha sido creado con exito");
		response.put("actionPlan", processNew);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/parqueos/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Queja queja, BindingResult result, @PathVariable Long id) {

		Queja quejaActual = quejaService.findById(id);

		Queja quejaUpdated = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

		}

		if (quejaActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el plan de acción con el ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			quejaActual.setQuejaDateRegistration(queja.getQuejaDateRegistration());
			quejaActual.setQuejaDescription(queja.getQuejaDescription());
			quejaActual.setQuejaId(queja.getQuejaId());
			quejaActual.setUsuarioId(queja.getUsuarioId());
	
							
			quejaUpdated = quejaService.save(quejaActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}

		response.put("mensaje", "El riesgo ha sido actualizado con exito");
		response.put("actionPlan", quejaUpdated);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("parqueos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Map<String, Object> response = new HashMap<>();

		try {
			quejaService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		response.put("mensaje", "El plan de acción ha sido eliminado con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}






