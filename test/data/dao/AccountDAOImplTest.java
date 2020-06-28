/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import com.mysql.cj.conf.ConnectionUrl;
import data.model.ConnectionUtil;
import data.model.Teacher;
import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PhamMinhHoang
 */
public class AccountDAOImplTest {

    public AccountDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class AccountDAOImpl.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        AccountDAOImpl expResult = AccountDAOImpl.getInstance();
        AccountDAOImpl result = AccountDAOImpl.getInstance();
        assertEquals(expResult, result);
    }

    /**
     * Test of loginTeacherAccount method, of class AccountDAOImpl.
     */
    @Test
    public void testLoginTeacherAccount_success() throws Exception {
        System.out.println("testLoginTeacherAccount_success");
        String pass = "06071989";
        AccountDAOImpl instance = new AccountDAOImpl();
        Teacher expResult = new Teacher(4, "Tien sy", 1, "Hoang Minh Anh", "anhhm@ptit.edu.vn", "Quang Ninh", "06/07/1989");
        Teacher result = instance.loginTeacherAccount(expResult.getEmail(), pass);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getEmail(), result.getEmail());
        assertEquals(expResult.getAddress(), result.getAddress());
        assertEquals(expResult.getDateOfBirth(), result.getDateOfBirth());
        assertEquals(expResult.getDegree(), result.getDegree());

    }

    @Test
    public void testLoginTeacherAccount_false() throws Exception {
        System.out.println("testLoginTeacherAccount_false");
        String pass = "11111111";
        String email = "anhha@ptit.edu.vn";
        AccountDAOImpl instance = new AccountDAOImpl();
        Teacher result = instance.loginTeacherAccount(email, pass);
        assertNull(result);
    }

    /**
     * Test of loginAdmin method, of class AccountDAOImpl.
     */
    @Test
    public void testLoginAdmin_success() throws Exception {
        System.out.println("loginAdmin");
        String email = "admin@ptit.edu.vn";
        String pass = "admin";
        AccountDAOImpl instance = new AccountDAOImpl();
        boolean expResult = true;
        boolean result = instance.loginAdmin(email, pass);
        assertEquals(expResult, result);
    }

    @Test
    public void testLoginAdmin_false() throws Exception {
        System.out.println("testLoginAdmin_false");
        String email = "admin@ptit.edu.vn";
        String pass = "adm222in";
        AccountDAOImpl instance = new AccountDAOImpl();
        boolean expResult = false;
        boolean result = instance.loginAdmin(email, pass);
        assertEquals(expResult, result);
    }

}
