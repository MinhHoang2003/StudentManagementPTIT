/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import data.dao.MajorDAOImpl;
import data.dao.TeacherDAOImpl;
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
public class TeacherControllerTest {

    @Test
    public void testValidateNameField_is_empty() {
        System.out.println("testValidateNameField_is_empty");
        String name = "";
        TeacherController instance = new TeacherController(TeacherDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = false;
        boolean result = instance.validateNameField(name);
        assertEquals(expResult, result);
    }

    @Test
    public void testValidateNameField_is_null() {
        System.out.println("testValidateNameField_is_null");
        String name = null;
        TeacherController instance = new TeacherController(TeacherDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = false;
        boolean result = instance.validateNameField(name);
        assertEquals(expResult, result);
    }

    @Test
    public void testValidateNameField_is_not_fit_form() {
        System.out.println("testValidateNameField_is_not_fit_form");
        String name = "hoang$$$$";
        TeacherController instance = new TeacherController(TeacherDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = false;
        boolean result = instance.validateNameField(name);
        assertEquals(expResult, result);
    }

    @Test
    public void testValidateNameField() {
        System.out.println("testValidateNameField");
        String name = "Pham Hoang";
        TeacherController instance = new TeacherController(TeacherDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = true;
        boolean result = instance.validateNameField(name);
        assertEquals(expResult, result);
    }

    @Test
    public void test_address_is_null() {
        System.out.println("test_address_is_null");
        String address = null;
        TeacherController instance = new TeacherController(TeacherDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = false;
        boolean result = instance.validateAddress(address);
        assertEquals(expResult, result);
    }

    @Test
    public void test_address_is_empty() {
        System.out.println("test_address_is_empty");
        String address = "";
        TeacherController instance = new TeacherController(TeacherDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = false;
        boolean result = instance.validateAddress(address);
        assertEquals(expResult, result);
    }

    @Test
    public void test_address_is_not_true() {
        System.out.println("test_address_is_not_true");
        String address = "22-03-2001";
        TeacherController instance = new TeacherController(TeacherDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = false;
        boolean result = instance.validateAddress(address);
        assertEquals(expResult, result);
    }

    @Test
    public void test_address_is_true() {
        System.out.println("test_address_is_true");
        String address = "Ha Noi";
        TeacherController instance = new TeacherController(TeacherDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = true;
        boolean result = instance.validateAddress(address);
        assertEquals(expResult, result);
    }

    @Test
    public void test_date_is_null() {
        System.out.println("test_date_is_null");
        String date = null;
        TeacherController instance = new TeacherController(TeacherDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = false;
        boolean result = instance.validateDate(date);
        assertEquals(expResult, result);
    }

    @Test
    public void test_date_is_empty() {
        System.out.println("test_date_is_empty");
        String date = " ";
        TeacherController instance = new TeacherController(TeacherDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = false;
        boolean result = instance.validateDate(date);
        assertEquals(expResult, result);
    }

    @Test
    public void test_date_is_false() {
        System.out.println("test_date_is_false");
        String date = "22-09-2000";
        TeacherController instance = new TeacherController(TeacherDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = false;
        boolean result = instance.validateDate(date);
        assertEquals(expResult, result);
    }

    @Test
    public void test_date_is_true() {
        System.out.println("test_date_is_true");
        String date = "22/09/2000";
        TeacherController instance = new TeacherController(TeacherDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = true;
        boolean result = instance.validateDate(date);
        assertEquals(expResult, result);
    }

    @Test
    public void test_email_is_null() {
        System.out.println("test_email_is_null");
        String email = null;
        TeacherController instance = new TeacherController(TeacherDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = false;
        boolean result = instance.validateEmailForm(email);
        assertEquals(expResult, result);
    }

    @Test
    public void test_email_is_empty() {
        System.out.println("test_email_is_empty");
        String email = " ";
        TeacherController instance = new TeacherController(TeacherDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = false;
        boolean result = instance.validateEmailForm(email);
        assertEquals(expResult, result);
    }

    @Test
    public void test_email_is_wrong_domain_name() {
        System.out.println("test_email_is_wrong_domain_name");
        String email = "hoang@gmail.com";
        TeacherController instance = new TeacherController(TeacherDAOImpl.getInstance(), MajorDAOImpl.getInstance());

        boolean expResult = false;
        boolean result = instance.validateEmailForm(email);
        assertEquals(expResult, result);
    }

    @Test
    public void test_email_is_false() {
        System.out.println("test_email_is_false");
        String email = "hoang$$$$@ptit.edu.vn";
        TeacherController instance = new TeacherController(TeacherDAOImpl.getInstance(), MajorDAOImpl.getInstance());

        boolean expResult = false;
        boolean result = instance.validateEmailForm(email);
        assertEquals(expResult, result);
    }

    @Test
    public void test_email_is_true() {
        System.out.println("test_email_is_true");
        String email = "hoang@ptit.edu.vn";
        TeacherController instance = new TeacherController(TeacherDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = true;
        boolean result = instance.validateEmailForm(email);
        assertEquals(expResult, result);
    }

}
