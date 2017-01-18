/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;
import javax.swing.*;
import java.awt.Point;
import java.awt.GraphicsEnvironment;

/**
 *
 * @author hh
 */
public class Hangman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Title t = new Title();
        MenuScreen mScreen = new MenuScreen();
        
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        
        //display title screen first.
        t.setSize(600,400);
        t.setBounds(center.x - 600/2, center.y - 400/2, 600, 400);
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.setVisible(true);
        
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
