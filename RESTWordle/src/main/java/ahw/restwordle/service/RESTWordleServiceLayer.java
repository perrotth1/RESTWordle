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
        
        //calculate results of guess
        
        
        //build round in dao
        
        //return round 
        return null;
    }
}
