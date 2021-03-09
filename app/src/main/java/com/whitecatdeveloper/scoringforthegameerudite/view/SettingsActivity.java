package com.whitecatdeveloper.scoringforthegameerudite.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Switch;

import com.whitecatdeveloper.scoringforthegameerudite.R;
import com.whitecatdeveloper.scoringforthegameerudite.model.MyBackgroundColors;
import com.whitecatdeveloper.scoringforthegameerudite.model.Settings;

public class SettingsActivity extends AppCompatActivity {

    private Settings settings;

    private Switch switchLanguage;
    private RadioButton radioButtonBlack;
    private RadioButton radioButtonWhite;
    private RadioButton radioButtonYellow;
    private RadioButton radioButtonOrange;
    private RadioButton radioButtonGreen;
    private RadioButton radioButtonBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        settings = Settings.getInstance();
        switchLanguage = findViewById(R.id.switchLanguage);
        radioButtonBlack = findViewById(R.id.radioButtonBlack);
        radioButtonWhite = findViewById(R.id.radioButtonWhite);
        radioButtonYellow = findViewById(R.id.radioButtonYellow);
        radioButtonOrange = findViewById(R.id.radioButtonOrange);
        radioButtonGreen = findViewById(R.id.radioButtonGreen);
        radioButtonBlue = findViewById(R.id.radioButtonBlue);
        setRadioButtonColor();
    }

    private void setRadioButtonColor () {
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

    }
}