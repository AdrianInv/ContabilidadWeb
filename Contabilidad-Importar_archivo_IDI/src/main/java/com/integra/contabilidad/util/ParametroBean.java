package com.integra.contabilidad.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("parametro")
public class ParametroBean {
	
	private String region;

	private String secretname;

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSecretname() {
		return secretname;
	}

	public void setSecretname(String secretname) {
		this.secretname = secretname;
	}

}
