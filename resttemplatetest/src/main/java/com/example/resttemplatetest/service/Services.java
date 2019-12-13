package com.example.resttemplatetest.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public interface Services 
{
	public void check();
	public void check2() throws ClientProtocolException, IOException;
}
