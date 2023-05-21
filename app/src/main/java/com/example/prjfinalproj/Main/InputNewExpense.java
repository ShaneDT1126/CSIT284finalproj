package com.example.prjfinalproj.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.prjfinalproj.R;

public class InputNewExpense extends AppCompatActivity implements View.OnClickListener {
    EditText txtNewExpense;
    Button btnNewExpense,btnRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_new_expense);

        txtNewExpense = findViewById(R.id.txtNewExpense);
        btnNewExpense = findViewById(R.id.btnNewExpense);
        btnRes = findViewById(R.id.btnRes);

        btnNewExpense.setOnClickListener(this);
        btnRes.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnNewExpense:
                String newExpense = "₱"+txtNewExpense.getText().toString();
                Intent i = new Intent(InputNewExpense.this,TrackSection.class);

                i.putExtra("expense",newExpense);
                startActivity(i);
                break;
            case R.id.btnRes:
                String reset = "₱0";
                Intent i2 = new Intent(InputNewExpense.this,TrackSection.class);
                i2.putExtra("expense",reset);
                startActivity(i2);
                break;
        }
    }
}