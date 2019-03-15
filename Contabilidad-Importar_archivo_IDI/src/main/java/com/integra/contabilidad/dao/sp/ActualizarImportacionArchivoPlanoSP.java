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

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.integra.contabilidad.bean.ArchivoImportadoIDI;
import com.integra.contabilidad.util.Procedimientos;

public class ActualizarImportacionArchivoPlanoSP extends StoredProcedure {
	
	public ActualizarImportacionArchivoPlanoSP(DataSource ds) {
		setDataSource(ds);
		setSql(Procedimientos.ACTUALIZAR_IMPORTACION_ARCHIVO_PLANO);
		
		declareParameter(new SqlParameter("@usuarioWindows", Types.VARCHAR));
		declareParameter(new SqlParameter("@nombreArchivo", Types.VARCHAR));
		declareParameter(new SqlParameter("@sumas_del_idi", Types.NUMERIC));
		declareParameter(new SqlParameter("@tipo_movimiento_idi", Types.VARCHAR));
		declareParameter(new SqlParameter("@cantidad_registros_idi", Types.INTEGER));
		
		compile();
	}
	
	public void executeProcedure(ArchivoImportadoIDI archivo) {
		Map<String, Object> parametrosIn = new HashMap<>();
		parametrosIn.put("@usuarioWindows", archivo.getUsuarioWindows());
		parametrosIn.put("@nombreArchivo", archivo.getArchivoIDI());
		parametrosIn.put("@sumas_del_idi", archivo.getSumasIDI());
		parametrosIn.put("@tipo_movimiento_idi", archivo.getTipoMovimientoIDI());
		parametrosIn.put("@cantidad_registros_idi", archivo.getCantidadRegistrosIDI());
		
		super.execute(parametrosIn);
	}

}