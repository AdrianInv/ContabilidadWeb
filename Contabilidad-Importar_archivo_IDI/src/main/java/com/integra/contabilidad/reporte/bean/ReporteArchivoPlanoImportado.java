/**
 * ************************************************************************************
 * Fecha de Creación        : 09/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.reporte.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import com.google.gson.annotations.Expose;

public class ReporteArchivoPlanoImportado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Expose
	private String nombreArchivoPlano;
	
	@Expose
    private BigDecimal totalDebe;
	
	@Expose
    private BigDecimal totalHaber;
	
	@Expose
    private String periodoAnio;
	
	@Expose
    private String periodoMes;
	
	@Expose
    private String fondo;
	
	@Expose
    private String libro;
	
	@Expose
    private String voucher;
	
	@Expose
    private int cantidadPlano;
	
	@Expose
    private int ccdCantidadRegistros;
	
	@Expose
    private BigDecimal ccdTotalDebe;
	
	@Expose
    private BigDecimal ccdTotalHaber;
	
	@Expose
    private int idiCantidadRegistros;
	
	@Expose
    private BigDecimal idiSumatoria;
	
	@Expose
    private String idiTipoMovimiento;
	
	@Expose
    private int indOK;
	
	@Expose
    private int cantidadArchivosProcesados;
	
	@Expose
    private int cantidadArchivosConError;
	
	@Expose
    private int cantidadArchivosCorrectos;

	public String getNombreArchivoPlano() {
		return nombreArchivoPlano;
	}

	public void setNombreArchivoPlano(String nombreArchivoPlano) {
		this.nombreArchivoPlano = nombreArchivoPlano;
	}

	public BigDecimal getTotalDebe() {
		return totalDebe;
	}

	public void setTotalDebe(BigDecimal totalDebe) {
		this.totalDebe = totalDebe;
	}

	public BigDecimal getTotalHaber() {
		return totalHaber;
	}

	public void setTotalHaber(BigDecimal totalHaber) {
		this.totalHaber = totalHaber;
	}

	public String getPeriodoAnio() {
		return periodoAnio;
	}

	public void setPeriodoAnio(String periodoAnio) {
		this.periodoAnio = periodoAnio;
	}

	public String getPeriodoMes() {
		return periodoMes;
	}

	public void setPeriodoMes(String periodoMes) {
		this.periodoMes = periodoMes;
	}

	public String getFondo() {
		return fondo;
	}

	public void setFondo(String fondo) {
		this.fondo = fondo;
	}

	public String getLibro() {
		return libro;
	}

	public void setLibro(String libro) {
		this.libro = libro;
	}

	public String getVoucher() {
		return voucher;
	}

	public void setVoucher(String voucher) {
		this.voucher = voucher;
	}

	public int getCantidadPlano() {
		return cantidadPlano;
	}

	public void setCantidadPlano(int cantidadPlano) {
		this.cantidadPlano = cantidadPlano;
	}

	public int getCcdCantidadRegistros() {
		return ccdCantidadRegistros;
	}

	public void setCcdCantidadRegistros(int ccdCantidadRegistros) {
		this.ccdCantidadRegistros = ccdCantidadRegistros;
	}

	public BigDecimal getCcdTotalDebe() {
		return ccdTotalDebe;
	}

	public void setCcdTotalDebe(BigDecimal ccdTotalDebe) {
		this.ccdTotalDebe = ccdTotalDebe;
	}

	public BigDecimal getCcdTotalHaber() {
		return ccdTotalHaber;
	}

	public void setCcdTotalHaber(BigDecimal ccdTotalHaber) {
		this.ccdTotalHaber = ccdTotalHaber;
	}

	public int getIdiCantidadRegistros() {
		return idiCantidadRegistros;
	}

	public void setIdiCantidadRegistros(int idiCantidadRegistros) {
		this.idiCantidadRegistros = idiCantidadRegistros;
	}

	public BigDecimal getIdiSumatoria() {
		return idiSumatoria;
	}

	public void setIdiSumatoria(BigDecimal idiSumatoria) {
		this.idiSumatoria = idiSumatoria;
	}

	public String getIdiTipoMovimiento() {
		return idiTipoMovimiento;
	}

	public void setIdiTipoMovimiento(String idiTipoMovimiento) {
		this.idiTipoMovimiento = idiTipoMovimiento;
	}

	public int getIndOK() {
		return indOK;
	}

	public void setIndOK(int indOK) {
		this.indOK = indOK;
	}

	public int getCantidadArchivosProcesados() {
		return cantidadArchivosProcesados;
	}

	public void setCantidadArchivosProcesados(int cantidadArchivosProcesados) {
		this.cantidadArchivosProcesados = cantidadArchivosProcesados;
	}

	public int getCantidadArchivosConError() {
		return cantidadArchivosConError;
	}

	public void setCantidadArchivosConError(int cantidadArchivosConError) {
		this.cantidadArchivosConError = cantidadArchivosConError;
	}

	public int getCantidadArchivosCorrectos() {
		return cantidadArchivosCorrectos;
	}

	public void setCantidadArchivosCorrectos(int cantidadArchivosCorrectos) {
		this.cantidadArchivosCorrectos = cantidadArchivosCorrectos;
	}

}