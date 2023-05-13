package com.example.prjfinalproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity implements View.OnClickListener {
    TextView txtManage,txtTrack,txtCalendar,txtScan,txtGoToHome,txtNotif;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        txtManage = (TextView)findViewById(R.id.txtManage);
        txtTrack = (TextView) findViewById(R.id.txtTrack);
        txtCalendar = (TextView) findViewById(R.id.txtCalendar);
        txtScan =(TextView) findViewById(R.id.txtScan);
        txtGoToHome = (TextView) findViewById(R.id.txtGoToHome);
        txtNotif = (TextView) findViewById(R.id.txtNotif);

        txtManage.setOnClickListener(this);
        txtTrack.setOnClickListener(this);
        txtCalendar.setOnClickListener(this);
        txtScan.setOnClickListener(this);
        txtGoToHome.setOnClickListener(this);
        txtNotif.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.txtManage:
                Intent intent = new Intent(MainMenu.this,ManageSection.class);
                startActivity(intent);
                break;

            case R.id.txtTrack:
                Intent i = new Intent(MainMenu.this,TrackSection.class);
                startActivity(i);
                break;

            case R.id.txtCalendar:
                Intent i2 = new Intent(MainMenu.this,CalendarSection.class);
                startActivity(i2);
                break;

            case R.id.txtScan:
                Intent i3 = new Intent(MainMenu.this,ScanSection.class);
                startActivity(i3);
                break;

            case R.id.txtGoToHome:
                Intent i4 = new Intent();
                startActivity(i4);
                break;

            case R.id.txtNotif:
                Intent i5 = new Intent();
                startActivity(i5);
                break;
        }
    }
}