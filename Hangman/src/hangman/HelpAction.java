/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public HelpAction(Point p) {
        center = p;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        HelpDisplay helpD = new HelpDisplay();
        helpD.setVisible(true);
        helpD.setBounds(center.x - 600/2, center.y - 400/2, 600, 400);
        helpD.setSize(600, 400);
    }
    
}
