/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.model.ConnectionUtil;
import data.model.Teacher;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PhamMinhHoang
 */
public class TeacherDAOImplTest {

    /**
     * Test of getInstance method, of class TeacherDAOImpl.
     */
    @Test
    public void testGetInstanceNotNull() {
        System.out.println("getInstanceNotNull");
        TeacherDAOImpl expResult = null;
        TeacherDAOImpl result = TeacherDAOImpl.getInstance();
        assertNotSame(expResult, result);
    }

    @Test
    public void testGetInstanceIsTheSame() {
        System.out.println("testGetInstanceIsTheSame");
        TeacherDAOImpl expResult = TeacherDAOImpl.getInstance();
        TeacherDAOImpl result = TeacherDAOImpl.getInstance();
        assertSame(expResult, result);
    }

    /**
     * Test of getTeachers method, of class TeacherDAOImpl.
     */
    @Test
    public void testGetTeachers() throws Exception {
        System.out.println("getTeachers");
        TeacherDAOImpl instance = new TeacherDAOImpl();
        List<Teacher> expectResult = new ArrayList<>();
        expectResult.add(new Teacher(4, "Tien sy", 1, "Hoang Minh Anh", "anhhm@ptit.edu.vn", "Quang Ninh", "06/07/1989"));
        expectResult.add(new Teacher(3, "Thac sy", 2, "Nguyen Duy Khang", "khangnd@ptit.edu.vn", "Ha Nam", "20/09/1974"));
        expectResult.add(new Teacher(3, "Thac sy", 5, "Pham Anh Van", "vanpa@ptit.edu.vn", "Hung Yen", "03/02/1988"));
        expectResult.add(new Teacher(4, "Tien sy", 17, "Hoang Minh Anh", "anhha@ptit.edu.vn", "Quang Ninh", "06/07/1989"));

        ArrayList<Teacher> result = instance.getTeachers();
        assertEquals(expectResult.size(), result.size());
        for (int i = 0; i < expectResult.size(); i++) {
            assertEquals(expectResult.get(i).getId(), result.get(i).getId());
            assertEquals(expectResult.get(i).getMajor(), result.get(i).getMajor());
            assertEquals(expectResult.get(i).getName(), result.get(i).getName());
            assertEquals(expectResult.get(i).getDegree(), result.get(i).getDegree());
            assertEquals(expectResult.get(i).getEmail(), result.get(i).getEmail());
            assertEquals(expectResult.get(i).getDateOfBirth(), result.get(i).getDateOfBirth());
            assertEquals(expectResult.get(i).getAddress(), result.get(i).getAddress());
        }
    }

    /**
     * Test of getTeacherById method, of class TeacherDAOImpl.
     */
    @Test
    public void testGetTeacherById() throws Exception {
        System.out.println("getTeacherById");
        TeacherDAOImpl instance = new TeacherDAOImpl();
        Teacher expResult = new Teacher(4, "Tien sy", 1, "Hoang Minh Anh", "anhhm@ptit.edu.vn", "Quang Ninh", "06/07/1989");
        Teacher result = instance.getTeacherById(expResult.getId());
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getMajor(), result.getMajor());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getDegree(), result.getDegree());
        assertEquals(expResult.getEmail(), result.getEmail());
        assertEquals(expResult.getDateOfBirth(), result.getDateOfBirth());
        assertEquals(expResult.getAddress(), result.getAddress());
    }

    /**
     * Test of getTeacherByEmail method, of class TeacherDAOImpl.
     */
    @Test
    public void testGetTeacherByEmail() throws Exception {
        System.out.println("getTeacherByEmail");
        TeacherDAOImpl instance = new TeacherDAOImpl();
        Teacher expResult = new Teacher(4, "Tien sy", 1, "Hoang Minh Anh", "anhhm@ptit.edu.vn", "Quang Ninh", "06/07/1989");
        Teacher result = instance.getTeacherByEmail(expResult.getEmail());
        assertEquals(expResult.getId(), result.getId());
    }

    @Test
    public void testUpdateTeacherFail() throws SQLException, ClassNotFoundException {
        System.out.println("testUpdateTeacherFail");
        Connection conn = ConnectionUtil.getConnection();
        conn.setAutoCommit(false);
        TeacherDAOImpl instance = new TeacherDAOImpl();
        Teacher expResult = new Teacher(4, "Tien sy", 20, "Hoang Minh Anh", "anhhm@ptit.edu.vn", "Quang Ninh", "06/07/1989");
        boolean result = instance.updateTeacher(conn, expResult);
        assertEquals(false, result);
        conn.rollback();
        conn.close();
    }

    @Test
    public void testUpdateTeacherSuccess() throws SQLException, ClassNotFoundException {
        System.out.println("getTeacherByEmail");
        Connection conn = ConnectionUtil.getConnection();
        conn.setAutoCommit(false);
        TeacherDAOImpl instance = new TeacherDAOImpl();
        Teacher expResult = new Teacher(4, "Tien sy", 17, "Hoang Minh Anh", "anhha@ptit.edu.vn", "Quang Ninh", "06/07/1989");
        boolean result = instance.updateTeacher(conn, expResult);
        assertEquals(true, result);
        conn.rollback();
        conn.close();
    }

    @Test
    public void testDeleteTeacher_success() throws SQLException, ClassNotFoundException {
        System.out.println("testDeleteTeacher_success");
        Connection conn = ConnectionUtil.getConnection();
        conn.setAutoCommit(false);
        TeacherDAOImpl instance = new TeacherDAOImpl();
        boolean result = instance.deleteTeacher(conn, 5);
        assertEquals(true, result);
        conn.rollback();
    }

    @Test
    public void testDeleteTeacher_fail() throws SQLException, ClassNotFoundException {
        System.out.println("testDeleteTeacher_fail");
        Connection conn = ConnectionUtil.getConnection();
        conn.setAutoCommit(false);
        TeacherDAOImpl instance = new TeacherDAOImpl();
        boolean result = instance.deleteTeacher(conn, 4);
        assertEquals(false, result);
        conn.rollback();
    }

    @Test
    public void testAddNewTeacher_false() throws SQLException, ClassNotFoundException {
        System.out.println("tetAddNewTeacher");
        Connection conn = ConnectionUtil.getConnection();
        conn.setAutoCommit(false);
        TeacherDAOImpl instance = new TeacherDAOImpl();
        Teacher expResult = new Teacher(4, "Tien sy", "Phan Hong Anh", "anhhm@ptit.edu.vn", "Quang Ninh", "06/07/1989");
        boolean result = instance.addNewTeacher(conn, expResult);
        assertEquals(true, result);
        conn.rollback();
    }

}
