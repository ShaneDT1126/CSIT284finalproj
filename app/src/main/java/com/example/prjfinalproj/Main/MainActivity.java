package com.example.prjfinalproj.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prjfinalproj.DBLoginRegister.SQLiteHelperLoginRegister;
import com.example.prjfinalproj.R;
import com.example.prjfinalproj.Tasks.Tasks;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLogin;
    TextView txtForgetPass;
    TextView txtSignUp;
    EditText username;
    EditText password;
    SQLiteDatabase sqLiteDatabaseObj;
    SQLiteHelperLoginRegister sqLiteHelper;
    Cursor cursor;
    Boolean EditTextEmptyHolder;
    String UsernameHolder, PasswordHolder;
    String TempPassword = "NOT_FOUND" ;
    public static final String Username = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();

       btnLogin = (Button) findViewById(R.id.btnLogin);
       btnLogin.setOnClickListener(this);

        String txt = "Sign Up";
        String txt2 = "Forget Password";

        txtForgetPass =(TextView) findViewById(R.id.txtForgetPass);
        txtSignUp = (TextView) findViewById(R.id.txtSignUp);

        txtForgetPass.setOnClickListener(this);
        txtSignUp.setOnClickListener(this);

        sqLiteHelper = new SQLiteHelperLoginRegister(this);


    }
    private void setupUI() {
        username = findViewById(R.id.Username);
        password = findViewById(R.id.Password);
        btnLogin = findViewById(R.id.btnLogin);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btnLogin:
                CheckEditTextStatus();
                LoginFunction();
//            Intent intent = new Intent(this, MainMenu.class);
//            startActivity(intent);
            break;

            case R.id.txtSignUp:
                Intent i = new Intent(this,register_section.class);
                startActivity(i);
                break;

        }
    }
    // Login function starts from here.
    @SuppressLint("Range")
    public void LoginFunction(){
        if(EditTextEmptyHolder) {
            // Opening SQLite database write permission.
            sqLiteDatabaseObj = sqLiteHelper.getWritableDatabase();
            // Adding search email query to cursor.
            cursor = sqLiteDatabaseObj.query(SQLiteHelperLoginRegister.TABLE_NAME, null, " " + SQLiteHelperLoginRegister.Table_Column_3_Username + "=?", new String[]{UsernameHolder}, null, null, null);
            while (cursor.moveToNext()) {
                if (cursor.isFirst()) {
                    cursor.moveToFirst();
                    // Storing Password associated with entered email.
                    TempPassword = cursor.getString(cursor.getColumnIndex(SQLiteHelperLoginRegister.Table_Column_4_Password));
                    // Closing cursor.
                    cursor.close();
                }
            }
            // Calling method to check final result ..
            CheckFinalResult();
        }
        else {
            //If any of login EditText empty then this block will be executed.
            Toast.makeText(MainActivity.this,"Please Enter Username or Password.",Toast.LENGTH_LONG).show();
        }
    }
    // Checking EditText is empty or not.
    public void CheckEditTextStatus(){
        // Getting value from All EditText and storing into String Variables.
        UsernameHolder = username.getText().toString();
        PasswordHolder = password.getText().toString();
        // Checking EditText is empty or no using TextUtils.
        if( TextUtils.isEmpty(UsernameHolder) || TextUtils.isEmpty(PasswordHolder)){
            EditTextEmptyHolder = false ;
        }
        else {
            EditTextEmptyHolder = true ;
        }
    }

    public void CheckFinalResult(){
        if(TempPassword.equalsIgnoreCase(PasswordHolder))
        {
            Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_LONG).show();
            // Going to Dashboard activity after login success message.
            Intent intent = new Intent(MainActivity.this, MainMenu.class);
            // Sending Email to Dashboard Activity using intent.
            intent.putExtra(Username, UsernameHolder);
            startActivity(intent);
        }
        else {
            Toast.makeText(MainActivity.this,"Username or Password is Wrong, Please Try Again.",Toast.LENGTH_LONG).show();
        }
        TempPassword = "NOT_FOUND" ;
    }
}