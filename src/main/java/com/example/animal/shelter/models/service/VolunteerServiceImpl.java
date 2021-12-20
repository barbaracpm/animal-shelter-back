package com.example.animal.shelter.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.animal.shelter.models.dao.VolunteerDao;
import com.example.animal.shelter.models.entity.Volunteer;

@Service
public class VolunteerServiceImpl implements VolunteerService{
	
	@Autowired
	private VolunteerDao volunteerDao;
	

	@Override
	@Transactional(readOnly = true)
	public List<Volunteer> findAll() {
		
		return (List<Volunteer>) volunteerDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Volunteer findById(Long id) {
		return volunteerDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Volunteer save(Volunteer volunteer) {
		return volunteerDao.save(volunteer);
		
	}
	
	@Override
	@Transactional//esta anotacion es requerida
	public void delete(Long id) {
		volunteerDao.deleteById(id);
		System.out.println("Este metodo eliminará un voluntario por id");
	}

	
	
	
	//@Override
	//@Transactional(readOnly=true)//si es de tipo get readOnly
	//public List<Animal> findAllAnimals() {
		
		//return volunteerDao.findAllAnimals();
	
	


}