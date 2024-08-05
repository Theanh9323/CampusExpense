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
import com.example.campusexpense.Model.Account;

public class LoginAccountActivity extends AppCompatActivity {
    public AccountDatabase accountDatabase;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_account);
        Button btnSignUp = findViewById(R.id.btn_register);
        Button btnLogin = findViewById(R.id.btn_login);
        EditText edtUserAccount = findViewById(R.id.tdt_username);
        EditText edtPassword = findViewById(R.id.tdt_password);
        accountDatabase = new AccountDatabase(LoginAccountActivity.this);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginAccountActivity.this, RegisterAccountActivity.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = edtUserAccount.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                if(TextUtils.isEmpty(userName)) {
                    edtUserAccount.setError("User name is not empty");
                    return;
                }
                if(TextUtils.isEmpty(password)) {
                    edtPassword.setError("Password is not empty");
                    return;
                }
                Account account = new Account();
                account = accountDatabase.getInformationUser(userName,password);
                assert account != null;
                if(account.getEmail() != null) {
                    String email = account.getEmail();
                    Toast.makeText(LoginAccountActivity.this,email,Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginAccountActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
