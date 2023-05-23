package com.example.prjfinalproj.GoalSetting;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.prjfinalproj.GoalSetting.GoalSettingModel;

import java.security.AccessController;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler2 extends SQLiteOpenHelper {

    private static final int VERSION = 4;
    private static final String NAME = "GoalSettingDatabase";
    private static final String GOAL_TABLE = "goal";
    private static final String ID = "id";
    private static final String GOALS = "goal";
    private static final String STATUS = "status";
    private static final String CREATE_GOAL_TABLE = "CREATE TABLE " + GOAL_TABLE + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + GOALS + " TEXT, " + STATUS + " INTEGER)";

    private SQLiteDatabase db;

    public DatabaseHandler2(Context context) {
        super(context, NAME, null, VERSION);
    }

    public DatabaseHandler2(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_GOAL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + GOAL_TABLE);
        //-------------------------------------------
        onCreate(db);
    }

    public void openDatabase() {
        if (db != null && db.isOpen()) {
            db.close();
        }
        db = this.getWritableDatabase();
    }

    public void insertGoal(GoalSettingModel goal) {
        ContentValues cv = new ContentValues();
        cv.put(GOALS, goal.getGoal());
        cv.put(STATUS, 0);
        db.insert(GOAL_TABLE, null, cv);
    }

    @SuppressLint("Range")
    public List<GoalSettingModel> getAllGoal() {
        List<GoalSettingModel> goalList = new ArrayList<>();
        Cursor cur = null;
        db.beginTransaction();
        try {
            cur = db.query(GOAL_TABLE, null, null, null, null, null, null, null);
            if (cur != null) {
                if (cur.moveToFirst()) {
                    do {
                        GoalSettingModel goal = new GoalSettingModel();
                        goal.setId(cur.getInt(cur.getColumnIndex(ID)));
                        goal.setGoal(cur.getString(cur.getColumnIndex(GOALS)));
                        goal.setStatus(cur.getInt(cur.getColumnIndex(STATUS)));
                        goalList.add(goal);
                    } while (cur.moveToNext());
                }
            }
        } finally {
            db.endTransaction();
            assert cur != null;
            cur.close();
        }
        return goalList;
    }

    public void updateStatus(int id, int status){
        ContentValues cv = new ContentValues();
        cv.put(STATUS, status);
        db.update(GOAL_TABLE, cv, ID + "= ?", new String[] {String.valueOf(id)});
    }

    public void updateGoal(int id, String goal){
        ContentValues cv = new ContentValues();
        cv.put(GOALS, goal);
        db.update(GOAL_TABLE, cv, ID + "= ?", new String[] {String.valueOf(id)});
    }

    public void deleteGoal(int id){
        db.delete(GOAL_TABLE,ID + "= ?", new String[] {String.valueOf(id)});
    }
}

