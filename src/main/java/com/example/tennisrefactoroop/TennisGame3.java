package com.example.tennisrefactoroop;

public class TennisGame3 implements TennisGame {
    
    private int playerTwoScore = 0;
    private int playerOneScore = 0;
    private String playerOneName;
    private String playerTwoName;

    public TennisGame3(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public String getScore() {
        if (hasWinner()) {
            return playerWithHighestScore() + " wins";
        }

        if (hasAdvantage()) {
            return "Advantage " + playerWithHighestScore();
        }

        if (isDeuce())
            return "Deuce";

        if(playerOneScore == playerTwoScore) {
            return translateScore(playerOneScore) + " all";
        }

        return translateScore(playerOneScore) + "," + translateScore(playerTwoScore);
    }
    
//    public void wonPoint(String playerName) {
//        if (playerName == "player1")
//            this.playerOneScore += 1;
//        else
//            this.playerTwoScore += 1;
//
//    }



}
