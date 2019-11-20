package com.hbt.semillero.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.hbt.semillero.entidades.Persona;

/**
 * <b>Descripción:<b> Clase que determina como almacenar y entegar los datos de un Proveedor
 * <b>Caso de Uso:<b> 
 * @author Francisco Alejandro Hoyos Rojas
 * @version 1.0
 */
public class ProveedorDTO implements Serializable{

	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = 5421733469758671175L;
	
	/**
	 * Atributo que define el id unico del proveedor
	 */
	private String id;
	
	/**
	 * Atributo que define la dirección fisica del proveedor
	 */
	private String direccion;
	
	/**
	 * Atributo que define la fecha de contratación del proveedor
	 */
	private LocalDate fechaCreacion;
	
	/**
	 * Atributo que define si un proveedor esta activo o inactivo
	 */
	private String estado;
	
	/**
	 * Atributo que define la persona que representa legalmente al proveedor
 	 */
	private Persona persona;
	
	/**
	 * Atributo que define el monto del credito
	 */
	private BigDecimal montoCredito;


	/**
	 * 
	 * Constructor de la clase.
	 */
	public ProveedorDTO() {
		super();	
	}

	/**
	 * 
	 * Constructor de la clase.
	 * @param id id unico del proveedor
	 * @param direccion dirección fisica del proveedor
	 * @param fechaCreacion fecha de contratación del proveedor
	 * @param estado define si un proveedor esta activo o inactivo
	 * @param persona define la persona que representa legalmente al proveedor
	 */
	public ProveedorDTO(String id, String direccion, LocalDate fechaCreacion, String estado, Persona persona, BigDecimal montoCredito) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.persona = persona;
		this.montoCredito = montoCredito;
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
	 * Método encargado de retornar el valor del atributo direccion
	 * @return La direccion asociada a la clase
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Método encargado de modificar el valor del atributo direccion
	 * @param direccion La nueva direccion a modificar.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	/**
	 * Método encargado de retornar el valor del atributo fechaCreacion
	 * @return La fechaCreacion asociada a la clase
	 */
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Método encargado de modificar el valor del atributo fechaCreacion
	 * @param fechaCreacion La nueva fechaCreacion a modificar.
	 */
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	/**
	 * Método encargado de retornar el valor del atributo estado
	 * @return El estado asociado a la clase
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Método encargado de modificar el valor del atributo estado
	 * @param estado El nuevo estado a modificar.
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}


	/**
	 * Método encargado de retornar el valor del atributo persona
	 * @return La persona asociada a la clase
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * Método encargado de modificar el valor del atributo persona
	 * @param persona La nueva persona a modificar.
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	/**
	 * Método encargado de retornar el valor del atributo montoCredito
	 * @return El montoCredito asociado a la clase
	 */
	public BigDecimal getMontoCredito() {
		return montoCredito;
	}

	/**
	 * Método encargado de modificar el valor del atributo montoCredito
	 * @param montoCredito El nuevo montoCredito a modificar.
	 */
	public void setMontoCredito(BigDecimal montoCredito) {
		this.montoCredito = montoCredito;
	}
	
	
	
	
	
	
	

}
