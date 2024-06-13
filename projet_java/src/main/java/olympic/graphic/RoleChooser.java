package olympic.graphic;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.layout.VBox;

/** class RoleChooser extends Application
 * petite fenetre pour choisir son role d'utilisateur
 */
public class RoleChooser extends Application {

    /**
     * main launch
     * @param args String term args
     */
    public static void main(String[] args) {
        Application.launch();
    }
    /** void init() */
    @Override
    public void init() {

    }
    /** void quitte() */
    public void quitte() {
        Platform.exit();
    }
    /**
     * start
     * @param stage Stage la fenetre
    */
    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        Scene scene = new Scene(root);
        stage.setTitle("Jeux olympique");
        stage.setScene(scene);
        stage.show();
    }

}