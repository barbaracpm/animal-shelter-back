package com.example.animal.shelter.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.animal.shelter.models.entity.UserEnt;


public interface IUserDao extends CrudRepository<UserEnt, Long>{
	
	public UserEnt findByUsername(String username); 
	
	//el 1 se refiere al primer parámetro (string username)
	@Query("select u from UserEnt u where u.username=?1")
	public UserEnt findByUsername2(String username);

}
