package org.krism.project;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class switchScreen {

    public void popUp(Event event, String path, int width, int height, String title, String imgPath) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setAlwaysOnTop(true);
        stage.setScene(new Scene(root));
        stage.setTitle(title);
        stage.setMinHeight(height);
        stage.setMaxHeight(height);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setMinWidth(width);
        stage.setMaxWidth(width);
        Image icon = new Image(getClass().getResourceAsStream(imgPath));
        stage.getIcons().add(icon);
        stage.show();
    }

    public static void Load_Error_Alert(String Window_Name, String Content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText("при загрузке окна - " + Window_Name);
        alert.setContentText(Content);
        alert.showAndWait();
    }

}
