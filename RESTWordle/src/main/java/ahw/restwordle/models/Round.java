/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahw.restwordle.models;

import java.sql.Date;

/**
 *
 * @author westo
 */
public class Round {
    int roundId;
    String guess;
    String result;
    Date roundTime;
    int gameId;

    
    public int getRoundId() {
        return roundId;
    }

    public String getGuess() {
        return guess;
    }

    public String getResult() {
        return result;
    }

    public Date getRoundTime() {
        return roundTime;
    }

    public int getGameId() {
        return gameId;
    }



    public void setRoundId(int roundId) {
        this.roundId = roundId;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setRoundTime(Date roundTime) {
        this.roundTime = roundTime;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
    
    
}
