package com.whitecatdeveloper.scoringforthegameerudite.model;


public class Game {
    // Нужно подумать о том чтобы игрока вынести в отдельный класс

    private String playerName1;
    private String playerName2;
    private String playerName3;
    private String playerName4;

    private int shorePlayer1 = 0;
    private int shorePlayer2 = 0;
    private int shorePlayer3 = 0;
    private int shorePlayer4 = 0;

    private int countPlayers;
    private int playerTurn = 1;

    private static Game gameInstance;



    public static Game getGameInstance() {
        if (gameInstance == null) gameInstance = new Game();
        return gameInstance;
    }

    public String getPlayerName1() {
        return playerName1;
    }

    public void setPlayerName1(String playerName1) {
        this.playerName1 = playerName1;
    }

    public String getPlayerName2() {
        return playerName2;
    }

    public void setPlayerName2(String playerName2) {
        this.playerName2 = playerName2;
    }

    public String getPlayerName3() {
        return playerName3;
    }

    public void setPlayerName3(String playerName3) {
        this.playerName3 = playerName3;
    }

    public String getPlayerName4() {
        return playerName4;
    }

    public void setPlayerName4(String playerName4) {
        this.playerName4 = playerName4;
    }

    public int getShorePlayer1() {
        return shorePlayer1;
    }

    public void setShorePlayer1(int shorePlayer1) {
        this.shorePlayer1 = shorePlayer1;
    }

    public int getShorePlayer2() {
        return shorePlayer2;
    }

    public void setShorePlayer2(int shorePlayer2) {
        this.shorePlayer2 = shorePlayer2;
    }

    public int getShorePlayer3() {
        return shorePlayer3;
    }

    public void setShorePlayer3(int shorePlayer3) {
        this.shorePlayer3 = shorePlayer3;
    }

    public int getShorePlayer4() {
        return shorePlayer4;
    }

    public void setShorePlayer4(int shorePlayer4) {
        this.shorePlayer4 = shorePlayer4;
    }

    public int getCountPlayers() {
        return countPlayers;
    }

    public void setCountPlayers(int  countPlayers) {
        this.countPlayers = countPlayers;
    }

    public void nextPlayerTurn() {
        if (playerTurn == countPlayers) playerTurn = 1;
        else playerTurn ++;
    }

    public String getNameCurrentPlayer () {
        String result = "";
        switch (playerTurn) {
            case 1: result = getPlayerName1();
            break;
            case 2: result = getPlayerName2();
            break;
            case 3: result = getPlayerName3();
            break;
            case 4: result = getPlayerName4();
        }
        return result;
    }

    public void setScoreCurrentPlayer (int score) {
        switch (playerTurn) {
            case 1: setShorePlayer1(shorePlayer1 + score);
            break;
            case 2: setShorePlayer2(shorePlayer2 + score);
            break;
            case 3: setShorePlayer3(shorePlayer3 + score);
            break;
            case 4: setShorePlayer4(shorePlayer4 + score);
        }
    }

    public void endGame() {
        playerName1 = "";
        playerName2 = "";
        playerName3 = "";
        playerName4 = "";
        shorePlayer1 = 0;
        shorePlayer2 = 0;
        shorePlayer3 = 0;
        shorePlayer4 = 0;
        playerTurn = 1;
    }


    
    public String winner() {
        String result;
        if (beastScore() == shorePlayer1) {
            result = playerName1;
        } else if (beastScore() == shorePlayer2) {
            result = playerName2;
        } else if (beastScore() == shorePlayer3) {
            result = playerName3;
        } else if (beastScore() == shorePlayer4) {
            result = playerName4;
        } else {
            result = "Никто не";
        }
        return result;
    }


    public int beastScore () {
        int beastScore = 0;
        if (getShorePlayer1() > beastScore) beastScore = getShorePlayer1();
        if (getShorePlayer2() > beastScore) beastScore = getShorePlayer2();
        if (getShorePlayer3() > beastScore) beastScore = getShorePlayer3();
        if (getShorePlayer4() > beastScore) beastScore = getShorePlayer4();
        return beastScore;
    }
}
