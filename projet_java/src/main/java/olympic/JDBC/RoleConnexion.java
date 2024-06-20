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
            ResultSet rs = st.executeQuery("select password from Utilisateur where nom ='" + nom + "'");
            if (!(rs.next()))
                return null;
            return rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur : getPassWord");
            return null;
            // throw e;
        }
    }

    /**
     * addDefaultRole
     */
    public static void addDefaultRole() {
        try {
            // test if empty
            ResultSet rs_test = laConnexion.createStatement().executeQuery("select COUNT(role_id) from Role;");
            // System.out.println("TEST : "+(!(rs_test.next())) +" : "+ rs_test.wasNull() +" : "+ (rs_test.getInt(1) < 4) +" : "+ (getMaxIdUser() < 3));
            
            rs_test = laConnexion.createStatement().executeQuery("select COUNT(role_id) from Role;");
            
            if (!(rs_test.next()) || rs_test.wasNull() || rs_test.getInt(1) < 4 || getMaxIdUser() < 3) {
                System.out.println("Role reset");
                System.out.println("Role delete");
                laConnexion.createStatement().execute("SET FOREIGN_KEY_CHECKS = 0;");
                laConnexion.createStatement().execute("DELETE FROM Role;");
                laConnexion.createStatement()
                        .execute("DELETE FROM Utilisateur where nom in ('admin', 'organisateur', 'visiteur');");
                laConnexion.createStatement().execute("SET FOREIGN_KEY_CHECKS = 1;");
                Statement st = laConnexion.createStatement();
                System.out.println("Default Role insert");
                st.executeUpdate("insert into Role (role_id, nom_role) values (0, null);");
                st.executeUpdate("insert into Role (role_id, nom_role) values (1, 'admin');");
                st.executeUpdate("insert into Role (role_id, nom_role) values (2, 'organsiateur');");
                st.executeUpdate("insert into Role (role_id, nom_role) values (3, 'visiteur');");
                System.out.println("Default user insert");
                st.executeUpdate(
                        "insert into Utilisateur (nom, password, role_id) values ('admin', '"
                                + String.valueOf("admin".hashCode()) + "' , 1), ('organisateur', '"
                                + String.valueOf("organisateur".hashCode()) + "', 2) , ('visiteur' , '"
                                + String.valueOf("visiteur".hashCode()) + "' , 3);");
                // System.out.println("addDefaultRole success");
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            System.out.println("Erreur : addDefaultRole");
        } catch (Exception e) {
            System.out.println("Erreur : addDefaultRole");
            // e.printStackTrace();
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
            ResultSet rs = st
                    .executeQuery("select role_id from Utilisateur natural left join Role where Utilisateur.nom='" + nom
                            + "' && Utilisateur.password='" + password + "';");
            if (!(rs.next()))
                return -1;
            int tmp = rs.getInt(1);
            return (rs.wasNull()) ? -1 : tmp;
        } catch (SQLException e) {
            System.out.println("Erreur : getRole");
            // e.printStackTrace();
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
            ResultSet rs = st.executeQuery("select COUNT(nom) from Utilisateur;");
            if (!(rs.next()))
                return -1;
            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println("Erreur : getMaxIdUser");
            // e.printStackTrace();
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
     * @throws SQLException SQLException
     */
    public static void ajouteVisiteur(String nom, String password) throws SQLException {
        try {
            PreparedStatement ps = laConnexion.prepareStatement(
                    "insert into Utilisateur (nom, password, role_id) values (?,?,?);");

            ps.setString(1, nom);
            ps.setString(2, password);
            ps.setInt(3, 3);

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur d'insertion : ajouteVisiteur");
            throw e;
        }
    }
}