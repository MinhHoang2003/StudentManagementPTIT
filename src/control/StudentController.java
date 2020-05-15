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
import data.model.Utils;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
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
                    view.showErrorMessage(ex.getMessage());
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
                    view.showErrorMessage(ex.getMessage());
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
                    view.showErrorMessage(ex.getMessage());
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
                    view.showErrorMessage(ex.getMessage());
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

    public boolean validateNameField(String name) {
        if (name == null || name.isEmpty()) {
            view.showErrorMessage("Trường tên không được để trống");
            return false;
        } else if (!Utils.validateName(name)) {
            view.showErrorMessage("Tên chứa ký tự đặc biệt");
        }
        return true;
    }

    public boolean validateAddress(String address) {
        if (address == null || address.isEmpty()) {
            view.showErrorMessage("Địa chỉ không được để trống");
            return false;
        }
        return true;
    }

    public boolean validateDate(String date) {
        if (date == null || date.isEmpty()) {
            view.showErrorMessage("Ngày sinh không được để trống");
            return false;
        } else if (!Utils.validateDate(date)) {
            view.showErrorMessage("Ngày sinh không đúng định dạng");
            return false;
        }
        return true;
    }

    public boolean validateClassName(String className) {
        if (className == null || className.isEmpty()) {
            view.showErrorMessage("Tên lớp không được để trống");
            return false;
        } else if (!Utils.validateText(className)) {
            view.showErrorMessage("Tên lớp có chứa ký tự đặc biệt");
            return false;
        }
        return true;
    }

    public boolean validateYear(String year) {
        if (year == null || year.isEmpty()) {
            view.showErrorMessage("Năm học không được để trống");
            return false;
        } else if (!Utils.validateNumber(year)) {
            view.showErrorMessage("Năm học sai định dạng");
            return false;
        } else {
            Calendar cal = Calendar.getInstance();
            int yearParser = Integer.parseInt(year);
            int yearNow = cal.get(Calendar.YEAR);
            if (yearParser > yearNow) {
                view.showErrorMessage("Năm nhập vào vượt quá thời điểm hiện tại");
                return false;
            }
        }
        return true;
    }

    @Override
    public void onWindowClosed(WindowAdapter windowAdapter) {
        if (view instanceof Frame) {
            ((Frame) view).addWindowListener(windowAdapter);
        }
    }

    @Override
    public void showConfirmCloseMessage() {
        view.showConfirmCloseMessage();
    }
}
