package com.pujexx.mlibraryuad.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.pujexx.mlibraryuad.R;

/**
 * Created by pujexx on 11/6/14.
 */
public class AdapterCover extends BaseAdapter {
    private Context context;


    public AdapterCover(Context context) {
        super();
        this.context = context;
    }


    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_cover, viewGroup, false);
            holder = new ViewHolder();
            assert view != null;
            holder.cover = (ImageView) view.findViewById(R.id.cover);
        }else{
            holder = (ViewHolder) view.getTag();
        }
      //  holder.cover.setImageResource(context.getResources().getDrawable(R.drawable.cover5));
        return view;
    }

    public static class ViewHolder{
        ImageView cover;
    }
}
