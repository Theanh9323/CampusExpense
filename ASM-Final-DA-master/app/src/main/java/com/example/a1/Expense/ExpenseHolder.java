package com.example.a1.Expense;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a1.R;

import org.w3c.dom.Text;

public class ExpenseHolder extends RecyclerView.ViewHolder {
    ExpenseActivity expenseActivity = new ExpenseActivity();
    ImageView imageView;
    TextView tv_category, tv_date,tv_expense;
    ExpenseDbContext context;
    public static int selectedPosition=-1;
    public ExpenseHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.img_expense);
        tv_category = itemView.findViewById(R.id.tv_category);
        tv_date = itemView.findViewById(R.id.tv_expense_date);
        tv_expense = itemView.findViewById(R.id.expense);
        Button button = itemView.findViewById(R.id.add_expense);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPosition=getAdapterPosition();
            }
        });
    }
}
