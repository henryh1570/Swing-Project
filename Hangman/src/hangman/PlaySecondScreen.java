/***************************************************************
* file: PLayScreen.java
* author: Luis Cortes, Oscar Hernandez, Henry Hu, Y-Uyen La, and An Le 
* class: CS 245 - Programming Graphical User Interfaces
*
* assignment: Swing Project v1.0
* date last modified: 1/18/2017
*
* purpose: This program is a game of Hangman where users are allowed up to 6 tries
* to guess the word correctly.A new point and click game is started after the 
* hangman game ends and the total score for both games gives you a total score
* which may or may not be considered in the high scores menu.
*
****************************************************************/ 
package hangman;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import static java.lang.Thread.sleep;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JButton;
import javax.swing.JOptionPane;

//class: PlaySecondScreen
//purpose of class: This class creates the second game screen we play after
//the hangman game is skipped or has ended. It takes care of all the logic 
//of the game.
public class PlaySecondScreen extends javax.swing.JFrame {
    public Point center;
    private int rounds = 5;
    private int totalScore;
    private final Color PURPLE = new Color(150, 0, 255);
    private int gemCount = 5;
    private JButton[] gems = new JButton[5];
    private int gemHeight;
    private int gemWidth;
    
    //constructor: PlaySecondScreen
    //purpose: This is the constructor and it initializes the objects and instance variables.
    // It also calls currentTIme() and currentDate() which are needed to set the date and time in the frame.
    // It uses "center" to always display the game window in the center of the screen. 
    public PlaySecondScreen(int firstScore) {
        center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        totalScore = firstScore;       
        initComponents();
        gemHeight = gem1.getHeight();
        gemWidth = gem1.getWidth();
        gems[0] = gem1;
        gems[1] = gem2;
        gems[2] = gem3;
        gems[3] = gem4;
        gems[4] = gem5;
        previousResult.setText("Round 1 | Previous Result: ");
        randomizeAll();
        setGemColor();
        currentTime();
        currentDate();        
    }
    
    //method: setGemColor
    //purpose: Used to link 
    private void setGemColor() {
        gem1.setForeground(Color.BLUE);
        gem2.setForeground(Color.GREEN);
        gem3.setForeground(PURPLE);
        gem4.setForeground(Color.RED);
        gem5.setForeground(Color.YELLOW);
    }

    //method: setRandomBounds
    // purpose: Sets the bounds of the button inside a rectangle region inside jPanel5
    // we chose 470 width to make sure they don't spawn and cut off the window
    // we chose 70 height to make sure they don't cut off
    private void setRandomBounds(JButton gem) {
        Random random = new Random();
        do {
            int x2 = ThreadLocalRandom.current().nextInt() % 470;
            int y2 = ThreadLocalRandom.current().nextInt() % 70;      
            gem.setBounds(gem.getWidth() + x2, gem.getHeight() + y2, gem.getWidth(), gem.getHeight());
        } while (!gem.getBounds().intersects(new Rectangle(100,100,350,150)));
        jPanel5.add(gem);
    } 
    
    //method: intersectsOtherGems
    //purpose: Given one gem, check if its bounds touch any other gem
    private boolean intersectsOtherGems(JButton gem) {
        Rectangle bounds = gem.getBounds();
        
        for (JButton other : gems) {
            if (!other.equals(gem)) {
                if (bounds.intersects(other.getBounds())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    //method: randomizeAll
    //purpose: Randomizes everything every new round. Changes the hint's text and color.
    //Randomly places the buttons inside the jPanel5 region and don't touch other ones.
    private void randomizeAll() {
            randomizeHintColor();
            randomizeHintName();
            
            // Makes all buttons randomly placed, doesn't check for intersects yet
            for (JButton gem : gems) {
                setRandomBounds(gem);
            }
            
            // For every button, check if it touches the other ones
            // If it does, then keep randomly sticking it into a random place inside jPanel5
            for (JButton gem : gems) {
                while(intersectsOtherGems(gem) == true) {
                    setRandomBounds(gem);
                }
            }          
    }
    
    //method: randomizeHintColor
    //purpose: Randomizes the hint's actual color font.
    private void randomizeHintColor() {
        int num = ThreadLocalRandom.current().nextInt() % 5;
        switch (num) {
            case 0: hint.setForeground(Color.YELLOW);
            break;
            case 1: hint.setForeground(Color.RED);
            break;
            case 2: hint.setForeground(PURPLE);
            break;
            case 3: hint.setForeground(Color.CYAN);
            break;
            default: hint.setForeground(Color.GREEN);
            break;
        }
    }
    
    //method: randomizeHintName
    //purpose: Changes hint to be one of the following strings.
    private void randomizeHintName() {
        int num = ThreadLocalRandom.current().nextInt() % 5;
        switch (num) {
            case 0: hint.setText("GREEN");
            break;
            case 1: hint.setText("RED");
            break;
            case 2: hint.setText("BLUE");
            break;
            case 3: hint.setText("PURPLE");
            break;
            default: hint.setText("YELLOW");
            break;
        }
    }
    
    //method: currentDate
    //purpose: This method returns the current date in the Month, dd, year format.
    public void currentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat ("MMMMMMMMMMM dd, yyyy");
        Calendar cal = new GregorianCalendar();
        Date today = new Date();
        String strDate = sdf.format(today);
        date.setText(strDate);
    }    
    
    //method: currentTime
    //purpose: This method updates the second in the clock by having the thread resume after being
    //put to sleep for 1 second so that it can update the seconds.
    public void currentTime() {
        Thread clock = new Thread() {
            public void run() {
                for(;;) {
                    Calendar cal = new GregorianCalendar();
                    int second = cal.get(Calendar.SECOND);
                    int minute = cal.get(Calendar.MINUTE);
                    int hour = cal.get(Calendar.HOUR);
                    time.setText(hour + ":" + minute + ":" + second);
                    
                    try{
                        sleep(1000);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            }
        };
        clock.start();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */// TODO add your handling code here:
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        gem1 = new javax.swing.JButton();
        gem2 = new javax.swing.JButton();
        gem3 = new javax.swing.JButton();
        gem4 = new javax.swing.JButton();
        gem5 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        hint = new javax.swing.JLabel();
        previousResult = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Color Game");
        setPreferredSize(new java.awt.Dimension(600, 400));
        setSize(new java.awt.Dimension(600, 400));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 400));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        gem1.setBackground(new java.awt.Color(255, 255, 255));
        gem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/blue_gem.jpg"))); // NOI18N
        gem1.setBorder(null);
        gem1.setBorderPainted(false);
        gem1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/highlighted_gem.jpg"))); // NOI18N
        gem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gem1ActionPerformed(evt);
            }
        });

        gem2.setBackground(new java.awt.Color(255, 255, 255));
        gem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/green_gem.jpg"))); // NOI18N
        gem2.setBorder(null);
        gem2.setBorderPainted(false);
        gem2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/highlighted_gem.jpg"))); // NOI18N
        gem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gem2ActionPerformed(evt);
            }
        });

        gem3.setBackground(new java.awt.Color(255, 255, 255));
        gem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/purple_gem.jpg"))); // NOI18N
        gem3.setBorder(null);
        gem3.setBorderPainted(false);
        gem3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/highlighted_gem.jpg"))); // NOI18N
        gem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gem3ActionPerformed(evt);
            }
        });

        gem4.setBackground(new java.awt.Color(255, 255, 255));
        gem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/red_gem.jpg"))); // NOI18N
        gem4.setBorder(null);
        gem4.setBorderPainted(false);
        gem4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/highlighted_gem.jpg"))); // NOI18N
        gem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gem4ActionPerformed(evt);
            }
        });

        gem5.setBackground(new java.awt.Color(255, 255, 255));
        gem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/yellow_gem.jpg"))); // NOI18N
        gem5.setBorder(null);
        gem5.setBorderPainted(false);
        gem5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/highlighted_gem.jpg"))); // NOI18N
        gem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gem5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gem1)
                .addGap(81, 81, 81)
                .addComponent(gem3)
                .addGap(79, 79, 79)
                .addComponent(gem5)
                .addContainerGap(104, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(gem2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(gem4)
                .addGap(149, 149, 149))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(gem5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addComponent(gem4))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gem1)
                            .addComponent(gem3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(gem2)))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        date.setText("Date");
        jPanel2.add(date);

        time.setText("Time");
        jPanel2.add(time);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        hint.setFont(new java.awt.Font("Courier 10 Pitch", 1, 48)); // NOI18N
        hint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hint.setText("ct");
        hint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        previousResult.setText("Round 1 | Previous Result: ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(hint)
                .addContainerGap(83, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(previousResult)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(hint)
                .addGap(0, 33, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addComponent(previousResult)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(167, 167, 167))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //method: generalButtionAction
    //purpose: checks if the gem clicked is the correct color of the text. Gives 
    //user 5 rounds to play and displays a message if they clicked the correct
    //gem or incorrect gem. Also updates the users score
    private void generalButtonAction(Color color) {
        
        rounds--;
        
        if (hint.getForeground().equals(color)) {
            previousResult.setText("Round " + (6 - rounds) + " | Previous Result: Correct!");
            totalScore += 100;
        } else {
            previousResult.setText("Round " + (6 - rounds) + " | Previous Result: Incorrect!");
        }
        
        if (rounds == 0) {
            SkipScreen sScreen = new SkipScreen(totalScore);
            sScreen.setScore(Integer.toString(totalScore));
            sScreen.setVisible(true);
            sScreen.setBounds(center.x - 600/2, center.y - 400/2, 600, 400);            
            dispose();
        } else {
            randomizeAll();     
        }
    }
    
    private void gem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gem1ActionPerformed
        generalButtonAction(gem1.getForeground());
    }//GEN-LAST:event_gem1ActionPerformed

    private void gem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gem2ActionPerformed
        generalButtonAction(gem2.getForeground());
    }//GEN-LAST:event_gem2ActionPerformed

    private void gem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gem3ActionPerformed
        generalButtonAction(gem3.getForeground());
    }//GEN-LAST:event_gem3ActionPerformed

    private void gem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gem4ActionPerformed
        generalButtonAction(gem4.getForeground());
    }//GEN-LAST:event_gem4ActionPerformed

    private void gem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gem5ActionPerformed
        generalButtonAction(gem5.getForeground());
    }//GEN-LAST:event_gem5ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlaySecondScreen(50).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel date;
    private javax.swing.JButton gem1;
    private javax.swing.JButton gem2;
    private javax.swing.JButton gem3;
    private javax.swing.JButton gem4;
    private javax.swing.JButton gem5;
    private javax.swing.JLabel hint;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel previousResult;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables
}
