package com.example.prjfinalproj.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.prjfinalproj.R;

public class ManageSection extends AppCompatActivity implements View.OnClickListener{
    Button btnCreateTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_section);

        btnCreateTask = (Button) findViewById(R.id.btnCreateTask);
        btnCreateTask.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCreateTask:
                Intent intent = new Intent(this, Tasks.class);
                startActivity(intent);
                break;
        }
    }
}