package olympic.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Epreuve
 */
public class Epreuve {
    /** boolean sex */
    private boolean sex;
    /** String nom */
    private String nom;
    /** List[Participant] les_participants */
    private List<Participant> les_participants;

    /**
     * ajouter_Participant
     * 
     * @param participant Participant
     */
    public void ajouter_sports(Participant participant) {
        les_participants.add(participant);
    }

    /**
     * les_Participant admin
     * 
     * @return List[Participant]
     */
    public List<Participant> les_participants() {
        return les_participants;
    }

    /**
     * Epreuve
     * 
     * @param sex boolean
     * @param nom String
     */
    public Epreuve(boolean sex, String nom) {
        this.sex = sex;
        this.nom = nom;
        les_participants = new ArrayList<>();
    }

    /**
     * getSex
     * 
     * @return boolean
     */
    public boolean getSex() {
        return this.sex;
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
     * sex admin
     * 
     * @param sex boolean
     * @return Epreuve
     */
    public Epreuve sex(boolean sex) {
        this.sex = sex;
        return this;
    }

    /**
     * nom admin
     * 
     * @param nom String
     * @return Epreuve 
     */
    public Epreuve nom(String nom) {
        this.nom = nom;
        return this;
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
        if (!(o instanceof Epreuve)) {
            return false;
        }
        Epreuve epreuve = (Epreuve) o;
        return sex == epreuve.sex && Objects.equals(nom, epreuve.nom);
    }

    /**
     * hashCode
     * 
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(sex, nom);
    }

    /**
     * toString
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "{" +
                "nom='" + getNom() + "'" +
                ", sex='" + getSex() + "'" +
                "}";
    }

}