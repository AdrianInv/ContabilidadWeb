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

public class ImportaInformacionArchivoPlanoSP extends StoredProcedure {
	
	public ImportaInformacionArchivoPlanoSP(DataSource ds) {
		setDataSource(ds);
		setSql(Procedimientos.IMPORTAR_INFORMACION_ARCHIVO);
		
		declareParameter(new SqlParameter("@cUsuario", Types.VARCHAR));
		declareParameter(new SqlParameter("@cNomArch", Types.VARCHAR));
		declareParameter(new SqlParameter("@cDesArch", Types.VARCHAR));
		declareParameter(new SqlParameter("@cCodigoFondo", Types.VARCHAR));
		declareParameter(new SqlOutParameter("@cMsgRetorno", Types.VARCHAR));
		declareParameter(new SqlOutParameter("@cValorRetorno", Types.INTEGER));
		
		compile();
	}
	
	public Map<String, Object> executeProcedure(String codigoUsuario, String codigoFondo) {
		Map<String, Object> parametrosIn = new HashMap<>();
		parametrosIn.put("@cUsuario", codigoUsuario);
		parametrosIn.put("@cNomArch", "");
		parametrosIn.put("@cDesArch", "");
		parametrosIn.put("@cCodigoFondo", codigoFondo);
		
		Map<String, Object> out = super.execute(parametrosIn);
		
		Map<String, Object> result = new HashMap<>();
		result.put("mensajeRetorno", out.get("@cMsgRetorno").toString());
		result.put("valorRetorno", Integer.parseInt(out.get("@cValorRetorno").toString()));
		
		return result;
	}

}