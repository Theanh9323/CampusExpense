package com.example.a1.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "user.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_USER = "user";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_FULL_NAME = "full_name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_DOB = "dob";
    public static final String COLUMN_PASSWORD = "password";

    public static final String TABLE_EXPENSE = "expense";
    public static final String COLUMN_CATEGORY_ID = "category_id";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_AMOUNT = "amount";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_MESSAGE = "message";
    public static final String COLUMN_TYPE= "type";

    public static final String TABLE_CATEGORY = "category";
    public static final String COLUMN_NAME = "category";

    private static final String TABLE_CREATE_CATEGORY =
            "CREATE TABLE " + TABLE_CATEGORY + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT); ";


    private static final String TABLE_CREATE_USER =
            "CREATE TABLE " + TABLE_USER + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_FULL_NAME + " TEXT, " +
                    COLUMN_EMAIL + " TEXT, " +
                    COLUMN_PHONE + " TEXT, " +
                    COLUMN_DOB + " TEXT, " +
                    COLUMN_PASSWORD + " TEXT);";


    private static final String TABLE_CREATE_EXPENSE =
            "CREATE TABLE " + TABLE_EXPENSE + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_DATE + " TEXT, " +
                    COLUMN_AMOUNT + " REAL, " +
                    COLUMN_TITLE + " TEXT, " +
                    COLUMN_TYPE + " TEXT, " +
                    COLUMN_MESSAGE + " TEXT);";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLE_CREATE_USER);
        db.execSQL(TABLE_CREATE_CATEGORY);
        db.execSQL(TABLE_CREATE_EXPENSE);
        db.execSQL("ALTER TABLE "+TABLE_EXPENSE+" ADD COLUMN "+COLUMN_CATEGORY_ID+" INTEGER REFERENCES "+TABLE_CATEGORY+"("+COLUMN_ID+")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXPENSE);
        onCreate(db);
    }

    public void addUser(String name, String emailText, String phoneText, String dobText, String pass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FULL_NAME, name);
        values.put(COLUMN_EMAIL, emailText);
        values.put(COLUMN_PHONE, phoneText);
        values.put(COLUMN_DOB, dobText);
        values.put(COLUMN_PASSWORD, pass);

        db.insert(TABLE_USER, null, values);
        db.close();
    }

    public Cursor getUserByEmail(String emailText) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_USER + " WHERE " + COLUMN_EMAIL + " = ?";
        return db.rawQuery(query, new String[]{emailText});
    }
}
