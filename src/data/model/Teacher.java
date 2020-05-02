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
public class Teacher extends User {

    private int id;
    private String major;
    private String degree;

    public Teacher(String major, String degree, int id, String name, String email, String address, String dateOfBirth) {
        super(name, email, address, dateOfBirth);
        this.major = major;
        this.degree = degree;
    }

    public Teacher(String major, String degree, String name, String email, String address, String dateOfBirth) {
        super(name, email, address, dateOfBirth);
        this.major = major;
        this.degree = degree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
