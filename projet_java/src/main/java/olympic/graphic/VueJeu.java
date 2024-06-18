package olympic.graphic;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
    private Button Athletes;
    private Button Pays;
    private Button Sports;

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

        Label connexionLabel = new Label("CONNEXION");
        connexionLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        connexionLabel.setTextFill(Color.BLACK);
        connexionLabel.setAlignment(Pos.CENTER);
        VBox.setMargin(connexionLabel, new Insets(0, 0, 40, 0));

        Visiteur = new Button("Visiteur");
        Visiteur.setOnAction(new ControlerJeu(this));
        Organisateur = new Button("Organisateur");
        Organisateur.setOnAction(new ControlerJeu(this));
        Administrateur = new Button("Administrateur");
        Administrateur.setOnAction(new ControlerJeu(this));

        
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
        
        buttonbox.getChildren().addAll(connexionLabel, Visiteur, Organisateur, Administrateur);
        
        buttonbox.setMaxWidth(300);
        buttonbox.setMaxHeight(400);
        
        panelCentral.setCenter(buttonbox);
    }


    public void modeOrga() {
        panelCentral.getChildren().clear();
        
        VBox mainBox = new VBox(20);
        mainBox.setPadding(new Insets(20)); 
        mainBox.setBackground(new Background(new BackgroundFill(Color.valueOf("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        panelCentral.setBackground(new Background(new BackgroundFill(Color.valueOf("#CFE4FF"), CornerRadii.EMPTY, Insets.EMPTY)));
    
        Button backButton = new Button("Retour");
        backButton.setStyle("-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;");
        backButton.setOnAction(e -> {
            System.out.println("Bouton Retour cliqué");
        });
        backButton.setOnAction(new ControlerJeu(this));
    
        VBox contentBox = new VBox(20);
        contentBox.setAlignment(Pos.CENTER);
        
        Label connexionLabel = new Label("Organisateur");
        connexionLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        connexionLabel.setTextFill(Color.BLACK);
        connexionLabel.setAlignment(Pos.CENTER);
        VBox.setMargin(connexionLabel, new Insets(0, 0, 40, 0));
        
        TextField usernameField = new TextField();
        usernameField.setPromptText("Identifiant");
        usernameField.setMaxWidth(320);
    
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Mot de passe");
        passwordField.setMaxWidth(320);
    
        Button connecterButton = new Button("Connecter");
        connecterButton.setStyle("-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;");
        connecterButton.setPrefWidth(320);
        connecterButton.setPrefHeight(25);
        
        Button inscription = new Button("Inscription");
        inscription.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #3C5A9C;");
        inscription.setPrefWidth(320);
        inscription.setPrefHeight(25);
        inscription.setOnAction(new ControlerJeu(this));

        
    
        contentBox.getChildren().addAll(connexionLabel, usernameField, passwordField, connecterButton, inscription);
        
        HBox topBox = new HBox();
        topBox.getChildren().add(backButton);
        //topBox.setAlignment(Pos.TOP_LEFT);
        topBox.setPadding(new Insets(0, 0, 0, 0));
    
        mainBox.getChildren().addAll(topBox, contentBox);
        
        mainBox.setMaxWidth(700);
        mainBox.setMaxHeight(400);
        
        panelCentral.setCenter(mainBox);
    }
    

    public void modeAdmin() {

        panelCentral.getChildren().clear();
        
        VBox mainBox = new VBox(20);
        mainBox.setPadding(new Insets(20)); 
        mainBox.setBackground(new Background(new BackgroundFill(Color.valueOf("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        panelCentral.setBackground(new Background(new BackgroundFill(Color.valueOf("#CFE4FF"), CornerRadii.EMPTY, Insets.EMPTY)));
    
        Button backButton = new Button("Retour");
        backButton.setStyle("-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;");
        backButton.setOnAction(e -> {
            System.out.println("Bouton Retour cliqué");
        });
        backButton.setOnAction(new ControlerJeu(this));

    
        VBox contentBox = new VBox(20);
        contentBox.setAlignment(Pos.CENTER);
        
        Label connexionLabel = new Label("Administrateur");
        connexionLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        connexionLabel.setTextFill(Color.BLACK);
        connexionLabel.setAlignment(Pos.CENTER);
        VBox.setMargin(connexionLabel, new Insets(0, 0, 40, 0));
        
        TextField usernameField = new TextField();
        usernameField.setPromptText("Identifiant");
        usernameField.setMaxWidth(320);
    
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Mot de passe");
        passwordField.setMaxWidth(320);
    
        Button connecterButton = new Button("Connecter");
        connecterButton.setStyle("-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;");
        connecterButton.setPrefWidth(320);
        connecterButton.setPrefHeight(25);
        
        Button inscription = new Button("Inscription");
        inscription.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #3C5A9C;");
        inscription.setPrefWidth(320);
        inscription.setPrefHeight(25);
        inscription.setOnAction(new ControlerJeu(this));


        contentBox.getChildren().addAll(connexionLabel, usernameField, passwordField, connecterButton, inscription);
    

        
        HBox topBox = new HBox();
        topBox.getChildren().add(backButton);
        //topBox.setAlignment(Pos.TOP_LEFT);
        topBox.setPadding(new Insets(0, 0, 0, 0));
    
        mainBox.getChildren().addAll(topBox, contentBox);
        
        mainBox.setMaxWidth(700);
        mainBox.setMaxHeight(400);
        
        panelCentral.setCenter(mainBox);
    }

    public void modeInscription() {

        panelCentral.getChildren().clear();
        
        VBox mainBox = new VBox(20);
        mainBox.setPadding(new Insets(20)); 
        mainBox.setBackground(new Background(new BackgroundFill(Color.valueOf("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        panelCentral.setBackground(new Background(new BackgroundFill(Color.valueOf("#CFE4FF"), CornerRadii.EMPTY, Insets.EMPTY)));
    
        Button backButton = new Button("Retour");
        backButton.setStyle("-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;");
        backButton.setOnAction(e -> {
            System.out.println("Bouton Retour cliqué");
        });
        backButton.setOnAction(new ControlerJeu(this));
    
        VBox contentBox = new VBox(20);
        contentBox.setAlignment(Pos.CENTER);
        
        Label connexionLabel = new Label("Inscription");
        connexionLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        connexionLabel.setTextFill(Color.BLACK);
        connexionLabel.setAlignment(Pos.CENTER);
        VBox.setMargin(connexionLabel, new Insets(0, 0, 40, 0));
        
        TextField usernameField = new TextField();
        usernameField.setPromptText("Identifiant");
        usernameField.setMaxWidth(320);
    
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Mot de passe");
        passwordField.setMaxWidth(320);
        
        // New Password Confirmation Field
        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Confirmez le mot de passe");
        confirmPasswordField.setMaxWidth(320);
    
        Label errorLabel = new Label();
        errorLabel.setTextFill(Color.RED);
    
        Button connecterButton = new Button("S'inscrire");
        connecterButton.setStyle("-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;");
        connecterButton.setPrefWidth(320);
        connecterButton.setPrefHeight(25);
        connecterButton.setOnAction(e -> {
            if (!passwordField.getText().equals(confirmPasswordField.getText())) {
                errorLabel.setText("Les mots de passe ne correspondent pas");
            } else {
                // Proceed with registration logic
                System.out.println("Inscription réussie");
                errorLabel.setText("");
            }
        });
        
        contentBox.getChildren().addAll(connexionLabel, usernameField, passwordField, confirmPasswordField, connecterButton, errorLabel);
        
        HBox topBox = new HBox();
        topBox.getChildren().add(backButton);
        //topBox.setAlignment(Pos.TOP_LEFT);
        topBox.setPadding(new Insets(0, 0, 0, 0));
    
        mainBox.getChildren().addAll(topBox, contentBox);
        
        mainBox.setMaxWidth(700);
        mainBox.setMaxHeight(400);
        
        panelCentral.setCenter(mainBox);
    }
     

    public void modeVisiteur() {
        panelCentral.getChildren().clear();
        
        VBox mainBox = new VBox(20);
        mainBox.setPadding(new Insets(20)); 
        mainBox.setBackground(new Background(new BackgroundFill(Color.valueOf("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        panelCentral.setBackground(new Background(new BackgroundFill(Color.valueOf("#CFE4FF"), CornerRadii.EMPTY, Insets.EMPTY)));
    
        Button backButton = new Button("Retour");
        backButton.setStyle("-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;");
        backButton.setOnAction(new ControlerJeu(this));
    
        Button Athletes = new Button("Athlètes");
        Button Pays = new Button("Pays");
        Button Sports = new Button("Sports");
    
        String buttonStyle = "-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;";
        Athletes.setStyle(buttonStyle);
        Pays.setStyle(buttonStyle);
        Sports.setStyle(buttonStyle);
    
        HBox topBox = new HBox(10);
        topBox.setPadding(new Insets(0, 0, 0, 0));
        topBox.setAlignment(Pos.TOP_LEFT);
        topBox.getChildren().add(backButton);
        
        HBox menuBox = new HBox(10);
        menuBox.setAlignment(Pos.TOP_RIGHT);
        menuBox.getChildren().addAll(Athletes, Pays, Sports);
    
        BorderPane topPane = new BorderPane();
        topPane.setLeft(topBox);
        topPane.setRight(menuBox);
    
        VBox contentBox = new VBox(20);
        contentBox.setAlignment(Pos.CENTER);
    
        mainBox.getChildren().addAll(topPane, contentBox);
        mainBox.setMaxWidth(750);
        mainBox.setMaxHeight(500);
        
        panelCentral.setCenter(mainBox);
    }
    
    

    

    public void modeAppli() {
        panelCentral.getChildren().clear();
        
        VBox mainBox = new VBox(20);
        mainBox.setPadding(new Insets(20)); 
        mainBox.setBackground(new Background(new BackgroundFill(Color.valueOf("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        panelCentral.setBackground(new Background(new BackgroundFill(Color.valueOf("#CFE4FF"), CornerRadii.EMPTY, Insets.EMPTY)));
        
    }

    public Alert alerteEntrerOrganisateur() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Voulez-vous allez sur la page de connexion d'Organisateur ?", ButtonType.YES, ButtonType.NO);
        alert.setHeaderText("Attention");
        alert.setTitle("Jeux IUT'Olympiques");
        return alert;
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Jeux IUT'Olympiques");
        stage.setScene(this.laScene());
        this.modeLog();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}