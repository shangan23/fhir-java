package com.fhir.client;

public class example {
	
	public static void main(String args[]) {
		String url2 = "http://52.21.3.60:57773/csp/healthshare/hsods/fhir/dstu2/";
		String url3 = "http://52.21.3.60:57773/csp/healthshare/hsods/fhir/stu3/";
		String url4 = "https://fhir-ehr.sandboxcerner.com/r4/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca";
		String uname = "_System";
		String pwd = "SYS";
		FhirFactory fhirFactory = new FhirFactory();
		FhirInterface client2 = fhirFactory.initFhir("Dstu2", url2, uname, pwd);
		FhirInterface client3 = fhirFactory.initFhir("Dstu3", url3, uname, pwd);
		FhirInterface client4 = fhirFactory.initFhir("R4", url4,"eyJraWQiOiIyMDE5LTEyLTI5VDAzOjM1OjExLjExOS5lYyIsInR5cCI6IkpXVCIsImFsZyI6IkVTMjU2In0.eyJzdWIiOiJwb3J0YWwiLCJ1cm46Y29tOmNlcm5lcjphdXRob3JpemF0aW9uOmNsYWltcyI6eyJ2ZXIiOiIxLjAiLCJlbmNvdW50ZXIiOiI0ODA3OTA2IiwidG50IjoiMGI4YTAxMTEtZThlNi00YzI2LWE5MWMtNTA2OWNiYzZiMWNhIiwiYXpzIjoibGF1bmNoIG9ubGluZV9hY2Nlc3MgdXNlclwvUGF0aWVudC5yZWFkIHVzZXJcL1BhdGllbnQud3JpdGUgdXNlclwvQWxsZXJneUludG9sZXJhbmNlLnJlYWQgdXNlclwvQWxsZXJneUludG9sZXJhbmNlLndyaXRlIiwidXNlciI6IjQ0NjQwMDciLCJwYXRpZW50IjoiNjk0NjAwNyJ9LCJhenAiOiIyNDI1NjEyZC01YTU5LTRkNTYtODVhNy01MDNkNjVjM2Y5OTkiLCJpc3MiOiJodHRwczpcL1wvYXV0aG9yaXphdGlvbi5zYW5kYm94Y2VybmVyLmNvbVwvIiwiZXhwIjoxNTc3NzI5MTEzLCJpYXQiOjE1Nzc3Mjg1MTMsImp0aSI6IjM4NWNjZGJmLTVlMDItNGQ0OS1iOGY5LTM5ODRjZDYyMzVlNCIsInVybjpjZXJuZXI6YXV0aG9yaXphdGlvbjpjbGFpbXM6dmVyc2lvbjoxIjp7InZlciI6IjEuMCIsInByb2ZpbGVzIjp7Im1pbGxlbm5pdW0tdjEiOnsicGVyc29ubmVsIjoiNDQ2NDAwNyIsImVuY291bnRlciI6IjQ4MDc5MDYifSwic21hcnQtdjEiOnsicGF0aWVudHMiOlsiNjk0NjAwNyJdLCJhenMiOiJsYXVuY2ggb25saW5lX2FjY2VzcyB1c2VyXC9QYXRpZW50LnJlYWQgdXNlclwvUGF0aWVudC53cml0ZSB1c2VyXC9BbGxlcmd5SW50b2xlcmFuY2UucmVhZCB1c2VyXC9BbGxlcmd5SW50b2xlcmFuY2Uud3JpdGUifX0sImNsaWVudCI6eyJuYW1lIjoiQ29yZW1vYmlsZSAtIFByb3ZpZGVyIiwiaWQiOiIyNDI1NjEyZC01YTU5LTRkNTYtODVhNy01MDNkNjVjM2Y5OTkifSwidXNlciI6eyJwcmluY2lwYWwiOiJwb3J0YWwiLCJwZXJzb25hIjoicHJvdmlkZXIiLCJpZHNwIjoiMGI4YTAxMTEtZThlNi00YzI2LWE5MWMtNTA2OWNiYzZiMWNhIiwic2Vzc2lvbklkIjoiZGY2ODBmZjQtMTY1Yi00OTNlLWFhZDUtOGI2MTMxNWQxZGYyIiwicHJpbmNpcGFsVHlwZSI6IlVTRVJOQU1FIiwicHJpbmNpcGFsVXJpIjoiaHR0cHM6XC9cL21pbGxlbm5pYS5zYW5kYm94Y2VybmVyLmNvbVwvaW5zdGFuY2VcLzBiOGEwMTExLWU4ZTYtNGMyNi1hOTFjLTUwNjljYmM2YjFjYVwvcHJpbmNpcGFsXC8wMDAwLjAwMDAuMDA0NC4xRDg3IiwiaWRzcFVyaSI6Imh0dHBzOlwvXC9taWxsZW5uaWEuc2FuZGJveGNlcm5lci5jb21cL2FjY291bnRzXC9maGlycGxheS50ZW1wX3Joby5jZXJuZXJhc3AuY29tXC8wYjhhMDExMS1lOGU2LTRjMjYtYTkxYy01MDY5Y2JjNmIxY2FcL2xvZ2luIn0sInRlbmFudCI6IjBiOGEwMTExLWU4ZTYtNGMyNi1hOTFjLTUwNjljYmM2YjFjYSJ9fQ.bN3B1WegN2U1IjpupzYHgdEde3nBiAGjhdKgt2j434P6X0MRNf9WKeV5LPYuoJawF7rkYlWM1ExhaNdFLOXv4g", "$bearer$Token$FHIR$");
		/*//String Patient = client.getPatient("100000006",");
		String Patient = client2.getPatientResourceList("100000006","AllergyIntolerance");
		System.out.print(Patient);*/
		//String NewPatient = client4.getPatientDemographics("1316024");
		/*String UpdatePatient = client4.updatePatient("5938008");
		System.out.print(UpdatePatient);*/
		String Patient = client4.getPatientResourceList("5938008","AllergyIntolerance");
		System.out.print(Patient);
		String PatientUpdate = client4.updatePatientAllergy("8135733", "5938008");
		System.out.print(PatientUpdate);
		
	}

}
