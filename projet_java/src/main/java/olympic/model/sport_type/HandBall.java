package olympic.model.sport_type;

import olympic.model.JeuxOlympique;
import olympic.model.Sport;

/**
 * HandBall
 */
public class HandBall extends Sport {
    /** HandBall constructor 
     * @param JO JeuxOlympique
    */
    public HandBall(JeuxOlympique JO) {
        super(JO, "HandBall", "points", 0.35, 0.25, 0.40);
    }
}