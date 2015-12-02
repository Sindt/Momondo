/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Link;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Sindt
 */
public class LinkFacadeTest {
    
    public LinkFacadeTest() {
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
     * Test of addLink method, of class LinkFacade.
     */
    @Ignore
    public void testAddLink() {
        System.out.println("addLink");
        Link expResult = null;
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLink method, of class LinkFacade.
     */
    @Test
    public void testGetLink() {
        System.out.println("getLink");
        Long id = 1L;
        LinkFacade instance = new LinkFacade();
        Link result = instance.getLink(id);
        System.out.println(result.getUrl());
        assertNotNull(result);
    }

    /**
     * Test of getAllLinks method, of class LinkFacade.
     */
    @Test
    public void testGetAllLinks() {
        System.out.println("getAllLinks");
        LinkFacade instance = new LinkFacade();
        List<Link> result = instance.getAllLinks();
        System.out.println(result.get(0).getUrl());
        assertNotNull(result);
    }
    
}
