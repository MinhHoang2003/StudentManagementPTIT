/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import data.dao.MajorDAOImpl;
import data.dao.StudentDAO;
import data.model.Major;
import data.model.Student;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;
import screen.BaseView;
import screen.StudentManagementScreen;

/**
 *
 * @author PhamMinhHoang
 */
public class StudentController implements BaseController {

    private final StudentDAO studentDAO;
    private final BaseView<Student> view;
    private final MajorDAOImpl majorDAO;

    public StudentController(StudentDAO studentDAO, MajorDAOImpl majorDAO) {
        this.studentDAO = studentDAO;
        this.majorDAO = majorDAO;
        this.view = new StudentManagementScreen(this);
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
        SwingWorker<List<Student>, Void> worker = new SwingWorker<List<Student>, Void>() {
            @Override
            protected List<Student> doInBackground() throws Exception {
                return studentDAO.getStudents();
            }

            @Override
            protected void done() {
                try {
                    List<Student> teachers = get();
                    view.refreshTable(teachers);
                } catch (InterruptedException | ExecutionException ex) {
                    view.refreshError(ex.getMessage());
                }
            }
        };
        worker.execute();
    }

    public void addNewStudent(Student student) {
        SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                return studentDAO.addNewStudent(student);
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

    public void editStudent(Student student) {
        SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                return studentDAO.updateStudent(student);
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

    public void deleteStudent(String id) {
        SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                return studentDAO.deleteStudent(id);
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

    public String generateNewStudentId(String getYearStudyIn, Major major) throws SQLException, ClassNotFoundException {
        int idNum = studentDAO.generateNewId(major.getId());
        String idFormat = String.format("%03d", ++idNum);
        System.out.println(getYearStudyIn);
        StringBuilder studentId = new StringBuilder();
        studentId.append("B")
                .append(getYearStudyIn.substring(getYearStudyIn.length() - 2))
                .append(major.getPrefix())
                .append(idFormat);
        return studentId.toString();
    }

    public void getMajorName(DataLoadingListener<List<String>> listener) {
        SwingWorker<List<String>, Void> worker = new SwingWorker<List<String>, Void>() {
            @Override
            protected List<String> doInBackground() throws Exception {
                ArrayList<String> majors = new ArrayList();
                majorDAO.majorsCached.forEach((major) -> {
                    majors.add(major.getName());
                });
                return majors;
            }

            @Override
            protected void done() {
                try {
                    List<String> majors = get();
                    if (!majors.isEmpty()) {
                        listener.onGetDataSuccess(majors);
                    } else {
                        listener.onGetDataFailure("Majors is empty");
                    }
                } catch (InterruptedException | ExecutionException ex) {
                    listener.onGetDataFailure(ex.getMessage());
                    Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        worker.execute();
    }

    public Major getMajor(String name) {
        return majorDAO.getMajorId(name);
    }
}
