/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 *
 * @author Y-Uyen
 */
public class PlayScreen extends javax.swing.JFrame {
    public Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
    public WordBank wb;
    public CheckWord cw;
    public char letter;
    public String wordToGuess;
    public String wordToGuessFormat;
    public String guessedString;
   
    
    /**
     * Creates new form PlayScreen
     */
    public PlayScreen() {
        wb = new WordBank();
        initComponents();
        currentTime();
        currentDate();
        displayWordFormat();
    }
    
    /**
     * This method gets the current date and forces it to be in the form of January, 17, 2017
    */
    
    public void currentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat ("MMMMMMMMMMM dd, yyyy");
        Calendar cal = new GregorianCalendar();
        Date today = new Date();
        String date = sdf.format(today);
        jLabel2.setText(date);
        
        
    }
    /**
     * This method updates the seconds, that way you can see the seconds change in the clock
     */

    /**
     * This Method loops indefinitely to update clock every 1000 milliseconds.
     */
     public void currentTime() {
        Thread clock = new Thread() {
            public void run() {
                for(;;) {
                    Calendar cal = new GregorianCalendar();
                    int second = cal.get(Calendar.SECOND);
                    int minute = cal.get(Calendar.MINUTE);
                    int hour = cal.get(Calendar.HOUR);
                    jLabel3.setText(hour + ":" + minute + ":" + second);
                    
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
     
    public void displayWordFormat() {
        wordToGuess = wb.getWord();
        wordToGuessFormat = wb.getWordFormat();
        cw = new CheckWord(wordToGuess, wordToGuessFormat);
        System.out.println("word: " + wordToGuess);
        System.out.println("hint: " + wordToGuessFormat);
        jLabel5.setText(wordToGuessFormat);
    }
    
    public void displayGuessedString() {
        System.out.println("guessed string: " + guessedString);
        jLabel6.setText(guessedString);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("A");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 50, -1));

        jButton2.setText("B");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 50, -1));

        jButton3.setText("C");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 50, -1));

        jButton4.setText("D");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 50, -1));

        jButton5.setText("E");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 50, -1));

        jButton6.setText("F");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 40, -1));

        jButton7.setText("G");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, -1, -1));

        jButton8.setText("H");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 50, -1));

        jButton9.setText("I");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 40, -1));

        jButton10.setText("J");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 50, -1));

        jButton11.setText("K");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 50, -1));

        jButton12.setText("L");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, 50, -1));

        jButton13.setText("M");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        jButton15.setText("N");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        jButton16.setText("O");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

        jButton17.setText("P");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, -1, -1));

        jButton18.setText("Q");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, -1, -1));

        jButton19.setText("R");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, -1, -1));

        jButton20.setText("S");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, -1, -1));

        jButton21.setText("T");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, -1, -1));

        jButton22.setText("U");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, -1, -1));

        jButton23.setText("V");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, -1, -1));

        jButton24.setText("W");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, -1, -1));

        jButton26.setText("X");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, -1, -1));

        jButton27.setText("Y");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, -1, -1));

        jButton28.setText("Z");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tekton Pro Ext", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Hangman");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel2.setText("Date");
        jPanel1.add(jLabel2);

        jLabel3.setText("Time");
        jPanel1.add(jLabel3);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 160, 20));

        jButton14.setText("Skip");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, -1, -1));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 70, 50));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel5.setText("word to guess");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * This method is for the skip button. When the player clicks "Skip", it will
     * take them to the Skip Screen where it will display their score as 0 because they
     * opted out of the game.
     */
    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        if(evt.getActionCommand().equals("Skip")) {
            SkipScreen sScreen = new SkipScreen();
            sScreen.setSize(600,400);
            sScreen.setBounds(center.x - 600/2, center.y - 400/2, 600, 400);
            sScreen.setVisible(true);
            dispose();
            
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(evt.getActionCommand().equals("A")) {
//            System.out.println("i clicked A");
//            ImageIcon icon = new ImageIcon("images/famous_fair.jpg"); 
//            icon.getImage().flush();
//            jLabel4.setIcon(icon);
//            jButton1.setEnabled(false);
            letter = 'a';
            jButton1.setEnabled(false);
            String check = cw.checkLetter(letter);
            guessedString = check;
            displayGuessedString();
        } else {
            System.out.println("nope");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(evt.getActionCommand().equals("B")) {
            letter = 'b';
            jButton2.setEnabled(false);
            String check = cw.checkLetter(letter);
            guessedString = check;
            displayGuessedString();
        } else {
            System.out.println("nope");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(evt.getActionCommand().equals("C")) {
            letter = 'c';
            jButton3.setEnabled(false);
            String check = cw.checkLetter(letter);
            guessedString = check;
            displayGuessedString();
        } else {
            System.out.println("nope");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(evt.getActionCommand().equals("D")) {
            letter = 'd';
            jButton4.setEnabled(false);
            String check = cw.checkLetter(letter);
            guessedString = check;
            displayGuessedString();
        } else {
            System.out.println("nope");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(evt.getActionCommand().equals("E")) {
            letter = 'e';
            jButton5.setEnabled(false);
            String check = cw.checkLetter(letter);
            guessedString = check;
            displayGuessedString();
        } else {
            System.out.println("nope");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
         if(evt.getActionCommand().equals("F")) {
            letter = 'f';
            jButton6.setEnabled(false);
            String check = cw.checkLetter(letter);
            guessedString = check;
            displayGuessedString();
        } else {
            System.out.println("nope");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if(evt.getActionCommand().equals("G")) {
            letter = 'g';
            jButton7.setEnabled(false);
            String check = cw.checkLetter(letter);
            guessedString = check;
            displayGuessedString();
        } else {
            System.out.println("nope");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if(evt.getActionCommand().equals("H")) {
            letter = 'h';
            jButton8.setEnabled(false);
            String check = cw.checkLetter(letter);
            guessedString = check;
            displayGuessedString();
        } else {
            System.out.println("nope");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if(evt.getActionCommand().equals("I")) {
            letter = 'i';
            jButton9.setEnabled(false);
            String check = cw.checkLetter(letter);
            guessedString = check;
            displayGuessedString();
        } else {
            System.out.println("nope");
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if(evt.getActionCommand().equals("J")) {
            letter = 'j';
            jButton10.setEnabled(false);
            String check = cw.checkLetter(letter);
            guessedString = check;
            displayGuessedString();
        } else {
            System.out.println("nope");
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if(evt.getActionCommand().equals("K")) {
            letter = 'k';
            jButton11.setEnabled(false);
            String check = cw.checkLetter(letter);
            guessedString = check;
            displayGuessedString();
        } else {
            System.out.println("nope");
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if(evt.getActionCommand().equals("L")) {
            letter = 'l';
            jButton12.setEnabled(false);
            String check = cw.checkLetter(letter);
            guessedString = check;
            displayGuessedString();
        } else {
            System.out.println("nope");
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if(evt.getActionCommand().equals("M")) {
            letter = 'm';
            jButton13.setEnabled(false);
            String check = cw.checkLetter(letter);
            guessedString = check;
            displayGuessedString();
        } else {
            System.out.println("nope");
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        if(evt.getActionCommand().equals("N")) {
            letter = 'n';
            jButton15.setEnabled(false);
            String check = cw.checkLetter(letter);
            guessedString = check;
            displayGuessedString();
        } else {
            System.out.println("nope");
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        if(evt.getActionCommand().equals("O")) {
            letter = 'o';
            jButton15.setEnabled(false);
            String check = cw.checkLetter(letter);
            guessedString = check;
            displayGuessedString();
        } else {
            System.out.println("nope");
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        if(evt.getActionCommand().equals("P")) {
            letter = 'p';
            jButton17.setEnabled(false);
            String check = cw.checkLetter(letter);
            guessedString = check;
            displayGuessedString();
        } else {
            System.out.println("nope");
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        if(evt.getActionCommand().equals("Q")) {
            letter = 'q';
            jButton18.setEnabled(false);
            String check = cw.checkLetter(letter);
            guessedString = check;
            displayGuessedString();
        } else {
            System.out.println("nope");
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        if(evt.getActionCommand().equals("R")) {
            letter = 'r';
            jButton19.setEnabled(false);
            String check = cw.checkLetter(letter);
            guessedString = check;
            displayGuessedString();
        } else {
            System.out.println("nope");
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        if(evt.getActionCommand().equals("S")) {
            letter = 's';
            jButton20.setEnabled(false);
            String check = cw.checkLetter(letter);
            guessedString = check;
            displayGuessedString();
        } else {
            System.out.println("nope");
        }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        if(evt.getActionCommand().equals("T")) {
            letter = 't';
            jButton20.setEnabled(false);
            String check = cw.checkLetter(letter);
            guessedString = check;
            displayGuessedString();
        } else {
            System.out.println("nope");
        }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        if(evt.getActionCommand().equals("U")) {
            letter = 'u';
            jButton22.setEnabled(false);
            String check = cw.checkLetter(letter);
            guessedString = check;
            displayGuessedString();
        } else {
            System.out.println("nope");
        }
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        if(evt.getActionCommand().equals("V")) {
            letter = 'v';
            jButton23.setEnabled(false);
            String check = cw.checkLetter(letter);
            guessedString = check;
            displayGuessedString();
        } else {
            System.out.println("nope");
        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        if(evt.getActionCommand().equals("W")) {
            letter = 'w';
            jButton24.setEnabled(false);
            String check = cw.checkLetter(letter);
            guessedString = check;
            displayGuessedString();
        } else {
            System.out.println("nope");
        }
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        if(evt.getActionCommand().equals("X")) {
            letter = 'x';
            jButton24.setEnabled(false);
            String check = cw.checkLetter(letter);
            guessedString = check;
            displayGuessedString();
        } else {
            System.out.println("nope");
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        if(evt.getActionCommand().equals("Y")) {
            letter = 'y';
            jButton27.setEnabled(false);
            String check = cw.checkLetter(letter);
            guessedString = check;
            displayGuessedString();
        } else {
            System.out.println("nope");
        }
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        if(evt.getActionCommand().equals("Z")) {
            letter = 'z';
            jButton28.setEnabled(false);
            String check = cw.checkLetter(letter);
            guessedString = check;
            displayGuessedString();
        } else {
            System.out.println("nope");
        }
    }//GEN-LAST:event_jButton28ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlayScreen().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
