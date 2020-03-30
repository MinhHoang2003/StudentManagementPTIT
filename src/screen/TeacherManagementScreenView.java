/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

import data.model.Teacher;
import java.util.List;

/**
 *
 * @author hoang
 */
public interface TeacherManagementScreenView {
    
    void setVisible(boolean isVisible);
    
    void refreshTable(List<Teacher> teachers);
    
    void refreshError(String message);
    
}
