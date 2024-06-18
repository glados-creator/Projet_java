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

    VueJeu appli;

    public ControlerJeu(VueJeu appli){
        this.appli = appli;
    }
    

    @Override
    public void handle(ActionEvent event){
        Button button = (Button) (event.getSource());
        if (button.getText().contains("Visiteur")){
            System.out.println("Bienvenue");
            this.appli.modeAppli();
        }
        else if (button.getText().contains("Organisateur")){
            this.appli.modeOrga();
            System.out.println("Bienvenue");
        }else if (button.getText().contains("Administrateur")) {
            this.appli.modeAdmin();
        }else if (button.getText().contains("Retour")){
            this.appli.modeLog();
            System.out.println("Bienvenue");     
        }
    }
}
