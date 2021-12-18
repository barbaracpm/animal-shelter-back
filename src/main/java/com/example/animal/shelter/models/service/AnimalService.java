package com.example.animal.shelter.models.service;

import java.util.List;

import com.example.animal.shelter.models.entity.Animal;
import com.example.animal.shelter.models.entity.Region;
import com.example.animal.shelter.models.entity.Specie;



public interface AnimalService {
	
	public List<Animal> findAll();
	public Animal findById(Long id);
	public Animal save(Animal animal);
	public void delete(Long id);
	
	public List<Region>findAllRegions();
	public List<Specie>findAllSpecies();

}
