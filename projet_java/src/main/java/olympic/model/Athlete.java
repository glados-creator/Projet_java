package olympic.model;
import java.util.Objects;

/**
 * Athlete
 */
public class Athlete implements Participant{

    private String nom;
    private boolean Sex;
    private double force;
    private double agilité;
    private double endurance;


    public Athlete() {
    }

    public Athlete(String nom, boolean Sex, double force, double agilité, double endurance) {
        this.nom = nom;
        this.Sex = Sex;
        this.force = force;
        this.agilité = agilité;
        this.endurance = endurance;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isSex() {
        return this.Sex;
    }

    public boolean getSex() {
        return this.Sex;
    }

    public void setSex(boolean Sex) {
        this.Sex = Sex;
    }

    public double getForce() {
        return this.force;
    }

    public void setForce(double force) {
        this.force = force;
    }

    public double getAgilité() {
        return this.agilité;
    }

    public void setAgilité(double agilité) {
        this.agilité = agilité;
    }

    public double getEndurance() {
        return this.endurance;
    }

    public void setEndurance(double endurance) {
        this.endurance = endurance;
    }

    public Athlete nom(String nom) {
        setNom(nom);
        return this;
    }

    public Athlete Sex(boolean Sex) {
        setSex(Sex);
        return this;
    }

    public Athlete force(double force) {
        setForce(force);
        return this;
    }

    public Athlete agilité(double agilité) {
        setAgilité(agilité);
        return this;
    }

    public Athlete endurance(double endurance) {
        setEndurance(endurance);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Athlete)) {
            return false;
        }
        Athlete athlete = (Athlete) o;
        return Objects.equals(nom, athlete.nom) && Sex == athlete.Sex && force == athlete.force && agilité == athlete.agilité && endurance == athlete.endurance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, Sex, force, agilité, endurance);
    }

    @Override
    public String toString() {
        return "{" +
            " nom='" + getNom() + "'" +
            ", Sex='" + isSex() + "'" +
            ", force='" + getForce() + "'" +
            ", agilité='" + getAgilité() + "'" +
            ", endurance='" + getEndurance() + "'" +
            "}";
    }

}
