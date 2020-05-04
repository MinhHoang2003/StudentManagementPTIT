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
public class Course {
    //ma_lop_hoc, ma_mon_hoc, ma_giang_vien, ki_hoc, nam_hoc
    private int classId;
    private int subjectId;
    private int teacherId;
    private int semester;
    private int schoolYear;

    public Course(int classId, int subjectId, int teacherId, int semester, int schoolYear) {
        this.classId = classId;
        this.subjectId = subjectId;
        this.teacherId = teacherId;
        this.semester = semester;
        this.schoolYear = schoolYear;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }
    
    
}
