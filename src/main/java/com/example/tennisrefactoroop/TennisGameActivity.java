package com.example.tennisrefactoroop;

public class TennisGameActivity implements TennisGame{
    
    private int playerTwoScore = 0;
    private int playerOneScore = 0;
    private final String playerOneName;
    private final String playerTwoName;

    public TennisGameActivity(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    @Override
    public String getScore() {
        if (hasWinner()) {
            return highestScoringPlayer() + " wins";
        }

        if (playerHasAnAdvantage()) {
            return "Advantage " + highestScoringPlayer();
        }

        if (isDeuce())
            return "Deuce";

        if(playerOneScore == playerTwoScore) {
            return interpreteScore(playerOneScore) + " all";
        }

        return interpreteScore(playerOneScore) + "," + interpreteScore(playerTwoScore);
    }

    @Override
    public boolean hasWinner() {
        if(playerTwoScore >= 4 && playerTwoScore >= playerOneScore + 2 )
            return true;
        if(playerOneScore >= 4 && playerOneScore >= playerTwoScore + 2)
            return true;
        return false;
    }

    @Override
    public String highestScoringPlayer() {
        if (playerOneScore > playerTwoScore) {
            return playerOneName;
        } else {
            return playerTwoName;
        }
    }

    @Override
    public boolean playerHasAnAdvantage() {
        if (playerTwoScore >= 4 && playerTwoScore == playerOneScore + 1)
            return true;
        if (playerOneScore >= 4 && playerOneScore == playerTwoScore + 1)
            return true;

        return false;

    }

    @Override
    public boolean isDeuce() {
        return playerOneScore >= 3 && playerTwoScore == playerOneScore;
    }

    @Override
    public String interpreteScore(int score) {
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

    public void playerOneScores() {
        playerOneScore++;
    }

    public void playerTwoScores() {
        playerTwoScore++;
    }
}
