package ahw.restwordle.controller;

import ahw.restwordle.data.RESTWordleDao;
import ahw.restwordle.models.Game;
import ahw.restwordle.models.Guess;
import ahw.restwordle.models.Round;
import ahw.restwordle.service.RESTWordleServiceLayer;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wordle")
public class RESTWordleController {

    private final RESTWordleServiceLayer service;
    private final RESTWordleDao dao;
    public RESTWordleController(RESTWordleServiceLayer service, RESTWordleDao dao){
        this.service = service;
        this.dao = dao;
    }
    
    @PostMapping("/begin")
    @ResponseStatus(HttpStatus.CREATED)
    public int createGame() {
        return service.createGame();
    }
    
    @PostMapping("/guess")
    public ResponseEntity guess(@RequestBody Guess g){
        Round resultRound = service.guess(g);
        if (resultRound == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(resultRound);
    }
    @GetMapping("/game")
    public List<Game> getGames()
    {
        return dao.getGames();
    }
    @GetMapping("/rounds/{gameId}")
    public List<Round> getRounds(@PathVariable int gameId){
        
        return dao.getRounds(gameId);
    }
  
/*
    @GetMapping("/{id}")
    public ResponseEntity<ToDo> findById(@PathVariable int id) {
        ToDo result = dao.findById(id);
        if (result == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }

    

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody ToDo todo) {
        ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);
        if (id != todo.getId()) {
            response = new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
        } else if (dao.update(todo)) {
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        if (dao.deleteById(id)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }*/
}
