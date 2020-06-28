/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import data.dao.AccountDAOImpl;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PhamMinhHoang
 */
public class LoginControllerTest {

    @Test
    //de trong email admin
    public void testLogin_email_empty() throws SQLException, ClassNotFoundException {
        System.out.println("testLogin_email_empty");
        String email = " ";
        boolean expResult = false;
        LoginController l = new LoginController(AccountDAOImpl.getInstance());
        boolean result = l.validateEmailForm(email);
        assertEquals(expResult, result);
    }

    @Test
    //de trong password admin
    public void testLogin_pass_empty() throws SQLException, ClassNotFoundException {
        System.out.println("testLogin_pass_empty");
        String pass = " ";
        boolean expResult = false;
        LoginController l = new LoginController(AccountDAOImpl.getInstance());
        boolean result = l.validatePasswordField(pass);
        assertEquals(expResult, result);
    }

    @Test
    //de trong password admin
    public void testLogin_pass_has_special_char() throws SQLException, ClassNotFoundException {
        System.out.println("testLogin_pass_has_special_char");
        String pass = "###";
        boolean expResult = false;
        LoginController l = new LoginController(AccountDAOImpl.getInstance());
        boolean result = l.validatePasswordField(pass);
        assertEquals(expResult, result);
    }

    @Test
    //de trong password admin
    public void testLogin_pass_true() throws SQLException, ClassNotFoundException {
        System.out.println("testLogin_pass_true");
        String pass = "test";
        boolean expResult = true;
        LoginController l = new LoginController(AccountDAOImpl.getInstance());
        boolean result = l.validatePasswordField(pass);
        assertEquals(expResult, result);
    }

    @Test
    //nhap sai dinh dang email admin
    public void testLogin_email_wrong_domain() throws SQLException, ClassNotFoundException {
        System.out.println("testLogin_email_wrong_domain");
        String email = "admin@gmail.com";
        boolean expResult = false;
        LoginController l = new LoginController(AccountDAOImpl.getInstance());
        boolean result = l.validateEmailForm(email);
        assertEquals(expResult, result);
    }

    @Test
    //nhap email admin co ky tu dac biet
    public void testLogin_email_has_special_char() throws SQLException, ClassNotFoundException {
        System.out.println("testLogin_email_has_special_char");
        String email = "test&&@ptit.edu.vn";
        boolean expResult = false;
        LoginController l = new LoginController(AccountDAOImpl.getInstance());
        boolean result = l.validateEmailForm(email);
        assertEquals(expResult, result);
    }
}
