/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.model.ConnectionUtil;
import data.model.Teacher;
import data.util.TeacherTableUtil;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PhamMinhHoang
 */
public class AccountDAOImpl implements AccountDAO {

    private static AccountDAOImpl INSTANCE = null;

    public static AccountDAOImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AccountDAOImpl();
        }
        return INSTANCE;
    }

    @Override
    public Teacher loginTeacherAccount(String email, String pass) throws ClassNotFoundException, SQLException {
        Connection conn = ConnectionUtil.getConnection();
        Teacher teacher = null;
        String call = "CALL loginTeacherAccount(?,?)";
        CallableStatement callableStatement = conn.prepareCall(call);
        callableStatement.setString(1, email);
        callableStatement.setString(2, pass);
        callableStatement.execute();
        ResultSet resultSet = callableStatement.getResultSet();
        if (resultSet.next()) {
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
    public boolean loginAdmin(String email, String pass) throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionUtil.getConnection();
        boolean result = false;
        String call = "CALL loginAdmin(?,?)";
        CallableStatement callableStatement = conn.prepareCall(call);
        callableStatement.setString(1, email);
        callableStatement.setString(2, pass);
        callableStatement.execute();
        ResultSet resultSet = callableStatement.getResultSet();
        if (resultSet.next()) {
            result = true;
        }
        conn.close();
        return result;
    }

}
