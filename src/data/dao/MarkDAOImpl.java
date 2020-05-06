/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.model.ConnectionUtil;
import data.model.Mark;
import data.model.Student;
import data.util.MarkUtil;
import data.util.StudentTableUtil;
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
public class MarkDAOImpl implements MarkDAO {

    private static MarkDAOImpl instance = null;

    public static MarkDAOImpl getInstance() {
        if (instance == null) {
            instance = new MarkDAOImpl();
        }
        return instance;
    }

    @Override
    public List<Mark> getMarksOfClass(int id) throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionUtil.getConnection();
        ArrayList<Mark> marks = new ArrayList<>();
        String call = "CALL getMarksOfClass(?)";
        CallableStatement callableStatement = conn.prepareCall(call);
        callableStatement.setInt(1, id);
        callableStatement.execute();
        ResultSet resultSet = callableStatement.getResultSet();
        while (resultSet.next()) {
            marks.add(new Mark(
                    resultSet.getString(MarkUtil.COLUMN_MA_SINH_VIEN),
                    resultSet.getInt(MarkUtil.COLUMN_MA_LOP),
                    resultSet.getString(MarkUtil.COLUMN_TEN),
                    resultSet.getFloat(MarkUtil.COLUMN_CHUYEN_CAN),
                    resultSet.getFloat(MarkUtil.COLUMN_BAI_TAP),
                    resultSet.getFloat(MarkUtil.COLUMN_KIEM_TRA),
                    resultSet.getFloat(MarkUtil.COLUMN_THUC_HANH),
                    resultSet.getFloat(MarkUtil.COLUMN_THI),
                    resultSet.getFloat(MarkUtil.COLUMN_TONG_KET),
                    resultSet.getString(MarkUtil.COLUMN_TONG_KET_BANG_CHU),
                    resultSet.getString(MarkUtil.COLUMN_KET_QUA)
            ));
        }
        conn.close();
        return marks;
    }

}
