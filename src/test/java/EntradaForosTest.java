/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.eci.pdsw.samples.persistence.DaoFactory;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 2107713
 */
public class EntradaForosTest {
    
    public EntradaForosTest() {
    }
    
   
    @Before
    public void setUp() {
    }
    @Test
    public void consultarEntradaforoSinComentarios() throws SQLException, PersistenceException, IOException{
        Properties properties=new PropertiesLoader().readProperties("applicationconfig.properties");

        
        DaoFactory daof=DaoFactory.getInstance(properties);
        
        daof.beginSession();
        assertEquals(0,daof.getDaoEntradaForo().load(4).getRespuestas().size());
        daof.commitTransaction();
        daof.endSession();
        
        
    }
}
class PropertiesLoader {

    public Properties readProperties(String fileName) throws IOException {
        InputStream input = null;
        Properties properties = new Properties();
        input = this.getClass().getClassLoader().getResourceAsStream(fileName);
        properties.load(input);
        return properties;
    }
}
