package com.integra.contabilidad.dao.sp;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.integra.contabilidad.bean.ControlEnvioAsiento;
import com.integra.contabilidad.util.Procedimientos;

public class ObtenerEstadoArchivoPlanoSP extends StoredProcedure {
	
	private static final String PARAMETRO_OUT_ESTADO_PREMIUM = "@estado_final_premium";
	private static final String PARAMETRO_OUT_ESTADO_IDI = "@estado_final_idi";
	
	public ObtenerEstadoArchivoPlanoSP(DataSource ds) {
        setDataSource(ds);
        setSql(Procedimientos.OBTENER_ESTADO_ARCHIVO_PLANO);
        
        declareParameter(new SqlParameter("@nombreArchivo", Types.VARCHAR));
        declareParameter(new SqlParameter("@estado_premium", Types.VARCHAR));
        declareParameter(new SqlParameter("@estado_idi", Types.VARCHAR));
        declareParameter(new SqlOutParameter(PARAMETRO_OUT_ESTADO_PREMIUM, Types.VARCHAR));
        declareParameter(new SqlOutParameter(PARAMETRO_OUT_ESTADO_IDI, Types.VARCHAR));
        
        compile();
    }

    public void executeProcedure(ControlEnvioAsiento archivo) {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("@nombreArchivo", archivo.getNombreArchivo());
        parametros.put("@estado_premium", archivo.getEstadoPremium());
        parametros.put("@estado_idi", archivo.getEstadoIDI());

        Map<String, Object> out = super.execute(parametros);
        
        archivo.setEstadoPremium(out.get(PARAMETRO_OUT_ESTADO_PREMIUM).toString().trim());
        archivo.setEstadoIDI(out.get(PARAMETRO_OUT_ESTADO_IDI).toString().trim());
    }

}