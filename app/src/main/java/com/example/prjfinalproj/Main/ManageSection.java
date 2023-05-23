package com.example.prjfinalproj.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.prjfinalproj.GoalSetting.Goals;
import com.example.prjfinalproj.R;
import com.example.prjfinalproj.Tasks.Tasks;

public class ManageSection extends AppCompatActivity implements View.OnClickListener{
    Button btnCreateTask,btnBudgetPlan, btnBackToMenu1, btnGoalSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_section);

        btnCreateTask = (Button) findViewById(R.id.btnCreateTask);
        btnBudgetPlan = findViewById(R.id.btnBudgetPlan);
        btnBackToMenu1 = findViewById(R.id.btnBackToMenu1);
        btnGoalSet = findViewById(R.id.btnGoalSet);
        btnGoalSet.setOnClickListener(this);
        btnCreateTask.setOnClickListener(this);
        btnBudgetPlan.setOnClickListener(this);
        btnBackToMenu1.setOnClickListener(this);
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
            case R.id.btnBackToMenu1:
                Intent i3 = new Intent(ManageSection.this,MainMenu.class);
                startActivity(i3);
                break;
            case R.id.btnGoalSet:
                Intent i4 = new Intent(this, Goals.class);
                startActivity(i4);
                break;
        }
    }
}