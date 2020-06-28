/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.model.ConnectionUtil;
import data.model.Student;
import java.sql.Connection;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author PhamMinhHoang
 */
public class StudentDAOTestAdd {

    /**
     * Test of addNewStudent method, of class StudentDAOImpl.
     */
    @Test
    public void testAddNewStudent() throws Exception {
        System.out.println("testAddNewStudent");
        Connection conn = ConnectionUtil.getConnection();
        conn.setAutoCommit(false);
        Student student = new Student(1, "2020", "B20DCCN111", "B20CNTT04", "PH", "ph@ptit.edu.vn", "Ha Noi", "20/09/1998");
        StudentDAOImpl instance = new StudentDAOImpl();
        boolean expResult = true;
        boolean result = instance.addNewStudent(conn, student);
        assertEquals(expResult, result);
        conn.rollback();
        conn.close();
    }
}
