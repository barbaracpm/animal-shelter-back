package com.example.animal.shelter.controller;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.animal.shelter.models.entity.Animal;
import com.example.animal.shelter.models.entity.Region;
import com.example.animal.shelter.models.entity.Sex;
import com.example.animal.shelter.models.entity.Specie;
import com.example.animal.shelter.models.service.AnimalService;


//damos acceso al cliente
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
//definimos la ruta
@RequestMapping("/api")
public class AnimalRestController {
	
	
	//inyección de dependencias. No hace falta instanciar con new
	@Autowired
	private AnimalService animalService;
	
	//método get de todos los animales en ruta /api/animals
	@GetMapping("/animals")
	public List<Animal> index(){
		return animalService.findAll();
	}
	

	//método get de animal por id
	@GetMapping("/animals/{id}")
	public ResponseEntity<?>show(@PathVariable Long id){
		Animal animal = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			animal = animalService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(animal == null) {
			response.put("mensaje", "El animal ID: ".concat(id.toString().concat(" no existe en la bbdd")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Animal>(animal, HttpStatus.OK);
			
	}
	
	
//Método post (create) (añadir nuevo animal)
	@PostMapping("/animals")
	public ResponseEntity<?> create (@RequestBody Animal animal){
		Animal animalNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			animalNew = animalService.save(animal);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El animal ha sido introducido con éxito en la base de datos.");
		response.put("animal", animalNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	//método put (modificar animal por id)
	@PutMapping("/animals/{id}")
	public ResponseEntity<?> update (@RequestBody Animal animal, @PathVariable Long id){
		Animal animalCurrent = animalService.findById(id);
		Animal animalUpdated = null;
		Map<String, Object> response = new HashMap<>();
		
		if(animalCurrent == null) {
			response.put("mensaje", "Error no se pudo editar, el animal ID: ".concat(id.toString().concat(" no existe el id en la bbdd")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
			
		try {
			animalCurrent.setName(animal.getName());
			animalCurrent.setSpecie(animal.getSpecie());
			animalCurrent.setBirthDate(animal.getBirthDate());
			animalCurrent.setSex(animal.getSex());
			animalCurrent.setColor(animal.getColor());
			animalCurrent.setWeight(animal.getWeight());
			animalCurrent.setRegion(animal.getRegion());
			animalCurrent.setDescription(animal.getDescription());
	
			
			animalUpdated = animalService.save(animalCurrent);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
		response.put("mensaje", "El animal ha sido actualizado con éxito.");
		response.put("animal", animalUpdated);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	//Método delete (eliminar animal por id)
	@DeleteMapping("animals/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Map<String, Object> response = new HashMap<>();
		
		try {
			animalService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
		response.put("mensaje", "El animal ha sido eliminado con éxito!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	@PostMapping("animals/uploads")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id){
		Map<String, Object> response = new HashMap<>();
		
		Animal animal = animalService.findById(id);
		
		if(!archivo.isEmpty()) {
			//String nombreArchivo = archivo.getOriginalFilename();-->este codigo no reemplaza la imagen
			String nombreArchivo = UUID.randomUUID().toString()+"_"+archivo.getOriginalFilename().replace(" ", " ");
			Path rutaArchivo = Paths.get("uploads").resolve(nombreArchivo).toAbsolutePath();
		
		
		try {
			Files.copy(archivo.getInputStream(), rutaArchivo);
		} catch (Exception e) {
			response.put("mensaje", "Error al subir la imagen del cliente");
			response.put("error", e.getMessage().concat(": ").concat(e.getCause().getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		String nombreFotoAnterior = animal.getPicture();
		if(nombreFotoAnterior != null && nombreFotoAnterior.length() > 0) {
			Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
			File archivoFotoAnterior = rutaFotoAnterior.toFile();
			if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
				archivoFotoAnterior.delete();
			}
			
		}
		
		animal.setPicture(nombreArchivo);
		animalService.save(animal);
		
		response.put("animal", animal);
		response.put("mensaje", "Has subido correctamente la imagen: "+ nombreArchivo);
		}
	
	return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	
	}
	
	//foto
	
	@GetMapping("/uploads/img/{nombreFoto:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto){
		Path rutaArchivo = Paths.get("uploads").resolve(nombreFoto).toAbsolutePath();
		
		Resource recurso = null;
		
		try {
			recurso = new UrlResource(rutaArchivo.toUri());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		if(!recurso.exists() && !recurso.isReadable()) {
			throw new RuntimeException("Error no se puede cargar la imagen"+ nombreFoto);	
		}
		
		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachement; filename=\""+recurso.getFilename()+"\"");
		return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
		
	}
	

	
	@GetMapping("animals/regions")
	public List<Region>listRegions(){
		return animalService.findAllRegions();
	}
	
	
	@GetMapping("animals/species")
	public List<Specie>listSpecies(){
		return animalService.findAllSpecies();
	}
	
	@GetMapping("animals/sexs")
	public List<Sex>listSexs(){
		return animalService.findAllSexs();
	}
	
	/*@GetMapping("animals/volunteers")
	public List<Volunteer>listVolunteers(){
		return animalService.findAllVolunteers();
	}*/
	
	

}
