package com.example.campusexpense;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DemoElementActivity extends AppCompatActivity {
    private CheckBox yes;
    private CheckBox no;
    private RadioButton female;
    private RadioButton male;
    private Button verify;
    private Button clickMe;
    private boolean enableClick = false;
    private final String tag = "DemoCheckBox";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_element);
        yes = findViewById(R.id.cb_yes);
        no = findViewById(R.id.cb_no);
        female = findViewById(R.id.rb_female);
        male = findViewById(R.id.rb_male);
        clickMe = findViewById(R.id.btn_clickMe);
        verify = findViewById(R.id.btn_verify);
        yes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    Log.v(tag,"Yes Checked");
                    clickMe.setEnabled(true);
                } else {
                    Log.v(tag,"Yes Unchecked");
                    clickMe.setEnabled(false);
                }
            }
        });
        no.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    enableClick = true;
                    clickMe.setEnabled(enableClick);
                    Log.v(tag,"No Checked");
                } else {
                    enableClick = false;
                    clickMe.setEnabled(enableClick);
                    Log.v(tag,"No Unchecked");
                }
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verify.setEnabled(true);
                male.setChecked(false);
                Log.v(tag,"female Radio is checked");
            }
        });
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verify.setEnabled(true);
                female.setChecked(false);
                Log.v(tag,"male Radio is checked");
            }
        });
    }
    public void handleClickable(View view){
        no = findViewById(R.id.cb_no);
        yes = findViewById(R.id.cb_yes);
        if(no.isChecked()) {
            Toast.makeText(this,"They not agree with us",Toast.LENGTH_SHORT).show();
        } else if(yes.isChecked()) {
            Toast.makeText(this,"They agree with us",Toast.LENGTH_SHORT).show();
        }
    }
}