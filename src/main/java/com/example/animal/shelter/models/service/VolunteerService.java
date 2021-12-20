package com.example.animal.shelter.models.service;

import java.util.List;

import com.example.animal.shelter.models.entity.Volunteer;

public interface VolunteerService {
	
	public List<Volunteer> findAll();
	public Volunteer findById(Long id);
	public Volunteer save(Volunteer volunteer);
	public void delete(Long id);
	

	//public List<Animal>findAllAnimals();


}
