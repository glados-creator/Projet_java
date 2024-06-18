package olympic.model;

// TODO: sync with datamanager

import java.util.ArrayList;
import java.util.List;

/**
 * Pays
 */
public class Pays {
    /** String Nom */
    private String Nom;
    /** int Medaille_or */
    private int Medaille_or;
    /** int Medaille_argent */
    private int Medaille_argent;
    /** int Medaille_bronze */
    private int Medaille_bronze;
    /** List[Athlete] lesAthletes */
    private List<Athlete> lesAthletes;

    /**
     * Pays
     * 
     * @param Nom             String
     * @param Medaille_or     int
     * @param Medaille_argent int
     * @param Medaille_bronze int
     */
    public Pays(String Nom, int Medaille_or, int Medaille_argent, int Medaille_bronze) {
        this.Nom = Nom;
        this.Medaille_or = Medaille_or;
        this.Medaille_argent = Medaille_argent;
        this.Medaille_bronze = Medaille_bronze;
        lesAthletes = new ArrayList<>();

    }

    /**
     * getNom
     * 
     * @return String
     */
    public String getNom() {
        return this.Nom;
    }

    /**
     * getMedaille_or
     * 
     * @return int
     */
    public int getMedaille_or() {
        return this.Medaille_or;
    }

    /**
     * getMedaille_argent
     * 
     * @return int
     */
    public int getMedaille_argent() {
        return this.Medaille_argent;
    }

    /**
     * getMedaille_bronze
     * 
     * @return int
     */
    public int getMedaille_bronze() {
        return this.Medaille_bronze;
    }

    /**
     * ajouter_athletes
     * 
     * @param athlete Athlete
     */
    public void ajouter_athletes(Athlete athlete) {
        lesAthletes.add(athlete);
    }

    /**
     * lesAthletes admin
     * 
     * @return List[Athlete]
     */
    public List<Athlete> lesAthletes() {
        return lesAthletes;
    }

    /**
     * Nom setNom_a
     * 
     * @param Nom String
     */
    public void setNom_a(String Nom) {
        this.Nom = Nom;
    }

    /**
     * setMedaille_or_a admin
     * 
     * @param Medaille_or int
     */
    public void setMedaille_or_a(int Medaille_or) {
        this.Medaille_or = Medaille_or;
    }

    /**
     * setMedaille_argent_a admin
     * 
     * @param Medaille_argent int
     */
    public void setMedaille_argent_a(int Medaille_argent) {
        this.Medaille_argent = Medaille_argent;
    }

    /**
     * setMedaille_bronze_a admin
     * 
     * @param Medaille_bronze int
     */
    public void setMedaille_bronze_a(int Medaille_bronze) {
        this.Medaille_bronze = Medaille_bronze;
    }

    /**
     * toString
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "{" +
                " Nom='" + getNom() + "'" +
                ", Medaille_or='" + getMedaille_or() + "'" +
                ", Medaille_argent='" + getMedaille_argent() + "'" +
                ", Medaille_bronze='" + getMedaille_bronze() + "'" +
                "}";
    }

}