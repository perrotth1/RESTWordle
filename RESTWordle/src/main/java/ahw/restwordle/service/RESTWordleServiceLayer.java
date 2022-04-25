/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahw.restwordle.service;

import ahw.restwordle.controller.RESTWordleController;
import ahw.restwordle.data.RESTWordleDao;
import ahw.restwordle.models.Game;
import ahw.restwordle.models.Guess;
import ahw.restwordle.models.Round;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Henry
 */
@Repository
public class RESTWordleServiceLayer {
    
    private RESTWordleDao dao;
    
    @Autowired
    public RESTWordleServiceLayer(RESTWordleDao _dao){
        this.dao = _dao;
    }
    
    public int createGame(){
        return dao.createGame();
    }
    
    public Round guess(Guess g){
        //find game by id
        Game game = dao.getGameById(g.getGameId());
        
        //if not found return null
        if(game == null){
            return null;
        }
        
        int exact = 0, partial = 0;
        for(int i = 0; i < 4; i++){
            if(g.getGuess().charAt(i) == game.getAnswer().charAt(i)){
                exact++;
            }
            else if(game.getAnswer().substring(i).contains( Character.toString( g.getGuess().charAt(i) ) ) ){
                partial++;
            }
        }
        String resultStr = "e:" + exact + ":p:" + partial;
        
        //build round in dao
        Round result = dao.addRound(g.getGuess(), resultStr, g.getGameId());
        
        //return round 
        return result;
    }
}
