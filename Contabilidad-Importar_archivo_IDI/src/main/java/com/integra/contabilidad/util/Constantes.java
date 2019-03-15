/**
 * ************************************************************************************
 * Fecha de Creación        : 09/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public final class Constantes {

	private Constantes() {}
	
	// Estados Archivos
	public static final String ESTADO_ARCHIVO_PENDIENTE = "Pendiente";
	public static final String ESTADO_ARCHIVO_FALTANTE = "Faltante";
	public static final String ESTADO_ARCHIVO_CONFORME = "Conforme";
	
	// Asiento
	public static final String ESTADO_ASIENTO_ERROR = "ERR";
	public static final String ESTADO_ASIENTO_GENERADO = "GEN";
	
	// Movimientos contables
	public static final String MOVIMIENTO_CONTABLE_SISTEMA = "IDI";
	public static final String MOVIMIENTO_CONTABLE_MODULO = "MOVIMIENTOCONTABLEPREMIUM";
	
	// Parametria parametros
	public static final String PARAMETRO_CODIGO_TAB = "035";
	public static final String PARAMETRO_CODIGO_ITEM = "-1";
	
	// Map Parametros
	public static final String KEY_PARAMETROS = "parametros";
	public static final String KEY_USUARIO_WINDOWS = "codigoUsuario";
	public static final String KEY_RUTA_PREMIUM = "RutaPrem";
	public static final String KEY_RUTA_PREMIUM_HISTORICA = "RutaPreHis";
	public static final String KEY_RUTA_IDI = "RutaIdI";
	public static final String KEY_RUTA_IDI_HISTORICA = "RutaIDIHis";
	public static final String KEY_DOMINIO_SMB = "dominioSmb";
	public static final String KEY_USUARIO_SMB = "usuarioSmb";
	public static final String KEY_CLAVE_SMB = "claveSmb";
	public static final String KEY_CODIGO_FONDO = "codigoFondo";
	public static final String KEY_PERIODO_YEAR = "periodoYear";
	public static final String KEY_PERIODO_MES = "periodoMes";
	public static final String KEY_CODIGO_EMPRESA = "codigoEmpresa";
	public static final String KEY_NOMBRE_EMPRESA = "nombreEmpresa";
	public static final String KEY_RUC_EMPRESA = "rucEmpresa";
	public static final String KEY_PERIODO = "periodo";
	
	// Parametros reporte importacion
	public static final String KEY_REPORTE_IMPORTACION_RUC_EMPRESA = "rucEmpresa";
	public static final String KEY_REPORTE_IMPORTACION_PERIODO = "periodo";
	
	// Status Rest Service
	public static final String KEY_STATUS = "status";
	public static final String KEY_MENSAJE = "mensaje";
	public static final String STATUS_OK = "OK";
	public static final String STATUS_ERROR = "ERROR";
	public static final String STATUS_NOT_FOUND = "NOT FOUND";
	
	// Extensiones Archivo
	public static final String EXTENSION_FILE_TXT = ".txt";
	public static final String EXTENSION_FILE_PDF = ".pdf";
	public static final String EXTENSION_FILE_JASPER = ".jasper";
	public static final String EXTENSION_FILE_JRXML = ".jrxml";
	
	// Reportes
	public static final String RUTA_REPORTE = "src/main/resources/reportes/";
	public static final String NOMBRE_REPORTE_VALIDACION = "ImpoInfo";
	public static final String NOMBRE_REPORTE_RESULTADO_IMPORTACION = "rptImportaIDIresultados";
	
	// Mensaje
	public static final String MENSAJE_ARCHIVO_LISTO_PARA_PROCESAR = "El archivo está listo para ser procesado";
	public static final String MENSAJE_ARCHIVO_NO_PENDIENTE_PARA_PROCESAR = "El archivo no está pendiente para procesar";
	public static final String MENSAJE_ARCHIVO_NO_PERTENCE_PERIODO_ACTUAL = "El archivo no pertence al Periodo Actual";
	
	// 
	public static final String FECHA_FORMATO_AS400 = "yyyyMMdd";
	public static final String FECHA_FORMATO_AS400_2 = "ddMMyyyy";
	public static final String FECHA_FORMATO_DD_MM_YYYY = "dd-MM-yyyy";
	public static final String FECHA_FORMATO_YYYY_MM_DD = "yyyy/MM/dd";
	
	// Parametros
	public static String periodoYear;
	
	public static String getPeriodoYear() {
		return periodoYear;
	}

	@Value("${parametro.periodoYear}")
	public void setPeriodoYear(String periodoYear) {
		Constantes.periodoYear = periodoYear;
	}

}