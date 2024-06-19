package olympic.JDBC;

import java.sql.*;

import olympic.model.Athlete;
import olympic.model.Epreuve;
import olympic.model.Equipe;
import olympic.model.Pays;
import olympic.model.JeuxOlympique;
import olympic.model.Sport;

public class JavatoDB {
    ConnexionMySQL laConnexion;
    Statement st;

    public JavatoDB(ConnexionMySQL laConnexion) {
        this.laConnexion = laConnexion;
    }

    public int getIdEquipe(String nomEquipe) throws SQLException {
        try {
            st = laConnexion.createStatement();
            ResultSet rs = st.executeQuery("select equipe_id from Equipe where equipe_id ='" + nomEquipe + "'");
            rs.next();
            return rs.getInt(1);

        } catch (SQLException e) {
            return 0;
        }
    }

    public int getIdEpreuve(String nomEpreuve, String nomSport) throws SQLException {
        try {
            st = laConnexion.createStatement();
            ResultSet rs = st.executeQuery("select epreuve_id from Epreuve natural join Sport where epreuve_id ='" + nomEpreuve + "' and nom_sport ='" + nomSport + "'");
            rs.next();
            return rs.getInt(1);

        } catch (SQLException e) {
            return 0;
        }
    }

    public int getIdAthlete(String nomAthlete, String prenomAthlete) throws SQLException {
        try {
            st = laConnexion.createStatement();
            ResultSet rs = st.executeQuery("select athlete_id from Athlete where nom ='" + nomAthlete + "' and prenom = '" + prenomAthlete + "'");
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            return 0;
        }
    }

    public int getIdAthleteProchain() throws SQLException {
        try {
            st = laConnexion.createStatement();
            ResultSet rs2 = st.executeQuery("select max(athlete_id) from Athlete");
            rs2.next();
            return rs2.getInt(1) + 1;
        } catch (SQLException e) {
            return 0;
        }
    }

    public int getIdEpreuveProchain() throws SQLException {
        try {
            st = laConnexion.createStatement();
            ResultSet rs2 = st.executeQuery("select max(epreuve_id) from Epreuve");
            rs2.next();
            return rs2.getInt(1) + 1;
        } catch (SQLException e) {
            return 0;
        }
    }

    public void ajouteJO(JeuxOlympique jo) throws SQLException {
        try {
            PreparedStatement st = this.laConnexion.prepareStatement("insert into JO values (?,?)");

            st.setInt(1, jo.getAnnee());
            st.setString(2, jo.getLieux());

            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erreur : ajouteJO, de type : " + e);
        }
    }

    public void ajouteSport(Sport sport) throws SQLException {
        try {
            PreparedStatement st = this.laConnexion.prepareStatement("insert into Sport values (?;?)");

            st.setString(1, sport.getNom());
            st.setInt(2, sport.getJO().getAnnee());

            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erreur : ajouteSport, de type : " + e);
        }
    }

    public void ajoutePays(Pays pa) throws SQLException {
        try {
            PreparedStatement st = this.laConnexion.prepareStatement("insert into Pays values (?,?)");

            st.setString(1, pa.getNom());
            st.setString(2, pa.getJO().getLieux());

            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erreur : ajoutePays, de type : " + e);
        }
    }

    public void ajouteEpreuve(Epreuve ep) throws SQLException {
        try {
            PreparedStatement st = this.laConnexion.prepareStatement("insert into Epreuve values (?,?,?,?,?,?)");

            st.setInt(1, this.getIdEpreuveProchain());
            st.setString(2, ep.getNom());
            st.setBoolean(3, ep.getLesParticipants().get(0) instanceof Equipe);
            st.setString(4, (ep.getSex()? "M":"F"));
            st.setString(5, ep.getSport().getNom());
            st.setInt(6, ep.getSport().getJO().getAnnee());

            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erreur : ajouteEpreuve, de type : " + e);
        }

    }

    public void ajouteEquipe(Equipe eq) throws SQLException {
        try{
            PreparedStatement st = this.laConnexion.prepareStatement("insert into Equipe values (?,?,?,?)");

            st.setInt(1, this.getIdEquipe(eq.getNom()));
            st.setString(2, eq.getNom());
            st.setString(3, eq.getOrigine().getNom());
            st.setInt(4, eq.getOrigine().getJO().getAnnee());

            st.executeUpdate();

            
        }catch (Exception e){
            System.out.println("Erreur : ajouteEquipe, de type : " + e);
        }
    }

    public void ajoute(Athlete ath) throws SQLException{
        try{
            PreparedStatement st = this.laConnexion.prepareStatement("insert into Athlete values (?,?,?,?,?,?,?,?)");

            st.setInt(1, this.getIdAthleteProchain());
            st.setString(2, ath.getNom());
            st.setBoolean(3, ath.getSex());
            st.setDouble(4, ath.getForce());
            st.setDouble(5, ath.getAgilite());
            st.setDouble(6, ath.getEndurance());
            st.setString(7, ath.getOrigine().getNom());
            st.setInt(8, ath.getOrigine().getJO().getAnnee());

            st.executeUpdate();
            

            // juste on ajoute un athlete pk on essaie d ajouter dans groupe ?
            /* if (eq.getEpreuve().getSport().getCollectif()){
                PreparedStatement st2 = this.laConnexion.prepareStatement("insert into APPARTIENT values (?,?)");

                st2.setInt(2, this.getAthlete(ath.getNom(), ath.getPrenom()));
                st2.setInt(1, this.getIdEpreuve(ath.getMembre()));

                st2.executeUpdate();
            }
            else{
                PreparedStatement st3 = this.laConnexion.prepareStatement("insert into PARTICIPE_ATHLETE values (?,?)");

                st3.setInt(1, this.getAthlete(ath.getNom(), ath.getPrenom()));
                st3.setInt(2, );
            } */
        }
        catch (Exception e){
            System.out.println("Erreur : ajouteAthlete, de type : " + e);
        }

    }
}
