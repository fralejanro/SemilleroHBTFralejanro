package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * Clase utilizada para realizar las pruebas de la aplicación
 * 
 * @author Francisco Alejandro Hoyos Rojas
 *
 */
public class AppTest {

	public void shouldAnswerWithTrue() {

	}

	/**
	 * Prueba utilizada para verificar que dos números se sumen
	 * correctamente
	 */
	@Test
	public void primeraPU() {
		Long resultadoEsperado = 150L;
		Long sumandoUno = 100L;
		Long sumandoDos = 50L;
		Long resultado = sumandoUno + sumandoDos;
		Assert.assertEquals(resultado, resultadoEsperado);
	}

	/**
	 * Prueba utilizada para verificar que una cadena se invierta
	 * correctamente.
	 * 
	 * Se utilizan 5 casos:
	 * 
	 * 1) Cadena de letras
	 * 2) Cadena de números
	 * 3) Cadena con un palindromo
	 * 4) Cadena vacía
	 * 5) Cadena con letras, números y caracteres
	 */
	@Test
	public void pruebaInvertirCadena() {
		String cadenaUno = "perro";
		String cadenaUnoInvertida = "orrep";
		String cadenaDos = "1234";
		String cadenaDosInvertida = "4321";
		String cadenaPalindromo = "ala";
		String cadenaVacia = "";
		String cadenaTres = "SemilleroHBT-2019II";
		String cadenaTresInvertida = "II9102-TBHorellimeS";
	
		// Cadena de letras
		Assert.assertTrue(cadenaUnoInvertida.equals(invertirCadena(cadenaUno)));
		Assert.assertFalse(cadenaUno.equals(invertirCadena(cadenaUno)));
		// Cadena de números
		Assert.assertEquals(cadenaDosInvertida, invertirCadena(cadenaDos));
		Assert.assertNotEquals(cadenaDos, invertirCadena(cadenaDos));
		// Cadena palindromo
		Assert.assertEquals(cadenaPalindromo, invertirCadena(cadenaPalindromo));
		// Cadena vacia
		Assert.assertTrue(cadenaVacia.equals(invertirCadena(cadenaVacia)));
		// Cadena con letras, números y caracteres
		Assert.assertTrue(cadenaTresInvertida.equals(invertirCadena(cadenaTres)));
	}
	
	/**
	 * Método utilizado para invertir una cadena
	 * @param cadena, cadena que se va a invertir
	 * @return cadena invertida o "" si la cadena es vacía
	 */
	private String invertirCadena(String cadena) {

		String cadenaInvertida = "";

		for (int x = cadena.length() - 1; x >= 0; x--){

			cadenaInvertida = cadenaInvertida + cadena.charAt(x);
		}

		return cadenaInvertida;

	}
}
