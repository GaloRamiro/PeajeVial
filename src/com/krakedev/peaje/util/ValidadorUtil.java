package com.krakedev.peaje.util;

import com.krakedev.peaje.entidades.Vehiculo;

public class ValidadorUtil {
	public static boolean esMontoValido(double monto) {
		return monto > 0;
	}

	public static boolean esTipoValido(String tipo) {
		return "L".equals(tipo) || "P".equals(tipo);
	}
	
	public static void imprimirVehiculo(Vehiculo vehiculo) {
	    System.out.println("Placa: " + vehiculo.getPlaca());
	    System.out.println("Tipo: " + vehiculo.getTipo());

	    System.out.println("Propietario:");
	    vehiculo.getPropietario().imprimir();

	    System.out.println("Tag:");
	    vehiculo.getTag().imprimir();
	}
}
