
package view.components;

import components.RoundPanel;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameHelpp extends JFrame {
    
    public RoundPanel roundPanel = new RoundPanel();
    CardLayout cardLayout = new CardLayout();

    public FrameHelpp() {
        initDisplay();
        setUndecorated(true);
//        setBackground(new Color(0,0,0,0));
        roundPanel.setLayout(cardLayout);
        JPanel panel = new JPanel();
        panel.setBackground(Color.red);
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.BLUE);
        roundPanel.add(panel, "1");
        roundPanel.add(panel1, "2");
        cardLayout.show(roundPanel, "1");
        JButton ad = new JButton();
        ad.addActionListener((e) -> {
            cardLayout.show(roundPanel, "2");
        });
//        add(ad);
    }
    
    private void initDisplay() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
    }
    
    public void showHelp(int sign) {
        setVisible(true);
        if(sign == 1) {
            cardLayout.show(roundPanel, "advisory");
        } else {
            cardLayout.show(roundPanel, "audiances");
        }
    }
    
    public void disableFrame() {
        setVisible(false);
    }
    
    public static void main(String[] args) {
        new FrameHelpp().setVisible(true);
    }
    
}
