package com.example.swaggertest.responseformat.backend;

public class APIError 
{
	private Integer code;
	private String message;

	public APIError() 
	{
		super();
	}

	public APIError(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}