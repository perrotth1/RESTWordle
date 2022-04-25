/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahw.restwordle.service;

import ahw.restwordle.controller.RESTWordleController;
import ahw.restwordle.data.RESTWordleDao;
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
        //if not found return null
        //build round in dao
        //calculate results of guess
        //return round 
        return null;
    }
}
