
package view.components;

import components.ContentView;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicButtonUI;

public class Advisory extends javax.swing.JPanel {
    
    final String naruto = "C:\\Users\\lapto\\OneDrive\\Creative Cloud Files\\Documents\\NetBeansProjects\\QuizGame\\src\\main\\java\\icon\\naruto.jpg";
    final String goku = "C:\\Users\\lapto\\OneDrive\\Creative Cloud Files\\Documents\\NetBeansProjects\\QuizGame\\src\\main\\java\\icon\\songoku.jpg";
    final String luffy = "C:\\Users\\lapto\\OneDrive\\Creative Cloud Files\\Documents\\NetBeansProjects\\QuizGame\\src\\main\\java\\icon\\luffy.jpg";
    CardLayout cardLayout;
    private JFrame frameHelpp;
    
    public Advisory(JFrame frameHelpp) {
        this.frameHelpp = frameHelpp;
        initComponents();
        initImage();
        initEvent();
    }
    
    private void initImage() {
        narutoLbl.setIcon(toIcon(naruto));
        gokuLbl.setIcon(toIcon(goku));
        luffyLbl.setIcon(toIcon(luffy));
        
        narutoButton.setUI(new BasicButtonUI());
        gokuButton.setUI(new BasicButtonUI());
        luffyButton.setUI(new BasicButtonUI());
    }
    
    private void initEvent() {
        narutoButton.addActionListener(new eventButton());
        gokuButton.addActionListener(new eventButton());
        luffyButton.addActionListener(new eventButton());
        confirmButton.addActionListener(new eventButton());
    }
    
    private class eventButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout = (CardLayout) getLayout();
            String src = e.getActionCommand();
            initDisplayAnswer();
            switch (src) {
                case "Naruto" -> {
                    narutoAction();
                }
                case "Goku" -> {
                    gokuAction();
                }
                case "Luffy" -> {
                    luffyAction();
                }
                case "Cảm ơn" -> {
                    frameHelpp.setVisible(false);
                }
            }
        }
    }
    
    private void initDisplayAnswer() {
        cardLayout.show(this, "card3");
    }
    
    private void narutoAction() {
        image.setIcon(toIcon(naruto));
        answerLabel.setText("Ta nghĩ câu trả lời là: " + ContentView.curentModel.getKey());
    }
    
    private void gokuAction() {
        image.setIcon(toIcon(goku));
        answerLabel.setText("Tin ta đi đáp án đúng chính là: " + ContentView.curentModel.getKey());
    }
    
    private void luffyAction() {
        image.setIcon(toIcon(luffy));
        answerLabel.setText("Đáp án là: " + ContentView.curentModel.getKey() + ", không thể sai được");
    }
    
    public final ImageIcon toIcon(String url) {
        return new ImageIcon(new ImageIcon(url).getImage()
                .getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(112, 112, 112));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ChoosePanel = new javax.swing.JPanel();
        narutoLbl = new javax.swing.JLabel();
        gokuLbl = new javax.swing.JLabel();
        luffyLbl = new javax.swing.JLabel();
        narutoButton = new javax.swing.JButton();
        gokuButton = new javax.swing.JButton();
        luffyButton = new javax.swing.JButton();
        AnswerPanel = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        answerLabel = new javax.swing.JTextArea();
        confirmButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(112, 112, 122));
        setLayout(new java.awt.CardLayout());

        ChoosePanel.setOpaque(false);

        narutoButton.setText("Naruto");
        narutoButton.setFocusable(false);

        gokuButton.setText("Goku");
        gokuButton.setFocusable(false);

        luffyButton.setText("Luffy");
        luffyButton.setFocusable(false);

        javax.swing.GroupLayout ChoosePanelLayout = new javax.swing.GroupLayout(ChoosePanel);
        ChoosePanel.setLayout(ChoosePanelLayout);
        ChoosePanelLayout.setHorizontalGroup(
            ChoosePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChoosePanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(ChoosePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(narutoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(narutoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ChoosePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ChoosePanelLayout.createSequentialGroup()
                        .addComponent(gokuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(luffyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(ChoosePanelLayout.createSequentialGroup()
                        .addComponent(gokuLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(luffyLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(40, Short.MAX_VALUE))))
        );
        ChoosePanelLayout.setVerticalGroup(
            ChoosePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ChoosePanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(ChoosePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(gokuLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(narutoLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(luffyLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(ChoosePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(narutoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gokuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(luffyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        add(ChoosePanel, "card2");

        AnswerPanel.setOpaque(false);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        answerLabel.setEditable(false);
        answerLabel.setBackground(new java.awt.Color(51, 51, 51));
        answerLabel.setColumns(20);
        answerLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        answerLabel.setForeground(new java.awt.Color(204, 204, 204));
        answerLabel.setLineWrap(true);
        answerLabel.setRows(5);
        answerLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jScrollPane1.setViewportView(answerLabel);

        confirmButton.setText("Cảm ơn");
        confirmButton.setFocusable(false);

        javax.swing.GroupLayout AnswerPanelLayout = new javax.swing.GroupLayout(AnswerPanel);
        AnswerPanel.setLayout(AnswerPanelLayout);
        AnswerPanelLayout.setHorizontalGroup(
            AnswerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AnswerPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(AnswerPanelLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );
        AnswerPanelLayout.setVerticalGroup(
            AnswerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AnswerPanelLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(AnswerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        add(AnswerPanel, "card3");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AnswerPanel;
    private javax.swing.JPanel ChoosePanel;
    private javax.swing.JTextArea answerLabel;
    private javax.swing.JButton confirmButton;
    private javax.swing.JButton gokuButton;
    private javax.swing.JLabel gokuLbl;
    private javax.swing.JLabel image;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton luffyButton;
    private javax.swing.JLabel luffyLbl;
    private javax.swing.JButton narutoButton;
    private javax.swing.JLabel narutoLbl;
    // End of variables declaration//GEN-END:variables
}
