/**
 * ************************************************************************************
 * Fecha de Creación        : 12/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ibm.icu.text.SimpleDateFormat;

public class Utilitarios {

	private Utilitarios() {}
	
	public static class ConversionBigDecimal {

        private static Object lock = new Object();
        private static final Pattern BIG_DECIMAL_MATCHER;

        private ConversionBigDecimal() {
        }

        static {
            synchronized (lock) {
                BIG_DECIMAL_MATCHER = Pattern.compile("-?(?:\\d+(?:\\.\\d+)?|\\.\\d+)"); 
            }
        }

        public static BigDecimal forceBigDecimal(String value) { 
            Matcher moneyMatcher = BIG_DECIMAL_MATCHER.matcher(value);
            
            while (moneyMatcher.find()) {
                return new BigDecimal(moneyMatcher.group());
            }
            throw new NumberFormatException(String.format("Número no válido encontrado en el valor: %s", value));
        }
    }

	public static boolean isNullOrEmpty(String valor) {
		if (valor == null || valor.trim().length() == 0) {
			return true;
		}
		return false;
	}
	
	public static BigDecimal cortarDecimales(BigDecimal importe, int longitudDecimal, int longitudImporte) {
		if (importe != null) {
			System.out.println("1.- Importe : " + importe);
			longitudImporte--;
			String cadena = importe.toPlainString();			
			String[] partirDecimal = cadena.split("\\.");
			int cantidadDecimales = longitudImporte - partirDecimal[0].length() > longitudDecimal ? partirDecimal[1].length() : longitudImporte - partirDecimal[0].length();
			
			System.out.println("1.- Importe Decimal: " + new BigDecimal(partirDecimal[0] + "." + partirDecimal[1].substring(0, cantidadDecimales)));
			return new BigDecimal(partirDecimal[0] + "." + partirDecimal[1].substring(0, cantidadDecimales));
		}
		return BigDecimal.ZERO;
	}
	
	public static String convertFormatoFecha(String fecha, String formatoInicial, String formatoFinal) throws ParseException {
		SimpleDateFormat parseador = new SimpleDateFormat(formatoInicial);
		SimpleDateFormat formateador = new SimpleDateFormat(formatoFinal);
		Date date = parseador.parse(fecha);
		return formateador.format(date);
	}
	
	public static void main(String args[]) {
		String fecha = "2018040210";
		System.out.println("Fecha : " + fecha.substring(0, 8));
	}
}