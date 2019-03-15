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

public class Asiento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nombreArchivoEnvio;
	private String usuarioCreacion;
	private String nombreProceso;
	private String uuid;
	private String descripcionAsiento;
	private String flagGeneraOrdenPago;
	private String estado;
	private String observacion;

	public String getNombreArchivoEnvio() {
		return nombreArchivoEnvio;
	}

	public void setNombreArchivoEnvio(String nombreArchivoEnvio) {
		this.nombreArchivoEnvio = nombreArchivoEnvio;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getNombreProceso() {
		return nombreProceso;
	}

	public void setNombreProceso(String nombreProceso) {
		this.nombreProceso = nombreProceso;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getDescripcionAsiento() {
		return descripcionAsiento;
	}

	public void setDescripcionAsiento(String descripcionAsiento) {
		this.descripcionAsiento = descripcionAsiento;
	}

	public String getFlagGeneraOrdenPago() {
		return flagGeneraOrdenPago;
	}

	public void setFlagGeneraOrdenPago(String flagGeneraOrdenPago) {
		this.flagGeneraOrdenPago = flagGeneraOrdenPago;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
}