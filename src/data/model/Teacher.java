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
    private int major;
    private String degree;

    public Teacher(int major, String degree, int id, String name, String email, String address, String dateOfBirth) {
        super(name, email, address, dateOfBirth);
        this.id = id;
        this.major = major;
        this.degree = degree;
    }

    public Teacher(int major, String degree, String name, String email, String address, String dateOfBirth) {
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

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
