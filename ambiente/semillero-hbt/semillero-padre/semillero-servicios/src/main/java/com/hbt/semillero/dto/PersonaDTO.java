package com.hbt.semillero.dto;

import java.io.Serializable;


/**
 * <b>Descripción:<b> Clase que determina como almacenar y entegar los datos de una Persona
 * <b>Caso de Uso:<b> 
 * @author Francisco Alejandro Hoyos Rojas
 * @version 1.0
 */
public class PersonaDTO implements Serializable{

	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = -4742014270524193118L;

	/**
	 * Atributo que define el id unico de una persona
	 */
	private String id;
	
	/**
	 * Atributo que define el nombre completo de una persona
	 */
	private String nombre;
	
	/*
	 * Atributo que define el número de cédula de una persona
	 */
	private String numeroIdentificacion;

	
	
	/**
	 * 
	 * Constructor de la clase.
	 */
	public PersonaDTO() {
		super();
	}

	/**
	 * 
	 * Constructor de la clase.
	 * @param id id unico de una persona
	 * @param nombre nombre completo de una persona
	 * @param numeroIdentificacion número de cédula de una persona
	 */
	public PersonaDTO(String id, String nombre, String numeroIdentificacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.numeroIdentificacion = numeroIdentificacion;
	}

	/**
	 * Método encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	public String getId() {
		return id;
	}

	/**
	 * Método encargado de modificar el valor del atributo id
	 * @param id El nuevo id a modificar.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Método encargado de retornar el valor del atributo nombre
	 * @return El nombre asociado a la clase
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método encargado de modificar el valor del atributo nombre
	 * @param nombre El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método encargado de retornar el valor del atributo numeroIdentificacion
	 * @return El numeroIdentificacion asociado a la clase
	 */
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	/**
	 * Método encargado de modificar el valor del atributo numeroIdentificacion
	 * @param numeroIdentificacion El nuevo numeroIdentificacion a modificar.
	 */
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	
	
}
