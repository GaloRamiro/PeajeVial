package com.krakedev.peaje.entidades;

public class TagElectronico {
	private String idTag;
	private double saldo;
	private boolean activo;
	
	public TagElectronico(String idTag) {
	    this.idTag = idTag;
	    this.saldo = 0.0;
	    this.activo = true;
	}

	public TagElectronico() {
	}

	public String getIdTag() {
	    return idTag;
	}

	public void setIdTag(String idTag) {
	    this.idTag = idTag;
	}

	public double getSaldo() {
	    return saldo;
	}

	public void setSaldo(double saldo) {
	    this.saldo = saldo;
	}

	public boolean isActivo() {
	    return activo;
	}

	public void setActivo(boolean activo) {
	    this.activo = activo;
	}
}
