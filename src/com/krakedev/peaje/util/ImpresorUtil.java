package com.krakedev.peaje.util;

import com.krakedev.peaje.entidades.Vehiculo;

public class ImpresorUtil {
	public static void imprimirVehiculo(Vehiculo vehiculo) {
	    System.out.println("Placa: " + vehiculo.getPlaca());
	    System.out.println("Tipo: " + vehiculo.getTipo());

	    System.out.println("Propietario:");
	    vehiculo.getPropietario().imprimir();

	    System.out.println("Tag:");
	    vehiculo.getTag().imprimir();
	}
}