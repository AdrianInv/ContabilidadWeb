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

public class LogImportacion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nombreArchivo;
	private String tipoValidacion;
	private int secuencia;
	private String uuid;
	private int codigoValidacion;
	private String descripcionValidacion;

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getTipoValidacion() {
		return tipoValidacion;
	}

	public void setTipoValidacion(String tipoValidacion) {
		this.tipoValidacion = tipoValidacion;
	}

	public int getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(int secuencia) {
		this.secuencia = secuencia;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getCodigoValidacion() {
		return codigoValidacion;
	}

	public void setCodigoValidacion(int codigoValidacion) {
		this.codigoValidacion = codigoValidacion;
	}

	public String getDescripcionValidacion() {
		return descripcionValidacion;
	}

	public void setDescripcionValidacion(String descripcionValidacion) {
		this.descripcionValidacion = descripcionValidacion;
	}
	
}