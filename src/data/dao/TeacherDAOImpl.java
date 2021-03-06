/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.util.TeacherTableUtil;
import data.model.ConnectionUtil;
import data.model.Teacher;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author hoang
 */
public class TeacherDAOImpl implements TeacherDAO {

    private static TeacherDAOImpl instance = null;

    public static TeacherDAOImpl getInstance() {
        if (instance == null) {
            instance = new TeacherDAOImpl();
        }
        return instance;
    }
//String major, String degree, int id, String name, String email, String address, String dateOfBirth

    @Override
    public ArrayList<Teacher> getTeachers() throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionUtil.getConnection();
        ArrayList<Teacher> teachers = new ArrayList<>();
        String call = "CALL getTeachers()";
        CallableStatement callableStatement = conn.prepareCall(call);
        callableStatement.execute();
        ResultSet resultSet = callableStatement.getResultSet();
        while (resultSet.next()) {
            teachers.add(new Teacher(
                    resultSet.getInt(TeacherTableUtil.COLUMN_MAJOR_ID),
                    resultSet.getString(TeacherTableUtil.COLUMN_DEGREE),
                    resultSet.getInt(TeacherTableUtil.COLUMN_ID),
                    resultSet.getString(TeacherTableUtil.COLUMN_NAME),
                    resultSet.getString(TeacherTableUtil.COLUMN_EMAIL),
                    resultSet.getString(TeacherTableUtil.COLUMN_ADDRESS),
                    resultSet.getString(TeacherTableUtil.COLUMN_DATE_OF_BIRTH)
            ));
        }
        conn.close();
        return teachers;
    }

    @Override
    public Teacher getTeacherById(int id) throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionUtil.getConnection();
        Teacher teacher = null;
        String call = "CALL getTeacherById(?)";
        CallableStatement callableStatement = conn.prepareCall(call);
        callableStatement.setInt(1, id);
        callableStatement.execute();
        ResultSet resultSet = callableStatement.getResultSet();
        while (resultSet.next()) {
            teacher = new Teacher(
                    resultSet.getInt(TeacherTableUtil.COLUMN_MAJOR_ID),
                    resultSet.getString(TeacherTableUtil.COLUMN_DEGREE),
                    resultSet.getInt(TeacherTableUtil.COLUMN_ID),
                    resultSet.getString(TeacherTableUtil.COLUMN_NAME),
                    resultSet.getString(TeacherTableUtil.COLUMN_EMAIL),
                    resultSet.getString(TeacherTableUtil.COLUMN_ADDRESS),
                    resultSet.getString(TeacherTableUtil.COLUMN_DATE_OF_BIRTH)
            );
        }
        conn.close();
        return teacher;
    }

    @Override
    public boolean addNewTeacher(Connection conn, Teacher teacher) throws SQLException, ClassNotFoundException {
        String callAddNewStudemt = "CALL addTeacher(?,?,?,?,?,?)";
        CallableStatement callableStatementAddNeww = conn.prepareCall(callAddNewStudemt);
        callableStatementAddNeww.setString(TeacherTableUtil.COLUMN_NAME, teacher.getName());
        callableStatementAddNeww.setString(TeacherTableUtil.COLUMN_DATE_OF_BIRTH, teacher.getDateOfBirth());
        callableStatementAddNeww.setString(TeacherTableUtil.COLUMN_ADDRESS, teacher.getAddress());
        callableStatementAddNeww.setString(TeacherTableUtil.COLUMN_EMAIL, teacher.getEmail());
        callableStatementAddNeww.setInt(TeacherTableUtil.COLUMN_MAJOR_ID, teacher.getMajor());
        callableStatementAddNeww.setString(TeacherTableUtil.COLUMN_DEGREE, teacher.getDegree());
        int id = callableStatementAddNeww.executeUpdate();
        callableStatementAddNeww.close();
        System.out.println("On add " + id);
        // create new account for teacher
        String call = "CALL createTeacherAccount(?,?)";
        CallableStatement callableStatement = conn.prepareCall(call);
        callableStatement.setString(1, teacher.getEmail());
        callableStatement.setString(2, teacher.getDateOfBirth().replaceAll("/", ""));
        int result = callableStatement.executeUpdate();
        callableStatement.close();
        return (id > 0) && (result > 0);
    }

    @Override
    public boolean updateTeacher(Connection conn, Teacher teacher) throws SQLException, ClassNotFoundException {
        String call = "CALL updateTeacher(?,?,?,?,?,?,?)";
        CallableStatement callableStatement = conn.prepareCall(call);
        callableStatement.setInt(TeacherTableUtil.COLUMN_ID, teacher.getId());
        callableStatement.setString(TeacherTableUtil.COLUMN_NAME, teacher.getName());
        callableStatement.setString(TeacherTableUtil.COLUMN_DATE_OF_BIRTH, teacher.getDateOfBirth());
        callableStatement.setString(TeacherTableUtil.COLUMN_ADDRESS, teacher.getAddress());
        callableStatement.setString(TeacherTableUtil.COLUMN_EMAIL, teacher.getEmail());
        callableStatement.setInt(TeacherTableUtil.COLUMN_MAJOR_ID, teacher.getMajor());
        callableStatement.setString(TeacherTableUtil.COLUMN_DEGREE, teacher.getDegree());
        final boolean result = callableStatement.executeUpdate() > 0;
        callableStatement.close();
        return result;
    }

    @Override
    public boolean deleteTeacher(Connection conn, int id) throws SQLException, ClassNotFoundException {
        String call = "CALL removeTeacher(?)";
        CallableStatement callableStatement = conn.prepareCall(call);
        callableStatement.setInt(TeacherTableUtil.COLUMN_ID, id);
        final boolean result = callableStatement.executeUpdate() > 0;
        callableStatement.close();
        return result;
    }

    @Override
    public Teacher getTeacherByEmail(String email) throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionUtil.getConnection();
        Teacher teacher = null;
        String call = "CALL getTeacherByEmail(?)";
        CallableStatement callableStatement = conn.prepareCall(call);
        callableStatement.setString(1, email);
        callableStatement.execute();
        ResultSet resultSet = callableStatement.getResultSet();
        while (resultSet.next()) {
            teacher = new Teacher(
                    resultSet.getInt(TeacherTableUtil.COLUMN_MAJOR_ID),
                    resultSet.getString(TeacherTableUtil.COLUMN_DEGREE),
                    resultSet.getInt(TeacherTableUtil.COLUMN_ID),
                    resultSet.getString(TeacherTableUtil.COLUMN_NAME),
                    resultSet.getString(TeacherTableUtil.COLUMN_EMAIL),
                    resultSet.getString(TeacherTableUtil.COLUMN_ADDRESS),
                    resultSet.getString(TeacherTableUtil.COLUMN_DATE_OF_BIRTH)
            );
        }
        conn.close();
        return teacher;
    }

}
