package olympic.graphic;

import java.util.Arrays;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import olympic.datamanager;
import olympic.model.Athlete;
import olympic.model.Pays;
import olympic.model.Sport;

public class Vue extends Application {

    private BorderPane panelCentral;

    private Button Connexion;
    private Button Inscription;

    private Button Accueil;
    private Button Athletes;
    private Button Pays;
    private Button Sports;

    /** TextField usernameField */
    public TextField usernameField = null;
    /** PasswordField passwordField */
    public PasswordField passwordField = null;
    /** PasswordField confirmPasswordField */
    public PasswordField confirmPasswordField = null;
    /** Label PageConnexion_error */
    public Label PageConnexion_error = null;

    @Override
    public void init() {
        datamanager.init();
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
        banniere.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#CFE4FF"), CornerRadii.EMPTY, Insets.EMPTY)));

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

        buttonbox.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        panelCentral.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#CFE4FF"), CornerRadii.EMPTY, Insets.EMPTY)));

        Connexion = new Button("Connexion");
        Connexion.setOnAction(new ControlerVue(this));
        Inscription = new Button("Inscription");
        Inscription.setOnAction(new ControlerVue(this));

        String buttonStyle = "-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff; -fx-font-size: 18px;";

        Connexion.setStyle(buttonStyle);
        Inscription.setStyle(buttonStyle);

        Connexion.setMinWidth(175);
        Connexion.setMinHeight(75);
        Inscription.setMinWidth(175);
        Inscription.setMinHeight(75);

        Region spacer = new Region();
        spacer.setPrefHeight(10);

        buttonbox.getChildren().addAll(Connexion, spacer, Inscription);

        buttonbox.setMaxWidth(300);
        buttonbox.setMaxHeight(400);

        panelCentral.setCenter(buttonbox);
    }

    public void modeConnexion() {
        panelCentral.getChildren().clear();

        VBox mainBox = new VBox(20);
        mainBox.setPadding(new Insets(20));
        mainBox.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        panelCentral.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#CFE4FF"), CornerRadii.EMPTY, Insets.EMPTY)));

        Button backButton = new Button("Retour");
        backButton.setStyle("-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;");
        backButton.setOnAction(e -> {
            System.out.println("Bouton Retour cliqué");
        });
        backButton.setOnAction(new ControlerVue(this));

        VBox contentBox = new VBox(20);
        contentBox.setAlignment(Pos.CENTER);

        Label connexionLabel = new Label("Connexion");
        connexionLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        connexionLabel.setTextFill(Color.BLACK);
        connexionLabel.setAlignment(Pos.CENTER);
        VBox.setMargin(connexionLabel, new Insets(0, 0, 40, 0));

        usernameField = new TextField();
        usernameField.setPromptText("Identifiant");
        usernameField.setMaxWidth(320);

        passwordField = new PasswordField();
        passwordField.setPromptText("Mot de passe");
        passwordField.setMaxWidth(320);

        Button connecterButton = new Button("Connecter");
        connecterButton.setStyle("-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;");
        connecterButton.setPrefWidth(320);
        connecterButton.setPrefHeight(25);
        connecterButton.setOnAction(new ControlerVue(this));

        Button inscription = new Button("Inscription");
        inscription.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #3C5A9C;");
        inscription.setPrefWidth(320);
        inscription.setPrefHeight(25);
        inscription.setOnAction(new ControlerVue(this));

        if (PageConnexion_error==null) PageConnexion_error = new Label();
        PageConnexion_error.setTextFill(Color.RED);
        
        contentBox.getChildren().addAll(connexionLabel, usernameField, passwordField, connecterButton, inscription, PageConnexion_error);

        HBox topBox = new HBox();
        topBox.getChildren().add(backButton);
        // topBox.setAlignment(Pos.TOP_LEFT);
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
        mainBox.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        panelCentral.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#CFE4FF"), CornerRadii.EMPTY, Insets.EMPTY)));

        Button backButton = new Button("Retour");
        backButton.setStyle("-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;");
        backButton.setOnAction(e -> {
            System.out.println("Bouton Retour cliqué");
        });
        backButton.setOnAction(new ControlerVue(this));

        VBox contentBox = new VBox(20);
        contentBox.setAlignment(Pos.CENTER);

        Label connexionLabel = new Label("Inscription");
        connexionLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        connexionLabel.setTextFill(Color.BLACK);
        connexionLabel.setAlignment(Pos.CENTER);
        VBox.setMargin(connexionLabel, new Insets(0, 0, 40, 0));

        usernameField = new TextField();
        usernameField.setPromptText("Identifiant");
        usernameField.setMaxWidth(320);

        passwordField = new PasswordField();
        passwordField.setPromptText("Mot de passe");
        passwordField.setMaxWidth(320);

        // New Password Confirmation Field
        confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Confirmez le mot de passe");
        confirmPasswordField.setMaxWidth(320);

        if (PageConnexion_error==null) PageConnexion_error = new Label();
        Label errorLabel = PageConnexion_error;
        errorLabel.setTextFill(Color.RED);

        Button connecterButton = new Button("S'inscrire");
        connecterButton.setStyle("-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;");
        connecterButton.setPrefWidth(320);
        connecterButton.setPrefHeight(25);
        connecterButton.setOnAction(new ControlerVue(this));
        // connecterButton.setOnAction(e -> {
        // if (!passwordField.getText().equals(confirmPasswordField.getText())) {
        // errorLabel.setText("Les mots de passe ne correspondent pas");
        // } else {
        // // Proceed with registration logic
        // System.out.println("Inscription réussie");
        // errorLabel.setText("");
        // }
        // });

        contentBox.getChildren().addAll(connexionLabel, usernameField, passwordField, confirmPasswordField,
                connecterButton, errorLabel);

        HBox topBox = new HBox();
        topBox.getChildren().add(backButton);
        // topBox.setAlignment(Pos.TOP_LEFT);
        topBox.setPadding(new Insets(0, 0, 0, 0));

        mainBox.getChildren().addAll(topBox, contentBox);

        mainBox.setMaxWidth(700);
        mainBox.setMaxHeight(400);

        panelCentral.setCenter(mainBox);
    }

    public void modeJournaliste() {
        panelCentral.getChildren().clear();

        VBox mainBox = new VBox(20);
        mainBox.setPadding(new Insets(20));
        mainBox.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        panelCentral.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#CFE4FF"), CornerRadii.EMPTY, Insets.EMPTY)));

        HBox topBox = new HBox(20);
        Accueil = new Button("Accueil");
        Accueil.setOnAction(new ControlerVue(this));
        Athletes = new Button("Athlètes");
        Athletes.setOnAction(new ControlerVue(this));
        Pays = new Button("Pays");
        Pays.setOnAction(new ControlerVue(this));
        Sports = new Button("Sports");
        Sports.setOnAction(new ControlerVue(this));

        topBox.getChildren().addAll(Accueil, Athletes, Pays, Sports);
        topBox.setAlignment(Pos.CENTER);

        Region spacer = new Region();
        spacer.setPrefHeight(10);

        mainBox.getChildren().addAll(topBox, spacer);
        mainBox.setMaxWidth(700);
        mainBox.setMaxHeight(400);

        panelCentral.setCenter(mainBox);
    }

    public void modeOrganisateur() {
        panelCentral.getChildren().clear();

        VBox mainBox = new VBox(20);
        mainBox.setPadding(new Insets(20));
        mainBox.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        panelCentral.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#CFE4FF"), CornerRadii.EMPTY, Insets.EMPTY)));

        HBox topBox = new HBox(20);
        Accueil = new Button("Accueil");
        Accueil.setOnAction(new ControlerVue(this));
        Athletes = new Button("Athlètes");
        Athletes.setOnAction(new ControlerVue(this));
        Pays = new Button("Pays");
        Pays.setOnAction(new ControlerVue(this));
        Sports = new Button("Sports");
        Sports.setOnAction(new ControlerVue(this));

        topBox.getChildren().addAll(Accueil, Athletes, Pays, Sports);
        topBox.setAlignment(Pos.CENTER);

        Region spacer = new Region();
        spacer.setPrefHeight(10);

        mainBox.getChildren().addAll(topBox, spacer);
        mainBox.setMaxWidth(700);
        mainBox.setMaxHeight(400);

        panelCentral.setCenter(mainBox);
    }

    public void modeAdministrateur() {
        panelCentral.getChildren().clear();

        VBox mainBox = new VBox(20);
        mainBox.setPadding(new Insets(20));
        mainBox.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        panelCentral.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#CFE4FF"), CornerRadii.EMPTY, Insets.EMPTY)));

        HBox topBox = new HBox(20);
        Accueil = new Button("Accueil");
        Accueil.setOnAction(new ControlerVue(this));
        Athletes = new Button("Athlètes");
        Athletes.setOnAction(new ControlerVue(this));
        Pays = new Button("Pays");
        Pays.setOnAction(new ControlerVue(this));
        Sports = new Button("Sports");
        Sports.setOnAction(new ControlerVue(this));

        topBox.getChildren().addAll(Accueil, Athletes, Pays, Sports);
        topBox.setAlignment(Pos.CENTER);

        Region spacer = new Region();
        spacer.setPrefHeight(10);

        mainBox.getChildren().addAll(topBox, spacer);
        mainBox.setMaxWidth(700);
        mainBox.setMaxHeight(400);

        panelCentral.setCenter(mainBox);
    }

    public void modeAthletes() {
        panelCentral.getChildren().clear();

        VBox mainBox = new VBox(20);
        mainBox.setPadding(new Insets(20));
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        panelCentral.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#CFE4FF"), CornerRadii.EMPTY, Insets.EMPTY)));

        TableView<Athlete> athleteTable = new TableView<>();
        athleteTable.setPrefWidth(500);
        athleteTable.setPrefHeight(300);

        TableColumn<Athlete, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Athlete, String> nameCol = new TableColumn<>("Nom");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("nom"));

        TableColumn<Athlete, Integer> ageCol = new TableColumn<>("Age");
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Athlete, String> sportCol = new TableColumn<>("Sport");
        sportCol.setCellValueFactory(new PropertyValueFactory<>("sport"));

        athleteTable.getColumns().addAll(Arrays.asList(idCol, nameCol, ageCol, sportCol));

        Button backButton = new Button("Retour");
        backButton.setOnAction(new ControlerVue(this));
        backButton.setStyle("-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;");

        mainBox.getChildren().addAll(athleteTable, backButton);
        panelCentral.setCenter(mainBox);
    }

    public void modePays() {
        panelCentral.getChildren().clear();

        VBox mainBox = new VBox(20);
        mainBox.setPadding(new Insets(20));
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        panelCentral.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#CFE4FF"), CornerRadii.EMPTY, Insets.EMPTY)));

        TableView<Pays> paysTable = new TableView<>();
        paysTable.setPrefWidth(500);
        paysTable.setPrefHeight(300);

        TableColumn<Pays, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Pays, String> nameCol = new TableColumn<>("Nom");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("nom"));

        paysTable.getColumns().addAll(Arrays.asList(idCol, nameCol));

        Button backButton = new Button("Retour");
        backButton.setOnAction(new ControlerVue(this));
        backButton.setStyle("-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;");

        mainBox.getChildren().addAll(paysTable, backButton);
        panelCentral.setCenter(mainBox);
    }

    public void modeSports() {
        panelCentral.getChildren().clear();

        VBox mainBox = new VBox(20);
        mainBox.setPadding(new Insets(20));
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        panelCentral.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#CFE4FF"), CornerRadii.EMPTY, Insets.EMPTY)));

        TableView<Sport> sportTable = new TableView<>();
        sportTable.setPrefWidth(500);
        sportTable.setPrefHeight(300);

        TableColumn<Sport, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Sport, String> nameCol = new TableColumn<>("Nom");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("nom"));

        sportTable.getColumns().addAll(Arrays.asList(idCol, nameCol));

        Button backButton = new Button("Retour");
        backButton.setOnAction(new ControlerVue(this));
        backButton.setStyle("-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;");

        mainBox.getChildren().addAll(sportTable, backButton);
        panelCentral.setCenter(mainBox);
    }

    public void afficherMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK);
        alert.showAndWait();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = laScene();
        stage.setScene(scene);
        stage.setTitle("Jeux IUT'Olympiques");
        stage.show();
        modeLog();
    }

    public static void main(String[] args) {
        launch();
    }

    public TextField getPasswordField() {
        return this.passwordField;

    }
}