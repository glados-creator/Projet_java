package olympic.graphic.GUI_admin;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.layout.VBox;

public class GUI_admin extends Application {

    public static void main(String[] args) {
        Application.launch();
    }
    
    @Override
    public void init() {

    }

    public void quitte() {
        Platform.exit();
    }

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        Scene scene = new Scene(root);
        stage.setTitle("Jeux olympique");
        stage.setScene(scene);
        stage.show();
    }

}
