package ahw.restwordle.data;

import ahw.restwordle.models.Game;
import ahw.restwordle.models.Guess;
import ahw.restwordle.models.Round;




public interface RESTWordleDao{
    int createGame();
    public Round guess(Guess guess);
}

