package olympic.model.sport_type;

import olympic.model.JeuxOlympique;
import olympic.model.Sport;

/**
 * generic
 */
public class sport_type_generic extends Sport {
    /**
     * generic
     * 
     * @param JO              JeuxOlympique
     * @param Nom             String
     * @param Uniter          String
     * @param Coef_Force      double
     * @param Coef_Agilite    double
     * @param Coef_Endurance  double
     * @param Plus_haut_score boolean
     */
    public sport_type_generic(JeuxOlympique JO, String Nom, String Uniter, double Coef_Force, double Coef_Agilite,
            double Coef_Endurance, boolean Plus_haut_score) {
        super(JO, Nom,
                Uniter,
                Coef_Force,
                Coef_Agilite,
                Coef_Endurance,
                Plus_haut_score);
    }

    /**
     * generic
     * 
     * @param JO             JeuxOlympique
     * @param Nom            String
     * @param Uniter         String
     * @param Coef_Force     double
     * @param Coef_Agilite   double
     * @param Coef_Endurance double
     */
    public sport_type_generic(JeuxOlympique JO, String Nom, String Uniter, double Coef_Force, double Coef_Agilite,
            double Coef_Endurance) {
        super(JO, Nom,
                Uniter,
                Coef_Force,
                Coef_Agilite,
                Coef_Endurance);
    }
}