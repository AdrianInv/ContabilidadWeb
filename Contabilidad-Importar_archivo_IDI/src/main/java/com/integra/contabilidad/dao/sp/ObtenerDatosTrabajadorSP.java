/**
 * ************************************************************************************
 * Fecha de Creación        : 09/02/2018
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

import com.integra.contabilidad.bean.Trabajador;
import com.integra.contabilidad.util.Procedimientos;

public class ObtenerDatosTrabajadorSP extends StoredProcedure {

	public ObtenerDatosTrabajadorSP(DataSource ds) {
        setDataSource(ds);
        setSql(Procedimientos.OBTENER_DATOS_TRABAJADOR);

        declareParameter(new SqlReturnResultSet("C_DATOS_TRABAJADOR", new RowMapper<Trabajador>() {
        	
        	@Override
            public Trabajador mapRow(ResultSet arg0, int arg1) throws SQLException {
            	Trabajador trabajadorBean = new Trabajador();
            	
            	trabajadorBean.setApellidoPaterno(arg0.getString("apePaterno") != null ? arg0.getString("apePaterno").trim() : "");
            	trabajadorBean.setApellidoMaterno(arg0.getString("apeMaterno") != null ? arg0.getString("apeMaterno").trim() : "");
            	trabajadorBean.setPrimerNombre(arg0.getString("nombre1") != null ? arg0.getString("nombre1").trim() : "");

                return trabajadorBean;
            }
        }));

        declareParameter(new SqlParameter("@CodUsuario", Types.VARCHAR));
        compile();
    }

    @SuppressWarnings("unchecked")
    public Trabajador executeProcedure(String codigoTrajador) {
        Map<String, Object> parametrosIn = new HashMap<>();
        parametrosIn.put("@CodUsuario", codigoTrajador);
        
        Map<String, Object> out = super.execute(parametrosIn);
        List<Trabajador> list = (List<Trabajador>) out.get("C_DATOS_TRABAJADOR");
        
        return !list.isEmpty() ? list.get(0) : null;
    }
    
}