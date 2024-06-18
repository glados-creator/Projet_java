package olympic.model;

// TODO: sync with datamanager

import java.util.ArrayList;
import java.util.List;

/**
 * Equipe
 */
public class Equipe implements Participant {

    /** private String nom */
    private final String nom;
    /** private boolean Sex */
    private final boolean Sex;
    /** private boolean Mix */
    private boolean Mix;
    /** private Pays Origine */
    private final Pays Origine;
    /** List[Athlete] les_athletes */
    private List<Athlete> les_athletes;

    // TODO : remove athlete copy
    /** private double force */
    private double force;
    /** private double Agilite */
    private double Agilite;
    /** private double endurance */
    private double endurance;

    public Equipe(String nom, boolean Sex, Pays Origine) {
        this.nom = nom;
        this.Sex = Sex;
        this.Origine = Origine;
        Mix = false;
        this.les_athletes = new ArrayList<Athlete>();
    }

    // TODO : this is athlete code

    /**
     * getNom
     * 
     * @return String
     */
    public String getNom() {
        return nom;
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
        return force;
    }

    /**
     * setForce_a admin
     * 
     * @param force double
     */
    public void setForce_a(double force) {
        this.force = force;
    }

    /**
     * getAgilite
     * 
     * @return double
     */
    public double getAgilite() {
        return Agilite;
    }

    /**
     * setAgilite_a admin
     * 
     * @param Agilite double
     */
    public void setAgilite_a(double Agilite) {
        this.Agilite = Agilite;
    }

    /**
     * getEndurance
     * 
     * @return double
     */
    public double getEndurance() {
        return endurance;
    }

    /**
     * setEndurance_a admin
     * 
     * @param endurance double
     */
    public void setEndurance_a(double endurance) {
        this.endurance = endurance;
    }

    /**
     * getOrigine
     * 
     * @return double
     */
    public Pays getOrigine() {
        return Origine;
    }

    // TODO : comment signature and remove uneccessary

    public boolean getMix() {
        return this.Mix;
    }

    public void setMix(boolean Mix) {
        this.Mix = Mix;
    }

    public List<Athlete> getLes_athletes() {
        return this.les_athletes;
    }

    public void setLes_athletes(List<Athlete> les_athletes) {
        this.les_athletes = les_athletes;
    }

    @Override
    public String toString() {
        return "{" +
                " nom='" + getNom() + "'" +
                ", Origine='" + getOrigine() + "'" +
                ", Sex='" + getSex() + "'" +
                ", force='" + getForce() + "'" +
                ", Agilite='" + getAgilite() + "'" +
                ", endurance='" + getEndurance() + "'" +
                ", les_athletes='" + getLes_athletes() + "'" +
                "}";
    }

}