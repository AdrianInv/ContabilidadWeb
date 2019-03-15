package com.integra.contabilidad.reporte.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ValidacionArchivoPlano implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombreArchivoPlano;
	private Integer codigoValidacion;
    private Integer numeroRegistro;
    private String comentarioValidacion;
    private String descripcionValidacion;
    
	private static final Map<Integer, String> VALIDACIONES;
    
    static {
        VALIDACIONES = new HashMap<>();
        VALIDACIONES.put(1, "Validacion 1: Libros Auxiliares que No Existen");
        VALIDACIONES.put(2, "Validacion 2: Libros Auxiliares en Blanco");
        VALIDACIONES.put(3, "Validacion 3: Asientos Tipo que No Existen");
        VALIDACIONES.put(4, "Validacion 4: Cuentas que No Existen o No son de Movimiento");
        VALIDACIONES.put(5, "Validacion 5: Cuentas en Blanco");
        VALIDACIONES.put(6, "Validacion 6: Centros de Costo que No Existen");
        VALIDACIONES.put(7, "Validacion 7: Tipos de Documento que No Existen");
        VALIDACIONES.put(8, "Validacion 8: Centro de Gestion que No Existen");
        VALIDACIONES.put(9, "Validacion 9: Monedas No Reconocidas");
        VALIDACIONES.put(10, "Validacion 10: Tipos de Cambio Menores o Iguales a Cero");
        VALIDACIONES.put(11, "Validacion 11: Cargos Menores a Cero");
        VALIDACIONES.put(12, "Validacion 12: Abonos Menores a Cero");
        VALIDACIONES.put(13, "Validacion 13: Montos Equivalentes Menores a Cero");
        VALIDACIONES.put(14, "Validacion 14: Tipos de Analisis que No Existen");
        VALIDACIONES.put(15, "Validacion 15: Tipos de Analisis que son diferentes a los de la Cuenta Utilizada");
        VALIDACIONES.put(16, "Validacion 16: Tipo de Analisis y Cuenta Corriente no completos");
        VALIDACIONES.put(17, "Validacion 17: Cuentas Corrientes que No Existen");
        VALIDACIONES.put(18, "Validacion 18: Cuentas Corrientes que No Existen pero se Agregaran ( Alerta )");
        VALIDACIONES.put(19, "Validacion 19: Movimientos a los que le falta Centro de Costo");
        VALIDACIONES.put(20, "Validacion 20: Movimientos que No deben tener Centro de Costo");
        VALIDACIONES.put(21, "Validacion 21: Movimientos a los que le falta Centro de Gestion");
        VALIDACIONES.put(22, "Validacion 22: Movimientos que No deben tener Centro de Gestion");
        VALIDACIONES.put(23, "Validacion 23: Movimientos a los que le falta Cuenta Corriente");
        VALIDACIONES.put(24, "Validacion 24: Movimientos que No deben tener Cuenta Corriente");
        VALIDACIONES.put(25, "Validacion 25: Movimientos que se encuentran Duplicados");
        VALIDACIONES.put(26, "Validacion 26: Vouchers que se encuentran Descuadrados");
        VALIDACIONES.put(27, "Validacion 27: Fechas de Voucher No Validas");
        VALIDACIONES.put(28, "Validacion 28: Fechas de Voucher No pertenecen al Periodo Actual");
        VALIDACIONES.put(29, "Validacion 29: Periodos No son el Periodo Actual");
        VALIDACIONES.put(30, "Validacion 30: Movimientos que No deben tener Movimientos en Cargo y Abono");
        VALIDACIONES.put(31, "Validacion 31: Centros de Gestion No Validos para las Cuentas de Gastos");
        VALIDACIONES.put(32, "Validacion 32: Centros de Gestion No Validos para las Cuentas de Activo");
        VALIDACIONES.put(33, "Validacion 33: Cuentas Corrientes duplicadas");
        VALIDACIONES.put(34, "RESULTADO DE LA VALIDACION");
    }

	public String getNombreArchivoPlano() {
		return nombreArchivoPlano;
	}

	public void setNombreArchivoPlano(String nombreArchivoPlano) {
		this.nombreArchivoPlano = nombreArchivoPlano;
	}

	public Integer getCodigoValidacion() {
		return codigoValidacion;
	}

	public void setCodigoValidacion(Integer codigoValidacion) {
		this.codigoValidacion = codigoValidacion;
	}

	public Integer getNumeroRegistro() {
		return numeroRegistro;
	}

	public void setNumeroRegistro(Integer numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	public String getComentarioValidacion() {
		return comentarioValidacion;
	}

	public void setComentarioValidacion(String comentarioValidacion) {
		this.comentarioValidacion = comentarioValidacion;
	}

	public String getDescripcionValidacion() {
		return descripcionValidacion != null ? descripcionValidacion : VALIDACIONES.get(codigoValidacion);
	}

	public void setDescripcionValidacion(String descripcionValidacion) {
		this.descripcionValidacion = descripcionValidacion;
	}

}