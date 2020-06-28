/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.model.Major;
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
public class MajorDAOImplTest {

    public MajorDAOImplTest() {
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
     * Test of getInstance method, of class MajorDAOImpl.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        MajorDAOImpl expResult = MajorDAOImpl.getInstance();
        MajorDAOImpl result = MajorDAOImpl.getInstance();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMajorsCached method, of class MajorDAOImpl.
     */
    @Test
    public void testGetMajorsCached() {
        System.out.println("getMajorsCached");
        MajorDAOImpl instance = MajorDAOImpl.getInstance();
        List<Major> expResult = new ArrayList<>();
        expResult.add(new Major(1, "Cong nghe thong tin", "DCCN"));
        expResult.add(new Major(2, "An toan thong tin", "ATTT"));
        expResult.add(new Major(3, "Marketing", "KTMR"));
        expResult.add(new Major(4, "Quan tri kinh doanh", "QTKD"));
        expResult.add(new Major(5, "Dien tu - Vien thong", "DTVT"));
        expResult.add(new Major(6, "Da phuong tien", "DPT"));

        List<Major> result = instance.getMajorsCached();
        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i).getId(), result.get(i).getId());
            assertEquals(expResult.get(i).getName(), result.get(i).getName());
            assertEquals(expResult.get(i).getPrefix(), result.get(i).getPrefix());
        }

    }

    /**
     * Test of getMajors method, of class MajorDAOImpl.
     */
    @Test
    public void testGetMajors() {
        System.out.println("getMajors");
        MajorDAOImpl instance = MajorDAOImpl.getInstance();
        List<Major> expResult = new ArrayList<>();
        expResult.add(new Major(1, "Cong nghe thong tin", "DCCN"));
        expResult.add(new Major(2, "An toan thong tin", "ATTT"));
        expResult.add(new Major(3, "Marketing", "KTMR"));
        expResult.add(new Major(4, "Quan tri kinh doanh", "QTKD"));
        expResult.add(new Major(5, "Dien tu - Vien thong", "DTVT"));
        expResult.add(new Major(6, "Da phuong tien", "DPT"));

        List<Major> result = instance.getMajors();
        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i).getId(), result.get(i).getId());
            assertEquals(expResult.get(i).getName(), result.get(i).getName());
            assertEquals(expResult.get(i).getPrefix(), result.get(i).getPrefix());
        }
    }

    /**
     * Test of getMajorId method, of class MajorDAOImpl.
     */
    @Test
    public void testGetMajorId() {
        System.out.println("getMajorId");
        MajorDAOImpl instance = MajorDAOImpl.getInstance();
        Major expResult = new Major(1, "Cong nghe thong tin", "DCCN");
        Major result = instance.getMajorId(expResult.getName());
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getPrefix(), result.getPrefix());

    }

    /**
     * Test of getMajor method, of class MajorDAOImpl.
     */
    @Test
    public void testGetMajor() {
        System.out.println("getMajor");
        MajorDAOImpl instance = MajorDAOImpl.getInstance();
        Major expResult = new Major(1, "Cong nghe thong tin", "DCCN");
        Major result = instance.getMajor(expResult.getId());
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getPrefix(), result.getPrefix());
    }

}
