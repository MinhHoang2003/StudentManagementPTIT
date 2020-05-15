/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import data.dao.TeacherDAO;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import screen.HomeView;
import screen.HomeViewListener;

/**
 *
 * @author PhamMinhHoang
 */
public class HomeController {

    private final HomeView view;
    private HomeViewListener homeViewListener;
    private final TeacherDAO teacherDAO;

    public HomeController(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
        view = new HomeView(this);
    }

    public void show(boolean isVisible) {
        view.setVisible(isVisible);
    }

    public void setHomeViewListener(HomeViewListener homeViewListener) {
        if (homeViewListener != null) {
            this.homeViewListener = homeViewListener;
        }
    }

    public void requestTeacherManagerScreen() {
        if (homeViewListener != null) {
            homeViewListener.onRequestTeacherManagerScreen();
        }
    }

    public void requestStudentManagerScreen() {
        if (homeViewListener != null) {
            homeViewListener.onRequestStudentManagerScreen();
        }
    }

    public void requestMarkManagerScreen() {
        if (homeViewListener != null) {
            homeViewListener.onRequestMarkManagerScreen();
        }
    }

    public void requentSettingScreen() {
        if (homeViewListener != null) {
            homeViewListener.onRequestSettingScreen();
        }
    }

    public void setUpUser(String userName) {
        view.setUpUserName(userName);
    }

    public void showCloseConfirmMessage() {
        view.showClosedConfirmMessage();
    }

    public void onHomeScreenClosed(WindowAdapter adapter) {
        if (view instanceof Frame) {
            ((Frame) view).addWindowListener(adapter);
        }
    }
}
