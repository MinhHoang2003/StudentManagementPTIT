/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.model.Subject;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author PhamMinhHoang
 */
public interface SubjectDAO {
    List<Subject> getSubjectsByTeacher(int id)throws SQLException, ClassNotFoundException;
}
