package com.example.campusexpense;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TestFirstActivity extends AppCompatActivity {
    private final String task = "TestFirstActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_first);
        Button start = findViewById(R.id.btn_startActivity);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TestSecondActivity.class));
            }
        });
        Log.v(task, " On Create Called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(task, " On Start Called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(task, " On Resume Called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(task, " On Stop Called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(task, " On Pause Called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(task, " On Restart Called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(task, " On Destroy Called");
    }
}
