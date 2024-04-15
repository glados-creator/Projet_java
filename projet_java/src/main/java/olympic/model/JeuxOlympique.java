package olympic.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * JeuxOlympique
 */
public class JeuxOlympique {

    /** String annee */
    private String annee;
    /** String lieux */
    private String lieux;
    /** List[Sport] les_sports */
    private List<Sport> les_sports;

    /** 
     * ajouter_sports
     * @param sport Sport
     */
    public void ajouter_sports(Sport sport){
        les_sports.add(sport);
    }
    /**
     * les_sports admin
     * @return List[Sport]
     */
    public List<Sport> les_sports(){
        return les_sports;
    }

    /**
     * JeuxOlympique
     * @param annee String
     * @param lieux String
     */
    public JeuxOlympique(String annee, String lieux) {
        this.annee = annee;
        this.lieux = lieux;
        les_sports = new ArrayList<>();
    }

    /**
     * getAnnee
     * @return String
     */
    public String getAnnee() {
        return this.annee;
    }

    /**
     * getLieux
     * @return String
     */
    public String getLieux() {
        return this.lieux;
    }

    /**
     * lieux admin
     * @param lieux String
     * @return JeuxOlympique
     */
    public JeuxOlympique lieux(String lieux) {
        this.lieux = lieux;
        return this;
    }

    /**
     * equals
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof JeuxOlympique)) {
            return false;
        }
        JeuxOlympique jeuxOlympique = (JeuxOlympique) o;
        return Objects.equals(annee, jeuxOlympique.annee) && Objects.equals(lieux, jeuxOlympique.lieux);
    }

    /**
     * hashCode
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(annee, lieux);
    }

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        return "{" +
                " annee='" + getAnnee() + "'" +
                ", lieux='" + getLieux() + "'" +
                "}";
    }

}