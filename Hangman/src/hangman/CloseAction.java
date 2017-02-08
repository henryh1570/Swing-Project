/***************************************************************
* file: CloseAction.java
* author: Luis Cortes, Oscar Hernandez, Henry Hu, Y-Uyen La, and An Le 
* class: CS 245 - Programming Graphical User Interfaces
*
* assignment: Swing Project v1.3
* date last modified: 2/5/2017
*
* purpose: This class extends the abstractaction class by closing its
* corresponding frame.
*
****************************************************************/ 
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
    
    //method: constructor
    public CloseAction(JFrame frame) {
        currentFrame = frame;
    }
    
    //method: actionPerformed
    //purpose: Closes Help display or terminates the program.
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
