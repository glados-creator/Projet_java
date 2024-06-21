package olympic;

import java.util.ArrayList;
import java.util.List;

import olympic.JDBC.ConnexionMySQL;
import olympic.JDBC.DBtoJava;
import olympic.JDBC.RoleConnexion;
import olympic.model.sport_type.*;
import olympic.model.Epreuve;
import olympic.model.JeuxOlympique;

// 1 début
// 2 load-csv

// 3-connection sql
// 4 - reset obj , import les donne sql

// 5 - app
// 6- fin app

// 7.1 - drop tout sql
// 7.2 - sauvegarder sql
// 8 - sauvegarder csv

/**
 * public final class datamanager
 * manage the sync with the data
 */
public final class datamanager {
    /** private static ConnexionMySQL conn */
    private static ConnexionMySQL conn;

    /** private static List[JeuxOlympique] glob_JO */
    private static List<JeuxOlympique> glob_JO = new ArrayList<>();

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

    public static void init() {
        System.out.println("datamanager init");
        try {
            conn = new ConnexionMySQL();
            conn.connecter(null, null, null, null);
            RoleConnexion.setlaConnexion(conn);
            // System.out.println("conn set");
            RoleConnexion.addDefaultRole();
            // System.out.println("default role set");
            DBtoJava.setSQL(conn);
            DBtoJava.getJeuxOlympique().forEach(JO -> {glob_JO.add(JO);});
            // System.out.println("default data");

            // System.err.println(glob_JO);
        } catch (Exception e) {
            System.out.println("erreur datamanager init");
            e.printStackTrace();
        }
    }

    public static ConnexionMySQL getMySQL() {
        return conn;
    }

    /** public final static void default_dataset() */
    public final static void default_dataset() {
        JeuxOlympique jo = new JeuxOlympique(2024, "Paris");
        // JO -> sports -> epreuves | equipes <- atheletes <- pays

        // epreuves = ["Natation 100 brasse", "Natation relais libre", "Handball",
        // "Volley-Ball", "Escrime fleuret", "Escrime épée", "Athétisme 110 haies",
        // "Athlétisme relais 400m"]
        Natation nat = new Natation(jo);
        nat.ajouter_epreuve(new Epreuve(nat, false, "Natation 100 brasse"));
        nat.ajouter_epreuve(new Epreuve(nat, true, "Natation 100 brasse"));
        nat.ajouter_epreuve(new Epreuve(nat, false, "Natation relais libre"));
        nat.ajouter_epreuve(new Epreuve(nat, true, "Natation relais libre"));
        jo.getLesSports().add(nat);

        HandBall hand = new HandBall(jo);
        hand.ajouter_epreuve(new Epreuve(hand, false, "Handball"));
        hand.ajouter_epreuve(new Epreuve(hand, true, "Handball"));
        jo.getLesSports().add(hand);

        VolleyBall voley = new VolleyBall(jo);
        voley.ajouter_epreuve(new Epreuve(voley, false, "Voley-Ball"));
        voley.ajouter_epreuve(new Epreuve(voley, true, "Voley-Ball"));
        jo.getLesSports().add(voley);

        Escrime escr = new Escrime(jo);
        escr.ajouter_epreuve(new Epreuve(escr, false, "Escrime fleuret"));
        escr.ajouter_epreuve(new Epreuve(escr, true, "Escrime fleuret"));
        escr.ajouter_epreuve(new Epreuve(escr, false, "Escrime épée"));
        escr.ajouter_epreuve(new Epreuve(escr, true, "Escrime épée"));
        jo.getLesSports().add(escr);

        Athletisme athle = new Athletisme(jo);
        athle.ajouter_epreuve(new Epreuve(athle, false, "Athétisme 110 haies"));
        athle.ajouter_epreuve(new Epreuve(athle, true, "Athétisme 110 haies"));
        athle.ajouter_epreuve(new Epreuve(athle, false, "Athlétisme relais 400m"));
        athle.ajouter_epreuve(new Epreuve(athle, true, "Athlétisme relais 400m"));
        jo.getLesSports().add(athle);

        create_jo(jo);
    }

    /*
     * public final static void load_data(String nomServeur, String nomBase, String
     * nomLogin, String motDePasse)
     * load_data
     * 
     * @param nomServeur String nomServeur
     * 
     * @param nomBase String nomBase
     * 
     * @param nomLogin String nomLogin
     * 
     * @param motDePasse String motDePasse
     * 
     * public final static void load_data(String nomServeur, String nomBase, String
     * nomLogin, String motDePasse) {
     * // either get sql data or csv static
     * try {
     * conn = new ConnexionMySQL();
     * conn.connecter(nomServeur, nomBase, nomLogin, motDePasse);
     * } catch (Exception e) {
     * // T0D0: handle exception
     * // parse csv to data model
     * }
     * }
     */
    /** public final static void save_data() */
    public final static void save_data() {
        // export their csv
    }

    /**
     * public final static void create_jo(JeuxOlympique JO)
     * 
     * @param JO JeuxOlympique le jo a créé
     */
    public final static void create_jo(JeuxOlympique JO) {
    }

    /** public final static void save_jo() */
    public final static void save_jo() {
    }

    /** public final static void delete_jo() */
    public final static void delete_jo() {
    }

    /**
     * public final static List[JeuxOlympique] load_jo()
     * 
     * @return List[JeuxOlympique]
     */
    public final static List<JeuxOlympique> load_jo() {
        return null;
    }

    /**
     * public final static List[JeuxOlympique] list_jo()
     * 
     * @return List[JeuxOlympique]
     */
    public final static List<JeuxOlympique> list_jo() {
        return glob_JO;
    }
}
