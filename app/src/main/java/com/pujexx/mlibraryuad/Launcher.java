package com.pujexx.mlibraryuad;

/*
    @author  : Puji Rahmadiyanto 
    @website : pujexx.web.id
    @file    : Launcher.java
    @version : 1.0 

*/

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;


import com.pujexx.mlibraryuad.R;



public class Launcher extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        Handler handler = new Handler();


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Launcher.this, Frontend.class);
                startActivity(intent);
                finish();
            }
        }, 3000);



    }

    @Override
    public void finish() {
        super.finish();

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}
