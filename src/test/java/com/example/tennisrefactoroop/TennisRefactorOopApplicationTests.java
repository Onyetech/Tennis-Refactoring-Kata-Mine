package com.example.tennisrefactoroop;

import junit.framework.TestCase;
public class TennisRefactorOopApplicationTests extends TestCase {

    TennisGameActivity game = new TennisGameActivity("James" , "Paul");

    public void testNewGameShouldReturnLoveAll()
    {
        String score = game.getScore();

        assertEquals("Love all", score);
    }

    public void testPlayerOneWinsFirstBall()
    {
        game.playerOneScores();

        String score = game.getScore();
        assertEquals("Fifteen,Love", score);
        // player one score greater initially
    }

    public void testPlayerTwoWinsFirstBall()
    {
        game.playerTwoScores();

        String score = game.getScore();
        assertEquals("Love,Fifteen", score);
        // only possible this way, as the other case
    }

    public void testFifteenAll(){
        game.playerOneScores();
        game.playerTwoScores();

        String score = game.getScore();
        assertEquals("Fifteen all", score);
    }

    public void testPlayerTwoWinsFirstTwoBalls() {
        createScore(0, 2);

        String score = game.getScore();
        assertEquals("Love,Thirty", score);
    }


    public void testPlayerOneWinsFirstThreeBalls(){
        createScore(3, 0);
        String score = game.getScore();
        assertEquals("Forty,Love", score);
    }

    public void testPlayersAreDeuce() {
        createScore(3, 3);

        String score = game.getScore();
        assertEquals("Deuce", score);
    }

    public void testPlayerOneWinsGame()
    {
        createScore(4, 0);

        String score = game.getScore();
        assertEquals("James wins", score);
    }

    public void testPlayerTwoWinsGame(){
        createScore(1,4);

        String score = game.getScore();
        assertEquals("Paul wins", score);
    }

    public void testPlayersAreDuce4() {
        createScore(4, 4);
        String score = game.getScore();
        assertEquals("Deuce", score);
    }

    public void testPlayerTwoAdvantage(){
        createScore(4, 5);

        String score = game.getScore();
        assertEquals("Advantage Paul", score);
    }

    public void testPlayerOneAdvantage(){
        createScore(5, 4);

        String score = game.getScore();
        assertEquals("Advantage James", score);
    }

    public void testPlayerTwoWins(){
        createScore(2, 4);
        String score = game.getScore();
        assertEquals("Paul wins", score);
    }


    public void testPlayerTwoWinsAfterAdvantage() {
        createScore(6, 8);
        String score = game.getScore();
        assertEquals("Paul wins", score);
    }



    public void testPlayerOneWinsAfterAdvantage() {
        createScore(8, 6);
        String score = game.getScore();
        assertEquals("James", score);
    }

    private void createScore(int playerOneBalls, int playerTwoBalls ) {
        for (int i = 0; i < playerOneBalls; i++) {
            game.playerOneScores();
        }
        for (int i = 0; i < playerTwoBalls; i++) {
            game.playerTwoScores();
        }
    }

}
