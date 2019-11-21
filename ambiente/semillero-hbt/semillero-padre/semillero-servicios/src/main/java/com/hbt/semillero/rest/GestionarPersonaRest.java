package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.IGestionarPersonaLocal;

/**
 * <b>Descripción:<b> Clase que determina el servicio rest que permite gestionar
 * una persona
 * 
 * @author Francisco Alejandro Hoyos Rojas
 * @version
 */
@Path("/GestionarPersona")
public class GestionarPersonaRest {

	/**
	 * Atriburo que permite gestionar una Persona
	 */
	@EJB
	private IGestionarPersonaLocal gestionarPersonaEJB;

	/**
	 * 
	 * Metodo encargado crear un comic
	 * http://localhost:8085/semillero-servicios/rest/GestionarPersona/crearPersona
	 * 
	 * @param personaDTO persona a ser creada
	 * @return
	 */
	@GET
	@Path("/crearPersona")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearComic(PersonaDTO personaDTO) {
		ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.FALSE, "La persona no fue creada");
		if (gestionarPersonaEJB.crearPersona(personaDTO) !=null) {
			resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Persona creada exitosamente");
		}
		return resultadoDTO;

	}
}
