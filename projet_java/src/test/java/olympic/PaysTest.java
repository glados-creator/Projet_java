package olympic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import olympic.model.Athlete;
import olympic.model.Pays;

import static org.junit.jupiter.api.Assertions.*;

public class PaysTest {

    private Pays pays;

    @BeforeEach
    public void setUp() {
        pays = new Pays("France", 10, 20, 30);
    }

    @Test
    public void testPaysConstructor() {
        assertEquals("France", pays.getNom());
        assertEquals(10, pays.getMedaille_or());
        assertEquals(20, pays.getMedaille_argent());
        assertEquals(30, pays.getMedaille_bronze());
    }

    @Test
    public void testAddAthlete() {
        Athlete athlete = new Athlete("John", true, 8.0, 7.5, 9.0);
        pays.ajouter_athletes(athlete);
        assertEquals(1, pays.les_athletes().size());
        assertEquals(athlete, pays.les_athletes().get(0));
    }

    @Test
    public void testEqualsAndHashCode() {
        Pays pays1 = new Pays("France", 10, 20, 30);
        Pays pays2 = new Pays("France", 10, 20, 30);
        Pays pays3 = new Pays("USA", 5, 10, 15);

        assertEquals(pays1, pays2);
        assertNotEquals(pays1, pays3);
        assertEquals(pays1.hashCode(), pays2.hashCode());
        assertNotEquals(pays1.hashCode(), pays3.hashCode());
    }

    @Test
    public void testToString() {
        String expected = "{ nom='France', medaille_or='10', medaille_argent='20', medaille_bronze='30' }";
        assertEquals(expected, pays.toString());
    }
}
