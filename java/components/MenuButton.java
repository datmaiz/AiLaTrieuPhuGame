package components;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;

public class MenuButton extends JButton {

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, 10, 10));
        g2.setColor(new Color(51, 51, 51));
        g2.fill(area);
        g2.setComposite(AlphaComposite.SrcOver);
        g2.setColor(MenuButton.this.getForeground());
        g2.setFont(getFont());
        FontMetrics font = g2.getFontMetrics();
        Rectangle2D rec = font.getStringBounds(getText(), g2);
        double x = (getWidth() - rec.getWidth()) / 2;
        double y = (getHeight() - rec.getHeight()) / 2;
        g2.drawString(getText(), (int) x, (int) (y + font.getAscent()));
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if(isSelected()) {
            g2.setColor(new Color(237,228,102, 100));
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
        }
        else {
            g2.setColor(new Color(51, 51, 51));
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
        }
    }

    @Override
    public boolean isSelected() {
        repaint();
        return super.isSelected(); 
    }

    
}
