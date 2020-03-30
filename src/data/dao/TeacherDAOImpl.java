/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.model.Teacher;
import java.util.ArrayList;
/**
 *
 * @author hoang
 */
public class TeacherDAOImpl implements TeacherDAO {

    private static TeacherDAOImpl instance = null;
    private ArrayList<Teacher> teachers;

    public TeacherDAOImpl(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public static TeacherDAOImpl getInstance(ArrayList<Teacher> teachers) {
        if (instance == null) {
            instance = new TeacherDAOImpl(teachers);
        }
        return instance;
    }

    @Override
    public ArrayList<Teacher> getTeachers() {
        return this.teachers;
    }

    @Override
    public Teacher getTeacherById(int id) {
        for (Teacher x : this.teachers) {
            if (x.getId() == id) {
                return x;
            }
        }
        return null;
    }

    @Override
    public boolean addNewTeacher(Teacher teacher) {
        this.teachers.add(teacher);
        return true;
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        for (int i = 0; i < this.teachers.size(); i++) {
            if (this.teachers.get(i).getId() == teacher.getId()) {
                this.teachers.set(i, teacher);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteTeacher(int id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }

}
