package com.example.prjfinalproj.DBLoginRegister;

/**
 * Created by Shashank on 14-Feb-18.
 */

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class SQLiteHelperLoginRegister extends SQLiteOpenHelper {

    public static String DATABASE_NAME="UserDataBase";

    public static final String TABLE_NAME="UserTable";

    public static final String Table_Column_ID="id";

    public static final String Table_Column_1_FirstName="firstname";

    public static final String Table_Column_2_LastName="lastname";

    public static final String Table_Column_3_Username="username";
    public static final String Table_Column_4_Password="password";
    public static final String Table_Column_5_Birthdate="birthdate";

    public SQLiteHelperLoginRegister(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+Table_Column_ID+" INTEGER PRIMARY KEY, "+Table_Column_1_FirstName+" VARCHAR, "+Table_Column_2_LastName+" VARCHAR, "+Table_Column_3_Username+" VARCHAR, "+Table_Column_4_Password+" VARCHAR, "+Table_Column_5_Birthdate+" VARCHAR)";
        database.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

}