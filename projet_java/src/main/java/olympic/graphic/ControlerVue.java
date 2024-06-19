package olympic.graphic;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
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
                int status = RoleConnexion.ajouteVisiteur(appli.usernameField.getText(), String.valueOf(appli.passwordField.getText().hashCode()));
                if (status < 0){
                    appli.PageConnexion_error.setText("erreur d'inscription");
                    break;
                }
                appli.Create_PaneLive(false, false);
                appli.Switch_modeAccueil();
            }
            case "Se Connecter": {
                /* String hash =  RoleConnexion.getPW(appli.usernameField.getText());
                if (hash == null || !(String.valueOf(appli.passwordField.getText().hashCode()).equals(hash))){
                    appli.PageConnexion_error.setText("mauvais mot de passe ou identifiant");
                    break;
                }
                int role_id = RoleConnexion.getRole(appli.usernameField.getText(),String.valueOf(appli.passwordField.getText().hashCode()));
                if (role_id < 0){
                    appli.PageConnexion_error.setText("authorisation corrompu");
                    break;
                } */
               int role_id = 0;
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
