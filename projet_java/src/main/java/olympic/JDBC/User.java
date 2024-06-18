package olympic.JDBC;

import java.sql.*;

public class User {
    ConnexionMySQL laConnexion;
    Statement st;

    public User(ConnexionMySQL laConnexion) {
        this.laConnexion = laConnexion;
    }

    public void close() throws SQLException {
        this.laConnexion.close();
    }

    public int getIdSport(String nomSport) throws SQLException {
        try {
            st = laConnexion.createStatement();
            ResultSet rs = st.executeQuery("select sport_id from Sport where sport_id ='" + nomSport + "'");
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                st = laConnexion.createStatement();
                ResultSet rs2 = st.executeQuery("select max(sport_id) from Sport");
                rs2.next();
                return rs2.getInt(1) + 1;
            }
        } catch (SQLException e) {
            return 0;
        }
    }

    public int getIdPays(String nomPays) throws SQLException {
        try {
            st = laConnexion.createStatement();
            ResultSet rs = st.executeQuery("select pays_id from Pays where pays_id ='" + nomPays + "'");
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                st = laConnexion.createStatement();
                ResultSet rs2 = st.executeQuery("select max(pays_id) from Pays");
                rs2.next();
                return rs2.getInt(1) + 1;
            }
        } catch (SQLException e) {
            return 0;
        }
    }

    public int getIdEquipe(String nomEquipe) throws SQLException {
        try {
            st = laConnexion.createStatement();
            ResultSet rs = st.executeQuery("select equipe_id from Equipe where equipe_id ='" + nomEquipe + "'");
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                st = laConnexion.createStatement();
                ResultSet rs2 = st.executeQuery("select max(equipe_id) from Equipe");
                rs2.next();
                return rs2.getInt(1) + 1;
            }
        } catch (SQLException e) {
            return 0;
        }
    }

    public int getIdEpreuve(String nomEpreuve) throws SQLException {
        try {
            st = laConnexion.createStatement();
            ResultSet rs = st.executeQuery("select epreuve_id from Epreuve where epreuve_id ='" + nomEpreuve + "'");
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                st = laConnexion.createStatement();
                ResultSet rs2 = st.executeQuery("select max(epreuve_id) from Epreuve");
                rs2.next();
                return rs2.getInt(1) + 1;
            }
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



    public void ajouteAthlete(String nom, String prenom, String sexe, String force, String endurance, String agilite,
            String pays, String epreuve) throws SQLException {
        PreparedStatement ps = this.laConnexion.prepareStatement(
                "insert into Athlete (athlete_id, nom, prenom, sexe, forceA, enduranceA, enduranceA, pays_id, epreuve_id, equipe_id) values (?,?,?,?,?,?,?,?,?,?)");

        st = this.laConnexion.createStatement();
        ResultSet test = st.executeQuery("select collectifs from Epreuve where nom='" + epreuve + "'");
        test.next();
        Boolean coll = test.getBoolean("collectifs");

        ps.setInt(1, this.getIdAthleteProchain());
        ps.setString(2, nom);
        ps.setString(3, prenom);
        ps.setString(4, sexe);
        ps.setDouble(5, Double.parseDouble(force));
        ps.setDouble(6, Double.parseDouble(endurance));
        ps.setDouble(7, Double.parseDouble(agilite));
        ps.setInt(8, Integer.parseInt(pays));

        if (coll) {
            ps.setNull(9, java.sql.Types.NULL);
            ps.setInt(10, 0);
        } else {
            ps.setInt(9, 0);
            ps.setNull(10, java.sql.Types.NULL);
        }

        ps.executeUpdate();

    }
}
