/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.io.Serializable;

/**
 *
 * @author hh
 */
public class Score implements Serializable {
    private final String NAME;
    private final int SCORE;
    
    public Score(String name, int score) {
        NAME = name;
        SCORE = score;
    }

    public String getName() {
        return NAME;
    }

    public int getScore() {
        return SCORE;
    }
}
