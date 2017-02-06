/***************************************************************
* file: SudokuScreen.java
* author: Luis Cortes, Oscar Hernandez, Henry Hu, Y-Uyen La, and An Le 
* class: CS 245 - Programming Graphical User Interfaces
*
* assignment: Swing Project v1.3
* date last modified: 2/5/2017
*
* purpose: This is the third game screen. Runs directly after color game.
*
****************************************************************/ 
package hangman;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.KeyEvent;
import static java.lang.Thread.sleep;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

//class: PlaySecondScreen
//purpose of class: This class creates the second game screen we play after
//the hangman game is skipped or has ended. It takes care of all the logic 
//of the game.
public class SudokuScreen extends javax.swing.JFrame {
    public Point center;
    private int totalScore;
    
    //constructor: PlaySecondScreen
    //purpose: This is the constructor and it initializes the objects and instance variables.
    // It also calls currentTIme() and currentDate() which are needed to set the date and time in the frame.
    // It uses "center" to always display the game window in the center of the screen. 
    public SudokuScreen(int firstScore) {
        center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        totalScore = firstScore;       
        initComponents();
        currentTime();
        currentDate();        
        mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"), "Help");
        mainPanel.getActionMap().put("Help", new HelpAction(center));
        mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Close");
        mainPanel.getActionMap().put("Close", new CloseAction(this));    }
    
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

        mainPanel = new javax.swing.JPanel();
        timePanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();
        sudokuBigPanel = new javax.swing.JPanel();
        sudokuTopLeft = new javax.swing.JPanel();
        num1 = new javax.swing.JTextField();
        num2 = new javax.swing.JTextField();
        num3 = new javax.swing.JTextField();
        num4 = new javax.swing.JTextField();
        num5 = new javax.swing.JTextField();
        num6 = new javax.swing.JTextField();
        num7 = new javax.swing.JTextField();
        num8 = new javax.swing.JTextField();
        num9 = new javax.swing.JTextField();
        sudokuTopMid = new javax.swing.JPanel();
        num10 = new javax.swing.JTextField();
        num11 = new javax.swing.JTextField();
        num12 = new javax.swing.JTextField();
        num13 = new javax.swing.JTextField();
        num14 = new javax.swing.JTextField();
        num15 = new javax.swing.JTextField();
        num16 = new javax.swing.JTextField();
        num17 = new javax.swing.JTextField();
        num18 = new javax.swing.JTextField();
        sudokuTopRight = new javax.swing.JPanel();
        num19 = new javax.swing.JTextField();
        num20 = new javax.swing.JTextField();
        num21 = new javax.swing.JTextField();
        num22 = new javax.swing.JTextField();
        num23 = new javax.swing.JTextField();
        num24 = new javax.swing.JTextField();
        num25 = new javax.swing.JTextField();
        num26 = new javax.swing.JTextField();
        num27 = new javax.swing.JTextField();
        sudokuMidLeft = new javax.swing.JPanel();
        num28 = new javax.swing.JTextField();
        num29 = new javax.swing.JTextField();
        num30 = new javax.swing.JTextField();
        num31 = new javax.swing.JTextField();
        num32 = new javax.swing.JTextField();
        num33 = new javax.swing.JTextField();
        num34 = new javax.swing.JTextField();
        num35 = new javax.swing.JTextField();
        num36 = new javax.swing.JTextField();
        sudokuMidMid = new javax.swing.JPanel();
        num37 = new javax.swing.JTextField();
        num38 = new javax.swing.JTextField();
        num39 = new javax.swing.JTextField();
        num40 = new javax.swing.JTextField();
        num41 = new javax.swing.JTextField();
        num42 = new javax.swing.JTextField();
        num43 = new javax.swing.JTextField();
        num44 = new javax.swing.JTextField();
        num45 = new javax.swing.JTextField();
        sudokuMidRight = new javax.swing.JPanel();
        num46 = new javax.swing.JTextField();
        num47 = new javax.swing.JTextField();
        num48 = new javax.swing.JTextField();
        num49 = new javax.swing.JTextField();
        num50 = new javax.swing.JTextField();
        num51 = new javax.swing.JTextField();
        num52 = new javax.swing.JTextField();
        num53 = new javax.swing.JTextField();
        num54 = new javax.swing.JTextField();
        sudokuBottomLeft = new javax.swing.JPanel();
        num55 = new javax.swing.JTextField();
        num56 = new javax.swing.JTextField();
        num57 = new javax.swing.JTextField();
        num58 = new javax.swing.JTextField();
        num59 = new javax.swing.JTextField();
        num60 = new javax.swing.JTextField();
        num61 = new javax.swing.JTextField();
        num62 = new javax.swing.JTextField();
        num63 = new javax.swing.JTextField();
        sudokuBottomMid = new javax.swing.JPanel();
        num64 = new javax.swing.JTextField();
        num65 = new javax.swing.JTextField();
        num66 = new javax.swing.JTextField();
        num67 = new javax.swing.JTextField();
        num68 = new javax.swing.JTextField();
        num69 = new javax.swing.JTextField();
        num70 = new javax.swing.JTextField();
        num71 = new javax.swing.JTextField();
        num72 = new javax.swing.JTextField();
        sudokuBottomRight = new javax.swing.JPanel();
        num73 = new javax.swing.JTextField();
        num74 = new javax.swing.JTextField();
        num75 = new javax.swing.JTextField();
        num76 = new javax.swing.JTextField();
        num77 = new javax.swing.JTextField();
        num78 = new javax.swing.JTextField();
        num79 = new javax.swing.JTextField();
        num80 = new javax.swing.JTextField();
        num81 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Color Game");
        setSize(new java.awt.Dimension(600, 400));

        mainPanel.setBackground(new java.awt.Color(204, 204, 204));
        mainPanel.setPreferredSize(new java.awt.Dimension(600, 400));

        timePanel.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.setToolTipText("Date and Time");

        date.setText("Date");
        jPanel2.add(date);

        time.setText("Time");
        jPanel2.add(time);

        javax.swing.GroupLayout timePanelLayout = new javax.swing.GroupLayout(timePanel);
        timePanel.setLayout(timePanelLayout);
        timePanelLayout.setHorizontalGroup(
            timePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
        );
        timePanelLayout.setVerticalGroup(
            timePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timePanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Abyssinica SIL", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 102));
        jLabel1.setText("SUDOKU");
        jLabel1.setToolTipText("Final Game");

        submitButton.setText("Submit");
        submitButton.setToolTipText("Check answers");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        quitButton.setText("Quit");
        quitButton.setToolTipText("Quit");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        sudokuBigPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuBigPanel.setLayout(new java.awt.GridLayout(3, 3));

        sudokuTopLeft.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTopLeft.setLayout(new java.awt.GridLayout(3, 3));

        num1.setEditable(false);
        num1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num1.setText("8");
        num1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num1ActionPerformed(evt);
            }
        });
        sudokuTopLeft.add(num1);

        num2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTopLeft.add(num2);

        num3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTopLeft.add(num3);

        num4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTopLeft.add(num4);

        num5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTopLeft.add(num5);

        num6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTopLeft.add(num6);

        num7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTopLeft.add(num7);

        num8.setEditable(false);
        num8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num8.setText("1");
        sudokuTopLeft.add(num8);

        num9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTopLeft.add(num9);

        sudokuBigPanel.add(sudokuTopLeft);

        sudokuTopMid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTopMid.setLayout(new java.awt.GridLayout(3, 3));

        num10.setEditable(false);
        num10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num10.setText("4");
        sudokuTopMid.add(num10);

        num11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTopMid.add(num11);

        num12.setEditable(false);
        num12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num12.setText("6");
        sudokuTopMid.add(num12);

        num13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTopMid.add(num13);

        num14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTopMid.add(num14);

        num15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTopMid.add(num15);

        num16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTopMid.add(num16);

        num17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTopMid.add(num17);

        num18.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTopMid.add(num18);

        sudokuBigPanel.add(sudokuTopMid);

        sudokuTopRight.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTopRight.setLayout(new java.awt.GridLayout(3, 3));

        num19.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTopRight.add(num19);

        num20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTopRight.add(num20);

        num21.setEditable(false);
        num21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num21.setText("7");
        sudokuTopRight.add(num21);

        num22.setEditable(false);
        num22.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num22.setText("4");
        sudokuTopRight.add(num22);

        num23.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTopRight.add(num23);

        num24.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTopRight.add(num24);

        num25.setEditable(false);
        num25.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num25.setText("6");
        sudokuTopRight.add(num25);

        num26.setEditable(false);
        num26.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num26.setText("5");
        sudokuTopRight.add(num26);

        num27.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuTopRight.add(num27);

        sudokuBigPanel.add(sudokuTopRight);

        sudokuMidLeft.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuMidLeft.setLayout(new java.awt.GridLayout(3, 3));

        num28.setEditable(false);
        num28.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num28.setText("5");
        sudokuMidLeft.add(num28);

        num29.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuMidLeft.add(num29);

        num30.setEditable(false);
        num30.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num30.setText("9");
        sudokuMidLeft.add(num30);

        num31.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuMidLeft.add(num31);

        num32.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuMidLeft.add(num32);

        num33.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuMidLeft.add(num33);

        num34.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuMidLeft.add(num34);

        num35.setEditable(false);
        num35.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num35.setText("4");
        sudokuMidLeft.add(num35);

        num36.setEditable(false);
        num36.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num36.setText("8");
        sudokuMidLeft.add(num36);

        sudokuBigPanel.add(sudokuMidLeft);

        sudokuMidMid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuMidMid.setLayout(new java.awt.GridLayout(3, 3));

        num37.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuMidMid.add(num37);

        num38.setEditable(false);
        num38.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num38.setText("3");
        sudokuMidMid.add(num38);

        num39.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuMidMid.add(num39);

        num40.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuMidMid.add(num40);

        num41.setEditable(false);
        num41.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num41.setText("7");
        sudokuMidMid.add(num41);

        num42.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuMidMid.add(num42);

        num43.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuMidMid.add(num43);

        num44.setEditable(false);
        num44.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num44.setText("2");
        sudokuMidMid.add(num44);

        num45.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuMidMid.add(num45);

        sudokuBigPanel.add(sudokuMidMid);

        sudokuMidRight.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuMidRight.setLayout(new java.awt.GridLayout(3, 3));

        num46.setEditable(false);
        num46.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num46.setText("7");
        sudokuMidRight.add(num46);

        num47.setEditable(false);
        num47.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num47.setText("8");
        sudokuMidRight.add(num47);

        num48.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuMidRight.add(num48);

        num49.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuMidRight.add(num49);

        num50.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuMidRight.add(num50);

        num51.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuMidRight.add(num51);

        num52.setEditable(false);
        num52.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num52.setText("1");
        sudokuMidRight.add(num52);

        num53.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuMidRight.add(num53);

        num54.setEditable(false);
        num54.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num54.setText("3");
        sudokuMidRight.add(num54);

        sudokuBigPanel.add(sudokuMidRight);

        sudokuBottomLeft.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuBottomLeft.setLayout(new java.awt.GridLayout(3, 3));

        num55.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuBottomLeft.add(num55);

        num56.setEditable(false);
        num56.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num56.setText("5");
        sudokuBottomLeft.add(num56);

        num57.setEditable(false);
        num57.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num57.setText("2");
        sudokuBottomLeft.add(num57);

        num58.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuBottomLeft.add(num58);

        num59.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuBottomLeft.add(num59);

        num60.setEditable(false);
        num60.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num60.setText("1");
        sudokuBottomLeft.add(num60);

        num61.setEditable(false);
        num61.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num61.setText("3");
        sudokuBottomLeft.add(num61);

        num62.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuBottomLeft.add(num62);

        num63.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuBottomLeft.add(num63);

        sudokuBigPanel.add(sudokuBottomLeft);

        sudokuBottomMid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuBottomMid.setLayout(new java.awt.GridLayout(3, 3));

        num64.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuBottomMid.add(num64);

        num65.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuBottomMid.add(num65);

        num66.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuBottomMid.add(num66);

        num67.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuBottomMid.add(num67);

        num68.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuBottomMid.add(num68);

        num69.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuBottomMid.add(num69);

        num70.setEditable(false);
        num70.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num70.setText("9");
        sudokuBottomMid.add(num70);

        num71.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuBottomMid.add(num71);

        num72.setEditable(false);
        num72.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num72.setText("2");
        sudokuBottomMid.add(num72);

        sudokuBigPanel.add(sudokuBottomMid);

        sudokuBottomRight.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuBottomRight.setLayout(new java.awt.GridLayout(3, 3));

        num73.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuBottomRight.add(num73);

        num74.setEditable(false);
        num74.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num74.setText("9");
        sudokuBottomRight.add(num74);

        num75.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuBottomRight.add(num75);

        num76.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuBottomRight.add(num76);

        num77.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuBottomRight.add(num77);

        num78.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuBottomRight.add(num78);

        num79.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuBottomRight.add(num79);

        num80.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sudokuBottomRight.add(num80);

        num81.setEditable(false);
        num81.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num81.setText("5");
        sudokuBottomRight.add(num81);

        sudokuBigPanel.add(sudokuBottomRight);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(submitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(quitButton))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addComponent(timePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sudokuBigPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sudokuBigPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(quitButton)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submitButtonActionPerformed

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        SkipScreen sScreen = new SkipScreen(totalScore);
        sScreen.setVisible(true);
        sScreen.setScore(""+totalScore);
        sScreen.setBounds(center.x - 600/2, center.y - 400/2, 600, 400);            
        dispose();
    }//GEN-LAST:event_quitButtonActionPerformed

    private void num1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_num1ActionPerformed

    
    //method: generalButtionAction
    //purpose: checks if the gem clicked is the correct color of the text. Gives 
    //user 5 rounds to play and displays a message if they clicked the correct
    //gem or incorrect gem. Also updates the users score
    private void generalButtonAction(Color color) {
        
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SudokuScreen(50).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField num1;
    private javax.swing.JTextField num10;
    private javax.swing.JTextField num11;
    private javax.swing.JTextField num12;
    private javax.swing.JTextField num13;
    private javax.swing.JTextField num14;
    private javax.swing.JTextField num15;
    private javax.swing.JTextField num16;
    private javax.swing.JTextField num17;
    private javax.swing.JTextField num18;
    private javax.swing.JTextField num19;
    private javax.swing.JTextField num2;
    private javax.swing.JTextField num20;
    private javax.swing.JTextField num21;
    private javax.swing.JTextField num22;
    private javax.swing.JTextField num23;
    private javax.swing.JTextField num24;
    private javax.swing.JTextField num25;
    private javax.swing.JTextField num26;
    private javax.swing.JTextField num27;
    private javax.swing.JTextField num28;
    private javax.swing.JTextField num29;
    private javax.swing.JTextField num3;
    private javax.swing.JTextField num30;
    private javax.swing.JTextField num31;
    private javax.swing.JTextField num32;
    private javax.swing.JTextField num33;
    private javax.swing.JTextField num34;
    private javax.swing.JTextField num35;
    private javax.swing.JTextField num36;
    private javax.swing.JTextField num37;
    private javax.swing.JTextField num38;
    private javax.swing.JTextField num39;
    private javax.swing.JTextField num4;
    private javax.swing.JTextField num40;
    private javax.swing.JTextField num41;
    private javax.swing.JTextField num42;
    private javax.swing.JTextField num43;
    private javax.swing.JTextField num44;
    private javax.swing.JTextField num45;
    private javax.swing.JTextField num46;
    private javax.swing.JTextField num47;
    private javax.swing.JTextField num48;
    private javax.swing.JTextField num49;
    private javax.swing.JTextField num5;
    private javax.swing.JTextField num50;
    private javax.swing.JTextField num51;
    private javax.swing.JTextField num52;
    private javax.swing.JTextField num53;
    private javax.swing.JTextField num54;
    private javax.swing.JTextField num55;
    private javax.swing.JTextField num56;
    private javax.swing.JTextField num57;
    private javax.swing.JTextField num58;
    private javax.swing.JTextField num59;
    private javax.swing.JTextField num6;
    private javax.swing.JTextField num60;
    private javax.swing.JTextField num61;
    private javax.swing.JTextField num62;
    private javax.swing.JTextField num63;
    private javax.swing.JTextField num64;
    private javax.swing.JTextField num65;
    private javax.swing.JTextField num66;
    private javax.swing.JTextField num67;
    private javax.swing.JTextField num68;
    private javax.swing.JTextField num69;
    private javax.swing.JTextField num7;
    private javax.swing.JTextField num70;
    private javax.swing.JTextField num71;
    private javax.swing.JTextField num72;
    private javax.swing.JTextField num73;
    private javax.swing.JTextField num74;
    private javax.swing.JTextField num75;
    private javax.swing.JTextField num76;
    private javax.swing.JTextField num77;
    private javax.swing.JTextField num78;
    private javax.swing.JTextField num79;
    private javax.swing.JTextField num8;
    private javax.swing.JTextField num80;
    private javax.swing.JTextField num81;
    private javax.swing.JTextField num9;
    private javax.swing.JButton quitButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JPanel sudokuBigPanel;
    private javax.swing.JPanel sudokuBottomLeft;
    private javax.swing.JPanel sudokuBottomMid;
    private javax.swing.JPanel sudokuBottomRight;
    private javax.swing.JPanel sudokuMidLeft;
    private javax.swing.JPanel sudokuMidMid;
    private javax.swing.JPanel sudokuMidRight;
    private javax.swing.JPanel sudokuTopLeft;
    private javax.swing.JPanel sudokuTopMid;
    private javax.swing.JPanel sudokuTopRight;
    private javax.swing.JLabel time;
    private javax.swing.JPanel timePanel;
    // End of variables declaration//GEN-END:variables
}
