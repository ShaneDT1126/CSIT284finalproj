package com.example.prjfinalproj.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.prjfinalproj.R;
import com.example.prjfinalproj.databinding.ActivityMainBinding;

public class SettingsSection extends AppCompatActivity implements View.OnClickListener {
    Button btnLogout,btnRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings_section);

        btnLogout = findViewById(R.id.btnLogout);
        btnRate = findViewById(R.id.btnRate);

        btnLogout.setOnClickListener(this);
        btnRate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnLogout:
                Intent i = new Intent(SettingsSection.this,MainActivity.class);
                startActivity(i);
                break;
            case R.id.btnRate:
                Uri uri = Uri.parse("https://play.google.com/store/apps/details?id"+getApplicationContext().getPackageName());
                Intent i2 = new Intent(Intent.ACTION_VIEW,uri);

                try{
                    startActivity(i2);
                } catch (Exception e) {
                    Toast.makeText(this,"Something went wrong\n"+e.getMessage(),Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}