package components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.JButton;
import model.Kind;

public class ButtonAnswer extends JButton {
    
    private boolean hovering = false;
    private boolean selected = false;
    private Kind isCorrect = Kind.WAITING;
    private boolean isClicked = false;
    int chosen = -1;
    public String answer;

    public ButtonAnswer() {
        setFocusable(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setHorizontalAlignment(JButton.LEFT);
        initEvent();
    }
    
    private void initEvent() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hovering = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hovering = false;
                repaint();
            }

//            @Override
//            public void mouseClicked(MouseEvent e) {
//                isCorrect = Kind.SELECTING;
//                isClicked = true;
//                answer = getText();
//                System.out.println(answer);
//                repaint();
//            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(51, 51, 51));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        g2.setColor(ButtonAnswer.this.getForeground());
        g2.setFont(getFont());
        FontMetrics font = g2.getFontMetrics();
        Rectangle2D rec = font.getStringBounds(getText(), g2);
        double y = (getHeight() - rec.getHeight()) / 2;
        g2.drawString(getText(), 5, (int) (y + font.getAscent()));
    }

    @Override
    public void paint(Graphics g) {
        setEnabled(!isClicked);
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(getFont());
        FontMetrics font = g2.getFontMetrics();
        Rectangle2D rec = font.getStringBounds(getText(), g2);
        double y = (getHeight() - rec.getHeight()) / 2;
        if(hovering && isEnabled()) {
            g2.setColor(Color.yellow);
            g2.drawString(getText(),5, (int) (y + font.getAscent()));
            g2.setColor(new Color(0, 0, 0, 50));
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        }
        else {
            g2.setColor(Color.WHITE);
            g2.drawString(getText(), 5, (int) y + font.getAscent());
        }
        if(null != isCorrect) switch (isCorrect) {
            case CORRECT -> {
                g2.setColor(Color.GREEN);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                g2.setColor(Color.WHITE);
                g2.drawString(getText(), 5, (int) (y + font.getAscent()));
            }
            case INCORRECT -> {
                g2.setColor(Color.RED);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                g2.setColor(Color.WHITE);
                g2.drawString(getText(), 5, (int) (y + font.getAscent()));
            }
            case SELECTING -> {
                g2.setColor(Color.ORANGE);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                g2.setColor(Color.WHITE);
                g2.drawString(getText(), 5, (int) (y + font.getAscent()));
            }
        }
        
    }

    public boolean isHovering() {
        return hovering;
    }

    public void setHovering(boolean hovering) {
        this.hovering = hovering;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Kind getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(Kind isCorrect) {
        this.isCorrect = isCorrect;
    }
    public String getAnswer() {
        return answer;
    }

    public boolean isIsClicked() {
        return isClicked;
    }

    public void setIsClicked(boolean isClicked) {
        this.isClicked = isClicked;
    }

    
}
