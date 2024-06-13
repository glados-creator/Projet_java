package olympic;

import java.util.ArrayList;
import java.util.List;

import olympic.model.Athlete;
import olympic.model.Athletisme;
import olympic.model.Epreuve;
import olympic.model.Equipe;
import olympic.model.Escrime;
import olympic.model.HandBall;
import olympic.model.JeuxOlympique;
import olympic.model.Natation;
import olympic.model.Pays;
import olympic.model.Sport;
import olympic.model.VolleyBall;

/** public class datamanager
 * manage the sync with the data
 */
public class datamanager {
    /** private static ConnexionMySQL conn */
    private static ConnexionMySQL conn;
    
    /** private static List[JeuxOlympique] glob_JO */
    private static List<JeuxOlympique> glob_JO = new ArrayList<>();
    /** private static List[Pays] glob_pays */
    private static List<Pays> glob_pays = new ArrayList<>();

    /** enum load_file_format */
    public enum load_file_format {
        /** le format bizzard que le fichier python genere */
        celene,
        /** notre format ou chaque tables est un fichier */
        ours;
    }

    /** private datamanager c'est une lib */
    private datamanager() {
    }
    /**     public final static void default_dataset() */
    public final static void default_dataset() {
        JeuxOlympique jo = new JeuxOlympique("2024", "Paris");
        // JO -> sports -> epreuves | equipes <- atheletes <- pays
        
        // epreuves = ["Natation 100 brasse", "Natation relais libre", "Handball",
        // "Volley-Ball", "Escrime fleuret", "Escrime épée", "Athétisme 110 haies",
        // "Athlétisme relais 400m"]
        Natation nat = new Natation();
        nat.ajouter_epreuve(new Epreuve(false,"Natation 100 brasse"));
        nat.ajouter_epreuve(new Epreuve(true,"Natation 100 brasse"));
        nat.ajouter_epreuve(new Epreuve(false,"Natation relais libre"));
        nat.ajouter_epreuve(new Epreuve(true,"Natation relais libre"));
        jo.ajouter_sports(nat);
        create_sport(nat);

        HandBall hand = new HandBall();
        hand.ajouter_epreuve(new Epreuve(false,"Handball"));
        hand.ajouter_epreuve(new Epreuve(true,"Handball"));
        jo.ajouter_sports(hand);

        VolleyBall voley = new VolleyBall();
        voley.ajouter_epreuve(new Epreuve(false,"Voley-Ball"));
        voley.ajouter_epreuve(new Epreuve(true,"Voley-Ball"));
        jo.ajouter_sports(voley);

        Escrime escr = new Escrime();
        escr.ajouter_epreuve(new Epreuve(false,"Escrime fleuret"));
        escr.ajouter_epreuve(new Epreuve(true,"Escrime fleuret"));
        escr.ajouter_epreuve(new Epreuve(false,"Escrime épée"));
        escr.ajouter_epreuve(new Epreuve(true,"Escrime épée"));
        jo.ajouter_sports(escr);

        Athletisme athle = new Athletisme();
        athle.ajouter_epreuve(new Epreuve(false,"Athétisme 110 haies"));
        athle.ajouter_epreuve(new Epreuve(true,"Athétisme 110 haies"));
        athle.ajouter_epreuve(new Epreuve(false,"Athlétisme relais 400m"));
        athle.ajouter_epreuve(new Epreuve(true,"Athlétisme relais 400m"));
        jo.ajouter_sports(athle);

        create_jo(jo);
    }
    /**     public final static void load_data(String nomServeur, String nomBase, String nomLogin, String motDePasse) 
     * load_data
     * @param nomServeur String nomServeur
     * @param nomBase String nomBase
     * @param nomLogin String nomLogin
     * @param motDePasse String motDePasse
     */
    public final static void load_data(String nomServeur, String nomBase, String nomLogin, String motDePasse) {
        // either get sql data or csv static
        try {
            conn = new ConnexionMySQL();
            conn.connecter(nomServeur, nomBase, nomLogin, motDePasse);
        } catch (Exception e) {
            // TODO: handle exception
            // parse csv to data model
        }
    }
    /**     public final static void save_data() */
    public final static void save_data() {
        save_jo();
        save_athlete();
        save_equipe();
        save_pays();
        save_sport();

        // export their csv
    }
    /**     public final static void create_jo(JeuxOlympique JO)
     * @param JO JeuxOlympique le jo a créé
     */
    public final static void create_jo(JeuxOlympique JO) {
    }
    /**     public final static void save_jo() */
    public final static void save_jo() {
    }
    /**     public final static void delete_jo() */
    public final static void delete_jo() {
    }
    /**     public final static List[JeuxOlympique] load_jo()
     * @return List[JeuxOlympique]
     */
    public final static List<JeuxOlympique> load_jo() {
        return null;
    }
    /**     public final static List[JeuxOlympique] list_jo()
     * @return List[JeuxOlympique]
     */
    public final static List<JeuxOlympique> list_jo() {
        return glob_JO;
    }
    /**     public final static void create_athlete(Athlete athlete)
     * @param athlete Athlete
     */
    public final static void create_athlete(Athlete athlete) {
    }
    /**     public final static void save_athlete() */
    public final static void save_athlete() {
    }
    /**     public final static void delete_athlete() */
    public final static void delete_athlete() {
    }
    /**     public final static List[Athlete] load_athlete()
     * @return List[Athlete]
     */
    public final static List<Athlete> load_athlete() {
        return null;
    }
    /**     public final static List[Athlete] list_athlete()
     * @return List[Athlete]
     */
    public final static List<Athlete> list_athlete() {
        return null;
        // return glob_athlete;
    }
    /**     public final static void create_equipe(Equipe equipe)
     * @param equipe Equipe l'équipe a créé
     */
    public final static void create_equipe(Equipe equipe) {
    }
    /**     public final static void save_equipe() */
    public final static void save_equipe() {
    }
    /**     public final static void delete_equipe() */
    public final static void delete_equipe() {
    }
    /**     public final static List[Equipe] load_equipe() 
     * @return List[Equipe]
    */
    public final static List<Equipe> load_equipe() {
        return null;
    }
    /**     public final static List[Equipe] list_Equipes()
     * @return List[Equipe]
     */
    public final static List<Equipe> list_Equipes() {
        return null;
        // return glob_equipe;
    }
    /**     public final static void create_pays(Pays pays) 
     * @param pays Pays le pays a créé
    */
    public final static void create_pays(Pays pays) {
    }
    /**     public final static void save_pays() */
    public final static void save_pays() {
    }
    /**     public final static void delete_pays() */
    public final static void delete_pays() {
    }
    /**     public final static List[Pays] load_pays() 
     * @return List[Pays]
    */
    public final static List<Pays> load_pays() {
        return null;
    }
    /**     public final static List[Pays] list_pays() 
     * @return List[Pays]
    */
    public final static List<Pays> list_pays() {
        return glob_pays;
    }
    /**     public final static void create_sport(Sport sport)
     * @param sport Sport le sport a créé
     */
    public final static void create_sport(Sport sport) {
    }
    /**     public final static void save_sport() */
    public final static void save_sport() {
    }
    /**     public final static void delete_sport() */
    public final static void delete_sport() {
    }
    /**     public final static List[Sport] load_sport() 
     * @return List[Sport]
    */
    public final static List<Sport> load_sport() {
        return null;
    }
    /**     public final static List[Sport] list_sport() 
     * @return List[Sport]
    */
    public final static List<Sport> list_sport() {
        return null;
        // return glob_sport;
    }

}
