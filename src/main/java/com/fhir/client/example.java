package com.fhir.client;

public class example {
	
	public static void main(String args[]) {
		String url4 = "https://fhir-ehr.sandboxcerner.com/r4/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca";
		
		FhirFactory fhirFactory = new FhirFactory();
		
		/*
		String url2 = "http://52.21.3.60:57773/csp/healthshare/hsods/fhir/dstu2/";
		String url3 = "http://52.21.3.60:57773/csp/healthshare/hsods/fhir/stu3/";
		String uname = "_System";
		String pwd = "SYS";
		FhirInterface client2 = fhirFactory.initFhir("Dstu2", url2, uname, pwd);
		FhirInterface client3 = fhirFactory.initFhir("Dstu3", url3, uname, pwd);
		//String Patient = client.getPatient("100000006",");
		String Patient = client2.getPatientResourceList("100000006","AllergyIntolerance");
		System.out.print(Patient);
		String Patient = client4.getPatientResourceList("5938008","AllergyIntolerance");
		System.out.print(Patient);
		String PatientUpdate = client4.updatePatientAllergy("8135733", "5938008");
		System.out.print(PatientUpdate);
		//String NewPatient = client4.getPatientDemographics("1316024");
		String NewPatient = client4.getPatientDemographics("5998007");
		System.out.print(NewPatient);*/
		
		FhirInterface client4 = fhirFactory.initFhir("R4", url4,"eyJraWQiOiIyMDIwLTAxLTA0VDAzOjM1OjExLjk3Mi5lYyIsInR5cCI6IkpXVCIsImFsZyI6IkVTMjU2In0.eyJzdWIiOiJwb3J0YWwiLCJ1cm46Y29tOmNlcm5lcjphdXRob3JpemF0aW9uOmNsYWltcyI6eyJ2ZXIiOiIxLjAiLCJlbmNvdW50ZXIiOiI0NDg3OTA2IiwidG50IjoiMGI4YTAxMTEtZThlNi00YzI2LWE5MWMtNTA2OWNiYzZiMWNhIiwiYXpzIjoibGF1bmNoIG9ubGluZV9hY2Nlc3MgdXNlclwvQWNjb3VudC5yZWFkIHVzZXJcL0FsbGVyZ3lJbnRvbGVyYW5jZS5yZWFkIHVzZXJcL0FwcG9pbnRtZW50LnJlYWQgdXNlclwvQmluYXJ5LnJlYWQgdXNlclwvQ29uZGl0aW9uLnJlYWQgdXNlclwvQ292ZXJhZ2UucmVhZCB1c2VyXC9EZXZpY2UucmVhZCB1c2VyXC9Eb2N1bWVudFJlZmVyZW5jZS5yZWFkIHVzZXJcL0VuY291bnRlci5yZWFkIHVzZXJcL0ltbXVuaXphdGlvbi5yZWFkIHVzZXJcL01lZGljYXRpb25SZXF1ZXN0LnJlYWQgdXNlclwvT3JnYW5pemF0aW9uLnJlYWQgdXNlclwvUGF0aWVudC5yZWFkIHVzZXJcL1ByYWN0aXRpb25lci5yZWFkIHVzZXJcL1Byb2NlZHVyZS5yZWFkIHVzZXJcL1JlbGF0ZWRQZXJzb24ucmVhZCB1c2VyXC9BbGxlcmd5SW50b2xlcmFuY2Uud3JpdGUgdXNlclwvQXBwb2ludG1lbnQud3JpdGUgdXNlclwvQmFzaWMud3JpdGUgdXNlclwvQ29uZGl0aW9uLndyaXRlIHVzZXJcL0NvdmVyYWdlLndyaXRlIHVzZXJcL0VuY291bnRlci53cml0ZSB1c2VyXC9Pcmdhbml6YXRpb24ud3JpdGUgdXNlclwvUGF0aWVudC53cml0ZSB1c2VyXC9QcmFjdGl0aW9uZXIud3JpdGUiLCJ1c2VyIjoiNDQ2NDAwNyIsInBhdGllbnQiOiI1MzM4MDA3In0sImF6cCI6IjI0MjU2MTJkLTVhNTktNGQ1Ni04NWE3LTUwM2Q2NWMzZjk5OSIsImlzcyI6Imh0dHBzOlwvXC9hdXRob3JpemF0aW9uLnNhbmRib3hjZXJuZXIuY29tXC8iLCJleHAiOjE1NzgxNTU3MDgsImlhdCI6MTU3ODE1NTEwOCwianRpIjoiMzQ1NGU5MTQtNWQ2MS00OWJkLTgyNmUtMzMzNWExOWU0MjJiIiwidXJuOmNlcm5lcjphdXRob3JpemF0aW9uOmNsYWltczp2ZXJzaW9uOjEiOnsidmVyIjoiMS4wIiwicHJvZmlsZXMiOnsibWlsbGVubml1bS12MSI6eyJwZXJzb25uZWwiOiI0NDY0MDA3IiwiZW5jb3VudGVyIjoiNDQ4NzkwNiJ9LCJzbWFydC12MSI6eyJwYXRpZW50cyI6WyI1MzM4MDA3Il0sImF6cyI6ImxhdW5jaCBvbmxpbmVfYWNjZXNzIHVzZXJcL0FjY291bnQucmVhZCB1c2VyXC9BbGxlcmd5SW50b2xlcmFuY2UucmVhZCB1c2VyXC9BcHBvaW50bWVudC5yZWFkIHVzZXJcL0JpbmFyeS5yZWFkIHVzZXJcL0NvbmRpdGlvbi5yZWFkIHVzZXJcL0NvdmVyYWdlLnJlYWQgdXNlclwvRGV2aWNlLnJlYWQgdXNlclwvRG9jdW1lbnRSZWZlcmVuY2UucmVhZCB1c2VyXC9FbmNvdW50ZXIucmVhZCB1c2VyXC9JbW11bml6YXRpb24ucmVhZCB1c2VyXC9NZWRpY2F0aW9uUmVxdWVzdC5yZWFkIHVzZXJcL09yZ2FuaXphdGlvbi5yZWFkIHVzZXJcL1BhdGllbnQucmVhZCB1c2VyXC9QcmFjdGl0aW9uZXIucmVhZCB1c2VyXC9Qcm9jZWR1cmUucmVhZCB1c2VyXC9SZWxhdGVkUGVyc29uLnJlYWQgdXNlclwvQWxsZXJneUludG9sZXJhbmNlLndyaXRlIHVzZXJcL0FwcG9pbnRtZW50LndyaXRlIHVzZXJcL0Jhc2ljLndyaXRlIHVzZXJcL0NvbmRpdGlvbi53cml0ZSB1c2VyXC9Db3ZlcmFnZS53cml0ZSB1c2VyXC9FbmNvdW50ZXIud3JpdGUgdXNlclwvT3JnYW5pemF0aW9uLndyaXRlIHVzZXJcL1BhdGllbnQud3JpdGUgdXNlclwvUHJhY3RpdGlvbmVyLndyaXRlIn19LCJjbGllbnQiOnsibmFtZSI6IkNvcmVtb2JpbGUgLSBQcm92aWRlciIsImlkIjoiMjQyNTYxMmQtNWE1OS00ZDU2LTg1YTctNTAzZDY1YzNmOTk5In0sInVzZXIiOnsicHJpbmNpcGFsIjoicG9ydGFsIiwicGVyc29uYSI6InByb3ZpZGVyIiwiaWRzcCI6IjBiOGEwMTExLWU4ZTYtNGMyNi1hOTFjLTUwNjljYmM2YjFjYSIsInNlc3Npb25JZCI6Ijk1ZjAyNTA0LTQ4YTYtNDVkZi04M2E3LWRhZWRiZjIwZWFjYyIsInByaW5jaXBhbFR5cGUiOiJVU0VSTkFNRSIsInByaW5jaXBhbFVyaSI6Imh0dHBzOlwvXC9taWxsZW5uaWEuc2FuZGJveGNlcm5lci5jb21cL2luc3RhbmNlXC8wYjhhMDExMS1lOGU2LTRjMjYtYTkxYy01MDY5Y2JjNmIxY2FcL3ByaW5jaXBhbFwvMDAwMC4wMDAwLjAwNDQuMUQ4NyIsImlkc3BVcmkiOiJodHRwczpcL1wvbWlsbGVubmlhLnNhbmRib3hjZXJuZXIuY29tXC9hY2NvdW50c1wvZmhpcnBsYXkudGVtcF9yaG8uY2VybmVyYXNwLmNvbVwvMGI4YTAxMTEtZThlNi00YzI2LWE5MWMtNTA2OWNiYzZiMWNhXC9sb2dpbiJ9LCJ0ZW5hbnQiOiIwYjhhMDExMS1lOGU2LTRjMjYtYTkxYy01MDY5Y2JjNmIxY2EifX0.ESPiOc2efgr_sjy9bjionMpaFTumC7HmDbwWHUxMSZqMOYs2Tmy_-9RLJPnkEAflhYCDAGuR5y38df2Ef-G5Hw", "$bearer$Token$FHIR$");
		String newPat = client4.createPatient("");
		
		/*String PatientId = "5938008";
		
		String patch = "[\n" + "  {\n" + "    \"path\": \"/name/0/id\",\n" + "    \"op\": \"test\",\n"
				+ "    \"value\": \"CI-" + PatientId + "-0\"\n" + "  },\n" + "  {\n"
				+ "    \"path\": \"/name/0/given\",\n" + "    \"op\": \"replace\",\n" + "    \"value\": [\n"
				+ "      \"Shankar\",\n" + "      \"Ganesh\"\n" + "    ]\n" + "  }\n" + "]";
		
		String patchNew = "[\n" + 
				"    {\n" + 
				"    \"path\": \"/name/0/id\",\n" + 
				"    \"op\": \"test\",\n" + 
				"    \"value\": \"CI-" + PatientId + "-0\"\n" + 
				"    },\n" + 
				"    {\n" + 
				"        \"path\": \"/name/0/given\",\n" + 
				"        \"op\": \"replace\",\n" + 
				"        \"value\": [\n" + 
				"            \"Ganesh\",\n" + 
				"            \"Jayaraman\"\n" + 
				"        ]\n" + 
				"    },\n" + 
				"    {\n" + 
				"        \"path\": \"/name/0/family\",\n" + 
				"        \"op\": \"replace\",\n" + 
				"        \"value\": \"SHANKAR\"\n" + 
				"    }\n" + 
				"]";
		
		String UpdatePatient = client4.updatePatient("5938008",patch, true);*/
		System.out.print(newPat);
		
		
	}

}
