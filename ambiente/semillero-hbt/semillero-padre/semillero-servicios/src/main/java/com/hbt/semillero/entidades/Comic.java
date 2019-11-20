/**
 * Comic.java
 */
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <b>Descripción:<b> Clase que representa la entidad Comic <b>Caso de Uso:<b>
 *
 * @author Francisco Alejandro Hoyos Rojas
 * @version 1.0
 */
@Entity
@NamedQueries({
	@NamedQuery(name = Comic.CONSULTAR_COMIC_POR_NOMBRE, query = "select c from Comic c where UPPER(c.nombre)=:nombreComic")
})
@Table(name = "COMIC")
public class Comic implements Serializable {

	/**
	 * Atributo que determina el número de serialización
	 */
	private static final long serialVersionUID = 4322034079745146450L;
	
	/**
	 * Constante que identifica la consulta que permite buscar un comic por nombre
	 */
	public static final String CONSULTAR_COMIC_POR_NOMBRE = "consultarComicPorNombre";
	/**
	 * Atributo que define el identificador unico del comic
	 */
	private Long id;
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
	 */
	public Comic() {

	}

	/**
	 * Constructor de la clase.
	 * 
	 * @param id            Identificador unico del comic
	 * @param nombre        Nombre o titulo del comic o revista grafica
	 * @param editorial     Empresa editorial quien publico el comic
	 * @param tematicaEnum  Tipo de comic
	 * @param coleccion     Conjunto de publicaciones de la que el comic es parte
	 * @param numeroPaginas Cantidad de las paginas que contiene el comic
	 * @param precio        Valor en pesos del comic
	 * @param autores       Autor u autores del comic
	 * @param color         Define si el comic es a color o no
	 * @param fechaVenta    Fecha de inicio de la venta del comic
	 * @param estadoEnum    Define si el comic tiene existencia para la venta o no
	 * @param cantidad      Cantidad de comics en inventario disponibles para la
	 *                      venta
	 */
	public Comic(Long id, String nombre, String editorial, TematicaENUM tematicaEnum, String coleccion,
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
	 * Método encargado de retornar el valor del atributo id
	 * 
	 * @return El id asociado a la clase
	 */
	@Id
	@Column(name = "SCID")
	@SequenceGenerator(allocationSize = 1, name = "COMIC_SCID_GENERATOR", sequenceName = "SEQ_COMIC")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMIC_SCID_GENERATOR")
	public Long getId() {
		return id;
	}

	/**
	 * Método encargado de modificar el valor del atributo id
	 * 
	 * @param id El nuevo id a modificar.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Método encargado de retornar el valor del atributo nombre
	 * 
	 * @return El nombre asociado a la clase
	 */
	@Column(name = "SCNOMBRE")
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método encargado de modificar el valor del atributo nombre
	 * 
	 * @param nombre El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método encargado de retornar el valor del atributo editorial
	 * 
	 * @return El editorial asociado a la clase
	 */
	@Column(name = "SCEDITORIAL")
	public String getEditorial() {
		return editorial;
	}

	/**
	 * Método encargado de modificar el valor del atributo editorial
	 * 
	 * @param editorial El nuevo editorial a modificar.
	 */
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	/**
	 * Método encargado de retornar el valor del atributo tematicaEnum
	 * 
	 * @return El tematicaEnum asociado a la clase
	 */
	@Column(name = "SCTEMATICA")
	@Enumerated(value = EnumType.STRING)
	public TematicaENUM getTematicaEnum() {
		return tematicaEnum;
	}

	/**
	 * Método encargado de modificar el valor del atributo tematicaEnum
	 * 
	 * @param tematicaEnum El nuevo tematicaEnum a modificar.
	 */
	public void setTematicaEnum(TematicaENUM tematicaEnum) {
		this.tematicaEnum = tematicaEnum;
	}

	/**
	 * Método encargado de retornar el valor del atributo coleccion
	 * 
	 * @return El coleccion asociado a la clase
	 */
	@Column(name = "SCCOLECCION")
	public String getColeccion() {
		return coleccion;
	}

	/**
	 * Método encargado de modificar el valor del atributo coleccion
	 * 
	 * @param coleccion El nuevo coleccion a modificar.
	 */
	public void setColeccion(String coleccion) {
		this.coleccion = coleccion;
	}

	/**
	 * Método encargado de retornar el valor del atributo numeroPaginas
	 * 
	 * @return El numeroPaginas asociado a la clase
	 */
	@Column(name = "SCNUMEROPAGINAS")
	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	/**
	 * Método encargado de modificar el valor del atributo numeroPaginas
	 * 
	 * @param numeroPaginas El nuevo numeroPaginas a modificar.
	 */
	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	/**
	 * Método encargado de retornar el valor del atributo precio
	 * 
	 * @return El precio asociado a la clase
	 */
	@Column(name = "SCPRECIO")
	public BigDecimal getPrecio() {
		return precio;
	}

	/**
	 * Método encargado de modificar el valor del atributo precio
	 * 
	 * @param precio El nuevo precio a modificar.
	 */
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	/**
	 * Método encargado de retornar el valor del atributo autores
	 * 
	 * @return El autores asociado a la clase
	 */
	@Column(name = "SCAUTORES")
	public String getAutores() {
		return autores;
	}

	/**
	 * Método encargado de modificar el valor del atributo autores
	 * 
	 * @param autores El nuevo autores a modificar.
	 */
	public void setAutores(String autores) {
		this.autores = autores;
	}

	/**
	 * Método encargado de retornar el valor del atributo color
	 * 
	 * @return El color asociado a la clase
	 */
	@Column(name = "SCCOLOR")
	public Boolean getColor() {
		return color;
	}

	/**
	 * Método encargado de modificar el valor del atributo color
	 * 
	 * @param color El nuevo color a modificar.
	 */
	public void setColor(Boolean color) {
		this.color = color;
	}

	/**
	 * Método encargado de retornar el valor del atributo fechaVenta
	 * 
	 * @return El fechaVenta asociado a la clase
	 */
	@Column(name = "SCFECHA_VENTA")
	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	/**
	 * Método encargado de modificar el valor del atributo fechaVenta
	 * 
	 * @param fechaVenta El nuevo fechaVenta a modificar.
	 */
	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	/**
	 * Método encargado de retornar el valor del atributo estadoEnum
	 * 
	 * @return El estadoEnum asociado a la clase
	 */
	@Column(name = "SCESTADO")
	@Enumerated(value = EnumType.STRING)
	public EstadoENUM getEstadoEnum() {
		return estadoEnum;
	}

	/**
	 * Método encargado de modificar el valor del atributo estadoEnum
	 * 
	 * @param estadoEnum El nuevo estadoEnum a modificar.
	 */
	public void setEstadoEnum(EstadoENUM estadoEnum) {
		this.estadoEnum = estadoEnum;
	}

	/**
	 * Método encargado de retornar el valor del atributo cantidad
	 * 
	 * @return El cantidad asociado a la clase
	 */
	@Column(name = "SCCANTIDAD")
	public Long getCantidad() {
		return cantidad;
	}

	/**
	 * Método encargado de modificar el valor del atributo cantidad
	 * 
	 * @param cantidad El nuevo cantidad a modificar.
	 */
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Método encargado de mostrar la información de un Comic
	 * @return Información de un Comic
	 */
	@Override
	public String toString() {
		return "Comic [id=" + id + ", nombre=" + nombre + " ]";
		/*
		 * return "Comic [id=" + id + ", nombre=" + nombre + ", editorial=" + editorial
		 * + ", tematicaEnum=" + tematicaEnum + ", coleccion=" + coleccion +
		 * ", numeroPaginas=" + numeroPaginas + ", precio=" + precio + ", autores=" +
		 * autores + ", color=" + color + ", fechaVenta=" + fechaVenta + ", estadoEnum="
		 * + estadoEnum + ", cantidad=" + cantidad + "]";
		 */
	}

	/**
	 * Método encargado de retornar el Hash Code de un Comic
	 * @return Hash Code de un Comic
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autores == null) ? 0 : autores.hashCode());
		result = prime * result + ((cantidad == null) ? 0 : cantidad.hashCode());
		result = prime * result + ((coleccion == null) ? 0 : coleccion.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((editorial == null) ? 0 : editorial.hashCode());
		result = prime * result + ((estadoEnum == null) ? 0 : estadoEnum.hashCode());
		result = prime * result + ((fechaVenta == null) ? 0 : fechaVenta.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numeroPaginas == null) ? 0 : numeroPaginas.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		result = prime * result + ((tematicaEnum == null) ? 0 : tematicaEnum.hashCode());
		return result;
	}

	/**
	 * 
	 * Método encargado de comparar si un Comic es igual a otro
	 * @return True si los comics son iguales, de lo contrario False
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comic other = (Comic) obj;
		if (autores == null) {
			if (other.autores != null)
				return false;
		} else if (!autores.equals(other.autores))
			return false;
		if (cantidad == null) {
			if (other.cantidad != null)
				return false;
		} else if (!cantidad.equals(other.cantidad))
			return false;
		if (coleccion == null) {
			if (other.coleccion != null)
				return false;
		} else if (!coleccion.equals(other.coleccion))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (editorial == null) {
			if (other.editorial != null)
				return false;
		} else if (!editorial.equals(other.editorial))
			return false;
		if (estadoEnum == null) {
			if (other.estadoEnum != null)
				return false;
		} else if (!estadoEnum.equals(other.estadoEnum))
			return false;
		if (fechaVenta == null) {
			if (other.fechaVenta != null)
				return false;
		} else if (!fechaVenta.equals(other.fechaVenta))
			return false;
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
		if (numeroPaginas == null) {
			if (other.numeroPaginas != null)
				return false;
		} else if (!numeroPaginas.equals(other.numeroPaginas))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		if (tematicaEnum == null) {
			if (other.tematicaEnum != null)
				return false;
		} else if (!tematicaEnum.equals(other.tematicaEnum))
			return false;
		return true;
	}

}
