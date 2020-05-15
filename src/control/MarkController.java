/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import data.dao.CourseDAO;
import data.dao.MarkDAO;
import data.dao.SubjectDAO;
import data.model.Course;
import data.model.Mark;
import data.model.Subject;
import data.util.MarkExportExcelUtil;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;
import screen.MarkManagementScreen;
import screen.MarkManagementView;

/**
 *
 * @author PhamMinhHoang
 */
public class MarkController implements BaseController {

    private final CourseDAO courseDAO;
    private final MarkDAO markDAO;
    private final SubjectDAO subjectDAO;
    private final MarkManagementView view;
    private List<Subject> cachedSubjects = null;

    public MarkController(CourseDAO courseDAO, MarkDAO markDAO, SubjectDAO subjectDAO) {
        this.courseDAO = courseDAO;
        this.markDAO = markDAO;
        this.subjectDAO = subjectDAO;
        view = new MarkManagementScreen(this);
    }

    @Override
    public void show(boolean isVisible) {
        view.setVisible(isVisible);
        if (isVisible) {
            getSubjectsNameByTeacherId();
//            refreshTable();
        }
    }

    @Override
    public void refreshTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void getSubjectsNameByTeacherId() {
        SwingWorker<List<String>, Void> worker = new SwingWorker<List<String>, Void>() {
            @Override
            protected List<String> doInBackground() throws Exception {
                List<Subject> subjects = subjectDAO.getSubjectsByTeacher(1);
                cachedSubjects = subjects;
                ArrayList<String> subjectsName = new ArrayList<>();
                subjects.forEach((subject) -> {
                    subjectsName.add(subject.getName());
                });
                return subjectsName;
            }

            @Override
            protected void done() {
                try {
                    List<String> subjectsName = get();
                    view.showSubjectListOfTeacher(subjectsName);
                } catch (InterruptedException | ExecutionException ex) {
                    view.showErrorMessage(ex.getMessage());
                }
            }
        };
        worker.execute();
    }

    private int getSubjectIdFromName(String name) {
        if (name.equals("None")) {
            System.out.println("This name not support");
            return -1;
        }
        for (Subject subject : cachedSubjects) {
            if (subject.getName().equals(name)) {
                return subject.getId();
            }
        }
        return -1;
    }

    public void getCoursesIdByTeacherId(String subjectName) {
        SwingWorker<List<String>, Void> worker = new SwingWorker<List<String>, Void>() {
            @Override
            protected List<String> doInBackground() throws Exception {
                int subjectId = getSubjectIdFromName(subjectName);
                if (subjectId == -1) {
                    throw new Exception("Khong the tim thay mon hoc nao");
                }
                List<Course> courses = courseDAO.getCourseByTeacher(1, subjectId);
                ArrayList<String> coursesId = new ArrayList<>();
                courses.forEach((course) -> {
                    coursesId.add(course.getClassId() + " ");
                });
                return coursesId;
            }

            @Override
            protected void done() {
                try {
                    List<String> coursesId = get();
                    view.showCoursesOfTeacher(coursesId);
                } catch (InterruptedException | ExecutionException ex) {
                    view.showErrorMessage(ex.getMessage());
                }
            }
        };
        worker.execute();
    }

    public void getMarkAfterSelected(int courseId) {
        SwingWorker<List<Mark>, Void> worker = new SwingWorker<List<Mark>, Void>() {
            @Override
            protected List<Mark> doInBackground() throws Exception {
                return markDAO.getMarksOfClass(courseId);
            }

            @Override
            protected void done() {
                try {
                    List<Mark> marks = get();
                    view.refreshTable(marks);
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(MarkController.class.getName()).log(Level.SEVERE, null, ex);
                    view.showError(ex.getMessage());
                }
            }
        };
        worker.execute();
    }

    public void exportMarkToExcelFile(String fileOutputPath) {
        if (!fileOutputPath.toLowerCase().endsWith(".xls")) {
            fileOutputPath = fileOutputPath + ".xls";
        }
        try {
            MarkExportExcelUtil.exportToExcelFile(fileOutputPath);
        } catch (IOException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MarkManagementScreen.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getMessage());
        }
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
