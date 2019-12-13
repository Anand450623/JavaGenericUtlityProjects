package com.example.swaggertest.responseformat.backend;

public enum APIResponseKey 
{
	SUCCESS(1000,"Success"),
	EXCEPTION(4000,"UNCALLED EXCEPTION");
	
	private Integer code;
	private String message;
	
	private APIResponseKey(Integer code,String message)
	{
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