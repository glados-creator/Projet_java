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
import javafx.scene.text.FontWeight;
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
    banniere.setBackground(new Background(new BackgroundFill(Color.valueOf("#CFE4FF"), CornerRadii.EMPTY, Insets.EMPTY)));


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
    
    buttonbox.setBackground(new Background(new BackgroundFill(Color.valueOf("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
    panelCentral.setBackground(new Background(new BackgroundFill(Color.valueOf("#CFE4FF"), CornerRadii.EMPTY, Insets.EMPTY)));

    // Add the "Connexion" label
    Label connexionLabel = new Label("CONNEXION");
    connexionLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
    connexionLabel.setTextFill(Color.BLACK);
    connexionLabel.setAlignment(Pos.CENTER);
    VBox.setMargin(connexionLabel, new Insets(0, 0, 40, 0)); // Adjust this value as needed to move the label up

    Visiteur = new Button("Visiteur");
    Organisateur = new Button("Organisateur");
    Administrateur = new Button("Administrateur");
    
    // Set button styles
    String buttonStyle = "-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;";

    Visiteur.setStyle(buttonStyle);
    Organisateur.setStyle(buttonStyle);
    Administrateur.setStyle(buttonStyle);

    Visiteur.setMinWidth(175);
    Visiteur.setMinHeight(50);
    Organisateur.setMinWidth(175);
    Organisateur.setMinHeight(50);
    Administrateur.setMinWidth(175);
    Administrateur.setMinHeight(50);
    
    // Add the label and buttons to the VBox
    buttonbox.getChildren().addAll(connexionLabel, Visiteur, Organisateur, Administrateur);
    
    buttonbox.setMaxWidth(300);
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