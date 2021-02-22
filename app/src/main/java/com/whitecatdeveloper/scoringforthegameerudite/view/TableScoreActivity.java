package com.whitecatdeveloper.scoringforthegameerudite.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.whitecatdeveloper.scoringforthegameerudite.R;
import com.whitecatdeveloper.scoringforthegameerudite.model.Game;

public class TableScoreActivity extends AppCompatActivity {

    private Game game;

    private TextView textViewNamePlayer1;
    private TextView textViewNamePlayer2;
    private TextView textViewNamePlayer3;
    private TextView textViewNamePlayer4;
    private TextView textViewScorePlayer1;
    private TextView textViewScorePlayer2;
    private TextView textViewScorePlayer3;
    private TextView textViewScorePlayer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_score);
        textViewNamePlayer1 = findViewById(R.id.textViewPlayer1);
        textViewNamePlayer2 = findViewById(R.id.textViewPlayer2);
        textViewNamePlayer3 = findViewById(R.id.textViewPlayer3);
        textViewNamePlayer4 = findViewById(R.id.textViewPlayer4);
        textViewScorePlayer1 = findViewById(R.id.textViewScorePlayer1);
        textViewScorePlayer2 = findViewById(R.id.textViewScorePlayer2);
        textViewScorePlayer3 = findViewById(R.id.textViewScorePlayer3);
        textViewScorePlayer4 = findViewById(R.id.textViewScorePlayer4);
        game = Game.getGameInstance();
        fillTable();
    }

    public void onClickNextMove(View view) {
        game.nextPlayerTurn();
        Intent intent = new Intent(this, ScoringActivity.class);
        startActivity(intent);
    }

    public void onClickEndGame(View view) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Предупреждение");
        dialog.setMessage("Вы действительно хотите завершить игру?");
        dialog.setPositiveButton("ДА", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                game.endGame();
                Intent intent = new Intent(TableScoreActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
        dialog.setNegativeButton("НЕТ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        dialog.show();
    }

    private void fillTable () {
        switch (game.getCountPlayers()) {
            case 2: {
                textViewNamePlayer1.setText(game.getPlayerName1());
                textViewNamePlayer2.setText(game.getPlayerName2());
                textViewScorePlayer1.setText(String.valueOf(game.getShorePlayer1()));
                textViewScorePlayer2.setText(String.valueOf(game.getShorePlayer2()));
            } break;
            case 3:{
                textViewNamePlayer1.setText(game.getPlayerName1());
                textViewNamePlayer2.setText(game.getPlayerName2());
                textViewNamePlayer3.setText(game.getPlayerName3());
                textViewScorePlayer1.setText(String.valueOf(game.getShorePlayer1()));
                textViewScorePlayer2.setText(String.valueOf(game.getShorePlayer2()));
                textViewScorePlayer3.setText(String.valueOf(game.getShorePlayer3()));
                textViewNamePlayer3.setVisibility(View.VISIBLE);
                textViewScorePlayer3.setVisibility(View.VISIBLE);
            } break;
            case 4: {
                textViewNamePlayer1.setText(game.getPlayerName1());
                textViewNamePlayer2.setText(game.getPlayerName2());
                textViewNamePlayer3.setText(game.getPlayerName3());
                textViewNamePlayer4.setText(game.getPlayerName4());
                textViewScorePlayer1.setText(String.valueOf(game.getShorePlayer1()));
                textViewScorePlayer2.setText(String.valueOf(game.getShorePlayer2()));
                textViewScorePlayer3.setText(String.valueOf(game.getShorePlayer3()));
                textViewScorePlayer4.setText(String.valueOf(game.getShorePlayer4()));
                textViewNamePlayer3.setVisibility(View.VISIBLE);
                textViewNamePlayer4.setVisibility(View.VISIBLE);
                textViewScorePlayer3.setVisibility(View.VISIBLE);
                textViewScorePlayer4.setVisibility(View.VISIBLE);
            }
        }
    }
}