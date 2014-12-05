package com.pujexx.mlibraryuad.custom;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.pujexx.mlibraryuad.Login;
import com.pujexx.mlibraryuad.R;
import com.pujexx.mlibraryuad.Register;

public class DialogMenu extends Dialog {



	 private Context context;
    private LinearLayout menu_login;
    private LinearLayout menu_register;

	@SuppressWarnings("deprecation")
	public DialogMenu(final Context context) {
		super(context);

		 this.context = context;
		// TODO Auto-generated constructor stub

		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.dropdown_menu);

        menu_login = (LinearLayout) findViewById(R.id.menu_login);
        menu_register = (LinearLayout) findViewById(R.id.menu_register);

		WindowManager.LayoutParams params = this.getWindow().getAttributes();



		Window window = this.getWindow();



		window.setLayout(240,LayoutParams.WRAP_CONTENT);
		window.setAttributes(params);
		this.getWindow().setBackgroundDrawableResource(R.drawable.transparent);

		this.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);


		WindowManager.LayoutParams p = this.getWindow().getAttributes();



		window.setGravity(Gravity.TOP | Gravity.LEFT);
       menu_login.setClickable(true);
       menu_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, Login.class);
                context.startActivity(intent);
                dismiss();
            }
        });

        menu_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Register.class);
                context.startActivity(intent);
                dismiss();
            }
        });


	}

}
