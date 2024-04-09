package olympic.model;

import java.util.Objects;

/**
 * Epreuve
 */
public class Epreuve {
    private boolean sex;
    private String nom;

    public Epreuve() {
    }

    public Epreuve(boolean sex, String nom) {
        this.sex = sex;
        this.nom = nom;
    }

    public boolean getSex() {
        return this.sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Epreuve sex(boolean sex) {
        setSex(sex);
        return this;
    }

    public Epreuve nom(String nom) {
        setNom(nom);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Epreuve)) {
            return false;
        }
        Epreuve epreuve = (Epreuve) o;
        return sex == epreuve.sex && Objects.equals(nom, epreuve.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sex, nom);
    }

    @Override
    public String toString() {
        return "{" +
                "nom='" + getNom() + "'" +
                ", sex='" + getSex() + "'" +
                "}";
    }

}