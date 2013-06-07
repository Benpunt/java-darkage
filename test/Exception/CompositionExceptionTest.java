/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jappie
 */
public class CompositionExceptionTest {
    
    public CompositionExceptionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
	System.out.print("CompositionException test: ");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of Check method, of class CompositionException.
     * Checks if a exception is thrown when parameter was null
     */
    @Test
    public void testCheckTrown() {
	System.out.println("is thrown");
	Object parameter = null;
	String subject = "";
	String component = "";
	try{
	CompositionException.Check(parameter, subject, component);
	fail("No exception thrown when excpected");
	}catch(CompositionException e){}
	
    }
    /**
     * Checks if parameter was not thrown when parameter was not null
     */    
        @Test
    public void testCheckNotTrown() {
	System.out.println("is not thrown");
	Object parameter = 3;
	String subject = "";
	String component = "";
	try{
	CompositionException.Check(parameter, subject, component);
	
	}catch(CompositionException e){
	fail("No exception expected");
	}
	
    }
    
    
}
