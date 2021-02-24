package com.whitecatdeveloper.scoringforthegameerudite.view;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.whitecatdeveloper.scoringforthegameerudite.R;
import com.whitecatdeveloper.scoringforthegameerudite.model.CountScore;
import com.whitecatdeveloper.scoringforthegameerudite.model.CountScoreCyrillic;
import com.whitecatdeveloper.scoringforthegameerudite.model.Game;

import java.util.ArrayList;

public class ScoringActivity extends AppCompatActivity {

    private EditText wordInput;
    private String word;
    private CountScore countScore;
    private TextView textViewPrintScore;
    private TextView textViewPlayerName;
    private Spinner spinnerSelectMultipliersWord;
    private Spinner spinnerSelectMultipliersLetter1;
    private Spinner spinnerSelectMultipliersLetter2;
    private Spinner spinnerSelectMultipliersLetter3;
    private Spinner spinnerLetter1;
    private Spinner spinnerLetter2;
    private Spinner spinnerLetter3;
    private int score;
    private Game game;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> wordList = new ArrayList<>();

    private boolean selectMultipliers = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoring);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) actionBar.hide();
        initObject();
        countScore = new CountScoreCyrillic();
        spinnerManager();
    }

    public void onClickSelectMultipliers(View view) {
        inputWord();
        selectMultipliers = true;
    }

    public void onClickSaveScore(View view) {
        if (selectMultipliers) {
            game.setScoreCurrentPlayer(score);
        } else {
            char[] symbols = wordInput.getText().toString().toCharArray();
            game.setScoreCurrentPlayer(countScore.countScoreOfWord(symbols));
        }
        Intent intent = new Intent(this, TableScoreActivity.class);
        startActivity(intent);
    }

    private void inputWord () {
        word = wordInput.getText().toString().toLowerCase();
        if (countScore.isCorrect(word.toCharArray())) {
            fillOfTheListWord();
            adapter.notifyDataSetChanged();
        } else {
            cellAlertDialog();
        }
    }


    private void countFullScore() {
        int result = 0;

        boolean spin1 = true;
        boolean spin2 = true;
        boolean spin3 = true;


        for (String s : wordList) {
            if (spin1 && spinnerLetter1.getSelectedItem().equals(s)) {
            int multiplier = spinnerSelectMultipliersLetter1.getSelectedItemPosition() + 1;
            int positionSpinner1 = spinnerLetter1.getSelectedItemPosition();
            result += (countScore.countScoreOfSymbol(wordList.get(positionSpinner1).charAt(0)) * multiplier);
            spin1 = false;
            } else if (spin2 && spinnerLetter2.getSelectedItem().equals(s)) {
                int multiplier = spinnerSelectMultipliersLetter2.getSelectedItemPosition() + 1;
                int positionSpinner2 = spinnerLetter2.getSelectedItemPosition();
                result += (countScore.countScoreOfSymbol(wordList.get(positionSpinner2).charAt(0)) * multiplier);
                spin2 = false;
            } else if (spin3 && spinnerLetter3.getSelectedItem().equals(s)) {
                int multiplier = spinnerSelectMultipliersLetter3.getSelectedItemPosition() + 1;
                int positionSpinner3 = spinnerLetter3.getSelectedItemPosition();
                result += (countScore.countScoreOfSymbol(wordList.get(positionSpinner3).charAt(0)) * multiplier);
                spin3 = false;
            } else {
                result += countScore.countScoreOfSymbol(s.charAt(0));
            }
        }
        result = result * (spinnerSelectMultipliersWord.getSelectedItemPosition() + 1);
        score = result;
        textViewPrintScore.setText(String.valueOf(result));
    }

//    Заполнение массива на основании слова
    private void fillOfTheListWord () {
        String wordCopy = word.toLowerCase();
        wordList.clear();
        wordList.add(" ");
        for (char c : wordCopy.toCharArray()) {
            wordList.add(String.valueOf(c));
        }
    }

//    Слушатели на спиннеры
    private void spinnerManager() {
        spinnerLetter1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0) {
                    if (i == spinnerLetter2.getSelectedItemPosition() || i == spinnerLetter3.getSelectedItemPosition()) {
                       cellWarningToast();
                       spinnerLetter1.setSelection(0);
                    } else {
                        spinnerLetter2.setVisibility(View.VISIBLE);
                        spinnerSelectMultipliersLetter2.setVisibility(View.VISIBLE);
                    }
                }
                countFullScore();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        spinnerLetter2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0) {
                    if (i == spinnerLetter1.getSelectedItemPosition() || i == spinnerLetter3.getSelectedItemPosition()) {
                        cellWarningToast();
                        spinnerLetter2.setSelection(0);
                    } else {
                        spinnerLetter3.setVisibility(View.VISIBLE);
                        spinnerSelectMultipliersLetter3.setVisibility(View.VISIBLE);
                    }
                }
                countFullScore();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        spinnerLetter3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0) {
                    if (i == spinnerLetter1.getSelectedItemPosition() || i == spinnerLetter2.getSelectedItemPosition()) {
                        cellWarningToast();
                        spinnerLetter3.setSelection(0);
                    }
                }
                countFullScore();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        spinnerSelectMultipliersWord.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                countFullScore();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        spinnerSelectMultipliersLetter1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                countFullScore();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        spinnerSelectMultipliersLetter2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                countFullScore();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        spinnerSelectMultipliersLetter3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                countFullScore();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }


    private void cellAlertDialog () {
//        Убери хардкод)
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("НЕКОРРЕКТНЫЙ ВВОД");
        alertDialog.setMessage("Слово должно состоять только из букв русского алфавита");
        alertDialog.setPositiveButton("Ввести заново", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                wordInput.setText("");
            }
        });
        alertDialog.setNegativeButton("Исправить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        alertDialog.show();
    }

    private void cellWarningToast () {
        Toast toast = Toast.makeText(getApplicationContext(), "ЭТА БУКВА УЖЕ ВЫБРАНА", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0 ,0);
        toast.show();
    }


//    Инициализация всех переменных
    private void initObject() {
        wordInput = findViewById(R.id.editTextWordInput);
        textViewPrintScore = findViewById(R.id.textViewPrintScore);
        textViewPlayerName = findViewById(R.id.textViewPlayerName);
        spinnerSelectMultipliersWord = findViewById(R.id.spinnerSelectMultipliersWord);
        spinnerSelectMultipliersLetter1 = findViewById(R.id.spinnerSelectMultipliersLetter1);
        spinnerSelectMultipliersLetter2 = findViewById(R.id.spinnerSelectMultipliersLetter2);
        spinnerSelectMultipliersLetter3 = findViewById(R.id.spinnerSelectMultipliersLetter3);
        spinnerLetter1 = findViewById(R.id.spinnerLetter1);
        spinnerLetter2 = findViewById(R.id.spinnerLetter2);
        spinnerLetter3 = findViewById(R.id.spinnerLetter3);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, wordList);
        spinnerLetter1.setAdapter(adapter);
        spinnerLetter2.setAdapter(adapter);
        spinnerLetter3.setAdapter(adapter);
        initName();
    }

    private void initName() {
        game = Game.getGameInstance();
        String name = "Ход игрока: " + game.getNameCurrentPlayer();
        textViewPlayerName.setText(name);
    }


}