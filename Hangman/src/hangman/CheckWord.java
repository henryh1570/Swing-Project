/***************************************************************
* file: CheckWord.java
* author: Team HOALY
* class: CS 245 – Graphical User Interfaces
*
* assignment: project 1.0
* date last modified: 1/18/2017
*
* purpose: This program is the Hangman version 1.0 application.
****************************************************************/ 
package hangman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Y-Uyen
 */
public class CheckWord {
    public int numWrongGuesses;
    public int numGuesses;
    public WordBank wb = new WordBank();
    public String wordToGuess;
    public char guessedLetter;
    public List guessedLettersList;
    public char[] charsToGuessFormat;
    public String currentGuessedFormat="";
    public String correctlyGuessedFormat="";
    
    public CheckWord(String word, String format) {      
        wordToGuess = word;
        numGuesses = 0;
        numWrongGuesses = 0;
        guessedLettersList = new ArrayList<Character>();
        String wordToGuessFormat = format;
        charsToGuessFormat = wordToGuessFormat.toCharArray();
        for(int i = 0; i < charsToGuessFormat.length; i++) {
            if(charsToGuessFormat[i] == '_') {
                charsToGuessFormat[i] = ' ';
            }
        }
    }
    
    public boolean checkLetter(char guessedLetter) {
        boolean result = false;

        for(int i = 0; i < wordToGuess.length(); i++) {
            if(wordToGuess.charAt(i) == guessedLetter) {
                int index = i*2;
                guessedLettersList.add(guessedLetter);
                charsToGuessFormat[index] = guessedLetter;
                result = true;
            }
        }
        
        if(result) {
            numGuesses++;
            correctlyGuessedFormat = String.valueOf(charsToGuessFormat);
            currentGuessedFormat = correctlyGuessedFormat;
        } else {
            numGuesses++;
            numWrongGuesses++;
            correctlyGuessedFormat = currentGuessedFormat;
        }
        return result;
    }
    
    public boolean checkGuesses() {
        char[] charsToGuess = wordToGuess.toCharArray();
        int size = guessedLettersList.size();
        char[] guessedLetters = new char[size];
        
        for(int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = (char) guessedLettersList.get(i);
        }
        
        Arrays.sort(guessedLetters);
        Arrays.sort(charsToGuess);
        return Arrays.equals(charsToGuess, guessedLetters);
    }
}
