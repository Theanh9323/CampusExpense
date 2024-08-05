package com.example.campusexpense;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SharedReferenceActivity extends AppCompatActivity {
    private EditText edtNumber1, edtNumber2, edtResult, edtHistory;
    private Button btnSumNumber, btnClearData;
    private TextView tvHistory;
    private String history = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_reference);
        edtNumber1 = findViewById(R.id.edt_number1);
        edtNumber2 = findViewById(R.id.edt_number2);
        edtResult = findViewById(R.id.edt_result);
        btnSumNumber = findViewById(R.id.sum_number);
        btnClearData = findViewById(R.id.clear_data);
        tvHistory = findViewById(R.id.tv_history);
        // get data from preference
        SharedPreferences myPrefers = getSharedPreferences("saveMaths", MODE_PRIVATE);
        history = myPrefers.getString("myHistory",history);

        btnSumNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number1 = Integer.parseInt(edtNumber1.getText().toString().trim());
                int number2 = Integer.parseInt(edtNumber2.getText().toString().trim());
                int result = number1 + number2;
                history += number1 +"+"+ number2 + "=" + result;
                edtResult.setText(result);
                tvHistory.setText(history);
            }
        });
        btnClearData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = "";
                tvHistory.setText(history);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences myPrefers = getSharedPreferences("saveMaths",MODE_PRIVATE);
        SharedPreferences.Editor myEditor = myPrefers.edit();
        myEditor.putString("myHistory", history);
        myEditor.apply();
    }
}
