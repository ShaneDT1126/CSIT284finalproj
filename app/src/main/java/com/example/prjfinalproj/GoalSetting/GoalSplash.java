package com.example.prjfinalproj.GoalSetting;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prjfinalproj.Main.MainActivity;
import com.example.prjfinalproj.R;

public class GoalSplash  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        final Intent i = new Intent(GoalSplash.this, Goals.class);
        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                          startActivity(i);
                                          finish();
                                      }
                                  },1000
        );
    }
}
