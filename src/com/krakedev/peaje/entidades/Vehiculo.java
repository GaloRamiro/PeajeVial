package com.krakedev.peaje.entidades;

public class Vehiculo {
	private String placa;
	private String tipo;
	private Conductor propietario;
	private TagElectronico tag;
	
	public Vehiculo(String placa) {
	    this.placa = placa;
	    this.tipo = "L";
	}
}
