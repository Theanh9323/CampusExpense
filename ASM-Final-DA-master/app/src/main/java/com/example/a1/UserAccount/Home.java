package com.example.a1.UserAccount;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a1.Expense.CategoriesActivity;
import com.example.a1.R;

public class Home extends AppCompatActivity {

    private ImageView profileImageView;
    private ImageView logoutImageView; // Khai báo đúng ID
    private ImageButton category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        profileImageView = findViewById(R.id.profile);
        logoutImageView = findViewById(R.id.logoutImageView); // Tham chiếu đúng ID
        category = findViewById(R.id.nav_categories);
        // Nhận thông tin email từ Intent
        String userEmail = getIntent().getStringExtra("USER_EMAIL");

        profileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Profile.class);
                intent.putExtra("USER_EMAIL", userEmail); // Chuyển email đến trang Profile
                startActivity(intent);
            }
        });

        logoutImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, LoginScreen.class);
                startActivity(intent);
                finish(); // Kết thúc hoạt động hiện tại để quay lại trang đăng nhập

            }
        });
        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CategoriesActivity.class);
                startActivity(intent);
            }
        });
    }

}
