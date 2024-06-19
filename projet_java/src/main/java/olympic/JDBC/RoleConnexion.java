package olympic.JDBC;

import java.sql.*;

public class RoleConnexion {
    /** private static ConnexionMySQL laConnexion */
    private static ConnexionMySQL laConnexion;

    /**
     * setlaConnexion
     * 
     * @param laConnexion_truc ConnexionMySQL
     */
    public static void setlaConnexion(ConnexionMySQL laConnexion_truc) {
        laConnexion = laConnexion_truc;
    }

    /** private RoleConnexion */
    private RoleConnexion() {
    }

    /**
     * getPW password
     * 
     * @param nom String user id
     * @return String str hash of mdp
     */
    public static String getPW(String nom) {
        try {
            Statement st = laConnexion.createStatement();
            ResultSet rs = st.executeQuery("select motDePasse from Role where nom ='" + nom + "'");
            if (!(rs.next()))
                return null;
            return rs.getString(1);
        } catch (SQLException e) {
            return null;
        }
    }

    /**
     * addDefaultRole
     */
    public static void addDefaultRole() {
        try {
            Statement st = laConnexion.createStatement();
            st.executeUpdate("insert into Role (role_id, nom_role) values (1, 'admin')");
            st.executeUpdate("insert into Role (role_id, nom_role) values (2, 'organsiateur')");
            st.executeUpdate("insert into Role (role_id, nom_role) values (3, 'visiteur')");

            st.executeUpdate(
                    "insert into Utilisateur (nom, password, role_id) values (admin, admin, 1), (organisateur, organisateur, 2)");
        } catch (SQLException e) {
            System.out.println("Erreur : addDefaultRole");
        }
    }

    /**
     * getRole
     * 
     * @return int role
     */
    public static int getRole(String nom, String password) {
        try {
            Statement st = laConnexion.createStatement();
            ResultSet rs = st.executeQuery("select role_id from Utilisateur natural left join Role where Utilisateur.nom='"+nom+"' && Utilisateur.password='"+password+"';");
            if (!(rs.next()))
                return -1;
            int tmp = rs.getInt(1);
            return (rs.wasNull())? -1:tmp;
        } catch (SQLException e) {
            System.out.println("Erreur : getRole");
            return -1;
        }
    }

    /**
     * getMaxIdUser
     * 
     * @return int max user id
     */
    public static int getMaxIdUser() {
        try {
            Statement st = laConnexion.createStatement();
            ResultSet rs = st.executeQuery("select max(utilisateur_id) from Utilisateur");
            if (!(rs.next()))
                return -1;
            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println("Erreur : getIdUserProchain");
            return -1;
        }
    }

    /**
     * getIdUserProchain
     * 
     * @return int user id +1
     */
    public static int getIdUserProchain() {
        int id = getIdUserProchain();
        return (id < 0) ? -1 : id;
    }

    /**
     * ajouteVisiteur
     * 
     * @param nom      String
     * @param password String le str du hash du mdp
     * @return int status
     */
    public static int ajouteVisiteur(String nom, String password) {
        try {
            PreparedStatement ps = laConnexion.prepareStatement(
                    "insert into Visiteur (nom, password, role_id) values (?,?,?)");

            ps.setString(1, nom);
            ps.setString(2, password);
            ps.setInt(3, 3);

            ps.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Erreur d'insertion : ajouteVisiteur");
            return -1;
        }
    }
}