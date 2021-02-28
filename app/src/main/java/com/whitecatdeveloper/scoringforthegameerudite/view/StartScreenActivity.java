package com.whitecatdeveloper.scoringforthegameerudite.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.whitecatdeveloper.scoringforthegameerudite.R;

public class StartScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        initDataBase();
        next();

    }

    private void initDataBase () {}

    private void next () {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}