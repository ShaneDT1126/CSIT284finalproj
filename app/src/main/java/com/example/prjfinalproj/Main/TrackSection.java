package com.example.prjfinalproj.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.prjfinalproj.R;

import java.util.ArrayList;

public class TrackSection extends AppCompatActivity implements View.OnClickListener {
    TextView txtIncome,txtExpenses,txtAddNewIncome,txtAddNewExpense;
    Button btnBackToMenu2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_section);

        txtIncome = findViewById(R.id.txtIncome);
       txtExpenses = findViewById(R.id.txtExpenses);
        txtAddNewIncome = findViewById(R.id.txtAddNewIncome);
        txtAddNewExpense = findViewById(R.id.txtAddNewExpense);
        btnBackToMenu2 = findViewById(R.id.btnBackToMenu2);





        String income = getIntent().getStringExtra("income_data");
        String expense = getIntent().getStringExtra("expense");
//        ArrayList<String> num = new ArrayList<String>();
//        num.add(income);
//        num.add(expense);


        txtIncome.setText(income);
        txtExpenses.setText(expense);




        txtAddNewIncome.setOnClickListener(this);
        txtAddNewExpense.setOnClickListener(this);
        btnBackToMenu2.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.txtAddNewIncome:
                Intent i = new Intent(TrackSection.this,InputNewIncome.class);
                startActivity(i);
                break;
            case R.id.txtAddNewExpense:
                Intent i2 = new Intent(TrackSection.this,InputNewExpense.class);
                startActivity(i2);
                break;
            case R.id.btnBackToMenu2:
                Intent i3 = new Intent(TrackSection.this,MainMenu.class);
                startActivity(i3);
                break;
        }
    }






}