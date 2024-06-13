package olympic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import olympic.model.Athlete;
import olympic.model.Equipe;

import static org.junit.jupiter.api.Assertions.*;

public class EquipeTest {

    private Equipe equipe;

    @BeforeEach
    public void setUp() {
        equipe = new Equipe("Team A");
    }

    @Test
    public void testEquipeConstructor() {
        assertEquals("Team A", equipe.getNom());
    }

    @Test
    public void testAddAthlete() {
        Athlete athlete = new Athlete("John", true, 8.0, 7.5, 9.0);
        equipe.ajouter_athlete(athlete);
        assertEquals(1, equipe.les_athletes().size());
        assertEquals(athlete, equipe.les_athletes().get(0));
    }

    @Test
    public void testEqualsAndHashCode() {
        Equipe equipe1 = new Equipe("Team A");
        Equipe equipe2 = new Equipe("Team A");
        Equipe equipe3 = new Equipe("Team B");

        assertEquals(equipe1, equipe2);
        assertNotEquals(equipe1, equipe3);
        assertEquals(equipe1.hashCode(), equipe2.hashCode());
        assertNotEquals(equipe1.hashCode(), equipe3.hashCode());
    }

    @Test
    public void testToString() {
        String expected = "{ nom='Team A' }";
        assertEquals(expected, equipe.toString());
    }
}
