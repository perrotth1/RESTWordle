package ahw.restwordle.data;

import ahw.restwordle.models.Round;




public interface RESTWordleDao{
    int createGame();
    public Round guess(int guess, int game);
}

