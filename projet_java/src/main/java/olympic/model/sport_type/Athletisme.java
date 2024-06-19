package olympic.model.sport_type;

import olympic.model.JeuxOlympique;
import olympic.model.Sport;

/**
 * Athletisme
 */
public class Athletisme extends Sport {
    /** Athletisme constructor 
     * @param JO JeuxOlympique
    */
    public Athletisme(JeuxOlympique JO) {
        super(JO, "Athletisme", "sec", 0.40, 0.30, 0.30, false);
    }
}