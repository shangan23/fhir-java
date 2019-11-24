package com.fhir.client;

public class example {
	
	public static void main(String args[]) {
		String url2 = "http://52.21.3.60:57773/csp/healthshare/hsods/fhir/dstu2/";
		String url3 = "http://52.21.3.60:57773/csp/healthshare/hsods/fhir/stu3/";
		String uname = "_System";
		String pwd = "SYS";
		String format = "JSON";
		FhirFactory fhirFactory = new FhirFactory(format);
		FhirInterface client2 = fhirFactory.initFhir("Dstu2", url2, uname, pwd);
		FhirInterface client3 = fhirFactory.initFhir("Dstu3", url3, uname, pwd);
		//String Patient = client.getPatient("100000006");
		//System.out.print(Patient);
		String Practitioner = client2.getUserList("Practitioner");
		System.out.print(Practitioner);
		String PatientDemographics = client3.getPatientDemographics("100000006");
		System.out.print(PatientDemographics);
	}

}
