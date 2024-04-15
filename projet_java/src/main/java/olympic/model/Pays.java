package olympic.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Pays
 */
public class Pays {
    /** String nom */
    private String nom;
    /** int medaille_or */
    private int medaille_or;
    /** int medaille_argent */
    private int medaille_argent;
    /** int medaille_bronze */
    private int medaille_bronze;
    /** List[Athlete] les_athletes */
    private List<Athlete> les_athletes;

    /**
     * ajouter_athletes
     * @param athlete Athlete
     */
    public void ajouter_athletes(Athlete athlete){
        les_athletes.add(athlete);
    }

    /**
     * les_athletes admin
     * @return List[Athlete]
     */
    public List<Athlete> les_athletes(){
        return les_athletes;
    }

    /**
     * Pays
     * @param nom String
     * @param medaille_or int
     * @param medaille_argent int
     * @param medaille_bronze int
     */
    public Pays(String nom, int medaille_or, int medaille_argent, int medaille_bronze) {
        this.nom = nom;
        this.medaille_or = medaille_or;
        this.medaille_argent = medaille_argent;
        this.medaille_bronze = medaille_bronze;
        les_athletes = new ArrayList<>();

    }

    /**
     * getNom
     * @return String
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * getMedaille_or
     * @return int
     */
    public int getMedaille_or() {
        return this.medaille_or;
    }

    /**
     * getMedaille_argent
     * @return int
     */
    public int getMedaille_argent() {
        return this.medaille_argent;
    }
    /**
     * getMedaille_bronze
     * @return int
     */
    public int getMedaille_bronze() {
        return this.medaille_bronze;
    }

    /**
     * nom admin
     * @param nom String
     * @return Pays
     */
    public Pays nom(String nom) {
        this.nom = nom;
        return this;
    }

    /**
     * medaille_or admin
     * @param medaille_or int
     * @return Pays
     */
    public Pays medaille_or(int medaille_or) {
        this.medaille_or = medaille_or;
        return this;
    }

    /**
     * medaille_argent admin
     * @param medaille_argent int
     * @return Pays
     */
    public Pays medaille_argent(int medaille_argent) {
        this.medaille_argent = medaille_argent;
        return this;
    }

    /**
     * medaille_bronze admin
     * @param medaille_bronze int
     * @return Pays
     */
    public Pays medaille_bronze(int medaille_bronze) {
        this.medaille_bronze = medaille_bronze;
        return this;
    }

    /**
     * equals
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pays)) {
            return false;
        }
        Pays pays = (Pays) o;
        return Objects.equals(nom, pays.nom) && Objects.equals(medaille_or, pays.medaille_or)
                && Objects.equals(medaille_argent, pays.medaille_argent)
                && Objects.equals(medaille_bronze, pays.medaille_bronze);
    }

    /**
     * hashCode
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(nom, medaille_or, medaille_argent, medaille_bronze);
    }

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        return "{" +
                " nom='" + getNom() + "'" +
                ", medaille_or='" + getMedaille_or() + "'" +
                ", medaille_argent='" + getMedaille_argent() + "'" +
                ", medaille_bronze='" + getMedaille_bronze() + "'" +
                "}";
    }

}