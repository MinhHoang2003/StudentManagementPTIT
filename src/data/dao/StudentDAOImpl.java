/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.util.StudentTableUtil;
import data.util.TeacherTableUtil;
import data.model.ConnectionUtil;
import data.model.Student;
import data.model.Teacher;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PhamMinhHoang
 */
public class StudentDAOImpl implements StudentDAO {

    private static StudentDAOImpl instance = null;

    public static StudentDAOImpl getInstance() {
        if (instance == null) {
            instance = new StudentDAOImpl();
        }
        return instance;
    }

    @Override
    public ArrayList<Student> getStudents() throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionUtil.getConnection();
        ArrayList<Student> students = new ArrayList<>();
        String call = "CALL getStudents()";
        CallableStatement callableStatement = conn.prepareCall(call);
        callableStatement.execute();
        ResultSet resultSet = callableStatement.getResultSet();
        while (resultSet.next()) {
            students.add(new Student(
                    resultSet.getInt(StudentTableUtil.COLUMN_MAJOR),
                    resultSet.getString(StudentTableUtil.COLUMN_YEAR_STUDY_IN),
                    resultSet.getString(StudentTableUtil.COLUMN_CLASS),
                    resultSet.getString(StudentTableUtil.COLUMN_ID),
                    resultSet.getString(StudentTableUtil.COLUMN_NAME),
                    resultSet.getString(StudentTableUtil.COLUMN_EMAIL),
                    resultSet.getString(StudentTableUtil.COLUMN_ADDRESS),
                    resultSet.getString(StudentTableUtil.COLUMN_DATE_OF_BIRTH)
            ));
        }
        conn.close();
        return students;
    }

    @Override
    public Student getStudentById(String id) throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionUtil.getConnection();
        Student student = null;
        String call = "CALL getStudentById(?)";
        CallableStatement callableStatement = conn.prepareCall(call);
        callableStatement.setString(1, id);
        callableStatement.execute();
        ResultSet resultSet = callableStatement.getResultSet();
        while (resultSet.next()) {
            student = new Student(
                    resultSet.getInt(StudentTableUtil.COLUMN_MAJOR),
                    resultSet.getString(StudentTableUtil.COLUMN_YEAR_STUDY_IN),
                    resultSet.getString(StudentTableUtil.COLUMN_CLASS),
                    resultSet.getString(StudentTableUtil.COLUMN_ID),
                    resultSet.getString(StudentTableUtil.COLUMN_NAME),
                    resultSet.getString(StudentTableUtil.COLUMN_EMAIL),
                    resultSet.getString(StudentTableUtil.COLUMN_ADDRESS),
                    resultSet.getString(StudentTableUtil.COLUMN_DATE_OF_BIRTH)
            );
        }
        conn.close();
        return student;
    }

    @Override
    public boolean addNewStudent(Connection conn, Student student) throws SQLException, ClassNotFoundException {
        String call = "CALL addStudent(?,?,?,?,?,?,?,?)";
        CallableStatement callableStatement = conn.prepareCall(call);
        callableStatement.setString(StudentTableUtil.COLUMN_ID, student.getId());
        callableStatement.setString(StudentTableUtil.COLUMN_NAME, student.getName());
        callableStatement.setString(StudentTableUtil.COLUMN_DATE_OF_BIRTH, student.getDateOfBirth());
        callableStatement.setString(StudentTableUtil.COLUMN_ADDRESS, student.getAddress());
        callableStatement.setString(StudentTableUtil.COLUMN_EMAIL, student.getEmail());
        callableStatement.setString(StudentTableUtil.COLUMN_CLASS, student.getClassName());
        callableStatement.setInt(StudentTableUtil.COLUMN_MAJOR, student.getMajor());
        callableStatement.setString(StudentTableUtil.COLUMN_YEAR_STUDY_IN, student.getYearStudyIn());
        int id = callableStatement.executeUpdate();
        callableStatement.close();
        return id > 0;
    }

    @Override
    public boolean updateStudent(Connection conn, Student student) throws SQLException, ClassNotFoundException {
        String call = "CALL updateStudent(?,?,?,?,?,?,?,?)";
        CallableStatement callableStatement = conn.prepareCall(call);
        callableStatement.setString(StudentTableUtil.COLUMN_ID, student.getId());
        callableStatement.setString(StudentTableUtil.COLUMN_NAME, student.getName());
        callableStatement.setString(StudentTableUtil.COLUMN_DATE_OF_BIRTH, student.getDateOfBirth());
        callableStatement.setString(StudentTableUtil.COLUMN_ADDRESS, student.getAddress());
        callableStatement.setString(StudentTableUtil.COLUMN_EMAIL, student.getEmail());
        callableStatement.setString(StudentTableUtil.COLUMN_CLASS, student.getClassName());
        callableStatement.setInt(StudentTableUtil.COLUMN_MAJOR, student.getMajor());
        callableStatement.setString(StudentTableUtil.COLUMN_YEAR_STUDY_IN, student.getYearStudyIn());
        final boolean result = callableStatement.executeUpdate() > 0;
        callableStatement.close();
        return result;
    }

    @Override
    public boolean deleteStudent(Connection conn, String id) throws SQLException, ClassNotFoundException {
        String call = "CALL removeStudent(?)";
        CallableStatement callableStatement = conn.prepareCall(call);
        callableStatement.setString(TeacherTableUtil.COLUMN_ID, id);
        final boolean result = callableStatement.executeUpdate() > 0;
        callableStatement.close();
        return result;
    }

    @Override
    public int generateNewId(Connection conn, int maChuyenNganh) throws SQLException, ClassNotFoundException {
        String call = "CALL getStudentCount(?)";
        int id = 0;
        CallableStatement callableStatement = conn.prepareCall(call);
        callableStatement.setInt(StudentTableUtil.COLUMN_MAJOR, maChuyenNganh);
        ResultSet result = callableStatement.executeQuery();
        while (result.next()) {
            id = result.getInt("num");
        }
        return id;
    }
}
