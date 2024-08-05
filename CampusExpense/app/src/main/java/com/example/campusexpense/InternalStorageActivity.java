package com.example.campusexpense;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class InternalStorageActivity extends AppCompatActivity {
    private EditText edtId, edtName;
    private TextView tvFilePath;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);
        edtId = findViewById(R.id.edt_ID);
        edtName = findViewById(R.id.edt_Name);
    }
    public void saveData(View view) {
        File file = null;
        String idStudent = edtId.getText().toString();
        String nameStudent = edtName.getText().toString();
        tvFilePath = findViewById(R.id.tv_filepath);
        // Save data to Internal Storage
        //file duoi .xml
        FileOutputStream fileOutputStream = null;
        try{
            idStudent = idStudent + "";
            file = getFilesDir();
            fileOutputStream = openFileOutput("code.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(idStudent.getBytes());
            fileOutputStream.write(nameStudent.getBytes());
            edtId.setText("");
            edtName.setText("");
            String filepath = "Path" + file + "- code.txt";
            Toast.makeText(InternalStorageActivity.this, "done", Toast.LENGTH_SHORT).show();
            tvFilePath.setText(filepath);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                fileOutputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void nextData(View view) {
        Intent intent = new Intent(InternalStorageActivity.this, InternalLoadDataActivity.class);
        startActivity(intent);

    }
}
