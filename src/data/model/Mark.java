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
public class Mark {

    //masv, malop, chuyencan, baitap, thuchanh, kiemtra, thi, tongket, tongketbangchu, ketqua
    private String studentId;
    private int classId;
    private String studentName;
    private float attendance;
    private float project;
    private float examination;
    private float practicse;
    private float finalExamination;
    private float finalGrades;
    private String finalGradesInChar;
    private String summarize;

    public Mark(String studentId, int classId, String studentName, float attendance, float project, float examination, float practicse, float finalExamination, float finalGrades, String finalGradesInChar, String summarize) {
        this.studentId = studentId;
        this.classId = classId;
        this.studentName = studentName;
        this.attendance = attendance;
        this.project = project;
        this.examination = examination;
        this.practicse = practicse;
        this.finalExamination = finalExamination;
        this.finalGrades = finalGrades;
        this.finalGradesInChar = finalGradesInChar;
        this.summarize = summarize;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
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

    public float getFinalGrades() {
        return finalGrades;
    }

    public void setFinalGrades(float finalGrades) {
        this.finalGrades = finalGrades;
    }

    public String getFinalGradesInChar() {
        return finalGradesInChar;
    }

    public void setFinalGradesInChar(String finalGradesInChar) {
        this.finalGradesInChar = finalGradesInChar;
    }

    public String getSummarize() {
        return summarize;
    }

    public void setSummarize(String summarize) {
        this.summarize = summarize;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

}
