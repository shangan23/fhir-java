package com.fhir.client;

public class example {
	
	public static void main(String args[]) {
		String url = "http://52.21.3.60:57773/csp/healthshare/hsods/fhir/stu3/";
		String uname = "_System";
		String pwd = "SYS";
		FhirFactory fhirFactory = new FhirFactory();
		FhirInterface client2 = fhirFactory.initFhir("Dstu2", url, uname, pwd);
		FhirInterface client3 = fhirFactory.initFhir("Dstu3", url, uname, pwd);
		//String Patient = client.getPatient("100000006");
		//System.out.print(Patient);
		//String Practitioner = client.getUserList("Practitioner");
		//System.out.print(Practitioner);
		String PatientDemographics = client3.getPatientDemographics("100000006");
		System.out.print(PatientDemographics);
	}

}
