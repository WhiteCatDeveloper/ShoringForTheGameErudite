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
        settings = Settings.getInstance();
        initDataBase();
        next();

    }


    // нужно вынести в отдельный поток
    private void initDataBase () {
        SettingsDBHelper dbHelper = new SettingsDBHelper(this);
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        String language = null;
        String color = null;
        if (database != null) {
            Cursor cursor = database.query(SettingsDBHelper.DB_NAME, null, null, null, null, null, null);
            if (cursor.moveToFirst()) {
                language = cursor.getString(cursor.getColumnIndex(SettingsContract.SettingsEntry.COLUMN_LANGUAGE));
                color = cursor.getString(cursor.getColumnIndex(SettingsContract.SettingsEntry.COLUMN_BACKGROUND_COLORS));
            }
            cursor.close();
        } else {
            language = String.valueOf(Language.CYRILLIC);
            color = String.valueOf(MyBackgroundColors.GREEN);
        }
        if (language.equals(String.valueOf(Language.LATIN))) settings.setLanguage(Language.LATIN);
        else settings.setLanguage(Language.CYRILLIC);

        if (color.equals(String.valueOf(MyBackgroundColors.BLACK ))) {
            settings.setColors(MyBackgroundColors.BLACK);
        } else if (color.equals(String.valueOf(MyBackgroundColors.BLUE))) {
            settings.setColors(MyBackgroundColors.BLUE);
        } else if (color.equals(String.valueOf(MyBackgroundColors.ORANGE))) {
            settings.setColors(MyBackgroundColors.ORANGE);
        } else if (color.equals(String.valueOf(MyBackgroundColors.YELLOW))) {
            settings.setColors(MyBackgroundColors.YELLOW);
        } else if (color.equals(String.valueOf(MyBackgroundColors.WHITE))) {
            settings.setColors(MyBackgroundColors.WHITE);
        } else settings.setColors(MyBackgroundColors.GREEN);
    }

    private void next () {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }


}