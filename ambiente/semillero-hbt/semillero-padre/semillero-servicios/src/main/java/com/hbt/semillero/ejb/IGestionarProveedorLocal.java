package com.hbt.semillero.ejb;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.entidades.Proveedor;

/**
 * Expone los métodos del EJB GestionarPersona Las interfaces determinan una
 * especie de contrato donde se define las firmas de los metodos, define que se
 * necesita implementar pero no el como eso lo realiza la clase que la
 * implementa Palabras claves interface e implements
 * 
 * @author Francisco Alejandro Hoyos Rojas
 *
 */
public interface IGestionarProveedorLocal {

	/**
	 * 
	 * Metodo encargado de crear un proveedor <b>Caso de Uso</b>
	 * 
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param proveedorDTO proveedor a ser creado
	 * @param personaDTO   persona que representa al proveedor
	 * @return True si el proveedor fue creado, de lo contrario false
	 */
	public Boolean crearProveedor(ProveedorDTO proveedorDTO, PersonaDTO personaDTO);
	
	/**
	 * 
	 * Metodo encargado de modificar el monto y nombre del proveedor
	 * <b>Caso de Uso</b>
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param idProveedor id del proveedor a ser modificado
	 * @param montoCredito nuevo monto a ser asignado
	 * @param nombre nuevo nombre a ser asignado
	 * @return True si se modifica el proveedor, de lo contrario false
	 */
	public Boolean modificarProvedor(String idProveedor, BigDecimal montoCredito, String nombre);
	
	
	/**
	 * 
	 * Metodo encargado de eliminar un proveedor
	 * <b>Caso de Uso</b>
	 * 
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param idProveedor id del proveedor a eliminar
	 * @return True si el proveedor se elimina, de lo contrario false
	 */
	public Boolean eliminarProveedor(String idProveedor);

	/**
	 * 
	 * Metodo encargado de consultar la vigencia de un contrato con un proveedor
	 * <b>Caso de Uso</b>
	 * 
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param idProveedor   id del proveedor a consultar
	 * @param fechaCreacion fecha del contrato actual
	 * @retun True si el contrato esta vigente de lo contrario False
	 */
	public Boolean consultarVigenciaContrato(String idProveedor, LocalDate fechaCreacion);
	

	/**
	 * 
	 * Metodo encargado de consultar si el monto de credito esta cerca a coparse
	 * <b>Caso de Uso</b>
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param idProveedor
	 * @return True si el cupo es igual o mayor a 15.000.000 de lo contrario false
	 */
	public Boolean consultarMontoCredito(String idProveedor);
	
	/**
	 * 
	 * Metodo encargado de retornar una lista de proveedores
	 * 
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @return Lista de proveedores
	 */
	public List<Proveedor> consultarTodosLosProveedores();



}
