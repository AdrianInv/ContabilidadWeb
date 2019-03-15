/**
 * ************************************************************************************
 * Fecha de Creación        : 09/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.bean;

import java.io.Serializable;

public class ArchivoPlanoEstado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nombreArchivo;
	private String estadoPremium;
	private String estadoIDI;

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getEstadoPremium() {
		return estadoPremium;
	}

	public void setEstadoPremium(String estadoPremium) {
		this.estadoPremium = estadoPremium;
	}

	public String getEstadoIDI() {
		return estadoIDI;
	}

	public void setEstadoIDI(String estadoIDI) {
		this.estadoIDI = estadoIDI;
	}
	
}