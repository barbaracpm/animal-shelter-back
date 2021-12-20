package com.example.animal.shelter.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.animal.shelter.models.entity.Volunteer;
import com.example.animal.shelter.models.service.VolunteerService;

//cors para autorizar al cliente
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class VolunteerRestController {
	
	@Autowired
	private VolunteerService volunteerService;
	
	@GetMapping("/volunteers")
	public List<Volunteer> index(){
		return volunteerService.findAll();
	}
	

	
	//con manejo de errores
	@GetMapping("/volunteers/{id}")
	public ResponseEntity<?>show(@PathVariable Long id){
		Volunteer volunteer = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			volunteer = volunteerService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(volunteer == null) {
			response.put("mensaje", "El ID del voluntario: ".concat(id.toString().concat(" no existe en la bbdd")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Volunteer>(volunteer, HttpStatus.OK);
			
	}
	
	
	//Post con manejo de errores
	@PostMapping("/volunteers")
	public ResponseEntity<?> create (@RequestBody Volunteer volunteer){
		Volunteer volunteerNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			volunteerNew = volunteerService.save(volunteer);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El voluntario ha sido introducido con éxito en la base de datos.");
		response.put("volunteer", volunteerNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/volunteers/{id}")
	public ResponseEntity<?> update (@RequestBody Volunteer volunteer, @PathVariable Long id){
		Volunteer volunteerCurrent = volunteerService.findById(id);
		Volunteer volunteerUpdated = null;
		Map<String, Object> response = new HashMap<>();
		
		if(volunteerCurrent == null) {
			response.put("mensaje", "Error no se pudo editar, el ID del voluntario: ".concat(id.toString().concat(" no existe el id en la bbdd")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
			
		try {
			volunteerCurrent.setName(volunteer.getName());
			volunteerCurrent.setSurname(volunteer.getSurname());
			volunteerCurrent.setEmail(volunteer.getEmail());
			volunteerCurrent.setPhone(volunteer.getPhone());
			
			volunteerUpdated = volunteerService.save(volunteerCurrent);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
		response.put("mensaje", "El voluntario ha sido actualizado con éxito.");
		response.put("volunteer", volunteerUpdated);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("volunteers/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Map<String, Object> response = new HashMap<>();
		
		try {
			volunteerService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
		response.put("mensaje", "El voluntario ha sido eliminado con éxito!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	

	

}
