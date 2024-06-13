package olympic.model;

import java.util.ArrayList;
import java.util.List;
// import java.util.Objects;

/**
 * Sport
 */
public abstract class Sport {
    /** String nom */
    private String nom;
    /** String uniter */
    private String uniter;
    /** List[Epreuve] les_epreuves */
    private List<Epreuve> les_epreuves;

    /** double coef_force */
    private double coef_force;
    /** double coef_agilité */
    private double coef_agilité;
    /** double coef_endurance */
    private double coef_endurance;

    /**
     * Sport
     * 
     * @param nom    String
     * @param uniter String
     */
    public Sport(String nom, String uniter, double coef_force, double coef_agilité, double coef_endurance) {
        this.nom = nom;
        this.uniter = uniter;
        les_epreuves = new ArrayList<>();
        this.coef_force = coef_force;
        this.coef_agilité = coef_agilité;
        this.coef_endurance = coef_endurance;
    }


    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUniter() {
        return this.uniter;
    }

    public void setUniter(String uniter) {
        this.uniter = uniter;
    }

    public List<Epreuve> getLes_epreuves() {
        return this.les_epreuves;
    }

    public void setLes_epreuves(List<Epreuve> les_epreuves) {
        this.les_epreuves = les_epreuves;
    }

    public double getCoef_force() {
        return this.coef_force;
    }

    public void setCoef_force(double coef_force) {
        this.coef_force = coef_force;
    }

    public double getCoef_agilité() {
        return this.coef_agilité;
    }

    public void setCoef_agilité(double coef_agilité) {
        this.coef_agilité = coef_agilité;
    }

    public double getCoef_endurance() {
        return this.coef_endurance;
    }

    public void setCoef_endurance(double coef_endurance) {
        this.coef_endurance = coef_endurance;
    }

    

    /**
     * ajouter_epreuve
     * 
     * @param epreuve Epreuve
     */
    public void ajouter_epreuve(Epreuve epreuve) {
        les_epreuves.add(epreuve);
    }

    /**
     * les_epreuves admin
     * 
     * @return List[Epreuve]
     */
    public List<Epreuve> les_epreuves() {
        return les_epreuves;
    }

    @Override
    public String toString() {
        return "{" +
                " nom='" + getNom() + "'" +
                ", uniter='" + getUniter() + "'" +
                ", les_epreuves='" + getLes_epreuves() + "'" +
                ", coef_force='" + getCoef_force() + "'" +
                ", coef_agilité='" + getCoef_agilité() + "'" +
                ", coef_endurance='" + getCoef_endurance() + "'" +
                "}";
    }

}