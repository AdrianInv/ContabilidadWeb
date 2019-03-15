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

import com.integra.contabilidad.bean.Asiento;
import com.integra.contabilidad.util.Procedimientos;

public class ObtenerUsuarioYMotivoSP extends StoredProcedure {

	public ObtenerUsuarioYMotivoSP(DataSource ds) {
        setDataSource(ds);
        setSql(Procedimientos.OBTENER_USUARIO_Y_MOTIVO_ARCHIVO);

        declareParameter(new SqlReturnResultSet("C_OBTENER_USUARIO_Y_MOTIVO_ARCHIVO", new RowMapper<Asiento>() {
        	
        	@Override
            public Asiento mapRow(ResultSet arg0, int arg1) throws SQLException {
            	Asiento asientoBean = new Asiento();
            	
            	asientoBean.setNombreArchivoEnvio(arg0.getString("SAPNO5").trim());
            	asientoBean.setUsuarioCreacion(arg0.getString("SAPUS7").trim());
            	asientoBean.setNombreProceso(arg0.getString("SAPN30").trim());
            	
                return asientoBean;
            }
        }));

        declareParameter(new SqlParameter("@ARCHIV", Types.VARCHAR));
        compile();
    }

    @SuppressWarnings("unchecked")
    public Asiento executeProcedure(String nombreArchivo) {
        Map<String, Object> parametrosIn = new HashMap<>();
        parametrosIn.put("@ARCHIV", nombreArchivo);
        
        Map<String, Object> out = super.execute(parametrosIn);
        List<Asiento> list = (List<Asiento>) out.get("C_OBTENER_USUARIO_Y_MOTIVO_ARCHIVO");
        
        return !list.isEmpty() ? list.get(0) : null;
    }
    
}