package com.example.prjfinalproj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLogin;
    TextView txtForgetPass;
    TextView txtSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       btnLogin =(Button) findViewById(R.id.btnLogin);
       btnLogin.setOnClickListener(this);


//        TextView textView =(TextView) findViewById(R.id.txtSignUp);

        String txt = "Sign Up";
        String txt2 = "Forget Password";

        txtForgetPass =(TextView) findViewById(R.id.txtForgetPass);
        txtSignUp = (TextView) findViewById(R.id.txtSignUp);

        txtForgetPass.setOnClickListener(this);
        txtSignUp.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btnLogin:
            Intent intent = new Intent(this, MainMenu.class);
            startActivity(intent);
            break;

            case R.id.txtSignUp:
                Intent i = new Intent(this,register_section.class);
                startActivity(i);
                break;

        }
    }
}