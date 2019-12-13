package com.example.swaggertest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.swaggertest.responseformat.backend.APIResponse;
import com.example.swaggertest.responseformat.backend.APIResponseKey;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="class level description")
public class SampleController 
{
	@GetMapping(value="/sample")
	@ApiOperation(value="method level description",response = String.class)
	public APIResponse<String> test()
	{
		return new APIResponse<String>(APIResponseKey.SUCCESS,"Test sucessfull");
	}
}
