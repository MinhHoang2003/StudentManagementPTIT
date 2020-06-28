/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.model.Subject;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PhamMinhHoang
 */
public class SubjectDAOImplTest {

    /**
     * Test of getInstance method, of class SubjectDAOImpl.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        SubjectDAOImpl expResult = SubjectDAOImpl.getInstance();
        SubjectDAOImpl result = SubjectDAOImpl.getInstance();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSubjectsByTeacher method, of class SubjectDAOImpl.
     */
    @Test
    public void testGetSubjectsByTeacher() throws Exception {
        System.out.println("getSubjectsByTeacher");
        int id = 1;
        SubjectDAOImpl instance = new SubjectDAOImpl();
        List<Subject> expResult = new ArrayList<>();
        expResult.add(new Subject(1, 1, "Lap trinh mang", 3, 0.1f, 0, 0.1f, 0.1f, 0.7f));
        List<Subject> result = instance.getSubjectsByTeacher(id);
        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i).getId(), result.get(i).getId());
            assertEquals(expResult.get(i).getMajorId(), result.get(i).getMajorId());
            assertEquals(expResult.get(i).getName(), result.get(i).getName());
            assertEquals(expResult.get(i).getCredits(), result.get(i).getCredits());
            assertEquals(expResult.get(i).getPracticse(), result.get(i).getPracticse(), 0);
            assertEquals(expResult.get(i).getAttendance(), result.get(i).getAttendance(), 0);
            assertEquals(expResult.get(i).getProject(), result.get(i).getProject(), 0);
            assertEquals(expResult.get(i).getExamination(), result.get(i).getExamination(), 0);
            assertEquals(expResult.get(i).getFinalExamination(), result.get(i).getFinalExamination(), 0);
        }
    }

    @Test
    public void testGetSubjectsByTeacher_is_empty() throws Exception {
        System.out.println("testGetSubjectsByTeacher_is_empty");
        int id = 0;
        SubjectDAOImpl instance = new SubjectDAOImpl();
        List<Subject> result = instance.getSubjectsByTeacher(id);
        assertEquals(0, result.size());
    }

}
