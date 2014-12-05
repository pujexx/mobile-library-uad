package com.pujexx.mlibraryuad.custom;

import android.content.Context;
import android.view.LayoutInflater;

import com.pujexx.mlibraryuad.R;
import com.special.ResideMenu.ResideMenu;


/**
 * Created by pujexx on 11/6/14.
 */
public class CustomResideMenu  extends ResideMenu{

    public CustomResideMenu(Context context) {
        super(context);
        this.initViews(context);
    }

    private void initViews(Context context){
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.residemenu_custom, this);

    }





}
