package com.example.resttemplatetest.service.impl;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.resttemplatetest.service.Services;

@Service
public class ServicesImpl implements Services
{
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	HttpClient client;

	@Override
	public void check() 
	{
		ResponseEntity<String> response = null;
		HttpHeaders header = new HttpHeaders();
		String body = "";
		HttpEntity<String> entity = new HttpEntity<>(body,header);
		
		response = restTemplate.exchange("http://localhost:8080/test/sample", HttpMethod.GET, entity, String.class);
		
		System.err.println(response.getStatusCode());
		System.err.println(response.getBody());
		
	}

	@Override
	public void check2() throws ClientProtocolException, IOException 
	{
		String url = "http://localhost:8080/test/sample";

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);

		// add request header
		//request.addHeader("User-Agent", USER_AGENT);
		HttpResponse response = client.execute(request);

		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
		
		org.apache.http.HttpEntity httpEntity = response.getEntity();
        String apiOutput = EntityUtils.toString(httpEntity);
        
        System.err.println(apiOutput);
        
	}
	
	public void custom() throws ClientProtocolException, IOException
	{
		HttpPut putRequest =  new HttpPut("url");
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.addBinaryBody("name", "message".getBytes(), ContentType.TEXT_PLAIN, "filename");
		putRequest.setEntity(builder.build());
		HttpResponse response = client.execute(putRequest);
		System.err.println(response.getStatusLine().getStatusCode());
	}
	
}