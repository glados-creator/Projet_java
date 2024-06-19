package olympic.graphic;

import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import olympic.datamanager;
import olympic.JDBC.ConnexionMySQL;
import olympic.JDBC.RoleConnexion;

/** class ControlerJeu implements EventHandler[ActionEvent] */
public class ControlerVue implements EventHandler<ActionEvent> {
    /** Vue appli */
    Vue appli;

    /**
     * ControlerVue
     * 
     * @param appli
     */
    public ControlerVue(Vue appli) {
        this.appli = appli;
    }

    /**
     * handle
     * 
     * @param event ActionEvent
     */
    @Override
    public void handle(ActionEvent event) {
        Button button = (Button) (event.getSource());
        System.out.println("pressed : " + button.getText());
        switch (button.getText()) {
            case "S'Inscrire": {
                if (!(appli.passwordField.getText().equals(appli.confirmPasswordField.getText()))) {
                    appli.PageConnexion_error.setText("Les mots de passe ne correspondent pas");
                    break;
                }

                try {
                    RoleConnexion.ajouteVisiteur(appli.usernameField.getText(), appli.passwordField.getText());
                    System.out.println("Inscription réussie");
                    appli.modeLog();

                } catch (SQLException e) {
                    System.out.println("Erreur d'inscription : " + e.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                appli.Switch_modeAccueil();
            }
            case "Se Connecter": {
                /*
                 * TextField usernameField = appli.getUsernameField();
                 * TextField passwordField = appli.getPasswordField();
                 * 
                 * String username = usernameField.getText();
                 * String password = passwordField.getText();
                 * 
                 * if (roleConnexion.getPW(username, password)) {
                 * System.out.println("Connexion réussie");
                 * appli.modeJournaliste();
                 * } else {
                 * System.out.println("Échec de la connexion");
                 * 
                 * }
                 */
                appli.Switch_modeAccueil();
            }
            case "Accueil":
                // TODO : NON
                appli.Switch_modeAccueil();
                break;
            case "Athlètes":
                appli.Switch_modeSports();
                break;
            case "Pays":
                appli.Switch_modePays();
                break;
            case "Sports":
                appli.Switch_modesSports();
                break;
            case "Retour":
                appli.Switch_Connexion();
                break;
            default:
                System.out.println("Bouton non reconnu");
                // TODO : alert
                break;
        }
    }
}
