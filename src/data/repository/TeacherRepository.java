/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.repository;

import data.dao.TeacherDAO;
import data.model.Teacher;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author hoang
 */
public class TeacherRepository implements ITeacherRepository {

    private static TeacherRepository teacherRepository = null;
    private final TeacherDAO teacherDAO;

    private TeacherRepository(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    public TeacherRepository getInstance(TeacherDAO teacherDAO) {
        if (teacherRepository != null) {
            teacherRepository = new TeacherRepository(teacherDAO);
        }
        return teacherRepository;
    }

    @Override
    public void getTeachers(LocalTaskListener<ArrayList<Teacher>> listener) {
        try {
            listener.onTaskDone(teacherDAO.getTeachers());
        } catch (SQLException ex) {
            listener.onTaskError(ex.getMessage());
        }
    }

    @Override
    public void getTeacherById(int id, LocalTaskListener<Teacher> listener) {
        try {
            listener.onTaskDone(teacherDAO.getTeacherById(id));
        } catch (SQLException ex) {
            listener.onTaskError(ex.getMessage());
        }
    }

    @Override
    public void addNewTeacher(Teacher teacher, LocalTaskListener<Boolean> listener) {
        try {
            teacherDAO.addNewTeacher(teacher);
            listener.onTaskDone(true);
        } catch (SQLException ex) {
            listener.onTaskError(ex.getMessage());
        }
    }

    @Override
    public void updateTeacher(Teacher teacher, LocalTaskListener<Boolean> listener) {
        try {
            teacherDAO.updateTeacher(teacher);
            listener.onTaskDone(true);
        } catch (SQLException ex) {
            listener.onTaskError(ex.getMessage());
        }
    }

    @Override
    public void deleteTeacher(int id, LocalTaskListener<Boolean> listener) {
        try {
            teacherDAO.deleteTeacher(id);
            listener.onTaskDone(true);
        } catch (SQLException ex) {
            listener.onTaskError(ex.getMessage());
        }
    }

}
