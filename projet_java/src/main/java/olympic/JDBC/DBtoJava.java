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
            ResultSet rs = st.executeQuery("SELECT * FROM JO");
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
                sports.add(new Sport(nom, annee));
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
            ResultSet rs = st.executeQuery("SELECT * FROM Pays natural join JO where annee = " + jeux.getAnnee());
            while (rs.next()) {
                String nom = rs.getString(1);
                pays.add(new Pays(nom, annee));
            }
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return pays;
    
}
