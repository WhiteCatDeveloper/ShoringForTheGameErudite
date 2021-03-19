package com.whitecatdeveloper.scoringforthegameerudite.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import com.whitecatdeveloper.scoringforthegameerudite.R;
import com.whitecatdeveloper.scoringforthegameerudite.database.SettingsContract;
import com.whitecatdeveloper.scoringforthegameerudite.database.SettingsDBHelper;
import com.whitecatdeveloper.scoringforthegameerudite.model.Language;
import com.whitecatdeveloper.scoringforthegameerudite.model.MyBackgroundColors;
import com.whitecatdeveloper.scoringforthegameerudite.model.Settings;

public class StartScreenActivity extends AppCompatActivity {
    private Settings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        initDataBase();
        next();

    }

    private void initDataBase () {
        SettingsDBHelper dbHelper = new SettingsDBHelper(this);
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Cursor cursor = database.query(SettingsDBHelper.DB_NAME, null, null, null, null, null, null);
        String language = null;
        String color = null;
        if (cursor.moveToFirst()) {
            language = cursor.getString(cursor.getColumnIndex(SettingsContract.SettingsEntry.COLUMN_LANGUAGE));
            color = cursor.getString(cursor.getColumnIndex(SettingsContract.SettingsEntry.COLUMN_BACKGROUND_COLORS));
        } else {
            language = String.valueOf(Language.CYRILLIC);
            color = String.valueOf(MyBackgroundColors.GREEN);
        }

    }

    private void next () {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }


}