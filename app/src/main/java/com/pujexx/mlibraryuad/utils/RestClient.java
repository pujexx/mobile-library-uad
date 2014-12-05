package com.pujexx.mlibraryuad.utils;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.pujexx.mlibraryuad.config.Config;

public class RestClient {
	
	public String getMethod(String Uri) throws ClientProtocolException, IOException{
		String respon = null;
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(Config.base_url+Uri);
		HttpResponse response = client.execute(get);
		respon = Convert.request(response);
		return respon;
	}
	
}
