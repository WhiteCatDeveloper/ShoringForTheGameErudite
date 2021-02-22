package com.whitecatdeveloper.scoringforthegameerudite.view;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.whitecatdeveloper.scoringforthegameerudite.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) actionBar.hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onClickToActivityScoring(View view) {
        Intent intent = new Intent(this, EntryNameActivity.class);
        startActivity(intent);
    }

    public void onClickToSettings(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}