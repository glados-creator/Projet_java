package olympic.model;

// TODO : format and check later

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

    /** double Coef_Force */
    private double Coef_Force;
    /** double Coef_Agilite */
    private double Coef_Agilite;
    /** double Coef_Endurance */
    private double Coef_Endurance;

    /**
     * Sport
     * 
     * @param nom            String nom
     * @param uniter         String uniter
     * @param Coef_Force     double Coef_Force
     * @param Coef_Agilite   double Coef_Agilite
     * @param Coef_Endurance double Coef_Endurance
     */
    public Sport(String nom, String uniter, double Coef_Force, double Coef_Agilite, double Coef_Endurance) {
        this.nom = nom;
        this.uniter = uniter;
        les_epreuves = new ArrayList<>();
        this.Coef_Force = Coef_Force;
        this.Coef_Agilite = Coef_Agilite;
        this.Coef_Endurance = Coef_Endurance;
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
     * setNom admin
     * 
     * @param nom String
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * getUniter
     * 
     * @return String
     */
    public String getUniter() {
        return this.uniter;
    }

    /**
     * setUniter admin
     * 
     * @param uniter String
     */
    public void setUniter(String uniter) {
        this.uniter = uniter;
    }

    /**
     * getLes_epreuves admin
     * 
     * @return List[Epreuve]
     */
    public List<Epreuve> getLes_epreuves() {
        return this.les_epreuves;
    }

    /**
     * getCoef_Force
     * 
     * @return double
     */
    public double getCoef_Force() {
        return this.Coef_Force;
    }

    /**
     * setCoef_Force
     * 
     * @param Coef_Force double
     */
    public void setCoef_Force(double Coef_Force) {
        this.Coef_Force = Coef_Force;
    }

    /**
     * getCoef_Agilite
     * 
     * @return double
     */
    public double getCoef_Agilite() {
        return this.Coef_Agilite;
    }

    /**
     * setCoef_Agilite
     * 
     * @param Coef_Agilite double
     */
    public void setCoef_Agilite(double Coef_Agilite) {
        this.Coef_Agilite = Coef_Agilite;
    }

    /**
     * getCoef_Endurance
     * 
     * @return double
     */
    public double getCoef_Endurance() {
        return this.Coef_Endurance;
    }

    /**
     * setCoef_Endurance
     * 
     * @param Coef_Endurance double
     */
    public void setCoef_Endurance(double Coef_Endurance) {
        this.Coef_Endurance = Coef_Endurance;
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

    /**
     * toString
     * 
     * @return String la doc
     */
    @Override
    public String toString() {
        return "{" +
                " nom='" + getNom() + "'" +
                ", uniter='" + getUniter() + "'" +
                ", les_epreuves='" + getLes_epreuves().size() + "'" +
                ", Coef_Force='" + getCoef_Force() + "'" +
                ", Coef_Agilite='" + getCoef_Agilite() + "'" +
                ", Coef_Endurance='" + getCoef_Endurance() + "'" +
                "}";
    }

}