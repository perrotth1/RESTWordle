package ahw.restwordle.models;

import java.util.Map;

public class Game {
    private int id;
    private String answer;
    private boolean inProgress;
    private Map<String, String> rounds;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }

    public Map<String, String> getRounds() {
        return rounds;
    }

    public void setRounds(Map<String, String> rounds) {
        this.rounds = rounds;
    }
    
    public void addRound(String guess, String result){
        rounds.put(guess, result);
    }
    
}
