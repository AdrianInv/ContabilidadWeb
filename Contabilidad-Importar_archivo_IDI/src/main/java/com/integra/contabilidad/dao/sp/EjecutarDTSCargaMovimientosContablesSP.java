/**
 * ************************************************************************************
 * Fecha de Creación        : 09/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.dao.sp;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.integra.contabilidad.bean.ArchivoImportadoIDI;
import com.integra.contabilidad.util.Constantes;
import com.integra.contabilidad.util.Procedimientos;

public class EjecutarDTSCargaMovimientosContablesSP extends StoredProcedure {
	
	public EjecutarDTSCargaMovimientosContablesSP(DataSource ds) {
		setDataSource(ds);
		setSql(Procedimientos.EJECUTAR_DTS_CARGA_MOVIMIENTOS_CONTABLES);
		
		declareParameter(new SqlParameter("@p_Sistema", Types.VARCHAR));
		declareParameter(new SqlParameter("@p_Modulo", Types.VARCHAR));
		declareParameter(new SqlParameter("@p_TipoModalidad", Types.VARCHAR));
		declareParameter(new SqlParameter("@p_TipoPago", Types.VARCHAR));
		declareParameter(new SqlParameter("@p_RutaArchivo", Types.VARCHAR));
		declareParameter(new SqlParameter("@p_Usuario", Types.VARCHAR));
		declareParameter(new SqlParameter("@p_Contador", Types.INTEGER));
		declareParameter(new SqlParameter("@p_FechaInforme", Types.NUMERIC));
		declareParameter(new SqlOutParameter("@p_IdCarga", Types.NUMERIC));
		declareParameter(new SqlOutParameter("@p_EstadoCarga", Types.INTEGER));
		declareParameter(new SqlOutParameter("@p_Mensaje", Types.VARCHAR));
		
		compile();
	}
	
	public void executeProcedure(ArchivoImportadoIDI archivo, String rutaIDI) {
		Map<String, Object> parametrosIn = new HashMap<>();
		parametrosIn.put("@p_Sistema", Constantes.MOVIMIENTO_CONTABLE_SISTEMA);
		parametrosIn.put("@p_Modulo", Constantes.MOVIMIENTO_CONTABLE_MODULO);
		parametrosIn.put("@p_TipoModalidad", archivo.getTipoModalidad());
		parametrosIn.put("@p_TipoPago", archivo.getProvisionPago());
		parametrosIn.put("@p_RutaArchivo", rutaIDI + archivo.getArchivoIDI());
		parametrosIn.put("@p_Usuario", archivo.getUsuarioWindows());
		parametrosIn.put("@p_Contador", 0);
		parametrosIn.put("@p_FechaInforme", Integer.parseInt(archivo.getFechaFormatoAS400()));
		
		super.execute(parametrosIn);
	}

}