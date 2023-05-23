package com.example.prjfinalproj.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.prjfinalproj.R;

public class CalendarSection extends AppCompatActivity implements View.OnClickListener{

    Button btnBackToMenu3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_section);

        btnBackToMenu3 = findViewById(R.id.btnBackToMenu3);
        btnBackToMenu3.setOnClickListener(this);


    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnBackToMenu3:
                Intent i = new Intent(CalendarSection.this, MainMenu.class);
                startActivity(i);
                break;
        }
    }
}