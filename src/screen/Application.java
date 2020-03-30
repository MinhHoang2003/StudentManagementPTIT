/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

import control.TeacherController;
import data.dao.TeacherDAO;
import data.dao.TeacherDAOImpl;
import java.util.ArrayList;

/**
 *
 * @author hoang
 */
public class Application {
    public static void main(String[] args) {
        TeacherDAO teacherDAO = new TeacherDAOImpl(new ArrayList<>());
        TeacherController teacherController = new TeacherController(teacherDAO);
        teacherController.show(true);
    }
}
