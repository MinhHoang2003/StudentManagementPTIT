/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PhamMinhHoang
 */
public class UtilsTest {

    /**
     * Test of setHashMap method, of class Utils.
     */
    @Test
    public void testSetHashMap() {
        System.out.println("setHashMap");
        List<Major> majors = new ArrayList<>();
        majors.add(new Major(0, "test", "TEST"));
        Utils.setHashMap(majors);
        assertEquals(Utils.majors.get(0), "test");

    }

    /**
     * Test of validateText method, of class Utils.
     */
    @Test
    public void testValidateText_false() {
        System.out.println("validateText");
        String name = "%%";
        boolean expResult = false;
        boolean result = Utils.validateText(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateText method, of class Utils.
     */
    @Test
    public void testValidateText_true() {
        System.out.println("validateText");
        String name = "Text";
        boolean expResult = true;
        boolean result = Utils.validateText(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateNumber method, of class Utils.
     */
    @Test
    public void testValidateNumber_false() {
        System.out.println("validateNumber");
        String number = "adb";
        boolean expResult = false;
        boolean result = Utils.validateNumber(number);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateNumber method, of class Utils.
     */
    @Test
    public void testValidateNumber_true() {
        System.out.println("validateNumber");
        String number = "1234";
        boolean expResult = true;
        boolean result = Utils.validateNumber(number);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateName method, of class Utils.
     */
    @Test
    public void testValidateName_false() {
        System.out.println("validateName");
        String name = "Nam 123";
        boolean expResult = false;
        boolean result = Utils.validateName(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateName method, of class Utils.
     */
    @Test
    public void testValidateName_true() {
        System.out.println("validateName");
        String name = "Nam";
        boolean expResult = true;
        boolean result = Utils.validateName(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateDate method, of class Utils.
     */
    @Test
    public void testValidateDate_is_empty() {
        System.out.println("validateDate");
        String strDate = " ";
        boolean expResult = false;
        boolean result = Utils.validateDate(strDate);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateDate method, of class Utils.
     */
    @Test
    public void testValidateDate_is_false() {
        System.out.println("validateDate");
        String strDate = "222-33-2003";
        boolean expResult = false;
        boolean result = Utils.validateDate(strDate);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateDate method, of class Utils.
     */
    @Test
    public void testValidateDate_is_true() {
        System.out.println("validateDate");
        String strDate = "22/3/2003";
        boolean expResult = true;
        boolean result = Utils.validateDate(strDate);
        assertEquals(expResult, result);
    }

}
