package com.example.swaggertest.responseformat;

import com.example.swaggertest.responseformat.backend.APIResponseKey;

public class CustomException1 extends RuntimeException 
{

	private static final long serialVersionUID = -7560769458516199593L;
	
	final Integer code;
	
	public CustomException1(APIResponseKey key) 
	{
		super(key.getMessage());
		this.code=key.getCode();
	}
	
	public CustomException1(APIResponseKey key,String message)
	{
		super(message);
		this.code = key.getCode();
	}

	public Integer getCode() {
		return code;
	}

}