/**
 * GestionarComicBean.java
 */
package com.hbt.semillero.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.Comic;
import com.hbt.semillero.entidades.EstadoENUM;
import com.hbt.semillero.entidades.TematicaENUM;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author Francisco Alejandro Hoyos Rojas
 * @version 1.0
 */

@Stateless
public class GestionarComicBean implements IGestionarComicLocal {

	/**
	 * 
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * 
	 * Método encargado de Crear un nuevo Comic <b>Caso de Uso</b>
	 * 
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param comicDTO Comic a crear
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Boolean crearComic(ComicDTO comicDTO) {
		if (consultarComicPorNombre(comicDTO.getNombre()) == null) {
			Comic comic = convertirComicDTOToComic(comicDTO);
			em.persist(comic);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	/**
	 * 
	 * Método encargado de modificar un Comic <b>Caso de Uso</b>
	 * 
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param comicDTO comic a modificar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
		// comic.setId(comicDTO.getId());
		em.merge(comicDTO);
	}

	/**
	 * 
	 * Método encargado de buscar un Comic <b>Caso de Uso</b>
	 * 
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param id id del comic a buscar
	 * @return Comic buscado
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ComicDTO consultarComic(String id) {
		Comic comic = em.find(Comic.class, Long.parseLong(id));
		return convertirComicToComicDTO(comic);
	}

	/**
	 * 
	 * Método encargado de buscar un Comic <b>Caso de Uso</b>
	 * 
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param nombreComic nombre del comic a buscar
	 * @return Comic buscado
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ComicDTO consultarComicPorNombre(String nombreComic) {
		try {
			TypedQuery<Comic> query = (TypedQuery<Comic>) em.createNamedQuery(Comic.CONSULTAR_COMIC_POR_NOMBRE);
			query.setParameter("nombreComic", nombreComic.toUpperCase());
			return convertirComicToComicDTO(query.getSingleResult());
		} catch (NoResultException e) {
			return null;
		}
	}

	/**
	 * 
	 * Método encargado de buscar todos los comics <b>Caso de Uso</b>
	 * 
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

	/**
	 * 
	 * Método encargado de modificar un Comic <b>Caso de Uso</b>
	 * 
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param id       id del comic a modificar
	 * @param nombre   nuevo nombre del comic
	 * @param comicDTO comic a modificar
	 */
	@Override
	// @TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarComic(Long id, String nombre, ComicDTO comicNuevo) {
		Comic comicModificar;
		if (comicNuevo == null) {
			comicModificar = em.find(Comic.class, id);
		} else {
			comicModificar = convertirComicDTOToComic(comicNuevo);
		}
		// TODO
		comicModificar.setNombre(nombre);
		em.merge(comicModificar);

	}

	/**
	 * 
	 * Método encargado de eliminar un Comic <b>Caso de Uso</b>
	 * 
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param idComic id del comic a eliminar
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public Boolean eliminarComic(Long idComic) {
		Comic comic = em.find(Comic.class, idComic);
		if (comic != null) {
			em.remove(comic);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	/**
	 * 
	 * Método encargado de consultar todos los comics <b>Caso de Uso</b>
	 * 
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 */
	@Override
	public List<ComicDTO> consultarComics() {
		List<ComicDTO> resultadosComicDTO = new ArrayList<ComicDTO>();
		List<Comic> resultados = em.createQuery("select c from Comic c").getResultList();
		for (Comic comic : resultados) {
			resultadosComicDTO.add(convertirComicToComicDTO(comic));
		}
		return resultadosComicDTO;
	}

	/**
	 * 
	 * Método encargado de converir un ComicDTO a un Comic <b>Caso de Uso</b>
	 * 
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param comicDTO ComicDTO que va a ser convertido a Comic
	 * @return Un Comic
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	private Comic convertirComicDTOToComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
		comic.setNombre(comicDTO.getNombre());
		comic.setEditorial(comicDTO.getEditorial());
		comic.setTematicaEnum(TematicaENUM.valueOf(comicDTO.getTematicaEnum()));
		comic.setColeccion(comicDTO.getColeccion());
		comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
		comic.setPrecio(comicDTO.getPrecio());
		comic.setAutores(comicDTO.getAutores());
		comic.setFechaVenta(comicDTO.getFechaVenta());
		comic.setColor(comicDTO.getColor());
		comic.setEstadoEnum(EstadoENUM.valueOf(comicDTO.getEstadoEnum()));
		comic.setCantidad(0L);
		return comic;
	}

	/**
	 * 
	 * Método encargado de converir un Comic a un ComicDTO <b>Caso de Uso</b>
	 * 
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param comic Comic que va a ser convertido a ComicDTO
	 * @return Un ComicDTO
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	private ComicDTO convertirComicToComicDTO(Comic comic) {
		ComicDTO comicDTO = new ComicDTO();
		if (comic.getId() != null) {
			comicDTO.setId(comic.getId().toString());
		}
		comicDTO.setNombre(comic.getNombre());
		comicDTO.setEditorial(comic.getEditorial());
		comicDTO.setTematicaEnum(comic.getTematicaEnum().toString());
		comicDTO.setColeccion(comic.getColeccion());
		comicDTO.setNumeroPaginas(comic.getNumeroPaginas());
		comicDTO.setPrecio(comic.getPrecio());
		comicDTO.setAutores(comic.getAutores());
		comicDTO.setColor(comic.getColor());
		comicDTO.setFechaVenta(comic.getFechaVenta());
		comicDTO.setEstadoEnum(comic.getEstadoEnum().toString());
		comicDTO.setCantidad(comic.getCantidad());
		return comicDTO;
	}

}
