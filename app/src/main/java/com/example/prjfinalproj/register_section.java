package com.example.prjfinalproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register_section extends AppCompatActivity implements View.OnClickListener {
    Button btnStartTask;
    EditText regFirstName;
    EditText regLastName;
    EditText regBday;
    EditText regUsername;
    EditText regPassWord;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_section);

        regFirstName = findViewById(R.id.txtRegFirstName);
        regLastName = findViewById(R.id.txtRegLastName);
        regBday = findViewById(R.id.txtRegBday);
        regUsername = findViewById(R.id.txtRegUsername);
        regPassWord = findViewById(R.id.txtRegPassWord);

        btnStartTask =(Button) findViewById(R.id.btnStartTask);
        btnStartTask.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        checkDataEntered();

        Intent intent = new Intent(register_section.this,MainMenu.class );
        startActivity(intent);

    }
    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    void checkDataEntered(){
        if (isEmpty(regFirstName)) {
            regFirstName.setError("First name is required!");
        }
        if (isEmpty(regLastName)) {
            regLastName.setError("Last name is required!");
        }
        if (isEmpty(regUsername)) {
            regUsername.setError("Username is required!");
        }
        if (isEmpty(regPassWord)) {
            regPassWord.setError("Password is required!");
        }

    }
}