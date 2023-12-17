package com.builtin.login.db;
/*creator Brian Barnabas Langay
 email brianlangay0@gmail.com*/

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "UserData.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_USERS = "users";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NUMBER = "number";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_PHOTO = "photo";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_RECOVERY_MESSAGE = "recovery_message";

    private static final String CREATE_TABLE_USERS =
            "CREATE TABLE " + TABLE_USERS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NUMBER + " TEXT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_PASSWORD + " TEXT, " +
                    COLUMN_PHOTO + " BLOB, " +
                    COLUMN_GENDER + " TEXT, " +
                    COLUMN_RECOVERY_MESSAGE + " TEXT" +
                    ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /* for Upgrade purposes */
    }
}
