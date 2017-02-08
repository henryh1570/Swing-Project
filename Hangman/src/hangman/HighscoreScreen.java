/***************************************************************
* file: HighscoreScreen.java
* author: Luis Cortes, Oscar Hernandez, Henry Hu, Y-Uyen La, and An Le 
* class: CS 245 - Programming Graphical User Interfaces
*
* assignment: Swing Project v1.0
* date last modified: 2/5/2017
*
* purpose: This class displays all the saved high scores from the game.
*
****************************************************************/ 
package hangman;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

//class: HighscoreScreen
//purpose: Currently, this page only displays the default values.
public class HighscoreScreen extends javax.swing.JFrame {
    public Point center;
    private Score[] rawScores;
    
    //constructor: HighscoreScreen
    //purpose: Initializes the JFrame along with center.
    public HighscoreScreen() {
        center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        initComponents();
        loadScores();
        jPanel2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"), "Help");
        jPanel2.getActionMap().put("Help", new HelpAction(center));
        jPanel2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Close");
        jPanel2.getActionMap().put("Close", new CloseAction(this));
    }
    
    //method: loadScores
    //purpose: dynamically load the previous high scores to view.
    public void loadScores() {
        ScoreSerializer sS = new ScoreSerializer();
        
        rawScores = sS.loadScores("scores");
            
        if (rawScores == null) {
            System.out.println("Initialize Scores");
            rawScores = new Score[5];
            for(int i = 0; i < rawScores.length; i++) {
                rawScores[i] = new Score("AAA", 0);
            }
        }
        
        score1.setText(rawScores[0].getName() + "..." + rawScores[0].getScore());
        score2.setText(rawScores[1].getName() + "..." + rawScores[1].getScore());
        score3.setText(rawScores[2].getName() + "..." + rawScores[2].getScore());
        score4.setText(rawScores[3].getName() + "..." + rawScores[3].getScore());
        score5.setText(rawScores[4].getName() + "..." + rawScores[4].getScore());
    }
    
    //method: eraseScores
    //purpose: delete all highscores to reset it.
    public void eraseScores() {
        ScoreSerializer sS = new ScoreSerializer();

        System.out.println("Initialize Scores");
        rawScores = new Score[5];
        for(int i = 0; i < rawScores.length; i++) {
            rawScores[i] = new Score("AAA", 0);
        }
        sS.saveScores("scores", rawScores);
        
        score1.setText(rawScores[0].getName() + "..." + rawScores[0].getScore());
        score2.setText(rawScores[1].getName() + "..." + rawScores[1].getScore());
        score3.setText(rawScores[2].getName() + "..." + rawScores[2].getScore());
        score4.setText(rawScores[3].getName() + "..." + rawScores[3].getScore());
        score5.setText(rawScores[4].getName() + "..." + rawScores[4].getScore());       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        eraseButton = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Highscores");
        setBounds(new java.awt.Rectangle(0, 0, 600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));
        setSize(new java.awt.Dimension(600, 40));

        jButton1.setText("Back");
        jButton1.setToolTipText("Back to Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        title.setForeground(new java.awt.Color(0, 153, 102));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("HIGHSCORES");
        title.setToolTipText("All time high");
        title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        score1.setFont(new java.awt.Font("DejaVu Serif", 1, 24));
        score1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        score1.setText("ABC...00000");
        score1.setToolTipText("Is this you?");
        score1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        score2.setFont(new java.awt.Font("DejaVu Serif", 1, 24));
        score2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        score2.setText("ABC...00000");
        score2.setToolTipText("Is this you?");
        score2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        score3.setFont(new java.awt.Font("DejaVu Serif", 1, 24));
        score3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        score3.setText("ABC...00000");
        score3.setToolTipText("Is this you?");
        score3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        score4.setFont(new java.awt.Font("DejaVu Serif", 1, 24));
        score4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        score4.setText("ABC...00000");
        score4.setToolTipText("Is this you?");
        score4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        score5.setFont(new java.awt.Font("DejaVu Serif", 1, 24));
        score5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        score5.setText("ABC...00000");
        score5.setToolTipText("Is this you?");
        score5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(score5, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(score2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(score1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(score3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(score4, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(score1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(score2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(score3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(score4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(score5)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        eraseButton.setText("Erase");
        eraseButton.setToolTipText("Reset scores");
        eraseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eraseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eraseButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 61, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(eraseButton))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //method: jButton1ActionPerformed
    //purpose: This creates the event for the "Back" button. Once the button is clicked, it takes the user back one page.
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(evt.getActionCommand().equals("Back")) {
            MenuScreen mScreen = new MenuScreen();
            mScreen.setVisible(true);
            mScreen.setBounds(center.x - 600/2, center.y - 400/2, 600, 400);
            mScreen.setSize(600, 400);
            dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void eraseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eraseButtonActionPerformed
        eraseScores();
    }//GEN-LAST:event_eraseButtonActionPerformed

    //method: Main method
    //purpose: To run the HighscoreScreen class' JFrame form.
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HighscoreScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton eraseButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private final javax.swing.JLabel score1 = new javax.swing.JLabel();
    private final javax.swing.JLabel score2 = new javax.swing.JLabel();
    private final javax.swing.JLabel score3 = new javax.swing.JLabel();
    private final javax.swing.JLabel score4 = new javax.swing.JLabel();
    private final javax.swing.JLabel score5 = new javax.swing.JLabel();
    private final javax.swing.JLabel title = new javax.swing.JLabel();
    // End of variables declaration//GEN-END:variables
}
