
package components;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JButton;

public class ButtonMoney extends JButton {
    
    private int index = -1;
    private int curentIndex = 1;

    public ButtonMoney() {
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(51, 51, 51));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        g2.setColor(getForeground());
        g2.setFont(getFont());
        FontMetrics font = g2.getFontMetrics();
        Rectangle2D rec = font.getStringBounds(getText(), g2);
        double x = (getWidth() - rec.getWidth()) / 2;
        double y = (getHeight() - rec.getHeight()) / 2;
        g2.drawString(getText(), 5, (int) (y + font.getAscent()));
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        if(curentIndex == index) {
            g2.setColor(Color.ORANGE);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        }
        else {
            g2.setColor(new Color(51, 51, 51));
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        }
        g2.setColor(getForeground());
        g2.setFont(getFont());
        FontMetrics font = g2.getFontMetrics();
        Rectangle2D rec = font.getStringBounds(getText(), g2);
        double x = (getWidth() - rec.getWidth()) / 2;
        double y = (getHeight() - rec.getHeight()) / 2;
        g2.drawString(getText(), 5, (int) (y + font.getAscent()));
    }
    
    public void checkIndex() {
        repaint();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getCurentIndex() {
        return curentIndex;
    }

    public void setCurentIndex(int curentIndex) {
        this.curentIndex = curentIndex;
    }
    
    
    
}
