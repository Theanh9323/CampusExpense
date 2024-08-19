package com.example.a1.Expense;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a1.Models.Expense;
import com.example.a1.R;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<ExpenseHolder> {
    Context context;
    ArrayList<Expense> expenses = new ArrayList<>();
    int[] image = {R.drawable.food,R.drawable.food};


    public RecycleAdapter(Context context, ArrayList<Expense> expenses) {
        this.context = context;
        this.expenses = expenses;
    }

    @NonNull
    @Override
    public ExpenseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ExpenseHolder(LayoutInflater.from(context).inflate(R.layout.expense_view_component,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseHolder holder, int position) {
        holder.imageView.setImageResource(image[position]);
        holder.tv_category.setText(expenses.get(position).getTitle());
        holder.tv_date.setText(expenses.get(position).getDate());
        holder.tv_expense.setText(String.valueOf(expenses.get(position).getAmount()));
    }

    @Override
    public int getItemCount() {
        return expenses.size();
    }
}
