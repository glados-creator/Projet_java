package olympic.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Sport
 */
public abstract class Sport {
    /** String Nom */
    private final String Nom;
    /** String Uniter */
    private String Uniter;
    /** private boolean Plus_haut_score */
    private boolean Plus_haut_score;
    /** List[Epreuve] LesEpreuves */
    private List<Epreuve> LesEpreuves;
    /** private final JeuxOlympique JO */
    private final JeuxOlympique JO;

    /** double Coef_Force */
    private double Coef_Force;
    /** double Coef_Agilite */
    private double Coef_Agilite;
    /** double Coef_Endurance */
    private double Coef_Endurance;

    /**
     * Sport
     * 
     * @param JO              JeuxOlympique
     * @param Nom             String
     * @param Uniter          String
     * @param Coef_Force      double
     * @param Coef_Agilite    double
     * @param Coef_Endurance  double
     * @param Plus_haut_score boolean
     */
    public Sport(JeuxOlympique JO, String Nom, String Uniter, double Coef_Force, double Coef_Agilite,
            double Coef_Endurance, boolean Plus_haut_score) {
        this.JO = JO;
        this.Nom = Nom;
        this.Uniter = Uniter;
        this.Plus_haut_score = Plus_haut_score;
        this.LesEpreuves = new ArrayList<>();
        this.Coef_Force = Coef_Force;
        this.Coef_Agilite = Coef_Agilite;
        this.Coef_Endurance = Coef_Endurance;
    }

    /**
     * Sport
     * 
     * @param JO             JeuxOlympique
     * @param Nom            String
     * @param Uniter         String
     * @param Coef_Force     double
     * @param Coef_Agilite   double
     * @param Coef_Endurance double
     */
    public Sport(JeuxOlympique JO, String Nom, String Uniter, double Coef_Force, double Coef_Agilite, double Coef_Endurance) {
        this(JO, Nom, Uniter, Coef_Force, Coef_Agilite, Coef_Endurance, true);
    }

    /**
     * getJO
     * 
     * @return JeuxOlympique
     */
    public JeuxOlympique getJO() {
        return JO;
    }

    /**
     * getNom
     * 
     * @return String
     */
    public String getNom() {
        return Nom;
    }

    /**
     * getUniter
     * 
     * @return String
     */
    public String getUniter() {
        return Uniter;
    }

    /**
     * setUniter_a admin
     * 
     * @param Uniter String
     */
    public void setUniter_a(String Uniter) {
        this.Uniter = Uniter;
    }

    /**
     * getPlus_haut_score
     * 
     * @return boolean
     */
    public boolean getPlus_haut_score() {
        return Plus_haut_score;
    }

    /**
     * setPlus_haut_score_a admin
     * 
     * @param Plus_haut_score boolean
     */
    public void setPlus_haut_score_a(boolean Plus_haut_score) {
        this.Plus_haut_score = Plus_haut_score;
    }

    /**
     * getLesEpreuves
     * 
     * @return Epreuve>
     */
    public List<Epreuve> getLesEpreuves() {
        return LesEpreuves;
    }

    /**
     * setLesEpreuves_a(List admin
     * 
     * @param LesEpreuves Epreuve>
     */
    public void setLesEpreuves_a(List<Epreuve> LesEpreuves) {
        this.LesEpreuves = LesEpreuves;
    }

    /**
     * getCoef_Force
     * 
     * @return double
     */
    public double getCoef_Force() {
        return Coef_Force;
    }

    /**
     * setCoef_Force_a admin
     * 
     * @param Coef_Force double
     */
    public void setCoef_Force_a(double Coef_Force) {
        this.Coef_Force = Coef_Force;
    }

    /**
     * getCoef_Agilite
     * 
     * @return double
     */
    public double getCoef_Agilite() {
        return Coef_Agilite;
    }

    /**
     * setCoef_Agilite_a admin
     * 
     * @param Coef_Agilite double
     */
    public void setCoef_Agilite_a(double Coef_Agilite) {
        this.Coef_Agilite = Coef_Agilite;
    }

    /**
     * getCoef_Endurance
     * 
     * @return double
     */
    public double getCoef_Endurance() {
        return Coef_Endurance;
    }

    /**
     * setCoef_Endurance_a admin
     * 
     * @param Coef_Endurance double
     */
    public void setCoef_Endurance_a(double Coef_Endurance) {
        this.Coef_Endurance = Coef_Endurance;
    }

    /**
     * ajouter_epreuve
     * 
     * @param epreuve Epreuve
     */
    public void ajouter_epreuve(Epreuve epreuve) {
        LesEpreuves.add(epreuve);
    }

    /**
     * toString
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "{" +
                " 'Nom':'" + getNom() + "'" +
                ", 'Uniter':'" + getUniter() + "'" +
                ", 'Plus_haut_score':'" + getPlus_haut_score() + "'" +
                ", 'LesEpreuves':" + getLesEpreuves() + "" +
                ", 'Coef_Force':'" + getCoef_Force() + "'" +
                ", 'Coef_Agilite':'" + getCoef_Agilite() + "'" +
                ", 'Coef_Endurance':'" + getCoef_Endurance() + "'" +
                "}";
    }

}