package com.pujexx.mlibraryuad.custom;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class LatoTextView extends TextView {

	public LatoTextView(Context context) {
	    super(context);
	   // TODO Auto-generated constructor stub
	    init();
	}
	
	public LatoTextView(Context context, AttributeSet attrs) {
	    super(context, attrs);
	   // TODO Auto-generated constructor stub
	    init();
	}
	
	public LatoTextView(Context context, AttributeSet attrs, int defStyle) {
	    super(context, attrs, defStyle);
	   // TODO Auto-generated constructor stub
	    init();
	}
	
	private void init() {
	    Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
	        "fonts/lato/Lato-Reg.ttf");
	    setTypeface(tf);
	}

}
