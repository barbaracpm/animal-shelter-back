package com.example.animal.shelter.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity//representa una tabla en una base de datos
@Table(name = "animals")
public class Animal implements Serializable{
	
	@Id //PARA QUE LA BD LO RECONOZCA COMO IDENTIFICADOR ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) //PARA GENERAR EL AUTOINCREMENT
	private long id;
	
	@Column(nullable = false) // es obligatorio
	private String name;
	
	//many donde estamos, la palabra de la izquierda hace referencia donde estamos
	@NotNull(message="no puede estar vacío")
	@ManyToOne(fetch=FetchType.LAZY)//hace una subconsulta atraves de un metodo, carga perezosa
	@JoinColumn(name="specie_id")//para relacionar es indispensable
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})// ponemos porque tenemos una carga perezosa
	private Specie specie;
	
	@Column(name = "birth_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	private String picture;
	
	private String sex;
	
	private String color;
	
	private Number weight;
	
	private String description;
	
	@NotNull(message="no puede estar vacío")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="region_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Region region;
	
	
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


	public Specie getSpecie() {
		return specie;
	}


	public void setSpecie(Specie specie) {
		this.specie = specie;
	}


	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public Number getWeight() {
		return weight;
	}


	public void setWeight(Number weight) {
		this.weight = weight;
	}


	public Region getRegion() {
		return region;
	}


	public void setRegion(Region region) {
		this.region = region;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;//PARA MARCAR EL MODELO EN EL CUAL SE IMPLEMENTA
}
	
	