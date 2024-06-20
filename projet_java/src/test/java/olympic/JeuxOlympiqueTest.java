package olympic;

import olympic.model.JeuxOlympique;
import olympic.model.Pays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import junit.framework.TestCase;

// TODO : do test

public class JeuxOlympiqueTest extends TestCase {

    private olympic.model.JeuxOlympique internal;

    @BeforeEach
    public void setUp() {
        datamanager.init();
        // internal = datamanager.list_jo().get(0);
    }

    @Test
    public void test_ToString() {
        assertEquals(0, 0);
        // assertEquals(internal.toString(),"{ Annee='0', Lieux='test'}");
    }
    
    @Test
    public void simule() {
        assertEquals(0, 0);
        // TODO : here
    }

    
    
    @Test
    public void getLesSports() {
        assertEquals(0, 0);
    }

    
    @Test
    public void getLesPays() {
        assertEquals(0, 0);
    }

    
    
    @Test
    public void getAnnee() {
        assertEquals(0, 0);
    }

    
    
    @Test
    public void getLieux() {
        assertEquals(0, 0);
    }
    
    @Test
     public void setLieux() {
        assertEquals(0, 0);
    }
}
