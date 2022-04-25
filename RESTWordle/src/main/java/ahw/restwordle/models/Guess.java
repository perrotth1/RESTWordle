package ahw.restwordle.models;

/**
 *
 * @author Henry
 */
public class Guess {
    int gameId;
    String guess;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }
    
    
}
