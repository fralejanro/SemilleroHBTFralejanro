/**
 * ComicDTO.java
 */
package com.hbt.semillero.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.hbt.semillero.entidades.EstadoENUM;
import com.hbt.semillero.entidades.TematicaENUM;

/**
 * <b>Descripción:<b> Clase que determina como almacenar y entegar los datos del
 * Comic 
 * <b>Caso de Uso:<b> 
 * @author Francisco Alejandro Hoyos Rojas
 * @version 1.0
 */
public class ComicDTO implements Serializable {

	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = -5495724378797813755L;

	/**
	 * Atributo que define el identificador unico del comic
	 */
	private String id;
	/**
	 * Atributo que determina el Nombre o titulo del comic o revista grafica
	 */
	private String nombre;
	/**
	 * Atributo que determina la Empresa editorial quien publico el comic
	 */
	private String editorial;
	/**
	 * Atributo que permite identificar si el comic es de tipo AVENTURAS, BELICO,
	 * HUMORISTICO, DEPORTIVO, FANTASTICO, CIENCIA_FICCION, HISTORICO, HORROR'
	 */
	private TematicaENUM tematicaEnum;
	/**
	 * Atributo que determina el conjunto de publicaciones de la que el comic es
	 * parte
	 */
	private String coleccion;
	/**
	 * Atributo que determina la cantidad de las paginas que contiene el comic
	 */
	private Integer numeroPaginas;
	/**
	 * Atributo que determina el valor en pesos del comic
	 */
	private BigDecimal precio;
	/**
	 * Atributo que determina el Autor u autores del comic
	 */
	private String autores;
	/**
	 * Atributo que define si el comic es a color o no, campo de tipo booleano solo
	 * acepta 1 o 0
	 */
	private Boolean color;
	/**
	 * Atributo que determina la fecha de inicio de la venta del comic
	 */
	private LocalDate fechaVenta;
	/**
	 * Atributo que define si el comic tiene existencia para la venta o no
	 */
	private EstadoENUM estadoEnum;
	/**
	 * Atributo que determina la cantidad de comics en inventario disponibles para
	 * la venta
	 */
	private Long cantidad;

	/**
	 * Constructor de la clase.
	 * @param id
	 * @param nombre
	 */
	public ComicDTO(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}



	/**
	 * Constructor de la clase.
	 * @param id
	 * @param nombre
	 * @param editorial
	 * @param tematica
	 * @param coleccion
	 * @param numeroPaginas
	 * @param precio
	 * @param autores
	 * @param color
	 * @param fechaVenta
	 * @param estado
	 * @param cantidad
	 */
	public ComicDTO(String id, String nombre, String editorial, TematicaENUM tematicaEnum, String coleccion,
			Integer numeroPaginas, BigDecimal precio, String autores, Boolean color, LocalDate fechaVenta,
			EstadoENUM estadoEnum, Long cantidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.editorial = editorial;
		this.tematicaEnum = tematicaEnum;
		this.coleccion = coleccion;
		this.numeroPaginas = numeroPaginas;
		this.precio = precio;
		this.autores = autores;
		this.color = color;
		this.fechaVenta = fechaVenta;
		this.estadoEnum = estadoEnum;
		this.cantidad = cantidad;
	}



	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	public String getId() {
		return id;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * @param id El nuevo id a modificar.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * @return El nombre asociado a la clase
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo nombre
	 * @param nombre El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo editorial
	 * @return El editorial asociado a la clase
	 */
	public String getEditorial() {
		return editorial;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo editorial
	 * @param editorial El nuevo editorial a modificar.
	 */
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo tematica
	 * @return El tematica asociado a la clase
	 */
	public TematicaENUM getTematicaENUM() {
		return tematicaEnum;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo tematica
	 * @param tematica El nuevo tematica a modificar.
	 */
	public void setTematicaENUM(TematicaENUM tematicaEnum) {
		this.tematicaEnum = tematicaEnum;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo coleccion
	 * @return El coleccion asociado a la clase
	 */
	public String getColeccion() {
		return coleccion;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo coleccion
	 * @param coleccion El nuevo coleccion a modificar.
	 */
	public void setColeccion(String coleccion) {
		this.coleccion = coleccion;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo numeroPaginas
	 * @return El numeroPaginas asociado a la clase
	 */
	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo numeroPaginas
	 * @param numeroPaginas El nuevo numeroPaginas a modificar.
	 */
	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo precio
	 * @return El precio asociado a la clase
	 */
	public BigDecimal getPrecio() {
		return precio;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo precio
	 * @param precio El nuevo precio a modificar.
	 */
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo autores
	 * @return El autores asociado a la clase
	 */
	public String getAutores() {
		return autores;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo autores
	 * @param autores El nuevo autores a modificar.
	 */
	public void setAutores(String autores) {
		this.autores = autores;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo color
	 * @return El color asociado a la clase
	 */
	public Boolean getColor() {
		return color;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo color
	 * @param color El nuevo color a modificar.
	 */
	public void setColor(Boolean color) {
		this.color = color;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo fechaVenta
	 * @return El fechaVenta asociado a la clase
	 */
	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo fechaVenta
	 * @param fechaVenta El nuevo fechaVenta a modificar.
	 */
	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo estado
	 * @return El estado asociado a la clase
	 */
	public EstadoENUM getEstadoEnum() {
		return estadoEnum;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo estado
	 * @param estado El nuevo estado a modificar.
	 */
	public void setEstadoEnum(EstadoENUM estadoEnum) {
		this.estadoEnum = estadoEnum;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo cantidad
	 * @return El cantidad asociado a la clase
	 */
	public Long getCantidad() {
		return cantidad;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo cantidad
	 * @param cantidad El nuevo cantidad a modificar.
	 */
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
