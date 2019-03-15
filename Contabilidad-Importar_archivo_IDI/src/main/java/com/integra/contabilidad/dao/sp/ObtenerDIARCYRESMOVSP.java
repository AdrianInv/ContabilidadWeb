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
import org.springframework.jdbc.object.StoredProcedure;

import com.integra.contabilidad.util.Procedimientos;

public class ObtenerDIARCYRESMOVSP extends StoredProcedure {
	
	public ObtenerDIARCYRESMOVSP(DataSource ds) {
		setDataSource(ds);
		setSql(Procedimientos.OBTENER_DIA_HABIL_Y_RESMOV);
		
		declareParameter(new SqlOutParameter("@FECHA", Types.VARCHAR));
		declareParameter(new SqlOutParameter("@RESMOV", Types.INTEGER));
		compile();
	}
	
	public Map<String, Object> executeProcedure() {
		Map<String, Object> out = super.execute();
		Map<String, Object> result = new HashMap<>();
		result.put("fechaHabil", out.get("@FECHA"));
		result.put("cantRegistros", out.get("@RESMOV"));
		
		return result;
	}

}