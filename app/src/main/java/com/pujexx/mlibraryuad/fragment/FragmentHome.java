package com.pujexx.mlibraryuad.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.pujexx.mlibraryuad.R;
import com.pujexx.mlibraryuad.adapter.AdapterCover;

/**
 * Created by pujexx on 11/6/14.
 */
public class FragmentHome extends Fragment {

    private Context context;
    private GridView gridView;
    private AdapterCover adapter;

    public static FragmentHome newIntance(Context context){
        FragmentHome f = new FragmentHome();
        Bundle bundle = new Bundle();
        f.setArguments(bundle);
        return f;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getActivity();
        adapter = new AdapterCover(context);
        gridView.setAdapter(adapter);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_home, null);
        return view;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gridView = (GridView) view.findViewById(R.id.gridview);

    }
}
