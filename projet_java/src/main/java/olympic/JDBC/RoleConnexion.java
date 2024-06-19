package olympic.JDBC;

import java.sql.*;

public class RoleConnexion {
    private static ConnexionMySQL laConnexion;

    public static void setlaConnexion(ConnexionMySQL laConnexion_truc) {
        laConnexion = laConnexion_truc;
    }

    private RoleConnexion(){}

    public static boolean getPW(String nom) {
        try {
            Statement st = laConnexion.createStatement();
            ResultSet rs = st.executeQuery("select motDePasse from Role where nom ='" + nom + "'");
            rs.next();
            return rs.getString(1).equals(nom);
        } catch (SQLException e) {
            return false;
        }
    }

    public static void addDefaultRole() throws SQLException {
        try {
            Statement st = laConnexion.createStatement();
            st.executeUpdate("insert into Role (role_id, nom_role) values (1, 'admin')");
            st.executeUpdate("insert into Role (role_id, nom_role) values (2, 'organsiateur')");
            st.executeUpdate("insert into Role (role_id, nom_role) values (3, 'visiteur')");

            st.executeUpdate(
                    "insert into Utilisateur (nom, password, role_id) values (admin, admin, 1), (organisateur, organisateur, 2)");
        } catch (SQLException e) {
            System.out.println("Erreur d'insertion : addDefaultRole");
        }
    }

    public static int getIdUserProchain() throws SQLException {
        try {
            Statement st = laConnexion.createStatement();
            ResultSet rs = st.executeQuery("select max(utilisateur_id) from Utilisateur");
            rs.next();
            return rs.getInt(1) + 1;
        } catch (SQLException e) {
            return 0;
        }
    }

    public static void ajouteVisiteur(String nom, String password) throws SQLException {
        try {
            PreparedStatement ps = laConnexion.prepareStatement(
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