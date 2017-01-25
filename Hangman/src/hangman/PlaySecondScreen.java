/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import static java.lang.Thread.sleep;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author hh
 */
public class PlaySecondScreen extends javax.swing.JFrame {
    public Point center;
    private int rounds = 100;
    private int totalScore;
    private final Color PURPLE = new Color(150, 0, 255);
    private int[][] coordinates;
    private int gemCount = 5;
    private JButton[] gems;
    /**
     * Creates new form PlaySecondScreen
     */
    public PlaySecondScreen(int firstScore) {
        center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        totalScore = firstScore;
       
        initComponents();
        previousResult.setText("Round 1 | Previous Result: ");
        randomizeHintName();
        randomizeHintColor();
        setGemColor();
        currentTime();
        currentDate();
    }
    
    public void setGemColor() {
        gem1.setForeground(Color.BLUE);
        gem2.setForeground(Color.GREEN);
        gem3.setForeground(PURPLE);
        gem4.setForeground(Color.RED);
        gem5.setForeground(Color.YELLOW);
    }
    
    public int randomX() {
        int max = 500;
        int min = 0;
        Random rand = new Random();
        int x = rand.nextInt((max - min) + 1) + min;
        System.out.print("x: " + x);
        return x;
    }
    
    public int randomY() {
        int max = 300;
        int min = 100;
        Random rand = new Random();
        int y = rand.nextInt((max - min) + 1) + min;
        System.out.print("y: " + y);
        return y;
    }
    
    public void randomizeGems() {
        int g1x = randomX();
        int g1y = randomY();
        System.out.println();
        
        int g2x = randomX();
        int g2y = randomY();
        System.out.println();
        
        int g3x = randomX();
        int g3y = randomY();
        System.out.println();
        
        int g4x = randomX();
        int g4y = randomY();
        System.out.println();
        
        int g5x = randomX();
        int g5y = randomY();
        System.out.println();
        
        this.add(gem1);
        this.add(gem2);
        this.add(gem3);
        this.add(gem4);
        this.add(gem5);
       
        gem1.setLocation(g1x, g1y);
        gem2.setLocation(g2x, g2y);
        gem3.setLocation(g3x, g3y);
        gem4.setLocation(g4x, g4y);
        gem5.setLocation(g5x, g5y);
        
    }
    
    
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
    
    public void currentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat ("MMMMMMMMMMM dd, yyyy");
        Calendar cal = new GregorianCalendar();
        Date today = new Date();
        String strDate = sdf.format(today);
        date.setText(strDate);
    }    
    
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(gem2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
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
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 151, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
        );

        hint.setFont(new java.awt.Font("Courier 10 Pitch", 1, 48)); // NOI18N
        hint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hint.setText("ct");
        hint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        previousResult.setText("Round 1 | Previous Result: ");

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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(hint)
                        .addGap(208, 208, 208)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(previousResult)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(hint)
                        .addGap(26, 26, 26)
                        .addComponent(previousResult)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
            randomizeHintColor();
            randomizeHintName();
            randomizeGems();
            
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
