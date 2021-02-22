package com.whitecatdeveloper.scoringforthegameerudite.model;

import java.util.HashMap;
import java.util.Map;

public abstract class CountScore {
    protected Map<Character, Integer> scoreSymbolMap = new HashMap<>();

    public int countScoreOfSymbol(char symbol) {
        int result = 0;
        if (scoreSymbolMap.containsKey(symbol)) result = scoreSymbolMap.get(symbol);
        return result;
    }

    //  метод проверяющий содержание введенного слова
    public boolean isCorrect(char[] chars) {
        boolean result = false;
        for (char ch : chars) {
            result = scoreSymbolMap.containsKey(ch);
        }
        return result;
    }

    public int countScoreOfWord(char[] chars) {
        int result = 0;
        for (char aChar : chars) {
            result += countScoreOfSymbol(aChar);
        }
        return result;
    }

}
