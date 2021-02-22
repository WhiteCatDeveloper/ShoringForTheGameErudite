package com.whitecatdeveloper.scoringforthegameerudite.view;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.whitecatdeveloper.scoringforthegameerudite.R;
import com.whitecatdeveloper.scoringforthegameerudite.model.Game;


public class EntryNameActivity extends AppCompatActivity {

    private EditText editTextNamePlayer1;
    private EditText editTextNamePlayer2;
    private EditText editTextNamePlayer3;
    private EditText editTextNamePlayer4;

    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_name);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.hide();
        editTextNamePlayer1 = findViewById(R.id.editTextEntryNamePlayer1);
        editTextNamePlayer2 = findViewById(R.id.editTextEntryNamePlayer2);
        editTextNamePlayer3 = findViewById(R.id.editTextEntryNamePlayer3);
        editTextNamePlayer4 = findViewById(R.id.editTextEntryNamePlayer4);
        game = Game.getGameInstance();
        game.setCountPlayers(2);
    }

    public void onClickAddPlayer(View view) {
        if (game.getCountPlayers() == 2)  {
            editTextNamePlayer3.setVisibility(View.VISIBLE);
            game.setCountPlayers(3);
        } else if (game.getCountPlayers() == 3) {
            editTextNamePlayer4.setVisibility(View.VISIBLE);
            game.setCountPlayers(4);
        } else {
//            Toast
        }
    }

    public void onClickDeletePlayer(View view) {
        if (game.getCountPlayers() == 4) {
            editTextNamePlayer4.setVisibility(View.INVISIBLE);
            game.setCountPlayers(3);
        } else if (game.getCountPlayers() == 3) {
            editTextNamePlayer3.setVisibility(View.INVISIBLE);
            game.setCountPlayers(2);
        } else {
//            Toast
        }
    }

    public void onClickStartGame(View view) {
        fillName();
        Intent intent = new Intent(this, ScoringActivity.class);
        startActivity(intent);
    }

    private void fillName () {
        switch (game.getCountPlayers()) {
            case 2: {
                game.setPlayerName1(editTextNamePlayer1.getText().toString());
                game.setPlayerName2(editTextNamePlayer2.getText().toString());
            } break;
            case 3: {
                game.setPlayerName1(editTextNamePlayer1.getText().toString());
                game.setPlayerName2(editTextNamePlayer2.getText().toString());
                game.setPlayerName3(editTextNamePlayer3.getText().toString());
            } break;
            case 4: {
                game.setPlayerName1(editTextNamePlayer1.getText().toString());
                game.setPlayerName2(editTextNamePlayer2.getText().toString());
                game.setPlayerName3(editTextNamePlayer3.getText().toString());
                game.setPlayerName4(editTextNamePlayer4.getText().toString());
            }
        }
    }
}