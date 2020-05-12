/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

import control.HomeController;
import control.LoginController;
import control.MarkController;
import control.StudentController;
import control.TeacherController;
import data.dao.AccountDAO;
import data.dao.AccountDAOImpl;
import data.dao.CourseDAO;
import data.dao.CourseDAOImpl;
import data.dao.MajorDAOImpl;
import data.dao.MarkDAO;
import data.dao.MarkDAOImpl;
import data.dao.StudentDAO;
import data.dao.StudentDAOImpl;
import data.dao.SubjectDAO;
import data.dao.SubjectDAOImpl;
import data.dao.TeacherDAO;
import data.dao.TeacherDAOImpl;
import data.model.Utils;

/**
 *
 * @author hoang
 */
public class Application implements LoginScreenListener, HomeViewListener {

    private final AccountDAO accountDAO;
    private final StudentDAO studentDAO;
    private final TeacherDAO teacherDAO;
    private final MajorDAOImpl majorDAOImpl;
    private final MarkDAO markDAO;
    private final CourseDAO courseDAO;
    private final SubjectDAO subjectDAO;

    private LoginController loginController;
    private HomeController homeController;
    private TeacherController teacherController;
    private StudentController studentController;
    private MarkController markController;

    public Application() {
        accountDAO = AccountDAOImpl.getInstance();
        studentDAO = StudentDAOImpl.getInstance();
        majorDAOImpl = MajorDAOImpl.getInstance();
        teacherDAO = TeacherDAOImpl.getInstance();
        markDAO = MarkDAOImpl.getInstance();
        courseDAO = CourseDAOImpl.getInstance();
        subjectDAO = SubjectDAOImpl.getInstance();
        Utils.setHashMap(majorDAOImpl.majorsCached);
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.startLoginScreen();
    }

    private void startLoginScreen() {
        loginController = new LoginController(accountDAO);
        loginController.show(true);
        loginController.setOnLoginScreenListener(this);
    }

    @Override
    public void onLoginComplete() {
        if (loginController != null) {
            loginController.show(false);
        }
        homeController = new HomeController(teacherDAO);
        homeController.show(true);
        homeController.setUpUser(Utils.teacherCached.getName());
        homeController.setHomeViewListener(this);
    }

    @Override
    public void onRequestTeacherManagerScreen() {
        if (teacherController == null) {
            teacherController = new TeacherController(teacherDAO, majorDAOImpl);
        }
        homeController.show(false);
        teacherController.show(true);
    }

    @Override
    public void onRequestStudentManagerScreen() {
        if (studentController == null) {
            studentController = new StudentController(studentDAO, majorDAOImpl);
        }
        homeController.show(false);
        studentController.show(true);
    }

    @Override
    public void onRequestMarkManagerScreen() {
        if (markController == null) {
            markController = new MarkController(courseDAO, markDAO, subjectDAO);
        }
        homeController.show(false);
        markController.show(true);
    }

    @Override
    public void onRequestSettingScreen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
