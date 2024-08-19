package com.example.a1.OverView;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a1.Expense.ExpenseActivity;
import com.example.a1.Expense.ExpenseDbContext;
import com.example.a1.Expense.RecycleAdapter;
import com.example.a1.Models.Expense;
import com.example.a1.R;

import java.util.ArrayList;

public class OverViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Expense> expenses;
    ExpenseDbContext context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over_view);
        recyclerView = findViewById(R.id.recycle_expense);
        context = new ExpenseDbContext(OverViewActivity.this);
        expenses = new ArrayList<>();
        expenses =  context.getAll();


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecycleAdapter(getApplicationContext(),expenses));
    }
}