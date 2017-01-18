/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Y-Uyen
 */
public class CheckWord {
//    private final int MAX_GUESSES = 6;
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
        char letter = guessedLetter;
        boolean result = false;
        
        System.out.println("guessed letter: " + guessedLetter);
        System.out.println("word to guess: " + wordToGuess);

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
        System.out.println("correct? " + result);
        
        return result;
    }
    
    public boolean checkGuesses() {
        boolean result = false;
        char[] charsToGuess = wordToGuess.toCharArray();
        int size = guessedLettersList.size();
        char[] guessedLetters = new char[size];
        for(int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = (char) guessedLettersList.get(i);
        }
        Arrays.sort(guessedLetters);
        Arrays.sort(charsToGuess);
        
        System.out.println("guessed: " + Arrays.toString(guessedLetters));
        System.out.println("correct: " + Arrays.toString(charsToGuess));
        
        result = Arrays.equals(charsToGuess, guessedLetters);
        return result;
    }
    
    
}
