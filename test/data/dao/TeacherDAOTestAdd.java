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
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author PhamMinhHoang
 */
public class TeacherDAOTestAdd {

    @Test
    public void testAddNewTeacher() throws SQLException, ClassNotFoundException {
        System.out.println("tetAddNewTeacher");
        Connection conn = ConnectionUtil.getConnection();
        conn.setAutoCommit(false);
        TeacherDAOImpl instance = new TeacherDAOImpl();
        Teacher expResult = new Teacher(4, "Tien sy", "Phan Hong Anh", "anhhp@ptit.edu.vn", "Quang Ninh", "06/07/1989");
        boolean result = instance.addNewTeacher(conn, expResult);
        assertEquals(true, result);
        conn.rollback();
        conn.close();
    }
}
