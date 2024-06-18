package olympic.JDBC;

import java.sql.*;

public class RoleConnexion {
    ConnexionMySQL laConnexion;
    Statement st;

    public RoleConnexion(ConnexionMySQL laConnexion) {
        this.laConnexion = laConnexion;
    }

    public boolean getPW(String nom) {
        try {
            st = laConnexion.createStatement();
            ResultSet rs = st.executeQuery("select motDePasse from Role where nom ='" + nom + "'");
            rs.next();
            return rs.getString(1).equals(nom);
        } catch (SQLException e) {
            return false;
        }
    }

    public void addDefaultRole() throws SQLException {
        try {
            st = laConnexion.createStatement();
            st.executeUpdate("insert into Role (role_id, nom_role) values (1, 'admin')");
            st.executeUpdate("insert into Role (role_id, nom_role) values (2, 'organsiateur')");
            st.executeUpdate("insert into Role (role_id, nom_role) values (3, 'visiteur')");

            st.executeUpdate(
                    "insert into Utilisateur (nom, password, role_id) values (admin, admin, 1), (organisateur, organisateur, 2)");
        } catch (SQLException e) {
            System.out.println("Erreur d'insertion : addDefaultRole");
        }
    }

    public int getIdUserProchain() throws SQLException {
        try {
            ResultSet rs = st.executeQuery("select max(utilisateur_id) from Utilisateur");
            rs.next();
            return rs.getInt(1) + 1;
        } catch (SQLException e) {
            return 0;
        }
    }

    public void ajouteVisiteur(String nom, String prenom, String password) throws SQLException {
        try {
            PreparedStatement ps = this.laConnexion.prepareStatement(
                    "insert into Visiteur (nom, password, role_id) values (?,?,?)");

            ps.setString(1, nom);
            ps.setString(2, password);
            ps.setInt(3, 3);

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur d'insertion : ajouteVisiteur");
        }
    }
}