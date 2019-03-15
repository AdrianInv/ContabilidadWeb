/**
 * ************************************************************************************
 * Fecha de Creación        : 09/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.util;

public final class Procedimientos {
	
	private Procedimientos() {}
	
	//PROCEDIMIENTOS SQL SERVER
	public static final String LISTAR_PARAMETROS = "SP_LIS_PARAMETROS";
	public static final String OBTENER_DATOS_TRABAJADOR = "UADRYAN.Obt_Datos_Trabajador";
	public static final String OBTENER_ESTADO_ARCHIVO_PLANO = "SP_OBT_IMPORTACION_ARCHIVOS_PLANOS_ESTADO";
	public static final String OBTENER_VALIDACION_MOVIMIENTO = "CNTB_OBT_VALIDACION_MOVIMIENTO";
	public static final String ELIMINAR_IMPORTACION_ARCHIVO_PLANO = "SP_DEL_IMPORTACION_ARCHIVOS_PLANOS";
	public static final String INGRESAR_IMPORTACION_ARCHIVO_PLANO = "SP_INS_IMPORTACION_ARCHIVOS_PLANOS";
	public static final String ELIMINAR_DETALLE_ARCHIVO = "sp_Del_Archivos_Transferir";
	public static final String INGRESAR_DETALLE_ARCHIVO = "CNTB_INS_CCB14VAL";
	public static final String VALIDAR_CUENTA_ARCHIVO = "SP_VAL_CCB14VAL_DOCUMENTO";
	public static final String ACTUALIZAR_CUENTA_ARCHIVO = "SP_UPD_CCB14VAL_DOCUMENTO";
	public static final String OBTENER_RESULTADO_VALIDACION = "sp_Dame_Resultado_Validacion";
	public static final String LISTAR_LOG_IMPORTACION_POR_UUID = "sp_lis_LOG_IMPORTACION_XUUID";
	public static final String IMPORTAR_INFORMACION_ARCHIVO = "CNTB_INS_VOUCHER";
	public static final String ACTUALIZAR_ESTADO_IMPORTACION_ARCHIVO_PLANO = "SP_UPD_IMPORTACION_ARCHIVOS_PLANOS_ESTADO";
	public static final String ASOCIAR_VOUCHER_LOTE = "SP_EJE_ASOCIAR_VOUCHERS_LOTE";
	public static final String ELIMINAR_RANGO_IMPRESION = "sp_Del_Rango_Impresion";
	public static final String EJECUTAR_DTS_CARGA_MOVIMIENTOS_CONTABLES = "pr_IDI_gl_EjecutarDTS_CargaMovimientosContablesPREMIUM";
	public static final String OBTENER_IMPORTES_CARGADOS_PATRIMONIO = "pr_IDI_gl_ObtenerSumasPatrimonio";
	public static final String ACTUALIZAR_IMPORTACION_ARCHIVO_PLANO = "SP_UPD_IMPORTACION_ARCHIVOS_PLANOS";
	public static final String EMITIR_REPORTE_IMPORTACION = "SP_REP_IMPORTACION_POST_VALIDAR";
	public static final String VALIDAR_ARCHIVOS_A_TRANSFERIR = "sp_Valida_Archivo_Transferir";
	
	//PROCEDIMIENTOS AS400
	public static final String LISTAR_ARCHIVOS_TRANSFERENCIA_PREMIUM = "PCNTB003";
	public static final String LISTAR_ASIENTO_CONTABLES_POR_UUID = "PCNTB004";
	
	public static final String OBTENER_USUARIO_Y_MOTIVO_ARCHIVO = "PCNTB001";
	public static final String OBTENER_DIA_HABIL_Y_RESMOV = "PCNTB002";
	public static final String OBTENER_UUID_ARCHIVO = "PSAP0102";
	public static final String INGRESAR_LOG_VALIDACION = "PSAP0103";
	public static final String ACTUALIZAR_ESTADO_ENVIO_TABLA_CONTROL = "PSAP0101";
	
}