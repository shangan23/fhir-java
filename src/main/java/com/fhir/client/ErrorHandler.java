package com.fhir.client;

public class ErrorHandler {

	public String error(Exception Error) {
		String error = Error.getLocalizedMessage().toString();
		if (error.contains("\"")) {
			error = error.replace("\"", "'");
		}
		return "{ \"details\":\"" + error + "\"}";
	}
};