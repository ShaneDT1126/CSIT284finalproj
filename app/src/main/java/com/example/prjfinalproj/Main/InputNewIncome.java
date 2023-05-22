package com.example.prjfinalproj.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.prjfinalproj.R;

public class InputNewIncome extends AppCompatActivity implements View.OnClickListener {
    EditText txtNewIncome;
    Button btnNewIncome;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_INCOME = "mypref";
    private static final String KEY_INCOME = "income";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_new_income);

        txtNewIncome = findViewById(R.id.txtNewIncome);
        btnNewIncome = findViewById(R.id.btnNewIncome);



        btnNewIncome.setOnClickListener(this);


        sharedPreferences = getSharedPreferences(SHARED_PREF_INCOME,MODE_PRIVATE);

        String income = sharedPreferences.getString(KEY_INCOME,null);

        if (income != null){
            Intent i = new Intent(InputNewIncome.this,TrackSection.class);
            startActivity(i);
        }


    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnNewIncome:
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_INCOME,txtNewIncome.getText().toString());
                editor.apply();

                Intent i = new Intent(InputNewIncome.this,TrackSection.class);
                startActivity(i);
                Toast.makeText(this, "New Income Added!!", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}