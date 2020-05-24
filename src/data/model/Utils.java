/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author hoang
 */
public class Utils {

    public static final String ADMIN = "admin";
    public static final String EMAIL_SUFFIX = "@ptit.edu.vn";
    public static final String ADMIN_SELECTED = "Admin";
    public static final String TEACHER_SELECTED = "Giảng viên";
    public static Teacher teacherCached;
    public static AccountType currentAccountType = AccountType.TEACHER;

    public static Object[] convertTeacherToObject(Teacher teacher) {
        System.out.println("Convert : " + teacher.getId());
        return new Object[]{
            teacher.getId(),
            teacher.getName(),
            teacher.getDateOfBirth(),
            teacher.getAddress(),
            teacher.getEmail(),
            majors.get(teacher.getMajor()),
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

    public static boolean validateText(String name) {
        name = name.replaceAll("\\s+", " ").trim();
        Pattern p = Pattern.compile("[^A-Za-z0-9]");
        Matcher m = p.matcher(name);
        boolean b = m.find();
        if (b) {
            return false;
        }
        return true;
    }

    public static boolean validateNumber(String number) {
        number = number.replaceAll("\\s+", " ").trim();
        Pattern p = Pattern.compile("[^0-9]");
        Matcher m = p.matcher(number);
        boolean b = m.find();
        if (b) {
            return false;
        }
        return true;
    }

    public static boolean validateName(String name) {
        name = name.replaceAll("\\s+", "").trim();
        Pattern p = Pattern.compile("[^A-Za-z]");
        Matcher m = p.matcher(name);
        boolean b = m.find();
        if (b) {
            return false;
        }
        return true;
    }

    public static boolean validateDate(String strDate) {
        if (strDate.trim().equals("")) {
            System.err.println("On validate date: date is null");
            return false;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setLenient(false);
        try {
            Date date = simpleDateFormat.parse(strDate);
            boolean check = date.before(new Date());
            if (!check) {
                return false;
            }
        } catch (ParseException e) {
            System.err.println("On validate " + strDate + " is invalid date format");
            return false;
        }
        return true;

    }

    public static String splitName(String name) {
        name = name.replaceAll("\\s+", " ").trim();
        Pattern p = Pattern.compile("[^A-Za-z0-9]");
        Matcher m = p.matcher(name);
        boolean b = m.find();
        if (b) {
            System.out.println("There is a special character in name ");
            return null;
        }
        String mail = "";
        String[] names = name.split(" ");
        mail = mail + names[names.length - 1];
        for (int i = 0; i < names.length - 1; i++) {
            mail = mail + names[i].substring(0, 1);
        }
        return mail;
    }
}
