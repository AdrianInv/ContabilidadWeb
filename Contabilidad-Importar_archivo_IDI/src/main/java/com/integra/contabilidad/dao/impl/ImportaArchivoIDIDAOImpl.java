/**
 * ************************************************************************************
 * Fecha de Creación        : 12/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.dao.impl;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.integra.contabilidad.bean.ArchivoImportadoIDI;
import com.integra.contabilidad.bean.ArchivoPlanoEstado;
import com.integra.contabilidad.dao.ImportaArchivoIDIDAO;
import com.integra.contabilidad.dao.sp.ActualizarEstadoArchivoPlanoSP;
import com.integra.contabilidad.dao.sp.ActualizarImportacionArchivoPlanoSP;
import com.integra.contabilidad.dao.sp.AsociarVoucherLoteSP;
import com.integra.contabilidad.dao.sp.EjecutarDTSCargaMovimientosContablesSP;
import com.integra.contabilidad.dao.sp.EliminarRangoImpresionSP;
import com.integra.contabilidad.dao.sp.EmitirReporteImportacionSP;
import com.integra.contabilidad.dao.sp.ImportaInformacionArchivoPlanoSP;
import com.integra.contabilidad.dao.sp.IngresarImportacionArchivoPlanosSP;
import com.integra.contabilidad.dao.sp.ObtenerSumaImportesCargadosPatrimonioSP;
import com.integra.contabilidad.reporte.bean.ReporteArchivoPlanoImportado;

@Repository
public class ImportaArchivoIDIDAOImpl implements ImportaArchivoIDIDAO {

	@Qualifier("dsConta04")
	@Autowired
	private DataSource dsContabilidadConta04;
	
	@Qualifier("dsConta03")
	@Autowired
	private DataSource dsContabilidadConta03;
	
	/*
	 * @Qualifier("dsPremMain")
	 * 
	 * @Autowired private DataSource dsContabilidadPremMain;
	 */
	
	@Qualifier("dsTesoreria")
	@Autowired
	private DataSource dsContabilidadTesoreria;
	
	/*@Override
	public Map<String, Object> listarParametros() {
		ListarParametrosSP sp = new ListarParametrosSP(dsContabilidadPremMain);
		return sp.executeProcedure();
	}

	@Override
	public ArchivoPlanoEstado obtenerEstadoArchivo(ArchivoImportadoIDI archivo, String codigoEmpresa) {
		ObtenerEstadoArchivoIDISP sp = new ObtenerEstadoArchivoIDISP(dsContabilidad(codigoEmpresa));
		return sp.executeProcedure(archivo);
	}
	
	@Override // copia
	public void obtenerEstadoRealesArchivo(ControlEnvioAsiento archivo) {
		ObtenerEstadoArchivoPlanoSP sp = new ObtenerEstadoArchivoPlanoSP(dsContabilidad(archivo.getEmpresa()));
		sp.executeProcedure(archivo);
	}*/
	
	
	
	@Override
	public void ingresarImportacionArchivoPlano(ArchivoImportadoIDI archivo, String usuarioWindows,
			String codigoEmpresa) {
		IngresarImportacionArchivoPlanosSP sp = new IngresarImportacionArchivoPlanosSP(dsContabilidad(codigoEmpresa));
		sp.executeProcedure(archivo, usuarioWindows);
	}
	
	@Override
	public Map<String, Object> importarInformacion(String codigoUsuario, String codigoFondo, String codigoEmpresa) {
		ImportaInformacionArchivoPlanoSP sp = new ImportaInformacionArchivoPlanoSP(dsContabilidad(codigoEmpresa));
		return sp.executeProcedure(codigoUsuario, codigoFondo);
	}
	
	@Override
	public void actualizarEstadoArchivo(ArchivoPlanoEstado archivoPlanoEstado, String codigoEmpresa) {
		ActualizarEstadoArchivoPlanoSP sp = new ActualizarEstadoArchivoPlanoSP(dsContabilidad(codigoEmpresa));
		sp.executeProcedure(archivoPlanoEstado);
	}
	
	@Override
	public void asociarVoucherLote(ArchivoImportadoIDI archivo, String codigoEmpresa) {
		AsociarVoucherLoteSP sp = new AsociarVoucherLoteSP(dsContabilidad(codigoEmpresa));
		sp.executeProcedure(archivo);
	}

	@Override
	public void eliminarRangoImpresion(String codigoUsuario, String codigoEmpresa) {
		EliminarRangoImpresionSP sp = new EliminarRangoImpresionSP(dsContabilidad(codigoEmpresa));
		sp.executeProcedure(codigoUsuario);
	}
	
	@Override
	public void ejecutarDTSCargaMovimientosContablesPREMIUM(ArchivoImportadoIDI archivo, String rutaIDI) {
		EjecutarDTSCargaMovimientosContablesSP sp = new EjecutarDTSCargaMovimientosContablesSP(dsContabilidadTesoreria);
		sp.executeProcedure(archivo, rutaIDI);
	}

	@Override
	public ArchivoImportadoIDI obtenerSumaImportesCargadosPatrimonio(ArchivoImportadoIDI archivo) {
		ObtenerSumaImportesCargadosPatrimonioSP sp = new ObtenerSumaImportesCargadosPatrimonioSP(dsContabilidadTesoreria);
		return sp.executeProcedure(archivo);
	}
	
	@Override
	public void actualizarImportacion(ArchivoImportadoIDI archivo, String codigoEmpresa) {
		ActualizarImportacionArchivoPlanoSP sp = new ActualizarImportacionArchivoPlanoSP(dsContabilidad(codigoEmpresa));
		sp.executeProcedure(archivo);
	}
	
	@Override
	public List<ReporteArchivoPlanoImportado> emitirReporteImportacion(String codigoUsuario, String codigoEmpresa) {
		EmitirReporteImportacionSP sp = new EmitirReporteImportacionSP(dsContabilidad(codigoEmpresa));
		return sp.executeProcedure(codigoUsuario);
	}
	
	private DataSource dsContabilidad(String codigoEmpresa) {
		if ("04".equals(codigoEmpresa)) {
			return dsContabilidadConta04;
		} else if ("03".equals(codigoEmpresa)) {
			return dsContabilidadConta03;
		}
		return dsContabilidadConta04;
	}

}