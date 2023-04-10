
package view.components;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.JFrame;

public class Audiences extends javax.swing.JPanel {
    
    int answer = 1;
    Random random = new Random();
    int A, B, C, D;
    
    Frame fh;

    public Audiences(Frame fh) {
        this.fh = fh;
        initComponents();
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fh.disableFrame();
            }
            
        });
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(112, 112, 112));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.setColor(Color.blue);
        int x = 50;
        int width = 75;
        int heightScreen = getHeight();
        preparedForPaint();
        System.out.println("a = " + A + " b = " + B + " c = " + C + " d = " + D);
        g2.setFont(getFont());
        g2.fillRect(x, heightScreen - A - 50, width, A);
        g2.fillRect(x + width * 1 + 60 * 1, heightScreen - B - 50, width, B);
        g2.fillRect(x + width * 2 + 60 * 2, heightScreen - C - 50, width, C);
        g2.fillRect(x + width * 3 + 60 * 3, heightScreen - D - 50, width, D);
        g2.setColor(Color.white);
        g2.drawString("A", x + 30, heightScreen - 20);
        g2.drawString("B", x + width + 60 + 30, heightScreen - 20);
        g2.drawString("C", x + width * 2 + 60 * 2 + 30, heightScreen - 20);
        g2.drawString("D", x + width * 3 + 60 * 3 + 30, heightScreen - 20);
        String title = "Biểu đồ thống kê từ khán giả";
        FontMetrics font = g2.getFontMetrics(getFont());
        Rectangle2D rect = font.getStringBounds(title, g2);
        int xx = (int) rect.getWidth();
        g2.drawString(title, (getWidth() - xx) / 2, 50);
        g2.drawString((A * 100 / 200) + "%", x + 20, heightScreen - 50 - A - 10);
        g2.drawString((B * 100 / 200) + "%", x + width + 60 + 20, heightScreen - 50 - B - 10);
        g2.drawString((C * 100 / 200) + "%", x + width * 2 + 60 * 2 + 20, heightScreen - 50 - C - 10);
        g2.drawString((D * 100 / 200) + "%", x + width * 3 + 60 * 3 + 20, heightScreen - 50 - D - 10);
        g2.setColor(Color.red);
        g2.drawString("X", 573, 25);
    }
    
    private void preparedForPaint() {
        int total = 0;
        if(answer == 1) {
            A = Math.abs(random.nextInt() % 20) + 50;
            total += A;
            B = Math.abs(random.nextInt(25));
            total += B;
            C = Math.abs(random.nextInt() % (95 - total));
            total += C;
            D = Math.abs(random.nextInt() % (100 - total));
        }
        else if(answer == 2) {
            B = Math.abs(random.nextInt() % 20 + 50);
            total += B;
            A = Math.abs(random.nextInt(25));
            total += A;
            C = Math.abs(random.nextInt() % (95 - total));
            total += C;
            D = Math.abs(random.nextInt() % (100 - total));
        }
        else if(answer == 3) {
            C = Math.abs(random.nextInt() % 20 + 50);
            total += C;
            B = Math.abs(random.nextInt(25));
            total += B;
            A = Math.abs(random.nextInt() % (95 - total));
            total += A;
            D = Math.abs(random.nextInt() % (100 - total));
        }
        else if(answer == 4) {
            D = Math.abs(random.nextInt() % 20 + 50);
            total += D;
            B = Math.abs(random.nextInt(25));
            total += B;
            C = Math.abs(random.nextInt() % (95 - total));
            total += C;
            A = Math.abs(random.nextInt() % (100 - total));
        }
        A *= 200 / 100;
        B *= 200 / 100;
        C *= 200 / 100;
        D *= 200 / 100;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exit = new javax.swing.JLabel();

        setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        exit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 51, 51));
        exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit.setText("X");
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 356, Short.MAX_VALUE)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 322, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exit;
    // End of variables declaration//GEN-END:variables
}
