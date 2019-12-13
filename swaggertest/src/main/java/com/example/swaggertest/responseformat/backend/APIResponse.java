package com.example.swaggertest.responseformat.backend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class APIResponse<E>
{
	private Integer responseCode;
	private String message;
	private E payload;
	private List<APIError> errors;
	private Integer code;
	private Date timeStamp;
	
	private APIResponse()
	{
		this.timeStamp = new Date();
		this.errors = new ArrayList<>();
	}
	
	
	public APIResponse(APIResponseKey apiResponseKey,String errorMessage,Integer code)
	{
		this();
		this.responseCode = apiResponseKey.getCode();
		this.errors.add(new APIError(apiResponseKey.getCode(), apiResponseKey.getMessage()));
	}
	
	public APIResponse(Integer responseCode, String message, E payload, APIError error)
	{
		this();
		this.responseCode = responseCode;
		this.message = message;
		this.payload = payload;
		this.errors.add(error);
	}
	
	public APIResponse(Integer responseCode, E payload)
	{
		this();
		this.responseCode = responseCode;
		this.payload = payload;
	}
	
	public APIResponse(APIResponseKey responseCode, String message)
	{
		this();
		this.responseCode = responseCode.getCode();
		this.message = message;
	}
	
	public APIResponse(APIResponseKey apiResponseKey)
	{
		this();
		this.responseCode = apiResponseKey.getCode();
		this.errors.add(new APIError(apiResponseKey.getCode(), apiResponseKey.getMessage()));
	}

	public Integer getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public E getPayload() {
		return payload;
	}

	public void setPayload(E payload) {
		this.payload = payload;
	}

	public List<APIError> getErrors() {
		return errors;
	}

	public void setErrors(List<APIError> errors) {
		this.errors = errors;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}