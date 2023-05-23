package com.example.prjfinalproj.GoalSetting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import com.example.prjfinalproj.GoalSetting.GoalSettingModel;
import com.example.prjfinalproj.R;
import com.example.prjfinalproj.Utils.DialogCloseListener;
import com.example.prjfinalproj.Utils.RecyclerItemTouchHelper2;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Goals extends AppCompatActivity implements DialogCloseListener {
    private RecyclerView goalRecyclerView;
    private GoalSettingAdapter GoalSettingAdapter;
    private FloatingActionButton fab2;
    private List<GoalSettingModel> goalList;
    private DatabaseHandler2 db2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);

        db2 = new DatabaseHandler2(this);
        db2.openDatabase();

        goalList = new ArrayList<GoalSettingModel>();

        goalRecyclerView = findViewById(R.id.goalRecyclerView);
        goalRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        GoalSettingAdapter = new GoalSettingAdapter(db2,Goals.this);
        goalRecyclerView.setAdapter(GoalSettingAdapter);

        fab2 = findViewById(R.id.fab2);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new RecyclerItemTouchHelper2(GoalSettingAdapter));
        itemTouchHelper.attachToRecyclerView(goalRecyclerView);

        goalList = db2.getAllGoal();
        Collections.reverse(goalList);
        GoalSettingAdapter.setGoals(goalList);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddNewGoal.newInstance().show(getSupportFragmentManager(), AddNewGoal.TAG);
            }
        });

    }

    @Override
    public void handleDialogClose(DialogInterface dialog) {
        goalList = db2.getAllGoal();
        Collections.reverse(goalList);
        GoalSettingAdapter.setGoals(goalList);
        GoalSettingAdapter.notifyDataSetChanged();
    }
}