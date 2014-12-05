package com.pujexx.mlibraryuad;

/*
    @author  : Puji Rahmadiyanto 
    @website : pujexx.web.id
    @file    : Login.java
    @version : 1.0 

*/

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.pujexx.mlibraryuad.R;
import com.pujexx.mlibraryuad.custom.TextViewHelvetica;

public class Login extends Activity {

    private LinearLayout btn_back;
    private TextViewHelvetica login_back_text;
    private ImageView login_back_icon;
    private Animation animation1, animation2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_back = (LinearLayout) findViewById(R.id.btn_back);
        login_back_icon = (ImageView) findViewById(R.id.login_back_icon);
        login_back_text = (TextViewHelvetica) findViewById(R.id.login_back_text);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onResume();
        animation1 = AnimationUtils.loadAnimation(this, R.anim.fadein);
        animation2 = AnimationUtils.loadAnimation(this, R.anim.nav_left_in);
        login_back_icon.setAnimation(animation1);
        login_back_text.setAnimation(animation2);
        overridePendingTransition(R.anim.push_left_in , R.anim.push_left_out);

    }

    @Override
    public void finish() {
        super.finish();
        animation1 = AnimationUtils.loadAnimation(this, R.anim.fadeout);
        animation2 = AnimationUtils.loadAnimation(this, R.anim.nav_right_out);
        login_back_icon.setAnimation(animation1);
        login_back_text.setAnimation(animation2);
        overridePendingTransition(R.anim.push_right_in , R.anim.push_right_out);
    }
}
