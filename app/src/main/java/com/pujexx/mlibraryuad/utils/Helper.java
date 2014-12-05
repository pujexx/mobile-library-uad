package com.pujexx.mlibraryuad.utils;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.pujexx.mlibraryuad.adapter.AdapterMenu;

/**
 * Created by pujexx on 11/8/14.
 */
public class Helper {

    public static void getGridSize(GridView gridview){
        AdapterMenu adapter = (AdapterMenu) gridview.getAdapter();
        if(adapter == null){
            return;
        }
        int totalheight = 0;
        for(int size=0;size < adapter.getCount();size++){
            View griditem = adapter.getView(size, null, gridview);
            griditem.measure(0,0);
            totalheight += griditem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = gridview.getLayoutParams();
        params.height = totalheight + (gridview.getVerticalSpacing()*adapter.getCount()-1);
        gridview.setLayoutParams(params);

        Log.i("height of listItem:", String.valueOf(totalheight));
    }
}
