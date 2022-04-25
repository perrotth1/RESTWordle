package ahw.restwordle.data;

import ahw.restwordle.models.Game;
import ahw.restwordle.models.Round;
import java.util.List;




public interface RESTWordleDao{
    int createGame();
    public Round guess(int guess, int game);
    public Game getGameById(int gameId);
    public List<Game> getAllGames();
    public List<Round> getRoundsByGameId(int gameId);
}

