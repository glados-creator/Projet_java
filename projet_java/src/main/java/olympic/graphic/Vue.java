package olympic.graphic;

import java.util.Arrays;

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
import javafx.scene.layout.Border;
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
    /** private BorderPane Menu */
    private BorderPane Menu;
    /** private BorderPane PageAccueil */
    private BorderPane PageAccueil;
    /** private BorderPane PagePays */
    private BorderPane PagePays;
    /** private BorderPane PagesSports */
    private BorderPane PagesSports;
    /** private BorderPane PageSports */
    private BorderPane PageSports;
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

    public void Create_modeAthletes(boolean organisateur, boolean admin) {
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

        table.getColumns().addAll(Arrays.asList(prenomCol, nomCol, sexeCol, BPaysCol, BSportsCol));

        VBox contentBox = new VBox(20);
        contentBox.setAlignment(Pos.CENTER);
        contentBox.getChildren().add(table);
    }

    public void Create_modePays(boolean organisateur, boolean admin) {
        TableView<Pays> table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Pays, String> NomBPaysCol = new TableColumn<>("Nom du BPays");
        NomBPaysCol.setCellValueFactory(new PropertyValueFactory<>("Nom du Pay"));

        TableColumn<Pays, String> DrapeauCol = new TableColumn<>("Drapeau du BPays");
        DrapeauCol.setCellValueFactory(new PropertyValueFactory<>("Drapeau du BPays"));

        table.getColumns().addAll(Arrays.asList(NomBPaysCol, DrapeauCol));

        VBox contentBox = new VBox(20);
        contentBox.setAlignment(Pos.CENTER);
        contentBox.getChildren().add(table);

    }

    public void Create_modeSports(boolean organisateur, boolean admin) {
        TableView<Sport> table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Sport, String> NomBPaysCol = new TableColumn<>("Nom du Sport");
        NomBPaysCol.setCellValueFactory(new PropertyValueFactory<>("Nom du Sport"));

        TableColumn<Sport, String> DrapeauCol = new TableColumn<>("Nombre de participants");
        DrapeauCol.setCellValueFactory(new PropertyValueFactory<>("Nombre de participants"));

        table.getColumns().addAll(Arrays.asList(NomBPaysCol, DrapeauCol));
    }

    public void Create_modeAccueil(boolean organisateur, boolean admin) {
        TableView<Sport> table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Sport, String> NomBPaysCol = new TableColumn<>("Nom du Sport");
        NomBPaysCol.setCellValueFactory(new PropertyValueFactory<>("Nom du Sport"));

        TableColumn<Sport, String> DrapeauCol = new TableColumn<>("Nombre de participants");
        DrapeauCol.setCellValueFactory(new PropertyValueFactory<>("Nombre de participants"));

        table.getColumns().addAll(Arrays.asList(NomBPaysCol, DrapeauCol));

        VBox contentBox = new VBox(20);
        contentBox.setAlignment(Pos.CENTER);
        contentBox.getChildren().add(table);
    }

    public void Create_Menu(boolean organisateur, boolean admin) {
        Menu = new BorderPane();
        // titre back

        Button BResultat = new Button("Résultat");
        BResultat.setOnAction(new ControlerVue(this));
        Button BAthletes = new Button("Athlètes");
        BAthletes.setOnAction(new ControlerVue(this));
        Button BPays = new Button("BPays");
        BPays.setOnAction(new ControlerVue(this));
        Button BSports = new Button("BSports");
        BSports.setOnAction(new ControlerVue(this));

        String buttonStyle = "-fx-background-color: " + color_format(NotreBlue) + "; -fx-text-fill: "
                + color_format(Color.WHITE) + ";";
        BResultat.setStyle(buttonStyle);
        BAthletes.setStyle(buttonStyle);
        BPays.setStyle(buttonStyle);
        BSports.setStyle(buttonStyle);

        HBox menuBox = new HBox(10);
        menuBox.setAlignment(Pos.TOP_RIGHT);
        menuBox.getChildren().addAll(BAthletes, BPays, BSports);

        Menu.setRight(menuBox);
        Menu.setLeft(BResultat);

        Menu.setCenter(PageAccueil);
        fenetre.setCenter(Menu);
    }

    /** void Switch_modeAccueil() */
    public void Switch_modeAccueil() {
        Menu.setCenter(PageAccueil);
    }

    /** void Switch_modeSports() */
    public void Switch_modeSports() {
        Menu.setCenter(PageSports);
    }

    /** void Switch_modePays() */
    public void Switch_modePays() {
        Menu.setCenter(PagePays);
    }

    /** void Switch_modesSports() */
    public void Switch_modesSports() {
        Menu.setCenter(PagesSports);
    }

    /** void Switch_Connexion() */
    public void Switch_Connexion() {
        // titre remove back
        Menu.setCenter(PageConnexion);
    }

    public void Create_PaneLive(boolean organisateur, boolean admin) {
        Create_modeAccueil(organisateur, admin);
        Create_modeAthletes(organisateur, admin);
        Create_modePays(organisateur, admin);
        Create_modeSports(organisateur, admin);
        Create_Menu(organisateur, admin);
        Switch_modeAccueil();
    }

    public void Create_PageConnexion() {
        String root_style_light = "-fx-background-color: " + color_format(NotreBlueClaire) + "; -fx-text-fill: "
                + color_format(Color.BLACK) + ";";
        String root_style_dark = "-fx-background-color: " + color_format(NotreBlue) + "; -fx-text-fill: "
                + color_format(Color.WHITE) + ";";
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

        Label paneconn_label = new Label("Connexion");
        paneconn_label.setFont(NoteFont);
        paneconn_label.setAlignment(Pos.CENTER);
        paneconn_label.setStyle(root_style_light);
        GridPane.setMargin(paneconn_label, new Insets(0, 0, 40, 0));
        paneconn.add(paneconn_label, 0, 0, 2, 1);

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
        paneconn.add(PageConnexion_error, 0, 3, 2, 1);

        Button paneconn_connect = new Button("Se Connecter");
        paneconn_connect.setStyle(root_style_dark);
        paneconn_connect.setOnAction(new ControlerVue(this));
        paneconn.add(paneconn_connect, 0, 4, 2, 1);

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
        paneinsc.add(paneinsc_label, 0, 0, 2, 1);

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
        paneinsc.add(PageConnexion_error, 0, 4, 2, 1);

        Button connecterButton = new Button("S'Inscrire");
        connecterButton.setStyle(root_style_dark);
        connecterButton.setOnAction(new ControlerVue(this));
        paneinsc.add(connecterButton, 0, 5, 2, 1);

        Region divrect = new Region();
        divrect.setPrefSize(200, 200);
        divrect.setStyle(root_style_dark + " -fx-background-radius: 10 10 0 10;");
        root.getChildren().addAll(paneconn, divrect, paneinsc);
    }

    private String color_format(Color c) {
        int r = (int) Math.round(c.getRed() * 255.0);
        int g = (int) Math.round(c.getGreen() * 255.0);
        int b = (int) Math.round(c.getBlue() * 255.0);
        int o = (int) Math.round(c.getOpacity() * 255.0);
        return String.format("#%02x%02x%02x%02x", r, g, b, o);
    }

    /**
     * start
     * 
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
        TitreLabel.setTextFill(Color.BLACK);

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

    /**
     * main
     * 
     * @param args args String[] temr launch args
     */
    public static void main(String[] args) {
        launch(args);
    }
}