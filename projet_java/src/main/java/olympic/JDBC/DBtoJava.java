package olympic.JDBC;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import olympic.model.Athlete;
import olympic.model.Epreuve;
import olympic.model.Equipe;
import olympic.model.JeuxOlympique;
import olympic.model.Pays;
import olympic.model.Sport;
import olympic.model.sport_type.sport_type_generic;

/** final class DBtoJava */
public final class DBtoJava {
    /** private static ConnexionMySQL laConnexion */
    private static ConnexionMySQL laConnexion;

    /**
     * setSQL
     * 
     * @param laConnexion_i ConnexionMySQL
     */
    public static final void setSQL(ConnexionMySQL laConnexion_i) {
        laConnexion = laConnexion_i;
    }

    /** private DBtoJava() */
    private DBtoJava() {
    }

    /**
     * getJeuxOlympique
     * 
     * @return List[JeuxOlympique]
     */
    public static final List<JeuxOlympique> getJeuxOlympique() {
        List<JeuxOlympique> jeux = new ArrayList<JeuxOlympique>();
        try {
            Statement st = laConnexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT annee, lieux FROM JO");
            while (rs.next()) {
                int annee = rs.getInt(1);
                String lieux = rs.getString(2);

                JeuxOlympique jeuxTest = new JeuxOlympique(annee, lieux);
                getSport(jeuxTest).forEach(sport -> {
                    jeuxTest.getLesSports().add(sport);
                });

                getPays(jeuxTest).forEach(pays -> {
                    jeuxTest.getLesPays().add(pays);
                });
                jeuxTest.simule();
                jeux.add(jeuxTest);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // System.out.println("Error: " + e.getMessage());

        }
        return jeux;
    }

    /**
     * getSport
     * 
     * @param jeux JeuxOlympique
     * @return List[JeuxOlympique]
     * 
     */
    public static final List<Sport> getSport(JeuxOlympique jeux) {
        List<Sport> sports = new ArrayList<Sport>();
        try {
            Statement st = laConnexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT nom_sport FROM Sport where jo_id = " + jeux.getAnnee());
            while (rs.next()) {
                String nom = rs.getString(1);

                switch (nom) {
                    case "Athletisme":
                        sports.add(new olympic.model.sport_type.Athletisme(jeux));
                        break;
                    case "Escrime":
                        sports.add(new olympic.model.sport_type.Escrime(jeux));
                        break;
                    case "HandBall":
                        sports.add(new olympic.model.sport_type.HandBall(jeux));
                        break;
                    case "Natation":
                        sports.add(new olympic.model.sport_type.Natation(jeux));
                        break;
                    case "VolleyBall":
                        sports.add(new olympic.model.sport_type.VolleyBall(jeux));
                        break;
                    default:
                        sports.add(new sport_type_generic(jeux, nom, "uniter", (double) 1 / 3, (double) 1 / 3,
                                (double) 1 / 3, true));
                        break;
                }
                getEpreuves(sports.get(sports.size() - 1)).forEach(
                        epreuve -> {
                            sports.get(sports.size() - 1).ajouter_epreuve(epreuve);
                        });
            }
        } catch (Exception e) {
            e.printStackTrace();
            // System.out.println("Error: " + e.getMessage());
        }
        return sports;
    }

    /**
     * getEpreuves
     * 
     * @param p Sport
     * @return List[Epreuve]
     */
    public static final List<Epreuve> getEpreuves(Sport p) {
        List<Epreuve> ret = new ArrayList<>();
        try {
            ResultSet rs = laConnexion.createStatement().executeQuery(
                    "select nom_epreuve ,genre from Epreuve natural join Sport where nom_sport='"
                            +
                            p.getNom() + "' && annee=" + p.getJO().getAnnee() + ";");
            while (rs.next()) {
                ret.add(new Epreuve(p,rs.getString(2).charAt(0) == 'F',rs.getString(1)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * getPays
     * 
     * @param jeux JeuxOlympique
     * @return List[Pays]
     */
    public static final List<Pays> getPays(JeuxOlympique jeux) {
        List<Pays> pays = new ArrayList<Pays>();
        try {
            Statement st = laConnexion.createStatement();
            ResultSet rs = st
                    .executeQuery("SELECT nom_pays, annee FROM Pays natural join JO where annee = " + jeux.getAnnee());
            while (rs.next()) {
                String nom = rs.getString(1);
                Pays paysTest = new Pays(jeux, nom, 0, 0, 0);

                getAthlete(paysTest).forEach(athlete -> {
                    paysTest.lesAthletes().add(athlete);
                });
                pays.add(paysTest);
                link_athlete_equipe_epreuve(paysTest);

            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return pays;
    }

    /**
     * getAthlete
     * 
     * @param p Pays
     * @return List[Athlete]
     */
    public static final List<Athlete> getAthlete(Pays p) {
        List<Athlete> ret = new ArrayList<>();
        try {
            ResultSet rs = laConnexion.createStatement().executeQuery("select nom,prenom,sexe,forceA,enduranceA,agiliteA from Athlete natural join Pays where nom_sport='"
            + p.getNom() + "' && annee=" + p.getJO().getAnnee() + ";");
            while (rs.next()) {
                ret.add(new Athlete(rs.getString(1), rs.getString(2), rs.getString(3).charAt(0) == 'F', rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), p));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * getEquipes
     * 
     * @param p Pays
     * @return List[Equipe]
     */
    public static final List<Equipe> getEquipes(Pays p) {
        List<Equipe> ret = new ArrayList<>();
        try {
            // APPARTIENT
            ResultSet rs = laConnexion.createStatement().executeQuery(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * link_athlete_equipe_epreuve
     * 
     * @param pays Pays
     */
    public static final void link_athlete_equipe_epreuve(Pays pays) {

    }
}
