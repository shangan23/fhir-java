package com.fhir.client;

public class example {
	
	public static void main(String args[]) {
		String url = "http://52.21.3.60:57773/csp/healthshare/hsods/fhir/dstu2/";
		String uname = "_System";
		String pwd = "SYS";
		FhirFactory fhirFactory = new FhirFactory();
		FhirInterface client = fhirFactory.initFhir("Dstu2", url, uname, pwd);
		String Patient = client.getPatient("100000006");
		System.out.print(Patient);
		//String Practitioner = client.getUserList("Practitioner");
		//System.out.print(Practitioner);
		//String PatientObservation = client.getPatientResourceList("100000006", "Appointment");
		//System.out.print(PatientObservation);
	}

}
