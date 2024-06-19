package olympic.JDBC;

import java.sql.*;

public class JavatoDB {
    ConnexionMySQL laConnexion;
    Statement st;

    public JavatoDB(ConnexionMySQL laConnexion) {
        this.laConnexion = laConnexion;
    }

    public int getIdSport(String nomSport) throws SQLException {
        try {
            st = laConnexion.createStatement();
            ResultSet rs = st.executeQuery("select sport_id from Sport where sport_id ='" + nomSport + "'");
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            return 0;
        }
    }

    public int getIdPays(String nomPays) throws SQLException {
        try {
            st = laConnexion.createStatement();
            ResultSet rs = st.executeQuery("select pays_id from Pays where pays_id ='" + nomPays + "'");
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            return 0;
        }
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

    public int getIdSportProchain() throws SQLException {
        try {
            st = laConnexion.createStatement();
            ResultSet rs2 = st.executeQuery("select max(sport_id) from Sport");
            rs2.next();
            return rs2.getInt(1) + 1;
        } catch (SQLException e) {
            return 0;
        }
    }

    public int getIdPaysProchain() throws SQLException {
        try {
            st = laConnexion.createStatement();
            ResultSet rs2 = st.executeQuery("select max(pays_id) from Pays");
            rs2.next();
            return rs2.getInt(1) + 1;
        } catch (SQLException e) {
            return 0;
        }
    }
}
