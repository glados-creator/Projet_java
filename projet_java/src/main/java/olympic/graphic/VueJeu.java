package olympic.graphic;

import javafx.application.Application;
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

public class VueJeu extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the menu bar and menus
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        Menu helpMenu = new Menu("Help");

        // Add menu items to File menu
        fileMenu.getItems().addAll(
                new MenuItem("New"),
                new MenuItem("Open…"),
                new Menu("Open Recent"),
                new SeparatorMenuItem(),
                new MenuItem("Close"),
                new MenuItem("Save"),
                new MenuItem("Save As…"),
                new MenuItem("Revert"),
                new SeparatorMenuItem(),
                new MenuItem("Preferences…"),
                new SeparatorMenuItem(),
                new MenuItem("Quit")
        );

        // Add menu items to Edit menu
        editMenu.getItems().addAll(
                new MenuItem("Undo"),
                new MenuItem("Redo"),
                new SeparatorMenuItem(),
                new MenuItem("Cut"),
                new MenuItem("Copy"),
                new MenuItem("Paste"),
                new MenuItem("Delete"),
                new SeparatorMenuItem(),
                new MenuItem("Select All"),
                new MenuItem("Unselect All")
        );

        // Add menu items to Help menu
        helpMenu.getItems().addAll(
                new MenuItem("About MyHelloApp")
        );

        // Add menus to menu bar
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);

        // Create the main layout
        VBox mainLayout = new VBox();
        mainLayout.setPrefSize(640, 400);

        // Add the menu bar to the layout
        mainLayout.getChildren().add(menuBar);

        // Create the BorderPane for the content
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(640, 373);

        // Create the top label
        Label topLabel = new Label("Jeux IUT'Olympique");
        topLabel.setFont(new Font(24));
        topLabel.setStyle("");
        topLabel.setAlignment(javafx.geometry.Pos.CENTER);
        borderPane.setTop(topLabel);

        // Create the center VBox
        VBox centerVBox = new VBox();
        centerVBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        centerVBox.setPrefSize(444, 241);

        // Create the main label
        Label mainLabel = new Label("Label");
        mainLabel.setFont(new Font(18));
        mainLabel.setPadding(new Insets(50, 0, 0, 0));
        centerVBox.getChildren().add(mainLabel);

        // Create the buttons
        Button administrateurButton = new Button("Administrateur");
        administrateurButton.setPadding(new Insets(15, 0, 15, 0));
        administrateurButton.setOnAction(e -> handleAdministrateurButton(mainLabel));
        centerVBox.getChildren().add(administrateurButton);

        Button organisateurButton = new Button("Organisateur");
        organisateurButton.setPadding(new Insets(15, 0, 15, 0));
        organisateurButton.setOnAction(e -> handleOrganisateurButton(mainLabel));
        centerVBox.getChildren().add(organisateurButton);

        Button visiteurButton = new Button("Visiteur");
        visiteurButton.setPadding(new Insets(15, 0, 15, 0));
        visiteurButton.setOnAction(e -> handleVisiteurButton(mainLabel));
        centerVBox.getChildren().add(visiteurButton);

        borderPane.setCenter(centerVBox);
        borderPane.setPadding(new Insets(15, 0, 5, 0));

        // Add the BorderPane to the AnchorPane
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().add(borderPane);

        // Add the AnchorPane to the main layout
        mainLayout.getChildren().add(anchorPane);

        // Create the scene and add the main layout
        Scene scene = new Scene(mainLayout);

        // Configure the stage
        primaryStage.setTitle("Jeux IUT'Olympique");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleAdministrateurButton(Label mainLabel) {
        mainLabel.setText("Administrateur bouton cliqué");
    }

    private void handleOrganisateurButton(Label mainLabel) {
        mainLabel.setText("Organisateur bouton cliqué");
    }

    private void handleVisiteurButton(Label mainLabel) {
        mainLabel.setText("Visiteur bouton cliqué");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
