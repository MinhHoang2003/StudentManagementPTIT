/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.model.ConnectionUtil;
import data.model.Mark;
import data.model.Student;
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
        String call = "CALL getStudents()";
        CallableStatement callableStatement = conn.prepareCall(call);
        callableStatement.execute();
        ResultSet resultSet = callableStatement.getResultSet();
        //TODO : need implement
//        while (resultSet.next()) {
//            marks.add(new Student(
//                    resultSet.getInt(StudentTableUtil.COLUMN_MAJOR),
//                    resultSet.getString(StudentTableUtil.COLUMN_YEAR_STUDY_IN),
//                    resultSet.getString(StudentTableUtil.COLUMN_CLASS),
//                    resultSet.getString(StudentTableUtil.COLUMN_ID),
//                    resultSet.getString(StudentTableUtil.COLUMN_NAME),
//                    resultSet.getString(StudentTableUtil.COLUMN_EMAIL),
//                    resultSet.getString(StudentTableUtil.COLUMN_ADDRESS),
//                    resultSet.getString(StudentTableUtil.COLUMN_DATE_OF_BIRTH)
//            ));
//        }
        conn.close();
        return marks;
    }

}
