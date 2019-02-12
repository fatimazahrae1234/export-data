package org.exportXLSX.ServiceChild;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.ws.Response;

import org.springframework.test.web.servlet.MockMvc;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    
    public void testSetvice() throws IllegalArgumentException, IllegalAccessException, IOException {
    	Service service = new Service();
    	ArrayList<Personne> data = new ArrayList<Personne>();
    	data.add(new Personne("nom","prenom","email@gmail.com","rueXXX"));
    	assertEquals("datamultiType.xlsx", service.multiExport(data).getNomFichier());
    	assertNotNull(service.multiExport(data).getData());
    }
    
   
}
