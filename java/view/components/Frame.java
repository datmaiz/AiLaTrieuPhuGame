package view.components;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
    
    private JPanel advisory = new Advisory(this);
    private Audiences audiances = new Audiences(this);
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainanel = new JPanel();

    public Frame() {
        initComponents();
    }
    
    private void initComponents() {
        add(mainanel);
        setUndecorated(true);
        mainanel.setLayout(cardLayout);
        setUndecorated(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null);
        setBackground(new Color(0, 0, 0, 0));
        addComponent();
    }
    
    private void addComponent() {
        mainanel.add(advisory, "1");
        mainanel.add(audiances, "2");
//        cardLayout.show(mainanel, "1");
    }
    
    public void showHelp(int index, int answer) {
        setAnswerForChart(answer);
        cardLayout.show(mainanel, String.valueOf(index));
        setVisible(true);
    }
    
    public void disableFrame() {
        setVisible(false);
    }
    
    public void setAnswerForChart(int index) {
        audiances.answer = index;
        audiances.repaint();
    }
    
    
    
}
