package com.fhir;

public class FhirFactory {

	public FhirInterface initFhir(String ver, String url, String uname, String pwd) {
		if (ver == null) {
			return null;
		}
		if (ver.equalsIgnoreCase("DSTU2")) {
			return new Dstu2(url, uname, pwd);
		}
		return null;
	}

}
