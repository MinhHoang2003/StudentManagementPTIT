/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

import control.ButtonState;
import control.TeacherController;
import data.model.Teacher;
import data.model.Utils;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hoang
 */
public class TecherManagementScreen extends javax.swing.JFrame implements TeacherManagementScreenView {

    private ButtonState buttonState = ButtonState.NORMAL;
    private final DefaultTableModel model;
    private final TeacherController controller;

    public TecherManagementScreen(TeacherController teacherController) {
        initComponents();
        controller = teacherController;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        comboBoxMajor = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        comboBoxDegree = new javax.swing.JComboBox<>();
        editTextId = new javax.swing.JTextField();
        buttonConfirm = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        buttonCancel = new javax.swing.JButton();
        editTextName = new javax.swing.JTextField();
        buttonAdd = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        buttonEdit = new javax.swing.JButton();
        editTextAddress = new javax.swing.JTextField();
        buttonRemove = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        editTextEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Address", "Email", "Major", "Degree"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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

        comboBoxMajor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cong nghe thong tin", "An toan thong tin", "Marketing", "Quan tri kinh doanh", "Dien tu - Vien thong", "Da phuong tien" }));

        jLabel6.setText("Degree: ");

        jLabel1.setText("Id :");

        comboBoxDegree.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thac sy", "Tien sy", "Pho giao su", "Giao su" }));

        editTextId.setEditable(false);

        buttonConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/check.png"))); // NOI18N
        buttonConfirm.setText("OK");
        buttonConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfirmActionPerformed(evt);
            }
        });

        jLabel2.setText("Name :");

        buttonCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/cross.png"))); // NOI18N
        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        buttonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/more.png"))); // NOI18N
        buttonAdd.setText("ADD");
        buttonAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        jLabel3.setText("Address :");

        buttonEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/edit.png"))); // NOI18N
        buttonEdit.setText("EDIT");
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });

        buttonRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/eraser.png"))); // NOI18N
        buttonRemove.setText("REMOVE");
        buttonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveActionPerformed(evt);
            }
        });

        jLabel4.setText("Emai :");

        jLabel5.setText("Major: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(buttonAdd)
                        .addGap(68, 68, 68)
                        .addComponent(buttonEdit)
                        .addGap(63, 63, 63)
                        .addComponent(buttonRemove))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editTextAddress))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(editTextName, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(editTextId, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(comboBoxMajor, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(editTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(comboBoxDegree, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(editTextId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(editTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonConfirm)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(editTextName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(editTextAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)
                                .addComponent(comboBoxDegree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxMajor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonCancel))))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAdd)
                    .addComponent(buttonEdit)
                    .addComponent(buttonRemove))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfirmActionPerformed
        Teacher teacher = getData();
        switch (this.buttonState) {
            case ADD: {
                if (teacher != null) {
//                    model.addRow(Utils.convertTeacherToObject(teacher));
                    controller.addNewTeacher(teacher);
                }
                break;
            }
            case EDIT: {
                if (teacher != null) {
//                    model.addRow(Utils.convertTeacherToObject(teacher));
                    controller.editTeacher(teacher);
                }
                break;
            }
            case REMOVE: {
                if (teacher != null) {
                    controller.deleteTeacher(teacher.getId());
                }
                break;
            }
        }
        changeButtonState(ButtonState.NORMAL);
    }//GEN-LAST:event_buttonConfirmActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        changeButtonState(ButtonState.NORMAL);
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        changeButtonState(ButtonState.ADD);
    }//GEN-LAST:event_buttonAddActionPerformed

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        changeButtonState(ButtonState.EDIT);
    }//GEN-LAST:event_buttonEditActionPerformed

    private void buttonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveActionPerformed
        changeButtonState(ButtonState.REMOVE);
    }//GEN-LAST:event_buttonRemoveActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.getSelectedRow();
        int id = (int) model.getValueAt(index, 0);
        String name = (String) model.getValueAt(index, 1);
        String address = (String) model.getValueAt(index, 2);
        String email = (String) model.getValueAt(index, 3);
        String major = (String) model.getValueAt(index, 4);
        String degree = (String) model.getValueAt(index, 5);

        if (name.isEmpty() || address.isEmpty()
                || email.isEmpty() || major.isEmpty() || degree.isEmpty()) {
            //TODO : dialog here
            return;
        }
        editTextId.setText(id + "");
        editTextName.setText(name);
        editTextAddress.setText(address);
        editTextEmail.setText(email);
        setSelectedValue(comboBoxMajor, major);
        setSelectedValue(comboBoxDegree, degree);
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonConfirm;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonRemove;
    private javax.swing.JComboBox<String> comboBoxDegree;
    private javax.swing.JComboBox<String> comboBoxMajor;
    private javax.swing.JTextField editTextAddress;
    private javax.swing.JTextField editTextEmail;
    private javax.swing.JTextField editTextId;
    private javax.swing.JTextField editTextName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void changeButtonState(ButtonState state) {
        this.buttonState = state;
        switch (buttonState) {
            case ADD: {
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
                this.buttonEdit.setEnabled(true);
                this.buttonRemove.setEnabled(true);
                this.buttonConfirm.setEnabled(false);
                this.buttonCancel.setEnabled(false);
                break;
            }
        }
    }

    private Teacher getData() {
//        int id = Integer.parseInt(editTextId.getText());
        String name = editTextName.getText();
        String email = editTextEmail.getText();
        String address = editTextAddress.getText();
        String major = comboBoxMajor.getSelectedItem().toString();
        String degree = comboBoxDegree.getSelectedItem().toString();
        if (!name.isEmpty() && !email.isEmpty() && !address.isEmpty()) {
            return new Teacher(major, degree, 0, name, email, address);
        } else {
            return null;
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
    public void refreshTable(List<Teacher> teachers) {
        model.setRowCount(0);
        for (Teacher teacher : teachers) {
            model.addRow(Utils.convertTeacherToObject(teacher));
        }
    }

    @Override
    public void refreshError(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
