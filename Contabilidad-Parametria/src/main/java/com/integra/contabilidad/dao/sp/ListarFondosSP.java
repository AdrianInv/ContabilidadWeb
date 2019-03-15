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

import com.integra.contabilidad.bean.Fondo;
import com.integra.contabilidad.util.Constantes;
import com.integra.contabilidad.util.Procedimientos;

public class ListarFondosSP extends StoredProcedure {

	public ListarFondosSP(DataSource datasource) {
		setDataSource(datasource);
		setSql(Procedimientos.LISTAR_FONDOS);
		
		declareParameter(new SqlReturnResultSet("C_LISTAR_FONDOS", new RowMapper<Fondo>() {

			@Override
			public Fondo mapRow(ResultSet arg0, int arg1) throws SQLException {
				Fondo fondo = new Fondo();
				
				fondo.setCodigo(arg0.getString("ccb02cod") != null ? arg0.getString("ccb02cod").trim() : "");
                fondo.setDescripcion(arg0.getString("ccb02des") != null ? arg0.getString("ccb02des").trim() : "");
                fondo.setEstado(arg0.getString("ccb02est") != null ? arg0.getString("ccb02est").trim() : "");
                
				return fondo;
			}
		}));
		
		declareParameter(new SqlParameter("@cEmpresa", Types.VARCHAR));
        declareParameter(new SqlParameter("@cCampo", Types.VARCHAR));
        declareParameter(new SqlParameter("@cFiltro", Types.VARCHAR));
		compile();
	}
	
	@SuppressWarnings("unchecked")
    public List<Fondo> executeProcedure(String codigoEmpresa) {
		Map<String, Object> parametrosIn = new HashMap<>();
		parametrosIn.put("@cEmpresa", codigoEmpresa);
		parametrosIn.put("@cCampo", Constantes.PARAMETRO_IN_CAMPO);
		parametrosIn.put("@cFiltro", Constantes.PARAMETRO_IN_FILTRO);
		
		Map<String, Object> out = super.execute(parametrosIn);
		
        return (List<Fondo>) out.get("C_LISTAR_FONDOS");
    }
}