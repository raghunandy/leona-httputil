/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leona.httputil;

import leona.httputil.SingleLineHttpClient;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Raghu
 */
public class SingleLineHttpClientTest {
    
    public SingleLineHttpClientTest() {
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
     * Test of post method, of class SingleLineHttpClient.
     */
    @Test
    public void testPost() {
        System.out.println("post");
        String url = "";
        String data = "";
        SingleLineHttpClient instance =  SingleLineHttpClient.instance();
        System.out.println("Google Data:"+instance.post("http://google.com", "what ever data"));
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
