/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.model.ConnectionUtil;
import data.model.Major;
import data.util.MajorUtil;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PhamMinhHoang
 */
public class MajorDAOImpl implements MajorDAO {

    private static MajorDAOImpl instance = null;
    public List<Major> majorsCached = null;

    private MajorDAOImpl() {
        majorsCached = getMajors();
    }

    public static MajorDAOImpl getInstance() {
        if (instance == null) {
            instance = new MajorDAOImpl();
        }
        return instance;
    }

    public List<Major> getMajorsCached() {
        return majorsCached;
    }

    @Override
    public List<Major> getMajors() {
        ArrayList<Major> majors = new ArrayList<>();
        Connection conn = null;
        try {
            conn = ConnectionUtil.getConnection();
            String call = "CALL getMajors()";
            CallableStatement callableStatement = conn.prepareCall(call);
            callableStatement.execute();
            ResultSet resultSet = callableStatement.getResultSet();
            while (resultSet.next()) {
                majors.add(new Major(
                        resultSet.getInt(MajorUtil.COLUMN_MA_CHUYEN_NGANH),
                        resultSet.getString(MajorUtil.COLUMN_TEN_CHUYEN_NGANH),
                        resultSet.getString(MajorUtil.COLUMN_VIET_TAT)
                ));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MajorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(MajorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return majors;
    }

    public Major getMajorId(String name) {
        Major major = null;
        if (majorsCached != null) {
            for (Major m : majorsCached) {
                if (m.getName().equals(name)) {
                    return m;
                }
            };
        }
        return major;
    }

    public Major getMajor(int id) {
        if (majorsCached != null) {
            for (Major major : majorsCached) {
                if (major.getId() == id) {
                    return major;
                }
            }
        }
        return null;
    }
}
