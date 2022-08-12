package com.example.barkingmadpetstorev2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import androidx.annotation.Nullable;

public class DataBaseController extends SQLiteOpenHelper {
    public static final String USER_TABLE = "USER_TABLE";
    public static final String COLUMN_USER_EMAIL = "USER_EMAIL";
    public static final String COLUMN_USER_PASSWORD = "USER_PASSWORD";
    public static final String COLUMN_USER_NAME = "USER_NAME";
    public static final String ID = "ID";

    public DataBaseController(@Nullable Context context) {
        super(context, "users.db", (CursorFactory)null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE USER_TABLE (ID INTEGER PRIMARY KEY AUTOINCREMENT, USER_EMAIL TEXT, USER_PASSWORD TEXT, USER_NAME TEXT)";
        db.execSQL(createTableStatement);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public boolean addUser(UserModel userModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("USER_EMAIL", userModel.getEmail());
        cv.put("USER_PASSWORD", userModel.getPassword());
        cv.put("USER_NAME", userModel.getUsername());
        long insert = db.insert("USER_TABLE", (String)null, cv);
        return insert != -1L;
    }
}