package olympic.sport_type;

import olympic.model.JeuxOlympique;
import olympic.model.sport_type.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

/**
 * EscrimeTest
 */
public class EscrimeTest extends TestCase{
    private olympic.model.sport_type.Escrime internal;
    private olympic.model.JeuxOlympique JO;

    private final static double Test_Coef_Force = 0.3;
    private final static double Test_Coef_Agilite = 0.5;
    private final static double Test_Coef_Endurance = 0.2;
    private final static String Test_uniter = "points";

    @BeforeEach
    public void setUp() {
        JO = new JeuxOlympique(0, "test");
        internal = new Escrime(JO);
    }

    
    @Test
    public void test_ToString() {
        assertEquals(internal.toString(),"{ Nom='Escrime', Uniter='points', Plus_haut_score='true', LesEpreuves='[]', Coef_Force='0.3', Coef_Agilite='0.5', Coef_Endurance='0.2'}");
    }

    @Test
    public void test_getJO() {
        assertEquals(internal.getJO(),JO);
    }

    @Test
    public void test_getNom() {
        assertEquals(internal.getNom(),"Escrime");
    }

    @Test
    public void test_getUniter() {
        assertEquals(internal.getUniter(),Test_uniter);
    }

    @Test
    public void test_setUniter_a() {
        internal.setUniter_a("test");
        assertEquals(internal.getUniter(),"test");
        internal.setUniter_a(Test_uniter);
        assertEquals(internal.getUniter(),Test_uniter);
    }

    @Test
    public void test_getPlus_haut_score() {
        assertEquals(internal.getPlus_haut_score(),true);
    }

    @Test
    public void test_setPlus_haut_score_a() {
        boolean old = internal.getPlus_haut_score();
        internal.setPlus_haut_score_a(!old);
        assertEquals(internal.getPlus_haut_score(),!old);
        internal.setPlus_haut_score_a(old);
        assertEquals(internal.getPlus_haut_score(),old);
    }


    @Test
    public void test_getCoef_Force() {
        assertEquals(internal.getCoef_Force(),Test_Coef_Force);
    }

    @Test
    public void test_setCoef_Force_a() {
        internal.setCoef_Force_a(0.01);
        assertEquals(internal.getCoef_Force(),0.01);
        internal.setCoef_Force_a(Test_Coef_Force);
        assertEquals(internal.getCoef_Force(),Test_Coef_Force);
    }

    @Test
    public void test_getCoef_Agilite() {
        assertEquals(internal.getCoef_Agilite(),Test_Coef_Agilite);
    }

    @Test
    public void test_setCoef_Agilite_a() {
            internal.setCoef_Agilite_a(0.01);
            assertEquals(internal.getCoef_Agilite(),0.01);
            internal.setCoef_Agilite_a(Test_Coef_Agilite);
            assertEquals(internal.getCoef_Agilite(),Test_Coef_Agilite);
    }

    @Test
    public void test_getCoef_Endurance() {
        assertEquals(internal.getCoef_Endurance(),Test_Coef_Endurance);
    }
    
    @Test
    public void test_setCoef_Endurance_a() {
            internal.setCoef_Endurance_a(0.01);
            assertEquals(internal.getCoef_Endurance(),0.01);
            internal.setCoef_Endurance_a(Test_Coef_Endurance);
            assertEquals(internal.getCoef_Endurance(),Test_Coef_Endurance);
    }
}