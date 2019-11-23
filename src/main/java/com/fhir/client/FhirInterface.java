package com.fhir.client;

public interface FhirInterface {

	String getPatientResourceList(String PatientID, String bundle);
	String getUserList(String bundle);

}
