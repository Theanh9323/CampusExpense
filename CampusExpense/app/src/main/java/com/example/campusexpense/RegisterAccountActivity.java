package com.example.campusexpense;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.campusexpense.DatabaseSQLite.AccountDatabase;

public class RegisterAccountActivity extends AppCompatActivity {
    private EditText edtUsernameAccount, edtPasswordAccount, edtEmailAccount, edtPhoneAccount;
    private Button btn_signup;
    private AccountDatabase accountDatabase;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeraccount);
        edtUsernameAccount = findViewById(R.id.tdt_username);
        edtPasswordAccount = findViewById(R.id.tdt_password);
        edtEmailAccount = findViewById(R.id.tdt_email);
        edtPhoneAccount = findViewById(R.id.tdt_phonenumber);
        btn_signup = findViewById(R.id.btn_signup);
        accountDatabase = new AccountDatabase(RegisterAccountActivity.this);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
                Intent intent = new Intent(RegisterAccountActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void signUp() {
        String user = edtUsernameAccount.getText().toString().trim();
        String password = edtPasswordAccount.getText().toString().trim();
        String email = edtEmailAccount.getText().toString().trim();
        String phone = edtPhoneAccount.getText().toString().trim();
        if(TextUtils.isEmpty(user)) {
            edtUsernameAccount.setError("Username is not empty");
            return;
        }
        if(TextUtils.isEmpty(password)) {
            edtPasswordAccount.setError("Password is not empty");
            return;
        }
        if(TextUtils.isEmpty(email)) {
            edtEmailAccount.setError("Email is not empty");
            return;
        }
        if(TextUtils.isEmpty(phone)) {
            edtPhoneAccount.setError("Phone Number is not empty");
            return;
        }
        long result = accountDatabase.addNewAccount(user,password, email,phone);
        if(result == -1) {
            Toast.makeText(RegisterAccountActivity.this,"Register failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(RegisterAccountActivity.this,"Register Successful", Toast.LENGTH_SHORT).show();
        }

    }
}
