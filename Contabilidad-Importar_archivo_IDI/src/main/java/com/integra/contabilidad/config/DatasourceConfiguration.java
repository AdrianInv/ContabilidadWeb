/**
 * ************************************************************************************
 * Fecha de Creación        : 09/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.config;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.sql.DataSource;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.integra.contabilidad.util.EncryptionUtil;
import com.integra.contabilidad.util.SecretParametro;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatasourceConfiguration {
	
	@Autowired
	SecretConfiguration awsSecret;
	
	/*
	 * @Value("${spring.datasource.hikari.minimum-idle}") private int minimumIdle;
	 * 
	 * @Value("${spring.datasource.hikari.maximum-pool-size}") private int
	 * maxPoolSize;
	 */
	

	@Bean(name = "dsConta04")
	@Primary
	@ConfigurationProperties(prefix = "spring.dsConta04")
	public DataSource conta04DataSource() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		
		/*SecretParametro aws = awsSecret.getSecretKey();
		
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		hikariConfig.setJdbcUrl(EncryptionUtil.decrypt(Base64.decodeBase64(aws.getContabilidadWebConta04Url()), aws.getKeyEncriptacion()));
		hikariConfig.setUsername(EncryptionUtil.decrypt(Base64.decodeBase64(aws.getContabilidadWebConta04Usr()), aws.getKeyEncriptacion()));
		hikariConfig.setPassword(EncryptionUtil.decrypt(Base64.decodeBase64(aws.getContabilidadWebConta04Psw()), aws.getKeyEncriptacion()));
		hikariConfig.setMaximumPoolSize(maxPoolSize);
		hikariConfig.setMinimumIdle(minimumIdle);
		hikariConfig.setConnectionTestQuery("SELECT 1");
		hikariConfig.setPoolName("springHikariCPConta04");

		return new HikariDataSource(hikariConfig);*/
		
		 return DataSourceBuilder.create().build();
		
	   
	}
	
	@Bean(name = "dsConta03")
	@ConfigurationProperties(prefix = "spring.dsConta03")
	public DataSource conta03DataSource() {
	     return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "dsPremMain")
	@ConfigurationProperties(prefix = "spring.dsPremMain")
	public DataSource premMainDataSource() {
	     return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "dsCuentasIndividuales")
	@ConfigurationProperties(prefix = "spring.dsCuentasIndividuales")
	public DataSource cuentasIndividualesDataSource() {
	     return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "dsTesoreria")
	@ConfigurationProperties(prefix = "spring.dsTesoreria")
	public DataSource tesoreriaDataSource() {
	     return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "dsAdryan")
	@ConfigurationProperties(prefix = "spring.dsAdryan")
	public DataSource adryanDataSource() {
	     return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "dsContaAS400")
	@ConfigurationProperties(prefix = "spring.dsContaAS400")
	public DataSource contabilidadAS400DataSource() {
	     return DataSourceBuilder.create().build();
	}
	
}