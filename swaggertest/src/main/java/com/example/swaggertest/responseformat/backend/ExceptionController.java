package com.example.swaggertest.responseformat.backend;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.swaggertest.responseformat.CustomException1;
import com.example.swaggertest.responseformat.CustomException2;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler 
{
	@ExceptionHandler(CustomException1.class)
	public ResponseEntity<Object> handleCustomException1(CustomException1 exception)
	{
		String errorMsg = exception.getLocalizedMessage();
		return buildResponseEntity(new APIResponse<Object>(APIResponseKey.EXCEPTION,errorMsg,exception.getCode()));
	}
	
	@ExceptionHandler(CustomException2.class)
	public ResponseEntity<Object> handleCustomException2(CustomException2 exception)
	{
		String errorMsg = exception.getLocalizedMessage();
		return buildResponseEntity(new APIResponse<Object>(APIResponseKey.EXCEPTION,errorMsg,exception.getCode()));
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(Exception exception)
	{
		return buildResponseEntity(new APIResponse<Object>(APIResponseKey.EXCEPTION));
	}
	
	private ResponseEntity<Object> buildResponseEntity(APIResponse<Object> apiResponseDTO)
	{
		return new ResponseEntity<>(apiResponseDTO,HttpStatus.BAD_REQUEST);
	}
	
}