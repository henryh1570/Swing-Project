/***************************************************************
* file: App.java
* author: Luis Cortes, Oscar Hernandez, Henry Hu, Y-Uyen La, and An Le 
* class: CS 245 - Programming Graphical User Interfaces
*
* assignment: Swing Project v1.0
* date last modified: 2/5/2017
*
* purpose: This is the main driver class that runs the game program.
*
****************************************************************/ 
package hangman;
import javax.swing.*;
import java.awt.Point;
import java.awt.GraphicsEnvironment;

//class: App
//purpose: This class is the starting point for the game.
public class App {

    //method: Main method
    //purpose: Creates the objects of the other classes and calls the initial TitleScreen, pauses for 3 seconds and then calls MenuScreen
    //where the game functions lie.
    public static void main(String[] args) {
        Title title = new Title();
        MenuScreen menu = new MenuScreen();
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        
        //display title screen first.
        title.setSize(600,400);
        title.setBounds(center.x - 600/2, center.y - 400/2, 600, 400);
        title.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        title.setVisible(true);
        
        //pause for 3 seconds and then display the menu screen
        try{
            Thread.sleep(3000);
            menu.setSize(600,400);
            menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            title.dispose();
            menu.setBounds(center.x - 600/2, center.y - 400/2, 600, 400);
            menu.setVisible(true);
            
        } catch(InterruptedException e){
            
        }
    }
    
}
