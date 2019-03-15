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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.integra.contabilidad.util.Constantes;

public class ArchivoImportadoIDI implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Expose
	private String uuid;
	
	private String nombreArchivo;
	
	@Expose
	private String archivoPremium;
	
	@Expose
	private String archivoIDI;
	
	@Expose
	private String indicadorPago;
	
	private String descripcion;
	
	private String estadoInicialPremium;
	
	private String estadoInicialIDI;
	
	@Expose
	private String estadoFinalPremium;
	
	@Expose
	private String estadoFinalIDI;
	
    private String codigoFondo;
    
    private String usuarioWindows;
    
    @Expose
    private String codigoUsuario;
    
    @Expose
    private String apellidoPaterno;
    
    @Expose
    private String primerNombre;
    
    @Expose
    private String nombreCompletoUsuario;
    
    @Expose
    private String motivo;
    
    @Expose
    private String fecha;
    
    private String fechaFormatoAS400;
    
    @Expose
    private String periodo;
    
    private String year;
    
    private String mes;
    
    @Expose
    private String empresa;
    
    @Expose
    private String provisionPago;
    
    @Expose
    private BigDecimal importeTotalDebe;
    
    @Expose
    private BigDecimal importeTotalHaber;
    
    @Expose
    private BigDecimal importeCuotaDebe;
    
    @Expose
    private BigDecimal importeCuotaHaber;
    
    @Expose
    private int cantidadRegistros;
    
    private String tipoModalidad;
    
    private BigDecimal sumasIDI;
    
    private String tipoMovimientoIDI;
    
    private int cantidadRegistrosIDI;
    
    @Expose
    private boolean flagProcesar;
    
    @Expose
    private boolean enabledFactura;
    
    @Expose
    private boolean enabledValidacion1;
    
    @Expose
    private boolean enabledValidacion2;
    
    @Expose
    private boolean checkedFactura;
    
    @Expose
    private boolean checkedValidacion1;
    
    @Expose
    private boolean checkedValidacion2;
    
    @Expose
    private boolean checkedValidacion3;
    
    @Expose
    private String comentario;
    
    @Expose
    private String resultadoPremium;
    
    @Expose
    private String resultadoIDI;
    
    @Expose
    private List<ArchivoImportadoIDIDetalle> detalle;

	public ArchivoImportadoIDI() {
		detalle = new ArrayList<>();
	}
    
    public String getUuid() {
		return uuid != null ? uuid : "";
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getNombreArchivo() {
		if (archivoPremium != null || archivoIDI != null) {
			nombreArchivo = archivoPremium != null ? archivoPremium : archivoIDI;
		}
		return nombreArchivo;
	}
	
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getArchivoPremium() {
		return archivoPremium;
	}

	public void setArchivoPremium(String archivoPremium) {
		this.archivoPremium = archivoPremium;
	}

	public String getArchivoIDI() {
		return archivoIDI;
	}

	public void setArchivoIDI(String archivoIDI) {
		this.archivoIDI = archivoIDI;
	}

	public String getIndicadorPago() {
		return indicadorPago != null ? indicadorPago : "";
	}

	public void setIndicadorPago(String indicadorPago) {
		this.indicadorPago = indicadorPago;
	}

	public String getDescripcion() {
		return descripcion != null ? descripcion : "";
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstadoInicialPremium() {
		if (archivoPremium != null) {
			estadoInicialPremium = Constantes.ESTADO_ARCHIVO_PENDIENTE;
		} else {
			estadoInicialPremium = Constantes.ESTADO_ARCHIVO_FALTANTE;
		}
		return estadoInicialPremium;
	}

	public void setEstadoInicialPremium(String estadoInicialPremium) {
		this.estadoInicialPremium = estadoInicialPremium;
	}

	public String getEstadoInicialIDI() {
		if (archivoPremium != null) {
			estadoInicialIDI = Constantes.ESTADO_ARCHIVO_PENDIENTE;
		} else {
			estadoInicialIDI = Constantes.ESTADO_ARCHIVO_FALTANTE;
		}
		return estadoInicialIDI;
	}

	public void setEstadoInicialIDI(String estadoInicialIDI) {
		this.estadoInicialIDI = estadoInicialIDI;
	}

	public String getEstadoFinalPremium() {
		return estadoFinalPremium;
	}

	public void setEstadoFinalPremium(String estadoFinalPremium) {
		this.estadoFinalPremium = estadoFinalPremium;
	}

	public String getEstadoFinalIDI() {
		return estadoFinalIDI;
	}

	public void setEstadoFinalIDI(String estadoFinalIDI) {
		this.estadoFinalIDI = estadoFinalIDI;
	}

	public String getCodigoFondo() {
		if (getNombreArchivo() != null) {
			codigoFondo = getNombreArchivo().substring(10, 11);
		}
		return codigoFondo;
	}

	public void setCodigoFondo(String codigoFondo) {
		this.codigoFondo = codigoFondo;
	}
	
	public String getUsuarioWindows() {
		return usuarioWindows;
	}

	public void setUsuarioWindows(String usuarioWindows) {
		this.usuarioWindows = usuarioWindows;
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getNombreCompletoUsuario() {
		if (apellidoPaterno != null && primerNombre != null) {
			nombreCompletoUsuario = apellidoPaterno + "," + primerNombre;
		}
		return nombreCompletoUsuario;
	}

	public void setNombreCompletoUsuario(String nombreCompletoUsuario) {
		this.nombreCompletoUsuario = nombreCompletoUsuario;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getFecha() {
		if (getNombreArchivo() != null) {
			fecha = getNombreArchivo().substring(25, 27) + "/" + getNombreArchivo().substring(23, 25) + "/" + getNombreArchivo().substring(19, 23);
		}
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getFechaFormatoAS400() { 
		if (getNombreArchivo() != null) {
			fechaFormatoAS400 = getNombreArchivo().substring(19, 23) + getNombreArchivo().substring(23, 25) + getNombreArchivo().substring(25, 27);
		}
		return fechaFormatoAS400;
	}

	public void setFechaFormatoAS400(String fechaFormatoAS400) {
		this.fechaFormatoAS400 = fechaFormatoAS400;
	}

	public String getPeriodo() {
		if (getNombreArchivo() != null) {
			periodo = getNombreArchivo().substring(12, 16) + "/" + getNombreArchivo().substring(16, 18);
		}
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getYear() {
		if (getNombreArchivo() != null) {
			year = getNombreArchivo().substring(19, 23);
		}
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMes() {
		if (getNombreArchivo() != null) {
			mes = getNombreArchivo().substring(23, 25);
		}
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getProvisionPago() {
		return provisionPago;
	}

	public void setProvisionPago(String provisionPago) {
		this.provisionPago = provisionPago;
	}

	public BigDecimal getImporteTotalDebe() {
		return importeTotalDebe != null ? importeTotalDebe : BigDecimal.ZERO;
	}

	public void setImporteTotalDebe(BigDecimal importeTotalDebe) {
		this.importeTotalDebe = importeTotalDebe;
	}

	public BigDecimal getImporteTotalHaber() {
		return importeTotalHaber != null ? importeTotalHaber : BigDecimal.ZERO;
	}

	public void setImporteTotalHaber(BigDecimal importeTotalHaber) {
		this.importeTotalHaber = importeTotalHaber;
	}

	public BigDecimal getImporteCuotaDebe() {
		return importeCuotaDebe != null ? importeCuotaDebe : BigDecimal.ZERO;
	}

	public void setImporteCuotaDebe(BigDecimal importeCuotaDebe) {
		this.importeCuotaDebe = importeCuotaDebe;
	}

	public BigDecimal getImporteCuotaHaber() {
		return importeCuotaHaber != null ? importeCuotaHaber : BigDecimal.ZERO;
	}

	public void setImporteCuotaHaber(BigDecimal importeCuotaHaber) {
		this.importeCuotaHaber = importeCuotaHaber;
	}

	public int getCantidadRegistros() {
		return cantidadRegistros;
	}

	public void setCantidadRegistros(int cantidadRegistros) {
		this.cantidadRegistros = cantidadRegistros;
	}

	public String getTipoModalidad() {
		tipoModalidad = archivoIDI != null ? archivoIDI.substring(5, 11) : "";
		return tipoModalidad;
	}

	public void setTipoModalidad(String tipoModalidad) {
		this.tipoModalidad = tipoModalidad;
	}

	public BigDecimal getSumasIDI() {
		return sumasIDI != null ? sumasIDI : BigDecimal.ZERO;
	}

	public void setSumasIDI(BigDecimal sumasIDI) {
		this.sumasIDI = sumasIDI;
	}

	public String getTipoMovimientoIDI() {
		return tipoMovimientoIDI != null ? tipoMovimientoIDI : "0";
	}

	public void setTipoMovimientoIDI(String tipoMovimientoIDI) {
		this.tipoMovimientoIDI = tipoMovimientoIDI;
	}

	public int getCantidadRegistrosIDI() {
		return cantidadRegistrosIDI;
	}

	public void setCantidadRegistrosIDI(int cantidadRegistrosIDI) {
		this.cantidadRegistrosIDI = cantidadRegistrosIDI;
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
		if (archivoPremium != null) {
			this.resultadoPremium = resultadoPremium;
		}
	}

	public String getResultadoIDI() {
		return resultadoIDI;
	}

	public void setResultadoIDI(String resultadoIDI) {
		if (archivoIDI != null) {
			this.resultadoIDI = resultadoIDI;
		}
	}

	public List<ArchivoImportadoIDIDetalle> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<ArchivoImportadoIDIDetalle> detalle) {
		this.detalle = detalle;
	}
	
}