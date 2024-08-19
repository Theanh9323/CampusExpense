package com.example.a1.Expense;

import android.content.Context;
import android.content.Intent;
import android.net.ipsec.ike.exceptions.InvalidMajorVersionException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a1.Models.Category;
import com.example.a1.Models.Expense;
import com.example.a1.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class AddExpenseActivity extends AppCompatActivity {
    CalendarView calendarView;
    Calendar calendar;
    CategoryDbContext cateContext;
    View calendarLayout;
    ImageView calendarIcon;
    TextView tv_date;
    EditText et_mount,et_title,et_type,et_message ;
    ExpenseDbContext expContext;

    Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
        cateContext = new CategoryDbContext(AddExpenseActivity.this);
        expContext = new ExpenseDbContext(AddExpenseActivity.this);
        ArrayList<Category> categories = cateContext.getAll();
        ArrayList<String> category_name = new ArrayList<>();
        Spinner spinner = findViewById(R.id.spinner_category);
        tv_date = findViewById(R.id.tv_date);
        btnSave = findViewById(R.id.btn_save);
        et_mount = findViewById(R.id.et_amount);
        et_title = findViewById(R.id.et_expense_title);
        et_message = findViewById(R.id.et_message);
        calendarLayout = findViewById(R.id.calendar_layout);
        calendarView = findViewById(R.id.calendar_view);
        calendarIcon = findViewById(R.id.calender_icon);
        for (Category category: categories) {
            category_name.add(category.getName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,category_name);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(adapter);
        calendar = Calendar.getInstance();
        calendarIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendarLayout.setVisibility(View.VISIBLE);
            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                calendarView.setVisibility(View.GONE);
                String formatedDate = DateFormat.getDateInstance(DateFormat.FULL).format(view.getDate());
                tv_date.setText(formatedDate);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Expense expense = new Expense();
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                        Object item = parent.getItemAtPosition(pos);
                        expense.setCategoryId(1);
                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
                expense.setDate(tv_date.getText().toString().trim());
                expense.setAmount(Double.parseDouble(et_mount.getText().toString().trim()));
                expense.setTitle(et_title.getText().toString().trim());
                expense.setType("inCome");
                expense.setMessage(et_message.getText().toString().trim());
                expContext.insert(expense);
            }
        });
    }


}