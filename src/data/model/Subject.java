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
public class Subject {
    //ma_mon, ma_chuyen_nganh, ten_mon_hoc, so_tin_chi, chuyen_can, baitap, kiem_tra, thuc_hanh, thi
    private int id;
    private int majorId;
    private String name;
    private int credits;
    private float attendance;
    private float project;
    private float examination;
    private float practicse;
    private float finalExamination;

    public Subject(int id, int majorId, String name, int credits, float attendance, float project, float examination, float practicse, float finalExamination) {
        this.id = id;
        this.majorId = majorId;
        this.name = name;
        this.credits = credits;
        this.attendance = attendance;
        this.project = project;
        this.examination = examination;
        this.practicse = practicse;
        this.finalExamination = finalExamination;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public float getAttendance() {
        return attendance;
    }

    public void setAttendance(float attendance) {
        this.attendance = attendance;
    }

    public float getProject() {
        return project;
    }

    public void setProject(float project) {
        this.project = project;
    }

    public float getExamination() {
        return examination;
    }

    public void setExamination(float examination) {
        this.examination = examination;
    }

    public float getPracticse() {
        return practicse;
    }

    public void setPracticse(float practicse) {
        this.practicse = practicse;
    }

    public float getFinalExamination() {
        return finalExamination;
    }

    public void setFinalExamination(float finalExamination) {
        this.finalExamination = finalExamination;
    }
    
}
