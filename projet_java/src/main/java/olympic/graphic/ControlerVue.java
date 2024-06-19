package olympic.graphic;

import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/** class ControlerJeu implements EventHandler[ActionEvent] */
public class ControlerVue implements EventHandler<ActionEvent>  {
    /** Vue appli */
    Vue appli;
    /** ControlerVue
     * 
     * @param appli
     */
    public ControlerVue(Vue appli){
        this.appli = appli;
    }
    
    /** handle
     * @param event ActionEvent
     */
    @Override
    public void handle(ActionEvent event){
        Button button = (Button) (event.getSource());

        switch (button.getText()) {
            case "Connexion":
                appli.modeConnexion();
                break;
            case "Inscription":
                appli.modeInscription();
                break;
            case "S'inscrire": {

                if (!passwordField.getText().equals(confirmPasswordField.getText())) {
                    errorLabel.setText("Les mots de passe ne correspondent pas");
                } else {
                    // Proceed with registration logic
                    System.out.println("Inscription réussie");
                    errorLabel.setText("");
                }

                TextField usernameField = appli.getUsernameField();

                TextField passwordField = appli.getPasswordField();

                String username = usernameField.getText();

                String password = passwordField.getText();

                try {
                    roleConnexion.ajouteVisiteur(username, password);
                    System.out.println("Inscription réussie");
                    appli.modeLog();

                } catch (SQLException e) {
                    System.out.println("Erreur d'inscription : " + e.getMessage());

                }
            }
            case "Connecter": {
                TextField usernameField = appli.getUsernameField();
                TextField passwordField = appli.getPasswordField();

                String username = usernameField.getText();
                String password = passwordField.getText();

                if (roleConnexion.getPW(username, password)) {
                    System.out.println("Connexion réussie");
                    appli.modeJournaliste();
                } else {
                    System.out.println("Échec de la connexion");

                }
            }
            case "Accueil":
                System.out.println("Page d'accueil");
                appli.modeJournaliste();
                break;
            case "Athlètes":
                System.out.println("Page des athlètes");
                appli.modeAthletes();
                break;
            case "Pays":
                System.out.println("Page des pays");
                appli.modePays();
                break;
            case "Sports":
                System.out.println("Page des sports");
                appli.modeSports();
                break;
            case "Retour":
                System.out.println("Retour à la page de log");
                appli.modeLog();
                break;
            default:
                System.out.println("Bouton non reconnu");
                break;
        }
    }
}
