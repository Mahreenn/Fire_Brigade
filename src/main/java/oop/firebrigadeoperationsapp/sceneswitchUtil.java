package oop.firebrigadeoperationsapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class sceneswitchUtil {
    public  static <E> E switchscene(ActionEvent event, String fxmlFile, String stageName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)(((Node) event.getSource()).getScene().getWindow());
        stage.setScene(scene);
        stage.setTitle(stageName);

        return fxmlLoader.getController();
    }

}
