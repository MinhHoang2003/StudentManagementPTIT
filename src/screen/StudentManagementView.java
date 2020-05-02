/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

import data.model.Student;
import java.util.List;

/**
 *
 * @author PhamMinhHoang
 */
public interface StudentManagementView {

    void setVisible(boolean isVisible);

    void refreshTable(List<Student> teachers);

    void refreshError(String message);
}
