package com.fhir.client;

import java.awt.List;
import java.util.ArrayList;

import org.hl7.fhir.dstu3.model.Identifier.IdentifierUse;
import org.hl7.fhir.r4.formats.IParser;
import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.Address.AddressType;
import org.hl7.fhir.r4.model.AllergyIntolerance;
import org.hl7.fhir.r4.model.Annotation;
import org.hl7.fhir.r4.model.Appointment;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Condition;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointUse;
import org.hl7.fhir.r4.model.DiagnosticReport;
import org.hl7.fhir.r4.model.DocumentReference;
import org.hl7.fhir.r4.model.Encounter;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.HumanName.NameUse;
import org.hl7.fhir.r4.model.Immunization;
import org.hl7.fhir.r4.model.MedicationRequest;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Organization;
import org.hl7.fhir.r4.model.Parameters;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Patient.ContactComponent;
import org.hl7.fhir.r4.model.Practitioner;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.codesystems.AddressUse;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.primitive.IdDt;
import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.client.interceptor.AdditionalRequestHeadersInterceptor;
import ca.uhn.fhir.rest.client.interceptor.BasicAuthInterceptor;
import ca.uhn.fhir.rest.client.interceptor.BearerTokenAuthInterceptor;

public class R4 extends ErrorHandler implements FhirInterface {

	static IGenericClient client;
	static FhirContext ctx;

	public R4(String url, String uname, String pwd) {
		ctx = FhirContext.forR4();
		client = ctx.newRestfulGenericClient(url);
		if (pwd.equalsIgnoreCase("$bearer$Token$FHIR$")) {
			BearerTokenAuthInterceptor AuthInterceptor = HTTPTokenAuthorization(uname);
			client.registerInterceptor(AuthInterceptor);
		} else {
			BasicAuthInterceptor AuthInterceptor = HTTPBasicAuthorization(uname, pwd);
			client.registerInterceptor(AuthInterceptor);
		}
	}

	private static BasicAuthInterceptor HTTPBasicAuthorization(String username, String password) {
		BasicAuthInterceptor authInterceptor = new BasicAuthInterceptor(username, password);
		return authInterceptor;

	}

	private static BearerTokenAuthInterceptor HTTPTokenAuthorization(String token) {
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
					.where(AllergyIntolerance.PATIENT.hasId(PatientID)).returnBundle(Bundle.class).execute();
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
					.where(DiagnosticReport.PATIENT.hasId(PatientID)).returnBundle(Bundle.class).execute();
			break;
		case "DocumentReference":
			results = client.search().forResource(DocumentReference.class)
					.where(DocumentReference.PATIENT.hasId(PatientID)).returnBundle(Bundle.class).execute();
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
			results = client.search().forResource(MedicationRequest.class)
					.where(MedicationRequest.PATIENT.hasId(PatientID)).returnBundle(Bundle.class).execute();
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
			results = client.search().forResource(Patient.class).returnBundle(Bundle.class).execute();
			break;
		case "Practitioner":
			results = client.search().forResource(Practitioner.class).returnBundle(Bundle.class).execute();
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
	public String updatePatient(String PatientId, String Payload, Boolean Patch) {
		try {
			try {
				if (Patch.booleanValue()) {
					Patient patient = client.read().resource(Patient.class).withId(PatientId).execute();
					AdditionalRequestHeadersInterceptor interceptor = new AdditionalRequestHeadersInterceptor();
					interceptor.addHeaderValue("If-Match", "W/\"" + patient.getIdElement().getVersionIdPart() + "\"");
					client.registerInterceptor(interceptor);
					MethodOutcome outcome = client.patch().withBody(Payload).withId("Patient/" + PatientId).execute();
					if (outcome.equals(null)) {
						return "{\"details\":\"Success\"}";
					}
					return outcome.getOperationOutcome().toString();
				}
			} catch (NullPointerException e) {
				return "{\"details\":\"Success\"}";
			}
		} catch (Exception e) {
			return error(e);
		}
		return "{\"details\":\"something went wrong\"}";
	}

	private String formatOutput(Bundle results) {
		String output = ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(results);
		return output;

	}

	private String formatOutput(Patient results) {
		String output = ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(results);
		return output;

	}

	@Override
	public String updatePatientAllergy(String AllergyId, String Payload) {
		// try {
		AllergyIntolerance Allergy = client.read().resource(AllergyIntolerance.class).withId(AllergyId).execute();
		String patient = "Patient/" + Payload;

		AllergyIntolerance NewAllergy = new AllergyIntolerance();
		NewAllergy.addNote(new Annotation().setText("Section0_Allergy0"));
		NewAllergy.addCategoryElement().setValueAsString("environment");
		NewAllergy.getAsserter().setReference(patient);

		AdditionalRequestHeadersInterceptor interceptor = new AdditionalRequestHeadersInterceptor();
		interceptor.addHeaderValue("If-Match", "W/\"" + Allergy.getIdElement().getVersionIdPart() + "\"");
		client.registerInterceptor(interceptor);

		MethodOutcome outcome = client.update().resource(Allergy).withId(AllergyId).execute();
		return outcome.getOperationOutcome().getMeta().toString();
		/*
		 * } catch(Exception e) { return error(e); }
		 */
	}

	@Override
	public String createPatient(String Payload) {
		Patient patient = new Patient();
		patient.addName().setFamily("Romesh").addGiven("Sachin Tendulkar").setUse(NameUse.OFFICIAL);

		Reference OrgReference = new Reference("Organization/619848");
		patient.addIdentifier().setAssigner(OrgReference);

		/*patient.addIdentifier()
				.setType(new CodeableConcept()
						.addCoding(new Coding().setCode("SB").setSystem("http://hl7.org/fhir/v2/0203")))
				.setSystem("http://hl7.org/fhir/sid/us-ssn").setValue("123456789");*/
		
		patient.setGender(AdministrativeGender.FEMALE);
		patient.addAddress().setUse(Address.AddressUse.HOME).addLine("Street name, number, direction & P.O. Box etc.")
				.setCity("Name of city, town etc.").setState("Sub-unit of country (abbreviations ok)")
				.setPostalCode("Postal/ZIP code for area").setType(AddressType.PHYSICAL);
		patient.addTelecom().setUse(ContactPointUse.HOME).setSystem(ContactPointSystem.PHONE)
				.setValue("(555) 675 5745");
		patient.addTelecom().setUse(ContactPointUse.HOME).setSystem(ContactPointSystem.PHONE)
				.setValue("(415) 675 5745");
		patient.addTelecom().setUse(ContactPointUse.HOME).setSystem(ContactPointSystem.EMAIL).setValue("test@test.com");
		ContactComponent emergencyContact = new ContactComponent();
		emergencyContact.addTelecom().setSystem(ContactPointSystem.PHONE).setValue("(111) 675 5745")
				.setUse(ContactPointUse.HOME);
		emergencyContact.addRelationship().addCoding().setSystem("http://hl7.org/fhir/ValueSet/v2-0131").setCode("C");
		emergencyContact
				.setName(new HumanName().setFamily("Jayaraman").addGiven("Shankar Ganesh").setUse(NameUse.OFFICIAL));
		patient.addContact(emergencyContact);

		/*Reference practitionerReference = new Reference("Practitioner/605925");
		ArrayList<Reference> ref = new ArrayList<>();
		ref.add(practitionerReference);
		patient.setGeneralPractitioner(ref);*/
		
		String encoded = ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(patient);
		MethodOutcome outcome = client.create().resource(patient).encodedJson().execute();
		System.out.print(outcome.getId());
		// System.out.print(encoded);
		return outcome.getResource().toString();
	}

}
