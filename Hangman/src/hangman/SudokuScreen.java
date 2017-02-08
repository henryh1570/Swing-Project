/**
 * *************************************************************
 * file: SudokuScreen.java author: Luis Cortes, Oscar Hernandez, Henry Hu,
 * Y-Uyen La, and An Le class: CS 245 - Programming Graphical User Interfaces
 * 
 * assignment: Swing Project v1.0 date last modified: 1/18/2017
 * 
 * purpose: This is the third game screen. Runs directly after color game.
 * 
***************************************************************
 */
package hangman;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    private ArrayList<Integer> userInputs;
    private ArrayList<Integer> answers;
    private int totalPossible;

    //constructor: SudokuScreen
    //purpose: This is the constructor and it initializes the objects and instance variables.
    // It also calls currentTIme() and currentDate() which are needed to set the date and time in the frame.
    // It uses "center" to always display the game window in the center of the screen. 
    // It is also used to fill the answer key and to initialize the user input.
    public SudokuScreen(int firstScore) {
        center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        totalScore = firstScore;
        totalPossible = 540;

        answers = new ArrayList<Integer>();
        initAnswers();

        userInputs = new ArrayList<Integer>();

        for (int i = 0; i < 54; i++) {
            userInputs.add(0);
        }
      
        initComponents();
        setTitle("Sudoku");
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        currentTime();
        currentDate();
        mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"), "Help");
        mainPanel.getActionMap().put("Help", new HelpAction(center));
        mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Close");
        mainPanel.getActionMap().put("Close", new CloseAction(this));
        quitButton.setToolTipText("End Sudoku");
        submitButton.setToolTipText("Submit Answers");

    }

    //method: initAnswers
    //purpose: This fills the ArrayList with the answers that we are going to compare userInput to later.
    public void initAnswers() {
        BufferedReader br = null;
        String line;
        String split = ",";
        String[] values = null;

        try {
            br = new BufferedReader(new FileReader("answers.txt"));
            while ((line = br.readLine()) != null) {
                values = line.split(split);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        for (int i = 0; i < values.length; i++) {
            int temp = Integer.parseInt(values[i]);
            answers.add(temp);
        }

    }

    //method: currentDate
    //purpose: This method returns the current date in the Month, dd, year format.
    public void currentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMMMMMMMMM dd, yyyy");
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
                for (;;) {
                    Calendar cal = new GregorianCalendar();
                    int second = cal.get(Calendar.SECOND);
                    int minute = cal.get(Calendar.MINUTE);
                    int hour = cal.get(Calendar.HOUR);
                    time.setText(hour + ":" + minute + ":" + second);

                    try {
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
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Color Game");

        mainPanel.setBackground(new java.awt.Color(204, 204, 204));
        mainPanel.setPreferredSize(new java.awt.Dimension(600, 400));

        timePanel.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

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

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        quitButton.setText("Quit");
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
        num1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        num1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num1.setText("8");
        sudokuTopLeft.add(num1);

        num2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num2ActionPerformed(evt);
            }
        });
        sudokuTopLeft.add(num2);

        num3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num3ActionPerformed(evt);
            }
        });
        sudokuTopLeft.add(num3);

        num4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num4ActionPerformed(evt);
            }
        });
        sudokuTopLeft.add(num4);

        num5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num5ActionPerformed(evt);
            }
        });
        sudokuTopLeft.add(num5);

        num6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num6ActionPerformed(evt);
            }
        });
        sudokuTopLeft.add(num6);

        num7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num7ActionPerformed(evt);
            }
        });
        sudokuTopLeft.add(num7);

        num8.setEditable(false);
        num8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        num8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num8.setText("1");
        sudokuTopLeft.add(num8);

        num9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num9ActionPerformed(evt);
            }
        });
        sudokuTopLeft.add(num9);

        sudokuBigPanel.add(sudokuTopLeft);

        sudokuTopMid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTopMid.setLayout(new java.awt.GridLayout(3, 3));

        num10.setEditable(false);
        num10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        num10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num10.setText("4");
        sudokuTopMid.add(num10);

        num11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num11ActionPerformed(evt);
            }
        });
        sudokuTopMid.add(num11);

        num12.setEditable(false);
        num12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        num12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num12.setText("6");
        sudokuTopMid.add(num12);

        num13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num13ActionPerformed(evt);
            }
        });
        sudokuTopMid.add(num13);

        num14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num14ActionPerformed(evt);
            }
        });
        sudokuTopMid.add(num14);

        num15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num15ActionPerformed(evt);
            }
        });
        sudokuTopMid.add(num15);

        num16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num16ActionPerformed(evt);
            }
        });
        sudokuTopMid.add(num16);

        num17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num17ActionPerformed(evt);
            }
        });
        sudokuTopMid.add(num17);

        num18.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num18ActionPerformed(evt);
            }
        });
        sudokuTopMid.add(num18);

        sudokuBigPanel.add(sudokuTopMid);

        sudokuTopRight.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuTopRight.setLayout(new java.awt.GridLayout(3, 3));

        num19.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num19ActionPerformed(evt);
            }
        });
        sudokuTopRight.add(num19);

        num20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num20ActionPerformed(evt);
            }
        });
        sudokuTopRight.add(num20);

        num21.setEditable(false);
        num21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        num21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num21.setText("7");
        sudokuTopRight.add(num21);

        num22.setEditable(false);
        num22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        num22.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num22.setText("4");
        sudokuTopRight.add(num22);

        num23.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num23ActionPerformed(evt);
            }
        });
        sudokuTopRight.add(num23);

        num24.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num24ActionPerformed(evt);
            }
        });
        sudokuTopRight.add(num24);

        num25.setEditable(false);
        num25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        num25.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num25.setText("6");
        sudokuTopRight.add(num25);

        num26.setEditable(false);
        num26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        num26.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num26.setText("5");
        sudokuTopRight.add(num26);

        num27.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num27ActionPerformed(evt);
            }
        });
        sudokuTopRight.add(num27);

        sudokuBigPanel.add(sudokuTopRight);

        sudokuMidLeft.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuMidLeft.setLayout(new java.awt.GridLayout(3, 3));

        num28.setEditable(false);
        num28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        num28.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num28.setText("5");
        sudokuMidLeft.add(num28);

        num29.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num29ActionPerformed(evt);
            }
        });
        sudokuMidLeft.add(num29);

        num30.setEditable(false);
        num30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        num30.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num30.setText("9");
        sudokuMidLeft.add(num30);

        num31.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num31ActionPerformed(evt);
            }
        });
        sudokuMidLeft.add(num31);

        num32.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num32ActionPerformed(evt);
            }
        });
        sudokuMidLeft.add(num32);

        num33.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num33ActionPerformed(evt);
            }
        });
        sudokuMidLeft.add(num33);

        num34.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num34ActionPerformed(evt);
            }
        });
        sudokuMidLeft.add(num34);

        num35.setEditable(false);
        num35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        num35.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num35.setText("4");
        sudokuMidLeft.add(num35);

        num36.setEditable(false);
        num36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        num36.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num36.setText("8");
        sudokuMidLeft.add(num36);

        sudokuBigPanel.add(sudokuMidLeft);

        sudokuMidMid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuMidMid.setLayout(new java.awt.GridLayout(3, 3));

        num37.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num37ActionPerformed(evt);
            }
        });
        sudokuMidMid.add(num37);

        num38.setEditable(false);
        num38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        num38.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num38.setText("3");
        sudokuMidMid.add(num38);

        num39.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num39ActionPerformed(evt);
            }
        });
        sudokuMidMid.add(num39);

        num40.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num40ActionPerformed(evt);
            }
        });
        sudokuMidMid.add(num40);

        num41.setEditable(false);
        num41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        num41.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num41.setText("7");
        sudokuMidMid.add(num41);

        num42.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num42ActionPerformed(evt);
            }
        });
        sudokuMidMid.add(num42);

        num43.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num43ActionPerformed(evt);
            }
        });
        sudokuMidMid.add(num43);

        num44.setEditable(false);
        num44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        num44.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num44.setText("2");
        sudokuMidMid.add(num44);

        num45.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num45ActionPerformed(evt);
            }
        });
        sudokuMidMid.add(num45);

        sudokuBigPanel.add(sudokuMidMid);

        sudokuMidRight.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuMidRight.setLayout(new java.awt.GridLayout(3, 3));

        num46.setEditable(false);
        num46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        num46.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num46.setText("7");
        sudokuMidRight.add(num46);

        num47.setEditable(false);
        num47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        num47.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num47.setText("8");
        sudokuMidRight.add(num47);

        num48.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num48ActionPerformed(evt);
            }
        });
        sudokuMidRight.add(num48);

        num49.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num49ActionPerformed(evt);
            }
        });
        sudokuMidRight.add(num49);

        num50.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num50ActionPerformed(evt);
            }
        });
        sudokuMidRight.add(num50);

        num51.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num51ActionPerformed(evt);
            }
        });
        sudokuMidRight.add(num51);

        num52.setEditable(false);
        num52.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        num52.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num52.setText("1");
        sudokuMidRight.add(num52);

        num53.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num53ActionPerformed(evt);
            }
        });
        sudokuMidRight.add(num53);

        num54.setEditable(false);
        num54.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        num54.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num54.setText("3");
        sudokuMidRight.add(num54);

        sudokuBigPanel.add(sudokuMidRight);

        sudokuBottomLeft.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuBottomLeft.setLayout(new java.awt.GridLayout(3, 3));

        num55.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num55ActionPerformed(evt);
            }
        });
        sudokuBottomLeft.add(num55);

        num56.setEditable(false);
        num56.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        num56.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num56.setText("5");
        sudokuBottomLeft.add(num56);

        num57.setEditable(false);
        num57.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        num57.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num57.setText("2");
        sudokuBottomLeft.add(num57);

        num58.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num58ActionPerformed(evt);
            }
        });
        sudokuBottomLeft.add(num58);

        num59.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num59ActionPerformed(evt);
            }
        });
        sudokuBottomLeft.add(num59);

        num60.setEditable(false);
        num60.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        num60.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num60.setText("1");
        sudokuBottomLeft.add(num60);

        num61.setEditable(false);
        num61.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        num61.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num61.setText("3");
        sudokuBottomLeft.add(num61);

        num62.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num62ActionPerformed(evt);
            }
        });
        sudokuBottomLeft.add(num62);

        num63.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num63ActionPerformed(evt);
            }
        });
        sudokuBottomLeft.add(num63);

        sudokuBigPanel.add(sudokuBottomLeft);

        sudokuBottomMid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuBottomMid.setLayout(new java.awt.GridLayout(3, 3));

        num64.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num64ActionPerformed(evt);
            }
        });
        sudokuBottomMid.add(num64);

        num65.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num65ActionPerformed(evt);
            }
        });
        sudokuBottomMid.add(num65);

        num66.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num66ActionPerformed(evt);
            }
        });
        sudokuBottomMid.add(num66);

        num67.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num67ActionPerformed(evt);
            }
        });
        sudokuBottomMid.add(num67);

        num68.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num68ActionPerformed(evt);
            }
        });
        sudokuBottomMid.add(num68);

        num69.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num69ActionPerformed(evt);
            }
        });
        sudokuBottomMid.add(num69);

        num70.setEditable(false);
        num70.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        num70.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num70.setText("9");
        sudokuBottomMid.add(num70);

        num71.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num71ActionPerformed(evt);
            }
        });
        sudokuBottomMid.add(num71);

        num72.setEditable(false);
        num72.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        num72.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num72.setText("2");
        sudokuBottomMid.add(num72);

        sudokuBigPanel.add(sudokuBottomMid);

        sudokuBottomRight.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sudokuBottomRight.setLayout(new java.awt.GridLayout(3, 3));

        num73.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num73ActionPerformed(evt);
            }
        });
        sudokuBottomRight.add(num73);

        num74.setEditable(false);
        num74.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        num74.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num74.setText("9");
        sudokuBottomRight.add(num74);

        num75.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num75ActionPerformed(evt);
            }
        });
        sudokuBottomRight.add(num75);

        num76.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num76.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num76ActionPerformed(evt);
            }
        });
        sudokuBottomRight.add(num76);

        num77.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num77ActionPerformed(evt);
            }
        });
        sudokuBottomRight.add(num77);

        num78.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num78.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num78ActionPerformed(evt);
            }
        });
        sudokuBottomRight.add(num78);

        num79.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num79.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num79ActionPerformed(evt);
            }
        });
        sudokuBottomRight.add(num79);

        num80.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num80.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num80ActionPerformed(evt);
            }
        });
        sudokuBottomRight.add(num80);

        num81.setEditable(false);
        num81.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        num81.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num81.setText("5");
        sudokuBottomRight.add(num81);

        sudokuBigPanel.add(sudokuBottomRight);

        jLabel3.setText(" message ");

        jLabel2.setText("score");

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
                .addContainerGap(83, Short.MAX_VALUE)
                .addComponent(sudokuBigPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(34, 34, 34))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sudokuBigPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    //method: submitButtonActionPerformed
    //purpose: This method checks the user's input against the correct answers. If they're correct, they get sent to the score screen and get shown their final score.
    // If they're incorrect, they must continue the game until they get it right.
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        boolean correct = false;

        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i) == userInputs.get(i)) {
                correct = true;
            } else {
                correct = false;
            }
        }
        
        if (correct) {
            jLabel3.setForeground(Color.GREEN);
            jLabel3.setText("Correct!");
            jLabel3.setVisible(true);
            
            totalPossible += totalScore;
            
            SkipScreen sScreen = new SkipScreen(totalPossible);
            sScreen.setVisible(true);
            sScreen.setScore("" + totalPossible);
            sScreen.setBounds(center.x - 600 / 2, center.y - 400 / 2, 600, 400);
            dispose();

           
        } else {
            jLabel3.setForeground(Color.RED);
            jLabel3.setText("Incorrect! Try again!");
            jLabel3.setVisible(true);
            String score = "Score: " + totalPossible;
            jLabel2.setText(score);
            jLabel2.setVisible(true);
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    //method: quitButtonActionPerformed
    //purpose: If user quits, they get no points from this game and are sent to the score screen
    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        SkipScreen sScreen = new SkipScreen(totalScore);
        sScreen.setVisible(true);
        sScreen.setScore("" + totalScore);
        sScreen.setBounds(center.x - 600 / 2, center.y - 400 / 2, 600, 400);
        dispose();
    }//GEN-LAST:event_quitButtonActionPerformed

    //method: checkScore
    //purpose: This method checks that their first answer input for each box is correct. If it's not this method calls subtractPoints()
    private void checkScore(int index, int value) {
        if (answers.get(index) != value) {
            subtractPoints();
        } else {
            return;
        }
    }

    //method: subtractPoints
    //purpose: This method just subtracts points from the 540 points possible
    private void subtractPoints() {
        totalPossible -= 10;
    }
    
    //method: checkValue
    //purpose: This method checks if the value is between 1 and 9
    private boolean checkValue(int value) {
        boolean result = false;

        if (value < 1 || value > 9) {
            jLabel3.setForeground(Color.RED);
            jLabel3.setText("Error! Value must be 1-9");
            jLabel3.setVisible(true);
            result = false;
            subtractPoints();
        } else if (value > 0 && value < 10) {
            jLabel3.setVisible(false);
            result = true;
        }
        return result;
    }

    //method: addToList
    //purpose: This adds the user's input to the userInput ArrayList if it's correct
    private void addToList(int index, int value) {
        userInputs.add(index, value);

        System.out.println(userInputs);
        System.out.println(userInputs.size());
    }

    //method: removeFromList
    //purpose: If the user decides to change their answer, this method takes their original input out from the userInput ArrayList and replaces it with their new one.
    private void removeFromList(int index) {
        userInputs.remove(index);
    }

    
    /**********************************
     * From here on out, all of these are event methods for each of the text input boxes.
     * All of these methods check to make sure that the inputted value is an integer. If it isn't, it throws and exception, displays message to user,
     * and asks them to enter an integer.
     * This is also where it calls the checkScore() to either deduct, or leave their points alone depending on if they got the answer right the first time.
     * This also checks calls the check() which checks if the number is between 1-9
     * 
     *********************************/
    
    private void num2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num2ActionPerformed
        int value = 0;
        try {
            value = Integer.parseInt(num2.getText());
            boolean check = checkValue(value);

            if (check && userInputs.get(0) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(0);
                addToList(0, value);
            } else if (check && userInputs.get(0) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(0);
                addToList(0, value);
                checkScore(0, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");
        }
    }//GEN-LAST:event_num2ActionPerformed

    private void num3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num3ActionPerformed
        int value = 0;
        try {
            value = Integer.parseInt(num3.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(1) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(1);
                addToList(1, value);
            } else if (check && userInputs.get(1) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(1);
                addToList(1, value);
                checkScore(1, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }
    }//GEN-LAST:event_num3ActionPerformed

    private void num11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num11ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num11.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(2) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(2);
                addToList(2, value);
            } else if (check && userInputs.get(2) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(2);
                addToList(2, value);
                checkScore(2, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num11ActionPerformed

    private void num19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num19ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num19.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(3) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(3);
                addToList(3, value);
            } else if (check && userInputs.get(3) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(3);
                addToList(3, value);
                checkScore(3, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }
    }//GEN-LAST:event_num19ActionPerformed

    private void num20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num20ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num20.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(4) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(4);
                addToList(4, value);
            } else if (check && userInputs.get(4) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(4);
                addToList(4, value);
                checkScore(4, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num20ActionPerformed

    private void num4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num4ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num4.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(5) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(5);
                addToList(5, value);
            } else if (check && userInputs.get(5) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(5);
                addToList(5, value);
                checkScore(5, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num4ActionPerformed

    private void num5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num5ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num5.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(6) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(6);
                addToList(6, value);
            } else if (check && userInputs.get(6) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(6);
                addToList(6, value);
                checkScore(6, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num5ActionPerformed

    private void num6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num6ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num6.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(7) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(7);
                addToList(7, value);
            } else if (check && userInputs.get(7) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(7);
                addToList(7, value);
                checkScore(7, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }
    }//GEN-LAST:event_num6ActionPerformed

    private void num13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num13ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num13.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(8) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(8);
                addToList(8, value);
            } else if (check && userInputs.get(8) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(8);
                addToList(8, value);
                checkScore(8, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num13ActionPerformed

    private void num14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num14ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num14.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(9) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(9);
                addToList(9, value);
            } else if (check && userInputs.get(9) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(9);
                addToList(9, value);
                checkScore(9, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");
        }

    }//GEN-LAST:event_num14ActionPerformed

    private void num15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num15ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num15.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(10) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(10);
                addToList(10, value);
            } else if (check && userInputs.get(10) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(10);
                addToList(10, value);
                checkScore(10, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num15ActionPerformed

    private void num23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num23ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num23.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(11) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(11);
                addToList(11, value);
            } else if (check && userInputs.get(11) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(11);
                addToList(11, value);
                checkScore(11, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num23ActionPerformed

    private void num24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num24ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num24.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(12) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(12);
                addToList(12, value);
            } else if (check && userInputs.get(12) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(12);
                addToList(12, value);
                checkScore(12, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num24ActionPerformed

    private void num7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num7ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num7.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(13) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(13);
                addToList(13, value);
            } else if (check && userInputs.get(13) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(13);
                addToList(13, value);
                checkScore(13, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num7ActionPerformed

    private void num9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num9ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num9.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(14) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(14);
                addToList(14, value);
            } else if (check && userInputs.get(14) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(14);
                addToList(14, value);
                checkScore(14, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num9ActionPerformed

    private void num16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num16ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num16.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(15) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(15);
                addToList(15, value);
            } else if (check && userInputs.get(15) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(15);
                addToList(15, value);
                checkScore(15, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num16ActionPerformed

    private void num17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num17ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num17.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(16) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(16);
                addToList(16, value);
            } else if (check && userInputs.get(16) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(16);
                addToList(16, value);
                checkScore(16, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num17ActionPerformed

    private void num18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num18ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num18.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(17) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(17);
                addToList(17, value);
            } else if (check && userInputs.get(17) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(17);
                addToList(17, value);
                checkScore(17, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }
    }//GEN-LAST:event_num18ActionPerformed

    private void num27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num27ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num27.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(18) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(18);
                addToList(18, value);
            } else if (check && userInputs.get(18) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(18);
                addToList(18, value);
                checkScore(18, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num27ActionPerformed

    private void num29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num29ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num29.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(19) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(19);
                addToList(19, value);
            } else if (check && userInputs.get(19) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(19);
                addToList(19, value);
                checkScore(19, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num29ActionPerformed

    private void num37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num37ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num37.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(20) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(20);
                addToList(20, value);
            } else if (check && userInputs.get(20) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(20);
                addToList(20, value);
                checkScore(20, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num37ActionPerformed

    private void num39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num39ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num39.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(21) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(21);
                addToList(21, value);
            } else if (check && userInputs.get(21) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(21);
                addToList(21, value);
                checkScore(21, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num39ActionPerformed

    private void num48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num48ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num48.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(22) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(22);
                addToList(22, value);
            } else if (check && userInputs.get(22) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(22);
                addToList(22, value);
                checkScore(22, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }
    }//GEN-LAST:event_num48ActionPerformed

    private void num31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num31ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num31.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(23) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(23);
                addToList(23, value);
            } else if (check && userInputs.get(23) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(23);
                addToList(23, value);
                checkScore(23, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num31ActionPerformed

    private void num32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num32ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num32.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(24) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(24);
                addToList(24, value);
            } else if (check && userInputs.get(24) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(24);
                addToList(24, value);
                checkScore(24, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num32ActionPerformed

    private void num40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num40ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num40.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(26) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(26);
                addToList(26, value);
            } else if (check && userInputs.get(26) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(26);
                addToList(26, value);
                checkScore(26, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num40ActionPerformed

    private void num42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num42ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num42.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(27) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(27);
                addToList(27, value);
            } else if (check && userInputs.get(27) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(27);
                addToList(27, value);
                checkScore(27, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num42ActionPerformed

    private void num49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num49ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num49.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(28) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(28);
                addToList(28, value);
            } else if (check && userInputs.get(28) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(28);
                addToList(28, value);
                checkScore(28, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num49ActionPerformed

    private void num50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num50ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num50.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(29) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(29);
                addToList(29, value);
            } else if (check && userInputs.get(29) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(29);
                addToList(29, value);
                checkScore(29, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }
    }//GEN-LAST:event_num50ActionPerformed

    private void num51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num51ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num51.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(30) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(30);
                addToList(30, value);
            } else if (check && userInputs.get(30) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(30);
                addToList(30, value);
                checkScore(30, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }
    }//GEN-LAST:event_num51ActionPerformed

    private void num34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num34ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num34.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(31) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(31);
                addToList(31, value);
            } else if (check && userInputs.get(31) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(31);
                addToList(31, value);
                checkScore(31, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }
    }//GEN-LAST:event_num34ActionPerformed

    private void num43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num43ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num43.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(32) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(32);
                addToList(32, value);
            } else if (check && userInputs.get(32) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(32);
                addToList(32, value);
                checkScore(32, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num43ActionPerformed

    private void num45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num45ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num45.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(33) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(33);
                addToList(33, value);
            } else if (check && userInputs.get(33) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(33);
                addToList(33, value);
                checkScore(33, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }
    }//GEN-LAST:event_num45ActionPerformed

    private void num53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num53ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num53.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(34) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(34);
                addToList(34, value);
            } else if (check && userInputs.get(34) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(34);
                addToList(34, value);
                checkScore(34, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }
    }//GEN-LAST:event_num53ActionPerformed

    private void num55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num55ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num55.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(35) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(35);
                addToList(35, value);
            } else if (check && userInputs.get(35) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(35);
                addToList(35, value);
                checkScore(35, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num55ActionPerformed

    private void num64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num64ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num64.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(36) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(36);
                addToList(36, value);
            } else if (check && userInputs.get(36) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(36);
                addToList(36, value);
                checkScore(36, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num64ActionPerformed

    private void num65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num65ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num65.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(37) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(37);
                addToList(37, value);
            } else if (check && userInputs.get(37) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(37);
                addToList(37, value);
                checkScore(37, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }
    }//GEN-LAST:event_num65ActionPerformed

    private void num66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num66ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num66.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(38) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(38);
                addToList(38, value);
            } else if (check && userInputs.get(38) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(38);
                addToList(38, value);
                checkScore(38, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }
    }//GEN-LAST:event_num66ActionPerformed

    private void num73ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num73ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num73.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(39) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(39);
                addToList(39, value);
            } else if (check && userInputs.get(39) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(39);
                addToList(39, value);
                checkScore(39, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }
    }//GEN-LAST:event_num73ActionPerformed

    private void num75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num75ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num75.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(40) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(40);
                addToList(40, value);
            } else if (check && userInputs.get(40) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(40);
                addToList(40, value);
                checkScore(40, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num75ActionPerformed

    private void num58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num58ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num58.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(41) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(41);
                addToList(41, value);
            } else if (check && userInputs.get(41) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(41);
                addToList(41, value);
                checkScore(41, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }
    }//GEN-LAST:event_num58ActionPerformed

    private void num59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num59ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num59.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(42) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(42);
                addToList(42, value);
            } else if (check && userInputs.get(42) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(42);
                addToList(42, value);
                checkScore(42, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num59ActionPerformed

    private void num67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num67ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num67.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(43) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(43);
                addToList(43, value);
            } else if (check && userInputs.get(43) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(43);
                addToList(43, value);
                checkScore(43, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num67ActionPerformed

    private void num68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num68ActionPerformed

        int value = 0;
        try {

            value = Integer.parseInt(num68.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(44) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(44);
                addToList(44, value);
            } else if (check && userInputs.get(44) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(44);
                addToList(44, value);
                checkScore(44, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }
    }//GEN-LAST:event_num68ActionPerformed

    private void num69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num69ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num69.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(45) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(45);
                addToList(45, value);
            } else if (check && userInputs.get(45) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(45);
                addToList(45, value);
                checkScore(45, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num69ActionPerformed

    private void num76ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num76ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num76.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(46) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(46);
                addToList(46, value);
            } else if (check && userInputs.get(46) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(46);
                addToList(46, value);
                checkScore(46, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }
    }//GEN-LAST:event_num76ActionPerformed

    private void num77ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num77ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num77.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(47) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(47);
                addToList(47, value);
            } else if (check && userInputs.get(47) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(47);
                addToList(47, value);
                checkScore(47, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num77ActionPerformed

    private void num78ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num78ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num78.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(48) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(48);
                addToList(48, value);
            } else if (check && userInputs.get(48) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(48);
                addToList(48, value);
                checkScore(48, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num78ActionPerformed

    private void num62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num62ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num62.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(49) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(49);
                addToList(49, value);
            } else if (check && userInputs.get(49) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(49);
                addToList(49, value);
                checkScore(49, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num62ActionPerformed

    private void num63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num63ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num63.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(50) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(50);
                addToList(50, value);
            } else if (check && userInputs.get(50) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(50);
                addToList(50, value);
                checkScore(50, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num63ActionPerformed

    private void num71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num71ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num71.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(51) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(51);
                addToList(51, value);
            } else if (check && userInputs.get(51) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(51);
                addToList(51, value);
                checkScore(51, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num71ActionPerformed

    private void num79ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num79ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num79.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(52) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(52);
                addToList(52, value);
            } else if (check && userInputs.get(52) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(52);
                addToList(52, value);
                checkScore(52, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num79ActionPerformed

    private void num80ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num80ActionPerformed
        int value = 0;
        try {

            value = Integer.parseInt(num80.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(53) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(53);
                addToList(53, value);
            } else if (check && userInputs.get(53) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(53);
                addToList(53, value);
                checkScore(53, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }
    }//GEN-LAST:event_num80ActionPerformed

    private void num33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num33ActionPerformed

        int value = 0;
        try {

            value = Integer.parseInt(num33.getText());
            boolean check = checkValue(value);
            if (check && userInputs.get(25) != 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(25);
                addToList(25, value);
            } else if (check && userInputs.get(25) == 0) {
                if (jLabel2.getText().equals("Please enter an integer")) {
                    jLabel2.setVisible(false);
                }
                removeFromList(25);
                addToList(25, value);
                checkScore(25, value);
            }
        } catch (IllegalArgumentException e) {
            jLabel2.setForeground(Color.RED);
            jLabel2.setVisible(true);
            jLabel2.setText("Please enter an integer");

        }


    }//GEN-LAST:event_num33ActionPerformed

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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