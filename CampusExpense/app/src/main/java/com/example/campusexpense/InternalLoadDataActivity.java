package com.example.campusexpense;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;

public class InternalLoadDataActivity extends AppCompatActivity {
    private TextView tvIdStudent, tvNameStudent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_load_data);
        tvIdStudent = findViewById(R.id.tv_id);
        tvNameStudent = findViewById(R.id.tv_name);
    }
    public void loadData(View view) {
        try{
            FileInputStream fileInputStream = openFileInput("code.txt");
            int read = -1;
            StringBuilder  stringBuilder = new StringBuilder();
            while ((read = fileInputStream.read()) != -1) {
                stringBuilder.append((char)read);
            }
            String id = stringBuilder.substring(0,stringBuilder.indexOf(""));
            String name = stringBuilder.substring(stringBuilder.indexOf("") + 1);
            tvIdStudent.setText(id);
            tvNameStudent.setText(name);
            Toast.makeText(InternalLoadDataActivity.this, "done", Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }
    }
    public void backData(View view) {

    }
}
