/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import static com.jayway.restassured.RestAssured.basePath;
import static com.jayway.restassured.RestAssured.baseURI;
import static com.jayway.restassured.RestAssured.defaultParser;
import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.parsing.Parser;
import java.util.Date;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
public class LinkResourceTest {

    public LinkResourceTest() {
    }

    @BeforeClass
    public static void setUpClass() {

        baseURI = "http://localhost:8080/Momondo";
        defaultParser = Parser.JSON;
        basePath = "/api";
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
     * Test of getJson method, of class LinkResource.
     */
    @Test
    public void testGetJson_0args() throws Exception {
        given()
                .contentType(MediaType.APPLICATION_JSON)
                .when()
                .get("/link")
                .then().
                statusCode(200);
    }

    /**
     * Test of getJson method, of class LinkResource.
     */
    @Ignore
    public void testGetJson_3args() throws Exception {
        System.out.println("getJson");
        String from = "";
        String date = null;
        int numbers = 0;
        LinkResource instance = new LinkResource();
        Response expResult = null;
        Response result = instance.getJson(from, date, numbers);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJson method, of class LinkResource.
     */
    @Ignore
    public void testGetJson_4args() throws Exception {
        System.out.println("getJson");
        String from = "";
        String to = "";
        Date date = null;
        int numbers = 0;
        LinkResource instance = new LinkResource();
        Response expResult = null;
        Response result = instance.getJson(from, to, date, numbers);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJsonToAndFrom method, of class LinkResource.
     */
    @Test
    public void testGetJsonToAndFrom() throws Exception {

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .when()
                .get("/link/toandfrom")
                .then().
                statusCode(200);
    }

}
