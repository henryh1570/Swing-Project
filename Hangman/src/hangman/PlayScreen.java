/***************************************************************
* file: PLayScreen.java
* author: Luis Cortes, Oscar Hernandez, Henry Hu, Y-Uyen La, and An Le 
* class: CS 245 - Programming Graphical User Interfaces
*
* assignment: Swing Project v1.0
* date last modified: 1/18/2017
*
* purpose: This program is a game of Hangman where users are allowed up to 6 tries
* to guess the word correctly. 
*
****************************************************************/ 
package hangman;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


//class: PlayScreen
//purpose of class: This class is the class that takes care of all the interactions
//in the game. It uses the WordBank class in order to get the word and the CheckWord
//class in order to check if the user guesses correctly.
public class PlayScreen extends javax.swing.JFrame {
    public Point center;
    public WordBank wb;
    public CheckWord cw;
    public char letter;
    public String wordToGuess;
    public String wordToGuessFormat;
    public String guessedString;
    private int numWrong = 0;
    private final int maxWrong = 6;
    private String score;
    public boolean guess;
   
    
    // constructor: PlayScreen
    // purpose: This is the constructor and it initializes the objects and instance variables.
    // It also calls currentTIme() and currentDate() which are needed to set the date and time in the frame.
    // It uses "center" to always display the game window in the center of the screen.
    public PlayScreen() {
        center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        wb = new WordBank();
        score="100";
        initComponents();
        currentTime();
        currentDate();
        displayWordFormat();
    }
    
   
    //method: currentDate
    //purpose: This method returns the current date in the Month, dd, year format.
    public void currentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat ("MMMMMMMMMMM dd, yyyy");
        Calendar cal = new GregorianCalendar();
        Date today = new Date();
        String date = sdf.format(today);
        jLabel2.setText(date);
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
     
    //method: displayWordFormat
    //purpose: This method gets the hint, or the "_ _ _" for each word and displays it to the screen.
    public void displayWordFormat() {
        wordToGuess = wb.getWord();
        wordToGuessFormat = wb.getWordFormat();
        cw = new CheckWord(wordToGuess, wordToGuessFormat);
        jLabel5.setText(wordToGuessFormat);
    }
    
    
    //method: displayGuessedString
    //purpose: This method displays correctly guessed letter for each "_".
    //It also verifies whether or not the guess is correct and updates the score
    //as well as changes the text from "Incorrect!" to "Correct!"
    public void displayGuessedString() {
        PlaySecondScreen pSS;
        numWrong = cw.numWrongGuesses;
        int numGuesses = cw.numGuesses;
        jLabel6.setText(guessedString);
        if (numWrong > 0 && !guess) {
            if(numWrong <= maxWrong) {
                switch (numWrong) {
                    case 1:
                        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/DrawingNo1.png"))); // NOI18N
                        score = "90";
                        break;
                    case 2:
                        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/DrawingNo2.png"))); // NOI18N
                        score = "80";
                        break;
                    case 3:
                        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/DrawingNo2.5.png"))); // NOI18N
                        score = "70";
                        break;
                    case 4:
                        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/DrawingNo3.png"))); // NOI18N
                        score = "60";
                        break;
                    case 5:
                        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/DrawingNo4.png"))); // NOI18N
                        score = "50";
                        break;
                    case 6:
                        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/DrawingNo5.png"))); // NOI18N
                        score = "40";
                        pSS = new PlaySecondScreen(40);
                        pSS.setVisible(true);
                        pSS.setBounds(center.x - 600/2, center.y - 400/2, 600, 400);
                        dispose();
                        break;
                }
                jLabel7.setText(score);
                wrongLabel.setText("Incorrect!");
            } 
        } else if (guess) {
            wrongLabel.setText("Correct!");
            boolean win = cw.checkGuesses();
            if(cw.checkGuesses()) {
                pSS = new PlaySecondScreen(Integer.parseInt(score));
                pSS.setVisible(true);
                pSS.setBounds(center.x - 600/2, center.y - 400/2, 600, 400);
                dispose();
            } 
        } 
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        buttonA = new javax.swing.JButton();
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
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        wrongLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tekton Pro Ext", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Hangman");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 20, -1, -1));

        jButton14.setText("Skip");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hangman/Drawing.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 200, 170));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel5.setText("word to guess");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, -1, -1));
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, -1, -1));

        buttonA.setText("A");
        buttonA.setPreferredSize(new java.awt.Dimension(45, 29));
        buttonA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAActionPerformed(evt);
            }
        });
        jPanel3.add(buttonA);

        jButton2.setText("B");
        jButton2.setPreferredSize(new java.awt.Dimension(45, 29));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);

        jButton3.setText("C");
        jButton3.setPreferredSize(new java.awt.Dimension(45, 29));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);

        jButton4.setText("D");
        jButton4.setPreferredSize(new java.awt.Dimension(45, 29));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);

        jButton5.setText("E");
        jButton5.setPreferredSize(new java.awt.Dimension(45, 29));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5);

        jButton6.setText("F");
        jButton6.setPreferredSize(new java.awt.Dimension(45, 29));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6);

        jButton7.setText("G");
        jButton7.setPreferredSize(new java.awt.Dimension(45, 29));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7);

        jButton8.setText("H");
        jButton8.setPreferredSize(new java.awt.Dimension(45, 29));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton8);

        jButton9.setText("I");
        jButton9.setPreferredSize(new java.awt.Dimension(45, 29));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton9);

        jButton10.setText("J");
        jButton10.setPreferredSize(new java.awt.Dimension(45, 29));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10);

        jButton11.setText("K");
        jButton11.setPreferredSize(new java.awt.Dimension(45, 29));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton11);

        jButton12.setText("L");
        jButton12.setPreferredSize(new java.awt.Dimension(45, 29));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton12);

        jButton13.setText("M");
        jButton13.setPreferredSize(new java.awt.Dimension(45, 29));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton13);

        jButton15.setText("N");
        jButton15.setPreferredSize(new java.awt.Dimension(45, 29));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton15);

        jButton16.setText("O");
        jButton16.setPreferredSize(new java.awt.Dimension(45, 29));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton16);

        jButton17.setText("P");
        jButton17.setPreferredSize(new java.awt.Dimension(45, 29));
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton17);

        jButton18.setText("Q");
        jButton18.setPreferredSize(new java.awt.Dimension(45, 29));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton18);

        jButton19.setText("R");
        jButton19.setPreferredSize(new java.awt.Dimension(45, 29));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton19);

        jButton20.setText("S");
        jButton20.setPreferredSize(new java.awt.Dimension(45, 29));
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton20);

        jButton21.setText("T");
        jButton21.setPreferredSize(new java.awt.Dimension(45, 29));
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton21);

        jButton22.setText("U");
        jButton22.setPreferredSize(new java.awt.Dimension(45, 29));
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton22);

        jButton23.setText("V");
        jButton23.setPreferredSize(new java.awt.Dimension(45, 29));
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton23);

        jButton24.setText("W");
        jButton24.setPreferredSize(new java.awt.Dimension(45, 29));
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton24);

        jButton26.setText("X");
        jButton26.setPreferredSize(new java.awt.Dimension(45, 29));
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton26);

        jButton27.setText("Y");
        jButton27.setPreferredSize(new java.awt.Dimension(45, 29));
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton27);

        jButton28.setText("Z");
        jButton28.setPreferredSize(new java.awt.Dimension(45, 29));
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton28);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 540, 110));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel2.setText("Date");
        jPanel1.add(jLabel2);

        jLabel3.setText("Time");
        jPanel1.add(jLabel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 210, 40));

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel7.setText("100");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 60, 50));

        wrongLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        wrongLabel.setForeground(new java.awt.Color(255, 0, 0));
        wrongLabel.setText("   ");
        getContentPane().add(wrongLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 140, 40));

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 255, 0));
        jLabel9.setText("Score:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 70, 50));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //method: jButton14ActionPerformed
    //purpose: This method is for the skip button. When the player clicks "Skip", it will
    //take them to the Skip Screen where it will display their score as 0 because they
    //opted out of the game.
    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        if(evt.getActionCommand().equals("Skip")) {
            PlaySecondScreen pSS = new PlaySecondScreen(0);
            pSS.setSize(600,400);
            pSS.setBounds(center.x - 600/2, center.y - 400/2, 600, 400);
            pSS.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jButton14ActionPerformed
    /***********************************************
     * The rest of these methods are for the event. Once a user clicks on a letter,
     * the letter gets sent to the CheckWord class where it gets checked to see if the letter
     * is contained in the word.
     * @param evt 
     ************************************************/
    private void buttonAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAActionPerformed
        if(evt.getActionCommand().equals("A")) {
            letter = 'a';
            buttonA.setEnabled(false);
            guess = cw.checkLetter(letter);
            guessedString = cw.correctlyGuessedFormat;
            displayGuessedString();
        } 
    }//GEN-LAST:event_buttonAActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(evt.getActionCommand().equals("B")) {
            letter = 'b';
            jButton2.setEnabled(false);
            guess = cw.checkLetter(letter);
            guessedString = cw.correctlyGuessedFormat;
            displayGuessedString();
        } 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(evt.getActionCommand().equals("C")) {
            letter = 'c';
            jButton3.setEnabled(false);
            guess = cw.checkLetter(letter);
            guessedString = cw.correctlyGuessedFormat;
            displayGuessedString();
        } 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(evt.getActionCommand().equals("D")) {
            letter = 'd';
            jButton4.setEnabled(false);
            guess = cw.checkLetter(letter);
            guessedString = cw.correctlyGuessedFormat;
            displayGuessedString();
        } 
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(evt.getActionCommand().equals("E")) {
            letter = 'e';
            jButton5.setEnabled(false);
            guess = cw.checkLetter(letter);
            guessedString = cw.correctlyGuessedFormat;
            displayGuessedString();
        } 
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
         if(evt.getActionCommand().equals("F")) {
            letter = 'f';
            jButton6.setEnabled(false);
            guess = cw.checkLetter(letter);
            guessedString = cw.correctlyGuessedFormat;
            displayGuessedString();
        } 
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if(evt.getActionCommand().equals("G")) {
            letter = 'g';
            jButton7.setEnabled(false);
            guess = cw.checkLetter(letter);
            guessedString = cw.correctlyGuessedFormat;
            displayGuessedString();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if(evt.getActionCommand().equals("H")) {
            letter = 'h';
            jButton8.setEnabled(false);
            guess = cw.checkLetter(letter);
            guessedString = cw.correctlyGuessedFormat;
            displayGuessedString();
        } 
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if(evt.getActionCommand().equals("I")) {
            letter = 'i';
            jButton9.setEnabled(false);
            guess = cw.checkLetter(letter);
            guessedString = cw.correctlyGuessedFormat;
            displayGuessedString();
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if(evt.getActionCommand().equals("J")) {
            letter = 'j';
            jButton10.setEnabled(false);
            guess = cw.checkLetter(letter);
            guessedString = cw.correctlyGuessedFormat;
            displayGuessedString();
        } 
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if(evt.getActionCommand().equals("K")) {
            letter = 'k';
            jButton11.setEnabled(false);
            guess = cw.checkLetter(letter);
            guessedString = cw.correctlyGuessedFormat;
            displayGuessedString();
        } 
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if(evt.getActionCommand().equals("L")) {
            letter = 'l';
            jButton12.setEnabled(false);
            guess = cw.checkLetter(letter);
            guessedString = cw.correctlyGuessedFormat;
            displayGuessedString();
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if(evt.getActionCommand().equals("M")) {
            letter = 'm';
            jButton13.setEnabled(false);
            guess = cw.checkLetter(letter);
            guessedString = cw.correctlyGuessedFormat;
            displayGuessedString();
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        if(evt.getActionCommand().equals("N")) {
            letter = 'n';
            jButton15.setEnabled(false);
            guess = cw.checkLetter(letter);
            guessedString = cw.correctlyGuessedFormat;
            displayGuessedString();
        } 
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        if(evt.getActionCommand().equals("O")) {
            letter = 'o';
            jButton16.setEnabled(false);
            guess = cw.checkLetter(letter);
            guessedString = cw.correctlyGuessedFormat;
            displayGuessedString();
        } 
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        if(evt.getActionCommand().equals("P")) {
            letter = 'p';
            jButton17.setEnabled(false);
            guess = cw.checkLetter(letter);
            guessedString = cw.correctlyGuessedFormat;
            displayGuessedString();
        } 
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        if(evt.getActionCommand().equals("Q")) {
            letter = 'q';
            jButton18.setEnabled(false);
            guess = cw.checkLetter(letter);
            guessedString = cw.correctlyGuessedFormat;
            displayGuessedString();
        } 
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        if(evt.getActionCommand().equals("R")) {
            letter = 'r';
            jButton19.setEnabled(false);
            guess = cw.checkLetter(letter);
            guessedString = cw.correctlyGuessedFormat;
            displayGuessedString();
        } 
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        if(evt.getActionCommand().equals("S")) {
            letter = 's';
            jButton20.setEnabled(false);
            guess = cw.checkLetter(letter);
            guessedString = cw.correctlyGuessedFormat;
            displayGuessedString();
        } 
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        if(evt.getActionCommand().equals("T")) {
            letter = 't';
            jButton21.setEnabled(false);
            guess = cw.checkLetter(letter);
            guessedString = cw.correctlyGuessedFormat;
            displayGuessedString();
        } 
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        if(evt.getActionCommand().equals("U")) {
            letter = 'u';
            jButton22.setEnabled(false);
            guess = cw.checkLetter(letter);
            guessedString = cw.correctlyGuessedFormat;
            displayGuessedString();
        } 
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        if(evt.getActionCommand().equals("V")) {
            letter = 'v';
            jButton23.setEnabled(false);
            guess = cw.checkLetter(letter);
            guessedString = cw.correctlyGuessedFormat;
            displayGuessedString();
        } 
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        if(evt.getActionCommand().equals("W")) {
            letter = 'w';
            jButton24.setEnabled(false);
            guess = cw.checkLetter(letter);
            guessedString = cw.correctlyGuessedFormat;
            displayGuessedString();
        } 
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        if(evt.getActionCommand().equals("X")) {
            letter = 'x';
            jButton26.setEnabled(false);
            guess = cw.checkLetter(letter);
            guessedString = cw.correctlyGuessedFormat;
            displayGuessedString();
        } 
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        if(evt.getActionCommand().equals("Y")) {
            letter = 'y';
            jButton27.setEnabled(false);
            guess = cw.checkLetter(letter);
            guessedString = cw.correctlyGuessedFormat;
            displayGuessedString();
        } 
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        if(evt.getActionCommand().equals("Z")) {
            letter = 'z';
            jButton28.setEnabled(false);
            guess = cw.checkLetter(letter);
            guessedString = cw.correctlyGuessedFormat;
            displayGuessedString();
        } 
    }//GEN-LAST:event_jButton28ActionPerformed

        
    //method: Main method
    //purpose: To run the PLayScreen class' JFrame form.
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlayScreen().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonA;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel wrongLabel;
    // End of variables declaration//GEN-END:variables
}
