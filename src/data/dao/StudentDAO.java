/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.model.Student;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PhamMinhHoang
 */
public interface StudentDAO {

    ArrayList<Student> getStudents() throws SQLException, ClassNotFoundException;

    Student getStudentById(String id) throws SQLException, ClassNotFoundException;

    boolean addNewStudent(Connection conn, Student teacher) throws SQLException, ClassNotFoundException;

    boolean updateStudent(Connection conn, Student teacher) throws SQLException, ClassNotFoundException;

    boolean deleteStudent(Connection conn, String id) throws SQLException, ClassNotFoundException;

    int generateNewId(Connection conn, int maChuyenNganh) throws SQLException, ClassNotFoundException;

}
