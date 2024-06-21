package olympic.model;

import java.util.ArrayList;
import java.util.List;

/**
 * JeuxOlympique
 */
public class JeuxOlympique {

    /** String Annee */
    private int Annee;
    /** String Lieux */
    private String Lieux;
    /** List[Sport] LesSports */
    private final List<Sport> LesSports;

    private final List<Pays> LesPays;

    /**
     * JeuxOlympique
     * 
     * @param Annee String
     * @param Lieux String
     */
    public JeuxOlympique(int Annee, String Lieux) {
        this.Annee = Annee;
        this.Lieux = Lieux;
        LesSports = new ArrayList<>();
        LesPays = new ArrayList<>();
    }

    /**
     * void simule()
     * fait une simulation olympique
     */
    public void simule() {
        for (Sport sp : LesSports) {
            for (Epreuve ep : sp.getLesEpreuves()) {
                List<Participant> classement = ep.simule();
                try {
                    Pays pays_or = classement.get(0).getOrigine();
                    pays_or.setMedaille_or_a(1 + pays_or.getMedaille_or());
                } catch (Exception e) {
                    // System.out.println("error : simule medaille");
                }
                try {
                    Pays pays_argent = classement.get(1).getOrigine();
                    pays_argent.setMedaille_argent_a(1 + pays_argent.getMedaille_argent());
                } catch (Exception e) {
                    // System.out.println("error : simule medaille");
                }
                try {
                    Pays pays_bronze = classement.get(2).getOrigine();
                    pays_bronze.setMedaille_bronze_a(1 + pays_bronze.getMedaille_bronze());
                } catch (Exception e) {
                    // System.out.println("error : simule medaille");
                }
            }
        }
    }

    /**
     * LesSports
     * 
     * @return List[Sport]
     */
    public List<Sport> getLesSports() {
        return LesSports;
    }

    /**
     * getLesPays
     * @return List[Pays]
     */
    public List<Pays> getLesPays() {
        return LesPays;
    }

    /**
     * getAnnee
     * 
     * @return String
     */
    public int getAnnee() {
        return Annee;
    }

    /**
     * getLieux
     * 
     * @return String
     */
    public String getLieux() {
        return Lieux;
    }

    /**
     * setLieux admin
     * 
     * @param Lieux String
     */
    public void setLieux(String Lieux) {
        this.Lieux = Lieux;
    }

    /**
     * toString
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "{" +
            " 'Annee':'" + getAnnee() + "'" +
            ", 'Lieux':'" + getLieux() + "'" +
            ", 'LesSports':" + getLesSports() + "" +
            ", 'LesPays':" + getLesPays() + "" +
            "}";
    }
    

}