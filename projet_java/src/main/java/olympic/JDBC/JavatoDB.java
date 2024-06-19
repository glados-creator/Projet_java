package olympic.JDBC;

import java.sql.*;

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

    public int getIdEpreuve(String nomEpreuve) throws SQLException {
        try {
            st = laConnexion.createStatement();
            ResultSet rs = st.executeQuery("select epreuve_id from Epreuve where epreuve_id ='" + nomEpreuve + "'");
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
        try{
        PreparedStatement st = this.laConnexion.prepareStatement("insert into JO values (?,?)");

        st.setInt(1, jo.getAnnee());
        st.setString(2, jo.getLieux());

        st.executeUpdate();
        }catch (Exception e){
            System.out.println("Erreur : ajouteJO, de type : "+ e);
        }
    }

    public void ajouteSport(Sport sport) throws SQLException {
        try{       PreparedStatement st = this.laConnexion.prepareStatement("insert into Sport values (?;?)");

        st.setString(1, sport.getNom());
        st.setString(2, sport.getJO().getAnnee());

        st.executeUpdate();}catch (Exception e){
            System.out.println("Erreur : ajouteSport, de type : "+ e);
        }
    }

    public void ajoutePays(String nomPays) throws SQLException {
        try{
        PreparedStatement st = this.laConnexion.prepareStatement("insert into Pays values (?,?)");

        st.setString(1, nomPays);
        st.setString(2, nomPays.getJO().getLieux());

        st.executeUpdate();}
        catch(Exception e){
            System.out.println("Erreur : ajoutePays, de type : "+ e);
        }
    }

    public void ajouteEpreuve(Epreuve ep) throws SQLException {
        try{
            PreparedStatement st = this.laConnexion.prepareStatement("insert into Eprecision values (?,?,?,?,?,?)");

            st.setInt(1, his.getId)
        }


}
