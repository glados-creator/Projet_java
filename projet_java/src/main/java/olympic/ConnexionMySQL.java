package olympic;
import java.sql.*;

public class ConnexionMySQL {
    private Connection mysql = null;
    private boolean connecte = false;

    public ConnexionMySQL() throws ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
    }

    public void connecter(String nomServeur, String nomBase, String nomLogin, String motDePasse) throws SQLException {
        // si tout c'est bien passe la connexion n'est plus nulle
        String url = "jdbc:mysql://" + nomServeur + ":3306/" + nomBase;
        this.mysql = DriverManager.getConnection(url, nomLogin, motDePasse);

        this.connecte = this.mysql != null;
    }

    public void close() throws SQLException {
        // fermer la connexion

        this.mysql.close();

        this.connecte = false;
    }

    public boolean isConnecte() {
        return this.connecte;
    }

    public Statement createStatement() throws SQLException {
        return this.mysql.createStatement();
    }

    public PreparedStatement prepareStatement(String requete) throws SQLException {
        return this.mysql.prepareStatement(requete);
    }

}