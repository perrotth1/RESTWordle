/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ahw.restwordle.data;

import ahw.restwordle.models.Game;
import ahw.restwordle.models.Guess;
import ahw.restwordle.models.Round;
import static java.lang.Boolean.TRUE;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author westo
 */
@Repository
public class RESTWordleDatabaseDao implements RESTWordleDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RESTWordleDatabaseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int createGame(){
        // A set of digits 1-9
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        // Randomize their order
        Collections.shuffle(numbers);
        // Since it's a set, there won't be any repeated digits
        String ans = "";
        for (int i = 0; i < 4; i++) {
            ans += numbers.get(i).toString();
        }
        
        String answer = ans;
        final String sql = "INSERT INTO games(answer, inProgress) VALUES(?,?);";
        final String sql2 = "INSERT INTO rounds(guess, result, roundTime, gameId) VALUES(?, ?, ?, ?);";
        Date locDate = Date.valueOf(LocalDate.now());
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update((Connection conn) -> {

            PreparedStatement statement = conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, answer);
            statement.setBoolean(2, TRUE);
            return statement;

        }, keyHolder);
        jdbcTemplate.update((Connection conn) -> {
            PreparedStatement statement2 = conn.prepareStatement(
            sql2);
            statement2.setString(1, "NONE");
            statement2.setString(2, "NONE");
            statement2.setDate(3, locDate);
            statement2.setInt(4, keyHolder.getKey().intValue());
            return statement2;
        });

        return keyHolder.getKey().intValue();

    }

    @Override
    public List<Game> getGames(){
        String sql = "SELECT * FROM games;";
        return jdbcTemplate.query(sql, new GamesMapper());
    }
    @Override
    public Round addRound(String guess, String result, int gameId){
        final String sql = "INSERT INTO rounds(guess, result, roundTime, gameId) "
                + "VALUES (?, ?, ?, ?)";
        
        Date date = Date.valueOf(LocalDate.now());
        
        jdbcTemplate.update( (Connection conn) -> {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, guess);
            statement.setString(2, result);
            statement.setDate(3, date );
            statement.setInt(4, gameId);
            return statement;
        });
        
        final String sqlQuery = "SELECT * FROM rounds WHERE rounds.roundId = (SELECT LAST_INSERT_ID())";
        
        return jdbcTemplate.queryForObject(sqlQuery, new RoundMapper() );
    }

    @Override
    public List<Round> getRounds(int gameId){
        String sql = "SELECT * FROM rounds WHERE gameId = ? ORDER BY roundTime;";
        return jdbcTemplate.query(sql, new RoundMapper(), gameId);
    }
    
    


    @Override
    public Game getGameById(int gameId) {
        final String sqlQuery = "SELECT * FROM games WHERE games.gameId = ?";
        return jdbcTemplate.queryForObject(sqlQuery, new GamesMapper(), gameId);
    }

    @Override
    public List<Game> getAllGames() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Round> getRoundsByGameId(int gameId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
  
    private static final class GamesMapper implements RowMapper<Game> {


        @Override
        public Game mapRow(ResultSet rs, int index) throws SQLException {
            
            
            Game game = new Game();
            game.setId(rs.getInt("gameId"));
            game.setAnswer(rs.getString("answer"));
            game.setInProgress(rs.getBoolean("inProgress"));
            return game;
        }
        
    }
    private static final class RoundMapper implements RowMapper<Round> {
        @Override
        public Round mapRow(ResultSet rs, int index) throws SQLException {
            Round round = new Round();
            round.setRoundId(rs.getInt("roundId"));
            round.setGuess(rs.getString("guess"));
            round.setResult(rs.getString("result"));
            round.setRoundTime(rs.getDate("roundTime"));
            round.setGameId(rs.getInt("gameId"));
            
            return round;
        }
        
    }
}
