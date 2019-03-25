package com.prueba.pe.inter.dto;

public class ResponseArit {

	private double promedio;
	private double desviacion;

	public ResponseArit() {}
	
	public ResponseArit(double promedio, double desviacion) {
		super();
		this.promedio = promedio;
		this.desviacion = desviacion;
	}

	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}

	public double getDesviacion() {
		return desviacion;
	}

	public void setDesviacion(double desviacion) {
		this.desviacion = desviacion;
	}

}
