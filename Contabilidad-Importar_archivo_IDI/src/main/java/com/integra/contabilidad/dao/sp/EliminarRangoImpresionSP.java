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

import com.integra.contabilidad.util.Procedimientos;

public class EliminarRangoImpresionSP extends StoredProcedure {
	
	public EliminarRangoImpresionSP(DataSource ds) {
		setDataSource(ds);
		setSql(Procedimientos.ELIMINAR_RANGO_IMPRESION);
		
		declareParameter(new SqlParameter("@cUsuario", Types.VARCHAR));
		declareParameter(new SqlParameter("@cProceso", Types.VARCHAR));
		declareParameter(new SqlOutParameter("@cMsgRetorno", Types.VARCHAR));
		
		compile();
	}
	
	public void executeProcedure(String codigoUsuario) {
		Map<String, Object> parametrosIn = new HashMap<>();
		parametrosIn.put("@cUsuario", codigoUsuario);
		parametrosIn.put("@cProceso", "VOUCHERS");
		super.execute(parametrosIn);
	}

}