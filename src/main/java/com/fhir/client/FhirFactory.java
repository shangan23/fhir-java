package com.fhir.client;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.interceptor.BasicAuthInterceptor;

public class FhirFactory {
	
	String formatResult;
	
	public FhirFactory(String format) {
		formatResult = format;
	}

	public FhirInterface initFhir(String ver, String url, String uname, String pwd) {
		if (ver == null) {
			return null;
		}
		if (ver.equalsIgnoreCase("DSTU2")) {
			return new Dstu2(url, uname, pwd,formatResult);
		} else if (ver.equalsIgnoreCase("DSTU3")) {
			return new Dstu3(url, uname, pwd,formatResult);
		}
		return null;
	}

}
