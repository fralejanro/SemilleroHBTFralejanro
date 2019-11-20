package com.hbt.semillero.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * <b>Descripción:<b> Clase que representa la entidad Persona
 * <b>Caso de Uso:<b> 
 * @author Francisco Alejandro Hoyos Rojas
 * @version
 */
 
@Entity
@NamedQueries({
	@NamedQuery(name = Persona.CONSULTAR_PERSONA_POR_NOMBRE, query = "select p from Persona p where UPPER(p.nombre)=:nombrePersona")
})
@Table(name = "TC_PERSONA")
public class Persona implements Serializable {

	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = -8125585681165136154L;
	
	/**
	 * Constante que identifica la consulta que permite buscar un comic por nombre
	 */
	public static final String CONSULTAR_PERSONA_POR_NOMBRE = "consultarPersonaPorNombre";
	
	/**
	 * Atributo que define el id unico de una persona
	 */
	private Long id;
	
	/**
	 * Atributo que define el nombre completo de una persona
	 */
	private String nombre;
	
	/*
	 * Atributo que define el número de cédula de una persona
	 */
	private Long numeroIdentificacion;


	/**
	 * Atributo que representa relación de uno a muchos entre la tabla Persona y
	 * Proveedor
	 */
	private List<Proveedor> proveedores;
	
	/**
	 * 
	 * Constructor de la clase.
	 */
	public Persona() {
		super();
	}


	/**
	 * 
	 * Metodo encargado de retornar el valor del atributo id
	 * <b>Caso de Uso</b>
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @return El id asociado a la clase
	 */
	@Id
	@Column(name = "SPID")
	@SequenceGenerator(allocationSize = 1, name = "PERSONA_SPID_GENERATOR", sequenceName = "SEQ_PERSONA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSONA_SPID_GENERATOR")
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * Método encargado de modificar el valor del atributo id
	 * <b>Caso de Uso</b>
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param id  El nuevo id a modificar.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 
	 * Metodo encargado de retornar el valor del atributo nombre
	 * <b>Caso de Uso</b>
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @return El nombre asociado a la clase
	 */
	@Column(name = "SCNOMBRE")
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * Método encargado de modificar el valor del atributo nombre
	 * <b>Caso de Uso</b>
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param nombre  El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * Metodo encargado de retornar el valor del atributo numeroIdentificacion
	 * <b>Caso de Uso</b>
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @return El numeroIdentificacion asociado a la clase
	 */
	@Column(name = "SCNUMEROIDENTIFICACION")
	public Long getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	/**
	 * 
	 * Método encargado de modificar el valor del atributo numeroIdentificacion
	 * <b>Caso de Uso</b>
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param numeroIdentificacion  El nuevo número de identifcación a modificar.
	 */
	public void setNumeroIdentificacion(Long numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	/**
	 * 
	 * Metodo encargado de retornar el valor del atributo proveedores
	 * <b>Caso de Uso</b>
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @return Lista de proveedores asociado a la clase
	 */
	@OneToMany(mappedBy="persona")
	
	public List<Proveedor> getProveedores() {
		return proveedores;
	}


	/**
	 * 
	 * Método encargado de modificar el valor del atributo proveedores
	 * <b>Caso de Uso</b>
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param proveedores  Nueva lista de proveedores a modificar.
	 */
	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}


	/**
	 * Método encargado de retornar el Hash Code de una Persona
	 * @return Hash Code de una Persona
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numeroIdentificacion == null) ? 0 : numeroIdentificacion.hashCode());
		result = prime * result + ((proveedores == null) ? 0 : proveedores.hashCode());
		return result;
	}


	/**
	 * 
	 * Método encargado de comparar si una Persona es igual a otra
	 * @return True si las personas son iguales, de lo contrario False
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numeroIdentificacion == null) {
			if (other.numeroIdentificacion != null)
				return false;
		} else if (!numeroIdentificacion.equals(other.numeroIdentificacion))
			return false;
		if (proveedores == null) {
			if (other.proveedores != null)
				return false;
		} else if (!proveedores.equals(other.proveedores))
			return false;
		return true;
	}
	

	
}
