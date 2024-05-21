/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krism.checkout;

import com.jfoenix.controls.JFXButton;
import org.krism.hotel.Room;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author UpToDate
 */
public class CheckOutController implements Initializable {

    @FXML
    private JFXButton Logobtn;
    @FXML
    private Label usernameLabel;
    @FXML
    private Hyperlink logoutLink;
    @FXML
    private TextField roomNoField;
    @FXML
    private JFXButton CheckOutBTN;
    @FXML
    private JFXButton clearbtn;
    @FXML
    private JFXButton checkinBTN1;
    @FXML
    private JFXButton roombookingBTN1;
    @FXML
    private JFXButton cancelbookingBTN1;
    @FXML
    private JFXButton roomBTN;
    @FXML
    private JFXButton guestsBTN;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usernameLabel.setText(org.krism.login.LoginController.user.getUsername());
    }

    @FXML
    private void logout(Event event) {
        new org.krism.homepage.HomePageController().logout(event);
    }

    @FXML
    public void goToHomePage(Event event) {
        new org.krism.checkin.CheckInController().goToHomePage(event);
    }

    @FXML
    private void goTO_check_in(ActionEvent event) {
        new org.krism.homepage.HomePageController().goTO_check_in(event);
    }

    @FXML
    private void goTo_room_booking(ActionEvent event) {
        new org.krism.homepage.HomePageController().goTo_room_booking(event);
    }

    @FXML
    private void goTo_cancel_booking(ActionEvent event) {
        new org.krism.homepage.HomePageController().goTo_cancel_booking(event);
    }

    @FXML
    private void goTO_check_out(Event event) {
        new org.krism.homepage.HomePageController().goTo_Check_out(event);
    }

    @FXML
    public void checkoutAction(ActionEvent event) {
        if ("".equals(roomNoField.getText())) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.OK);
            alert.setContentText("Заполните все поля!");
            alert.setHeaderText("Заполните все поля!");
            alert.setTitle("Ошибка");
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/org/krism/img/Error01.png"));
            alert.showAndWait();
        } else {

            int flag = -1;
            try {
                flag = Room.CheckOut(Integer.parseInt(roomNoField.getText()));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                Alert alert = new Alert(Alert.AlertType.ERROR, null, ButtonType.OK);
                alert.setHeaderText("Номер комнаты не валидный!");
                alert.setContentText(e.getMessage());
                alert.setTitle("Ошибка");
                alert.show();
                return;
            }
            switch (flag) {
                case 1: {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, null, ButtonType.OK);
                    alert.setHeaderText("Выселение завершено ");
                    alert.setTitle("Информация");
                    alert.show();
                    new org.krism.homepage.HomePageController().goTo_Check_out(event);
                    break;
                }
                case 0: {
                    Alert alert = new Alert(Alert.AlertType.WARNING, null, ButtonType.OK);
                    alert.setHeaderText("Команата уже пуста!");
                    alert.setTitle("Информация");
                    alert.show();
                    break;
                }
                default: {
                    Alert alert = new Alert(Alert.AlertType.ERROR, null, ButtonType.OK);
                    alert.setHeaderText("Номер комнаты не валидный ...");
                    alert.setContentText("Ошибка, комната: " + roomNoField.getText() + " не валидная!");
                    alert.setTitle("Ошибка");
                    alert.show();
                    break;
                }
            }
        }
    }

    @FXML
    private void clearAction(ActionEvent event) {
        roomNoField.setText("");
    }

    @FXML
    private void goto_Rooms(ActionEvent event) {
        new org.krism.homepage.HomePageController().goTo_Rooms(event);
    }

    @FXML
    private void goTo_guests(ActionEvent event) {
        new org.krism.homepage.HomePageController().goTo_Guests(event);
    }
}
