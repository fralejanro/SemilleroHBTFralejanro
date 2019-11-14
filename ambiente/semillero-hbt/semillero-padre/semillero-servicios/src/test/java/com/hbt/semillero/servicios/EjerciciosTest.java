/**
 * EjerciciosTest.java
 */
package com.hbt.semillero.servicios;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.pojo.EjerciciosPOJO;

/**
 * <b>Descripción:<b> Clase utilizada para realizar pruebas a los métodos de la clase EjerciciosPOJO
 * <b>Caso de Uso:<b> 
 * @author Francisco Alejandro Hoyos Rojas	
 * @version 1.0
 */
public class EjerciciosTest {
	
	
	/**
	 * Atributo que determina el objeto para gestionar los ejercicios
	 */
	private EjerciciosPOJO ejerciciosPOJO;
	
	
	@Test(enabled=false)
	public void ejercicio4() {
		ejerciciosPOJO = new EjerciciosPOJO();
		String fechaNacimiento = "1994-06-08";
		int años = 1994;
		Assert.assertTrue(ejerciciosPOJO.ejercicio4(fechaNacimiento, años));
	}
	
	/**
	 * 
	 * Metodo encargado de verificar que se agregen y orden numeros a una lista
	 * <b>Caso de Uso</b>
	 * @author Francisco Alejandro Hoyos Rojas	
	 *
	 */
	@Test(enabled=true)
	public void ejercicio5() {
		ejerciciosPOJO = new EjerciciosPOJO();
		int numero1 = 50;
		int numero2 = 1;
		int numero3 = 249;
		int numero4 = -2;
		ejerciciosPOJO.agregarNumeroListaNumeros(numero1);
		ejerciciosPOJO.agregarNumeroListaNumeros(numero2);
		ejerciciosPOJO.agregarNumeroListaNumeros(numero3);
		ejerciciosPOJO.agregarNumeroListaNumeros(numero4);
		ejerciciosPOJO.ordenarListaNumeros();
		ArrayList<Integer>listaNumeros = (ArrayList<Integer>) ejerciciosPOJO.getListaNumeros();
		Assert.assertTrue( listaNumeros.get(0)==-2);
		Assert.assertTrue( listaNumeros.size()==4);
		
		
	}
	
	

}
