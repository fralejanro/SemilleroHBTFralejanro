/**
 * EjerciciosPOJO.java
 */
package com.hbt.semillero.pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author Francisco Alejandro Hoyos Rojas
 * @version 1.0
 */
public class EjerciciosPOJO {
	
	/**
	 * Atributo que determina la lista de numeros
	 */
	private List<Integer> listaNumeros = null;
	
	/**
	 * Atributo que representa los resultados de un partido de tenis
	 */
	private Map<String, Integer[]> resultadosTenis = null;
	/*
	 * public String ejercicio1(String identificador) {
	 * 
	 * if(identificador.isEmpty()) { return
	 * "Una cadena vacia no es un identificador valido"; }else
	 * if(!Character.isDigit(identificador.charAt(0))) {
	 * 
	 * }else { return "Un identificador valido no puede empezar por números"; }
	 * 
	 * }
	 */

	/*
	 * public static void ejercicio2() {
	 * 
	 * 
	 * System.out.print("Empty = " + empty);
	 * 
	 * System.out.print(", Brand = " + brand);
	 * 
	 * }
	 */

	/**
	 * 
	 * Metodo encargado de validar si un número es primo <b>Caso de Uso</b>
	 * 
	 * @author fralejanro
	 * 
	 * @param numeroValidar
	 * @return
	 */
	public boolean ejercicio3(int numeroValidar) {
		int contador = 0;
		for (int i = 1; i < numeroValidar; i++) {
			if (numeroValidar % i == 0) {
				contador++;
			}
		}
		if (contador > 2) {
			return false;
		}
		return true;

	}

	/**
	 * 
	 * Metodo encargado de sumarle años a la edad de cada persona
	 * <b>Caso de Uso</b>
	 * @author fralejanro
	 * 
	 * @param fechaNacimiento fecha de nacimiento de una persona
	 * @param años años de una persona
	 * @return true si la suma es igual 2019 de lo contrario false
	 */
	public boolean ejercicio4(String fechaNacimiento, int años) {
		if (!fechaNacimiento.isEmpty() && años > 0) {
			LocalDate fechaNacimientoLocalDate = LocalDate.parse(fechaNacimiento);
			fechaNacimientoLocalDate.plusYears(años);
			if (fechaNacimientoLocalDate.getYear() == 2019) {
				return true;
			}
		}
		return false;

	}
	/**
	 * 
	 * Metodo encargado de 
	 * <b>Caso de Uso</b>
	 * @author fralejanro
	 * 
	 * @param tenista
	 * @param juegosGanados
	 */
	public void agregarResultadosPartido(String tenista, Integer [] juegosGanados) {
		if(resultadosTenis==null) {
			resultadosTenis = new LinkedHashMap<String, Integer[]>();
		}
		resultadosTenis.put(tenista,juegosGanados);
	}
	

	/**
	 * 
	 * Metodo encargado de 
	 * <b>Caso de Uso</b>
	 * @author fralejanro
	 * 
	 * @param cantidadDevuelta
	 * @return
	 */
	public Integer [] calcularDevuelta(Integer cantidadDevuelta) {
		Integer [] monedas = {0,0,0,0,0};
		Integer [] monedasDisponibles = {1000,500,200,100,50};
		if(cantidadDevuelta<0) {
			return monedas;
		}else {
			for (int i=0; i<monedasDisponibles.length;i++) {
				monedas[i]=(int)Math.floor(cantidadDevuelta/monedasDisponibles[i]);
				cantidadDevuelta = cantidadDevuelta-(monedas[i]*monedasDisponibles[i]);
				if(cantidadDevuelta==0) {
					return monedas;
				}
			}
			return monedas;
		}
	}
	
	/**
	 * 
	 * Metodo encargado de manejar Excepción
	 * <b>Caso de Uso</b>
	 * @author fralejanro
	 * 
	 * @throws Exception
	 */
	public void ejercicio9()throws Exception{
	 throw	new Exception();
	}

	/**
	 * 
	 * Método encargado de agregar un numero a la lista de numeros
	 * 
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * @param numero numero que va a ser agregado a la lista de numeros
	 * 
	 */
	public void agregarNumeroListaNumeros(Integer numero) {
		if (listaNumeros == null) {
			listaNumeros = new ArrayList<Integer>();
		}
		listaNumeros.add(numero);
	}
	
	/**
	 * 
	 * Método encargado de ordenar la lista de números de manear ascendente
	 * 
	 * @author Francisco Alejandro Hoyos Rojas
	 * 
	 * 
	 */
	public void ordenarListaNumeros() {
		Collections.sort(listaNumeros);
	}

	/**
	 * Metodo encargado de retornar el valor del atributo listaNumeros
	 * @return El listaNumeros asociado a la clase
	 */
	public List<Integer> getListaNumeros() {
		return listaNumeros;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaNumeros
	 * @param listaNumeros El nuevo listaNumeros a modificar.
	 */
	public void setListaNumeros(List<Integer> listaNumeros) {
		this.listaNumeros = listaNumeros;
	}

	
	
}
