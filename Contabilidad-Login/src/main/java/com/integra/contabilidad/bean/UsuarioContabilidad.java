/**
 * ************************************************************************************
 * Fecha de Creación        : 07/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.bean;

import java.io.Serializable;

public class UsuarioContabilidad implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String sistema;
	private String nombre;
	private String nombreCompleto;
	private String cargo;
	private String periodoCerrado;
	private String periodo;
	private String moneda;
	private String saldos;
	private String tipoImp;
	private String ajuste;
	private String accPerCon;
	private String varImpche;
	private String flagEliminado;
	private Integer codigoArea;
	private String email;

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getPeriodoCerrado() {
		return periodoCerrado;
	}

	public void setPeriodoCerrado(String periodoCerrado) {
		this.periodoCerrado = periodoCerrado;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getSaldos() {
		return saldos;
	}

	public void setSaldos(String saldos) {
		this.saldos = saldos;
	}

	public String getTipoImp() {
		return tipoImp;
	}

	public void setTipoImp(String tipoImp) {
		this.tipoImp = tipoImp;
	}

	public String getAjuste() {
		return ajuste;
	}

	public void setAjuste(String ajuste) {
		this.ajuste = ajuste;
	}

	public String getAccPerCon() {
		return accPerCon;
	}

	public void setAccPerCon(String accPerCon) {
		this.accPerCon = accPerCon;
	}

	public String getVarImpche() {
		return varImpche;
	}

	public void setVarImpche(String varImpche) {
		this.varImpche = varImpche;
	}

	public String getFlagEliminado() {
		return flagEliminado;
	}

	public void setFlagEliminado(String flagEliminado) {
		this.flagEliminado = flagEliminado;
	}

	public Integer getCodigoArea() {
		return codigoArea;
	}

	public void setCodigoArea(Integer codigoArea) {
		this.codigoArea = codigoArea;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}