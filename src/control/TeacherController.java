/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import data.dao.MajorDAOImpl;
import data.dao.TeacherDAO;
import data.model.Major;
import data.model.Teacher;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;
import screen.BaseView;
import screen.TeacherManagementScreen;

/**
 *
 * @author hoang
 */
public class TeacherController implements BaseController {

    private final TeacherDAO teacherDAO;
    private final MajorDAOImpl majorDAO;
    private final BaseView<Teacher> view;

    public TeacherController(TeacherDAO teacherDAO, MajorDAOImpl majorDAO) {
        this.teacherDAO = teacherDAO;
        this.majorDAO = majorDAO;
        view = new TeacherManagementScreen(this);
    }

    @Override
    public void show(boolean isVisible) {
        view.setVisible(isVisible);
        if (isVisible) {
            refreshTable();
        }
    }

    @Override
    public void refreshTable() {
        SwingWorker<List<Teacher>, Void> worker = new SwingWorker<List<Teacher>, Void>() {
            @Override
            protected List<Teacher> doInBackground() throws Exception {
                return teacherDAO.getTeachers();
            }

            @Override
            protected void done() {
                try {
                    List<Teacher> teachers = get();
                    view.refreshTable(teachers);
                } catch (InterruptedException | ExecutionException ex) {
                    view.refreshError(ex.getMessage());
                }
            }
        };
        worker.execute();
    }

    public void addNewTeacher(Teacher teacher) {
        SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                return teacherDAO.addNewTeacher(teacher);
            }

            @Override
            protected void done() {
                try {
                    boolean isSuccess = get();
                    if (isSuccess) {
                        refreshTable();
                    }
                } catch (InterruptedException | ExecutionException ex) {
                    view.refreshError(ex.getMessage());
                }
            }
        };
        worker.execute();
    }

    public void editTeacher(Teacher teacher) {
        SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                return teacherDAO.updateTeacher(teacher);
            }

            @Override
            protected void done() {
                try {
                    boolean isSuccess = get();
                    if (isSuccess) {
                        refreshTable();
                    }
                } catch (InterruptedException | ExecutionException ex) {
                    view.refreshError(ex.getMessage());
                }
            }
        };
        worker.execute();
    }

    public void deleteTeacher(int teacherId) {
        SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                return teacherDAO.deleteTeacher(teacherId);
            }

            @Override
            protected void done() {
                try {
                    boolean isSuccess = get();
                    if (isSuccess) {
                        refreshTable();
                    }
                } catch (InterruptedException | ExecutionException ex) {
                    view.refreshError(ex.getMessage());
                }
            }
        };
        worker.execute();
    }



    public Major getMajor(String name) {
        return majorDAO.getMajorId(name);
    }
    
}
