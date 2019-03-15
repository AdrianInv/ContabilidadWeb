/**
 * ************************************************************************************
 * Fecha de Creación        : 12/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.dao;

import java.util.List;
import java.util.Map;

import com.integra.contabilidad.bean.ArchivoImportadoIDI;
import com.integra.contabilidad.bean.ArchivoPlanoEstado;
import com.integra.contabilidad.reporte.bean.ReporteArchivoPlanoImportado;

public interface ImportaArchivoIDIDAO {

	//public Map<String, Object> listarParametros();

	//public ArchivoPlanoEstado obtenerEstadoArchivo(ArchivoImportadoIDI archivo, String codigoEmpresa);
	
	//public void obtenerEstadoRealesArchivo(ControlEnvioAsiento archivo); // 

	

	public void ingresarImportacionArchivoPlano(ArchivoImportadoIDI archivo, String usuarioWindows,
			String codigoEmpresa);

	public Map<String, Object> importarInformacion(String codigoUsuario, String codigoFondo, String codigoEmpresa);

	public void actualizarEstadoArchivo(ArchivoPlanoEstado archivoPlanoEstado, String codigoEmpresa);

	public void asociarVoucherLote(ArchivoImportadoIDI archivo, String codigoEmpresa);

	public void eliminarRangoImpresion(String codigoUsuario, String codigoEmpresa);

	public void ejecutarDTSCargaMovimientosContablesPREMIUM(ArchivoImportadoIDI archivo, String rutaIDI);

	public ArchivoImportadoIDI obtenerSumaImportesCargadosPatrimonio(ArchivoImportadoIDI archivo);

	public void actualizarImportacion(ArchivoImportadoIDI archivo, String codigoEmpresa);

	public List<ReporteArchivoPlanoImportado> emitirReporteImportacion(String codigoUsuario, String codigoEmpresa);
	
	
	
}