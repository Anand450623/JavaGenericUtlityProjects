package com.example.swaggertest.responseformat;

import com.example.swaggertest.responseformat.backend.APIResponseKey;

public class CustomException2 extends RuntimeException 
{
	
	private static final long serialVersionUID = 2899846252357956546L;
	
	final Integer code;
	
	public CustomException2(APIResponseKey key) 
	{
		super(key.getMessage());
		this.code=key.getCode();
	}
	
	public CustomException2(APIResponseKey key,String message)
	{
		super(message);
		this.code = key.getCode();
	}

	public Integer getCode() {
		return code;
	}

}