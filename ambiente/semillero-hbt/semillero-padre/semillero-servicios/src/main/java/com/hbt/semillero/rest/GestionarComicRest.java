/**
 * GestionarComicRest.java
 */
package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.ejb.IGestionarComicLocal;

/**
 * <b>Descripción:<b> Clase que determina los servicios rest
 * <b>Caso de Uso:<b> 
 * @author Francisco Alejandro Hoyos Rojas
 * @version 1.0
 */

@Path("/GestionarComic")
public class GestionarComicRest {
/**
 * 
 */
	@EJB
	private IGestionarComicLocal gestionarComicEJB;
	/**
	 * 
	 * Metodo encargado de retonar un mensaje
	 * <b>Caso de Uso</b>
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @return Un mensaje
	 */
	@GET
	@Path("/saludo")
	@Produces
	public String primerRest() {
		return "hola mundo";
	}
	/**
	 * 
	 * Metodo encargado de consultar un comic
	 * <b>Caso de Uso</b>
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param idComic id del comic a consultar
	 * @return Un comic si se encuentra, de lo contrario null
	 */
	@GET
	@Path("/consultarComic")
	@Produces(MediaType.APPLICATION_JSON)
	public ComicDTO consultarComic(@QueryParam("idComic") Long idComic)  {
		if(idComic!=null) {
			return gestionarComicEJB.consultarComic(idComic.toString());
		}
		return null;
	}
}
