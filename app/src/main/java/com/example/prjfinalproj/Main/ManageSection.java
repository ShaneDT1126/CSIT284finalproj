package com.example.prjfinalproj.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.prjfinalproj.R;
import com.example.prjfinalproj.Tasks.Tasks;

public class ManageSection extends AppCompatActivity implements View.OnClickListener{
    Button btnCreateTask,btnBudgetPlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_section);

        btnCreateTask = (Button) findViewById(R.id.btnCreateTask);
        btnBudgetPlan = findViewById(R.id.btnBudgetPlan);
        btnCreateTask.setOnClickListener(this);
        btnBudgetPlan.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCreateTask:
                Intent intent = new Intent(this, Tasks.class);
                startActivity(intent);
                break;
            case R.id.btnBudgetPlan:
                Intent i2 = new Intent(ManageSection.this,BudgetPlannerSection.class);
                startActivity(i2);
                break;
        }
    }
}