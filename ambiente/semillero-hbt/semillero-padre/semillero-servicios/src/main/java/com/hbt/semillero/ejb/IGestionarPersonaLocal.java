package com.hbt.semillero.ejb;

import javax.ejb.Local;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.entidades.Persona;

/**
 * Expone los métodos del EJB GestionarPersona Las interfaces determinan una
 * especie de contrato donde se define las firmas de los metodos, define que se
 * necesita implementar pero no el como eso lo realiza la clase que la
 * implementa Palabras claves interface e implements
 * 
 * @author Francisco Alejandro Hoyos Rojas
 *
 */
@Local
public interface IGestionarPersonaLocal {

	/**
	 * 
	 * Metodo encargado de crear una persona
	 * <b>Caso de Uso</b>
	 * @author fralejanro
	 * 
	 * @param personaDTO
	 * @return True si la persona fue creada, de lo contrario false
	 */
	public Persona crearPersona(PersonaDTO personaDTO);
	
}
