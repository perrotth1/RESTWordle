package ahw.restwordle.data;

import ahw.restwordle.models.Game;

import ahw.restwordle.models.Guess;
import ahw.restwordle.models.Round;
import java.util.List;




public interface RESTWordleDao{
    int createGame();
    public Round addRound(Round round, int gameId);
    public Game getGameById(int gameId);
    public List<Game> getAllGames();
    public List<Round> getRoundsByGameId(int gameId);
    public Round guess(Guess guess);
}

