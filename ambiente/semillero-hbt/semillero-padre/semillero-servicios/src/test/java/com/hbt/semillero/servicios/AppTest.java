
package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.hbt.semillero.entidades.Comic;
import com.hbt.semillero.entidades.EstadoENUM;


/**
 * Clase utilizada para realizar las pruebas de la aplicación
 * 
 * @author Francisco Alejandro Hoyos Rojas
 * @version 1.0
 */
public class AppTest {

	/**
	 * Método encargado de verificar que una cadena se invierta correctamente.
	 * 
	 * Se utilizan 5 casos:
	 * 
	 * 1) Cadena de letras 2) Cadena de números 3) Cadena con un palindromo 4)
	 * Cadena vacía 5) Cadena con letras, números y caracteres
	 * <b>Caso de Uso</b>
	 * 
	 * @author Francisco Alejandro Hoyos Rojas
	 */
	@Test(enabled=false)
	public void invertirCadenaTest() {
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
	 * 
	 * Metodo encargado de usar el método toString() de la clase Comic 
	 * <b>Caso de Uso</b>
	 * @author Francisco Alejandro Hoyos Rojas
	 *
	 */
	@Test(enabled=false)
	public void toStringComicTest() {
		Comic comic = new Comic();
		comic.setId(1L);
		comic.setNombre("Rick y Morty");
		Assert.assertTrue(
				comic.toString().equals("Comic [id=" + comic.getId() + ", nombre=" + comic.getNombre() + " ]"));

	}

	/**
	 * 
	 * Metodo encargado de probar los métodos de la enumeración EstadoENUM 
	 * <b>Caso de Uso</b>
	 * @author Francisco Alejandro Hoyos Rojas
	 *
	 */
	@Test(enabled=false)
	public void metodosEstadoENUMTest() {
		EstadoENUM estadoEnumActivo = EstadoENUM.ACTIVO;
		EstadoENUM estadoEnumInactivo = EstadoENUM.INACTIVO;
		EstadoENUM[] estadosEnum = { estadoEnumActivo, estadoEnumInactivo };
		String estadoActivo = "ACTIVO";
		String estadoInactivo = "INACTIVO";
		Integer posEstadoEnumActivo = 0;
		Integer posEstadoEnumInactivo = 1;
		// Comprueba que se devuelva un string con el nombre de la constante ACTIVO
		Assert.assertEquals(estadoActivo, estadoEnumActivo.toString());
		// Comprueba que se devuelva un string con el nombre de la constante INACTIVO
		Assert.assertEquals(estadoInactivo, estadoEnumInactivo.toString());
		// Comprueba que se devuelva un entero con la posición del enum según está
		// declarada
		Assert.assertTrue(posEstadoEnumActivo == estadoEnumActivo.ordinal());
		Assert.assertTrue(posEstadoEnumInactivo != estadoEnumActivo.ordinal());
		// Compara dos enum
		Assert.assertTrue(estadoEnumActivo.compareTo(estadoEnumInactivo) == -1);
		// Comprueba que el array estadosEnum se igual al devuelto por el método
		// values()
		Assert.assertEquals(estadosEnum, EstadoENUM.values());
	}
	
	

	/**
	 * Método utilizado para invertir una cadena
	 * <b>Caso de Uso</b>
	 * @param cadena, cadena que se va a invertir
	 * @return cadena invertida o "" si la cadena es vacía
	 * 
	 * @author Francisco Alejandro Hoyos Rojas
	 */
	private String invertirCadena(String cadena) {

		String cadenaInvertida = "";

		for (int x = cadena.length() - 1; x >= 0; x--) {

			cadenaInvertida = cadenaInvertida + cadena.charAt(x);
		}

		return cadenaInvertida;

	}
}
