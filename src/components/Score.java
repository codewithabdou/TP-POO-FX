package components;

import java.io.Serializable;

public class Score implements Serializable{
    private int score;
    private String name;

    public Score(int score, String name) {
        this.score = score;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

}
