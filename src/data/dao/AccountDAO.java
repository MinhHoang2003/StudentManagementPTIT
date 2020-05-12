/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.model.Teacher;
import java.sql.SQLException;

/**
 *
 * @author PhamMinhHoang
 */
public interface AccountDAO {

    Teacher loginTeacherAccount(String email, String pass) throws SQLException, ClassNotFoundException;

    boolean loginAdmin(String email, String pass) throws SQLException, ClassNotFoundException;

    boolean createTeacherAccount(String email, String pass) throws SQLException, ClassNotFoundException;
}
