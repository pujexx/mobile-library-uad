package com.pujexx.mlibraryuad;


/*
    @author  : Puji Rahmadiyanto 
    @website : pujexx.web.id
    @file    : ContohDownload.java
    @version : 1.0 

*/

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.pujexx.mlibraryuad.R;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class ContohDownload extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contoh_download);
        new asynDownload().execute();
    }

    class asynDownload extends AsyncTask<String, String, String>{
        @Override
        protected String doInBackground(String... strings) {
            int count;
            try{
                URL url = new URL("http://digilib.uad.ac.id/download/Download/file/ENI%20DWI%20SUSANTI-P_MATEMATIKA.pdf/penelitian");
                URLConnection connection = url.openConnection();
                connection.connect();

                int lengoffile = connection.getContentLength();

                InputStream input = new BufferedInputStream(url.openStream(), 8192);
                OutputStream ouput = new FileOutputStream("/sdcard/download.pdf");

                byte data[] = new byte[1024];
                long total = 0;
                while ((count = input.read(data)) != 1){
                    total += count;
                    publishProgress(""+(int)((total*100)/lengoffile));
                    ouput.write(data,0,count);
                }
                ouput.flush();
                ouput.close();
                input.close();

            }catch (Exception e){

            }

            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            //Toast.makeText(getApplicationContext(), values[0], Toast.LENGTH_SHORT).show();
            Log.d("download", values[0]);
        }
    }
}
