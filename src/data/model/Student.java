/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.model;

/**
 *
 * @author PhamMinhHoang
 */
public class Student extends User {

    private String id;
    private int majorId;
    private String yearStudyIn;
    private String className;

    public Student(int majorId, String yearStudyIn, String className, String id, String name, String email, String address, String dateOfBirth) {
        super(name, email, address, dateOfBirth);
        this.id = id;
        this.majorId = majorId;
        this.yearStudyIn = yearStudyIn;
        this.className = className;
    }

    public Student(int majorId, String yearStudyIn, String className, String name, String email, String address, String dateOfBirth) {
        super(name, email, address, dateOfBirth);
        this.majorId = majorId;
        this.yearStudyIn = yearStudyIn;
        this.className = className;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMajor() {
        return majorId;
    }

    public void setMajor(int majorId) {
        this.majorId = majorId;
    }

    public String getYearStudyIn() {
        return yearStudyIn;
    }

    public void setYearStudyIn(String yearStudyIn) {
        this.yearStudyIn = yearStudyIn;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
