/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.model.Student;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PhamMinhHoang
 */
public interface StudentDAO {

    ArrayList<Student> getStudents() throws SQLException, ClassNotFoundException;

    Student getStudentById(int id) throws SQLException, ClassNotFoundException;

    boolean addNewStudent(Student teacher) throws SQLException, ClassNotFoundException;

    boolean updateStudent(Student teacher) throws SQLException, ClassNotFoundException;

    boolean deleteStudent(String id) throws SQLException, ClassNotFoundException;

    int generateNewId(int maChuyenNganh) throws SQLException, ClassNotFoundException;

}
