package com.integra.contabilidad.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integra.contabilidad.util.ParametroBean;
import com.integra.contabilidad.util.SecretParametro;

@Configuration
public class SecretConfiguration {
	
private static final Logger logger = LoggerFactory.getLogger(SecretConfiguration.class);
	
	@Autowired
	ParametroBean property;
	
	public SecretParametro getSecretKey() {
		AWSSecretsManager client = AWSSecretsManagerClientBuilder.standard()
				.withRegion(property.getRegion())
				.build();
		GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest().withSecretId(property.getSecretname());
		GetSecretValueResult getSecretValueResult = client.getSecretValue(getSecretValueRequest);
		String secretString = getSecretValueResult.getSecretString();
		
		SecretParametro secretParametro = null;
		try {
			logger.info(String.format("secretString %s", secretString));
			secretParametro = new ObjectMapper().readValue(secretString, SecretParametro.class);
		} catch (Exception e) {
			e.getMessage();
		}
		return secretParametro;
	}

}
