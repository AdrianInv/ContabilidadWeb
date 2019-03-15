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
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.integra.contabilidad.util.Procedimientos;

public class ObtenerValidacionMovimientoSP extends StoredProcedure {

	public ObtenerValidacionMovimientoSP(DataSource ds) {
		setDataSource(ds);
		setSql(Procedimientos.OBTENER_VALIDACION_MOVIMIENTO);
		
		declareParameter(new SqlParameter("@CANTREGRESMOV", Types.INTEGER));
		declareParameter(new SqlParameter("@FECHA", Types.VARCHAR));
		declareParameter(new SqlOutParameter("@VALOR", Types.INTEGER));
		compile();
	}
	
	public int executeProcedure(Map<String, Object> parametros) {
		Map<String, Object> out = super.execute(parametros);
		return Integer.parseInt(out.get("@VALOR").toString());
	}

}