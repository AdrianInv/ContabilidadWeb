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

import com.integra.contabilidad.util.Procedimientos;

public class EliminarImportacionArchivosPlanosSP  extends StoredProcedure {
	
	public EliminarImportacionArchivosPlanosSP(DataSource ds) {
		setDataSource(ds);
		setSql(Procedimientos.ELIMINAR_IMPORTACION_ARCHIVO_PLANO);
		
		declareParameter(new SqlParameter("@usuarioWindows", Types.VARCHAR));
		compile();
	}
	
	public void executeProcedure(String usuarioWindows) {
		Map<String, Object> parametrosIn = new HashMap<>();
		parametrosIn.put("@usuarioWindows", usuarioWindows);
		super.execute(parametrosIn);
	}

}