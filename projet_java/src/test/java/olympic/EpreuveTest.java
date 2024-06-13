package olympic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import olympic.model.Athlete;
import olympic.model.Epreuve;
import olympic.model.Participant;

import static org.junit.jupiter.api.Assertions.*;

public class EpreuveTest {

    private Epreuve epreuve;

    @BeforeEach
    public void setUp() {
        epreuve = new Epreuve(true, "100m Sprint");
    }

    @Test
    public void testEpreuveConstructor() {
        assertTrue(epreuve.getSex());
        assertEquals("100m Sprint", epreuve.getNom());
    }

    @Test
    public void testAddParticipant() {
        Participant participant = new Athlete("John", true, 8.0, 7.5, 9.0);
        epreuve.ajouter_sports(participant);
        assertEquals(1, epreuve.les_participants().size());
        assertEquals(participant, epreuve.les_participants().get(0));
    }

    @Test
    public void testEqualsAndHashCode() {
        Epreuve epreuve1 = new Epreuve(true, "100m Sprint");
        Epreuve epreuve2 = new Epreuve(true, "100m Sprint");
        Epreuve epreuve3 = new Epreuve(false, "200m Sprint");

        assertEquals(epreuve1, epreuve2);
        assertNotEquals(epreuve1, epreuve3);
        assertEquals(epreuve1.hashCode(), epreuve2.hashCode());
        assertNotEquals(epreuve1.hashCode(), epreuve3.hashCode());
    }

    @Test
    public void testToString() {
        String expected = "{nom='100m Sprint', sex='true'}";
        assertEquals(expected, epreuve.toString());
    }
}
