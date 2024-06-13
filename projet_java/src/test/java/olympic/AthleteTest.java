package olympic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import olympic.model.Athlete;

import static org.junit.jupiter.api.Assertions.*;

public class AthleteTest {

    private Athlete athlete;

    @BeforeEach
    public void setUp() {
        athlete = new Athlete("John", true, 8.0, 7.5, 9.0);
    }

    @Test
    public void testAthleteConstructor() {
        assertEquals("John", athlete.getNom());
        assertTrue(athlete.getSex());
        assertEquals(8.0, athlete.getForce());
        assertEquals(7.5, athlete.getAgilité());
        assertEquals(9.0, athlete.getEndurance());
    }

    @Test
    public void testSettersAndGetters() {
        athlete.setNom("Jane");
        athlete.setSex(false);
        athlete.setForce(9.0);
        athlete.setAgilité(8.5);
        athlete.setEndurance(10.0);

        assertEquals("Jane", athlete.getNom());
        assertFalse(athlete.getSex());
        assertEquals(9.0, athlete.getForce());
        assertEquals(8.5, athlete.getAgilité());
        assertEquals(10.0, athlete.getEndurance());
    }

    @Test
    public void testEqualsAndHashCode() {
        Athlete athlete1 = new Athlete("John", true, 8.0, 7.5, 9.0);
        Athlete athlete2 = new Athlete("John", true, 8.0, 7.5, 9.0);
        Athlete athlete3 = new Athlete("Jane", false, 9.0, 8.5, 10.0);

        assertEquals(athlete1, athlete2);
        assertNotEquals(athlete1, athlete3);
        assertEquals(athlete1.hashCode(), athlete2.hashCode());
        assertNotEquals(athlete1.hashCode(), athlete3.hashCode());
    }

    @Test
    public void testToString() {
        String expected = "{ nom='John', Sex='true', force='8.0', agilité='7.5', endurance='9.0' }";
        assertEquals(expected, athlete.toString());
    }
}
