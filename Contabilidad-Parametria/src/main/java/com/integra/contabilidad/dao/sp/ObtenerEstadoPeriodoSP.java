/**
 * ************************************************************************************
 * Fecha de Creación        : 08/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.dao.sp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import com.integra.contabilidad.bean.Periodo;
import com.integra.contabilidad.util.Procedimientos;

public class ObtenerEstadoPeriodoSP extends StoredProcedure {

	public ObtenerEstadoPeriodoSP(DataSource ds) {
        setDataSource(ds);
        setSql(Procedimientos.OBTENER_ESTADO_PERIODO);
        
        declareParameter(new SqlReturnResultSet("C_OBTENER_ESTADO_PERIODO", new RowMapper<Periodo>() {
        	
        	@Override
			public Periodo mapRow(ResultSet arg0, int arg1) throws SQLException {
				Periodo periodo = new Periodo();
				
				periodo.setEstado(arg0.getInt("Estado"));
				periodo.setConciliado(arg0.getInt("Conciliado"));
				
				return periodo;
			}
		}));
        declareParameter(new SqlParameter("@CODIGO", Types.VARCHAR));
        compile();
    }

    @SuppressWarnings("unchecked")
	public Integer executeProcedure(String codigoPeriodo) {
    	Map<String, Object> parametrosIn = new HashMap<>();
    	parametrosIn.put("@CODIGO", codigoPeriodo);
        
    	Map<String, Object> out = super.execute(parametrosIn);
    	List<Periodo> list = (List<Periodo>) out.get("C_OBTENER_ESTADO_PERIODO");
    	
    	if (!list.isEmpty()) {
    		return list.get(0).getEstado();
    	}
        return null;
    }
}