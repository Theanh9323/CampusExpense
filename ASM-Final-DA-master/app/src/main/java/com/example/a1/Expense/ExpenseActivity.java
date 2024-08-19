package com.example.a1.Expense;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a1.Models.Expense;
import com.example.a1.R;

import java.util.ArrayList;

public class ExpenseActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Expense> expenses;
    ExpenseDbContext context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);
        recyclerView = findViewById(R.id.recycle_expense);
        context = new ExpenseDbContext(ExpenseActivity.this);
        expenses = new ArrayList<>();
        expenses =  context.getAllWithCategory(0);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecycleAdapter(getApplicationContext(),expenses));

    }
}