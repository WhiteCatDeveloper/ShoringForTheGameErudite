package com.whitecatdeveloper.scoringforthegameerudite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SettingsDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "settings.db";
    private static final int DB_VERSION = 1;


    public SettingsDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SettingsContract.SettingsEntry.CREATE_COMMAND);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SettingsContract.SettingsEntry.DROP_COMMAND);
        onCreate(sqLiteDatabase);
    }
}
