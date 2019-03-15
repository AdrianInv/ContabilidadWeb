package com.integra.contabilidad.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.integra.contabilidad.bean.ControlEnvioAsiento;
import com.integra.contabilidad.reporte.bean.ValidacionArchivoPlano;

import net.sf.jasperreports.engine.JRException;

public interface ImportaArchivoIDIService {

	public byte[] emitirReporteValidacion(List<List<ValidacionArchivoPlano>> listaValidacionesArchivoPlano, String nombreEmpresa) throws IOException, JRException;
	
	public Map<String, Object> procesar(String parametros) throws IOException;

	public byte[] emitirReporteImportacion(String parametros) throws IOException, JRException;
	
	// PSC004
	public List<ControlEnvioAsiento> listarArchivosTransferenciaPREMIUM(String fondo, String empresa, String usuarioWindows);
	
	public Map<String, Object> validarAsientos(List<ControlEnvioAsiento> archivosSelecionados);
	
	public List<ControlEnvioAsiento> filtrarAsientos(List<ControlEnvioAsiento> listaArchivosSelecionados, String year, String mes) throws ParseException;
	
}