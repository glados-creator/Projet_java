package olympic;

import olympic.model.Athlete;
import olympic.model.JeuxOlympique;
import olympic.model.Pays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

public class AthleteTest extends TestCase {
    
    private final static double Test_Coef_Force = 0.4;
    private final static double Test_Coef_Agilite = 0.3;
    private final static double Test_Coef_Endurance = 0.3;

    private olympic.model.JeuxOlympique JO;
    private Pays pays;
    private Athlete internal;

    @BeforeEach
    public void setUp() {
        JO = new JeuxOlympique(0, "test");
        pays = new Pays(JO, "test_nom", 0, 0, 0);
        internal = new Athlete("test_nom", "test_prenom", false, Test_Coef_Force, Test_Coef_Agilite, Test_Coef_Endurance, pays);
    }

    @Test
    public void test_ToString() {
        assertEquals("{Nom='test_nom', Sex='false', force='0.4', Agilite='0.3', endurance='0.3'}", internal.toString());
    }

    
    @Test
    public void test_getNom() {
    assertEquals("test_nom" ,internal.getNom());
    }

    
    @Test
    public void test_getPrenom() {
    assertEquals("test_prenom" ,internal.getPrenom());
    }

    
    @Test
    public void test_setPrenom_a() {
        String old = internal.getPrenom();
        internal.setPrenom_a("null");
        assertEquals("null",internal.getPrenom());
        internal.setPrenom_a(old);
        assertEquals(old,internal.getPrenom());
    }

    
    @Test
    public void test_getSex() {
    assertEquals(false ,internal.getSex());
    }

    
    @Test
    public void test_setSex_a() {
        boolean old = internal.getSex();
        internal.setSex_a(!old);
        assertEquals(!old,internal.getSex());
        internal.setSex_a(old);
        assertEquals(old,internal.getSex());
    }

    
    @Test
    public void test_getForce() {
    assertEquals(Test_Coef_Force ,internal.getForce());
    }

    
    @Test
    public void test_setForce_a() {
        double old = internal.getForce();
        internal.setForce_a(0.01);
        assertEquals(0.01,internal.getForce());
        internal.setForce_a(old);
        assertEquals(old,internal.getForce());
        assertEquals(Test_Coef_Force,internal.getForce());
    }

    
    @Test
    public void test_getAgilite() {
    assertEquals(Test_Coef_Agilite ,internal.getAgilite());
    }

    
    @Test
    public void test_setAgilite_a() {
        double old = internal.getAgilite();
        internal.setAgilite_a(0.01);
        assertEquals(0.01,internal.getAgilite());
        internal.setAgilite_a(old);
        assertEquals(old,internal.getAgilite());
        assertEquals(Test_Coef_Agilite,internal.getAgilite());
    }

    
    @Test
    public void test_getEndurance() {
    assertEquals(Test_Coef_Endurance ,internal.getEndurance());
    }

    
    @Test
    public void test_setEndurance_a() {
        double old = internal.getEndurance();
        internal.setEndurance_a(0.01);
        assertEquals(0.01,internal.getEndurance());
        internal.setEndurance_a(old);
        assertEquals(old,internal.getEndurance());
        assertEquals(Test_Coef_Endurance,internal.getEndurance());
    }

    
    @Test
    public void test_getOrigine() {
    assertEquals(pays ,internal.getOrigine());
    }

    
    @Test
    public void isMembre() {
        assertEquals(false, internal.isMembre());    
        assertEquals(null, internal.getMembre());    
    }    
}
