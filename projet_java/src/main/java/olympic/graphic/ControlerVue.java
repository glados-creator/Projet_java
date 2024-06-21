package olympic.graphic;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import olympic.JDBC.RoleConnexion;

public class ControlerVue implements EventHandler<ActionEvent> {

    Vue appli;
    RoleConnexion roleConnexion;

    public ControlerVue(Vue appli, RoleConnexion roleConnexion) {
        this.appli = appli;
        this.roleConnexion = roleConnexion;
    }

    public ControlerVue(Vue appli) {
        this.appli = appli;
    }

    @Override
    public void handle(ActionEvent event) {
        Button button = (Button) (event.getSource());

        switch (button.getText()) {
            case "S'inscrire": {
                appli.PageConnexion_error.setText("");
                System.out.println("TEST S'inscrire");
                if (!(appli.passwordField.getText().equals(appli.confirmPasswordField.getText()))) {
                    appli.PageConnexion_error.setText("Les mots de passe ne correspondent pas");
                    break;
                }
                try {
                    RoleConnexion.ajouteVisiteur(appli.usernameField.getText(),
                            String.valueOf(appli.passwordField.getText().hashCode()));
                } catch (SQLIntegrityConstraintViolationException e) {
                    appli.PageConnexion_error.setText("identifiant existe déja");
                    return;
                } catch (SQLException e) {
                    appli.PageConnexion_error.setText("erreur d'inscription");
                    return;
                } catch (Exception e) {
                    appli.PageConnexion_error.setText("erreur général");
                    return;
                }
                break;
            }
            case "Connecter": {
                appli.PageConnexion_error.setText("");
                System.out.println("TEST Connecter");
                String hash = RoleConnexion.getPW(appli.usernameField.getText());
                if (hash == null || !(String.valueOf(appli.passwordField.getText().hashCode()).equals(hash))) {
                    appli.PageConnexion_error.setText("mauvais mot de passe ou identifiant");
                    break;
                }
                int role_id = RoleConnexion.getRole(appli.usernameField.getText(),
                        String.valueOf(appli.passwordField.getText().hashCode()));
                if (role_id < 0) {
                    appli.PageConnexion_error.setText("authorisation corrompu");
                    break;
                }

                System.out.println("old role gathered : " + role_id);
                
                switch (role_id) {
                    case 1:
                        System.out.println("inscription modeAdministrateur");
                        appli.modeAdministrateur();
                        break;
                    case 2:
                        System.out.println("inscription modeOrganisateur");
                        appli.modeOrganisateur();
                        break;
                    case 3:
                        System.out.println("inscription modeJournaliste");
                        appli.modeJournaliste();
                        break;
                    default:
                        System.out.println("inscription modeJournaliste");
                        appli.modeJournaliste();
                        break;
                }
                break;
            }
            case "Connexion":
                appli.modeConnexion();
                break;
            case "Inscription":
                appli.modeInscription();
                break;
            case "Accueil":
                int role_id = RoleConnexion.getRole(appli.usernameField.getText(),
                            String.valueOf(appli.passwordField.getText().hashCode()));
                switch (role_id) {
                    case 1:
                    System.out.println("Page d'accueil");
                        appli.modeAdministrateur();
                        break;
                    case 2:
                    System.out.println("Page d'accueil");
                    appli.modeOrganisateur();
                        break;
                    case 3:
                    System.out.println("Page d'accueil");
                    appli.modeJournaliste();
                        break;
                    default:
                    System.out.println("Page d'accueil");
                    appli.modeJournaliste();

                    break;
                }
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
            case "Déconnexion":
                System.out.println("Retour à la page de log");
                Optional<ButtonType> reponse = appli.popUpMessageDeconexion().showAndWait();

                if (reponse.isPresent() && reponse.get().equals(ButtonType.YES)){
                    appli.modeLog();
                }
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
