/**
 * ************************************************************************************
 * Fecha de Creación        : 09/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.dao.sp;

import java.math.RoundingMode;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.integra.contabilidad.bean.ArchivoImportadoIDI;
import com.integra.contabilidad.util.Constantes;
import com.integra.contabilidad.util.Procedimientos;

public class IngresarImportacionArchivoPlanosSP extends StoredProcedure {

    public IngresarImportacionArchivoPlanosSP(DataSource ds) {
        setDataSource(ds);
        setSql(Procedimientos.INGRESAR_IMPORTACION_ARCHIVO_PLANO);

        declareParameter(new SqlParameter("@nombreArchivoPlano", Types.VARCHAR));
        declareParameter(new SqlParameter("@usuarioWindows", Types.VARCHAR));
        declareParameter(new SqlParameter("@usuarioAprobacion", Types.VARCHAR));
        declareParameter(new SqlParameter("@totalDebe", Types.DECIMAL));
        declareParameter(new SqlParameter("@totalHaber", Types.DECIMAL));
        declareParameter(new SqlParameter("@totalCuotasDebe", Types.DECIMAL));
        declareParameter(new SqlParameter("@totalCuotasHaber", Types.DECIMAL));
        //declareParameter(new SqlParameter("@periodoAño", Types.VARCHAR));
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

    public void executeProcedure(ArchivoImportadoIDI archivo, String usuarioWindows) {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("@nombreArchivoPlano", archivo.getNombreArchivo());
        parametros.put("@usuarioWindows", usuarioWindows);
        parametros.put("@usuarioAprobacion", archivo.getNombreCompletoUsuario());
        parametros.put("@totalDebe", archivo.getImporteTotalDebe().setScale(2, RoundingMode.FLOOR));
        parametros.put("@totalHaber", archivo.getImporteTotalHaber().setScale(2, RoundingMode.FLOOR));
        parametros.put("@totalCuotasDebe", archivo.getImporteCuotaDebe().setScale(2, RoundingMode.FLOOR));
        parametros.put("@totalCuotasHaber", archivo.getImporteCuotaHaber().setScale(2, RoundingMode.FLOOR));
        //parametros.put("@periodoAño", "");
        parametros.put("@" + Constantes.getPeriodoYear(), "");
        parametros.put("@periodoMes", "");
        parametros.put("@fondo", "");
        parametros.put("@libro", "");
        parametros.put("@voucher", "");
        parametros.put("@CantidadRegistros", archivo.getCantidadRegistros());
        parametros.put("@sumas_del_idi", 0);
        parametros.put("@tipo_movimiento_idi", "");
        parametros.put("@cantidad_registros_idi", 0);
        
        super.execute(parametros);
    }
}