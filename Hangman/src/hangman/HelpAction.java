/***************************************************************
* file: HelpAction.java
* author: Luis Cortes, Oscar Hernandez, Henry Hu, Y-Uyen La, and An Le 
* class: CS 245 - Programming Graphical User Interfaces
*
* assignment: Swing Project v1.3
* date last modified: 2/5/2017
*
* purpose: This class extends the abstractaction class by opening a Help Display
* frame when F1 is pressed.
*
****************************************************************/ 
package hangman;

import java.awt.Point;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author hh
 */
public class HelpAction extends AbstractAction {

    private Point center;
    
    //method: constructor
    public HelpAction(Point p) {
        center = p;
    }
    
    //method: actionperformed
    //purpose: creates a Help Display frame when pressing F1 and displays it.
    @Override
    public void actionPerformed(ActionEvent ae) {
        HelpDisplay helpD = new HelpDisplay();
        helpD.setVisible(true);
        helpD.setBounds(center.x - 600/2, center.y - 400/2, 600, 400);
        helpD.setSize(600, 400);
    }
    
}
