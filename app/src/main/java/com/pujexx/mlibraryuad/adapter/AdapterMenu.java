package com.pujexx.mlibraryuad.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.pujexx.mlibraryuad.R;
import com.pujexx.mlibraryuad.custom.TextViewHelvetica;
import com.pujexx.mlibraryuad.data.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pujexx on 11/6/14.
 */
public class AdapterMenu extends BaseAdapter {
    private Context context;
    private List<Menu> menu;
    private int lastPosition = -1;

    public AdapterMenu(Context context) {
        super();
        this.context = context;
        this.menu = new ArrayList<Menu>();
        this.menu.add(new Menu(1,R.drawable.book, "Buku"));
        this.menu.add(new Menu(1,R.drawable.majalah, "Majalah"));
        this.menu.add(new Menu(1,R.drawable.cd, "CD"));
        this.menu.add(new Menu(1,R.drawable.skripsi, "Skripsi"));
        this.menu.add(new Menu(1,R.drawable.tesis, "Tesis"));
        this.menu.add(new Menu(1,R.drawable.jurnal, "Jurnal"));
        this.menu.add(new Menu(1,R.drawable.prosiding, "Prosiding"));

    }


    @Override
    public int getCount() {
        return this.menu.size();
    }

    @Override
    public Object getItem(int i) {
        return this.menu.get(i);
    }

    @Override
    public long getItemId(int i) {
        return this.menu.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.menu_frontend, viewGroup, false);
            holder = new ViewHolder();
            assert view != null;
            holder.drawable_menu = (ImageView) view.findViewById(R.id.drawable_menu);
            holder.text_menu= (TextViewHelvetica) view.findViewById(R.id.text_menu);

            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        holder.drawable_menu.setImageResource(this.menu.get(i).getIcon());
        holder.text_menu.setText(this.menu.get(i).getText_menu());

        Animation animation = AnimationUtils.loadAnimation(context, (i > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        view.startAnimation(animation);
        lastPosition = i;
        return view;
    }

    public static class ViewHolder{
        ImageView drawable_menu;
        TextViewHelvetica text_menu;
    }
}
