package in.fhir;

public class FhirFactory {

	static Object client;
	static String url, uname, pwd;

	public static void main(String[] args) {

		FhirFactory client = new FhirFactory("Dstu2", url, uname, pwd);

		client.getPatRsrcDetail("100000006", "Observation");
	}

	private Object ClientObj(String ver, String url, String uname, String pwd) {
		if (ver == null) {
			return null;
		}
		if (ver.equalsIgnoreCase("Dstu2")) {
			return new Dstu2(url, uname, pwd);
		}
		return null;
	}

	public FhirFactory(String ver, String url, String uname, String pwd) {
		url = "http://52.21.3.60:57773/csp/healthshare/hsods/fhir/dstu2/";
		uname = "_System";
		pwd = "SYS";
		client = ClientObj("Dstu2", url, uname, pwd);
	}

	public void getPatRsrcDetail(String patId, String bundle) {
		client = ClientObj("Dstu2", url, uname, pwd);
		((FhirInterface) client).getPatientResourceDetail("100000006", "Observation");

	}

}
