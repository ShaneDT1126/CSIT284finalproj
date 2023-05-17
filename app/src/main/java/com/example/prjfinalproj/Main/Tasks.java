package com.example.prjfinalproj.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;

import com.example.prjfinalproj.Adapter.ToDoAdapter;
import com.example.prjfinalproj.Model.ToDoModel;
import com.example.prjfinalproj.R;
import com.example.prjfinalproj.Utils.DatabaseHandler;
import com.example.prjfinalproj.Utils.DialogCloseListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tasks extends AppCompatActivity implements DialogCloseListener {
    private RecyclerView taskRecycleView;
    private ToDoAdapter taskAdapter;

    private List<ToDoModel> taskList;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

//        getSupportActionBar().hide();

        db = new DatabaseHandler(this);
        db.openDatabase();

        taskList = new ArrayList<>();

        taskRecycleView = findViewById(R.id.tasksRecyclerView);
        taskRecycleView.setLayoutManager(new LinearLayoutManager(this));
        taskAdapter = new ToDoAdapter(db,this);
        taskRecycleView.setAdapter(taskAdapter);

        taskList = db.getAllTask();
        Collections.reverse(taskList);
        taskAdapter.setTasks(taskList);


        ToDoModel task = new ToDoModel();
        task.setTask("test");
        task.setStatus(0);
        task.setId(1);

        taskList.add(task);
        taskList.add(task);
        taskList.add(task);
    }


    @Override
    public void handleDialogClose(DialogInterface dialog) {
        taskList = db.getAllTask();
        Collections.reverse(taskList);
        taskAdapter.setTasks(taskList);
        taskAdapter.notifyDataSetChanged();
    }
}