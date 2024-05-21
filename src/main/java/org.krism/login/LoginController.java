package org.krism.login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.krism.project.DataBase;
import org.krism.project.Paths;
import org.krism.project.User;
import org.krism.project.switchScreen;

public class LoginController implements Initializable {

    //=======================
    public static Stage window;
    public static JFXDecorator decorator;
    public static User user;
    //=======================
    @FXML
    private JFXButton ButtonLogin;
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private JFXTextField UserNameField;
    @FXML
    private JFXPasswordField PasswordField;
    @FXML
    private ImageView key_pic_Login_Btn;
    //=======================

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void loginAction(Event event) {
        try {
            DataBase.CheckConnection();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Ошибка подключения");
            alert.setContentText("Ошибка подключения к базе данных ..");
            alert.show();
            return;
        }

        user = new User(UserNameField.getText(), PasswordField.getText(), false);
        boolean userIsAdmin = User.isUserAdmin(user);
        user.setIs_admin(userIsAdmin);

        try {
            if (User.isUserValid(user)) {
                goToHomePage(event);
            } else {
                try {
                    new switchScreen().popUp(event, "org/krism/login/ErrorPopUp.fxml", 370, 250, "", "/org/krism/img/Error01.png");
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Ошибка подключения");
            alert.setContentText("Ошибка подключения к базе данных ..");
            alert.show();
            return;
        }

    }

    public void goToHomePage(Event event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Paths.HOMEPAGEVIEW));
            window = new Stage();
            window.setAlwaysOnTop(false);
            decorator = new JFXDecorator(window, root, true, false, true);
            int width = 1400, height = 1300;
            Scene scene = new Scene(decorator, width, height);
            decorator.setTitle("Система бронирования отеля");
            String uri = getClass().getResource("/org/krism/style.css").toExternalForm();
            scene.getStylesheets().add(uri);
            window.setScene(scene);
            window.setMaxHeight(height);
            window.setMinHeight(height);
            window.setMaxWidth(width);
            window.setMinWidth(width);
            window.setTitle("Отель");
            window.show();
            root.requestFocus();
            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
        } catch (IOException ex) {
            System.out.println("Ошибка!");
            System.out.println(ex);

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

}
