/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krism.users;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.krism.project.Paths;
import static org.krism.homepage.HomePageController.decorator1;

public class UsersController implements Initializable {

    @FXML
    private ImageView key_pic_Login_Btn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void NewUserAction(MouseEvent event) {
    }

    @FXML
    private void AddUser(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Paths.ADDUSERVIEW));
            decorator1.setContent(root);
            decorator1.setTitle("Добавление пользователя");
            root.requestFocus();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

    }

    @FXML
    private void DeleteUser(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Paths.DELETEUSERVIEW));

            decorator1.setContent(root);
            decorator1.setTitle("Удаление пользователя");

            root.requestFocus();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

    }

    @FXML
    private void ViewUsers(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Paths.VIEWUSERSVIEW));

            decorator1.setContent(root);
            decorator1.setTitle("View Users");

            root.requestFocus();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

}
