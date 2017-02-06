/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author hh
 */
public class CloseAction extends AbstractAction {

    private JFrame currentFrame;
    
    public CloseAction(JFrame frame) {
        currentFrame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        currentFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Disposes help displays. Otherwise terminate the program.
        if (currentFrame.getClass().getCanonicalName().equals("hangman.HelpDisplay")) {
            currentFrame.dispose();
        } else {
            currentFrame.dispatchEvent(new WindowEvent(currentFrame, WindowEvent.WINDOW_CLOSING));
        }
    }    
}
