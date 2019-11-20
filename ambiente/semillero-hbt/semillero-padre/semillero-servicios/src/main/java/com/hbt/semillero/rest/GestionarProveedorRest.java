package com.hbt.semillero.rest;

import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.IGestionarProveedorLocal;

/**
 * <b>Descripción:<b> Clase que determina el servicio rest que permite gestionar
 * un proveedor
 * 
 * @author Francisco Alejandro Hoyos Rojas
 * @version
 */
@Path("/GestionarProveedor")
public class GestionarProveedorRest {

	/**
	 * Atriburo que permite gestionar un Proveedor
	 */
	@EJB
	private IGestionarProveedorLocal gestionarProveedorEJB;

	/**
	 * 
	 * Metodo encargado crear un proveedor
	 * http://localhost:8085/semillero-servicios/rest/GestionarProveedor/crearProveedor
	 * 
	 * @param proveedorDTO proveedor a ser creado
	 * @param personaDTO   persona a ser creada
	 * @return
	 */
	@GET
	@Path("/crearProveedor")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearProveedor(ProveedorDTO proveedorDTO, PersonaDTO personaDTO) {
		ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.FALSE, "El proveedor no fue creado");
		if (gestionarProveedorEJB.crearProveedor(proveedorDTO, personaDTO) != null) {
			resultadoDTO = new ResultadoDTO(Boolean.TRUE, "El proveedor fue creado exitosamente");
		}
		return resultadoDTO;
	}

	/**
	 * 
	 * Metodo encargado de modificar el monto y nombre de un proveedor
	 * http://localhost:8085/semillero-servicios/rest/GestionarProveedor/modificarProveedor?idProveedor=idProveedor&montoCredito=montoCredito&&nombre=nombre
	 * 
	 * @param idProveedor  identificador del proveedor a modificar
	 * @param montoCredito Nuevo monto a aser asignado
	 * @param nombre       Nuevo nombre a ser asignado
	 */
	@POST
	@Path("/modificarProveedor")
	@Produces(MediaType.APPLICATION_JSON)
	public void modificarProveedor(@QueryParam("idProveedor") String idProveedor,
			@QueryParam("montoCredito") String montoCredito, @QueryParam("nombre") String nombre) {
		gestionarProveedorEJB.modificarProvedor(idProveedor, new BigDecimal(montoCredito), nombre);
	}

	/**
	 * 
	 * Metodo encargado de modificar eliminar un proveedor
	 * http://localhost:8085/semillero-servicios/rest/GestionarProveedor/eliminarProveedo?idProveedor=idProveedor
	 * 
	 * @param idProveedor identificador del proveedor a eliminar
	 * 
	 */
	@POST
	@Path("/eliminarProveedor")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO eliminarProveedor(@QueryParam("idProveedor") String idProveedor) {
		ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.FALSE,
				"El proveedor con id " + idProveedor + " no existe");
		if (idProveedor != null) {
			if (gestionarProveedorEJB.eliminarProveedor(idProveedor) == Boolean.TRUE) {
				resultadoDTO = new ResultadoDTO(Boolean.TRUE, "El proveedor fue eliminado correctamente");
			} else {
				resultadoDTO = new ResultadoDTO(Boolean.FALSE, "El proveedor no fue eliminado");
			}
		} else {
			resultadoDTO = new ResultadoDTO(Boolean.FALSE, "El proveedor con " + idProveedor + " no existe");
		}
		return resultadoDTO;
	}
}
