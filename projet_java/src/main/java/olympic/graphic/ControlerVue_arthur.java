package olympic.graphic;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import olympic.JDBC.RoleConnexion;

/** class ControlerJeu implements EventHandler[ActionEvent] */
public class ControlerVue_arthur implements EventHandler<ActionEvent> {
    /** Vue appli */
    Vue_arthur appli;

    /**
     * ControlerVue
     * 
     * @param appli
     */
    public ControlerVue_arthur(Vue_arthur appli) {
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
                    RoleConnexion.ajouteVisiteur(appli.usernameField.getText(),
                            String.valueOf(appli.passwordField.getText().hashCode()));
                } catch (SQLIntegrityConstraintViolationException e) {
                    e.printStackTrace();
                    appli.PageConnexion_error.setText("identifiant existe déja");
                    return;
                } catch (SQLException e) {
                    appli.PageConnexion_error.setText("erreur d'inscription");
                    return;
                } catch (Exception e) {
                    appli.PageConnexion_error.setText("erreur général");
                    return;
                }
                appli.Create_PaneLive(false, false);
                appli.Switch_modeAccueil();
            }
            case "Se Connecter": {
                String hash = RoleConnexion.getPW(appli.usernameField.getText());
                if (hash == null || !(String.valueOf(appli.passwordField.getText().hashCode()).equals(hash))) {
                    appli.PageConnexion_error.setText("mauvais mot de passe ou identifiant");
                    // TODO: uncomment
                    // no u
                    // break;
                }
                int role_id = RoleConnexion.getRole(appli.usernameField.getText(),
                        String.valueOf(appli.passwordField.getText().hashCode()));
                if (role_id < 0) {
                    appli.PageConnexion_error.setText("authorisation corrompu");
                    // TODO: uncomment
                    // no u
                    // break;
                }
                System.out.println("old role gathered : " + role_id);
                // TODO : remove
                role_id = 0;
                appli.Create_PaneLive(role_id == 1, role_id == 0);
                appli.Switch_modeAccueil();
            }
            case "Accueil":
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
                // TODO : alert peut etre
                break;
        }
    }
}
