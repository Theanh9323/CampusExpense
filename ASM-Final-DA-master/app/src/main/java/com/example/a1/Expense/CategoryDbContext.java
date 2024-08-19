package com.example.a1.Expense;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.a1.Database.DatabaseHelper;
import com.example.a1.Models.Category;
import com.example.a1.Models.Expense;

import java.util.ArrayList;

public class CategoryDbContext {
    DatabaseHelper helper;
    SQLiteDatabase database;
    public CategoryDbContext(Context context) {
        helper = new DatabaseHelper(context);
        database = helper.getWritableDatabase();
    }
    public long insert(Category category) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NAME,category.getName());
        return database.insert(DatabaseHelper.TABLE_CATEGORY, null, values);
    }
    public ArrayList<Category> getAll() {
        ArrayList<Category>list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_CATEGORY, null);
        if(cursor.getCount() >0){
            cursor.moveToFirst();
            do{
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                Category category = new Category();
                category.setId(id);
                category.setName(name);
                list.add(category);
            }while (cursor.moveToNext());
        }
        return list;
    }

}
