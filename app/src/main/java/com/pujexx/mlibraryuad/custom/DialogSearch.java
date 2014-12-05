package com.pujexx.mlibraryuad.custom;

import java.util.ArrayList;
import java.util.List;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;



import android.net.Uri;
import android.view.Gravity;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import android.widget.AdapterView.OnItemClickListener;

import com.pujexx.mlibraryuad.R;

public class DialogSearch extends Dialog {


    private ImageView close;
	 private Context context;

	@SuppressWarnings("deprecation")
	public DialogSearch(final Context context) {
		super(context);

		 this.context = context;
		// TODO Auto-generated constructor stub

		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.layout_search);

        close = (ImageView) this.findViewById(R.id.dialog_close);

        this.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;

		WindowManager.LayoutParams params = this.getWindow().getAttributes();



		Window window = this.getWindow();




		window.setLayout(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		window.setAttributes(params);
		this.getWindow().setBackgroundDrawableResource(R.drawable.transparent);

		this.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);


		WindowManager.LayoutParams p = this.getWindow().getAttributes();

		//p.x = 100;
		//this.getWindow().setAttributes(p);
		window.setGravity(Gravity.CENTER );

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });


	}

}
