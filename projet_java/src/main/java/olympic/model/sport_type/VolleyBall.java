package olympic.model.sport_type;

import olympic.model.JeuxOlympique;
import olympic.model.Sport;

/**
 * VolleyBall
 */
public class VolleyBall extends Sport {
    /** VolleyBall constructor
     * @param JO JeuxOlympique
     */
    public VolleyBall(JeuxOlympique JO) {
        super(JO, "VolleyBall", "points", 0.25, 0.40, 0.35);
    }
}