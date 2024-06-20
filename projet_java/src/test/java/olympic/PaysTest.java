package olympic;

import olympic.model.JeuxOlympique;
import olympic.model.Pays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import junit.framework.TestCase;

public class PaysTest extends TestCase {
    private olympic.model.JeuxOlympique JO;
    private Pays internal;

    @BeforeEach
    public void setUp() {
        JO = new JeuxOlympique(0, "test");
        internal = new Pays(JO, "test_nom", 0, 0, 0);
    }

    @Test
    public void test_ToString() {
        assertEquals("{ Nom='test_nom', Medaille_or='0', Medaille_argent='0', Medaille_bronze='0'}", internal.toString());
    }

    @Test
    public void getJO() {
        assertEquals(JO, internal.getJO());
    }

    @Test
    public void getNom() {
        assertEquals("test_nom", internal.getNom());
    }

    @Test
    public void getMedaille_or() {
        assertEquals(0, internal.getMedaille_or());
    }

    @Test
    public void getMedaille_argent() {
        assertEquals(0, internal.getMedaille_argent());
    }

    @Test
    public void getMedaille_bronze() {
        assertEquals(0, internal.getMedaille_bronze());
    }

    @Test
    public void setMedaille_or_a() {
        int old = internal.getMedaille_or();
        internal.setMedaille_or_a(99);
        assertEquals(99, internal.getMedaille_or());
        internal.setMedaille_or_a(old);
        assertEquals(old, internal.getMedaille_or());
    }

    @Test
    public void setMedaille_argent_a() {
        int old = internal.getMedaille_argent();
        internal.setMedaille_argent_a(99);
        assertEquals(99, internal.getMedaille_argent());
        internal.setMedaille_argent_a(old);
        assertEquals(old, internal.getMedaille_argent());
    }

    @Test
    public void setMedaille_bronze_a() {
        int old = internal.getMedaille_bronze();
        internal.setMedaille_bronze_a(99);
        assertEquals(99, internal.getMedaille_bronze());
        internal.setMedaille_bronze_a(old);
        assertEquals(old, internal.getMedaille_bronze());
    }
}
