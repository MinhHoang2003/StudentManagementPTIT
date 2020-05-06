/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.model.ConnectionUtil;
import data.model.Course;
import data.model.Subject;
import data.util.ClassUtil;
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
public class CourseDAOImpl implements CourseDAO {

    private static CourseDAOImpl instance = null;

    public static CourseDAOImpl getInstance() {
        if (instance == null) {
            instance = new CourseDAOImpl();
        }
        return instance;
    }

    @Override
    public List<Course> getCourseByTeacher(int teacherId, int courseId) throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionUtil.getConnection();
        ArrayList<Course> courses = new ArrayList<>();
        String call = "CALL getClassInfoByTeacher(?,?)";
        CallableStatement callableStatement = conn.prepareCall(call);
        callableStatement.setInt(1, teacherId);
        callableStatement.setInt(2, courseId);
        callableStatement.execute();
        ResultSet resultSet = callableStatement.getResultSet();
        while (resultSet.next()) {
            courses.add(new Course(
                    resultSet.getInt(ClassUtil.COLUMN_MA_LOP_HOC),
                    resultSet.getInt(ClassUtil.COLUMN_MA_MON_HOC),
                    resultSet.getInt(ClassUtil.COLUMN_MA_GIANG_VIEN),
                    resultSet.getInt(ClassUtil.COLUMN_KI_HOC),
                    resultSet.getInt(ClassUtil.COLUMN_NAM_HOC)
            ));
        }
        conn.close();
        return courses;
    }

}
