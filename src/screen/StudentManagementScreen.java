/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

import control.ButtonState;
import control.StudentController;
import data.model.Major;
import data.model.Student;
import data.model.Utils;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PhamMinhHoang
 */
public class StudentManagementScreen extends javax.swing.JFrame implements BaseView<Student> {

    private ButtonState buttonState = ButtonState.NORMAL;
    private final DefaultTableModel model;
    private final StudentController controller;

    public StudentManagementScreen(StudentController controller) {
        initComponents();
        changeButtonState(ButtonState.NORMAL);
        model = (DefaultTableModel) jTable1.getModel();
        this.controller = controller;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        editTextId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        editTextName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        editTextAddress = new javax.swing.JTextField();
        editTextDateOfBirth = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        editTextEmail = new javax.swing.JTextField();
        buttonConfirm = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        buttonRemove = new javax.swing.JButton();
        buttonEdit = new javax.swing.JButton();
        buttonAdd = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        editTextYearStudyIn = new javax.swing.JTextField();
        comboBoxMajor = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        editTextClassName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sinh viên", "Họ và tên", "Địa chỉ", "Ngày sinh", "Email", "Lớp", "Chuyên ngành", "Năm nhập học"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        editTextId.setEditable(false);

        jLabel1.setText("Id :");

        jLabel2.setText("Họ và tên:");

        jLabel3.setText("Địa chỉ:");

        jLabel7.setText("Ngày sinh:");

        jLabel6.setText("Năm nhập học:");

        jLabel5.setText("Chuyên ngành:");

        jLabel4.setText("Emai :");

        buttonConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/check.png"))); // NOI18N
        buttonConfirm.setText("Áp dụng");
        buttonConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfirmActionPerformed(evt);
            }
        });

        buttonCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/cross.png"))); // NOI18N
        buttonCancel.setText("Hủy bỏ");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        buttonRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/eraser.png"))); // NOI18N
        buttonRemove.setText("Xóa");
        buttonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveActionPerformed(evt);
            }
        });

        buttonEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/edit.png"))); // NOI18N
        buttonEdit.setText("Sửa");
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });

        buttonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/more.png"))); // NOI18N
        buttonAdd.setText("Thêm");
        buttonAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        jLabel8.setText("* ví dụ: 01/01/2011");

        comboBoxMajor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cong nghe thong tin", "An toan thong tin", "Marketing", "Quan tri kinh doanh", "Dien tu - Vien thong", "Da phuong tien" }));

        jLabel10.setText("Lớp:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(55, 55, 55)
                        .addComponent(editTextId, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(22, 22, 22)
                        .addComponent(editTextName, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(35, 35, 35)
                                .addComponent(editTextAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(editTextDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel8)))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10)
                            .addComponent(jLabel5))))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editTextYearStudyIn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxMajor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editTextClassName, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonCancel)
                            .addComponent(buttonConfirm)))))
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(buttonAdd)
                .addGap(31, 31, 31)
                .addComponent(buttonEdit)
                .addGap(34, 34, 34)
                .addComponent(buttonRemove))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editTextId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonConfirm)
                        .addComponent(editTextClassName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(editTextName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonCancel)
                                    .addComponent(jLabel4)
                                    .addComponent(editTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(comboBoxMajor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(editTextAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(editTextDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(editTextYearStudyIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAdd)
                    .addComponent(buttonEdit)
                    .addComponent(buttonRemove))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        this.buttonEdit.setEnabled(true);
        this.buttonRemove.setEnabled(true);
        int index = jTable1.getSelectedRow();
        String studentId = (String) model.getValueAt(index, 0);
        String name = (String) model.getValueAt(index, 1);
        String dateOfBirth = (String) model.getValueAt(index, 3);
        String address = (String) model.getValueAt(index, 2);
        String email = (String) model.getValueAt(index, 4);
        String className = (String) model.getValueAt(index, 5);
        String major = (String) model.getValueAt(index, 6);
        String yearStudyIn = (String) model.getValueAt(index, 7);

        if (name.isEmpty() || address.isEmpty()
                || email.isEmpty() || major.isEmpty()) {
            //TODO : dialog here
            return;
        }
        editTextId.setText(studentId);
        editTextClassName.setText(className);
        editTextName.setText(name);
        editTextAddress.setText(address);
        editTextEmail.setText(email);
        editTextDateOfBirth.setText(dateOfBirth);
        editTextYearStudyIn.setText(yearStudyIn);
        setSelectedValue(comboBoxMajor, major);
    }//GEN-LAST:event_jTable1MouseClicked

    private void buttonConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfirmActionPerformed
        Student student = null;
        try {
            student = getData();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(StudentManagementScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (student != null) {
            switch (this.buttonState) {
                case ADD: {
                    controller.addNewStudent(student);
                    break;
                }
                case EDIT: {
                    controller.editStudent(student);
                    break;
                }
                case REMOVE: {
                    controller.deleteStudent(student.getId());
                    break;
                }
            }
            clear();
            changeButtonState(ButtonState.NORMAL);
        }
    }//GEN-LAST:event_buttonConfirmActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        clear();
        changeButtonState(ButtonState.NORMAL);
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveActionPerformed
        changeButtonState(ButtonState.REMOVE);
    }//GEN-LAST:event_buttonRemoveActionPerformed

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        changeButtonState(ButtonState.EDIT);
    }//GEN-LAST:event_buttonEditActionPerformed

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        jTable1.clearSelection();
        changeButtonState(ButtonState.ADD);
    }//GEN-LAST:event_buttonAddActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonConfirm;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonRemove;
    private javax.swing.JComboBox<String> comboBoxMajor;
    private javax.swing.JTextField editTextAddress;
    private javax.swing.JTextField editTextClassName;
    private javax.swing.JTextField editTextDateOfBirth;
    private javax.swing.JTextField editTextEmail;
    private javax.swing.JTextField editTextId;
    private javax.swing.JTextField editTextName;
    private javax.swing.JTextField editTextYearStudyIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void changeButtonState(ButtonState state) {
        this.buttonState = state;
        switch (buttonState) {
            case ADD: {
                clear();
                this.buttonAdd.setEnabled(true);
                this.buttonEdit.setEnabled(false);
                this.buttonRemove.setEnabled(false);
                this.buttonConfirm.setEnabled(true);
                this.buttonCancel.setEnabled(true);
                break;
            }
            case EDIT: {
                this.buttonAdd.setEnabled(false);
                this.buttonEdit.setEnabled(true);
                this.buttonRemove.setEnabled(false);
                this.buttonConfirm.setEnabled(true);
                this.buttonCancel.setEnabled(true);
                break;
            }
            case REMOVE: {
                this.buttonAdd.setEnabled(false);
                this.buttonEdit.setEnabled(false);
                this.buttonRemove.setEnabled(true);
                this.buttonConfirm.setEnabled(true);
                this.buttonCancel.setEnabled(true);
                break;
            }
            case NORMAL: {
                this.buttonAdd.setEnabled(true);
                this.buttonEdit.setEnabled(false);
                this.buttonRemove.setEnabled(false);
                this.buttonConfirm.setEnabled(false);
                this.buttonCancel.setEnabled(false);
                break;
            }
        }
    }

    private void setSelectedValue(JComboBox comboBox, String value) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i).toString().equalsIgnoreCase(value)) {
                comboBox.setSelectedIndex(i);
            }
        }
    }

    @Override
    public void refreshTable(List<Student> data) {
        model.setRowCount(0);
        System.out.println("Refresh table " + data.size());
        data.forEach((student) -> {
            model.addRow(Utils.convertStudentToObject(student));
        });
    }

    @Override
    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    private Student getData() throws SQLException, ClassNotFoundException {
        String idByString = editTextId.getText();
        String yearStudyIn = editTextYearStudyIn.getText();
        Major major = controller.getMajor(comboBoxMajor.getSelectedItem().toString());

        String id = "";

        String name = editTextName.getText();
        String dateOfBirth = editTextDateOfBirth.getText();
        String email = editTextEmail.getText();
        String address = editTextAddress.getText();
        String className = editTextClassName.getText();
        if (!controller.validateNameField(name)) {
            editTextName.requestFocus();
            editTextName.selectAll();
            return null;
        } else if (!controller.validateAddress(address)) {
            editTextAddress.requestFocus();
            editTextAddress.selectAll();
            return null;
        } else if (!controller.validateDate(dateOfBirth)) {
            editTextDateOfBirth.requestFocus();
            editTextDateOfBirth.selectAll();
            return null;
        } else if (!controller.validateClassName(className)) {
            editTextClassName.requestFocus();
            editTextClassName.selectAll();
            return null;
        } else if (!controller.validateEmailForm(email)) {
            editTextEmail.requestFocus();
            editTextEmail.selectAll();
            return null;
        } else if (!idByString.isEmpty()) {
            id = idByString;
            return new Student(major.getId(), yearStudyIn, className, id, name, email, address, dateOfBirth);
        } else if (!controller.validateYear(yearStudyIn)) {
            editTextYearStudyIn.requestFocus();
            editTextYearStudyIn.selectAll();
            return null;
        } else {
            id = controller.generateNewStudentId(yearStudyIn, major);
            return new Student(major.getId(), yearStudyIn, className, id, name, email, address, dateOfBirth);
        }
    }

    private void clear() {
        editTextId.setText("");
        editTextName.setText("");
        editTextDateOfBirth.setText("");
        editTextEmail.setText("");
        editTextAddress.setText("");
        editTextClassName.setText("");
        editTextYearStudyIn.setText("");
    }

    @Override
    public void showConfirmCloseMessage() {
        int confirmed = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc muốn thoát bảng quản lý sinh viên?", "Thoát",
                JOptionPane.YES_NO_OPTION);

        if (confirmed == JOptionPane.YES_OPTION) {
            dispose();
        } else {
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }

}
