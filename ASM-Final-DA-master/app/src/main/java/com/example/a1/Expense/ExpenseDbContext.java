package com.example.a1.Expense;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.a1.Database.DatabaseHelper;
import com.example.a1.Models.Category;
import com.example.a1.Models.Expense;

import java.util.ArrayList;

public class ExpenseDbContext {
    DatabaseHelper helper;
    SQLiteDatabase database;
    public ExpenseDbContext(Context context) {
        helper = new DatabaseHelper(context);
        database = helper.getWritableDatabase();
    }
    public long insert(Expense expense) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_DATE,expense.getDate());
        values.put(DatabaseHelper.COLUMN_AMOUNT,expense.getAmount());
        values.put(DatabaseHelper.COLUMN_TITLE,expense.getTitle());
        values.put(DatabaseHelper.COLUMN_TYPE,expense.getType());
        values.put(DatabaseHelper.COLUMN_MESSAGE,expense.getMessage());
        values.put(DatabaseHelper.COLUMN_CATEGORY_ID,expense.getCategoryId());
        return database.insert(DatabaseHelper.TABLE_EXPENSE, null, values);
    }
    public ArrayList<Expense> getAllAmount() {
        ArrayList<Expense>list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_EXPENSE +"",null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                int id = cursor.getInt(0);
                String date = cursor.getString(1);
                double amount = cursor.getDouble(2);
                String title = cursor.getString(3);
                String type = cursor.getString(4);
                String message = cursor.getString(5);
                int cate_id = cursor.getInt(6);
                Expense expense = new Expense();
                expense.setId(id);
                expense.setDate(date);
                expense.setAmount(amount);
                expense.setTitle(title);
                expense.setType(type);
                expense.setMessage(message);
                expense.setCategoryId(cate_id);
                list.add(expense);
            }while (cursor.moveToNext());
        }
        return list;
    }
    public ArrayList<Expense> getAll() {
        ArrayList<Expense>list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_EXPENSE,null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                int id = cursor.getInt(0);
                String date = cursor.getString(1);
                double amount = cursor.getDouble(2);
                String title = cursor.getString(3);
                String type = cursor.getString(4);
                String message = cursor.getString(5);
                int cate_id = cursor.getInt(6);
                Expense expense = new Expense();
                expense.setId(id);
                expense.setDate(date);
                expense.setAmount(amount);
                expense.setTitle(title);
                expense.setType(type);
                expense.setMessage(message);
                expense.setCategoryId(cate_id);
                list.add(expense);
            }while (cursor.moveToNext());
        }
        return list;
    }
    public ArrayList<Expense> getAllWithCategory(int index) {
        ArrayList<Expense>list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_EXPENSE + " WHERE "+ DatabaseHelper.COLUMN_CATEGORY_ID +"="+ index,null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                int id = cursor.getInt(0);
                String date = cursor.getString(1);
                double amount = cursor.getDouble(2);
                String title = cursor.getString(3);
                String type = cursor.getString(4);
                String message = cursor.getString(5);
                int cate_id = cursor.getInt(6);
                Expense expense = new Expense();
                expense.setId(id);
                expense.setDate(date);
                expense.setAmount(amount);
                expense.setTitle(title);
                expense.setType(type);
                expense.setMessage(message);
                expense.setCategoryId(cate_id);
                list.add(expense);
            }while (cursor.moveToNext());
        }
        return list;
    }
}
