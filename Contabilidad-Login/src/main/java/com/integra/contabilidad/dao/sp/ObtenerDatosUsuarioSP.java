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

import com.integra.contabilidad.bean.UsuarioContabilidad;
import com.integra.contabilidad.util.Constantes;
import com.integra.contabilidad.util.Procedimientos;

public class ObtenerDatosUsuarioSP extends StoredProcedure {

    public ObtenerDatosUsuarioSP(DataSource ds) {
        setDataSource(ds);
        setSql(Procedimientos.OBTENER_DATOS_USUARIO);

        declareParameter(new SqlReturnResultSet("C_OBTENER_DATOS_USUARIO", new RowMapper<UsuarioContabilidad>() {
        	
        	@Override
            public UsuarioContabilidad mapRow(ResultSet arg0, int arg1) throws SQLException {
                UsuarioContabilidad usuarioBean = new UsuarioContabilidad();

                usuarioBean.setSistema(arg0.getString("Sistema"));
                usuarioBean.setNombre(arg0.getString("Nombre"));
                usuarioBean.setNombreCompleto(arg0.getString("NombreComp"));
                usuarioBean.setCargo(arg0.getString("Cargo"));
                usuarioBean.setPeriodoCerrado(arg0.getString("AccPerCerr"));
                usuarioBean.setPeriodo(arg0.getString("Periodo"));
                usuarioBean.setMoneda(arg0.getString("Moneda"));
                usuarioBean.setSaldos(arg0.getString("Saldos"));
                usuarioBean.setTipoImp(arg0.getString("TipoImp"));
                usuarioBean.setAjuste(arg0.getString("Ajuste"));
                usuarioBean.setAccPerCon(arg0.getString("AccPerCon"));
                usuarioBean.setVarImpche(arg0.getString("VarImpChe"));
                usuarioBean.setFlagEliminado(arg0.getString("Flag_eliminado"));
                usuarioBean.setCodigoArea(arg0.getInt("CODIGO_AREA"));
                usuarioBean.setEmail(arg0.getString("EMAIL"));

                return usuarioBean;
            }
        }));

        declareParameter(new SqlParameter("@cSistema", Types.VARCHAR));
        declareParameter(new SqlParameter("@cUsuario", Types.VARCHAR));
        compile();
    }

    @SuppressWarnings("unchecked")
    public UsuarioContabilidad executeProcedure(String codigoUsuario) {
    	Map<String, Object> parametrosIn = new HashMap<>();
    	parametrosIn.put("@cSistema", Constantes.SISTEMA);
    	parametrosIn.put("@cUsuario", codigoUsuario);
    	
        Map<String, Object> out = super.execute(parametrosIn);
        List<UsuarioContabilidad> list = (List<UsuarioContabilidad>) out.get("C_OBTENER_DATOS_USUARIO");
        return !list.isEmpty() ? list.get(0) : null;
    }

}