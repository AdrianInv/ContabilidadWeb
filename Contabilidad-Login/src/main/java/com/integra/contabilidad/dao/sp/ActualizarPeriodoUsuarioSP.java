/**
 * ************************************************************************************
 * Fecha de Creación        : 07/02/2018
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

import com.integra.contabilidad.bean.UsuarioContabilidad;
import com.integra.contabilidad.util.Procedimientos;

public class ActualizarPeriodoUsuarioSP extends StoredProcedure {
	
	public ActualizarPeriodoUsuarioSP(DataSource ds) {
		setDataSource(ds);
		setSql(Procedimientos.ACTUALIZAR_PERIODO_USUARIO);
		
		declareParameter(new SqlParameter("@cSistema", Types.VARCHAR));
		declareParameter(new SqlParameter("@cNombre", Types.VARCHAR));
		declareParameter(new SqlParameter("@cPeriodo", Types.VARCHAR));
		declareParameter(new SqlOutParameter("@cMsgRetorno", Types.VARCHAR));
		declareParameter(new SqlOutParameter("@cValorRetorno", Types.INTEGER));
		compile();
	}

    public Map<String, Object> executeProcedure(UsuarioContabilidad usuario) {
    	Map<String, Object> parametrosIn = new HashMap<>();
    	parametrosIn.put("@cSistema", usuario.getSistema());
    	parametrosIn.put("@cNombre", usuario.getNombre());
    	parametrosIn.put("@cPeriodo", usuario.getPeriodo());
    	
    	Map<String, Object> out = super.execute(parametrosIn);
    	
    	Map<String, Object> result = new HashMap<>();
    	result.put("msgRetorno", out.get("@cMsgRetorno"));
    	result.put("valorRetorno", out.get("@cValorRetorno"));
    	
    	return result;
    }
}
