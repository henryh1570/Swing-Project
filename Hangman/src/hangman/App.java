/***************************************************************
* file: Hangman.java
* author: Luis Cortes, Oscar Hernandez, Henry Hu, Y-Uyen La, and An Le 
* class: CS 245 - Programming Graphical User Interfaces
*
* assignment: Swing Project v1.0
* date last modified: 1/18/2017
*
* purpose: This program is a game of Hangman where users are allowed up to 6 tries
* to guess the word correctly. 
*
****************************************************************/ 
package hangman;
import javax.swing.*;
import java.awt.Point;
import java.awt.GraphicsEnvironment;

//class: Hangman
//purpose: This class is the starting point for the game.
public class App {

    //method: Main method
    //purpose: Creates the objects of the other classes and calls the initial TitleScreen, pauses for 3 seconds and then calls MenuScreen
    //where the game functions lie.
    public static void main(String[] args) {
        Title t = new Title();
        MenuScreen mScreen = new MenuScreen();
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        
        //display title screen first.
        t.setSize(600,400);
        t.setBounds(center.x - 600/2, center.y - 400/2, 600, 400);
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.setVisible(true);
        
        //pause for 3 seconds and then display the menu screen
        try{
            Thread.sleep(3000);
            mScreen.setSize(600,400);
            mScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            t.dispose();
            mScreen.setBounds(center.x - 600/2, center.y - 400/2, 600, 400);
            mScreen.setVisible(true);
            
        } catch(InterruptedException e){
            
        }
    }
    
}
