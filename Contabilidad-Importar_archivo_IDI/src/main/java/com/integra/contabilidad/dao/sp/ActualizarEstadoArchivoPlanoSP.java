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

import com.integra.contabilidad.bean.ArchivoPlanoEstado;
import com.integra.contabilidad.util.Procedimientos;

public class ActualizarEstadoArchivoPlanoSP extends StoredProcedure {
	
	public ActualizarEstadoArchivoPlanoSP(DataSource ds) {
		setDataSource(ds);
		setSql(Procedimientos.ACTUALIZAR_ESTADO_IMPORTACION_ARCHIVO_PLANO);
		
		declareParameter(new SqlParameter("@nombreArchivo", Types.VARCHAR));
		declareParameter(new SqlParameter("@estado_premium", Types.VARCHAR));
		declareParameter(new SqlParameter("@estado_idi", Types.VARCHAR));
		compile();
	}
	
	public void executeProcedure(ArchivoPlanoEstado archivoPlanoEstado) {
		Map<String, Object> parametrosIn = new HashMap<>();
		parametrosIn.put("@nombreArchivo", archivoPlanoEstado.getNombreArchivo());
		parametrosIn.put("@estado_premium", archivoPlanoEstado.getEstadoPremium());
		parametrosIn.put("@estado_idi", archivoPlanoEstado.getEstadoIDI());
		
		super.execute(parametrosIn);
	}

}