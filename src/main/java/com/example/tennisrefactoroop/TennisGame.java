package com.example.tennisrefactoroop;

public interface TennisGame {

    String getScore();
    boolean hasWinner();
    String highestScoringPlayer();
    boolean playerHasAnAdvantage();
    boolean isDeuce();
    String interpreteScore(int score);

}
