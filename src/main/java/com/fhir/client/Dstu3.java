package com.fhir.client;

import org.hl7.fhir.dstu3.model.AllergyIntolerance;
import org.hl7.fhir.dstu3.model.Appointment;
import org.hl7.fhir.dstu3.model.Bundle;
import org.hl7.fhir.dstu3.model.Condition;
import org.hl7.fhir.dstu3.model.DiagnosticReport;
import org.hl7.fhir.dstu3.model.DocumentReference;
import org.hl7.fhir.dstu3.model.Encounter;
import org.hl7.fhir.dstu3.model.Immunization;
import org.hl7.fhir.dstu3.model.MedicationRequest;
import org.hl7.fhir.dstu3.model.Observation;
import org.hl7.fhir.dstu3.model.Parameters;
import org.hl7.fhir.dstu3.model.Patient;
import org.hl7.fhir.dstu3.model.Practitioner;
import org.hl7.fhir.instance.model.api.IBaseResource;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.primitive.IdDt;
import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.client.interceptor.BasicAuthInterceptor;

public class Dstu3 implements FhirInterface {

	static IGenericClient client;
	static FhirContext ctx;

	public Dstu3(String url, String uname, String pwd) {
		ctx = FhirContext.forDstu3();
		client = ctx.newRestfulGenericClient(url);
		BasicAuthInterceptor AuthInterceptor = HTTPBasicAuthorization(uname, pwd);
		client.registerInterceptor(AuthInterceptor);
	}

	private static BasicAuthInterceptor HTTPBasicAuthorization(String username, String password) {
		BasicAuthInterceptor authInterceptor = new BasicAuthInterceptor(username, password);
		return authInterceptor;

	}

	@Override
	public String getPatientResourceList(String PatientID, String bundle) {
		Bundle results = null;
		switch (bundle) {
		case "AllergyIntolerance":
			results = client.search().forResource(AllergyIntolerance.class)
					.where(AllergyIntolerance.PATIENT.hasId(PatientID))
					.returnBundle(Bundle.class).execute();
			break;
		case "Appointment":
			results = client.search().forResource(Appointment.class).where(Appointment.PATIENT.hasId(PatientID))
					.returnBundle(Bundle.class).execute();
			break;
		case "Condition":
			results = client.search().forResource(Condition.class).where(Condition.PATIENT.hasId(PatientID))
					.returnBundle(Bundle.class).execute();
			break;
		case "DiagnosticReport":
			results = client.search().forResource(DiagnosticReport.class)
					.where(DiagnosticReport.PATIENT.hasId(PatientID))
					.returnBundle(Bundle.class).execute();
			break;
		case "DocumentReference":
			results = client.search().forResource(DocumentReference.class)
					.where(DocumentReference.PATIENT.hasId(PatientID))
					.returnBundle(Bundle.class).execute();
			break;
		case "Encounter":
			results = client.search().forResource(Encounter.class).where(Encounter.PATIENT.hasId(PatientID))
					.returnBundle(Bundle.class).execute();
			break;
		case "Immunization":
			results = client.search().forResource(Immunization.class).where(Immunization.PATIENT.hasId(PatientID))
					.returnBundle(Bundle.class).execute();
			break;
		case "MedicationOrder":
			results = client.search().forResource(MedicationRequest.class).where(MedicationRequest.PATIENT.hasId(PatientID))
					.returnBundle(Bundle.class).execute();
			break;
		case "Observation":
			results = client.search().forResource(Observation.class).where(Observation.PATIENT.hasId(PatientID))
					.returnBundle(Bundle.class).execute();
			break;
		}
		System.out.println("Total " + bundle + " = " + results.getEntry().size());
		return formatOutput(results);

	}

	@Override
	public String getPatientDemographics(String PatientID) {
		Patient result = null;
		result = client.read().resource(Patient.class).withId(PatientID).execute();
		return formatOutput(result);
	}

	@Override
	public String getUserList(String bundle) {
		Bundle results = null;
		switch (bundle) {
		case "Patient":
			results = client.search().forResource(Patient.class)
					.returnBundle(Bundle.class).execute();
			break;
		case "Practitioner":
			results = client.search().forResource(Practitioner.class)
					.returnBundle(Bundle.class).execute();
			break;

		}
		System.out.println("Total " + bundle + " = " + results.getEntry().size());
		return formatOutput(results);
	}

	@Override
	public String getPatientFull(String PatientID) {
		Bundle results = null;
		Parameters outParams = client.operation().onInstance(new IdDt("Patient", PatientID)).named("$everything")
				.withNoParameters(Parameters.class) // No input parameters
				.execute();
		results = (Bundle) outParams.getParameter().get(0).getResource();
		return formatOutput(results);
	}
	
	private String formatOutput(Bundle results) {
		String output = ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(results);
		return output;
		
	}
	
	private String formatOutput(Patient results) {
		String output = ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(results);
		return output;
		
	}
	
	private String formatOutput(MethodOutcome results) {
		String output = ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString((IBaseResource) results);
		return output;

	}

	@Override
	public String createPatient() {
		Patient patient = new Patient();
		// ..populate the patient object..
		patient.addIdentifier().setSystem("urn:system").setValue("12345");
		patient.addName().setFamily("Smith").addGiven("John");
		patient.addAddress().setCity("Oklahoma").setCountry("USA");

		// Invoke the server create method (and send pretty-printed JSON
		// encoding to the server
		// instead of the default which is non-pretty printed XML)
		MethodOutcome outcome = client.create()
		   .resource(patient)
		   .prettyPrint()
		   .encodedJson()
		   .execute();

		// The MethodOutcome object will contain information about the
		// response from the server, including the ID of the created 
		// resource, the OperationOutcome response, etc. (assuming that
		// any of these things were provided by the server! They may not
		// always be)
		return formatOutput(outcome);
	}

	@Override
	public String updatePatient(String PatientId) {
		// TODO Auto-generated method stub
		return null;
	}



}
