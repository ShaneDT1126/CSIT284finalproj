package com.example.prjfinalproj.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.prjfinalproj.DBLoginRegister.SQLiteHelperLoginRegister;
import com.example.prjfinalproj.R;

public class register_section extends AppCompatActivity implements View.OnClickListener {
    Button btnStartTask;
    EditText regFirstName;
    EditText regLastName;
    EditText regBday;
    EditText regUsername;
    EditText regPassWord;
    String FNHolder, LNHolder, UsernameHolder, PasswordHolder;
    Boolean EditTextEmptyHolder;
    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder ;
    SQLiteHelperLoginRegister sqLiteHelper;
    Cursor cursor;
    String F_Result = "Not_Found";

    boolean bool = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_section);

        regFirstName = findViewById(R.id.txtRegFirstName);
        regLastName = findViewById(R.id.txtRegLastName);
        regBday = findViewById(R.id.txtRegBday);
        regUsername = findViewById(R.id.txtRegUsername);
        regPassWord = findViewById(R.id.txtRegPassWord);

        btnStartTask =(Button) findViewById(R.id.btnStartTask);
        sqLiteHelper = new SQLiteHelperLoginRegister(this);
        btnStartTask.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        checkDataEntered();
        if(bool) {
//            Intent intent = new Intent(register_section.this, MainActivity.class);
//            startActivity(intent);
            // Creating SQLite database if dose n't exists
            SQLiteDataBaseBuild();
            // Creating SQLite table if dose n't exists.
            SQLiteTableBuild();
            // Checking EditText is empty or Not.
            CheckEditTextStatus();
            // Method to check Email is already exists or not.
            CheckingUsernameAlreadyExistsOrNot();
            // Empty EditText After done inserting process.
            EmptyEditTextAfterDataInsert();
        }

    }
    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    boolean checkDataEntered(){
        if (isEmpty(regFirstName)) {
            regFirstName.setError("First name is required!");
            bool = false;
        }
        if (isEmpty(regLastName)) {
            regLastName.setError("Last name is required!");
            bool = false;
        }
        if (isEmpty(regUsername)) {
            regUsername.setError("Username is required!");
            bool = false;
        }
        if (isEmpty(regPassWord)) {
            regPassWord.setError("Password is required!");
            bool = false;
        }
        if(!isEmpty(regFirstName) && !isEmpty(regLastName) && !isEmpty(regUsername) && !isEmpty(regPassWord)){
            bool = true;
        }
        return bool;
    }

    public void SQLiteDataBaseBuild(){
        sqLiteDatabaseObj = openOrCreateDatabase(SQLiteHelperLoginRegister.DATABASE_NAME, Context.MODE_PRIVATE, null);
    }
    // SQLite table build method.
    public void SQLiteTableBuild() {
        sqLiteDatabaseObj.execSQL("CREATE TABLE IF NOT EXISTS " + SQLiteHelperLoginRegister.TABLE_NAME + "(" + SQLiteHelperLoginRegister.Table_Column_ID + " PRIMARY KEY AUTOINCREMENT NOT NULL, " + SQLiteHelperLoginRegister.Table_Column_1_FirstName + " VARCHAR, " + SQLiteHelperLoginRegister.Table_Column_2_LastName + " VARCHAR, " + SQLiteHelperLoginRegister.Table_Column_3_Username + " VARCHAR, " + SQLiteHelperLoginRegister.Table_Column_4_Password + " VARCHAR, " + SQLiteHelperLoginRegister.Table_Column_5_Birthdate + " VARCHAR);");
    }

    public void InsertDataIntoSQLiteDatabase(){
        // If editText is not empty then this block will executed.
        if(EditTextEmptyHolder == true)
        {
            // SQLite query to insert data into table.
            SQLiteDataBaseQueryHolder = "INSERT INTO "+SQLiteHelperLoginRegister.TABLE_NAME+" (firstname,lastname,username,password) VALUES('"+FNHolder+"','"+LNHolder+"', '"+UsernameHolder+"', '"+PasswordHolder+"');";
            // Executing query.
            sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder);
            // Closing SQLite database object.
            sqLiteDatabaseObj.close();
            // Printing toast message after done inserting.
            Toast.makeText(register_section.this,"User Registered Successfully", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(register_section.this,MainActivity.class);
            startActivity(intent);
        }
        // This block will execute if any of the registration EditText is empty.
        else {
            // Printing toast message if any of EditText is empty.
            Toast.makeText(register_section.this,"Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();
        }
    }
    public void EmptyEditTextAfterDataInsert(){
        regFirstName.getText().clear();
        regLastName.getText().clear();
        regUsername.getText().clear();
        regPassWord.getText().clear();
    }

    public void CheckEditTextStatus(){
        // Getting value from All EditText and storing into String Variables.
        FNHolder = regFirstName.getText().toString();
        LNHolder = regLastName.getText().toString();
        UsernameHolder = regUsername.getText().toString();
        PasswordHolder = regPassWord.getText().toString();
        if(TextUtils.isEmpty(FNHolder) || TextUtils.isEmpty(LNHolder) || TextUtils.isEmpty(UsernameHolder) || TextUtils.isEmpty(PasswordHolder)){
            EditTextEmptyHolder = false ;
        }
        else {
            EditTextEmptyHolder = true ;
        }
    }

    public void CheckingUsernameAlreadyExistsOrNot(){

        sqLiteDatabaseObj = sqLiteHelper.getWritableDatabase();

        cursor = sqLiteDatabaseObj.query(SQLiteHelperLoginRegister.TABLE_NAME, null, " " + SQLiteHelperLoginRegister.Table_Column_3_Username + "=?", new String[]{UsernameHolder}, null, null, null);
        while (cursor.moveToNext()) {
            if (cursor.isFirst()) {
                cursor.moveToFirst();
                F_Result = "Username Found";
                // Closing cursor.
                cursor.close();
            }
        }
        CheckFinalResult();
    }

    public void CheckFinalResult(){
        if(F_Result.equalsIgnoreCase("Username Found"))
        {
            Toast.makeText(register_section.this,"Username Already Exists",Toast.LENGTH_LONG).show();
        }
        else {
            InsertDataIntoSQLiteDatabase();
        }
        F_Result = "Not_Found" ;
    }
}