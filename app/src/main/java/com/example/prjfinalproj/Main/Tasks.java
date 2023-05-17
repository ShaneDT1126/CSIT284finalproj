package com.example.prjfinalproj.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.prjfinalproj.Adapter.ToDoAdapter;
import com.example.prjfinalproj.Model.ToDoModel;
import com.example.prjfinalproj.R;

import java.util.ArrayList;
import java.util.List;

public class Tasks extends AppCompatActivity {
    private RecyclerView taskRecycleView;
    private ToDoAdapter taskAdapter;

    private List<ToDoModel> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

//        getSupportActionBar().hide();

        taskList = new ArrayList<>();
        taskRecycleView = findViewById(R.id.tasksRecyclerView);
        taskRecycleView.setLayoutManager(new LinearLayoutManager(this));
        taskAdapter = new ToDoAdapter(this);
        taskRecycleView.setAdapter(taskAdapter);

        ToDoModel task = new ToDoModel();
        task.setTask("Test Task");
        task.setStatus(0);
        task.setId(1);

        taskList.add(task);

        taskAdapter.setTasks(taskList);

    }
}