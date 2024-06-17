package olympic.graphic;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
// import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VueJeu extends Application {

    private BorderPane panelCentral;

private Button Visiteur;
private Button Organisateur;
private Button Administrateur;


@Override
public void init() {
}

private Scene laScene() {
    BorderPane fenetre = new BorderPane();
    fenetre.setTop(this.titre());
    panelCentral = new BorderPane();
    fenetre.setCenter(panelCentral);
    Scene scene = new Scene(fenetre, 800, 600);
    return scene;
}

private Pane titre() {
    BorderPane banniere = new BorderPane();
    banniere.setPadding(new Insets(20));

    Label Titre = new Label("Jeux IUT'Olympiques");
    Font font = Font.font("Arial", 24);
    Titre.setFont(font);

    // Center the title in the BorderPane
    HBox titleBox = new HBox();
    titleBox.setAlignment(Pos.CENTER);
    titleBox.getChildren().add(Titre);
    banniere.setCenter(titleBox);

    return banniere;
}

public void modeLog() {
    panelCentral.getChildren().clear();
    VBox buttonbox = new VBox(20); 
    buttonbox.setAlignment(Pos.CENTER);
    buttonbox.setPadding(new Insets(20)); 
    
    // Création et application du fond pour buttonbox
    BackgroundFill buttonboxBackgroundFill = new BackgroundFill(Color.valueOf("#dededf"), new CornerRadii(10), Insets.EMPTY);
    Background buttonboxBackground = new Background(buttonboxBackgroundFill);
    buttonbox.setBackground(buttonboxBackground);

    // Création et application du fond pour panelCentral
    BackgroundFill panelCentralBackgroundFill = new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY);
    Background panelCentralBackground = new Background(panelCentralBackgroundFill);
    panelCentral.setBackground(panelCentralBackground);
    
    Visiteur = new Button("Visiteur");
    Organisateur = new Button("Organisateur");
    Administrateur = new Button("Administrateur");
    
    Visiteur.setMinWidth(150);
    Visiteur.setMinHeight(50);
    Organisateur.setMinWidth(150);
    Organisateur.setMinHeight(50);
    Administrateur.setMinWidth(150);
    Administrateur.setMinHeight(50);
    
    buttonbox.getChildren().addAll(Visiteur, Organisateur, Administrateur);
    
    buttonbox.setMaxWidth(250);
    buttonbox.setMaxHeight(400);
    
    panelCentral.setCenter(buttonbox);
}



    @Override
    public void start(Stage stage) {
        stage.setTitle("Jeu IUT'Olympiques");
        stage.setScene(this.laScene());
        this.modeLog();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}