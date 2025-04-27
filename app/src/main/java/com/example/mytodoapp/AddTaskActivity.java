package com.example.mytodoapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AddTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task_activity);

        // Inisialisasi komponen
        EditText taskEditText = findViewById(R.id.taskEditText);
        Button saveButton = findViewById(R.id.saveTaskButton);

        // Handle klik tombol simpan
        saveButton.setOnClickListener(v -> {
            String newTask = taskEditText.getText().toString().trim();

            if (!newTask.isEmpty()) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("newTask", newTask);
                setResult(RESULT_OK, resultIntent);
                finish(); // Tutup activity dan kembalikan data
            } else {
                taskEditText.setError("Tugas tidak boleh kosong!");
            }
        });
    }
}