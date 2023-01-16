package com.example.tennisrefactoroop;

public class TennisGame3 implements TennisGame {
    
    private final int playerTwoScore = 0;
    private final int playerOneScore = 0;
    private final String playerOneName;
    private final String playerTwoName;

    public TennisGame3(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public String getScore() {
        if (hasWinner()) {
            return highestScoringPlayer() + " wins";
        }

        if (playerWithAdvantage()) {
            return "Advantage " + highestScoringPlayer();
        }

        if (isDeuce())
            return "Deuce";

        if(playerOneScore == playerTwoScore) {
            return interpreteScore(playerOneScore) + " all";
        }

        return interpreteScore(playerOneScore) + "," + interpreteScore(playerTwoScore);
    }

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

    private boolean playerWithAdvantage() {
        if (playerTwoScore >= 4 && playerTwoScore == playerOneScore + 1)
            return true;
        if (playerOneScore >= 4 && playerOneScore == playerTwoScore + 1)
            return true;

        return false;

    }

    private boolean isDeuce() {
        return playerOneScore >= 3 && playerTwoScore == playerOneScore;
    }

    private String interpreteScore(int score) {
        switch (score) {
            case 3:
                return "Forty";
            case 2:
                return "Thirty";
            case 1:
                return "Fifteen";
            case 0:
                return "Love";
        }
        throw new IllegalArgumentException("Illegal score: " + score);
    }



}
