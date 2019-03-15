package com.integra.contabilidad.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.integra.contabilidad.util.Utilitarios;

public class ControlEnvioAsiento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int codigoAsiento; // validar si es necesario
	private String uuid;
	private String nombreArchivo;
	private String fondo;
	private String empresa;
	private String codigoUsuarioCreacion;
	private String nombreCompletoUsuarioCreacion;
	private String nombreProceso;
	private String usuarioWindows;
	private String estadoPremium;
	private String estadoIDI;
	private String fecha;
	private String periodo;
	private String year;
	private String mes;
	private String tipoModalidad;
	private String provisionPago;
	private BigDecimal importeTotalDebe;
	private BigDecimal importeTotalHaber;
    private BigDecimal importeCuotaDebe;
    private BigDecimal importeCuotaHaber;
    private int resultadoValidacionMovimiento;
    private int cantidadRegistros;
    private boolean flagProcesar;
    private boolean enabledFactura;
    private boolean enabledValidacion1;
    private boolean enabledValidacion2;
    private boolean checkedFactura;
    private boolean checkedValidacion1;
    private boolean checkedValidacion2;
    private boolean checkedValidacion3;
    private String comentario;
    private String resultadoPremium;
    private String resultadoIDI;
    private List<AsientoContable> asientosContablesPremium;
    private List<AsientoContable> asientosContablesIDI;

	public ControlEnvioAsiento() {
		super();
		this.importeTotalDebe = BigDecimal.ZERO;
		this.importeTotalHaber = BigDecimal.ZERO;
		this.importeCuotaDebe = BigDecimal.ZERO;
		this.importeCuotaHaber = BigDecimal.ZERO;
	}

	public int getCodigoAsiento() {
		return codigoAsiento;
	}

	public void setCodigoAsiento(int codigoAsiento) {
		this.codigoAsiento = codigoAsiento;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getFondo() {
		return fondo;
	}

	public void setFondo(String fondo) {
		this.fondo = fondo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getCodigoUsuarioCreacion() {
		return codigoUsuarioCreacion;
	}

	public void setCodigoUsuarioCreacion(String codigoUsuarioCreacion) {
		this.codigoUsuarioCreacion = codigoUsuarioCreacion;
	}

	public String getNombreCompletoUsuarioCreacion() {
		return nombreCompletoUsuarioCreacion;
	}

	public void setNombreCompletoUsuarioCreacion(String nombreCompletoUsuarioCreacion) {
		this.nombreCompletoUsuarioCreacion = nombreCompletoUsuarioCreacion;
	}

	public String getNombreProceso() {
		return nombreProceso;
	}

	public void setNombreProceso(String nombreProceso) {
		this.nombreProceso = nombreProceso;
	}

	public String getUsuarioWindows() {
		return usuarioWindows;
	}

	public void setUsuarioWindows(String usuarioWindows) {
		this.usuarioWindows = usuarioWindows;
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

	public String getFecha() {
		if (!Utilitarios.isNullOrEmpty(getNombreArchivo())) {
			fecha = getNombreArchivo().substring(25, 27) + "/" + getNombreArchivo().substring(23, 25) + "/" + getNombreArchivo().substring(19, 23);
		}
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getPeriodo() {
		if (!Utilitarios.isNullOrEmpty(getNombreArchivo())) {
			periodo = getNombreArchivo().substring(12, 16) + "/" + getNombreArchivo().substring(16, 18);
		}
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	public String getYear() {
		if (!Utilitarios.isNullOrEmpty(getNombreArchivo())) {
			year = getNombreArchivo().substring(19, 23);
		}
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMes() {
		if (!Utilitarios.isNullOrEmpty(getNombreArchivo())) {
			mes = getNombreArchivo().substring(23, 25);
		}
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getTipoModalidad() {
		if (getNombreArchivo() != null && !"".equals(getNombreArchivo())) {
			tipoModalidad = getNombreArchivo().substring(5, 11);
		}
		return tipoModalidad;
	}

	public void setTipoModalidad(String tipoModalidad) {
		this.tipoModalidad = tipoModalidad;
	}

	public BigDecimal getImporteTotalDebe() {
		return importeTotalDebe;
	}

	public void setImporteTotalDebe(BigDecimal importeTotalDebe) {
		this.importeTotalDebe = importeTotalDebe;
	}

	public BigDecimal getImporteTotalHaber() {
		return importeTotalHaber;
	}

	public void setImporteTotalHaber(BigDecimal importeTotalHaber) {
		this.importeTotalHaber = importeTotalHaber;
	}

	public BigDecimal getImporteCuotaDebe() {
		return importeCuotaDebe;
	}

	public void setImporteCuotaDebe(BigDecimal importeCuotaDebe) {
		this.importeCuotaDebe = importeCuotaDebe;
	}

	public BigDecimal getImporteCuotaHaber() {
		return importeCuotaHaber;
	}

	public void setImporteCuotaHaber(BigDecimal importeCuotaHaber) {
		this.importeCuotaHaber = importeCuotaHaber;
	}
	
	public String getProvisionPago() {
		return provisionPago;
	}

	public void setProvisionPago(String provisionPago) {
		this.provisionPago = provisionPago;
	}

	public int getResultadoValidacionMovimiento() {
		return resultadoValidacionMovimiento;
	}

	public void setResultadoValidacionMovimiento(int resultadoValidacionMovimiento) {
		this.resultadoValidacionMovimiento = resultadoValidacionMovimiento;
	}

	public int getCantidadRegistros() {
		return cantidadRegistros;
	}

	public void setCantidadRegistros(int cantidadRegistros) {
		this.cantidadRegistros = cantidadRegistros;
	}

	public boolean isFlagProcesar() {
		return flagProcesar;
	}

	public void setFlagProcesar(boolean flagProcesar) {
		this.flagProcesar = flagProcesar;
	}

	public boolean isEnabledFactura() {
		return enabledFactura;
	}

	public void setEnabledFactura(boolean enabledFactura) {
		this.enabledFactura = enabledFactura;
	}

	public boolean isEnabledValidacion1() {
		return enabledValidacion1;
	}

	public void setEnabledValidacion1(boolean enabledValidacion1) {
		this.enabledValidacion1 = enabledValidacion1;
	}

	public boolean isEnabledValidacion2() {
		return enabledValidacion2;
	}

	public void setEnabledValidacion2(boolean enabledValidacion2) {
		this.enabledValidacion2 = enabledValidacion2;
	}

	public boolean isCheckedFactura() {
		return checkedFactura;
	}

	public void setCheckedFactura(boolean checkedFactura) {
		this.checkedFactura = checkedFactura;
	}

	public boolean isCheckedValidacion1() {
		return checkedValidacion1;
	}

	public void setCheckedValidacion1(boolean checkedValidacion1) {
		this.checkedValidacion1 = checkedValidacion1;
	}

	public boolean isCheckedValidacion2() {
		return checkedValidacion2;
	}

	public void setCheckedValidacion2(boolean checkedValidacion2) {
		this.checkedValidacion2 = checkedValidacion2;
	}

	public boolean isCheckedValidacion3() {
		return checkedValidacion3;
	}

	public void setCheckedValidacion3(boolean checkedValidacion3) {
		this.checkedValidacion3 = checkedValidacion3;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getResultadoPremium() {
		return resultadoPremium;
	}

	public void setResultadoPremium(String resultadoPremium) {
		this.resultadoPremium = resultadoPremium;
	}

	public String getResultadoIDI() {
		return resultadoIDI;
	}

	public void setResultadoIDI(String resultadoIDI) {
		this.resultadoIDI = resultadoIDI;
	}

	public List<AsientoContable> getAsientosContablesPremium() {
		return asientosContablesPremium;
	}

	public void setAsientosContablesPremium(List<AsientoContable> asientosContablesPremium) {
		this.asientosContablesPremium = asientosContablesPremium;
	}

	public List<AsientoContable> getAsientosContablesIDI() {
		return asientosContablesIDI;
	}

	public void setAsientosContablesIDI(List<AsientoContable> asientosContablesIDI) {
		this.asientosContablesIDI = asientosContablesIDI;
	}
	
}