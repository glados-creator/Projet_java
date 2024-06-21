package olympic.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Equipe
 */
public class Equipe implements Participant {

    /** private String Nom */
    private final String Nom;
    /** private boolean Sex */
    private final boolean Sex;
    /** private boolean Mix */
    private boolean Mix;
    /** private Pays Origine */
    private final Pays Origine;
    /** List[Athlete] LesAthletes */
    private List<Athlete> LesAthletes;

    /**
     * Equipe constructor
     * 
     * @param Nom     String
     * @param Sex     boolean
     * @param Origine Pays
     */
    public Equipe(String Nom, boolean Sex, Pays Origine) {
        this.Nom = Nom;
        this.Sex = Sex;
        this.Origine = Origine;
        Mix = false;
        this.LesAthletes = new ArrayList<Athlete>();
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
     * getSex
     * 
     * @return boolean
     */
    public boolean getSex() {
        return Sex;
    }

    /**
     * getForce
     * 
     * @return double
     */
    public double getForce() {
        return LesAthletes.stream().mapToDouble(ath -> ath.getForce()).average().getAsDouble();
    }

    /**
     * getAgilite
     * 
     * @return double
     */
    public double getAgilite() {
        return LesAthletes.stream().mapToDouble(ath -> ath.getAgilite()).average().getAsDouble();
    }

    /**
     * getEndurance
     * 
     * @return double
     */
    public double getEndurance() {
        return LesAthletes.stream().mapToDouble(ath -> ath.getEndurance()).average().getAsDouble();
    }

    /**
     * getOrigine
     * 
     * @return double
     */
    public Pays getOrigine() {
        return Origine;
    }

    /**
     * getMix
     * @return boolean
     */
    public boolean getMix() {
        return this.Mix;
    }
    /**
     * setMix_a admin
     * @param Mix boolean
     */
    public void setMix_a(boolean Mix) {
        this.Mix = Mix;
    }
    /**
     * getLesAthletes
     * @return List[Athlete]
     */
    public List<Athlete> getLesAthletes() {
        return this.LesAthletes;
    }

    /** toString
     * @return String
     */
    @Override
    public String toString() {
        return "{" +
                " 'Nom':'" + getNom() + "'" +
                ", 'Origine':'" + getOrigine() + "'" +
                ", 'Sex':'" + getSex() + "'" +
                ", 'Mix':'" + getMix() + "'" +
                ", 'force':'" + getForce() + "'" +
                ", 'Agilite':'" + getAgilite() + "'" +
                ", 'endurance':'" + getEndurance() + "'" +
                ", 'LesAthletes':" + getLesAthletes() + "" +
                "}";
    }

}