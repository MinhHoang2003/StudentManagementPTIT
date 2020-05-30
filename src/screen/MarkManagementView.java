/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

import data.model.Mark;
import java.util.List;

/**
 *
 * @author PhamMinhHoang
 */
public interface MarkManagementView extends BaseView<Mark> {

    void showSubjectListOfTeacher(List<String> subjects);

    void showCoursesOfTeacher(List<String> courses);

    void showError(String message);

    void showNotPassStudentCount(int num);

    void showPassStudentCount(int num);
}
