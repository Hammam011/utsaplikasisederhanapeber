package com.example.mytodoapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

import com.example.mytodoapp.Task;


public class MainActivity extends AppCompatActivity {
    // Tambahkan variabel ini
    private static final int ADD_TASK_REQUEST = 1;
    private List<Task> taskList = new ArrayList<>();
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi RecyclerView
        RecyclerView recyclerView = findViewById(R.id.taskRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        taskAdapter = new TaskAdapter(taskList);
        recyclerView.setAdapter(taskAdapter);

        // Inisialisasi FloatingActionButton
        FloatingActionButton addButton = findViewById(R.id.addTaskButton);
        addButton.setOnClickListener(v -> {
            Log.d("DEBUG", "Tombol tambah diklik!");
            startActivityForResult(
                    new Intent(MainActivity.this, AddTaskActivity.class),
                    ADD_TASK_REQUEST
            );
        });
    }

    // Tambahkan method ini untuk menerima data balikan
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_TASK_REQUEST && resultCode == RESULT_OK) {
            String newTask = data.getStringExtra("newTask");
            if (newTask != null && !newTask.trim().isEmpty()) {
                taskList.add(new Task(newTask));
                taskAdapter.notifyDataSetChanged();
            }
        }
    }
}