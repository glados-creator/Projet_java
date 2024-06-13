package olympic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import olympic.model.JeuxOlympique;
import olympic.model.Sport;

import static org.junit.jupiter.api.Assertions.*;

public class JeuxOlympiqueTest {

    private JeuxOlympique jeuxOlympique;

    @BeforeEach
    public void setUp() {
        jeuxOlympique = new JeuxOlympique("2024", "Paris");
    }

    @Test
    public void testJeuxOlympiqueConstructor() {
        assertEquals("2024", jeuxOlympique.getAnnee());
        assertEquals("Paris", jeuxOlympique.getLieux());
    }

    @Test
    public void testAddSport() {
        Sport sport = new Sport("Athletisme", "m",1,1,1) {};
        jeuxOlympique.ajouter_sports(sport);
        assertEquals(1, jeuxOlympique.les_sports().size());
        assertEquals(sport, jeuxOlympique.les_sports().get(0));
    }

    @Test
    public void testEqualsAndHashCode() {
        JeuxOlympique jeux1 = new JeuxOlympique("2024", "Paris");
        JeuxOlympique jeux2 = new JeuxOlympique("2024", "Paris");
        JeuxOlympique jeux3 = new JeuxOlympique("2020", "Tokyo");

        assertEquals(jeux1, jeux2);
        assertNotEquals(jeux1, jeux3);
        assertEquals(jeux1.hashCode(), jeux2.hashCode());
        assertNotEquals(jeux1.hashCode(), jeux3.hashCode());
    }

    @Test
    public void testToString() {
        String expected = "{ annee='2024', lieux='Paris' }";
        assertEquals(expected, jeuxOlympique.toString());
    }
}
