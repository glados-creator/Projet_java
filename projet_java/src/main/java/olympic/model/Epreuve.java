package olympic.model;

// TODO: sync with datamanager

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /** private List[Participant] Classement; */
    private List<Participant> Classement;

    /** private HashMap[Participant,Double] Scores; */
    private HashMap<Participant, Double> Scores;

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
        this.Scores = new HashMap<>();
        Classement = new ArrayList<>();
        les_participants = new ArrayList<>();
    }

    /** private void do_simule() */
    private void do_simule() {
        les_participants = new ArrayList<>();
        Scores = new HashMap<>();
        for (Participant pa : les_participants) {
            Scores.put(pa, Double.valueOf(pa.participe(this)));
        }
        // Classement
        List<Map.Entry<Participant, Double>> list = new ArrayList<>(Scores.entrySet());
        var god = this;
        // Sort the list based on the scores
        list.sort(new Comparator<Map.Entry<Participant, Double>>() {
            @Override
            public int compare(Map.Entry<Participant, Double> o1, Map.Entry<Participant, Double> o2) {
                if (god.sport.getPlus_haut_score()) {
                    // plus haut
                    return o2.getValue().compareTo(o1.getValue());
                } else {
                    // plus petit
                    return o1.getValue().compareTo(o2.getValue());
                }
            }
        });

        // Extract
        for (Map.Entry<Participant, Double> entry : list) {
            Classement.add(entry.getKey());
        }
    }

    /**
     * getClassement
     * 
     * @return List[Participant] le Classement
     */
    public List<Participant> getClassement() {
        if (Classement.size() != les_participants.size())
            do_simule();
        return Classement;
    }

    /**
     * simule
     * 
     * @return List[Participant] le Classement
     */
    public List<Participant> simule() {
        return getClassement();
    }

    /**
     * getScores
     * 
     * @return HashMap[Participant,Double] les scores
     */
    public HashMap<Participant, Double> getScores() {
        if (Classement.size() != les_participants.size())
            do_simule();
        return Scores;
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
                ", sex='" + getSex() + "'" +
                ", les_participants='" + getLes_participants() + "'" +
                ", sport='" + getSport() + "'" +
                ", Classement='" + getClassement() + "'" +
                ", Scores='" + getScores() + "'" +
                "}";
    }

}
