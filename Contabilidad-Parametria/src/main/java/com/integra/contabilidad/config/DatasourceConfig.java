/**
 * ************************************************************************************
 * Fecha de Creación        : 08/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DatasourceConfig {

	@Bean(name = "dsConta04")
	@Primary
	@ConfigurationProperties(prefix = "spring.dsConta04")
	public DataSource cobranzasDataSource() {
	     return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "dsConta03")
	@ConfigurationProperties(prefix = "spring.dsConta03")
	public DataSource utilitariosDataSource() {
	     return DataSourceBuilder.create().build();
	}
}