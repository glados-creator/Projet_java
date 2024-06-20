package olympic.model.sport_type;

import olympic.model.JeuxOlympique;
import olympic.model.Sport;

/**
 * Natation
 */
public class Natation extends Sport {
    /** Natation constructor 
     * @param JO JeuxOlympique
    */
    public Natation(JeuxOlympique JO) {
        super(JO, "Natation", "sec", 0.30, 0.30, 0.40, false);
    }
}