package com.krakedev.peaje.util;



public class ValidadorUtil {
	public static boolean esMontoValido(double monto) {
		return monto > 0;
	}

	public static boolean esTipoValido(String tipo) {
		return "L".equals(tipo) || "P".equals(tipo);
	}
	
	
}
