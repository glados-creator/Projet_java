package olympic.model;
import java.util.Objects;

/**
 * Pays
 */
public class Pays {
    /** String nom */
    private String nom;
    /** Int medaille_or */
    private Int medaille_or;
    /** Int medaille_argent */
    private Int medaille_argent;
    /** Int medaille_bronze */
    private Int medaille_bronze;


    public Pays() {
    }

    public Pays(String nom, Int medaille_or, Int medaille_argent, Int medaille_bronze) {
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

    public Int getMedaille_or() {
        return this.medaille_or;
    }

    public void setMedaille_or(Int medaille_or) {
        this.medaille_or = medaille_or;
    }

    public Int getMedaille_argent() {
        return this.medaille_argent;
    }

    public void setMedaille_argent(Int medaille_argent) {
        this.medaille_argent = medaille_argent;
    }

    public Int getMedaille_bronze() {
        return this.medaille_bronze;
    }

    public void setMedaille_bronze(Int medaille_bronze) {
        this.medaille_bronze = medaille_bronze;
    }

    public Pays nom(String nom) {
        setNom(nom);
        return this;
    }

    public Pays medaille_or(Int medaille_or) {
        setMedaille_or(medaille_or);
        return this;
    }

    public Pays medaille_argent(Int medaille_argent) {
        setMedaille_argent(medaille_argent);
        return this;
    }

    public Pays medaille_bronze(Int medaille_bronze) {
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