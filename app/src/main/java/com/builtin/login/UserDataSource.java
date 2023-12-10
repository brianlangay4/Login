package com.builtin.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.builtin.login.db.DatabaseHelper;
import com.builtin.login.models.User;

public class UserDataSource {

    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public UserDataSource(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public long createUser(User user) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NUMBER, user.getNumber());
        values.put(DatabaseHelper.COLUMN_NAME, user.getName());
        values.put(DatabaseHelper.COLUMN_PASSWORD, user.getPassword());
        values.put(DatabaseHelper.COLUMN_PHOTO, user.getPhoto());
        values.put(DatabaseHelper.COLUMN_GENDER, user.getGender());
        values.put(DatabaseHelper.COLUMN_RECOVERY_MESSAGE, user.getRecoveryMessage());

        return database.insert(DatabaseHelper.TABLE_USERS, null, values);
    }

    public User getUser(String number, String password) {
        User user = null;

        Cursor cursor = database.query(
                DatabaseHelper.TABLE_USERS,
                null,
                DatabaseHelper.COLUMN_NUMBER + " = ? AND " + DatabaseHelper.COLUMN_PASSWORD + " = ?",
                new String[]{number, password},
                null,
                null,
                null
        );

        if (cursor != null && cursor.moveToFirst()) {
            user = cursorToUser(cursor);
            cursor.close();
        }

        return user;
    }

    private User cursorToUser(Cursor cursor) {
        User user = new User();

        int idIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_ID);
        int numberIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_NUMBER);
        int nameIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME);
        int passwordIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_PASSWORD);
        int photoIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_PHOTO);
        int genderIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_GENDER);
        int recoveryMessageIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_RECOVERY_MESSAGE);

        // Check if the column exists in the cursor
        if (idIndex != -1) {
            user.setId(cursor.getInt(idIndex));
        }

        if (numberIndex != -1) {
            user.setNumber(cursor.getString(numberIndex));
        }

        if (nameIndex != -1) {
            user.setName(cursor.getString(nameIndex));
        }

        if (passwordIndex != -1) {
            user.setPassword(cursor.getString(passwordIndex));
        }

        if (photoIndex != -1) {
            user.setPhoto(cursor.getBlob(photoIndex));
        }

        if (genderIndex != -1) {
            user.setGender(cursor.getString(genderIndex));
        }

        if (recoveryMessageIndex != -1) {
            user.setRecoveryMessage(cursor.getString(recoveryMessageIndex));
        }

        return user;
    }

}
