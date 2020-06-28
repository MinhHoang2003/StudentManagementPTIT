/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.model.ConnectionUtil;
import data.model.Student;
import java.sql.Connection;
import java.util.ArrayList;
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
public class StudentDAOImplTest {

    /**
     * Test of getInstance method, of class StudentDAOImpl.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        StudentDAOImpl expResult = StudentDAOImpl.getInstance();
        StudentDAOImpl result = StudentDAOImpl.getInstance();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStudents method, of class StudentDAOImpl.
     */
    @Test
    public void testGetStudents() throws Exception {
        System.out.println("testGetStudents");
        StudentDAOImpl instance = new StudentDAOImpl();
        Student expResult = new Student(1, "2020", "D16DCCN06", "B20DCCN002", "Lu Tuan Nghia", "nghialt@ptit.edu.vn", "Hà Giang", "04/04/1998");
        Student result = instance.getStudents().get(0);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getMajor(), result.getMajor());
        assertEquals(expResult.getAddress(), result.getAddress());
        assertEquals(expResult.getDateOfBirth(), result.getDateOfBirth());
        assertEquals(expResult.getEmail(), result.getEmail());
        assertEquals(expResult.getClassName(), result.getClassName());
    }

    /**
     * Test of getStudentById method, of class StudentDAOImpl.
     */
    @Test
    public void testGetStudentById() throws Exception {
        System.out.println("testGetStudentById");
        String id = "B20DCCN001";
        StudentDAOImpl instance = new StudentDAOImpl();
        Student expResult = new Student(1, "2020", "D16DCCN06", "B20DCCN001", "Hoang Ngoc Khanh", "khanhhn@ptit.edu.vn", "Hà Nội", "20/09/1998");
        Student result = instance.getStudentById(id);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getMajor(), result.getMajor());
        assertEquals(expResult.getAddress(), result.getAddress());
        assertEquals(expResult.getDateOfBirth(), result.getDateOfBirth());
        assertEquals(expResult.getEmail(), result.getEmail());
        assertEquals(expResult.getClassName(), result.getClassName());
    }

    @Test
    public void testGetStudentById_false() throws Exception {
        System.out.println("testGetStudentById");
        String id = "B20DCCN100";
        StudentDAOImpl instance = new StudentDAOImpl();
        Student result = instance.getStudentById(id);
        assertNull(result);
    }



    /**
     * Test of updateStudent method, of class StudentDAOImpl.
     */
    @Test
    public void testUpdateStudent() throws Exception {
        System.out.println("testUpdateStudent");
        Connection conn = ConnectionUtil.getConnection();
        conn.setAutoCommit(false);
        Student st = new Student(2, "2020", "D16DCCN06", "B20DCCN001", "Hoang Ngoc Khanh", "khanhhn@ptit.edu.vn", "Hà Nội", "20/09/1998");
        StudentDAOImpl instance = new StudentDAOImpl();
        boolean expResult = true;
        boolean result = instance.updateStudent(conn, st);
        assertEquals(expResult, result);
        conn.rollback();
        conn.close();
    }

    /**
     * Test of updateStudent method, of class StudentDAOImpl.
     */
    @Test
    public void testUpdateStudent_fail() throws Exception {
        System.out.println("testUpdateStudent_fail");
        Connection conn = ConnectionUtil.getConnection();
        conn.setAutoCommit(false);
        Student st = new Student(2, "2020", "D16DCCN06", "B20DCCN001", "Hoang Ngoc Khanh", "nghialt@ptit.edu.vn", "Hà Nội", "20/09/1998");
        StudentDAOImpl instance = new StudentDAOImpl();
        boolean expResult = false;
        boolean result = instance.updateStudent(conn, st);
        assertEquals(expResult, result);
        conn.rollback();
        conn.close();
    }

    /**
     * Test of deleteStudent method, of class StudentDAOImpl.
     */
    @Test
    public void testDeleteStudent() throws Exception {
        System.out.println("testDeleteStudent");
        Connection conn = ConnectionUtil.getConnection();
        conn.setAutoCommit(false);
        String id = "B20DCCN001";
        StudentDAOImpl instance = new StudentDAOImpl();
        boolean expResult = true;
        boolean result = instance.deleteStudent(conn, id);
        assertEquals(expResult, result);
        conn.rollback();
        conn.close();
    }

    /**
     * Test of deleteStudent method, of class StudentDAOImpl.
     */
    @Test
    public void testDeleteStudent_fail() throws Exception {
        System.out.println("testDeleteStudent_fail");
        Connection conn = ConnectionUtil.getConnection();
        conn.setAutoCommit(false);
        String id = "B20DCCN100";
        StudentDAOImpl instance = new StudentDAOImpl();
        boolean expResult = false;
        boolean result = instance.deleteStudent(conn, id);
        assertEquals(expResult, result);
        conn.rollback();
        conn.close();
    }

    /**
     * Test of generateNewId method, of class StudentDAOImpl.
     */
    @Test
    public void testGenerateNewId() throws Exception {
        System.out.println("testGenerateNewId");
        Connection conn = ConnectionUtil.getConnection();
        conn.setAutoCommit(false);
        int maChuyenNganh = 1;
        StudentDAOImpl instance = new StudentDAOImpl();
        int expResult = 58;
        int result = instance.generateNewId(conn, maChuyenNganh);
        assertEquals(expResult, result);
        conn.rollback();
        conn.close();
    }

}
