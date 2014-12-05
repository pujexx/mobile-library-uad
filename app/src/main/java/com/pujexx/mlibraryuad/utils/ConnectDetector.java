package com.pujexx.mlibraryuad.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import com.pujexx.mlibraryuad.config.Config;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import android.util.Log;

public class ConnectDetector {
	private Boolean konek = false;
	public  boolean isNetworkAvailable(Context context) {
	    ConnectivityManager connectivityManager 
	          = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
	    return activeNetworkInfo != null;
	}
	
	public  boolean hasActiveInternetConnection(Context context) {
	    if (isNetworkAvailable(context)) {
	    	
	    	 try {
	             HttpURLConnection urlc = (HttpURLConnection) (new URL("http://www.google.com").openConnection());
	             urlc.setRequestProperty("User-Agent", "Test");
	             urlc.setRequestProperty("Connection", "close");
	             urlc.setConnectTimeout(1500); 
	             urlc.connect();
	             return (urlc.getResponseCode() == 200);
	         } catch (IOException e) {
	             Log.e("hae", "Error checking internet connection", e);
	         }
	    } else {
	    	 Log.d("wuwu", "No network available!");
	    }
	    return false;
	}
	
	public static boolean IsReachable(Context context) {
	    // First, check we have any sort of connectivity
	    final ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
	    final NetworkInfo netInfo = connMgr.getActiveNetworkInfo();
	    boolean isReachable = false;

	    if (netInfo != null && netInfo.isConnected()) {
	        // Some sort of connection is open, check if server is reachable
	        try {
	            URL url = new URL("http://www.google.com");
	            HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
	            urlc.setRequestProperty("User-Agent", "Android Application");
	            urlc.setRequestProperty("Connection", "close");
	            urlc.setConnectTimeout(30 * 1000);
	            urlc.connect();
	            isReachable = (urlc.getResponseCode() == 200);
	        } catch (IOException e) {
	            Log.e("awu awu", e.getMessage());
	        }
	    }

	    return isReachable;
	}
	
	public class  isConnect extends AsyncTask<String, String, String>{

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			try{
	            URL myUrl = new URL(Config.base_url);
	            URLConnection connection = myUrl.openConnection();
	            connection.setConnectTimeout(1500);
	            connection.connect();
	            konek = true;
	        } catch (Exception e) {
	            // Handle your exceptions
	            konek =  false;
	        }
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			
		}
		
		
		
	}
}
