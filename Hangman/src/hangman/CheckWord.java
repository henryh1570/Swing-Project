/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

/**
 *
 * @author Y-Uyen
 */
public class CheckWord {
    private final int MAX_GUESSES = 6;
    private int num_guesses;
    public WordBank wb = new WordBank();
    public String wordToGuess;
    public char guessedLetter;
    
    public char[] charsToGuess;

    
    public CheckWord(String word, String format) {      
        wordToGuess = word;
        String wordToGuessFormat = format;
        charsToGuess = wordToGuessFormat.toCharArray();
        for(int i = 0; i < charsToGuess.length; i++) {
            if(charsToGuess[i] == '_') {
                charsToGuess[i] = ' ';
            }
        }

    }
    
    public String checkLetter(char guessedLetter) {
        char letter = guessedLetter;
        String correctlyGuessedFormat="";
        boolean correct = false;
        
        System.out.println("guessed letter: " + guessedLetter);
        System.out.println("word to guess: " + wordToGuess);
        
        
        
        for(int i = 0; i < wordToGuess.length(); i++) {
            System.out.println("word to guess char: " + wordToGuess.charAt(i));
            if(wordToGuess.charAt(i) == guessedLetter) {
                int index = i*2;
                charsToGuess[index] = guessedLetter;
                correct = true;
            }
        }
        if(correct) {
            correctlyGuessedFormat = String.valueOf(charsToGuess);
            System.out.println("correct");
        } else {
            System.out.println("false");
            correctlyGuessedFormat="";
        }
        
        return correctlyGuessedFormat;
    }
    
}
