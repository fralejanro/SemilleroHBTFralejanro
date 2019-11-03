/**
 * EstadoENUM.java
 */
package com.hbt.semillero.entidades;

/**
 * <b>Descripción:<b> Clase que define si los estados de un comic puede ser activo o inactivo
 * <b>Caso de Uso:<b> 
 * @author Francisco Alejandro Hoyos Rojas
 * @version 1.0
 */
public enum EstadoENUM {
	ACTIVO("enum.estado.activo"),
	INACTIVO("enum.estado.activo");
	
	/**
	 * Atributo que define el mensaje a ser mostrado por los estados
	 */
	private String codigoMensaje;

	/**
	 * Constructor de la clase.
	 * @param codigoMensaje mensaje a ser mostrado por un estado
	 */
	private EstadoENUM(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo codigoMensaje
	 * @return El codigoMensaje asociado a la clase
	 */
	public String getCodigoMensaje() {
		return codigoMensaje;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo codigoMensaje
	 * @param codigoMensaje El nuevo codigoMensaje a modificar.
	 */
	public void setCodigoMensaje(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}
	
	
}
