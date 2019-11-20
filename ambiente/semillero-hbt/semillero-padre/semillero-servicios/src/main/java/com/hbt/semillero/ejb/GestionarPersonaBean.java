package com.hbt.semillero.ejb;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.entidades.Persona;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author Francisco Alejandro Hoyos Rojas
 * @version 1.0
 */

@Stateless
public class GestionarPersonaBean implements IGestionarPersonaLocal  {

	/**
	 * 
	 */
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * 
	 * Método encargado de Crear una nueva Persona <b>Caso de Uso</b>
	 * 
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param personaDTO Persona a crear
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Persona crearPersona(PersonaDTO personaDTO) {
		Persona persona = null;
		if (consultarPersonaPorNombre(personaDTO.getNombre()) == null) {
			persona = convertirPersonaDTOToPersona(personaDTO);
			em.persist(persona);
			return persona;
		}
		return null;
	}
	

	/**
	 * 
	 * Método encargado de buscar una Persona por Nombre 
	 * 
	 * <b>Caso de Uso</b>
	 * 
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param nombrePersona nombre de la persona a buscar
	 * @return Persona buscada, si no la encuentra null
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Persona consultarPersonaPorNombre(String nombrePersona) {
		try {
			TypedQuery<Persona> query = (TypedQuery<Persona>) em.createNamedQuery(Persona.CONSULTAR_PERSONA_POR_NOMBRE);
			query.setParameter("nombrePersona", nombrePersona.toUpperCase());
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	/**
	 * 
	 * Método encargado de converir una Persona a una PersonaDTO <b>Caso de Uso</b>
	 * 
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param personaDTO PersonaDTO que va a ser convertida a Persona
	 * @return Una Persona
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	private Persona convertirPersonaDTOToPersona(PersonaDTO personaDTO) {
		Persona persona = new Persona();
		persona.setNombre(personaDTO.getNombre());
		persona.setNumeroIdentificacion(Long.parseLong(personaDTO.getNumeroIdentificacion()));
		return persona;
	}


}
