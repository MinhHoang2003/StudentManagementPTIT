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
public class StudentTestAddFail {

    /**
     * Test of addNewStudent method, of class StudentDAOImpl.
     */
    @Test
    public void testAddNewStudent_false() throws Exception {
        System.out.println("testAddNewStudent_false");
        Connection conn = ConnectionUtil.getConnection();
        conn.setAutoCommit(false);
        Student student = new Student(1, "2020", "D16DCCN06", "B20DCCN005", "PH", "ph@ptit.edu.vn", "Ha Noi", "20/09/1998");
        StudentDAOImpl instance = new StudentDAOImpl();
        boolean expResult = false;
        boolean result = instance.addNewStudent(conn, student);
        assertEquals(expResult, result);
        conn.rollback();
        conn.close();
    }
}
