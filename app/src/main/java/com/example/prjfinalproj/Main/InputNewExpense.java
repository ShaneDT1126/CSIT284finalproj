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

public class InputNewExpense extends AppCompatActivity implements View.OnClickListener {
    EditText txtNewExpense;
    Button btnNewExpense;

    SharedPreferences sharedPreferences2;

    private static final String SHARED_PREF_EXPENSE = "mypref2";
    private static final String KEY_EXPENSE = "expense";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_new_expense);

        txtNewExpense = findViewById(R.id.txtNewExpense);
        btnNewExpense = findViewById(R.id.btnNewExpense);


        btnNewExpense.setOnClickListener(this);

        sharedPreferences2 =getSharedPreferences(SHARED_PREF_EXPENSE,MODE_PRIVATE);
        String expense = sharedPreferences2.getString(KEY_EXPENSE,null);
        if(expense != null){
            Intent i = new Intent(InputNewExpense.this,TrackSection.class);
            startActivity(i);
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnNewExpense:
                SharedPreferences.Editor editor = sharedPreferences2.edit();
                editor.putString(KEY_EXPENSE,txtNewExpense.getText().toString());
                editor.apply();
                Intent i = new Intent(InputNewExpense.this,TrackSection.class);
                startActivity(i);
                Toast.makeText(this, "New Expense Added", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}