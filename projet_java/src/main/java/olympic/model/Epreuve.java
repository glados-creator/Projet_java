package olympic.model;

// TODO: sync with datamanager

import java.util.ArrayList;
import java.util.List;

/**
 * Epreuve
 */
public class Epreuve {
    /** private String nom */
    private String nom;
    /** private boolean sex */
    private boolean sex;
    /** private List[Participant] les_participants */
    private List<Participant> les_participants;
    /** private final Sport sport */
    private final Sport sport;

    /**
     * Constructeur Epreuve
     *
     * @param sex boolean
     * @param nom String
     */
    public Epreuve(Sport sport, boolean sex, String nom) {
        this.sport = sport;
        this.sex = sex;
        this.nom = nom;
        les_participants = new ArrayList<>();
    }

    public List<Participant> simule() {
        // TODO : simule
        return null;
    }

    /**
     * getNom
     * 
     * @return String son nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * setNom_a admin
     * 
     * @param String Nom
     */
    public void setNom_a(String nom) {
        this.nom = nom;
    }

    /**
     * getSex
     * 
     * @return boolean sex false -> men , true -> woman
     */
    public boolean getSex() {
        return sex;
    }

    /**
     * setSex_a admin
     * 
     * @param sex boolean false -> men , true -> woman
     */
    public void setSex_a(boolean sex) {
        this.sex = sex;
    }

    /**
     * Participant
     * 
     * @return List[Participant]
     */
    public List<Participant> getLes_participants() {
        return les_participants;
    }

    /**
     * getSport
     * 
     * @return Sport
     */
    public Sport getSport() {
        return sport;
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
                ", sport='" + getSport() + "'" +
                ", sex='" + getSex() + "'" +
                ", les_participants='" + getLes_participants() + "'" +
                "}";
    }

}
