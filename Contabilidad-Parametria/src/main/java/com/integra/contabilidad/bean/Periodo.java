/**
 * ************************************************************************************
 * Fecha de Creación        : 08/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.bean;

import java.io.Serializable;

public class Periodo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private int estado;
	private int conciliado;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getConciliado() {
		return conciliado;
	}

	public void setConciliado(int conciliado) {
		this.conciliado = conciliado;
	}
}