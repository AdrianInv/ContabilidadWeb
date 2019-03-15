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

import com.integra.contabilidad.bean.LogImportacion;
import com.integra.contabilidad.util.Procedimientos;

public class IngresarRegistrosValidacionTablaLogSP extends StoredProcedure {
	
	public IngresarRegistrosValidacionTablaLogSP(DataSource ds) {
		setDataSource(ds);
		setSql(Procedimientos.INGRESAR_LOG_VALIDACION);
		
		declareParameter(new SqlParameter("PSAPU20", Types.VARCHAR));
		declareParameter(new SqlParameter("PSAPT31", Types.VARCHAR));
		declareParameter(new SqlParameter("PSAPSE6", Types.DECIMAL));
		declareParameter(new SqlParameter("PSAPC56", Types.DECIMAL));
		declareParameter(new SqlParameter("PSAPD09", Types.VARCHAR));
		compile();
	}
	
	public void executeProcedure(LogImportacion logImportacionBean) {
		Map<String, Object> parametrosIn = new HashMap<>();
		parametrosIn.put("PSAPU20", logImportacionBean.getUuid());
		parametrosIn.put("PSAPT31", logImportacionBean.getTipoValidacion());
		parametrosIn.put("PSAPSE6", logImportacionBean.getSecuencia());
		parametrosIn.put("PSAPC56", logImportacionBean.getCodigoValidacion());
		parametrosIn.put("PSAPD09", logImportacionBean.getDescripcionValidacion());
		
		super.execute(parametrosIn);
	}

}