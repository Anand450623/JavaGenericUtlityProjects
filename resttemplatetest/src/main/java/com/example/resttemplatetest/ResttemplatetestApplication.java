package com.example.resttemplatetest;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.resttemplatetest.service.Services;

@SpringBootApplication
public class ResttemplatetestApplication 
{

	public static void main(String[] args) throws ClientProtocolException, IOException 
	{
		ApplicationContext context = SpringApplication.run(ResttemplatetestApplication.class, args);
		Services service = context.getBean(Services.class);
		service.check2();
	}

}
