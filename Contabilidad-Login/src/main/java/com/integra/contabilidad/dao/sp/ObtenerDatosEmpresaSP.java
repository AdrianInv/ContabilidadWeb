/**
 * ************************************************************************************
 * Fecha de Creación        : 07/02/2018
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

import com.integra.contabilidad.bean.Empresa;
import com.integra.contabilidad.util.Constantes;
import com.integra.contabilidad.util.Procedimientos;

public class ObtenerDatosEmpresaSP extends StoredProcedure {

    public ObtenerDatosEmpresaSP(DataSource ds) {
        setDataSource(ds);
        setSql(Procedimientos.OBTENER_DATOS_EMPRESA);
        
        declareParameter(new SqlReturnResultSet("C_OBTENER_EMPRESA", new RowMapper<Empresa>() {
        	
        	@Override
            public Empresa mapRow(ResultSet arg0, int arg1) throws SQLException {
            	Empresa empresaBean = new Empresa();
                
            	empresaBean.setSistema(arg0.getString("Sistema"));
                empresaBean.setCodigo(arg0.getString("Codigo"));
                empresaBean.setNombre(arg0.getString("Nombre"));
                empresaBean.setDireccion(arg0.getString("Direccion"));
                empresaBean.setRepresentante(arg0.getString("Representante"));
                empresaBean.setCargo(arg0.getString("Cargo"));
                empresaBean.setContador(arg0.getString("Contador"));
                empresaBean.setMatricula(arg0.getString("Matricula"));
                empresaBean.setEjercicio(arg0.getString("Ejercicio"));
                empresaBean.setRucEmpresa(arg0.getString("RucEmpresa"));
                empresaBean.setMultifondo(arg0.getString("Multifondo"));
                empresaBean.setVigente(arg0.getString("Vigente"));
                                
                return empresaBean;
            }
        }));
        
        declareParameter(new SqlParameter("@SISTEMA", Types.VARCHAR));
        declareParameter(new SqlParameter("@CODIGO", Types.VARCHAR));
        declareParameter(new SqlParameter("@NUEVO", Types.VARCHAR));
        compile();
    }
    
    @SuppressWarnings("unchecked")
    public Empresa executeProcedure(String codigoEmpresa) {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("@SISTEMA", Constantes.SISTEMA);
        parametros.put("@CODIGO", codigoEmpresa);
        parametros.put("@NUEVO", "S");
        
        Map<String, Object> out = super.execute(parametros);
        List<Empresa> list = (List<Empresa>) out.get("C_OBTENER_EMPRESA");
        return !list.isEmpty() ? list.get(0) : null;
    }
}
