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

import com.integra.contabilidad.bean.ControlEnvioAsiento;
import com.integra.contabilidad.util.Procedimientos;

public class ListarAsientoATransferirPremiumSP extends StoredProcedure {

	public ListarAsientoATransferirPremiumSP(DataSource ds) {
		setDataSource(ds);
		setSql(Procedimientos.LISTAR_ARCHIVOS_TRANSFERENCIA_PREMIUM);
		
		declareParameter(new SqlReturnResultSet("C_LISTAR_ARCHIVOS", new RowMapper<ControlEnvioAsiento>() {

			@Override
			public ControlEnvioAsiento mapRow(ResultSet arg0, int arg1) throws SQLException {
				ControlEnvioAsiento asiento = new ControlEnvioAsiento();
				
				asiento.setUuid(arg0.getString("UUID") != null ? arg0.getString("UUID").trim() : "");
				asiento.setNombreArchivo(arg0.getString("NOMBRE_ARCHIVO") != null ? arg0.getString("NOMBRE_ARCHIVO").trim() : "");
				asiento.setCodigoUsuarioCreacion(arg0.getString("USUARIO") != null ? arg0.getString("USUARIO").trim() : "");
				asiento.setNombreProceso(arg0.getString("MOTIVO") != null ? arg0.getString("MOTIVO").trim() : "");
				
				return asiento;
			}
		}));
		
		declareParameter(new SqlParameter("@FONSEL", Types.VARCHAR));
		compile();
	}
	
	@SuppressWarnings("unchecked")
	public List<ControlEnvioAsiento> executeProcedure(String fondo) {
		Map<String, Object> parametrosIn = new HashMap<>();
		parametrosIn.put("@FONSEL", fondo);
		
		Map<String, Object> out = super.execute(parametrosIn);
		return (List<ControlEnvioAsiento>) out.get("C_LISTAR_ARCHIVOS");
	}

}