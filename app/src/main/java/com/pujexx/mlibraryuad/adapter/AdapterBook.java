package com.pujexx.mlibraryuad.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.pujexx.mlibraryuad.R;
import com.pujexx.mlibraryuad.data.Book;
import com.pujexx.mlibraryuad.utils.RandomColor;

import java.util.List;

/**
 * Created by pujexx on 11/6/14.
 */
public class AdapterBook extends BaseAdapter {
    private Context context;
    List<Book> books;

    public AdapterBook(Context context , List<Book> books) {
        super();
        this.context = context;
        this.books = books;
    }


    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int i) {
        return books.get(i);
    }

    @Override
    public long getItemId(int i) {
        return books.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        view = null;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.book_item, viewGroup, false);
            holder = new ViewHolder();
            assert view != null;
            holder.cover_background = (LinearLayout) view.findViewById(R.id.cover_background);
         //   holder.cover = (ImageView) view.findViewById(R.id.cover);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        RandomColor color = new RandomColor();
        holder.cover_background.setBackgroundResource(books.get(i).getColor());

        return view;
    }

    public static class ViewHolder{
        ImageView cover;
        LinearLayout cover_background;
    }
}
