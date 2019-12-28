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
		FhirInterface client4 = fhirFactory.initFhir("R4", url4, "eyJraWQiOiIyMDE5LTEyLTI3VDAzOjM1OjEwLjk1MC5lYyIsInR5cCI6IkpXVCIsImFsZyI6IkVTMjU2In0.eyJzdWIiOiJwb3J0YWwiLCJ1cm46Y29tOmNlcm5lcjphdXRob3JpemF0aW9uOmNsYWltcyI6eyJ2ZXIiOiIxLjAiLCJlbmNvdW50ZXIiOiI0NjQ5OTA5IiwidG50IjoiMGI4YTAxMTEtZThlNi00YzI2LWE5MWMtNTA2OWNiYzZiMWNhIiwiYXpzIjoibGF1bmNoIG9ubGluZV9hY2Nlc3MgdXNlclwvUGF0aWVudC5yZWFkIHVzZXJcL1BhdGllbnQud3JpdGUgdXNlclwvQWxsZXJneUludG9sZXJhbmNlLnJlYWQgdXNlclwvQWxsZXJneUludG9sZXJhbmNlLndyaXRlIiwidXNlciI6IjQ0NjQwMDciLCJwYXRpZW50IjoiNTkzODAwOCJ9LCJhenAiOiIyNDI1NjEyZC01YTU5LTRkNTYtODVhNy01MDNkNjVjM2Y5OTkiLCJpc3MiOiJodHRwczpcL1wvYXV0aG9yaXphdGlvbi5zYW5kYm94Y2VybmVyLmNvbVwvIiwiZXhwIjoxNTc3NTQ2MzQyLCJpYXQiOjE1Nzc1NDU3NDIsImp0aSI6ImQxNDZmMDMyLTZhODEtNGQwZS1hZTFiLWViMWU1ZTU4ZTljYyIsInVybjpjZXJuZXI6YXV0aG9yaXphdGlvbjpjbGFpbXM6dmVyc2lvbjoxIjp7InZlciI6IjEuMCIsInByb2ZpbGVzIjp7Im1pbGxlbm5pdW0tdjEiOnsicGVyc29ubmVsIjoiNDQ2NDAwNyIsImVuY291bnRlciI6IjQ2NDk5MDkifSwic21hcnQtdjEiOnsicGF0aWVudHMiOlsiNTkzODAwOCJdLCJhenMiOiJsYXVuY2ggb25saW5lX2FjY2VzcyB1c2VyXC9QYXRpZW50LnJlYWQgdXNlclwvUGF0aWVudC53cml0ZSB1c2VyXC9BbGxlcmd5SW50b2xlcmFuY2UucmVhZCB1c2VyXC9BbGxlcmd5SW50b2xlcmFuY2Uud3JpdGUifX0sImNsaWVudCI6eyJuYW1lIjoiQ29yZW1vYmlsZSAtIFByb3ZpZGVyIiwiaWQiOiIyNDI1NjEyZC01YTU5LTRkNTYtODVhNy01MDNkNjVjM2Y5OTkifSwidXNlciI6eyJwcmluY2lwYWwiOiJwb3J0YWwiLCJwZXJzb25hIjoicHJvdmlkZXIiLCJpZHNwIjoiMGI4YTAxMTEtZThlNi00YzI2LWE5MWMtNTA2OWNiYzZiMWNhIiwic2Vzc2lvbklkIjoiY2IxNWU2NzQtYzY5Ni00OWQ4LWExZWItYTA0ZjQ5ODkwMGRmIiwicHJpbmNpcGFsVHlwZSI6IlVTRVJOQU1FIiwicHJpbmNpcGFsVXJpIjoiaHR0cHM6XC9cL21pbGxlbm5pYS5zYW5kYm94Y2VybmVyLmNvbVwvaW5zdGFuY2VcLzBiOGEwMTExLWU4ZTYtNGMyNi1hOTFjLTUwNjljYmM2YjFjYVwvcHJpbmNpcGFsXC8wMDAwLjAwMDAuMDA0NC4xRDg3IiwiaWRzcFVyaSI6Imh0dHBzOlwvXC9taWxsZW5uaWEuc2FuZGJveGNlcm5lci5jb21cL2FjY291bnRzXC9maGlycGxheS50ZW1wX3Joby5jZXJuZXJhc3AuY29tXC8wYjhhMDExMS1lOGU2LTRjMjYtYTkxYy01MDY5Y2JjNmIxY2FcL2xvZ2luIn0sInRlbmFudCI6IjBiOGEwMTExLWU4ZTYtNGMyNi1hOTFjLTUwNjljYmM2YjFjYSJ9fQ.Fk6ND08OhChXWcy4cLSzWnBIoH6PsrQ0z8xqVBRAKeG10aRp2K_G-g3jfMht3oKNIR6pmOZlipRdArL4HA6ppg", "$bearer$Token$FHIR$");
		/*//String Patient = client.getPatient("100000006",");
		String Patient = client2.getPatientResourceList("100000006","AllergyIntolerance");
		System.out.print(Patient);*/
		//String NewPatient = client4.getPatientDemographics("1316024");
		String UpdatePatient = client4.updatePatient("5938008");
		System.out.print(UpdatePatient);
		String Patient = client4.getPatientResourceList("5938008","AllergyIntolerance");
		System.out.print(Patient);
		String PatientUpdate = client4.updatePatientAllergy("8135733", "5938008");
		System.out.print(PatientUpdate);
		
	}

}
