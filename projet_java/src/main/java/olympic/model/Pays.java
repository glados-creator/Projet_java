package olympic.model;
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


    public Pays() {
    }

    public Pays(String nom, int medaille_or, int medaille_argent, int medaille_bronze) {
        this.nom = nom;
        this.medaille_or = medaille_or;
        this.medaille_argent = medaille_argent;
        this.medaille_bronze = medaille_bronze;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getMedaille_or() {
        return this.medaille_or;
    }

    public void setMedaille_or(int medaille_or) {
        this.medaille_or = medaille_or;
    }

    public int getMedaille_argent() {
        return this.medaille_argent;
    }

    public void setMedaille_argent(int medaille_argent) {
        this.medaille_argent = medaille_argent;
    }

    public int getMedaille_bronze() {
        return this.medaille_bronze;
    }

    public void setMedaille_bronze(int medaille_bronze) {
        this.medaille_bronze = medaille_bronze;
    }

    public Pays nom(String nom) {
        setNom(nom);
        return this;
    }

    public Pays medaille_or(int medaille_or) {
        setMedaille_or(medaille_or);
        return this;
    }

    public Pays medaille_argent(int medaille_argent) {
        setMedaille_argent(medaille_argent);
        return this;
    }

    public Pays medaille_bronze(int medaille_bronze) {
        setMedaille_bronze(medaille_bronze);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pays)) {
            return false;
        }
        Pays pays = (Pays) o;
        return Objects.equals(nom, pays.nom) && Objects.equals(medaille_or, pays.medaille_or) && Objects.equals(medaille_argent, pays.medaille_argent) && Objects.equals(medaille_bronze, pays.medaille_bronze);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, medaille_or, medaille_argent, medaille_bronze);
    }

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