/***************************************************************
* file: Hangman.java
* author: Team HOALY
* class: CS 245 – Graphical User Interfaces
*
* assignment: project 1.0
* date last modified: 1/18/2017
*
* purpose: This program is the Hangman version 1.0 application.
****************************************************************/
package hangman;

import javax.swing.*;
import java.awt.Point;
import java.awt.GraphicsEnvironment;

/**
 * @author hh
 */
public class Hangman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Title title = new Title();
        MenuScreen mScreen = new MenuScreen();
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        
        //display title screen first.
        title.setSize(600,400);
        title.setBounds(center.x - 600/2, center.y - 400/2, 600, 400);
        title.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        title.setVisible(true);
        
        try{
            Thread.sleep(3000);
            mScreen.setSize(600,400);
            mScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            title.dispose();
            mScreen.setBounds(center.x - 600/2, center.y - 400/2, 600, 400);
            mScreen.setVisible(true);
            
        } catch(InterruptedException e){
        }
    }
}
