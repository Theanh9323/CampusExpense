package com.example.campusexpense.DatabaseSQLite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.campusexpense.Model.Account;

public class AccountDatabase extends SQLiteOpenHelper {
    public static final String DB_Name = "ASMExpense";
    public static final int DB_Version = 1;
    public static final String tableName = "Account";
    public static final String id_Column = "id";
    public static final String userName_Column = "user_name";
    public static final String password_Column = "password";
    public static final String email_Column = "email";
    public static final String phone_Column = "phone";
    public AccountDatabase(@Nullable Context context) {
        super(context, DB_Name, null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " +
                tableName + "(" +
                id_Column + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                userName_Column + " VARCHAR," +
                password_Column + " VARCHAR," +
                email_Column + " VARCHAR,"+
                phone_Column + " VARCHAR" + ")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + tableName;
        db.execSQL(query);
        onCreate(db);
    }
    public long addNewAccount(String username, String password, String email, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(userName_Column, username);
        values.put(password_Column, password);
        values.put(email_Column, email);
        values.put(phone_Column, phone);
        return db.insert(tableName, null,values);
    }
    @SuppressLint("Range")
    public Account getInformationUser(String username, String password) {
        Cursor cursor = null;
        Account account = new Account();
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            String [] columns = {"id", "user_name","email","phone"};
            String conditions = userName_Column + " =?" + " AND " + password_Column + " =?";
            String [] parameter = {username, password};
            cursor = db.query(tableName, columns,conditions, parameter, null, null,null);
            if(cursor.getCount() > 0) {
                cursor.moveToFirst();
                account.setId(cursor.getInt(cursor.getColumnIndex(id_Column)));
                account.setUsername(cursor.getString(cursor.getColumnIndex(userName_Column)));
                account.setPassword(cursor.getString(cursor.getColumnIndex(password_Column)));
                account.setEmail(cursor.getString(cursor.getColumnIndex(email_Column)));
                account.setPhone(cursor.getString(cursor.getColumnIndex(phone_Column)));
            }
            db.close();
        } finally {
            assert cursor != null;
            cursor.close();
        }
        return account;
    }
}
