package com.example.animal.shelter.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.animal.shelter.models.dao.AnimalDao;
import com.example.animal.shelter.models.entity.Animal;
import com.example.animal.shelter.models.entity.Region;
import com.example.animal.shelter.models.entity.Sex;
import com.example.animal.shelter.models.entity.Specie;
import com.example.animal.shelter.models.entity.Volunteer;



@Service
public class AnimalServiceImpl implements AnimalService{
	
	@Autowired
	private AnimalDao animalDao;
	

	@Override
	@Transactional(readOnly = true)
	public List<Animal> findAll() {
		
		return (List<Animal>) animalDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Animal findById(Long id) {
		return animalDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Animal save(Animal animal) {
		return animalDao.save(animal);
		
	}
	
	@Override
	@Transactional//esta anotacion es requerida
	public void delete(Long id) {
		animalDao.deleteById(id);
		System.out.println("Este metodo eliminará un animal por id");
	}

	@Override
	@Transactional(readOnly=true)//si es de tipo get readOnly
	public List<Region> findAllRegions() {
		
		return animalDao.findAllRegions();
	}
	
	@Override
	@Transactional(readOnly=true)//si es de tipo get readOnly
	public List<Specie> findAllSpecies() {
		
		return animalDao.findAllSpecies();
	}
	
	@Override
	@Transactional(readOnly=true)//si es de tipo get readOnly
	public List<Sex> findAllSexs() {
		
		return animalDao.findAllSexs();
	}
	
	@Override
	@Transactional//si es de tipo get readOnly
	public List<Volunteer> findAllVolunteers() {
		
		return animalDao.findAllVolunteers();
	}


}
