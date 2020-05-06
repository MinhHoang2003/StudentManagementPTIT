/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

import control.MarkController;
import control.StudentController;
import data.dao.CourseDAOImpl;
import data.dao.MajorDAOImpl;
import data.dao.MarkDAOImpl;
import data.dao.StudentDAO;
import data.dao.StudentDAOImpl;
import data.dao.SubjectDAOImpl;
import data.model.Utils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author hoang
 */
public class Application {

    public static void main(String[] args) {
//        StudentDAO teacherDAO = StudentDAOImpl.getInstance();
//        MajorDAOImpl majorDAOImpl = MajorDAOImpl.getInstance();
//        Utils.setHashMap(majorDAOImpl.majorsCached);
//        MarkController markController = new MarkController(CourseDAOImpl.getInstance(), MarkDAOImpl.getInstance(), SubjectDAOImpl.getInstance());
//        markController.show(true);
        
        HomeView view = new HomeView();
        view.setVisible(true);
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
