package com.example.resttemplatetest.configuration;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration 
{
	
	@Bean
	public RestTemplate restTemplate() 
	{
		
	    return new RestTemplate();
	}
	
	@Bean
	public HttpClient getHttpClient()
	{
		CredentialsProvider provider = new BasicCredentialsProvider();
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("username", "password");
		provider.setCredentials(AuthScope.ANY, credentials);
		
		return HttpClientBuilder.create()
				.setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
				.setDefaultCredentialsProvider(provider)
				.build();
	}

}