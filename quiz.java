package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class quiz extends JFrame implements ActionListener {
    String questions[][] = new String[10][5];
    String ans[][] = new String[10][2];
    String userans[][] = new String[10][1];

    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup grp;

    JButton next, submit, help;

    JLabel qno, question;

    public static int timer = 20;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;

    Timer quizTimer;
    TimerTask timerTask;

    String name;

    quiz(String name) {
        this.name = name;
        setUndecorated(true);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.png"));
        JLabel img = new JLabel(i1);
        img.setBounds(0, 0, 1440, 380);
        add(img);

        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 450, 1200, 30); // Increased the width to 1200
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        questions[0][0] = "Number of primitive data types in Java are.?";
        questions[0][1] = "6";
        questions[0][2] = "7";
        questions[0][3] = "8";
        questions[0][4] = "9";

        questions[1][0] = "What is the size of float and double in java.?";
        questions[1][1] = "32 and 64";
        questions[1][2] = "32 and 32";
        questions[1][3] = "64 and 64";
        questions[1][4] = "64 and 32";

        questions[2][0] = "Automatic type conversion is possible in which of the possible cases?";
        questions[2][1] = "Byte to int";
        questions[2][2] = "Int to Long";
        questions[2][3] = "Long to int";
        questions[2][4] = "Short to int";

        questions[3][0] = "When an array is passed to a method, what does the method receive?";
        questions[3][1] = "The reference of the array";
        questions[3][2] = "A copy of the array";
        questions[3][3] = "Length of the array";
        questions[3][4] = "Copy of first element";

        questions[4][0] = "Arrays in java are.?";
        questions[4][1] = "Object References";
        questions[4][2] = "Objects";
        questions[4][3] = "Primitive data type";
        questions[4][4] = "None";

        questions[5][0] = "When is the object created with new keyword?";
        questions[5][1] = "At rum time";
        questions[5][2] = "At compile time";
        questions[5][3] = "Depends on the code";
        questions[5][4] = "None";

        questions[6][0] = "Identify the corrected definition of a package.?";
        questions[6][1] = "A package is a collection of editing tools";
        questions[6][2] = "A package is a collection of Classes";
        questions[6][3] = "A package is a collection of Classes and interfaces";
        questions[6][4] = "A package is a collection of interfaces";

        questions[7][0] = "compareTo() returns";
        questions[7][1] = "True";
        questions[7][2] = "False";
        questions[7][3] = "An int value";
        questions[7][4] = "None";

        questions[8][0] = "To which of the following does the class string belong to.";
        questions[8][1] = "java.lang";
        questions[8][2] = "java.awt";
        questions[8][3] = "java.applet";
        questions[8][4] = "java.String";

        questions[9][0] = "Total constructor string class have.?";
        questions[9][1] = "3";
        questions[9][2] = "7";
        questions[9][3] = "13";
        questions[9][4] = "20";

        ans[0][1] = "8";
        ans[1][1] = "32 and 64";
        ans[2][1] = "Int to Long";
        ans[3][1] = "The reference of the array";
        ans[4][1] = "Objects";
        ans[5][1] = "At rum time";
        ans[6][1] = "A package is a collection of Classes and interfaces";
        ans[7][1] = "An int value";
        ans[8][1] = "java.lang";
        ans[9][1] = "13";

        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        grp = new ButtonGroup();
        grp.add(opt1);
        grp.add(opt2);
        grp.add(opt3);
        grp.add(opt4);

        next = new JButton("NEXT");
        next.setBounds(700, 700, 200, 30);
        next.setBackground(new Color(22, 99, 54));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        submit = new JButton("SUBMIT");
        submit.setBounds(1150, 700, 200, 30);
        submit.setBackground(new Color(255, 215, 0));
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        add(submit);

        help = new JButton("HELP");
        help.setBounds(930, 700, 200, 30);
        help.setBackground(new Color(22, 99, 54));
        help.setForeground(Color.WHITE);
        help.addActionListener(this);
        add(help);

        start(count);

        setSize(1440, 800);
        setLocation(50, 0);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            nextQuestion();
        } else if (e.getSource() == help) {
            provideHelp();
        } else if (e.getSource() == submit) {
            submitQuiz();
        }
    }

    private void nextQuestion() {
        if (quizTimer != null) {
            quizTimer.cancel();
        }
        opt1.setEnabled(true);
        opt2.setEnabled(true);
        opt3.setEnabled(true);
        opt4.setEnabled(true);
        ans_given = 1;
        if (grp.getSelection() == null) {
            userans[count][0] = "";
        } else {
            userans[count][0] = grp.getSelection().getActionCommand();
        }
        if (count == 8) {
            next.setEnabled(false);
            submit.setEnabled(true);
        }
        count++;
        start(count);
    }

    private void provideHelp() {
        if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
            opt2.setEnabled(false);
            opt3.setEnabled(false);
        } else {
            opt1.setEnabled(false);
            opt4.setEnabled(false);
        }
        help.setEnabled(false);
    }

    private void submitQuiz() {
        ans_given = 1;
        if (quizTimer != null) {
            quizTimer.cancel();
        }
        if (grp.getSelection() == null) {
            userans[count][0] = "";
        } else {
            userans[count][0] = grp.getSelection().getActionCommand();
        }
        for (int i = 0; i < userans.length; i++) {
            if (userans[i][0].equals(ans[i][1])) {
                score += 10;
            }
        }
        setVisible(false);
        new Score(name, score);
    }

    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time left - " + timer + " seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));
        if (timer > 0) {
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Times up!!!", 1100, 500);
        }
    }

    public void start(int count) {
        if (quizTimer != null) {
            quizTimer.cancel();
        }
        timer = 20;
        qno.setText("" + (count + 1) + ".");
        question.setText("<html>" + questions[count][0] + "</html>");
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        grp.clearSelection();

        quizTimer = new Timer();
        final int currentCount = count; // final local variable

        timerTask = new TimerTask() {
            @Override
            public void run() {
                if (timer > 0) {
                    timer--;
                    repaint();
                } else {
                    if (quizTimer != null) {
                        quizTimer.cancel();
                    }
                    ans_given = 1;
                    if (grp.getSelection() == null) {
                        userans[currentCount][0] = "";
                    } else {
                        userans[currentCount][0] = grp.getSelection().getActionCommand();
                    }
                    if (currentCount == 9) {
                        for (int i = 0; i < userans.length; i++) {
                            if (userans[i][0].equals(ans[i][1])) {
                                score += 10;
                            }
                        }
                        setVisible(false);
                        new Score(name, score);
                    } else {
                        quiz.this.count++;
                        start(quiz.this.count);
                    }
                }
            }
        };
        quizTimer.schedule(timerTask, 0, 1000);
    }

    public static void main(String[] args) {
        new quiz("User");
    }
}
