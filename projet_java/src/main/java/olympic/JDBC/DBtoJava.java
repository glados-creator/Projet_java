package olympic.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            ResultSet rs = st.executeQuery("SELECT annee, lieux FROM JO;");
            while (rs.next()) {
                int annee = rs.getInt(1);
                String lieux = rs.getString(2);

                JeuxOlympique jeuxTest = new JeuxOlympique(annee, lieux);
                getPays(jeuxTest).forEach(pays -> {
                    jeuxTest.getLesPays().add(pays);
                });
                getSport(jeuxTest).forEach(sport -> {
                    jeuxTest.getLesSports().add(sport);
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
            ResultSet rs = st.executeQuery("SELECT nom_sport FROM Sport where annee = " + jeux.getAnnee()+";");
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
                    "select nom_epreuve ,genre,collectifs from Epreuve natural join Sport where nom_sport='"
                            +
                            p.getNom() + "' && annee=" + p.getJO().getAnnee() + ";");
            while (rs.next()) {
                ret.add(new Epreuve(p,rs.getString(2).charAt(0) == 'F',rs.getString(1)));
                if (rs.getBoolean(3)){
                    link_equipe_epreuve(ret.get(ret.size()-1));
                } else {
                    link_athlete_epreuve(ret.get(ret.size()-1));
                }
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
                    .executeQuery("SELECT nom_pays, annee FROM Pays natural join JO where annee = " + jeux.getAnnee()+";");
            while (rs.next()) {
                String nom = rs.getString(1);
                Pays paysTest = new Pays(jeux, nom, 0, 0, 0);

                getAthlete(paysTest).forEach(athlete -> {
                    paysTest.lesAthletes().add(athlete);
                }); 

                getEquipes(paysTest);
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
     */
    public static final List<Athlete> getAthlete(Pays p) {
        List<Athlete> ret = new ArrayList<>();
        try {
            ResultSet rs = laConnexion.createStatement().executeQuery("select nom,prenom,sexe,forceA,enduranceA,agiliteA from Athlete natural join Pays where nom_pays='"
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
            String query = "SELECT nom_equipe, nom_pays, annee FROM Equipe WHERE nom_pays='" 
                + p.getNom() + "' AND annee=" + p.getJO().getAnnee() + ";";
            ResultSet rs = laConnexion.createStatement().executeQuery(query);
            while (rs.next()) {
                ret.add(new Equipe(rs.getString(1),false, p));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static final void link_equipe_epreuve(Epreuve ep) {
    try {
        String query = "SELECT e.equipe_id, e.nom_equipe, p.nom_pays " +
                       "FROM PARTICIPE_EQUIPE pe " +
                       "JOIN Equipe e ON pe.equipe_id = e.equipe_id " +
                       "JOIN Pays p ON e.nom_pays = p.nom_pays " +
                       "JOIN Epreuve ep ON pe.epreuve_id = ep.epreuve_id " +
                       "WHERE ep.nom_epreuve = ? AND ep.genre = ?";
        
        PreparedStatement pstmt = laConnexion.prepareStatement(query);
        pstmt.setString(1, ep.getNom());
        pstmt.setString(2, ep.getSex() ? "F" : "M");
        
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            String nomEquipe = rs.getString("nom_equipe");
            String nomPays = rs.getString("nom_pays");
            
            // Recherche de l'équipe dans les pays associés à l'épreuve
            for (Pays pays : ep.getSport().getJO().getLesPays()) {
                if (pays.getNom().equals(nomPays)) {
                    for (Equipe equipe : getEquipes(pays)) {
                        if (equipe.getNom().equals(nomEquipe)) {
                            ep.getLesParticipants().add(equipe);
                            break;
                        }
                    }
                    break; // Sortie de la boucle pays une fois l'équipe trouvée
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public static final void link_athlete_epreuve(Epreuve ep) {
    try {
        String query = "SELECT a.nom, a.prenom, p.nom_pays " +
                       "FROM PARTICIPE_ATHLETE pa " +
                       "JOIN Athlete a ON pa.athlete_id = a.athlete_id " +
                       "JOIN Pays p ON a.nom_pays = p.nom_pays " +
                       "JOIN Epreuve e ON pa.epreuve_id = e.epreuve_id " +
                       "WHERE e.nom_epreuve = ? AND e.genre = ?";
        
        PreparedStatement pstmt = laConnexion.prepareStatement(query);
        pstmt.setString(1, ep.getNom());
        pstmt.setString(2, ep.getSex() ? "F" : "M");
        
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            String nomAthlete = rs.getString("nom");
            String prenomAthlete = rs.getString("prenom");
            String nomPays = rs.getString("nom_pays");
            
            // Recherche de l'athlète dans les pays associés à l'épreuve
            for (Pays pays : ep.getSport().getJO().getLesPays()) {
                if (pays.getNom().equals(nomPays)) {
                    for (Athlete athlete : pays.lesAthletes()) {
                        if (athlete.getNom().equals(nomAthlete) && athlete.getPrenom().equals(prenomAthlete)) {
                            ep.getLesParticipants().add(athlete);
                        }
                    }
                    break; // Sortie de la boucle pays une fois tous les athlètes trouvés pour cette ligne
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}
