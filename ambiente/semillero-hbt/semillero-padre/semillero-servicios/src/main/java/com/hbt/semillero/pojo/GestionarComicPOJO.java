/**
 * GestionarComicPOJO.java
 */
package com.hbt.semillero.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.EstadoENUM;
import com.hbt.semillero.entidades.TematicaENUM;

/**
 * <b>Descripción:<b> <b>Caso de Uso:<b>
 * 
 * @author Francisco Alejandro Hoyos Rojas
 * @version 1.0
 */
public class GestionarComicPOJO {

	/**
	 * Atributo que determina la lista de comics
	 */
	private List<ComicDTO> listaComics = null;

	/**
	 * 
	 * Método encargado de crear un Comic <b>Caso de Uso</b>
	 * 
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @return Un nuevo Comic
	 * 
	 */
	public ComicDTO crearComicDTO(String id, String nombre, String editorial, TematicaENUM tematicaEnum,
			String coleccion, Integer numeroPaginas, BigDecimal precio, String autores, Boolean color,
			LocalDate fechaVenta, EstadoENUM estadoEnum, Long cantidad) {

		return new ComicDTO(id, nombre, editorial, tematicaEnum, coleccion, numeroPaginas, precio, autores, color,
				fechaVenta, estadoEnum, cantidad);
	}

	/**
	 * 
	 * Método encargado de crear un Comic <b>Caso de Uso</b>
	 * 
	 * @author Francisco Alejandro Hoyos Rojas
	 *
	 */
	public void crearComicDTO() {
		ComicDTO comicDTO = new ComicDTO();
		comicDTO.setId("1");
		comicDTO.setNombre("Dragon Ball Yamcha");
		comicDTO.setEditorial("Planeta Comic");
		comicDTO.setTematicaENUM(TematicaENUM.AVENTURAS);
		comicDTO.setColeccion("Manga Shonen");
		comicDTO.setNumeroPaginas(100);
		comicDTO.setPrecio(new BigDecimal(2100));
		comicDTO.setAutores("Dragon Garow Lee");
		comicDTO.setFechaVenta(LocalDate.now());
		comicDTO.setColor(Boolean.FALSE);
		comicDTO.setFechaVenta(LocalDate.now());
		comicDTO.setEstadoEnum(EstadoENUM.ACTIVO);
		comicDTO.setCantidad(20L);
		if (listaComics == null) {
			listaComics = new ArrayList<ComicDTO>();
		}
		listaComics.add(comicDTO);
	}

	/**
	 * 
	 * Método encargado de agregar un Comic a la lista de comics <b>Caso de Uso</b>
	 * 
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param comicDTO Comic que va a ser agregado a la lista de comics
	 * 
	 */
	public void agregarComicDTOLista(ComicDTO comicDTO) {
		if (listaComics == null) {
			listaComics = new ArrayList<ComicDTO>();
		}
		listaComics.add(comicDTO);
	}

	/**
	 * 
	 * Método encargado de modificar el nombre de un comic <b>Caso de Uso</b>
	 * 
	 * @author Frsncisco Alejandro Hoyos Rojas
	 * 
	 * @param id     id del Comic que va a ser modificado
	 * @param nombre Nuevo nombre que va a tener el comic
	 * @return Si se modifica el comic se retorna el comic modificado, de lo
	 *         contrario null
	 */
	public ComicDTO modificarComicDTO(String id, String nombre) {
		ComicDTO comicModificar = null;
		for (int i = 0; i < listaComics.size(); i++) {
			comicModificar = listaComics.get(i);
			if (comicModificar.getId().equals(id)) {
				comicModificar.setNombre(nombre);
				return comicModificar;
			}
		}
		return comicModificar;
	}

	/**
	 * 
	 * Metodo encargado de eliminar un comic de la lista de comics <b>Caso de
	 * Uso</b>
	 * 
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param id id del comic a eliminar
	 * @return True si el comic es eliminado de lo contrario False
	 */
	public Boolean eliminarComicDTO(String id) {
		int i = 0;
		ComicDTO comicEliminar = null;
		if (listaComics != null) {
			while (i < listaComics.size()) {
				comicEliminar = listaComics.get(i);
				if (comicEliminar.getId().equals(id)) {
					listaComics.remove(comicEliminar);
					return true;
				}
				i++;
			}
		}
		return false;
	}

	/**
	 * 
	 * Método encargado de modificar un comic en una posición específica de la lista
	 * de comics <b>Caso de Uso</b>
	 * 
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param posicion
	 * @param comicDTO
	 */
	public void modificarComicDTO(int posicion, ComicDTO comicDTO) {
		listaComics.set(posicion, comicDTO);
	}

	/**
	 * Método encargado de retornar el valor del atributo listaComics
	 * 
	 * @return El listaComics asociado a la clase
	 */
	public List<ComicDTO> getListaComics() {
		return listaComics;
	}

	/**
	 * Método encargado de modificar el valor del atributo listaComics
	 * 
	 * @param listaComics El nuevo listaComics a modificar.
	 */
	public void setListaComics(List<ComicDTO> listaComics) {
		this.listaComics = listaComics;
	}

}
