package olympic.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Equipe
 */
public class Equipe implements Participant {

    private String nom;
    private List<Athlete> les_athletes;

    public Equipe() {
        les_athletes = new ArrayList<>();
    }

    public Equipe(String nom) {
        this.nom = nom;
        les_athletes = new ArrayList<>();
    }

    public List<Athlete> get_athletes() {
        return les_athletes;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Equipe nom(String nom) {
        setNom(nom);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Equipe)) {
            return false;
        }
        Equipe equipe = (Equipe) o;
        return Objects.equals(nom, equipe.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.nom);
    }

    @Override
    public String toString() {
        return "{" +
                " nom='" + getNom() + "'" +
                "}";
    }
}