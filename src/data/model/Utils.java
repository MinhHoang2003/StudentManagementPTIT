/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.model;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author hoang
 */
public class Utils {

    public static Object[] convertTeacherToObject(Teacher teacher) {
        return new Object[]{
            teacher.getId(),
            teacher.getName(),
            teacher.getDateOfBirth(),
            teacher.getAddress(),
            teacher.getEmail(),
            teacher.getMajor(),
            teacher.getDegree()
        };
    }

    public static Object[] convertStudentToObject(Student student) {
        return new Object[]{
            student.getId(),
            student.getName(),
            student.getAddress(),
            student.getDateOfBirth(),
            student.getEmail(),
            student.getClassName(),
            majors.get(student.getMajor()),
            student.getYearStudyIn()
        };
    }

    public static Object[] convertMarkToObject(int no, Mark mark) {
        return new Object[]{
            no,
            mark.getStudentName(),
            mark.getStudentId(),
            mark.getAttendance(),
            mark.getPracticse(),
            mark.getProject(),
            mark.getExamination(),
            mark.getFinalExamination(),
            mark.getFinalGrades(),
            mark.getFinalGradesInChar(),
            mark.getSummarize()
        };
    }

    public static HashMap<Integer, String> majors = new HashMap<Integer, String>();

    public static void setHashMap(List<Major> majors) {
        majors.forEach((m) -> {
            Utils.majors.put(m.getId(), m.getName());
        });
    }
}
