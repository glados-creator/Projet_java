package olympic.JDBC;

import java.sql.*;

public class JOsql {
    ConnexionMySQL laConnexion;
    Statement st;

    public JOsql(ConnexionMySQL laConnexion) {
        this.laConnexion = laConnexion;
    }

    public void close() throws SQLException {
        this.laConnexion.close();
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

    public void ajouteAthlete(String nom, String prenom, String sexe, String force, String endurance, String agilite,
            String pays, String epreuve, String annee) throws SQLException {
        try {
            PreparedStatement ps = this.laConnexion.prepareStatement(
                    "insert into Athlete (athlete_id, nom, prenom, sexe, forceA, enduranceA, enduranceA, pays_id, annee) values (?,?,?,?,?,?,?,?,?)");

            st = this.laConnexion.createStatement();
            ResultSet test = st.executeQuery("select collectifs from Epreuve where nom='" + epreuve + "'");
            test.next();
            Boolean coll = test.getBoolean("collectifs");
            int id = this.getIdAthleteProchain();
            ps.setInt(1, id);
            ps.setString(2, nom);
            ps.setString(3, prenom);
            ps.setString(4, sexe);
            ps.setDouble(5, Double.parseDouble(force));
            ps.setDouble(6, Double.parseDouble(endurance));
            ps.setDouble(7, Double.parseDouble(agilite));
            ps.setInt(8, Integer.parseInt(pays));
            ps.setInt(9, Integer.parseInt(annee));

            if (coll) {
                PreparedStatement liason = this.laConnexion
                        .prepareStatement("insert into APPARTIENT (equipe_id, athlete_id) values (?, ?)");
                liason.setInt(1, this.getIdEquipe(epreuve));
                liason.setInt(2, id);
            } else {

                PreparedStatement liason = this.laConnexion
                        .prepareStatement("insert into PARTICIPE_ATHLETE (athlete_id, epreuve_id) values (?, ?)");
                liason.setInt(1, id);
                liason.setInt(2, this.getIdEpreuve(epreuve));
            }

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erreur d'insertion");
        }

    }

    public void ajouteSport(String nomSport) throws SQLException {
        PreparedStatement ps = this.laConnexion.prepareStatement(
                "insert into Sport (sport_id, nom) values (?,?)");
        ps.setInt(1, this.getIdSportProchain());
        ps.setString(2, nomSport);
        ps.executeUpdate();
    }

    public void ajoutePays(String nomPays) throws SQLException {
        PreparedStatement ps = this.laConnexion.prepareStatement(
                "insert into Pays (pays_id, nom) values (?,?)");
        ps.setInt(1, this.getIdPaysProchain());
        ps.setString(2, nomPays);
        ps.executeUpdate();
    }

    public void ajouteEquipe(String nomEquipe, String pays, String sport) throws SQLException {
        PreparedStatement ps = this.laConnexion.prepareStatement(
                "insert into Equipe (equipe_id, nom, pays_id, sport_id) values (?,?,?,?)");
        ps.setInt(1, this.getIdEquipe(nomEquipe));
        ps.setString(2, nomEquipe);
        ps.setInt(3, this.getIdPays(pays));
        ps.setInt(4, this.getIdSport(sport));
        ps.executeUpdate();
    }

    public void ajouteJO
}
