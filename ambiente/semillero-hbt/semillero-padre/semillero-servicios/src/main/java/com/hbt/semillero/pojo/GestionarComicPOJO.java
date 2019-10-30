/**
 * GestionarComicPOJO.java
 */
package com.hbt.semillero.pojo;

import java.util.List;

import com.hbt.semillero.dto.ComicDTO;

/**
 * <b>Descripción:<b> 
 * <b>Caso de Uso:<b>
 * 
 * @author Francisco Alejandro Hoyos Rojas
 * @version 1.0
 */
public class GestionarComicPOJO {

	private List<ComicDTO> listaComics = null;

	// TODO
	public void crearComicDTO() {
		//ComicDTO comicDTO = new ComicDTO();
	}

	/**
	 * Metodo encargado de retornar el valor del atributo listaComics
	 * 
	 * @return El listaComics asociado a la clase
	 */
	public List<ComicDTO> getListaComics() {
		return listaComics;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaComics
	 * 
	 * @param listaComics El nuevo listaComics a modificar.
	 */
	public void setListaComics(List<ComicDTO> listaComics) {
		this.listaComics = listaComics;
	}

}
