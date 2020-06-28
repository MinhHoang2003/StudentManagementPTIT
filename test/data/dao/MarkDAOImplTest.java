/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.model.Mark;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PhamMinhHoang
 */
public class MarkDAOImplTest {

    public MarkDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class MarkDAOImpl.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        MarkDAOImpl expResult = MarkDAOImpl.getInstance();
        MarkDAOImpl result = MarkDAOImpl.getInstance();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMarksOfClass method, of class MarkDAOImpl.
     */
    @Test
    public void testGetMarksOfClass() throws Exception {
        System.out.println("getMarksOfClass");
        int id = 1;
        MarkDAOImpl instance = new MarkDAOImpl();
        List<Mark> expResult = new ArrayList<>();
        expResult.add(new Mark("B20DCCN001", 1, "Hoang Ngoc Khanh", 10, 8, 8, 8, 9, 7, "B", "Qua môn"));
        expResult.add(new Mark("B20DCCN002", 1, "Lu Tuan Nghia", 9, 8, 6, 7, 5, 5, "D", "Qua môn"));
        expResult.add(new Mark("B20DCCN005", 1, "Ngo Dung", 4, 7, 5, 0, 6, 3, "F", "Không qua môn"));
        expResult.add(new Mark("B20DCCN006", 1, "Quan Thang", 1, 1, 1, 1, 1, 1, "F", "Không qua môn"));

        List<Mark> result = instance.getMarksOfClass(id);
        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i).getStudentId(), result.get(i).getStudentId());
            assertEquals(expResult.get(i).getStudentName(), result.get(i).getStudentName());
            assertEquals(expResult.get(i).getClassId(), result.get(i).getClassId());
            assertEquals(expResult.get(i).getSummarize(), result.get(i).getSummarize());
            assertEquals(expResult.get(i).getFinalGradesInChar(), result.get(i).getFinalGradesInChar());
            assertEquals(expResult.get(i).getFinalGrades(), result.get(i).getFinalGrades(), 0);
            assertEquals(expResult.get(i).getPracticse(), result.get(i).getPracticse(), 0);
            assertEquals(expResult.get(i).getAttendance(), result.get(i).getAttendance(), 0);
            assertEquals(expResult.get(i).getProject(), result.get(i).getProject(), 0);
            assertEquals(expResult.get(i).getExamination(), result.get(i).getExamination(), 0);
            assertEquals(expResult.get(i).getFinalExamination(), result.get(i).getFinalExamination(), 0);
        }
    }

    @Test
    public void testGetMarksOfClass_empty_case() throws Exception {
        System.out.println("testGetMarksOfClass_empty_case");
        int id = 0;
        MarkDAOImpl instance = new MarkDAOImpl();
        List<Mark> expResult = new ArrayList<>();
        List<Mark> result = instance.getMarksOfClass(id);
        assertEquals(expResult.size(), result.size());
    }

    /**
     * Test of getPassStudentCountByClass method, of class MarkDAOImpl.
     */
    @Test
    public void testGetPassStudentCountByClass() throws Exception {
        System.out.println("getPassStudentCountByClass");
        int id = 1;
        MarkDAOImpl instance = new MarkDAOImpl();
        int expResult = 2;
        int result = instance.getPassStudentCountByClass(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassStudentCountByClass method, of class MarkDAOImpl.
     */
    @Test
    public void testGetPassStudentCountByClass_case_empty() throws Exception {
        System.out.println("getPassStudentCountByClass");
        int id = 0;
        MarkDAOImpl instance = new MarkDAOImpl();
        int expResult = 0;
        int result = instance.getPassStudentCountByClass(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNotPassStudentCountByClass method, of class MarkDAOImpl.
     */
    @Test
    public void testGetNotPassStudentCountByClass() throws Exception {
        System.out.println("getNotPassStudentCountByClass");
        int id = 1;
        MarkDAOImpl instance = new MarkDAOImpl();
        int expResult = 2;
        int result = instance.getNotPassStudentCountByClass(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNotPassStudentCountByClass method, of class MarkDAOImpl.
     */
    @Test
    public void testGetNotPassStudentCountByClass_case_empty() throws Exception {
        System.out.println("getNotPassStudentCountByClass");
        int id = 0;
        MarkDAOImpl instance = new MarkDAOImpl();
        int expResult = 0;
        int result = instance.getNotPassStudentCountByClass(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassStudentByClass method, of class MarkDAOImpl.
     */
    @Test
    public void testGetPassStudentByClass() throws Exception {
        System.out.println("getPassStudentByClass");
        int id = 1;
        MarkDAOImpl instance = new MarkDAOImpl();
        List<Mark> expResult = new ArrayList<>();
        expResult.add(new Mark("B20DCCN001", 1, "Hoang Ngoc Khanh", 10, 8, 8, 8, 9, 7, "B", "Qua môn"));
        expResult.add(new Mark("B20DCCN002", 1, "Lu Tuan Nghia", 9, 8, 6, 7, 5, 5, "D", "Qua môn"));
        List<Mark> result = instance.getPassStudentByClass(id);
        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i).getStudentId(), result.get(i).getStudentId());
            assertEquals(expResult.get(i).getStudentName(), result.get(i).getStudentName());
            assertEquals(expResult.get(i).getClassId(), result.get(i).getClassId());
            assertEquals(expResult.get(i).getSummarize(), result.get(i).getSummarize());
            assertEquals(expResult.get(i).getFinalGradesInChar(), result.get(i).getFinalGradesInChar());
            assertEquals(expResult.get(i).getFinalGrades(), result.get(i).getFinalGrades(), 0);
            assertEquals(expResult.get(i).getPracticse(), result.get(i).getPracticse(), 0);
            assertEquals(expResult.get(i).getAttendance(), result.get(i).getAttendance(), 0);
            assertEquals(expResult.get(i).getProject(), result.get(i).getProject(), 0);
            assertEquals(expResult.get(i).getExamination(), result.get(i).getExamination(), 0);
            assertEquals(expResult.get(i).getFinalExamination(), result.get(i).getFinalExamination(), 0);
        }
    }

    @Test
    public void testGetPassStudentByClass_empty_case() throws Exception {
        System.out.println("testGetPassStudentByClass_empty_case");
        int id = 0;
        MarkDAOImpl instance = new MarkDAOImpl();
        List<Mark> expResult = new ArrayList<>();
        List<Mark> result = instance.getPassStudentByClass(id);
        assertEquals(expResult.size(), result.size());
    }

    /**
     * Test of getNotPassStudentByClass method, of class MarkDAOImpl.
     */
    @Test
    public void testGetNotPassStudentByClass() throws Exception {
        System.out.println("getNotPassStudentByClass");
        int id = 1;
        MarkDAOImpl instance = new MarkDAOImpl();
        List<Mark> expResult = new ArrayList<>();
        List<Mark> result = instance.getNotPassStudentByClass(id);
        expResult.add(new Mark("B20DCCN005", 1, "Ngo Dung", 4, 7, 5, 0, 6, 3, "F", "Không qua môn"));
        expResult.add(new Mark("B20DCCN006", 1, "Quan Thang", 1, 1, 1, 1, 1, 1, "F", "Không qua môn"));
        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i).getStudentId(), result.get(i).getStudentId());
            assertEquals(expResult.get(i).getStudentName(), result.get(i).getStudentName());
            assertEquals(expResult.get(i).getClassId(), result.get(i).getClassId());
            assertEquals(expResult.get(i).getSummarize(), result.get(i).getSummarize());
            assertEquals(expResult.get(i).getFinalGradesInChar(), result.get(i).getFinalGradesInChar());
            assertEquals(expResult.get(i).getFinalGrades(), result.get(i).getFinalGrades(), 0);
            assertEquals(expResult.get(i).getPracticse(), result.get(i).getPracticse(), 0);
            assertEquals(expResult.get(i).getAttendance(), result.get(i).getAttendance(), 0);
            assertEquals(expResult.get(i).getProject(), result.get(i).getProject(), 0);
            assertEquals(expResult.get(i).getExamination(), result.get(i).getExamination(), 0);
            assertEquals(expResult.get(i).getFinalExamination(), result.get(i).getFinalExamination(), 0);
        }
    }

    @Test
    public void testGetNotPassStudentByClass_empty_case() throws Exception {
        System.out.println("testGetNotPassStudentByClass_empty_case");
        int id = 0;
        MarkDAOImpl instance = new MarkDAOImpl();
        List<Mark> expResult = new ArrayList<>();
        List<Mark> result = instance.getNotPassStudentByClass(id);
        assertEquals(expResult.size(), result.size());
    }

}
