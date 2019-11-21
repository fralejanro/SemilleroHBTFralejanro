package com.hbt.semillero.ejb;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.entidades.EstadoENUM;
import com.hbt.semillero.entidades.Persona;
import com.hbt.semillero.entidades.Proveedor;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author Francisco Alejandro Hoyos Rojas
 * @version 1.0
 */

@LocalBean
@Stateless
public class GestionarProvedorBean implements IGestionarProveedorLocal{

	@EJB 
	private GestionarPersonaBean gestionarPersonaBean ;
	
	/**
	 * 
	 */
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * 
	 * Método encargado de Crear un nuevo Proveedor <b>Caso de Uso</b>
	 * 
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param personaDTO Persona a crear
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Boolean crearProveedor(ProveedorDTO proveedorDTO) {
		if (gestionarPersonaBean.consultarPersonaPorNombre(proveedorDTO.getPersonaDTO().getNombre())==null&&
				consultarProveedorPorDireccion(proveedorDTO.getDireccion())==null&&
				consultarTodosLosProveedores().size()<30) {
			
			em.persist(convertirProveedorDTOToProveedor(proveedorDTO,gestionarPersonaBean.crearPersona(proveedorDTO.getPersonaDTO())));
			
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	/**
	 * 
	 * Método encargado de buscar una Proveedor por Dirección
	 * 
	 * <b>Caso de Uso</b>
	 * 
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param Direccion direcciond el proveedor a buscar
	 * @return Proveedor buscado, si no la encuentra null
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Proveedor consultarProveedorPorDireccion(String direccionProveedor) {
		try {
			TypedQuery<Proveedor> query = (TypedQuery<Proveedor>) em.createNamedQuery(Proveedor.CONSULTAR_PROVEEDOR_POR_DIRECCION);
			query.setParameter("direccionProveedor", direccionProveedor.toUpperCase());
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	/**
	 * 
	 * Método encargado de consultar los proveedores
	 * <b>Caso de Uso</b>
	 * 
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Proveedor> consultarTodosLosProveedores() {
		try {
			TypedQuery<Proveedor> query = (TypedQuery<Proveedor>) em.createNamedQuery(Proveedor.CONSULTAR_TODOS_LOS_PROVEEDORES);
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	/**
	 * 
	 * Método encargado de converir un Proveedor a un ProveedorDTO <b>Caso de Uso</b>
	 * 
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param proveedorDTO ProveedorDTO que va a ser convertida a Proveedor
	 * @return Un Proveedor
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	private Proveedor convertirProveedorDTOToProveedor(ProveedorDTO proveedorDTO, Persona persona) {
		Proveedor proveedor = new Proveedor();
		proveedor.setDireccion(proveedorDTO.getDireccion());
		proveedor.setEstado(EstadoENUM.valueOf(proveedorDTO.getEstado()));
		proveedor.setFechaCreacion(proveedorDTO.getFechaCreacion());
		proveedor.setMontoCredito(proveedorDTO.getMontoCredito());
		proveedor.setPersona(persona);
		return proveedor;
	}

	
	/**
	 * 
	 * Método encargado de consultar si un contrato con un proveedor esta vigente o no
	 * 
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param idProveedor id del proveedor a consultar
	 * @param fechaCreacion fecha del contrato actual
	 * 
	 * @retun True si el contrato esta vigente de lo contrario False
	 */
	public Boolean consultarVigenciaContrato(String idProveedor, LocalDate fechaCreacion) {
		
		return null;
	}

	/**
	 * 
	 * Metodo encargado de eliminar un proveedor
	 * <b>Caso de Uso</b>
	 * 
	 * @author fralejanro
	 * 
	 * @param idProveedor id del proveedor a eliminar
	 * @return True si el proveedor se elimina, de lo contrario false
	 */
	public Boolean eliminarProveedor(String idProveedor) {
		Proveedor proveedor =  em.find(Proveedor.class, Long.parseLong(idProveedor));
		if(proveedor!=null) {
			proveedor.setEstado(EstadoENUM.INACTIVO);
			em.merge(proveedor);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}


	/**
	 * 
	 * Metodo encargado de modificar el monto y nombre del proveedor
	 * <b>Caso de Uso</b>
	 * @author fralejanro
	 * 
	 * @param idProveedor id del proveedor a ser modificado
	 * @param montoCredito nuevo monto a ser asignado
	 * @param nombre nuevo nombre a ser asignado
	 * @return True si se modifica el proveedor, de lo contrario false
	 */
	public Boolean modificarProvedor(String idProveedor, BigDecimal montoCredito, String nombre) {
		GestionarPersonaBean gestionarPersonaBean = new GestionarPersonaBean();
		Proveedor proveedor =  em.find(Proveedor.class, Long.parseLong(idProveedor));
		if(proveedor!=null) {
			if(proveedor.getMontoCredito()!=montoCredito) {
				proveedor.setMontoCredito(montoCredito);
			}
			if(gestionarPersonaBean.consultarPersonaPorNombre(proveedor.getPersona().getNombre().toUpperCase())==null) {
				proveedor.getPersona().setNombre(nombre);
			}
			em.merge(proveedor);	
		}
		return Boolean.FALSE;
	}

	
	/**
	 * 
	 * Metodo encargado de consultar si el monto de credito esta cerca a coparse
	 * <b>Caso de Uso</b>
	 * @author fralejanro
	 * 
	 * @param idProveedor
	 * @return True si el cupo es igual o mayor a 15.000.000 de lo contrario false
	 */
	@Override
	public Boolean consultarMontoCredito(String idProveedor) {
		Proveedor proveedor =  em.find(Proveedor.class, Long.parseLong(idProveedor));
		BigDecimal monto = new BigDecimal("15000000");
		if(proveedor!=null) {
			if(proveedor.getMontoCredito().compareTo(monto)==1||
					proveedor.getMontoCredito().compareTo(monto)==0) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

	

	
	
}
