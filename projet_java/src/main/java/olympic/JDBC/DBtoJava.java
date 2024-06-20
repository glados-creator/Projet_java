package olympic.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import olympic.model.Athlete;
import olympic.model.Equipe;
import olympic.model.Pays;
import olympic.model.JeuxOlympique;
import olympic.model.Sport;
import olympic.model.sport_type.*;

/** final class DBtoJava */
public final class DBtoJava {
    /** private static ConnexionMySQL laConnexion */
    private static ConnexionMySQL laConnexion;

    /**
     * setSQL
     * 
     * @param laConnexion_i ConnexionMySQL
     */
    public void setSQL(ConnexionMySQL laConnexion_i) {
        laConnexion = laConnexion_i;
    }

    /** private DBtoJava() */
    private DBtoJava() {
    }

    /**
     * getJeuxOlympique
     * 
     * @return List[JeuxOlympique]
     * @throws SQLException SQLException
     */
    public List<JeuxOlympique> getJeuxOlympique() throws SQLException {
        List<JeuxOlympique> jeux = new ArrayList<JeuxOlympique>();
        try {
            Statement st = laConnexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT annee, lieux FROM JO");
            while (rs.next()) {
                int annee = rs.getInt(1);
                String lieux = rs.getString(2);

                JeuxOlympique jeuxTest = new JeuxOlympique(annee, lieux);
                getSport(jeuxTest).forEach(sport -> {
                    jeuxTest.LesSports().add(sport);
                });

                getPays(jeuxTest).forEach(pays -> {
                    jeuxTest.LesPays().add(pays);
                });

                jeux.add(jeuxTest);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        }
        return jeux;
    }

    /**
     * getSport
     * 
     * @param jeux JeuxOlympique
     * @return List[JeuxOlympique]
     * @throws SQLException
     */
    public List<Sport> getSport(JeuxOlympique jeux) throws SQLException {
        List<Sport> sports = new ArrayList<Sport>();
        try {
            Statement st = laConnexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Sport where jo_id = " + jeux.getAnnee());
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
                        sports.add(new sport_type_generic(jeux, nom, "uniter", (double)1/3, (double)1/3, (double)1/3, true));
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return sports;
    }

    /**
     * getEpreuves
     * 
     * @param p Sport
     * @throws SQLException SQLException
     */
    public void getEpreuves(Sport p) throws SQLException {
    }

    /**
     * getPays
     * 
     * @param jeux JeuxOlympique
     * @return List[Pays]
     * @throws SQLException SQLException
     */
    public List<Pays> getPays(JeuxOlympique jeux) throws SQLException {
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
     * @throws SQLException SQLException
     */
    public List<Athlete> getAthlete(Pays p) throws SQLException {
        return null;
    }

    /**
     * getEquipes
     * 
     * @param p Pays
     * @return List[Equipe]
     * @throws SQLException SQLException
     */
    public List<Equipe> getEquipes(Pays p) throws SQLException {
        return null;
    }
}
