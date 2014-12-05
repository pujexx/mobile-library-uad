package com.pujexx.mlibraryuad;

/*
    @author  : Puji Rahmadiyanto 
    @website : pujexx.web.id
    @file    : Frontend.java
    @version : 1.0 

*/

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.pujexx.mlibraryuad.R;
import com.pujexx.mlibraryuad.adapter.AdapterMenu;
import com.pujexx.mlibraryuad.custom.CustomResideMenu;
import com.pujexx.mlibraryuad.custom.DialogMenu;
import com.pujexx.mlibraryuad.custom.DialogSearch;
import com.pujexx.mlibraryuad.custom.DrawerArrowDrawable;
import com.pujexx.mlibraryuad.data.TempData;
import com.pujexx.mlibraryuad.utils.Helper;

public class Frontend extends Activity {

    private GridView gridViewMenu;
    private AdapterMenu adapterMenu;
    private LinearLayout bg_navbar;
    private ImageView menu_right;
    private DialogSearch dialogSearch;
    private DrawerArrowDrawable drawerArrowDrawable;
    private DialogMenu dialogMenu;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_frontend);

        gridViewMenu = (GridView) findViewById(R.id.gridview_menu);
        bg_navbar = (LinearLayout) findViewById(R.id.background_navbar);
        menu_right = (ImageView) findViewById(R.id.menu_right);
        bg_navbar.setBackgroundColor(getResources().getColor(R.color.trasnparent));
        imageView = (ImageView) findViewById(R.id.drawer_indicator);
        final Resources resources = getResources();

        drawerArrowDrawable = new DrawerArrowDrawable(resources);
        drawerArrowDrawable.setStrokeColor(resources.getColor(R.color.light_gray));
        imageView.setImageDrawable(drawerArrowDrawable);

        dialogMenu = new DialogMenu(this);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogMenu.show();
            }
        });


        adapterMenu = new AdapterMenu(this);
        gridViewMenu.setAdapter(adapterMenu);

        dialogSearch = new DialogSearch(this);

        menu_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogSearch.show();
            }
        });

        gridViewMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i != 7){
                    selectMenu(i);
                }
                Intent intent = new Intent(getApplication(), ActivityBook.class);
                startActivity(intent);
            }
        });
/*

        gridViewMenu.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                switch (action){
                    case MotionEvent.ACTION_DOWN :
                        view.getParent().requestDisallowInterceptTouchEvent(true);
                        break;
                    case MotionEvent.ACTION_UP :
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }
                view.onTouchEvent(motionEvent);
                return true;
            }
        });
*/


    }

    @Override
    public void finish() {
        super.finish();

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fadeout);
        menu_right.setAnimation(animation);
        imageView.setAnimation(animation);
    }

    public void selectMenu(int i){
        switch (i){
            case 0:
                TempData.kategori_menu = "Buku";
                TempData.tipe_kategori = 0;
                break;
            case 1:
                TempData.kategori_menu = "Majalah";
                TempData.tipe_kategori = 1;
                break;
            case 2:
                TempData.kategori_menu = "CD";
                TempData.tipe_kategori = 2;
                break;
            case 3:
                TempData.kategori_menu = "Skripsi";
                TempData.tipe_kategori = 3;
                break;
            case 4:
                TempData.kategori_menu = "Tesis";
                TempData.tipe_kategori = 4;
                break;
            case 5:
                TempData.kategori_menu = "Jurnal";
                TempData.tipe_kategori = 5;
                break;
            case 6:
                TempData.kategori_menu = "Prosiding";
                TempData.tipe_kategori = 6;
                break;

        }
    }


}
