/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import data.dao.MajorDAOImpl;
import data.dao.StudentDAOImpl;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PhamMinhHoang
 */
public class StudentControllerTest {

    /**
     * Test of validateNameField method, of class StudentController.
     */
    @Test
    public void testValidateNameField_name_is_empty() {
        System.out.println("testValidateNameField_name_is_empty");
        String name = " ";
        StudentController instance = new StudentController(StudentDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = false;
        boolean result = instance.validateNameField(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateNameField method, of class StudentController.
     */
    @Test
    public void testValidateNameField_name_has_special_char() {
        System.out.println("testValidateNameField_name_has_special_char");
        String name = "test%%%%%";
        StudentController instance = new StudentController(StudentDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = false;
        boolean result = instance.validateNameField(name);
        assertEquals(expResult, result);
    }

    @Test
    public void testValidateNameField_name_is_correct() {
        System.out.println("testValidateNameField_name_is_correct");
        String name = "Name Test";
        StudentController instance = new StudentController(StudentDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = true;
        boolean result = instance.validateNameField(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateAddress method, of class StudentController.
     */
    @Test
    public void testValidateAddress_address_is_empty() {
        System.out.println("testValidateAddress_address_is_empty");
        String address = " ";
        StudentController instance = new StudentController(StudentDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = false;
        boolean result = instance.validateAddress(address);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateAddress method, of class StudentController.
     */
    @Test
    public void testValidateAddress_address_is_correct() {
        System.out.println("testValidateAddress_address_is_correct");
        String address = "Ha Noi";
        StudentController instance = new StudentController(StudentDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = true;
        boolean result = instance.validateAddress(address);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateDate method, of class StudentController.
     */
    @Test
    public void testValidateDate_is_empty() {
        System.out.println("testValidateDate_is_empty");
        String date = " ";
        StudentController instance = new StudentController(StudentDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = false;
        boolean result = instance.validateDate(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateDate method, of class StudentController.
     */
    @Test
    public void testValidateDate_correct() {
        System.out.println("testValidateDate_correct");
        String date = "20/04/2003";
        StudentController instance = new StudentController(StudentDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = true;
        boolean result = instance.validateDate(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateDate method, of class StudentController.
     */
    @Test
    public void testValidateDate_has_not_correct() {
        System.out.println("testValidateDate_has_not_correct");
        String date = "200/04/2003";
        StudentController instance = new StudentController(StudentDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = false;
        boolean result = instance.validateDate(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateClassName method, of class StudentController.
     */
    @Test
    public void testValidateClassName_is_empty() {
        System.out.println("testValidateClassName_is_empty");
        String className = " ";
        StudentController instance = new StudentController(StudentDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = false;
        boolean result = instance.validateClassName(className);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateClassName method, of class StudentController.
     */
    @Test
    public void testValidateClassName_has_special_char() {
        System.out.println("testValidateClassName_is_empty");
        String className = "D15%%%";
        StudentController instance = new StudentController(StudentDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = false;
        boolean result = instance.validateClassName(className);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateClassName method, of class StudentController.
     */
    @Test
    public void testValidateClassName_correct() {
        System.out.println("testValidateClassName_is_empty");
        String className = "D15DCCN01";
        StudentController instance = new StudentController(StudentDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = true;
        boolean result = instance.validateClassName(className);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateYear method, of class StudentController.
     */
    @Test
    public void testValidateYear_is_empty() {
        System.out.println("testValidateYear_is_empty");
        String year = " ";
        StudentController instance = new StudentController(StudentDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = false;
        boolean result = instance.validateYear(year);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateYear method, of class StudentController.
     */
    @Test
    public void testValidateYear_is_not_number() {
        System.out.println("testValidateYear_is_not_number");
        String year = "201aa";
        StudentController instance = new StudentController(StudentDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = false;
        boolean result = instance.validateYear(year);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateYear method, of class StudentController.
     */
    @Test
    public void testValidateYear_not_correct() {
        System.out.println("testValidateYear_not_correct");
        String year = "2030";
        StudentController instance = new StudentController(StudentDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = false;
        boolean result = instance.validateYear(year);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateYear method, of class StudentController.
     */
    @Test
    public void testValidateYear_correct() {
        System.out.println("testValidateYear_correct");
        String year = "2016";
        StudentController instance = new StudentController(StudentDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = true;
        boolean result = instance.validateYear(year);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateEmailForm method, of class StudentController.
     */
    @Test
    public void testValidateEmailForm_is_empty() {
        System.out.println("testValidateEmailForm_is_empty");
        String email = " ";
        StudentController instance = new StudentController(StudentDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = false;
        boolean result = instance.validateEmailForm(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateEmailForm method, of class StudentController.
     */
    @Test
    public void testValidateEmailForm_wrong_domain() {
        System.out.println("testValidateEmailForm_wrong_domain");
        String email = "test@gmail.com";
        StudentController instance = new StudentController(StudentDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = false;
        boolean result = instance.validateEmailForm(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateEmailForm method, of class StudentController.
     */
    @Test
    public void testValidateEmailForm_has_special_char() {
        System.out.println("testValidateEmailForm_has_special_char");
        String email = "test$$$@ptit.edu.vn";
        StudentController instance = new StudentController(StudentDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = false;
        boolean result = instance.validateEmailForm(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateEmailForm method, of class StudentController.
     */
    @Test
    public void testValidateEmailForm_correct() {
        System.out.println("testValidateEmailForm_correct");
        String email = "test@ptit.edu.vn";
        StudentController instance = new StudentController(StudentDAOImpl.getInstance(), MajorDAOImpl.getInstance());
        boolean expResult = true;
        boolean result = instance.validateEmailForm(email);
        assertEquals(expResult, result);
    }

}
