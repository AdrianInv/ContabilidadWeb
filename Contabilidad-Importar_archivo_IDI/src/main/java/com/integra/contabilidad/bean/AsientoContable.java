package com.integra.contabilidad.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class AsientoContable implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int correlativo;
	private String periodoVoucher;
	private String codigoEmpresa;
	private String codigoLibroAuxiliar;
	private int numeroVoucher;
	private int correlativoVoucher;
	private String fechaVoucher; // quitar
	private String tipoAsiento;
	private String codigoCuentaContable;
	private String codigoCentroCosto;
	private String codigoCuentaCorrienteTercero;
	private String tipoCuentaCorrienteTercero;
	private String codigoTipoDocumentoBase;
	private String numeroDocumento;
	private String fechaVencimiento;
	private BigDecimal montoDebito;
	private BigDecimal montoCredito;
	private String moneda;
	private BigDecimal tipoCambio;
	private BigDecimal importeDolares;
	private String centroGestion;
	private String nombreTercero;
	private String glosaVoucher;
	private String descripcionInterfaz;
	private String periodoInterfaz; // quitar	
	private String fechaDocumento;
	
	public int getCorrelativo() {
		return correlativo;
	}

	public void setCorrelativo(int correlativo) {
		this.correlativo = correlativo;
	}

	public String getPeriodoVoucher() {
		return periodoVoucher;
	}

	public void setPeriodoVoucher(String periodoVoucher) {
		this.periodoVoucher = periodoVoucher;
	}

	public String getCodigoEmpresa() {
		return codigoEmpresa;
	}

	public void setCodigoEmpresa(String codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}

	public String getCodigoLibroAuxiliar() {
		return codigoLibroAuxiliar;
	}

	public void setCodigoLibroAuxiliar(String codigoLibroAuxiliar) {
		this.codigoLibroAuxiliar = codigoLibroAuxiliar;
	}

	public int getNumeroVoucher() {
		return numeroVoucher;
	}

	public void setNumeroVoucher(int numeroVoucher) {
		this.numeroVoucher = numeroVoucher;
	}

	public int getCorrelativoVoucher() {
		return correlativoVoucher;
	}

	public void setCorrelativoVoucher(int correlativoVoucher) {
		this.correlativoVoucher = correlativoVoucher;
	}

	public String getFechaVoucher() {
		return fechaVoucher;
	}

	public void setFechaVoucher(String fechaVoucher) {
		this.fechaVoucher = fechaVoucher;
	}

	public String getTipoAsiento() {
		return tipoAsiento;
	}

	public void setTipoAsiento(String tipoAsiento) {
		this.tipoAsiento = tipoAsiento;
	}

	public String getCodigoCuentaContable() {
		return codigoCuentaContable;
	}

	public void setCodigoCuentaContable(String codigoCuentaContable) {
		this.codigoCuentaContable = codigoCuentaContable;
	}

	public String getCodigoCentroCosto() {
		return codigoCentroCosto;
	}

	public void setCodigoCentroCosto(String codigoCentroCosto) {
		this.codigoCentroCosto = codigoCentroCosto;
	}

	public String getCodigoCuentaCorrienteTercero() {
		return codigoCuentaCorrienteTercero;
	}

	public void setCodigoCuentaCorrienteTercero(String codigoCuentaCorrienteTercero) {
		this.codigoCuentaCorrienteTercero = codigoCuentaCorrienteTercero;
	}

	public String getTipoCuentaCorrienteTercero() {
		return tipoCuentaCorrienteTercero;
	}

	public void setTipoCuentaCorrienteTercero(String tipoCuentaCorrienteTercero) {
		this.tipoCuentaCorrienteTercero = tipoCuentaCorrienteTercero;
	}

	public String getCodigoTipoDocumentoBase() {
		return codigoTipoDocumentoBase;
	}

	public void setCodigoTipoDocumentoBase(String codigoTipoDocumentoBase) {
		this.codigoTipoDocumentoBase = codigoTipoDocumentoBase;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public BigDecimal getMontoDebito() {
		return montoDebito;
	}

	public void setMontoDebito(BigDecimal montoDebito) {
		this.montoDebito = montoDebito;
	}

	public BigDecimal getMontoCredito() {
		return montoCredito;
	}

	public void setMontoCredito(BigDecimal montoCredito) {
		this.montoCredito = montoCredito;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public BigDecimal getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(BigDecimal tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	public BigDecimal getImporteDolares() {
		return importeDolares;
	}

	public void setImporteDolares(BigDecimal importeDolares) {
		this.importeDolares = importeDolares;
	}

	public String getCentroGestion() {
		return centroGestion;
	}

	public void setCentroGestion(String centroGestion) {
		this.centroGestion = centroGestion;
	}

	public String getNombreTercero() {
		return nombreTercero;
	}

	public void setNombreTercero(String nombreTercero) {
		this.nombreTercero = nombreTercero;
	}

	public String getGlosaVoucher() {
		return glosaVoucher;
	}

	public void setGlosaVoucher(String glosaVoucher) {
		this.glosaVoucher = glosaVoucher;
	}

	public String getDescripcionInterfaz() {
		return descripcionInterfaz;
	}

	public void setDescripcionInterfaz(String descripcionInterfaz) {
		this.descripcionInterfaz = descripcionInterfaz;
	}

	public String getPeriodoInterfaz() {
		return periodoInterfaz;
	}

	public void setPeriodoInterfaz(String periodoInterfaz) {
		this.periodoInterfaz = periodoInterfaz;
	}

	public String getFechaDocumento() {
		return fechaDocumento;
	}

	public void setFechaDocumento(String fechaDocumento) {
		this.fechaDocumento = fechaDocumento;
	}

}