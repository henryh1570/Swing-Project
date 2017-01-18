/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


/**
 *
 * @author Y-Uyen
 */
public class WordBank {
    private Random random;
    private int size;
    public int iterator;
    private final List<String> wordBank;
    private String word;
    private Set set = new HashSet();
    private ArrayList<Integer> list;
    
    /**
     * This method fills the word bank with the words for the user to guess,
     * resets the iterator to 0, and starts up the list
     * 
     */
    
    public WordBank() {
        wordBank = new ArrayList<>();
        wordBank.add("abstract");
        wordBank.add("cemetery");
        wordBank.add("nurse");
        wordBank.add("pharmacy");
        wordBank.add("climbing");
        
        size = wordBank.size(); 
        iterator = 0;
        randomNumList();
    }
    
    /**
     * This method returns a random word from the word bank.
     * @return 
     */
    
    public String getWord() {
        String word = "";
        if(iterator > size) {
            iterator = 0;
        } else {
            this.word = wordBank.get(randomNum());
            iterator++;
            word = this.word;
        }
        return word;
    }

    public String getWordFormat() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            String s = word.substring(i, i + 1);
            if (s.equals(" ") || s.equals(",")) {
                builder.append(s);
            } else if (i != word.length() -1) {
                builder.append("_ ");
            } else {
                builder.append("_");
            }
        }
        return builder.toString();
    }
       
    
    public void randomNumList() {
       list = new ArrayList<Integer>();
        for (int i=0; i<size; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
    }
    
    public int randomNum() {
        return list.get(iterator);
    }
    
}
