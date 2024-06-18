package olympic.graphic;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class ControlerJeu implements EventHandler<ActionEvent>  {

    Vue appli;

    public ControlerJeu(Vue appli){
        this.appli = appli;
    }
    

    @Override
    public void handle(ActionEvent event){
        Button button = (Button) (event.getSource());
        if (button.getText().contains("Connexion")){
            System.out.println("Bienvenue");
            this.appli.modeConnexion();
        }
        else if (button.getText().contains("Inscription")){
            this.appli.modeInscription();
            System.out.println("Bienvenue");

        }else if (button.getText().contains("Retour")){
            this.appli.modeLog();     
        }
        else if (button.getText().contains("Inscription")){
            this.appli.modeInscription();     
        }
    }
}
