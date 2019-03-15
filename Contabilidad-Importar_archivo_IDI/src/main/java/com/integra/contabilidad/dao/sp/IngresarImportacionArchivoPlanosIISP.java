package com.integra.contabilidad.dao.sp;

import java.math.RoundingMode;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.integra.contabilidad.bean.ControlEnvioAsiento;
import com.integra.contabilidad.util.Constantes;
import com.integra.contabilidad.util.Procedimientos;

public class IngresarImportacionArchivoPlanosIISP extends StoredProcedure {

    public IngresarImportacionArchivoPlanosIISP(DataSource ds) {
        setDataSource(ds);
        setSql(Procedimientos.INGRESAR_IMPORTACION_ARCHIVO_PLANO);

        declareParameter(new SqlParameter("@nombreArchivoPlano", Types.VARCHAR));
        declareParameter(new SqlParameter("@usuarioWindows", Types.VARCHAR));
        declareParameter(new SqlParameter("@usuarioAprobacion", Types.VARCHAR));
        declareParameter(new SqlParameter("@totalDebe", Types.DECIMAL));
        declareParameter(new SqlParameter("@totalHaber", Types.DECIMAL));
        declareParameter(new SqlParameter("@totalCuotasDebe", Types.DECIMAL));
        declareParameter(new SqlParameter("@totalCuotasHaber", Types.DECIMAL));
        declareParameter(new SqlParameter("@" + Constantes.getPeriodoYear(), Types.VARCHAR));
        declareParameter(new SqlParameter("@periodoMes", Types.VARCHAR));
        declareParameter(new SqlParameter("@fondo", Types.CHAR));
        declareParameter(new SqlParameter("@libro", Types.VARCHAR));
        declareParameter(new SqlParameter("@voucher", Types.VARCHAR));
        declareParameter(new SqlParameter("@CantidadRegistros", Types.INTEGER));
        declareParameter(new SqlParameter("@sumas_del_idi", Types.NUMERIC));
        declareParameter(new SqlParameter("@tipo_movimiento_idi", Types.CHAR));
        declareParameter(new SqlParameter("@cantidad_registros_idi", Types.INTEGER));

        compile();
    }

    public void executeProcedure(ControlEnvioAsiento controlAsiento) {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("@nombreArchivoPlano", controlAsiento.getNombreArchivo());
        parametros.put("@usuarioWindows", controlAsiento.getUsuarioWindows());
        parametros.put("@usuarioAprobacion", controlAsiento.getNombreCompletoUsuarioCreacion());
        parametros.put("@totalDebe", controlAsiento.getImporteTotalDebe().setScale(2, RoundingMode.FLOOR));
        parametros.put("@totalHaber", controlAsiento.getImporteTotalHaber().setScale(2, RoundingMode.FLOOR));
        parametros.put("@totalCuotasDebe", controlAsiento.getImporteCuotaDebe().setScale(2, RoundingMode.FLOOR));
        parametros.put("@totalCuotasHaber", controlAsiento.getImporteCuotaHaber().setScale(2, RoundingMode.FLOOR));
        parametros.put("@" + Constantes.getPeriodoYear(), "");
        parametros.put("@periodoMes", "");
        parametros.put("@fondo", "");
        parametros.put("@libro", "");
        parametros.put("@voucher", "");
        parametros.put("@CantidadRegistros", controlAsiento.getCantidadRegistros());
        parametros.put("@sumas_del_idi", 0);
        parametros.put("@tipo_movimiento_idi", "");
        parametros.put("@cantidad_registros_idi", 0);
        
        super.execute(parametros);
    }
    
}