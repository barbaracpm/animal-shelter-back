package com.example.animal.shelter.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.animal.shelter.models.entity.Animal;
import com.example.animal.shelter.models.entity.Region;
import com.example.animal.shelter.models.entity.Sex;
import com.example.animal.shelter.models.entity.Specie;
import com.example.animal.shelter.models.entity.Volunteer;


public interface AnimalDao extends CrudRepository<Animal, Long>{//IMPLEMENTA METODOS DE MANIPULACION
	
	@Query("from Region")//desde la entidad, ponemos @Query porque no vamos a hacer un crud completo, solo consultar
	public List<Region>findAllRegions();
	

	@Query("from Specie")//desde la entidad, ponemos @Query porque no vamos a hacer un crud completo, solo consultar
	public List<Specie>findAllSpecies();
	
	@Query("from Sex")//desde la entidad, ponemos @Query porque no vamos a hacer un crud completo, solo consultar
	public List<Sex>findAllSexs();
	
	@Query("from Volunteer")//desde la entidad, ponemos @Query porque no vamos a hacer un crud completo, solo consultar
	public List<Volunteer>findAllVolunteers();



}
