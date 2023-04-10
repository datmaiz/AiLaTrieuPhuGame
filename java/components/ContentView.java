package components;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.ItemInterface;
import model.Kind;
import model.QuestionModel;
import view.components.Advisory;
import view.components.Audiences;
import view.components.Frame;
import view.components.Survey;
import view.main.Game;

public class ContentView extends javax.swing.JPanel {

    final String icon50_50 = "C:\\Users\\lapto\\OneDrive\\Creative Cloud Files\\Documents\\NetBeansProjects\\QuizGame\\src\\main\\java\\icon\\50_50.png";
    final String icon50_50_selected = "C:\\Users\\lapto\\OneDrive\\Creative Cloud Files\\Documents\\NetBeansProjects\\QuizGame\\src\\main\\java\\icon\\50_50_selected.png";
    final String call_selected = "C:\\Users\\lapto\\OneDrive\\Creative Cloud Files\\Documents\\NetBeansProjects\\QuizGame\\src\\main\\java\\icon\\download.jpg";
    final String call = "C:\\Users\\lapto\\OneDrive\\Creative Cloud Files\\Documents\\NetBeansProjects\\QuizGame\\src\\main\\java\\icon\\images.png";
    final String opinion_selected = "C:\\Users\\lapto\\OneDrive\\Creative Cloud Files\\Documents\\NetBeansProjects\\QuizGame\\src\\main\\java\\icon\\images_1.jpg";
    final String opinion = "C:\\Users\\lapto\\OneDrive\\Creative Cloud Files\\Documents\\NetBeansProjects\\QuizGame\\src\\main\\java\\icon\\images_1.png";
    final String friend_selected = "C:\\Users\\lapto\\OneDrive\\Creative Cloud Files\\Documents\\NetBeansProjects\\QuizGame\\src\\main\\java\\icon\\images_2.jpg";
    final String friend = "C:\\Users\\lapto\\OneDrive\\Creative Cloud Files\\Documents\\NetBeansProjects\\QuizGame\\src\\main\\java\\icon\\images_3.jpg";
    public static int numberQuestion = 1;
    boolean is50_50 = false;
    boolean isSurvey = false;
    boolean isFriend = false;
    boolean isFamous = false;
    boolean isIgnore = false;
    public static QuestionModel curentModel;
    private ArrayList<QuestionModel> listModel;
    private Frame frameHelp = new Frame();
    private JPanel survey = new Survey();
    private JPanel audiances = new Audiences(frameHelp);
    private JPanel advisory = new Advisory(frameHelp);

    long[] money = {200000, 400000, 600000, 1000000, 2000000, 3000000, 6000000, 10000000, 14000000, 22000000, 30000000,
        40000000, 60000000, 85000000, 150000000};

    public ContentView() {
        initComponents();
        listModel = (ArrayList<QuestionModel>) Question.listQuestion.clone();
        showHelping();
        initEvent(new ItemInterface() {
            @Override
            public void setAnswer(String answer, ButtonAnswer btAnswer) {
                new Thread(() -> {
                    if (checkAnswer(answer, btAnswer)) {
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        nextQuestion();
                    } else {
                        endGame();
                    }
                }).start();
            }
        });
        initDisplay();
    }

    private void showHelping() {
        help1.setIcon(toIcon(icon50_50));
        help2.setIcon(toIcon(call));
        help3.setIcon(toIcon(opinion));
        help4.setIcon(toIcon(friend));
    }

    private void initEvent(ItemInterface item) {
        help1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                help1.setIcon(toIcon(icon50_50_selected));
                if (!is50_50) {
                    help50_50();
                }
                is50_50 = true;
            }

        });
        help2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                help2.setIcon(toIcon(call_selected));
                if (!isFamous) {
                    frameHelp.showHelp(1, 1);
                }
                isFamous = true;
            }

        });
        help3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                help3.setIcon(toIcon(opinion_selected));
                if (!isFriend) {
                    int index = getAnswerInex();
                    System.out.println(index);
                    frameHelp.showHelp(2, index);
                }
                isFriend = true;
            }
        });
        help4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                help4.setIcon(toIcon(friend_selected));
                if (!isIgnore) {
                    numberQuestion--;
                    nextQuestion();
                }
                isIgnore = true;
            }

        });
        buttonAnswer1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                item.setAnswer(buttonAnswer1.getText(), buttonAnswer1);
                buttonAnswer1.repaint();
            }
        });
        buttonAnswer2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                item.setAnswer(buttonAnswer2.getText(), buttonAnswer2);
                buttonAnswer2.repaint();
            }
        });
        buttonAnswer3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                item.setAnswer(buttonAnswer3.getText(), buttonAnswer3);
            }
        });
        buttonAnswer4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                item.setAnswer(buttonAnswer4.getText(), buttonAnswer4);
            }
        });
    }

    private int getAnswerInex() {
        int index = 0;
        for (Component c : roundPanel1.getComponents()) {
            if (c instanceof ButtonAnswer b) {
                if (b == buttonAnswer1) {
                    index = 1;
                } else if (b == buttonAnswer2) {
                    index = 3;
                } else if (b == buttonAnswer3) {
                    index = 2;
                } else if (b == buttonAnswer4) {
                    index = 4;
                }
                if (b.getText().equals(curentModel.getKey())) {
                    return index;
                }
            }
        }
        return -1;
    }

    private void initDisplay() {
        if (numberQuestion >= 0 && numberQuestion <= 15) {
            labelNumber.setText("Câu hỏi số " + numberQuestion);
            int size = listModel.size();
            Random random = new Random();
            int questionSelected = Math.abs(random.nextInt() % (size - 1));
            curentModel = listModel.get(questionSelected);
            questionArea.setText(curentModel.getQuestions());
            buttonAnswer1.setText(curentModel.getAnswer1());
            buttonAnswer2.setText(curentModel.getAnswer2());
            buttonAnswer3.setText(curentModel.getAnswer3());
            buttonAnswer4.setText(curentModel.getAnswer4());
            listModel.remove(curentModel);
            repaint();
        }
    }

    public boolean checkAnswer(String answer, ButtonAnswer bt) {
        for (Component com : roundPanel1.getComponents()) {
            if (com instanceof ButtonAnswer b) {
                if (bt == b) {
                    if (answer.equals(curentModel.getKey())) {
                        b.setIsCorrect(Kind.CORRECT);
                        repaint();
                        return true;
                    } else {
                        b.setIsCorrect(Kind.INCORRECT);
                        repaint();
                        return false;
                    }
                }
            }
        }
        return false;
    }

    private void nextQuestion() {
        numberQuestion++;
        for (Component com : roundPanel1.getComponents()) {
            if (com instanceof ButtonAnswer b) {
                b.setIsCorrect(Kind.WAITING);
                b.setEnabled(true);
                b.repaint();
            }
        }
        initDisplay();
        if (numberQuestion <= 15) {
            MenuQuestion.initDisplay();
        } else {
            int i = JOptionPane.showConfirmDialog(null, "Ban da thang game, co muon choi tiep khoong", "", JOptionPane.YES_NO_OPTION);
            if (i == 0) {
                numberQuestion = 0;
                listModel = (ArrayList<QuestionModel>) Question.listQuestion.clone();
                nextQuestion();
                is50_50 = false;
                isFamous = false;
                isFriend = false;
                isSurvey = false;
                isIgnore = false;
                help1.setIcon(toIcon(icon50_50));
                help2.setIcon(toIcon(call));
                help3.setIcon(toIcon(opinion));
                help4.setIcon(toIcon(friend));
            } else if (i == 1) {
                System.exit(0);
            }
        }
    }

    private void endGame() {
        JOptionPane.showMessageDialog(null, "Bạn đã thua");
        System.exit(0);
    }

    private void newGame() {

    }

    private void help50_50() {
        for (int i = 0; i < 2; i++) {
            for (Component c : roundPanel1.getComponents()) {
                if (c instanceof ButtonAnswer b) {
                    if (!b.getText().equals(curentModel.getKey()) && !b.getText().equals("")) {
                        b.setText("");
                        break;
                    }
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
    }

    public final ImageIcon toIcon(String url) {
        return new ImageIcon(new ImageIcon(url).getImage()
                .getScaledInstance(80, 80, Image.SCALE_AREA_AVERAGING));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new components.RoundPanel();
        labelNumber = new javax.swing.JLabel();
        buttonAnswer1 = new components.ButtonAnswer();
        buttonAnswer2 = new components.ButtonAnswer();
        buttonAnswer3 = new components.ButtonAnswer();
        buttonAnswer4 = new components.ButtonAnswer();
        jScrollPane1 = new javax.swing.JScrollPane();
        questionArea = new javax.swing.JTextArea();
        help1 = new javax.swing.JLabel();
        help2 = new javax.swing.JLabel();
        help3 = new javax.swing.JLabel();
        help4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));
        setOpaque(false);

        roundPanel1.setBackground(new java.awt.Color(51, 51, 51));

        labelNumber.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelNumber.setForeground(new java.awt.Color(204, 204, 204));
        labelNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNumber.setText("Câu hỏi số 1");

        buttonAnswer1.setText("Đáp án 1");

        buttonAnswer2.setText("Đáp án 2");

        buttonAnswer3.setText("Đáp án 3");

        buttonAnswer4.setText("Đáp án 4");

        questionArea.setEditable(false);
        questionArea.setBackground(new java.awt.Color(51, 51, 51));
        questionArea.setColumns(20);
        questionArea.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        questionArea.setForeground(new java.awt.Color(204, 204, 204));
        questionArea.setLineWrap(true);
        questionArea.setRows(5);
        questionArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        questionArea.setFocusable(false);
        jScrollPane1.setViewportView(questionArea);

        help1.setToolTipText("50/50");
        help1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        help2.setToolTipText("Tổ tư vấn tại chỗ");
        help2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        help3.setToolTipText("Hỏi khán giả trường quay");
        help3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        help4.setToolTipText("Bỏ qua câu hỏi");
        help4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonAnswer2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonAnswer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonAnswer3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonAnswer4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(5, 5, 5))
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(help1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(help2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(help3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(help4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(labelNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(help1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(help2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(help3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(help4, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                .addGap(71, 71, 71)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonAnswer1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(buttonAnswer3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonAnswer2, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(buttonAnswer4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.ButtonAnswer buttonAnswer1;
    private components.ButtonAnswer buttonAnswer2;
    private components.ButtonAnswer buttonAnswer3;
    private components.ButtonAnswer buttonAnswer4;
    private javax.swing.JLabel help1;
    private javax.swing.JLabel help2;
    private javax.swing.JLabel help3;
    private javax.swing.JLabel help4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelNumber;
    private javax.swing.JTextArea questionArea;
    private components.RoundPanel roundPanel1;
    // End of variables declaration//GEN-END:variables
}
