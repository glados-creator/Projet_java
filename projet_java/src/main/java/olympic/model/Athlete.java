package olympic.model;

import java.util.Objects;

/**
 * Athlete
 */
public class Athlete implements Participant {

    /** String nom */
    private String nom;
    /** boolean Sex */
    private boolean Sex;
    /** double force */
    private double force;
    /** double agilité */
    private double agilité;
    /** double endurance */
    private double endurance;

   
    /**
     * constructeur
     * 
     * @param nom       String
     * @param Sex       boolean
     * @param force     double
     * @param agilité   double
     * @param endurance double
     */
    public Athlete(String nom, boolean Sex, double force, double agilité, double endurance) {
        this.nom = nom;
        this.Sex = Sex;
        this.force = force;
        this.agilité = agilité;
        this.endurance = endurance;
    }

    /**
     * getNom
     * 
     * @return String
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * setNom
     * 
     * @param nom String
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * getSex
     * 
     * @return boolean
     */
    public boolean getSex() {
        return this.Sex;
    }

    /**
     * setSex
     * 
     * @param Sex boolean
     */
    public void setSex(boolean Sex) {
        this.Sex = Sex;
    }

    /**
     * getForce
     * 
     * @return double
     */
    public double getForce() {
        return this.force;
    }

    /**
     * setForce
     * 
     * @param force double
     */
    public void setForce(double force) {
        this.force = force;
    }

    /**
     * getAgilité
     * 
     * @return double
     */
    public double getAgilité() {
        return this.agilité;
    }

    /**
     * setAgilité
     * 
     * @param agilité double
     */
    public void setAgilité(double agilité) {
        this.agilité = agilité;
    }

    /**
     * getEndurance
     * 
     * @return double
     */
    public double getEndurance() {
        return this.endurance;
    }

    /**
     * setEndurance
     * 
     * @param endurance double
     */
    public void setEndurance(double endurance) {
        this.endurance = endurance;
    }

    public double getCapa(){
        return (this.endurance + this.force + this.agilité);
    }

    /**
     * equals
     * 
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Athlete)) {
            return false;
        }
        Athlete athlete = (Athlete) o;
        return Objects.equals(nom, athlete.nom) && this.Sex == athlete.Sex && this.force == athlete.force
                && this.agilité == athlete.agilité && this.endurance == athlete.endurance;
    }

    /**
     * hashCode
     * 
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(nom, Sex, force, agilité, endurance);
    }

    /**
     * toString
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "{" +
                " nom='" + getNom() + "'" +
                ", Sex='" + getSex() + "'" +
                ", force='" + getForce() + "'" +
                ", agilité='" + getAgilité() + "'" +
                ", endurance='" + getEndurance() + "'" +
                "}";
    }

}
