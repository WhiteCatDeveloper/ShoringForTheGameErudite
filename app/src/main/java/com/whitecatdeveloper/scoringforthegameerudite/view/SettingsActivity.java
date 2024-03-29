package com.whitecatdeveloper.scoringforthegameerudite.view;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Switch;

import com.whitecatdeveloper.scoringforthegameerudite.R;
import com.whitecatdeveloper.scoringforthegameerudite.database.SettingsContract;
import com.whitecatdeveloper.scoringforthegameerudite.database.SettingsDBHelper;
import com.whitecatdeveloper.scoringforthegameerudite.model.Language;
import com.whitecatdeveloper.scoringforthegameerudite.model.MyBackgroundColors;
import com.whitecatdeveloper.scoringforthegameerudite.model.Settings;

public class SettingsActivity extends AppCompatActivity {

    private Settings settings;
    private SettingsDBHelper dbHelper;

    private Switch switchLanguage;
    private RadioButton radioButtonBlack;
    private RadioButton radioButtonWhite;
    private RadioButton radioButtonYellow;
    private RadioButton radioButtonOrange;
    private RadioButton radioButtonGreen;
    private RadioButton radioButtonBlue;

    private String lang = String.valueOf(Language.CYRILLIC);
    private String bColors = String.valueOf(MyBackgroundColors.GREEN);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.hide();
        settings = Settings.getInstance();
        dbHelper = new SettingsDBHelper(this);
        switchLanguage = findViewById(R.id.switchLanguage);
        radioButtonBlack = findViewById(R.id.radioButtonBlack);
        radioButtonWhite = findViewById(R.id.radioButtonWhite);
        radioButtonYellow = findViewById(R.id.radioButtonYellow);
        radioButtonOrange = findViewById(R.id.radioButtonOrange);
        radioButtonGreen = findViewById(R.id.radioButtonGreen);
        radioButtonBlue = findViewById(R.id.radioButtonBlue);
        getRadioButtonColor();
        getLanguage();
    }

    private void getRadioButtonColor() {
        MyBackgroundColors colors = settings.getColors();
        switch (colors) {
            case BLACK: radioButtonBlack.setChecked(true);
            break;
            case WHITE: radioButtonWhite.setChecked(true);
            break;
            case YELLOW: radioButtonYellow.setChecked(true);
            break;
            case ORANGE: radioButtonOrange.setChecked(true);
            break;
            case BLUE: radioButtonBlue.setChecked(true);
            break;
            default: radioButtonGreen.setChecked(true);
        }
    }

    private void getLanguage () {
        switchLanguage.setChecked(settings.getLanguage() == Language.CYRILLIC);
    }

    public void onClickSaveSettings(View view) {
        saveSettings();
        toMain();
    }

    public void onClickToMain(View view) {
        toMain();
    }

    private void toMain () {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    private void saveSettings () {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SettingsContract.SettingsEntry.COLUMN_LANGUAGE, lang);
        contentValues.put(SettingsContract.SettingsEntry.COLUMN_BACKGROUND_COLORS, bColors);
        sqLiteDatabase.insert(SettingsDBHelper.DB_NAME, null, contentValues);
    }


}