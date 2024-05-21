package org.krism.project;

import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXProgressBar;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LauncherSceneController implements Initializable {

    @FXML
    private JFXProgressBar progressbar;
    @FXML
    private ImageView BGLuncher;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
            goToLogin();
    }

    private void goToLogin() {
        try {
            //загрузка страницы логина
            Parent root = FXMLLoader.load(getClass().getResource(Paths.LOGINVIEW));
            Stage window = new Stage();
            JFXDecorator decorator = new JFXDecorator(window, root, false, false, true);
            String uri = getClass().getResource("/org/krism/style.css").toExternalForm();
            //Создание новой сцены и смена кадра на станицу логина
            Scene scene = new Scene(decorator);
            scene.getStylesheets().add(uri);
            window.setScene(scene);
            Image icon = new Image(getClass().getResourceAsStream("/org/krism/img/login_icon.png"));
            window.getIcons().add(icon);
            window.show();
            root.requestFocus();
            ((Stage) BGLuncher.getScene().getWindow()).close();
        } catch (IOException ex) {
            System.out.println("Error load loginFXML !");
        }
    }
}
