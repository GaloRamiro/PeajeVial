package com.krakedev.peaje.servicios;

import com.krakedev.peaje.entidades.Conductor;
import com.krakedev.peaje.entidades.TagElectronico;
import com.krakedev.peaje.entidades.Vehiculo;
import com.krakedev.peaje.util.ValidadorUtil;

public class EstacionPeaje {
	private int codigoEstacion = 500;
	private double tarifaLiviano = 1.00;
	private double tarifaPesado = 2.50;

	public EstacionPeaje() {
	}

	public int getCodigoEstacion() {
		return codigoEstacion;
	}

	public void setCodigoEstacion(int codigoEstacion) {
		this.codigoEstacion = codigoEstacion;
	}

	public double getTarifaLiviano() {
		return tarifaLiviano;
	}

	public void setTarifaLiviano(double tarifaLiviano) {
		this.tarifaLiviano = tarifaLiviano;
	}

	public double getTarifaPesado() {
		return tarifaPesado;
	}

	public void setTarifaPesado(double tarifaPesado) {
		this.tarifaPesado = tarifaPesado;
	}

	public Vehiculo registrarVehiculo(String placa, String tipo, Conductor conductor) {

		if (!ValidadorUtil.esTipoValido(tipo)) {
			return null;
		}

		Vehiculo vehiculo = new Vehiculo(placa);
		vehiculo.setTipo(tipo);
		vehiculo.setPropietario(conductor);

		TagElectronico tag = new TagElectronico(placa);
		vehiculo.setTag(tag);

		return vehiculo;
	}
	
	public boolean recargarTag(TagElectronico tag, double monto) {

	    if (!ValidadorUtil.esMontoValido(monto)) {
	        return false;
	    }

	    tag.setSaldo(tag.getSaldo() + monto);
	    return true;
	}
	public boolean cobrarPeaje(Vehiculo vehiculo) {

	    double tarifa;

	    if ("L".equals(vehiculo.getTipo())) {
	        tarifa = tarifaLiviano;
	    } else {
	        tarifa = tarifaPesado;
	    }

	    if (vehiculo.getTag().getSaldo() < tarifa) {
	        return false;
	    }

	    vehiculo.getTag().setSaldo(
	        vehiculo.getTag().getSaldo() - tarifa
	    );

	    return true;
	}
}
