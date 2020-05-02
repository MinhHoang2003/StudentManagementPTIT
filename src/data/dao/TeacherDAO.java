/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.model.Teacher;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author hoang
 */
public interface TeacherDAO {

    ArrayList<Teacher> getTeachers() throws SQLException, ClassNotFoundException;

    Teacher getTeacherById(int id) throws SQLException, ClassNotFoundException;

    boolean addNewTeacher(Teacher teacher) throws SQLException, ClassNotFoundException;

    boolean updateTeacher(Teacher teacher) throws SQLException, ClassNotFoundException;

    boolean deleteTeacher(int id) throws SQLException, ClassNotFoundException;
}
