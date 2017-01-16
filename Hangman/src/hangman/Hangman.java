/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;
import javax.swing.*;

/**
 *
 * @author hh
 */
public class Hangman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello!");
        HighscoreScreen hScreen = new HighscoreScreen();
        CreditScreen cScreen = new CreditScreen();
        Title t = new Title();
        MenuScreen mScreen = new MenuScreen();
        mScreen.setSize(600,400);
        mScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mScreen.setVisible(true);
        //t.setSize(600,400);
        //t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //t.setVisible(true);
        //hScreen.setSize(600,400);
        //hScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //hScreen.setVisible(true);
        //cScreen.setSize(600,400);
        //cScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //cScreen.setVisible(true);
    }
}
