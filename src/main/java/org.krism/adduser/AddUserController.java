package org.krism.adduser;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import static org.krism.homepage.HomePageController.decorator1;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.krism.project.DataBase;
import org.krism.project.Paths;
import org.krism.project.User;

/**
 * Класс обработки добавления пользователя
 *
 * @author UpToDate
 */
public class AddUserController implements Initializable {

    @FXML
    private JFXTextField UserNameField;
    @FXML
    private JFXPasswordField PasswordField;
    @FXML
    private JFXButton ButtonLogin;
    @FXML
    private ImageView key_pic_Login_Btn;
    @FXML
    private JFXToggleButton isAdminButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void NewUserAction(Event event) {
        if ("".equals(UserNameField.getText()) || "".equals(PasswordField.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "", ButtonType.OK);
            alert.setHeaderText("Fill all fields ...");
            alert.setTitle("Error");
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/org/krism/img/Error01.png"));
            alert.showAndWait();
            return;
        }

        try {
            boolean AdminStatus = isAdminButton.isSelected();
            User user = new User(UserNameField.getText(), PasswordField.getText(), AdminStatus);
            boolean SaveUser = DataBase.SaveUser(user);
            if (!SaveUser) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.OK);
                alert.setHeaderText("That username is taken. Try another.");
                alert.setTitle("Error");
                ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/org/krism/img/Error01.png"));
                alert.showAndWait();
                return;
            }
            PasswordField.setText("");
            UserNameField.setText("");
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "", ButtonType.OK);
            alert.setHeaderText("User added successfully");
            alert.setTitle("Notification");
            alert.showAndWait();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    @FXML
    private void isAdminButtonAction(ActionEvent event) {
        if (isAdminButton.isSelected()) {
            isAdminButton.setText("Админ");
        } else {
            isAdminButton.setText("Работник");
        }
    }

    @FXML
    public void goToUsers(Event event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Paths.USERSVIEW));
            decorator1.setContent(root);
            decorator1.setTitle("Пользователи");
            root.requestFocus();
        } catch (Exception ex) {
            System.out.println("Ошибка!");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
