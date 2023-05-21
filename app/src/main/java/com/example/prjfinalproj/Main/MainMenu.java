package com.example.prjfinalproj.Main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.prjfinalproj.R;
import com.example.prjfinalproj.databinding.ActivityMainBinding;

public class MainMenu extends AppCompatActivity implements View.OnClickListener {
    TextView txtManage;
    TextView txtTrack,txtCalendar,txtScan,txtGoToHome,txtNotif,txtSettingsIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_menu);

        txtManage = findViewById(R.id.txtManage);
        txtTrack = findViewById(R.id.txtTrack);
        txtCalendar = findViewById(R.id.txtCalendar);
        txtScan = findViewById(R.id.txtScan);
        txtGoToHome = findViewById(R.id.txtGoToHome);
        txtNotif = findViewById(R.id.txtNotif);
        txtSettingsIcon = (TextView) findViewById(R.id.txtSettingsIcon);

        txtManage.setOnClickListener(this);
        txtTrack.setOnClickListener(this);
        txtCalendar.setOnClickListener(this);
        txtScan.setOnClickListener(this);
        txtGoToHome.setOnClickListener(this);
        txtNotif.setOnClickListener(this);
        txtSettingsIcon.setOnClickListener(this);
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

            case R.id.txtSettingsIcon:
                Intent i6 = new Intent(MainMenu.this,SettingsSection.class);
                startActivity(i6);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.setting_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuSetting:
                Intent i = new Intent(this,SettingsSection.class);
                startActivity(i);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}