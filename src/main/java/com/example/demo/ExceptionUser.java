package com.example.demo;

public class ExceptionUser {
	private String errorMessage;
	private String requestedURI;
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getrequestedURI() {
		return requestedURI;
	}
	public void CallerURI(String requestedURI) {
		this.requestedURI = requestedURI;
	}
	
	

}
