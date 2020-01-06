package com.fhir.client;

public class ErrorHandler {

	public String error(Exception Error) {
		String error = Error.getLocalizedMessage().toString();
		if (error.contains("\"")) {
			error = error.replace("\"", "'");
		}
		return "{ \"details\":\"" + error + "\"}";
	}

	public String success() {
		return "{\"details\":\"Success\"}";
	}

	public String somethingWrong() {
		return "{\"details\":\"something went wrong\"}";
	}
};