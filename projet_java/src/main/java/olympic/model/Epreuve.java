package olympic.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Epreuve
 */
public class Epreuve {
    /** private String Nom */
    private String Nom;
    /** private boolean Sex */
    private boolean Sex;
    /** private List[Participant] LesParticipants */
    private List<Participant> LesParticipants;
    /** private final Sport LeSport */
    private final Sport LeSport;

    /** private List[Participant] Classement; */
    private List<Participant> Classement;

    /** private HashMap[Participant,Double] Scores; */
    private HashMap<Participant, Double> Scores;

    /**
     * Constructeur Epreuve
     *
     * @param LeSport Sport
     * @param Sex boolean
     * @param Nom String
     */
    public Epreuve(Sport LeSport, boolean Sex, String Nom) {
        this.LeSport = LeSport;
        this.Sex = Sex;
        this.Nom = Nom;
        this.Scores = new HashMap<>();
        Classement = new ArrayList<>();
        LesParticipants = new ArrayList<>();
    }

    /** private void do_simule() */
    private void do_simule() {
        LesParticipants = new ArrayList<>();
        Scores = new HashMap<>();
        Random rand = new Random();
        for (Participant pa : LesParticipants) {
            // aleatoir -> entre 0 et sum(rand x coef participant)
            int lmax = (int)((rand.nextDouble()*pa.getForce())+(rand.nextDouble()*pa.getAgilite())+(rand.nextDouble()*pa.getEndurance()));
            Scores.put(pa, Double.valueOf(pa.participe(this)+rand.nextInt((lmax) + 1)));
        }
        // Classement
        List<Map.Entry<Participant, Double>> list = new ArrayList<>(Scores.entrySet());
        var god = this;
        // Sort the list based on the scores
        list.sort(new Comparator<Map.Entry<Participant, Double>>() {
            @Override
            public int compare(Map.Entry<Participant, Double> o1, Map.Entry<Participant, Double> o2) {
                if (god.LeSport.getPlus_haut_score()) {
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
        if (Classement.size() != LesParticipants.size())
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
        if (Classement.size() != LesParticipants.size())
            do_simule();
        return Scores;
    }

    /**
     * getNom
     * 
     * @return String son Nom
     */
    public String getNom() {
        return Nom;
    }

    /**
     * setNom_a admin
     * 
     * @param Nom String son Nom
     */
    public void setNom_a(String Nom) {
        this.Nom = Nom;
    }

    /**
     * getSex
     * 
     * @return boolean Sex false -> men , true -> woman
     */
    public boolean getSex() {
        return Sex;
    }

    /**
     * setSex_a admin
     * 
     * @param Sex boolean false -> men , true -> woman
     */
    public void setSex_a(boolean Sex) {
        this.Sex = Sex;
    }

    /**
     * Participant
     * 
     * @return List[Participant]
     */
    public List<Participant> getLesParticipants() {
        return LesParticipants;
    }

    /**
     * getSport
     * 
     * @return Sport
     */
    public Sport getSport() {
        return LeSport;
    }

    /**
     * toString
     * 
     * @return String
     */

    @Override
    public String toString() {
        return "{" +
                " 'Nom':'" + getNom() + "'" +
                ", 'Sex':'" + getSex() + "'" +
                ", 'LesParticipants':" + getLesParticipants() + "" +
                ", 'Classement':" + getClassement() + "" +
                ", 'Scores':" + getScores() + "" +
                "}";
    }

}
