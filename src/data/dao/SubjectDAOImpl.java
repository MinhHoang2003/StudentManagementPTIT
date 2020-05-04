/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.model.ConnectionUtil;
import data.model.Subject;
import data.util.SubjectUtil;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PhamMinhHoang
 */
public class SubjectDAOImpl implements SubjectDAO {

    private static SubjectDAOImpl instance = null;

    private static SubjectDAOImpl getInstance() {
        if (instance == null) {
            instance = new SubjectDAOImpl();
        }
        return instance;
    }

    @Override
    public List<Subject> getSubjectsByTeacher(int id) throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionUtil.getConnection();
        ArrayList<Subject> subjects = new ArrayList<>();
        String call = "CALL getSubjectsByTeacher(?)";
        CallableStatement callableStatement = conn.prepareCall(call);
        callableStatement.setInt(1, id);
        callableStatement.execute();
        ResultSet resultSet = callableStatement.getResultSet();
        while (resultSet.next()) {
            subjects.add(new Subject(
                    resultSet.getInt(SubjectUtil.COLUMN_MA_MON),
                    resultSet.getInt(SubjectUtil.COLUMN_MA_CHUYEN_NGANH),
                    resultSet.getString(SubjectUtil.COLUMN_TEN_MON),
                    resultSet.getInt(SubjectUtil.COLUMN_SO_TIN_CHI),
                    resultSet.getFloat(SubjectUtil.COLUMN_CHUYEN_CAN),
                    resultSet.getFloat(SubjectUtil.COLUMN_BAI_TAP),
                    resultSet.getFloat(SubjectUtil.COLUMN_KIEM_TRA),
                    resultSet.getFloat(SubjectUtil.COLUMN_THUC_HANH),
                    resultSet.getFloat(SubjectUtil.COLUMN_THI)
            ));
        }
        conn.close();
        return subjects;
    }

}
