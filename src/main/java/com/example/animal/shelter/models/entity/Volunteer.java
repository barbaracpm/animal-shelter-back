package com.example.animal.shelter.models.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity//representa una tabla en una base de datos
@Table(name = "volunteers")
public class Volunteer implements Serializable{
	
	@Id //PARA QUE LA BD LO RECONOZCA COMO IDENTIFICADOR ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) //PARA GENERAR EL AUTOINCREMENT
	private long id;
	
	@Column(nullable = false) // es obligatorio
	private String name;
	private String surname;
	
	@Column(nullable = false, unique = true) // es obligatorio y único
	private String email;
	private int phone;
	
	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSurname() {
		return surname;
	}



	public void setSurname(String surname) {
		this.surname = surname;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}


	public int getPhone() {
		return phone;
	}



	public void setPhone(int phone) {
		this.phone = phone;
	}









	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;//PARA MARCAR EL MODELO EN EL CUAL SE IMPLEMENTA
	
	
	
	

}
