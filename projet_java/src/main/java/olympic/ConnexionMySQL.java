package olympic;
import java.sql.*;

/** class ConnexionMySQL */
public class ConnexionMySQL {
    /** private Connection mysql = null */
    private Connection mysql = null;
    /** private boolean connecte = false */
    private boolean connecte = false;

    /**
     * load the mariadb driver
     * @throws ClassNotFoundException not found
     */
    public ConnexionMySQL() throws ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
    }

    /**
     * connecter au server
     * @param nomServeur String nomServeur
     * @param nomBase String nomBase
     * @param nomLogin String nomLogin
     * @param motDePasse String motDePasse
     * @throws SQLException Execption
     */
    public void connecter(String nomServeur, String nomBase, String nomLogin, String motDePasse) throws SQLException {
        // si tout c'est bien passe la connexion n'est plus nulle
        String url = "jdbc:mysql://" + nomServeur + ":3306/" + nomBase;
        this.mysql = DriverManager.getConnection(url, nomLogin, motDePasse);

        this.connecte = this.mysql != null;
    }

    /**
     * close
     * @throws SQLException not found
     */
    public void close() throws SQLException {
        // fermer la connexion

        this.mysql.close();

        this.connecte = false;
    }

    /**
     * isConnecte
     * @return boolean isConnecte
     */
    public boolean isConnecte() {
        return this.connecte;
    }

    /**
     * createStatement
     * @return Statement
     * @throws SQLException not executed
     */
    public Statement createStatement() throws SQLException {
        return this.mysql.createStatement();
    }

    /**
     * prepareStatement
     * @param requete String the sql
     * @return PreparedStatement to be formated by %
     * @throws SQLException not executed
     */
    public PreparedStatement prepareStatement(String requete) throws SQLException {
        return this.mysql.prepareStatement(requete);
    }

}