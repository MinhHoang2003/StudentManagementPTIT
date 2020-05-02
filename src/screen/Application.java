/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

import control.StudentController;
import data.dao.MajorDAOImpl;
import data.dao.StudentDAO;
import data.dao.StudentDAOImpl;
import data.model.Utils;

/**
 *
 * @author hoang
 */
public class Application {

    public static void main(String[] args) {
        StudentDAO teacherDAO = StudentDAOImpl.getInstance();
        MajorDAOImpl majorDAOImpl = MajorDAOImpl.getInstance();
        Utils.setHashMap(majorDAOImpl.majorsCached);
        StudentController teacherController = new StudentController(teacherDAO, majorDAOImpl);
        teacherController.show(true);
    }
}
