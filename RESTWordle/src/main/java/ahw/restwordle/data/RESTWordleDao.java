package ahw.restwordle.data;

import ahw.restwordle.models.Game;
import ahw.restwordle.models.Round;
import java.util.List;




public interface RESTWordleDao{
    int createGame();
    List<Game> getGames();
    List<Round> getRounds(int gameId);
}

