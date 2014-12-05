package com.pujexx.mlibraryuad;

/*
    @author  : Puji Rahmadiyanto 
    @website : pujexx.web.id
    @file    : BookDetail.java
    @version : 1.0 

*/


import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.pujexx.mlibraryuad.R;
import com.pujexx.mlibraryuad.custom.DrawerArrowDrawable;

public class BookDetail extends Activity {

    private DrawerArrowDrawable drawerArrowDrawable;
    private LinearLayout background_navbar;
    private ImageView navbar_right;
    private  ImageView imageView;
    private Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_detail);

        background_navbar = (LinearLayout) findViewById(R.id.background_navbar);
        navbar_right = (ImageView) findViewById(R.id.menu_right);
        navbar_right.setVisibility(View.INVISIBLE);

        background_navbar.setBackgroundColor(getResources().getColor(R.color.navbar));

        imageView = (ImageView) findViewById(R.id.drawer_indicator);
        final Resources resources = getResources();

        drawerArrowDrawable = new DrawerArrowDrawable(resources);
        drawerArrowDrawable.setStrokeColor(resources.getColor(R.color.light_gray));
        imageView.setImageDrawable(drawerArrowDrawable);

        drawerArrowDrawable.setFlip(true);
        drawerArrowDrawable.setParameter(1);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }


    @Override
    protected void onStart() {
        super.onStart();
        animation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        imageView.setAnimation(animation);
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    @Override
    public void finish() {
        super.finish();
        animation = AnimationUtils.loadAnimation(this, R.anim.fadeout);
        imageView.setAnimation(animation);
        overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
    }
}
