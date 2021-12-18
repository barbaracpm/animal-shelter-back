package com.example.animal.shelter.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "species")
public class Specie implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//le da las propiedades de id en bbdd pk, autoincrements etc
	private Long id;
	
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
