package com.example.prjfinalproj.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.prjfinalproj.R;
import com.example.prjfinalproj.Tasks.Tasks;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLogin;
    TextView txtForgetPass;
    TextView txtSignUp;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setContentView(R.layout.activity_tasks);

        setupUI();

       btnLogin = (Button) findViewById(R.id.btnLogin);
       btnLogin.setOnClickListener(this);


//        TextView textView =(TextView) findViewById(R.id.txtSignUp);

        String txt = "Sign Up";
        String txt2 = "Forget Password";

        txtForgetPass =(TextView) findViewById(R.id.txtForgetPass);
        txtSignUp = (TextView) findViewById(R.id.txtSignUp);

        txtForgetPass.setOnClickListener(this);
        txtSignUp.setOnClickListener(this);


    }
    private void setupUI() {
        username = findViewById(R.id.Username);
        password = findViewById(R.id.Password);
        btnLogin = findViewById(R.id.btnLogin);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btnLogin:
            Intent intent = new Intent(this, Tasks.class);
            startActivity(intent);
            break;

            case R.id.txtSignUp:
                Intent i = new Intent(this,register_section.class);
                startActivity(i);
                break;

        }
    }
}