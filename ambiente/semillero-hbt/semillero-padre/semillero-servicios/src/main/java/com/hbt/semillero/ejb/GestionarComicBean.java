/**
 * GestionarComicBean.java
 */
package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.Comic;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Francisco Alejandro Hoyos Rojas
 * @version 1.0
 */

@Stateless
public class GestionarComicBean {
	
	/**
	 * 
	 */
	@PersistenceContext
	private EntityManager em;
	

	
	/**
	 * 
	 * Método encargado de Crear un nuevo Comic
	 * <b>Caso de Uso</b>
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param comicDTO Comic a crear
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
		comic.setId(comicDTO.getId());
		comic.setNombre(comicDTO.getNombre());
		comic.setEditorial(comicDTO.getEditorial());
		comic.setTematicaEnum(comicDTO.getTematicaENUM());
		comic.setColeccion(comicDTO.getColeccion());
		comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
		comic.setPrecio(comicDTO.getPrecio());
		comic.setAutores(comicDTO.getAutores());
		comic.setFechaVenta(comicDTO.getFechaVenta());
		comic.setColor(comicDTO.getColor());
		comic.setFechaVenta(comicDTO.getFechaVenta());
		comic.setEstadoEnum(comicDTO.getEstadoEnum());
		comic.setCantidad(comicDTO.getCantidad());
		em.persist(comic);
	}
	
	/**
	 * 
	 * Método encargado de modificar un Comic
	 * <b>Caso de Uso</b>
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param comicDTO comic a modificar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
		comic.setId(comicDTO.getId());
		em.merge(comicDTO);
	}
	
	/**
	 * 
	 * Método encargado de buscar un Comic
	 * <b>Caso de Uso</b>
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param id id del comic a buscar
	 * @return Comic buscado
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ComicDTO consultarComic(String id) {
		Comic comic = em.find(Comic.class, id);
		return new ComicDTO(comic.getId(), comic.getNombre());	
	}
	
	/**
	 * 
	 * Método encargado de buscar todos los comics
	 * <b>Caso de Uso</b>
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @return Lista de comics
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComicDTO> consultarTodos() {
		em.createNativeQuery("SELECT c from Comic").getResultList();
		List<Comic> resultList = (List<Comic>) em.createQuery("Select c from Comic").getResultList();
		return null;
	}
}
