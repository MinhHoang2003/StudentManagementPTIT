/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.model;

/**
 *
 * @author hoang
 */
public class Utils {
    public static Object[] convertTeacherToObject(Teacher teacher) {
        return new Object[]{
            teacher.getId(),
            teacher.getName(),
            teacher.getEmail(),
            teacher.getAddress(),
            teacher.getMajor(),
            teacher.getDegree()
        };
    }
}
