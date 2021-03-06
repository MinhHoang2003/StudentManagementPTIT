/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

import control.MarkController;
import data.model.Mark;
import data.model.Utils;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hoang
 */
public class MarkManagementScreen extends javax.swing.JFrame implements MarkManagementView {

    public static final String MESSAGE_COURSE_NOT_SELECT = "Hãy chọn mộn học trước";
    public static final String MESSAGE_LET_SELECT = "Hãy chọn một mục";
    public static final String MESSAGE_SUBJECT_NOT_SELECT = "Chưa được chọn";

    private final DefaultTableModel model;
    private final MarkController markController;

    public MarkManagementScreen(MarkController controller) {
        initComponents();
        this.markController = controller;
        model = (DefaultTableModel) jTable1.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jComboSubjects = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboClass = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboStatus = new javax.swing.JComboBox<>();
        jButtonGetMark = new javax.swing.JButton();
        jButtonExport = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelPass = new javax.swing.JLabel();
        jLabelNotPass = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelSubjectName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Môn học");

        jLabel2.setText("Môn học :");

        jComboSubjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboSubjectsActionPerformed(evt);
            }
        });

        jLabel3.setText("Lớp : ");

        jComboClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboClassActionPerformed(evt);
            }
        });

        jLabel4.setText("Lọc trạng thái");

        jComboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chưa được chọn", "Qua môn", "Không qua môn" }));

        jButtonGetMark.setBackground(new java.awt.Color(255, 255, 255));
        jButtonGetMark.setText("Lấy thông tin");
        jButtonGetMark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGetMarkActionPerformed(evt);
            }
        });

        jButtonExport.setBackground(new java.awt.Color(255, 255, 255));
        jButtonExport.setText("Xuất báo cáo");
        jButtonExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportActionPerformed(evt);
            }
        });

        jLabel5.setText("Qua môn:");

        jLabel6.setText("Không qua môn:");

        jLabelPass.setText("0");

        jLabelNotPass.setText("0");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Tên", "Id", "CC", "TH", "BT", "KT", "Thi", "TK(10)", "TK(CH)", "KQ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setRowHeight(25);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboClass, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabelNotPass))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(45, 45, 45)
                                            .addComponent(jLabelPass)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabelSubjectName))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jButtonGetMark)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonExport)
                        .addGap(28, 28, 28)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelSubjectName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabelPass))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelNotPass))
                .addGap(36, 36, 36)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonExport)
                    .addComponent(jButtonGetMark)))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboSubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboSubjectsActionPerformed
        String name = jComboSubjects.getSelectedItem().toString();
        if (!name.equals(MESSAGE_LET_SELECT)) {
            markController.getCoursesIdByTeacherId(name);
            jLabelSubjectName.setText(name);
        } else {
            jLabelSubjectName.setText("");
            jComboClass.removeAllItems();
            jComboClass.addItem(MESSAGE_COURSE_NOT_SELECT);
        }
    }//GEN-LAST:event_jComboSubjectsActionPerformed

    private void jButtonGetMarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGetMarkActionPerformed
        String courseId = jComboClass.getSelectedItem().toString().trim();
        String filter = jComboStatus.getSelectedItem().toString().trim();
        if (courseId.equals(MESSAGE_LET_SELECT) || courseId.equals(MESSAGE_COURSE_NOT_SELECT)) {
            return;
        }
        int id = Integer.parseInt(courseId);
        switch (filter) {
            case "Chưa được chọn":
                markController.getMarkAfterSelected(id);
                break;
            case "Qua môn":
                markController.getMarkAfterSelectedPassStudent(id);
                break;
            case "Không qua môn":
                markController.getMarkAfterSelectedNotPassStudent(id);
                break;
            default:
                markController.getMarkAfterSelected(id);
                break;
        }
        markController.getPassStudentCount(id);
        markController.getNotPassStudentCount(id);
    }//GEN-LAST:event_jButtonGetMarkActionPerformed

    private void jComboClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboClassActionPerformed
        if (jComboClass.getItemCount() == 0) {
            return;
        }
        String selected = jComboClass.getSelectedItem().toString();
        if (selected.equals(MESSAGE_LET_SELECT) || selected.equals(MESSAGE_COURSE_NOT_SELECT)) {
            jButtonGetMark.setEnabled(false);
            jButtonExport.setEnabled(false);
        } else {
            jButtonGetMark.setEnabled(true);
            jButtonExport.setEnabled(false);
        }
    }//GEN-LAST:event_jComboClassActionPerformed

    private void jButtonExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");
        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            String fileOutputPath = fileChooser.getSelectedFile().getAbsolutePath();
            markController.exportMarkToExcelFile(fileOutputPath);
        }
    }//GEN-LAST:event_jButtonExportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExport;
    private javax.swing.JButton jButtonGetMark;
    private javax.swing.JComboBox<String> jComboClass;
    private javax.swing.JComboBox<String> jComboStatus;
    private javax.swing.JComboBox<String> jComboSubjects;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelNotPass;
    private javax.swing.JLabel jLabelPass;
    private javax.swing.JLabel jLabelSubjectName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void refreshTable(List<Mark> data) {
        markController.setCachedForMarks(data);
        if (data.size() > 0) {
            jButtonExport.setEnabled(true);
        }
        model.setRowCount(0);
        System.out.println("Refresh table " + data.size());
        for (int i = 0; i < data.size(); i++) {
            model.addRow(Utils.convertMarkToObject(i + 1, data.get(i)));
        };
    }

    @Override
    public void showErrorMessage(String message) {
        System.err.println("Error: " + message);
    }

    @Override
    public void showSubjectListOfTeacher(List<String> subjects) {
        jComboSubjects.removeAllItems();
        jComboSubjects.addItem(MESSAGE_LET_SELECT);
        subjects.forEach((subject) -> {
            jComboSubjects.addItem(subject);
        });
    }

    @Override
    public void showCoursesOfTeacher(List<String> courses) {
        jComboClass.removeAllItems();
        jComboClass.addItem(MESSAGE_LET_SELECT);
        courses.forEach((course) -> {
            jComboClass.addItem(course);
        });
    }

    @Override
    public void showError(String message) {
        System.err.println("Error: " + message);
    }

    @Override
    public void showConfirmCloseMessage() {
        int confirmed = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc muốn thoát bảng điểm?", "Thoát",
                JOptionPane.YES_NO_OPTION);

        if (confirmed == JOptionPane.YES_OPTION) {
            dispose();
        } else {
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }

    @Override
    public void showNotPassStudentCount(int num) {
        jLabelNotPass.setText(num + "");
    }

    @Override
    public void showPassStudentCount(int num) {
        jLabelPass.setText(num + "");
    }
}
