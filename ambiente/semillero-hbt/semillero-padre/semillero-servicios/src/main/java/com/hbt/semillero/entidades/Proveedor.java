package com.hbt.semillero.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * <b>Descripción:<b> Clase que representa la entidad Proveedor
 * <b>Caso de Uso:<b> 
 * @author fralejanro
 * @version
 */
@Entity
@NamedQueries({
	@NamedQuery(name = Proveedor.CONSULTAR_PROVEEDOR_POR_DIRECCION, query = "select p from Proveedor p where UPPER(p.direccion)=:direccionProveedor"),
	@NamedQuery(name = Proveedor.CONSULTAR_TODOS_LOS_PROVEEDORES, query = "select p from Proveedor p")
	
})
@Table(name = "TC_PROVEEDOR")
public class Proveedor implements Serializable {

	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = -1413806453357862589L;
	
	/**
	 * Constante que identifica la consulta que permite buscar un proveedor por direccion
	 */
	public static final String CONSULTAR_PROVEEDOR_POR_DIRECCION = "consultarProveedorPorDireccion";
	
	/**
	 * Constante que identifica la consulta que permite buscar un proveedor por direccion
	 */
	public static final String CONSULTAR_TODOS_LOS_PROVEEDORES = "consultarTodosLosProveedores";

	/**
	 * Atributo que define el id unico del proveedor
	 */
	private Long id;
	
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
	private EstadoENUM estado;
	
	/**
	 * Atributo que representa la relación de muchos a uno entre la tabla Proveedor y
	 * Persona
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
	public Proveedor() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * Metodo encargado de retornar el valor del atributo id
	 * <b>Caso de Uso</b>
	 * @author fralejanro
	 * 
	 * @return El id asociado a la clase
	 */
	@Id
	@Column(name = "SPID")
	@SequenceGenerator(allocationSize = 1, name = "PROVEEDOR_SPID_GENERATOR", sequenceName = "SEQ_PROVEEDOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROVEEDOR_SPID_GENERATOR")
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
	 * Metodo encargado de retornar el valor del atributo direccion
	 * <b>Caso de Uso</b>
	 * @author fralejanro
	 * 
	 * @return La direccion asociada a la clase
	 */
	@Column(name = "SPDIRECCION")
	public String getDireccion() {
		return direccion;
	}

	/**
	 * 
	 * Método encargado de modificar el valor del atributo direccion
	 * <b>Caso de Uso</b>
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param direccion  La nueva direccion a modificar.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * 
	 * Metodo encargado de retornar el valor del atributo fechaCreacion
	 * <b>Caso de Uso</b>
	 * @author fralejanro
	 * 
	 * @return La fechaCreacion asociada a la clase
	 */
	@Column(name = "SPFECHA_CREACION")
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * 
	 * Método encargado de modificar el valor del atributo fechaCreacion
	 * <b>Caso de Uso</b>
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param fechaCreacion nueva fecha de creacion a modificar.
	 */
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * 
	 * Metodo encargado de retornar el valor del atributo estado
	 * <b>Caso de Uso</b>
	 * @author fralejanro
	 * 
	 * @return El estado asociado a la clase
	 */
	@Column(name = "SPESTADO")
	@Enumerated(value = EnumType.STRING)
	public EstadoENUM getEstado() {
		return estado;
	}

	/**
	 * 
	 * Método encargado de modificar el valor del atributo estado
	 * <b>Caso de Uso</b>
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param estado  El nuevo estado a modificar.
	 */
	public void setEstado(EstadoENUM estado) {
		this.estado = estado;
	}

	/**
	 * 
	 * Metodo encargado de retornar el valor del atributo persona
	 * <b>Caso de Uso</b>
	 * @author fralejanro
	 * 
	 * @return La persona asociada a la clase
	 */
	@ManyToOne
	public Persona getPersona() {
		return persona;
	}

	/**
	 * 
	 * Método encargado de modificar el valor del atributo persona
	 * <b>Caso de Uso</b>
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param persona La nueva persona a modificar.
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	

	/**
	 * 
	 * Metodo encargado de retornar el valor del atributo montoCredito
	 * <b>Caso de Uso</b>
	 * @author fralejanro
	 * 
	 * @return El montoCredito asociada a la clase
	 */
	@Column(name = "SPMONTO_CREDITO")
	public BigDecimal getMontoCredito() {
		return montoCredito;
	}

	/**
	 * 
	 * Método encargado de modificar el valor del atributo montoCredito
	 * <b>Caso de Uso</b>
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param montoCredito  El nuevo montoCredito a modificar.
	 */
	public void setMontoCredito(BigDecimal montoCredito) {
		this.montoCredito = montoCredito;
	}

	
	/**
	 * Método encargado de retornar el Hash Code de un Proveedor
	 * @return Hash Code de una Proveedor
	 */
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((montoCredito == null) ? 0 : montoCredito.hashCode());
		result = prime * result + ((persona == null) ? 0 : persona.hashCode());
		return result;
	}


	/**
	 * 
	 * Método encargado de comparar si un Proveedor es igual a otro
	 * @return True si los proveedores son iguales, de lo contrario False
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proveedor other = (Proveedor) obj;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (estado != other.estado)
			return false;
		if (fechaCreacion == null) {
			if (other.fechaCreacion != null)
				return false;
		} else if (!fechaCreacion.equals(other.fechaCreacion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (montoCredito == null) {
			if (other.montoCredito != null)
				return false;
		} else if (!montoCredito.equals(other.montoCredito))
			return false;
		if (persona == null) {
			if (other.persona != null)
				return false;
		} else if (!persona.equals(other.persona))
			return false;
		return true;
	}

	
	
	
}
