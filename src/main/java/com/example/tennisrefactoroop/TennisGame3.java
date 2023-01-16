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
            return highestScoringPlayer() + " wins";
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

    private boolean hasWinner() {
        if(playerTwoScore >= 4 && playerTwoScore >= playerOneScore + 2 )
            return true;
        if(playerOneScore >= 4 && playerOneScore >= playerTwoScore + 2)
            return true;
        return false;
    }

    private String highestScoringPlayer() {
        if (playerOneScore > playerTwoScore) {
            return playerOneName;
        } else {
            return playerTwoName;
        }
    }



}
