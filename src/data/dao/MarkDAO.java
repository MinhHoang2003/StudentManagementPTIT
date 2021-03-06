/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.model.Mark;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author PhamMinhHoang
 */
public interface MarkDAO {

    List<Mark> getMarksOfClass(int id) throws SQLException, ClassNotFoundException;

    int getPassStudentCountByClass(int id) throws SQLException, ClassNotFoundException;

    int getNotPassStudentCountByClass(int id) throws SQLException, ClassNotFoundException;

    List<Mark> getPassStudentByClass(int id) throws SQLException, ClassNotFoundException;

    List<Mark> getNotPassStudentByClass(int id) throws SQLException, ClassNotFoundException;

}
