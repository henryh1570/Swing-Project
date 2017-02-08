/***************************************************************
* file: Score.java
* author: Luis Cortes, Oscar Hernandez, Henry Hu, Y-Uyen La, and An Le 
* class: CS 245 - Programming Graphical User Interfaces
*
* assignment: Swing Project v1.3
* date last modified: 2/5/2017
*
* purpose: This class is a tuple of String and int.
*
****************************************************************/ 
package hangman;

import java.io.Serializable;

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
