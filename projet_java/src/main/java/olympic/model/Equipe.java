package olympic.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Equipe
 */
public class Equipe implements Participant {

    /** String nom */
    private String nom;
    /** List[Athlete] les_athletes */
    private List<Athlete> les_athletes;

    /**
     * participe
     * see Participant
     * @return double
     */
    public double participe(){
        /// TODO : here
        return 0.0;
    }

    /**
     * Equipe
     * 
     * @param nom String
     */
    public Equipe(String nom) {
        this.nom = nom;
        les_athletes = new ArrayList<>();
    }

    /**
     * ajouter_athlete
     * 
     * @param ath Athlete
     */
    public void ajouter_athlete(Athlete ath) {
        this.les_athletes.add(ath);
    }

    /**
     * les_athletes admin
     * 
     * @return List[Athlete]
     */
    public List<Athlete> les_athletes() {
        return les_athletes;
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
     * nom admin
     * @param nom String
     * @return Equipe
     */
    public Equipe nom(String nom) {
        this.nom = nom;
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