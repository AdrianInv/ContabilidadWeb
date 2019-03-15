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

import com.google.gson.annotations.Expose;
import com.integra.contabilidad.util.Utilitarios.ConversionBigDecimal;

public class ArchivoImportadoIDIDetalle implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Expose
	private String fila;
	@Expose
    private int numeroRegistro;
    private String codigoEmpresa;
    private String codigoLibroAuxiliar;
    private String numeroVoucher;
    private BigDecimal correlativoVoucher;
    private String codigoCentroCosto;
    private String tipoCuentaCorrienteTercero;
    private String codigoCuentaCorrienteTercero;
    private String codigoTipoAsiento;
    private String codigoCuentaContable;
    private String codigoTipoDocumento;
    private BigDecimal debe;
    private BigDecimal haber;
    private BigDecimal cuotaDebe;
    private BigDecimal cuotaHaber;
    private String numeroDocumento;
    private String fechaVencimiento;
    private String tipoMoneda;
    private BigDecimal tipoCambioMovimiento;
    private BigDecimal valorOtraMonedaMovimiento;
    private String fechaDocumento;
    private String fechaDocumentoRel;
    private String tipoDocumentoRel;
    private String numeroDocumentoRel;
    private String codigoCentroGestion;
    private String nombreCuentaCorrienteTercero;
    private String glosaVoucher;
    private String descripcionArchivoInterfase;
    
    public ArchivoImportadoIDIDetalle(String fila, int numeroRegistro) {
        this.fila = fila;
        this.numeroRegistro = numeroRegistro;
    }

    public ArchivoImportadoIDIDetalle() {
    }

    public String getFila() {
        return fila;
    }

    public String getCodigoEmpresa() {
    	if (fila != null) {
    		codigoEmpresa = fila.substring(6, 8).trim();
    	}
        return codigoEmpresa;
    }

    public String getCodigoLibroAuxiliar() {
    	if (fila != null) {
    		codigoLibroAuxiliar = fila.substring(8, 10).trim();
    	}
        return codigoLibroAuxiliar;
    }

    public String getNumeroVoucher() {
    	if (fila != null) {
    		 numeroVoucher = fila.substring(10, 15).trim();
    	}
    	return numeroVoucher;
    }

    public BigDecimal getCorrelativoVoucher() {
    	if (fila != null) {
    		correlativoVoucher = ConversionBigDecimal.forceBigDecimal(fila.substring(15, 20).trim());
    	}
        return correlativoVoucher;
    }

    public String getCodigoTipoAsiento() {
    	if (fila != null) {
    		codigoTipoAsiento = fila.substring(28, 33).trim();
    	}
        return codigoTipoAsiento;
    }

    public String getCodigoCuentaContable() {
    	if (fila != null) {
    		codigoCuentaContable = fila.substring(33, 48).trim();
    	}
        return codigoCuentaContable;
    }

    public String getCodigoCentroCosto() {
    	if (fila != null) {
    		codigoCentroCosto = fila.substring(48, 60).trim(); 
    	}
        return codigoCentroCosto;
    }

    public String getCodigoCuentaCorrienteTercero() {
    	if (fila != null) {
    		codigoCuentaCorrienteTercero = fila.substring(60, 76).trim();
    	}
        return codigoCuentaCorrienteTercero;
    }
    
    public String getTipoCuentaCorrienteTercero() {
    	if (fila != null) {
    		tipoCuentaCorrienteTercero = fila.substring(76, 78).trim();
    	}
    	return tipoCuentaCorrienteTercero;
    }

    public String getCodigoTipoDocumento() {
    	if (fila != null) {
    		codigoTipoDocumento = fila.substring(78, 80).trim();
    	}
        return codigoTipoDocumento;
    }

    public String getNumeroDocumento() {
    	if (fila != null) {
    		numeroDocumento = fila.substring(80, 92).trim();
    	}
        return numeroDocumento;
    }

    public String getFechaVencimiento() {
    	if (fila != null) {
    		fechaVencimiento = fila.substring(98, 100).trim() + "/" + fila.substring(96, 98).trim() + "/" + fila.substring(92, 96).trim();
    	}
        return fechaVencimiento;
    }

    public BigDecimal getDebe() {
    	if (fila != null) {
    		debe = ConversionBigDecimal.forceBigDecimal(fila.substring(100, 113).trim());
    	}
        return debe;
    }
    
    public BigDecimal getHaber() {
    	if (fila != null) {
    		haber = ConversionBigDecimal.forceBigDecimal(fila.substring(113, 126).trim());
    	}
        return haber;
    }

    public BigDecimal getCuotaDebe() {
    	if (fila != null) {
    		cuotaDebe = ConversionBigDecimal.forceBigDecimal(fila.substring(140, 153).trim());
    	}
    	return cuotaDebe;
	}

	public BigDecimal getCuotaHaber() {
		if (fila != null) {
			cuotaHaber = ConversionBigDecimal.forceBigDecimal(fila.substring(140, 153).trim());
		}
		return cuotaHaber;
	}

	public String getTipoMoneda() {
		if (fila != null) {
			tipoMoneda = fila.substring(126, 127).trim();
		}
        return tipoMoneda;
    }

    public BigDecimal getTipoCambioMovimiento() {
    	if (fila != null) {
    		tipoCambioMovimiento = ConversionBigDecimal.forceBigDecimal(fila.substring(127, 140));
    	}
        return tipoCambioMovimiento;
    }

    public BigDecimal getValorOtraMonedaMovimiento() {
        if (fila != null) {
        	valorOtraMonedaMovimiento = "S".equals(getTipoMoneda()) ? BigDecimal.ZERO : ConversionBigDecimal.forceBigDecimal(this.fila.substring(140, 153));
        }
        return valorOtraMonedaMovimiento;
    }
    
    public String getCodigoCentroGestion() {
    	if (fila != null) {
    		codigoCentroGestion = fila.substring(153, 159).trim();
    	}
        return codigoCentroGestion;
    }

    public String getNombreCuentaCorrienteTercero() {
    	if (fila != null) {
    		nombreCuentaCorrienteTercero = fila.substring(159, 209).trim();
    	}
    	return nombreCuentaCorrienteTercero;
    }

    public String getGlosaVoucher() {
    	if (fila != null) {
    		glosaVoucher = fila.substring(209, 289).trim();
    	}
        return glosaVoucher;
    }

    public String getDescripcionArchivoInterfase() {
    	if (fila != null) {
    		descripcionArchivoInterfase = fila.substring(289, 339).trim();
    	}
        return descripcionArchivoInterfase;
    }

    public int getNumeroRegistro() {
        return numeroRegistro;
    }
    
    public String getFechaDocumento() {
        if (fila != null) {
            String fecDoc = fila.length() == 345 ? "" : fila.substring(345, 347).trim() + "-" + fila.substring(347, 349).trim() + "-" + fila.substring(349, 353).trim();
            fechaDocumento = "--".equals(fecDoc) ? "" : fecDoc;			
        }
        return fechaDocumento;
    }

    public String getFechaDocumentoRel() {
        if (fila != null) {
            String fecDocRel = fila.length() == 382 ? fila.substring(355, 357).trim() + "-" + fila.substring(357, 359).trim() + "-" + fila.substring(359, 363).trim() : "";
            fechaDocumentoRel = "--".equals(fecDocRel) ? "" : fecDocRel;
        }
        return fechaDocumentoRel;
    }

    public String getTipoDocumentoRel() {
        if (fila != null) {
        	tipoDocumentoRel = fila.length() == 382 ? fila.substring(365, 367).trim() : "";
        }
        return tipoDocumentoRel;
    }
    
    public String getNumeroDocumentoRel() {
        if (fila != null) {
        	numeroDocumentoRel = fila.length() == 382 ? fila.substring(367, 382).trim() : "";
        }
        return numeroDocumentoRel;
    }
    
}