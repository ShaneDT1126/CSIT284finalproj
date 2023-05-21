package com.example.prjfinalproj.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.prjfinalproj.R;

public class InputNewIncome extends AppCompatActivity implements View.OnClickListener {
    EditText txtNewIncome;
    Button btnNewIncome,btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_new_income);

        txtNewIncome = findViewById(R.id.txtNewIncome);
        btnNewIncome = findViewById(R.id.btnNewIncome);
        btnReset = findViewById(R.id.btnReset);


        btnNewIncome.setOnClickListener(this);
        btnReset.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnNewIncome:

                String newIncome ="₱"+txtNewIncome.getText();
                Intent i = new Intent(InputNewIncome.this,TrackSection.class);


               i.putExtra("income_data",newIncome);
                startActivity(i);
                break;
            case R.id.btnReset:
                String reset = "₱0";
                Intent i2 = new Intent(InputNewIncome.this,TrackSection.class);
                i2.putExtra("income",reset);
                startActivity(i2);
                break;
        }
    }
}