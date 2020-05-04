/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

import control.StudentController;
import data.dao.MajorDAOImpl;
import data.dao.StudentDAO;
import data.dao.StudentDAOImpl;
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
//        StudentController teacherController = new StudentController(teacherDAO, majorDAOImpl);
//        teacherController.show(true);
        System.out.println(splitName("Pham Minh Hoang"));

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
