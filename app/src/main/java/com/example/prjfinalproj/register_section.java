package com.example.prjfinalproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class register_section extends AppCompatActivity implements View.OnClickListener {
    Button btnStartTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_section);

        btnStartTask =(Button) findViewById(R.id.btnStartTask);
        btnStartTask.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(register_section.this,MainMenu.class );
        startActivity(intent);

    }
}