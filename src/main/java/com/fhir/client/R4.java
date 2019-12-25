package com.fhir.client;
import org.hl7.fhir.r4.model.AllergyIntolerance;
import org.hl7.fhir.r4.model.Appointment;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Condition;
import org.hl7.fhir.r4.model.DiagnosticReport;
import org.hl7.fhir.r4.model.DocumentReference;
import org.hl7.fhir.r4.model.Encounter;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Immunization;
import org.hl7.fhir.r4.model.MedicationRequest;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Parameters;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Practitioner;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Reference;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

import org.hl7.fhir.instance.model.api.IBaseResource;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.primitive.IdDt;
import ca.uhn.fhir.parser.json.JsonLikeArray;
import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.client.api.IClientInterceptor;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.client.interceptor.BasicAuthInterceptor;
import ca.uhn.fhir.rest.client.interceptor.BearerTokenAuthInterceptor;

public class R4 implements FhirInterface{
	
	static IGenericClient client;
	static FhirContext ctx;

	public R4(String url, String uname, String pwd) {
		ctx = FhirContext.forR4();
		client = ctx.newRestfulGenericClient(url);
		if(pwd.equalsIgnoreCase("$bearer$Token$FHIR$")) {
			BearerTokenAuthInterceptor AuthInterceptor = HTTPTokenAuthorization(uname);
			client.registerInterceptor(AuthInterceptor);
		}else {
			BasicAuthInterceptor AuthInterceptor = HTTPBasicAuthorization(uname, pwd);
			client.registerInterceptor(AuthInterceptor);
		}
	}
	
	private static BasicAuthInterceptor HTTPBasicAuthorization(String username, String password) {
		BasicAuthInterceptor authInterceptor = new BasicAuthInterceptor(username, password);
		return authInterceptor;

	}
	
	private static BearerTokenAuthInterceptor HTTPTokenAuthorization(String token){
		// Create a context and get the client factory so it can be configured
	
		BearerTokenAuthInterceptor authInterceptor = new BearerTokenAuthInterceptor(token);
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

	@Override
	public String updatePatient(String PatientId) {
		Patient patient = client.read()
                .resource(Patient.class)
                .withId(PatientId)
                .execute(); 
		System.out.println("Version ID: " + patient.getIdElement().getVersionIdPart());
		//patient.addAddress().setCity("Oklahoma").setCountry("USA");
		//System.out.print(formatOutput(patient));
		Patient pat = new Patient();

		JsonArray arr = new JsonArray(); 
		JsonObject obj=new JsonObject();    
		obj.addProperty("op","replace");  
		obj.addProperty("path","/birthDate");  
		obj.addProperty("value","1990-09-15");  
		arr.add(obj); 

		String patch = "[\n" + 
				"  {\n" + 
				"    \"path\": \"/name/0/id\",\n" + 
				"    \"op\": \"test\",\n" + 
				"    \"value\": \"CI-"+PatientId+"-0\"\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"path\": \"/name/0/given\",\n" + 
				"    \"op\": \"replace\",\n" + 
				"    \"value\": [\n" + 
				"      \"Shankar\",\n" + 
				"      \"Ganesh\"\n" + 
				"    ]\n" + 
				"  }\n" + 
				"]";
		MethodOutcome outcome = client.patch()
				.withBody(patch)
				.withId("Patient/"+PatientId)
				.withAdditionalHeader("If-Match","W/\""+patient.getIdElement().getVersionIdPart()+"\"")
				.execute();

		// The MethodOutcome object will contain information about the
		// response from the server, including the ID of the created 
		// resource, the OperationOutcome response, etc. (assuming that
		// any of these things were provided by the server! They may not
		// always be)
		
		//System.out.println("Got ID: " + outcome.getResponseHeaders().get("status").toString());
		return outcome.getResponseHeaders().get("status").toString();
	}
	
	@Override
	public String createPatient() {
		// Create a patient object
		Patient patient = new Patient();
		// ..populate the patient object..
		patient.addIdentifier().setSystem("urn:system").setValue("12345");
		patient.addName().setFamily("Smith").addGiven("John");
		//patient.addAddress().setCity("Oklahoma").setCountry("USA");

		// Invoke the server create method (and send pretty-printed JSON
		// encoding to the server
		// instead of the default which is non-pretty printed XML)
		MethodOutcome outcome = client.create()
		   .resource(patient)
		   .execute();

		// The MethodOutcome object will contain information about the
		// response from the server, including the ID of the created 
		// resource, the OperationOutcome response, etc. (assuming that
		// any of these things were provided by the server! They may not
		// always be)
		IdType id = (IdType) outcome.getId();
		System.out.println("Got ID: " + id.getValue());
		return id.getValue();
	}
	
	private String formatOutput(Bundle results) {
		String output = ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(results);
		return output;
		
	}
	
	private String formatOutput(Patient results) {
		String output = ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(results);
		return output;
		
	}
}
