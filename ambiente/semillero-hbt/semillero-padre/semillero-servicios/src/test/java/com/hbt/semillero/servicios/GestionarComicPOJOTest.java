/**
 * GestionarComicPOJOTest.java
 */
package com.hbt.semillero.servicios;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.EstadoENUM;
import com.hbt.semillero.entidades.TematicaENUM;
import com.hbt.semillero.pojo.GestionarComicPOJO;

/**
 * <b>Descripción:<b> Clase utilizada para realizar pruebas a los métodos de la clase GestionarComicPOJO
 * <b>Caso de Uso:<b> 
 * @author Francisco Alejandro Hoyos Rojas
 * @version 1.0
 */
public class GestionarComicPOJOTest {
	
	/**
	 * Atributo que determina el objeto para gestionar los comics
	 */
	private GestionarComicPOJO gestionarComicPOJO;
	
	/**
	 *
	 * Método encargado de verificar que se cree una lista de comics y que contenga al menos 3 elementos
	 * al menos un elemento
	 * <b>Caso de Uso</b>
	 * @author Francisco Alejandro Hoyos Rojas
	 *
	 */
	@BeforeTest(enabled=true)
	public void crearComicDTOTest() {
		gestionarComicPOJO = new GestionarComicPOJO();
		gestionarComicPOJO.crearComicDTO();
		Assert.assertNotNull(gestionarComicPOJO.getListaComics()); // Comprueba que se cree una lista de comics
		Assert.assertTrue(!gestionarComicPOJO.getListaComics().isEmpty()); // Comprueba que la lista de comics tenga al menos un elemento
		ComicDTO comicDTO = gestionarComicPOJO.crearComicDTO("2", 
				"Captain America Corps 1-5 USA ",
				"Panini Comics", 
				TematicaENUM.FANTASTICO, 
				"BIBLIOTECA MARVEL", 128, 
				new BigDecimal(5000), 
				"Phillippe Briones, Roger Stern", 
				Boolean.FALSE, LocalDate.now(), 
				EstadoENUM.ACTIVO, 
				5L);
		gestionarComicPOJO.agregarComicDTOLista(comicDTO);
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 2); // Comprueba que solo hayan 2 elementos en la lista de comics
		comicDTO = new ComicDTO();
		comicDTO = gestionarComicPOJO.crearComicDTO("3", 
				"The Spectacular Spider-Man v2 USA",
				"Panini Comics", 
				TematicaENUM.FANTASTICO, 
				"MARVEL COMICS", 208, 
				new BigDecimal(6225), 
				"Straczynski,Deodato Jr.,Barnes,Eaton", 
				Boolean.TRUE, LocalDate.now(), 
				EstadoENUM.INACTIVO, 
				0L);
		gestionarComicPOJO.agregarComicDTOLista(comicDTO);
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 3); // Comprueba que solo hayan 3 elementos en la lista de comics
	}
	
	/**
	 *
	 * Método encargado de verificar que se modifique el comic con id 2 de la lista de comics
	 * <b>Caso de Uso</b>
	 * @author Francisco Alejandro Hoyos Rojas
	 *
	 */
	@Test(enabled=true)
	public void modificarComicDTOTest() {
		String idComicModificar = "2";
		String nuevoNombreComic = "Rick y Morty";
		Assert.assertNotNull(gestionarComicPOJO.modificarComicDTO(idComicModificar, nuevoNombreComic));
	}
	
	/**
	 * 
	 * Método encargado de verificar que se elimine el comic con id 1 de la lista de comics
	 * <b>Caso de Uso</b>
	 * @author Francisco Alejandro Hoyos Rojas
	 *
	 */
	@Test(enabled=true)
	public void eliminarComicDTOTest() {
		String idComicEliminar = "1";
		Assert.assertTrue(gestionarComicPOJO.eliminarComicDTO(idComicEliminar));
	}
	
	
	}
	
	
	
