package com.fhir.client;

public interface FhirInterface {
	String getPatientResourceList(String PatientID, String bundle);
	String getUserList(String bundle);
	String getPatientFull(String PatientID);
	String getPatientDemographics(String PatientID);
	String createPatient();
	String updatePatient(String PatientId);
}
