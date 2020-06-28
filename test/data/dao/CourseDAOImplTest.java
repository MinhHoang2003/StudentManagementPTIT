/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.model.Course;
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
public class CourseDAOImplTest {

    public CourseDAOImplTest() {
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
     * Test of getInstance method, of class CourseDAOImpl.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        CourseDAOImpl expResult = CourseDAOImpl.getInstance();
        CourseDAOImpl result = CourseDAOImpl.getInstance();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCourseByTeacher method, of class CourseDAOImpl.
     */
    @Test
    public void testGetCourseByTeacher() throws Exception {
        System.out.println("getCourseByTeacher");
        int teacherId = 1;
        int courseId = 1;
        CourseDAOImpl instance = new CourseDAOImpl();
        Course expResult = new Course(1, 1, 1, 1, 2020);
        Course result = instance.getCourseByTeacher(teacherId, courseId).get(0);
        assertEquals(expResult.getClassId(), result.getClassId());
        assertEquals(expResult.getSchoolYear(), result.getSchoolYear());
        assertEquals(expResult.getSemester(), result.getSemester());
        assertEquals(expResult.getSubjectId(), result.getSubjectId());
        assertEquals(expResult.getTeacherId(), result.getTeacherId());
    }

    @Test
    public void testGetCourseByTeacher_not_result() throws Exception {
        System.out.println("getCourseByTeacher");
        int teacherId = 0;
        int courseId = 0;
        CourseDAOImpl instance = new CourseDAOImpl();
        Course expResult = new Course(1, 1, 1, 1, 2020);
        List<Course> result = instance.getCourseByTeacher(teacherId, courseId);
        assertEquals(0, result.size());
    }

}
