package com.fhir;

public interface FhirInterface {

	String getPatientResourceList(String PatientID, String bundle);
	String getUserList(String bundle);

}
