package com.pujexx.mlibraryuad;


/*
    @author  : Puji Rahmadiyanto 
    @website : pujexx.web.id
    @file    : MyActivity.java
    @version : 1.0 

*/

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.pujexx.mlibraryuad.custom.CustomResideMenu;
import com.pujexx.mlibraryuad.custom.DrawerArrowDrawable;
import com.pujexx.mlibraryuad.fragment.FragmentHome;
import com.special.ResideMenu.ResideMenu;


public class MyActivity extends FragmentActivity {

    private Fragment mContent;
    private CustomResideMenu residemenu;
    private DrawerArrowDrawable drawerArrowDrawable;
    private LinearLayout background_navbar;
    private Boolean open = false;
    private Boolean fliped = false;
    private float offset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null)
            mContent = getSupportFragmentManager().getFragment(
                    savedInstanceState, "mContent");
        if (mContent == null)
            mContent = FragmentHome.newIntance(this);

        setContentView(R.layout.activity_my);

       background_navbar = (LinearLayout) findViewById(R.id.background_navbar);

       background_navbar.setBackgroundColor(getResources().getColor(R.color.navbar));


       final ImageView imageView = (ImageView) findViewById(R.id.drawer_indicator);
       final Resources resources = getResources();

        drawerArrowDrawable = new DrawerArrowDrawable(resources);
        drawerArrowDrawable.setStrokeColor(resources.getColor(R.color.light_gray));
        imageView.setImageDrawable(drawerArrowDrawable);



        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_content, mContent).commit();


        residemenu = new CustomResideMenu(this);

        residemenu.attachToActivity(this);

        residemenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);

        residemenu.setMenuListener(new ResideMenu.OnMenuListener() {
            @Override
            public void openMenu() {
                open = true;
                drawerArrowDrawable.setFlip(true);
                drawerArrowDrawable.setParameter(1);
            }

            @Override
            public void closeMenu() {
                open = false;
                drawerArrowDrawable.setFlip(false);
                drawerArrowDrawable.setParameter(0);
            }
        });

        imageView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                residemenu.openMenu(ResideMenu.DIRECTION_LEFT);

            }
        });




    }


    /*private float getAlphaForView(int position) {
        int diff = 0;
        float minAlpha = 0.4f, maxAlpha = 1.f;
        float alpha = minAlpha; // min alpha

        if (position > 50)
            alpha = minAlpha;
        else if (position + locationImageHeight < 50)
            alpha = maxAlpha;
        else {
            diff = 50 - position;
            alpha += ((diff * 1f) / locationImageHeight)* (maxAlpha - minAlpha); // 1f and 0.4f are maximum and min
            // alpha
            // this will return a number betn 0f and 0.6f
        }
        // System.out.println(alpha+" "+screenHeight +" "+locationImageInitialLocation+" "+position+" "+diff);
        return alpha;
    }
*/


    public void switchContent(Fragment fragment) {
        mContent = fragment;
        getSupportFragmentManager().beginTransaction().
                replace(R.id.frame_content, fragment).addToBackStack(null).commit();

    }

}
