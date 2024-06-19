package olympic.model.sport_type;

import olympic.model.JeuxOlympique;
import olympic.model.Sport;

/**
 * Escrime
 */
public class Escrime extends Sport {
    /** Escrime constructor 
     * @param JO JeuxOlympique
    */
    public Escrime(JeuxOlympique JO) {
        super(JO, "Escrime", "points", 0.30, 0.50, 0.20);
    }
}