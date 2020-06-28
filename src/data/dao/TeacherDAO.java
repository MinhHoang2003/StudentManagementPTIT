/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.model.Teacher;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author hoang
 */
public interface TeacherDAO {

    ArrayList<Teacher> getTeachers() throws SQLException, ClassNotFoundException;

    Teacher getTeacherById(int id) throws SQLException, ClassNotFoundException;

    Teacher getTeacherByEmail(String email) throws SQLException, ClassNotFoundException;

    boolean addNewTeacher(Connection conn, Teacher teacher) throws SQLException, ClassNotFoundException;

    boolean updateTeacher(Connection conn, Teacher teacher) throws SQLException, ClassNotFoundException;

    boolean deleteTeacher(Connection conn, int id) throws SQLException, ClassNotFoundException;
}
