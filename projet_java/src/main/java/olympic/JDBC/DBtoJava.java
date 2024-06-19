package olympic.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import olympic.model.Athlete;
import olympic.model.Epreuve;
import olympic.model.Equipe;
import olympic.model.Pays;
import olympic.model.JeuxOlympique;
import olympic.model.Sport;
import olympic.model.sport_type.sport_type_generic;

public class DBtoJava {
    ConnexionMySQL laConnexion;
    Statement st;

    public DBtoJava(ConnexionMySQL laConnexion) {
        this.laConnexion = laConnexion;
    }

    public List<JeuxOlympique> getJeuxOlympique() throws SQLException {
        List<JeuxOlympique> jeux = new ArrayList<JeuxOlympique>();
        try {
            st = laConnexion.createStatement();
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

    //On verra plus tard
    public List<Sport> getSport(JeuxOlympique jeux) throws SQLException {
        List<Sport> sports = new ArrayList<Sport>();
        try{
            st = laConnexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Sport where jo_id = " + jeux.getAnnee());
            while (rs.next()) {
                String nom = rs.getString(1);

                switch (sports) {
                    case value:
                    sports.add(new Natation(jeux));
                        
                        break;
                
                    default:
                        sports.add(new sport_type_generic(jeux, nom, "uniter", 0, 0, 0, false));
                        break;
                }

            }
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return sports;
    }

    public List<Pays> getPays(JeuxOlympique jeux) throws SQLException {
        List<Pays> pays = new ArrayList<Pays>();
        try{
            st = laConnexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT nom_pays, annee FROM Pays natural join JO where annee = " + jeux.getAnnee());
            while (rs.next()) {
                String nom = rs.getString(1);
                Pays paysTest =new Pays(jeux, nom, 0, 0, 0);
                

                getAthlete(paysTest).forEach(athlete -> {
                    paysTest.lesAthletes().add(athlete);
                });
                pays.add(paysTest);
                
            }
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return pays;
    
        public void getPays(Pays p) throws SQLException {}
}
