package olympic.graphic;

import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
            case "Connexion":
                appli.modeConnexion();
                break;
            case "Inscription":
                appli.modeInscription();
                break;
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
