package admin;

import components.Question;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.DefaultTableModel;
import model.QuestionModel;
import source.Environtment;

public class ListQuestionPanel extends javax.swing.JPanel {

    private EditFrame editFrame;

    public ListQuestionPanel() {
        initComponents();
        editFrame = new EditFrame();
        initEvent();
        jScrollPane1.setBackground(new Color(51, 51, 51));
        jTable1.getTableHeader().setBackground(new Color(51, 51, 51));
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(300);
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        pushQuestion();
    }

    public void pushQuestion() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (QuestionModel q : Question.listQuestion) {
            model.addRow(new Object[]{q.getQuestions(), q.getAnswer1(), q.getAnswer2(), q.getAnswer3(), q.getAnswer4(), q.getKey()});
        }
    }

    public void initEvent() {
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = jTable1.getSelectedRow();
                System.out.println(row);
                if (row >= 0) {
                    editFrame.setVisible(true);
                    String question = jTable1.getValueAt(row, 0).toString();
                    String answer1 = jTable1.getValueAt(row, 1).toString();
                    String answer2 = jTable1.getValueAt(row, 2).toString();
                    String answer3 = jTable1.getValueAt(row, 3).toString();
                    String answer4 = jTable1.getValueAt(row, 4).toString();
                    String key = jTable1.getValueAt(row, 5).toString();
                    editFrame.getQuestionField().setText(question);
                    editFrame.getAnswer1Field().setText(answer1);
                    editFrame.getAnswer2Field().setText(answer2);
                    editFrame.getAnswer3Field().setText(answer3);
                    editFrame.getAnswer4Field().setText(answer4);
                    editFrame.getKeyText().setText(key);
                }
            }

        });
        editFrame.getEditButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = jTable1.getSelectedRow();
                System.out.println(row);
                String question = editFrame.getQuestionField().getText();
                String answer1 = editFrame.getAnswer1Field().getText();
                String answer2 = editFrame.getAnswer2Field().getText();
                String answer3 = editFrame.getAnswer3Field().getText();
                String answer4 = editFrame.getAnswer4Field().getText();
                String key = editFrame.getKeyText().getText();
                if (!question.isEmpty() && !answer1.isEmpty() && !answer2.isEmpty() && !answer3.isEmpty() && !answer4.isEmpty() && !key.isEmpty()) {
                    jTable1.setValueAt(question, row, 0);
                    jTable1.setValueAt(answer1, row, 1);
                    jTable1.setValueAt(answer2, row, 2);
                    jTable1.setValueAt(answer3, row, 3);
                    jTable1.setValueAt(answer4, row, 4);
                    jTable1.setValueAt(answer4, row, 5);
//                    for (QuestionModel q : Question.listQuestion) {
//                        if (q.getQuestions().equals(jTable1.getValueAt(row, 0).toString())) {
//                            Question.listQuestion.remove(q);
//                            Question.listQuestion.add(new QuestionModel(question, answer1, answer2, answer3, answer4, key));
//                            Environtment.writeQuestion(Question.listQuestion);
//                            showHideFrame(false);
//                            break;
//                        }
//                    }
                    for(int i = 0; i < Question.listQuestion.size(); i++) {
                        if(Question.listQuestion.get(i).getQuestions().equals(jTable1.getValueAt(row, 0).toString())) {
                            Question.listQuestion.set(i, new QuestionModel(question, answer1, answer2, answer3, answer4, key));
                            Environtment.writeQuestion(Question.listQuestion);
                            showHideFrame(false);
                            break;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Không được bỏ trống thông tin");
                }
            }
        });
    }
    
    private void showHideFrame(boolean status) {
        editFrame.setVisible(status);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        editButton = new javax.swing.JButton();

        setOpaque(false);

        jTable1.setBackground(new java.awt.Color(51, 51, 51));
        jTable1.setForeground(new java.awt.Color(204, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Câu hỏi", "Đáp án 1", "Đáp án 2", "Đáp án 3", "Đáp án 4", "Key:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        editButton.setBackground(new java.awt.Color(51, 51, 51));
        editButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editButton.setForeground(new java.awt.Color(204, 204, 204));
        editButton.setText("Chỉnh sửa");
        editButton.setBorder(null);
        editButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editButton.setUI(new BasicButtonUI());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                .addGap(194, 194, 194))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
