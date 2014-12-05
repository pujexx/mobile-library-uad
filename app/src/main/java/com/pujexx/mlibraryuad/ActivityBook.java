package com.pujexx.mlibraryuad;


/*
    @author  : Puji Rahmadiyanto 
    @website : pujexx.web.id
    @file    : ActivityBook.java
    @version : 1.0 

*/


import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;


import com.pujexx.mlibraryuad.R;
import com.pujexx.mlibraryuad.adapter.AdapterBook;
import com.pujexx.mlibraryuad.custom.DrawerArrowDrawable;
import com.pujexx.mlibraryuad.custom.LoadMoreListView;
import com.pujexx.mlibraryuad.custom.TextViewHelvetica;
import com.pujexx.mlibraryuad.data.Book;
import com.pujexx.mlibraryuad.data.TempData;
import com.pujexx.mlibraryuad.utils.RandomColor;

import java.util.ArrayList;
import java.util.List;


public class ActivityBook extends Activity {

    private LoadMoreListView list_view;
    private AdapterBook adapter;
    private List<Book> books;
    private DrawerArrowDrawable drawerArrowDrawable;
    private LinearLayout navbar_background , background_header_list_book;
    private TextViewHelvetica text_header , title;
    private  ImageView imageView ,menu_right;
    private Animation animation , animation2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.list_book);
        list_view = (LoadMoreListView) findViewById(R.id.list_book);
        title = (TextViewHelvetica) findViewById(R.id.title);
        title.setVisibility(View.VISIBLE);

        navbar_background = (LinearLayout) findViewById(R.id.background_navbar);

        imageView = (ImageView) findViewById(R.id.drawer_indicator);
        menu_right = (ImageView) findViewById(R.id.menu_right);

        final Resources resources = getResources();

        drawerArrowDrawable = new DrawerArrowDrawable(resources);
        drawerArrowDrawable.setStrokeColor(resources.getColor(R.color.light_gray));
        imageView.setImageDrawable(drawerArrowDrawable);

        drawerArrowDrawable.setFlip(true);
        drawerArrowDrawable.setParameter(1);

        books = new ArrayList<Book>();

        adapter = new AdapterBook(this, books);

        list_view.setAdapter(adapter);
        Book book1 = new Book();

        navbar_background.setBackgroundColor(getResources().getColor(R.color.navbar));

        final View viewheader = getLayoutInflater().inflate(R.layout.header_list_book,null, false);

        text_header = (TextViewHelvetica) viewheader.findViewById(R.id.header_text);

        background_header_list_book  = (LinearLayout) viewheader.findViewById(R.id.background_header_list_book);

        list_view.addParallaxedHeaderView(viewheader);

        background_header_list_book.setBackgroundColor(getResources().getColor(R.color.navbar));

        final Drawable drawable_background = navbar_background.getBackground();
        drawable_background.setAlpha(0);

        book1.setColor(new RandomColor().getRandomColor());
        books.add(book1);
        book1.setColor(new RandomColor().getRandomColor());
        books.add(book1);
        book1.setColor(new RandomColor().getRandomColor());
        books.add(book1);
        book1.setColor(new RandomColor().getRandomColor());
        books.add(book1);
        book1.setColor(new RandomColor().getRandomColor());
        books.add(book1);
        book1.setColor(new RandomColor().getRandomColor());
        books.add(book1);
        book1.setColor(new RandomColor().getRandomColor());
        books.add(book1);
        book1.setColor(new RandomColor().getRandomColor());
        books.add(book1);
        book1.setColor(new RandomColor().getRandomColor());
        books.add(book1);
        book1.setColor(new RandomColor().getRandomColor());
        books.add(book1);

        adapter.notifyDataSetChanged();

        drawable_background.setAlpha(0);

        text_header.setText(TempData.kategori_menu);
        title.setAlpha(0);
        title.setText(TempData.kategori_menu);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), BookDetail.class);
                startActivity(intent);
            }
        });
        list_view.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                View c = list_view.getChildAt(0);
                int scrolly = -c.getTop() + list_view.getFirstVisiblePosition() * c.getHeight();






                final int headerHeight = 250;
                final float ratio = (float) Math.min(Math.max(scrolly, 0), headerHeight) / headerHeight;
                final int newAlpha = (int) (ratio * 255);

                drawable_background.setAlpha(newAlpha);

                if(scrolly>250){
                    title.setAlpha(1f);
                }else{
                    title.setAlpha(0f);
                }



            }


        });

        list_view.setOnLoadMoreListener(new LoadMoreListView.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                Book book2 = new Book();

                book2.setColor(new RandomColor().getRandomColor());
                books.add(book2);
                adapter.notifyDataSetChanged();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        list_view.onLoadMoreComplete();
                    }
                },2000);

            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        animation = AnimationUtils.loadAnimation(this,R.anim.fadein);
        animation2 = AnimationUtils.loadAnimation(this, R.anim.fadeinlong);
        imageView.setAnimation(animation);
        menu_right.setAnimation(animation);
        text_header.setAnimation(animation2);
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    @Override
    public void finish() {
        super.finish();
        animation = AnimationUtils.loadAnimation(this,R.anim.fadeout);

        imageView.setAnimation(animation);
        menu_right.setAnimation(animation);

        overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
    }
}
