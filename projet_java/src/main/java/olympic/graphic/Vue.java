package olympic.graphic;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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

/** class Vue extends Application */
public class Vue extends Application {
    /** private BorderPane fenetre */
    private BorderPane fenetre;
    /** private BorderPane Titre */
    private BorderPane Titre;
    /** private BorderPane PageConnexion */
    private HBox PageConnexion;
    /** private BorderPane PageAccueil */
    private BorderPane PageAccueil;
    /** private BorderPane PagePays */
    private BorderPane PagePays;
    /** private BorderPane PagesSports */
    private BorderPane PagesSports;
    /** private BorderPane PageSports */
    private BorderPane PageSports;
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
    /** TextField usernameField */
    public TextField usernameField;
    /** PasswordField passwordField */
    public PasswordField passwordField;
    /** PasswordField confirmPasswordField */
    public PasswordField confirmPasswordField;
    /** Label PageConnexion_error */
    public Label PageConnexion_error;

    public static Color NotreBlue = Color.valueOf("#3C5A9C");
    public static Color NotreBlueClaire = Color.valueOf("#CFE4FF");
    public static Font NoteFont = Font.font("Arial", FontWeight.BOLD, 24);

    /** void init() */
    @Override
    public void init() {
        datamanager.init();
        Create_PageConnexion();
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

    public void modeJournaliste() {
        /*
         * PanelCentral.getChildren().clear();
         * 
         * VBox mainBox = new VBox(20);
         * mainBox.setPadding(new Insets(20));
         * mainBox.setBackground(
         * new Background(new BackgroundFill(Color.valueOf("#ffffff"),
         * CornerRadii.EMPTY, Insets.EMPTY)));
         * PanelCentral.setBackground(
         * new Background(new BackgroundFill(Color.valueOf("#CFE4FF"),
         * CornerRadii.EMPTY, Insets.EMPTY)));
         * 
         * Button backButton = new Button("Retour");
         * backButton.setStyle("-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;"
         * );
         * backButton.setOnAction(new ControlerVue(this));
         * 
         * BResultat = new Button("Résultat");
         * BResultat.setOnAction(new ControlerVue(this));
         * BAthletes = new Button("Athlètes");
         * BAthletes.setOnAction(new ControlerVue(this));
         * BPays = new Button("BPays");
         * BPays.setOnAction(new ControlerVue(this));
         * BSports = new Button("BSports");
         * BSports.setOnAction(new ControlerVue(this));
         * 
         * String buttonStyle =
         * "-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;";
         * BResultat.setStyle(buttonStyle);
         * BAthletes.setStyle(buttonStyle);
         * BPays.setStyle(buttonStyle);
         * BSports.setStyle(buttonStyle);
         * 
         * HBox topBox = new HBox(10);
         * topBox.setPadding(new Insets(0, 0, 0, 0));
         * topBox.setAlignment(Pos.TOP_LEFT);
         * topBox.getChildren().add(backButton);
         * 
         * HBox menuBox = new HBox(10);
         * menuBox.setAlignment(Pos.TOP_RIGHT);
         * menuBox.getChildren().addAll(BResultat, BAthletes, BPays, BSports);
         * 
         * BorderPane topPane = new BorderPane();
         * topPane.setLeft(topBox);
         * topPane.setRight(menuBox);
         * 
         * VBox contentBox = new VBox(20);
         * contentBox.setAlignment(Pos.CENTER);
         * 
         * mainBox.getChildren().addAll(topPane, contentBox);
         * mainBox.setMaxWidth(750);
         * mainBox.setMaxHeight(500);
         * 
         * TextField barreDeRecherche = new TextField("Recherche par BPays et Epreuve");
         * 
         * ComboBox<String> comboBox = new ComboBox();
         * 
         * comboBox.setValue("BSports");
         * comboBox.getItems().addAll("Natation", "Volley-ball", "Escrime",
         * "Athlétisme", "Handball");
         * 
         * Button bRechercher = new Button("Rechercher");
         * 
         * TableView<Athlete> table = new TableView<>();
         * table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
         * 
         * TableColumn<Athlete, String> prenomCol = new TableColumn<>("Prénom");
         * prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
         * 
         * TableColumn<Athlete, String> nomCol = new TableColumn<>("Nom");
         * nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
         * 
         * TableColumn<Athlete, String> sexeCol = new TableColumn<>("Sexe");
         * sexeCol.setCellValueFactory(new PropertyValueFactory<>("sexe"));
         * 
         * TableColumn<Athlete, String> BPaysCol = new TableColumn<>("BPays");
         * BPaysCol.setCellValueFactory(new PropertyValueFactory<>("BPays"));
         * 
         * TableColumn<Athlete, String> BSportsCol = new TableColumn<>("BSports");
         * BSportsCol.setCellValueFactory(new PropertyValueFactory<>("BSports"));
         * 
         * table.getColumns().addAll(prenomCol, nomCol, sexeCol, BPaysCol, BSportsCol);
         * 
         * mainBox.getChildren().addAll(barreDeRecherche, comboBox, bRechercher, table);
         * 
         * PanelCentral.setCenter(mainBox);
         */
    }

    public void modeOrganisateur() {
        /*
         * PanelCentral.getChildren().clear();
         * 
         * VBox mainBox = new VBox(20);
         * mainBox.setPadding(new Insets(20));
         * mainBox.setBackground(
         * new Background(new BackgroundFill(Color.valueOf("#ffffff"),
         * CornerRadii.EMPTY, Insets.EMPTY)));
         * PanelCentral.setBackground(
         * new Background(new BackgroundFill(Color.valueOf("#CFE4FF"),
         * CornerRadii.EMPTY, Insets.EMPTY)));
         * 
         * Button backButton = new Button("Retour");
         * backButton.setStyle("-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;"
         * );
         * backButton.setOnAction(new ControlerVue(this));
         * 
         * BResultat = new Button("Résutlat");
         * BResultat.setOnAction(new ControlerVue(this));
         * BAthletes = new Button("Athlètes");
         * BAthletes.setOnAction(new ControlerVue(this));
         * BPays = new Button("BPays");
         * BPays.setOnAction(new ControlerVue(this));
         * BSports = new Button("BSports");
         * BSports.setOnAction(new ControlerVue(this));
         * 
         * String buttonStyle =
         * "-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;";
         * BResultat.setStyle(buttonStyle);
         * BAthletes.setStyle(buttonStyle);
         * BPays.setStyle(buttonStyle);
         * BSports.setStyle(buttonStyle);
         * 
         * HBox topBox = new HBox(10);
         * topBox.setPadding(new Insets(0, 0, 0, 0));
         * topBox.setAlignment(Pos.TOP_LEFT);
         * topBox.getChildren().add(backButton);
         * 
         * HBox menuBox = new HBox(10);
         * menuBox.setAlignment(Pos.TOP_RIGHT);
         * menuBox.getChildren().addAll(BResultat, BAthletes, BPays, BSports);
         * 
         * BorderPane topPane = new BorderPane();
         * topPane.setLeft(topBox);
         * topPane.setRight(menuBox);
         * 
         * VBox contentBox = new VBox(20);
         * contentBox.setAlignment(Pos.CENTER);
         * 
         * mainBox.getChildren().addAll(topPane, contentBox);
         * mainBox.setMaxWidth(750);
         * mainBox.setMaxHeight(500);
         * 
         * PanelCentral.setCenter(mainBox);
         */
    }

    public void modeAdministrateur() {
        /*
         * PanelCentral.getChildren().clear();
         * 
         * VBox mainBox = new VBox(20);
         * mainBox.setPadding(new Insets(20));
         * mainBox.setBackground(
         * new Background(new BackgroundFill(Color.valueOf("#ffffff"),
         * CornerRadii.EMPTY, Insets.EMPTY)));
         * PanelCentral.setBackground(
         * new Background(new BackgroundFill(Color.valueOf("#CFE4FF"),
         * CornerRadii.EMPTY, Insets.EMPTY)));
         * 
         * Button backButton = new Button("Retour");
         * backButton.setStyle("-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;"
         * );
         * backButton.setOnAction(new ControlerVue(this));
         * 
         * BResultat = new Button("Résultat");
         * BResultat.setOnAction(new ControlerVue(this));
         * BAthletes = new Button("Athlètes");
         * BAthletes.setOnAction(new ControlerVue(this));
         * BPays = new Button("BPays");
         * BPays.setOnAction(new ControlerVue(this));
         * BSports = new Button("BSports");
         * BSports.setOnAction(new ControlerVue(this));
         * 
         * String buttonStyle =
         * "-fx-background-color: #3C5A9C; -fx-text-fill: #ffffff;";
         * BResultat.setStyle(buttonStyle);
         * BAthletes.setStyle(buttonStyle);
         * BPays.setStyle(buttonStyle);
         * BSports.setStyle(buttonStyle);
         * 
         * HBox topBox = new HBox(10);
         * topBox.setPadding(new Insets(0, 0, 0, 0));
         * topBox.setAlignment(Pos.TOP_LEFT);
         * topBox.getChildren().add(backButton);
         * 
         * HBox menuBox = new HBox(10);
         * menuBox.setAlignment(Pos.TOP_RIGHT);
         * menuBox.getChildren().addAll(BResultat, BAthletes, BPays, BSports);
         * 
         * BorderPane topPane = new BorderPane();
         * topPane.setLeft(topBox);
         * topPane.setRight(menuBox);
         * 
         * VBox contentBox = new VBox(20);
         * contentBox.setAlignment(Pos.CENTER);
         * 
         * mainBox.getChildren().addAll(topPane, contentBox);
         * mainBox.setMaxWidth(750);
         * mainBox.setMaxHeight(500);
         * 
         * PanelCentral.setCenter(mainBox);
         */
    }

    public void Create_modeAthletes(boolean organisateur, boolean admin) {
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

    public void Create_modePays(boolean organisateur, boolean admin) {
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

    public void Create_modeSports(boolean organisateur, boolean admin) {
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

    /** void Switch_modeAccueil() */
    public void Switch_modeAccueil() {
        fenetre.setCenter(PageAccueil);
    }

    /** void Switch_modeSports() */
    public void Switch_modeSports() {
        fenetre.setCenter(PageSports);
    }

    /** void Switch_modePays() */
    public void Switch_modePays() {
        fenetre.setCenter(PagePays);
    }

    /** void Switch_modesSports() */
    public void Switch_modesSports() {
        fenetre.setCenter(PagesSports);
    }

    /** void Switch_Connexion() */
    public void Switch_Connexion() {
        fenetre.setCenter(PageConnexion);
    }

    public void Create_PaneLive(boolean organisateur, boolean admin) {
        Create_modeAthletes(organisateur, admin);
        Create_modePays(organisateur, admin);
        Create_modeSports(organisateur, admin);
    }

    public void Create_PageConnexion() {
        String root_style_light = "-fx-background-color: "+color_format(NotreBlueClaire)+"; -fx-text-fill: "+color_format(Color.WHITE)+";";
        String root_style_dark = "-fx-background-color: "+color_format(NotreBlue)+"; -fx-text-fill: "+color_format(Color.WHITE)+";";
        PageConnexion = new HBox();
        HBox root = PageConnexion;

        PageConnexion_error = new Label();
        PageConnexion_error.setTextFill(Color.RED);

        usernameField = new TextField();
        usernameField.setPromptText("Identifiant");
        usernameField.setAlignment(Pos.CENTER);

        passwordField = new PasswordField();
        passwordField.setPromptText("Mot de passe");
        passwordField.setAlignment(Pos.CENTER);

        confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Mot de passe");
        confirmPasswordField.setAlignment(Pos.CENTER);


        // Partie connection
        GridPane paneconn = new GridPane();
        // paneconn.setPadding(new Insets(20));
        paneconn.setStyle(root_style_light);
        paneconn.setAlignment(Pos.CENTER);

        Label paneconn_label = new Label("Connection");
        paneconn_label.setFont(NoteFont);
        paneconn_label.setAlignment(Pos.CENTER);
        paneconn_label.setStyle(root_style_light);
        GridPane.setMargin(paneconn_label, new Insets(0, 0, 40, 0));
        paneconn.add(paneconn_label, 0, 0,2,1);

        Label paneconn_id = new Label("identifiant");
        paneconn_id.setFont(NoteFont);
        paneconn_id.setAlignment(Pos.CENTER);
        GridPane.setMargin(paneconn_id, new Insets(0, 0, 40, 0));
        paneconn.add(paneconn_id, 0, 1);
        
        paneconn.add(usernameField, 1, 1);

        Label paneconn_mdp = new Label("mot de passe");
        paneconn_mdp.setFont(NoteFont);
        paneconn_mdp.setAlignment(Pos.CENTER);
        GridPane.setMargin(paneconn_mdp, new Insets(0, 0, 40, 0));
        paneconn.add(paneconn_mdp, 0, 2);
        
        paneconn.add(passwordField, 1, 2);
        paneconn.add(PageConnexion_error, 0, 3,2,1);

        Button paneconn_connect = new Button("Se Connecter");
        paneconn_connect.setStyle(root_style_dark);
        paneconn_connect.setOnAction(new ControlerVue(this));
        paneconn.add(paneconn_connect, 0, 4,2,1);

        // Partie inscription
        GridPane paneinsc = new GridPane();
        paneinsc.setPadding(new Insets(20));
        paneinsc.setStyle(root_style_light);
        paneinsc.setAlignment(Pos.CENTER);

        Label paneinsc_label = new Label("Inscription");
        paneinsc_label.setFont(NoteFont);
        paneinsc_label.setAlignment(Pos.CENTER);
        paneinsc_label.setStyle(root_style_light);
        GridPane.setMargin(paneinsc_label, new Insets(0, 0, 40, 0));
        paneinsc.add(paneinsc_label, 0, 0,2,1);

        Label paneinsc_id = new Label("identifiant");
        paneinsc_id.setFont(NoteFont);
        paneinsc_id.setAlignment(Pos.CENTER);
        GridPane.setMargin(paneinsc_id, new Insets(0, 0, 40, 0));
        paneinsc.add(paneinsc_id, 0, 1);
        
        paneinsc.add(usernameField, 1, 1);

        Label paneinsc_mdp = new Label("mot de passe");
        paneinsc_mdp.setFont(NoteFont);
        paneinsc_mdp.setAlignment(Pos.CENTER);
        GridPane.setMargin(paneinsc_mdp, new Insets(0, 0, 40, 0));
        paneinsc.add(paneinsc_mdp, 0, 2);
        
        paneinsc.add(passwordField, 1, 2);

        Label paneinsc_mdpconf = new Label("confirmer mot de passe");
        paneinsc_mdpconf.setFont(NoteFont);
        paneinsc_mdpconf.setAlignment(Pos.CENTER);
        GridPane.setMargin(paneinsc_mdpconf, new Insets(0, 0, 40, 0));
        paneinsc.add(paneinsc_mdpconf, 0, 3);
        
        paneinsc.add(confirmPasswordField, 1, 3);
        paneinsc.add(PageConnexion_error, 0, 4,2,1);

        Button connecterButton = new Button("S'Inscrire");
        connecterButton.setStyle(root_style_dark);
        connecterButton.setOnAction(new ControlerVue(this));
        paneinsc.add(connecterButton, 0, 5,2,1);

        
        Region divrect = new Region();
        divrect.setPrefSize(200, 200);
        divrect.setStyle(root_style_dark+ " -fx-background-radius: 10 10 0 10;");
        root.getChildren().addAll(paneconn,divrect,paneinsc);
    }

    private String color_format(Color c) {
        int r = (int)Math.round(c.getRed() * 255.0);
        int g = (int)Math.round(c.getGreen() * 255.0);
        int b = (int)Math.round(c.getBlue() * 255.0);
        int o = (int)Math.round(c.getOpacity() * 255.0);
        return String.format("#%02x%02x%02x%02x" , r, g, b, o);
    }

    /** start
     * @param stage Stage la fenetre
     */
    @Override
    public void start(Stage stage) {
        stage.setTitle("Jeux IUT'Olympiques");
        fenetre = new BorderPane();

        Titre = new BorderPane();
        Titre.setPadding(new Insets(20));

        Label TitreLabel = new Label("Jeux IUT'Olympiques");
        Font font = Font.font("Arial", 24);
        TitreLabel.setFont(font);
        TitreLabel.setTextFill(Color.WHITE);
        
        HBox titleBox = new HBox();
        titleBox.setAlignment(Pos.CENTER);
        titleBox.setBackground(new Background(new BackgroundFill(NotreBlue, CornerRadii.EMPTY, Insets.EMPTY)));
        titleBox.getChildren().add(TitreLabel);
        Titre.setCenter(titleBox);

        fenetre.setTop(Titre);
        fenetre.setCenter(PageConnexion);
        Scene scene = new Scene(fenetre, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    /** main
     * 
     * @param args args String[] temr launch args
     */
    public static void main(String[] args) {
        launch(args);
    }
}