/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krism.deleteuser;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.krism.project.DataBase;

public class DeleteUserController implements Initializable {

    @FXML
    private JFXTextField UserNameField;
    @FXML
    private JFXButton ButtonLogin;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void DeleteAction(ActionEvent event) {
        if ("".equals(UserNameField.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "", ButtonType.OK);
            alert.setHeaderText("Заполните все поля");
            alert.setTitle("Ошибка");
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/org/krism/img/WARNING_PNG.png"));
            alert.showAndWait();
            return;
        }
        if(UserNameField.getText().equals(org.krism.login.LoginController.user.getUsername())){
            Alert alert = new Alert(Alert.AlertType.WARNING, "", ButtonType.OK);
            alert.setHeaderText("Вы не можете удалить себя!");
            alert.setTitle("Ошибка");
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/org/krism/img/WARNING_PNG.png"));
            alert.showAndWait();
            return;
        }
        boolean DeleteUser = DataBase.DeleteUser(UserNameField.getText());
        if (DeleteUser) {
            UserNameField.setText("");
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "", ButtonType.OK);
            alert.setHeaderText("Пользователь удален");
            alert.setTitle("Информация");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.OK);
            alert.setHeaderText("Логин не валидный!");
            alert.setTitle("Ошибка");
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/org/krism/img/Error01.png"));
            alert.showAndWait();
        }

    }

    @FXML
    private void goToUsers(Event event) {
        new org.krism.adduser.AddUserController().goToUsers(event);
    }

}
