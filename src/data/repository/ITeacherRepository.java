/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.repository;

import data.model.Teacher;
import java.util.ArrayList;

/**
 *
 * @author hoang
 */
public interface ITeacherRepository {
    void getTeachers(LocalTaskListener< ArrayList<Teacher>> listener);

    void getTeacherById(int id,LocalTaskListener<Teacher> listener);

    void addNewTeacher(Teacher teacher, LocalTaskListener<Boolean> listener);

    void updateTeacher(Teacher teacher, LocalTaskListener<Boolean> listener);

    void deleteTeacher(int id, LocalTaskListener<Boolean> listener);
}
