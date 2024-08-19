package com.example.a1.Expense;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a1.Models.Category;
import com.example.a1.R;


import java.util.ArrayList;

public class CategoriesActivity extends AppCompatActivity {
    View include;
    ImageButton ibOption, ibAddCategory;
    EditText edtCategory;
    Button save, cancel;
    ArrayList<Category> categories = new ArrayList<>();
    GridView gridView;
    CategoryDbContext context;
    Category category;
    int[] image = {R.drawable.food,R.drawable.food,R.drawable.food,R.drawable.food,R.drawable.food};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        ibOption = findViewById(R.id.ib_option);
        ibAddCategory = findViewById(R.id.ib_addcategory);
        include = findViewById(R.id.cp_addcategory);
        edtCategory = findViewById(R.id.edt_category);
        context = new CategoryDbContext(CategoriesActivity.this);
        save = findViewById(R.id.save);
        ArrayList<Category> categories = context.getAll();
        String[] data = new String[categories.size()];
        int[] image = new int[categories.size()];
        for(int i = 0; i < data.length;i++) {
            data[i] = categories.get(i).getName();
            image[i] = R.drawable.food;
        }
        gridView = findViewById(R.id.gridView);
        GridAdapter adapter = new GridAdapter(CategoriesActivity.this,data,image);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CategoriesActivity.this,"You Clicked on" + data[position],Toast.LENGTH_LONG).show();
            }
        });
        ibAddCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                include.setVisibility(View.VISIBLE);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Category category = new Category();
                category.setName(edtCategory.getText().toString().trim());
                context.insert(category);
                include.setVisibility(View.INVISIBLE);
                edtCategory.setText("");
            }
        });
    }

}