package com.sparrow.dto;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.fasterxml.jackson.annotation.JsonInclude;

@Component
@JsonInclude(Include.NON_NULL)
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Response<T> {
	private int responseCode;
	private String message;
	private String requestedURI;
	private T data;
	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRequestedURI() {
		return requestedURI;
	}

	public void setRequestedURI(String requestedURI) {
		this.requestedURI = requestedURI;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Response(int responseCode, String message, String requestedURI, T data) {
		super();
		this.responseCode = responseCode;
		this.message = message;
		this.requestedURI = requestedURI;
		this.data = data;
	}

	public Response(int responseCode, String message, T data) {
		super();
		this.responseCode = responseCode;
		this.message = message;
		this.data = data;
	}

	public Response(int responseCode, String message) {
		super();
		this.responseCode = responseCode;
		this.message = message;
	}

}
