package com.fhir.client;

public interface FhirInterface {
	String getPatientResourceList(String PatientID, String bundle);
	String getUserList(String bundle);
	String getPatientFull(String PatientID);
	String getPatientDemographics(String PatientID);
	String updatePatientAllergy(String AllergyId,String Payload);
	String addPatientAllergy(String PatientId,String Payload);
	String addPatientAppointment(String PatientId,String Payload);
	String updatePatient(String PatientId, String Payload, Boolean Patch);
	String createPatient(String Payload);
}
