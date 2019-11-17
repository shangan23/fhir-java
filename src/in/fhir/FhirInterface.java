package in.fhir;

public interface FhirInterface {

	void getPatientDetail();

	void getPractitionerDetail();

	void getPatientResourceDetail(String PatientID, String bundle);


}
