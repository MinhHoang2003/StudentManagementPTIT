/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import data.dao.AccountDAO;
import data.model.AccountType;
import data.model.Teacher;
import data.model.Utils;
import java.util.concurrent.ExecutionException;
import javax.swing.SwingWorker;
import screen.LoginScreen;
import screen.LoginScreenListener;

/**
 *
 * @author PhamMinhHoang
 */
public class LoginController {

    private final AccountDAO accountDAO;
    private final LoginScreen view;
    private LoginScreenListener loginScreenListener = null;

    public LoginController(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
        view = new LoginScreen(this);
    }

    public void show(boolean isVisible) {
        view.setVisible(isVisible);
    }

    public void loginAccount(String email, String password) {
        SwingWorker<Teacher, Void> worker = new SwingWorker<Teacher, Void>() {
            @Override
            protected Teacher doInBackground() throws Exception {
                return accountDAO.loginTeacherAccount(email, password);
            }

            @Override
            protected void done() {
                try {
                    Teacher teacher = get();
                    if (teacher != null) {
                        Utils.teacherCached = teacher;
                        Utils.currentAccountType = AccountType.TEACHER;
                        onLoginComplete();
                    } else {
                        view.notifyErrorMessage("Đăng nhập không thành công, email hoặc pass không đúng");
                    }
                } catch (InterruptedException | ExecutionException ex) {
                    view.notifyErrorMessage("Đăng nhập không thành công, email hoặc pass không đúng");
                }
            }
        };
        worker.execute();

    }

    public void setOnLoginScreenListener(LoginScreenListener loginScreenListener) {
        this.loginScreenListener = loginScreenListener;
    }

    private void onLoginComplete() {
        if (this.loginScreenListener != null) {
            loginScreenListener.onLoginComplete();
        }
    }

    public boolean validateEmailForm(String email) {
        if (email.isEmpty()) {
            view.notifyErrorMessage("Email không được để trống");
            return false;
        } else if (!email.endsWith(Utils.EMAIL_SUFFIX)) {
            view.notifyErrorMessage("Email sai tên miền, cần tên miền của học viện: @ptit.edu.vn");
            return false;
        }
        String emailPreffix = email.replaceFirst(Utils.EMAIL_SUFFIX, "");
        System.out.println("login : " + emailPreffix);
        if (!Utils.validateText(emailPreffix)) {
            view.notifyErrorMessage("Email sai quy định : có chứa ký tự đặc biệt");
            return false;
        }
        return true;
    }

    public boolean validatePasswordField(String pass) {
        if (pass.isEmpty()) {
            view.notifyErrorMessage("Password không được để trống");
        } else if (!Utils.validateText(pass)) {
            view.notifyErrorMessage("Password sai quy định : có chứa ký tự đặc biệt");
            return false;
        }
        return true;
    }

    public void loginAmin(String email, String pass) {
        SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                return accountDAO.loginAdmin(email, pass);
            }

            @Override
            protected void done() {
                try {
                    Boolean result = get();
                    if (result) {
                        Utils.currentAccountType = AccountType.ADMIN;
                        onLoginComplete();
                    } else {
                        view.notifyErrorMessage("Đăng nhập không thành công, email hoặc pass không đúng");
                    }
                } catch (InterruptedException | ExecutionException ex) {
                    view.notifyErrorMessage("Đăng nhập không thành công, email hoặc pass không đúng");
                }
            }
        };
        worker.execute();
    }

}
