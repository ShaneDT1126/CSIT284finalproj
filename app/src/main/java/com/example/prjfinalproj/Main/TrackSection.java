package com.example.prjfinalproj.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.prjfinalproj.R;

import java.util.ArrayList;

public class TrackSection extends AppCompatActivity implements View.OnClickListener {
    TextView txtIncome,txtExpenses,txtAddNewIncome,txtAddNewExpense;
    Button btnBackToMenu2;

    SharedPreferences sharedPreferences,sharedPreferences2;

    private static final String SHARED_PREF_INCOME = "mypref";
    private static final String KEY_INCOME = "income";
    private static final String KEY_EXPENSE = "expense";
    private static final String SHARED_PREF_EXPENSE = "mypref2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_section);

        txtIncome = findViewById(R.id.txtIncome);
       txtExpenses = findViewById(R.id.txtExpenses);
        txtAddNewIncome = findViewById(R.id.txtAddNewIncome);
        txtAddNewExpense = findViewById(R.id.txtAddNewExpense);
        btnBackToMenu2 = findViewById(R.id.btnBackToMenu2);





//        String income = getIntent().getStringExtra("income_data");
//        String expense = getIntent().getStringExtra("expense");
//        ArrayList<String> num = new ArrayList<String>();
//        num.add(income);
//        num.add(expense);


//        txtIncome.setText(income);
//        txtExpenses.setText(expense);




        txtAddNewIncome.setOnClickListener(this);
        txtAddNewExpense.setOnClickListener(this);
        btnBackToMenu2.setOnClickListener(this);

        sharedPreferences = getSharedPreferences(SHARED_PREF_INCOME,MODE_PRIVATE);
        sharedPreferences2 = getSharedPreferences(SHARED_PREF_EXPENSE,MODE_PRIVATE);

        String income = sharedPreferences.getString(KEY_INCOME,null);
        String expense = sharedPreferences2.getString(KEY_EXPENSE,null);

        if(income != null){
            txtIncome.setText("₱"+income);

        }
        if(expense != null){
            txtExpenses.setText("₱"+expense);
        }
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.txtAddNewIncome:
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.clear();
                editor1.commit();
                Intent i = new Intent(TrackSection.this,InputNewIncome.class);
                startActivity(i);
                break;
            case R.id.txtAddNewExpense:
                SharedPreferences.Editor editor = sharedPreferences2.edit();
                editor.clear();
                editor.commit();
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