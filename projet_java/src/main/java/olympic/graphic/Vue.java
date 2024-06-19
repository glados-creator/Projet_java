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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
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
import olympic.model.Athlete;
import olympic.model.Pays;
import olympic.model.Sport;
import javafx.scene.control.ComboBox;

/** class Vue extends Application */
public class Vue extends Application {
    /** private BorderPane fenetre */
    private BorderPane fenetre;
    /** private BorderPane PaneConnexion */
    private BorderPane PaneConnexion;
    /** private BorderPane PanelCentral */
    private BorderPane PanelCentral;
    /** private Button BInscription */
    private Button BInscription;
    /** private Button Inscription */
    private Button Inscription;
    /** private Button BResultat */
    private Button BResultat;
    /** private Button BAthletes */
    private Button BAthletes;
    /** private Button BPays */
    private Button BPays;
    /** private Button BSports */
    private Button BSports;

    /** void init() */
    @Override
    public void init() {
        CreatePaneConnexion();
    }

    public void modeLog() {
        PanelCentral.getChildren().clear();
        VBox buttonbox = new VBox(20);
        buttonbox.setAlignment(Pos.CENTER);
        buttonbox.setPadding(new Insets(20));

        buttonbox.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        PanelCentral.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#CFE4FF"), CornerRadii.EMPTY, Insets.EMPTY)));

        BInscription = new Button("BInscription");
        BInscription.setOnAction(new ControlerVue(this));
        Inscription = new Button("Inscription");
        Inscription.setOnAction(new ControlerVue(this));

        String buttonStyle = "-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff; -fx-font-size: 18px;";

        BInscription.setStyle(buttonStyle);
        Inscription.setStyle(buttonStyle);

        BInscription.setMinWidth(175);
        BInscription.setMinHeight(75);
        Inscription.setMinWidth(175);
        Inscription.setMinHeight(75);

        Region spacer = new Region();
        spacer.setPrefHeight(10);

        buttonbox.getChildren().addAll(BInscription, spacer, Inscription);

        buttonbox.setMaxWidth(300);
        buttonbox.setMaxHeight(400);

        PanelCentral.setCenter(buttonbox);
    }

    public void modeConnexion() {
        PanelCentral.getChildren().clear();

        VBox mainBox = new VBox(20);
        mainBox.setPadding(new Insets(20));
        mainBox.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        PanelCentral.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#CFE4FF"), CornerRadii.EMPTY, Insets.EMPTY)));

        Button backButton = new Button("Retour");
        backButton.setStyle("-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;");
        backButton.setOnAction(e -> {
            System.out.println("Bouton Retour cliqué");
        });
        backButton.setOnAction(new ControlerVue(this));

        VBox contentBox = new VBox(20);
        contentBox.setAlignment(Pos.CENTER);

        Label BInscriptionLabel = new Label("BInscription");
        BInscriptionLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        BInscriptionLabel.setTextFill(Color.BLACK);
        BInscriptionLabel.setAlignment(Pos.CENTER);
        VBox.setMargin(BInscriptionLabel, new Insets(0, 0, 40, 0));

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
        inscription.setOnAction(new ControlerVue(this));

        contentBox.getChildren().addAll(BInscriptionLabel, usernameField, passwordField, connecterButton, inscription);

        HBox topBox = new HBox();
        topBox.getChildren().add(backButton);
        // topBox.setAlignment(Pos.TOP_LEFT);
        topBox.setPadding(new Insets(0, 0, 0, 0));

        mainBox.getChildren().addAll(topBox, contentBox);

        mainBox.setMaxWidth(700);
        mainBox.setMaxHeight(400);

        PanelCentral.setCenter(mainBox);
    }

    public void modeInscription() {

        PanelCentral.getChildren().clear();

        VBox mainBox = new VBox(20);
        mainBox.setPadding(new Insets(20));
        mainBox.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        PanelCentral.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#CFE4FF"), CornerRadii.EMPTY, Insets.EMPTY)));

        Button backButton = new Button("Retour");
        backButton.setStyle("-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;");
        backButton.setOnAction(e -> {
            System.out.println("Bouton Retour cliqué");
        });
        backButton.setOnAction(new ControlerVue(this));

        VBox contentBox = new VBox(20);
        contentBox.setAlignment(Pos.CENTER);

        Label BInscriptionLabel = new Label("Inscription");
        BInscriptionLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        BInscriptionLabel.setTextFill(Color.BLACK);
        BInscriptionLabel.setAlignment(Pos.CENTER);
        VBox.setMargin(BInscriptionLabel, new Insets(0, 0, 40, 0));

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

        contentBox.getChildren().addAll(BInscriptionLabel, usernameField, passwordField, confirmPasswordField,
                connecterButton, errorLabel);

        HBox topBox = new HBox();
        topBox.getChildren().add(backButton);
        // topBox.setAlignment(Pos.TOP_LEFT);
        topBox.setPadding(new Insets(0, 0, 0, 0));

        mainBox.getChildren().addAll(topBox, contentBox);

        mainBox.setMaxWidth(700);
        mainBox.setMaxHeight(400);

        PanelCentral.setCenter(mainBox);
    }

    public void modeJournaliste() {
        /* 
        PanelCentral.getChildren().clear();

        VBox mainBox = new VBox(20);
        mainBox.setPadding(new Insets(20));
        mainBox.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        PanelCentral.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#CFE4FF"), CornerRadii.EMPTY, Insets.EMPTY)));

        Button backButton = new Button("Retour");
        backButton.setStyle("-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;");
        backButton.setOnAction(new ControlerVue(this));

        BResultat = new Button("Résultat");
        BResultat.setOnAction(new ControlerVue(this));
        BAthletes = new Button("Athlètes");
        BAthletes.setOnAction(new ControlerVue(this));
        BPays = new Button("BPays");
        BPays.setOnAction(new ControlerVue(this));
        BSports = new Button("BSports");
        BSports.setOnAction(new ControlerVue(this));

        String buttonStyle = "-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;";
        BResultat.setStyle(buttonStyle);
        BAthletes.setStyle(buttonStyle);
        BPays.setStyle(buttonStyle);
        BSports.setStyle(buttonStyle);

        HBox topBox = new HBox(10);
        topBox.setPadding(new Insets(0, 0, 0, 0));
        topBox.setAlignment(Pos.TOP_LEFT);
        topBox.getChildren().add(backButton);

        HBox menuBox = new HBox(10);
        menuBox.setAlignment(Pos.TOP_RIGHT);
        menuBox.getChildren().addAll(BResultat, BAthletes, BPays, BSports);

        BorderPane topPane = new BorderPane();
        topPane.setLeft(topBox);
        topPane.setRight(menuBox);

        VBox contentBox = new VBox(20);
        contentBox.setAlignment(Pos.CENTER);

        mainBox.getChildren().addAll(topPane, contentBox);
        mainBox.setMaxWidth(750);
        mainBox.setMaxHeight(500);

        TextField barreDeRecherche = new TextField("Recherche par BPays et Epreuve");

        ComboBox<String> comboBox = new ComboBox();

        comboBox.setValue("BSports");
        comboBox.getItems().addAll("Natation", "Volley-ball", "Escrime", "Athlétisme", "Handball");

        Button bRechercher = new Button("Rechercher");

        TableView<Athlete> table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Athlete, String> prenomCol = new TableColumn<>("Prénom");
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));

        TableColumn<Athlete, String> nomCol = new TableColumn<>("Nom");
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));

        TableColumn<Athlete, String> sexeCol = new TableColumn<>("Sexe");
        sexeCol.setCellValueFactory(new PropertyValueFactory<>("sexe"));

        TableColumn<Athlete, String> BPaysCol = new TableColumn<>("BPays");
        BPaysCol.setCellValueFactory(new PropertyValueFactory<>("BPays"));

        TableColumn<Athlete, String> BSportsCol = new TableColumn<>("BSports");
        BSportsCol.setCellValueFactory(new PropertyValueFactory<>("BSports"));

        table.getColumns().addAll(prenomCol, nomCol, sexeCol, BPaysCol, BSportsCol);

        mainBox.getChildren().addAll(barreDeRecherche, comboBox, bRechercher, table);

        PanelCentral.setCenter(mainBox);
        */
    }

    public void modeOrganisateur() {
        /*
        PanelCentral.getChildren().clear();

        VBox mainBox = new VBox(20);
        mainBox.setPadding(new Insets(20));
        mainBox.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        PanelCentral.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#CFE4FF"), CornerRadii.EMPTY, Insets.EMPTY)));

        Button backButton = new Button("Retour");
        backButton.setStyle("-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;");
        backButton.setOnAction(new ControlerVue(this));

        BResultat = new Button("Résutlat");
        BResultat.setOnAction(new ControlerVue(this));
        BAthletes = new Button("Athlètes");
        BAthletes.setOnAction(new ControlerVue(this));
        BPays = new Button("BPays");
        BPays.setOnAction(new ControlerVue(this));
        BSports = new Button("BSports");
        BSports.setOnAction(new ControlerVue(this));

        String buttonStyle = "-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;";
        BResultat.setStyle(buttonStyle);
        BAthletes.setStyle(buttonStyle);
        BPays.setStyle(buttonStyle);
        BSports.setStyle(buttonStyle);

        HBox topBox = new HBox(10);
        topBox.setPadding(new Insets(0, 0, 0, 0));
        topBox.setAlignment(Pos.TOP_LEFT);
        topBox.getChildren().add(backButton);

        HBox menuBox = new HBox(10);
        menuBox.setAlignment(Pos.TOP_RIGHT);
        menuBox.getChildren().addAll(BResultat, BAthletes, BPays, BSports);

        BorderPane topPane = new BorderPane();
        topPane.setLeft(topBox);
        topPane.setRight(menuBox);

        VBox contentBox = new VBox(20);
        contentBox.setAlignment(Pos.CENTER);

        mainBox.getChildren().addAll(topPane, contentBox);
        mainBox.setMaxWidth(750);
        mainBox.setMaxHeight(500);

        PanelCentral.setCenter(mainBox);
        */
    }

    public void modeAdministrateur() {
        /*
        PanelCentral.getChildren().clear();

        VBox mainBox = new VBox(20);
        mainBox.setPadding(new Insets(20));
        mainBox.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        PanelCentral.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#CFE4FF"), CornerRadii.EMPTY, Insets.EMPTY)));

        Button backButton = new Button("Retour");
        backButton.setStyle("-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;");
        backButton.setOnAction(new ControlerVue(this));

        BResultat = new Button("Résultat");
        BResultat.setOnAction(new ControlerVue(this));
        BAthletes = new Button("Athlètes");
        BAthletes.setOnAction(new ControlerVue(this));
        BPays = new Button("BPays");
        BPays.setOnAction(new ControlerVue(this));
        BSports = new Button("BSports");
        BSports.setOnAction(new ControlerVue(this));

        String buttonStyle = "-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;";
        BResultat.setStyle(buttonStyle);
        BAthletes.setStyle(buttonStyle);
        BPays.setStyle(buttonStyle);
        BSports.setStyle(buttonStyle);

        HBox topBox = new HBox(10);
        topBox.setPadding(new Insets(0, 0, 0, 0));
        topBox.setAlignment(Pos.TOP_LEFT);
        topBox.getChildren().add(backButton);

        HBox menuBox = new HBox(10);
        menuBox.setAlignment(Pos.TOP_RIGHT);
        menuBox.getChildren().addAll(BResultat, BAthletes, BPays, BSports);

        BorderPane topPane = new BorderPane();
        topPane.setLeft(topBox);
        topPane.setRight(menuBox);

        VBox contentBox = new VBox(20);
        contentBox.setAlignment(Pos.CENTER);

        mainBox.getChildren().addAll(topPane, contentBox);
        mainBox.setMaxWidth(750);
        mainBox.setMaxHeight(500);

        PanelCentral.setCenter(mainBox);
        */
    }

    public void Create_modeAthletes(boolean organisateur,boolean admin) {
        PanelCentral.getChildren().clear();

        VBox mainBox = new VBox(20);
        mainBox.setPadding(new Insets(20));
        mainBox.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        PanelCentral.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#CFE4FF"), CornerRadii.EMPTY, Insets.EMPTY)));

        Button backButton = new Button("Retour");
        backButton.setStyle("-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;");
        backButton.setOnAction(new ControlerVue(this));

        BResultat = new Button("Résultat");
        BResultat.setOnAction(new ControlerVue(this));
        BAthletes = new Button("Athlètes");
        BAthletes.setOnAction(new ControlerVue(this));
        BPays = new Button("BPays");
        BPays.setOnAction(new ControlerVue(this));
        BSports = new Button("BSports");
        BSports.setOnAction(new ControlerVue(this));

        String buttonStyle = "-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;";
        BResultat.setStyle(buttonStyle);
        BAthletes.setStyle(buttonStyle);
        BPays.setStyle(buttonStyle);
        BSports.setStyle(buttonStyle);

        HBox topBox = new HBox(10);
        topBox.setPadding(new Insets(0, 0, 0, 0));
        topBox.setAlignment(Pos.TOP_LEFT);
        topBox.getChildren().add(backButton);

        HBox menuBox = new HBox(10);
        menuBox.setAlignment(Pos.TOP_RIGHT);
        menuBox.getChildren().addAll(BResultat, BAthletes, BPays, BSports);

        BorderPane topPane = new BorderPane();
        topPane.setLeft(topBox);
        topPane.setRight(menuBox);

        TableView<Athlete> table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Athlete, String> prenomCol = new TableColumn<>("Prénom");
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));

        TableColumn<Athlete, String> nomCol = new TableColumn<>("Nom");
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));

        TableColumn<Athlete, String> sexeCol = new TableColumn<>("Sexe");
        sexeCol.setCellValueFactory(new PropertyValueFactory<>("sexe"));

        TableColumn<Athlete, String> BPaysCol = new TableColumn<>("BPays");
        BPaysCol.setCellValueFactory(new PropertyValueFactory<>("BPays"));

        TableColumn<Athlete, String> BSportsCol = new TableColumn<>("BSports");
        BSportsCol.setCellValueFactory(new PropertyValueFactory<>("BSports"));

        table.getColumns().addAll(prenomCol, nomCol, sexeCol, BPaysCol, BSportsCol);

        VBox contentBox = new VBox(20);
        contentBox.setAlignment(Pos.CENTER);
        contentBox.getChildren().add(table);

        mainBox.getChildren().addAll(topPane, contentBox);
        mainBox.setMaxWidth(750);
        mainBox.setMaxHeight(500);

        PanelCentral.setCenter(mainBox);
    }

    public void Create_modePays(boolean organisateur,boolean admin) {
        PanelCentral.getChildren().clear();

        VBox mainBox = new VBox(20);
        mainBox.setPadding(new Insets(20));
        mainBox.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        PanelCentral.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#CFE4FF"), CornerRadii.EMPTY, Insets.EMPTY)));

        Button backButton = new Button("Retour");
        backButton.setStyle("-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;");
        backButton.setOnAction(new ControlerVue(this));

        BResultat = new Button("Résultat");
        BResultat.setOnAction(new ControlerVue(this));
        BAthletes = new Button("Athlètes");
        BAthletes.setOnAction(new ControlerVue(this));
        BPays = new Button("BPays");
        BPays.setOnAction(new ControlerVue(this));
        BSports = new Button("BSports");
        BSports.setOnAction(new ControlerVue(this));

        String buttonStyle = "-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;";
        BResultat.setStyle(buttonStyle);
        BAthletes.setStyle(buttonStyle);
        BPays.setStyle(buttonStyle);
        BSports.setStyle(buttonStyle);

        HBox topBox = new HBox(10);
        topBox.setPadding(new Insets(0, 0, 0, 0));
        topBox.setAlignment(Pos.TOP_LEFT);
        topBox.getChildren().add(backButton);

        HBox menuBox = new HBox(10);
        menuBox.setAlignment(Pos.TOP_RIGHT);
        menuBox.getChildren().addAll(BResultat, BAthletes, BPays, BSports);

        BorderPane topPane = new BorderPane();
        topPane.setLeft(topBox);
        topPane.setRight(menuBox);

        TableView<Pays> table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Pays, String> NomBPaysCol = new TableColumn<>("Nom du BPays");
        NomBPaysCol.setCellValueFactory(new PropertyValueFactory<>("Nom du Pay"));

        TableColumn<Pays, String> DrapeauCol = new TableColumn<>("Drapeau du BPays");
        DrapeauCol.setCellValueFactory(new PropertyValueFactory<>("Drapeau du BPays"));

        table.getColumns().addAll(NomBPaysCol, DrapeauCol);

        VBox contentBox = new VBox(20);
        contentBox.setAlignment(Pos.CENTER);
        contentBox.getChildren().add(table);

        mainBox.getChildren().addAll(topPane, contentBox);
        mainBox.setMaxWidth(750);
        mainBox.setMaxHeight(500);

        PanelCentral.setCenter(mainBox);

    }

    public void Create_modeSports(boolean organisateur,boolean admin) {
        PanelCentral.getChildren().clear();

        VBox mainBox = new VBox(20);
        mainBox.setPadding(new Insets(20));
        mainBox.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        PanelCentral.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#CFE4FF"), CornerRadii.EMPTY, Insets.EMPTY)));

        Button backButton = new Button("Retour");
        backButton.setStyle("-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;");
        backButton.setOnAction(new ControlerVue(this));

        BResultat = new Button("Résultat");
        BResultat.setOnAction(new ControlerVue(this));
        BAthletes = new Button("Athlètes");
        BAthletes.setOnAction(new ControlerVue(this));
        BPays = new Button("BPays");
        BPays.setOnAction(new ControlerVue(this));
        BSports = new Button("BSports");
        BSports.setOnAction(new ControlerVue(this));

        String buttonStyle = "-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;";
        BResultat.setStyle(buttonStyle);
        BAthletes.setStyle(buttonStyle);
        BPays.setStyle(buttonStyle);
        BSports.setStyle(buttonStyle);

        HBox topBox = new HBox(10);
        topBox.setPadding(new Insets(0, 0, 0, 0));
        topBox.setAlignment(Pos.TOP_LEFT);
        topBox.getChildren().add(backButton);

        HBox menuBox = new HBox(10);
        menuBox.setAlignment(Pos.TOP_RIGHT);
        menuBox.getChildren().addAll(BResultat, BAthletes, BPays, BSports);

        BorderPane topPane = new BorderPane();
        topPane.setLeft(topBox);
        topPane.setRight(menuBox);

        TableView<Sport> table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Sport, String> NomBPaysCol = new TableColumn<>("Nom du Sport");
        NomBPaysCol.setCellValueFactory(new PropertyValueFactory<>("Nom du Sport"));

        TableColumn<Sport, String> DrapeauCol = new TableColumn<>("Nombre de participants");
        DrapeauCol.setCellValueFactory(new PropertyValueFactory<>("Nombre de participants"));

        table.getColumns().addAll(NomBPaysCol, DrapeauCol);

        VBox contentBox = new VBox(20);
        contentBox.setAlignment(Pos.CENTER);
        contentBox.getChildren().add(table);

        mainBox.getChildren().addAll(topPane, contentBox);
        mainBox.setMaxWidth(750);
        mainBox.setMaxHeight(500);

        PanelCentral.setCenter(mainBox);
    }

    Switch_modeAccueil
    Switch_modeSports
    Switch_modePays 
    Switch_modesSports
    Switch_Connexion



    public Pane Create_PaneLive(boolean organisateur,boolean admin){
        // TODO : TODO
        Create_modeAthletes(organisateur, admin);
        Create_modePays(organisateur, admin);
        Create_modeSports(organisateur, admin);
        return null;
    }

    public Pane Create_PaneConnexion(){
        // TODO : TODO
        return null;
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Jeux IUT'Olympiques");
        fenetre = new BorderPane();

        BorderPane Titre = new BorderPane();
        Titre.setPadding(new Insets(20));

        Label TitreLabel = new Label("Jeux IUT'Olympiques");
        Font font = Font.font("Arial", 24);
        TitreLabel.setFont(font);
        TitreLabel.setBackground(
                new Background(new BackgroundFill(Color.valueOf("#CFE4FF"), CornerRadii.EMPTY, Insets.EMPTY)));

        HBox titleBox = new HBox();
        titleBox.setAlignment(Pos.CENTER);
        titleBox.getChildren().add(TitreLabel);
        Titre.setCenter(titleBox);

        fenetre.setTop(Titre);
        fenetre.setCenter(PaneConnexion);
        Scene scene = new Scene(fenetre, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}