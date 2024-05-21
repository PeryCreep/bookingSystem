package org.krism.roombooking;

import org.krism.checkin.CheckInController;
import static org.krism.checkin.CheckInController.getDifferenceDays;
import static org.krism.checkin.CheckInController.reservation;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import org.krism.hotel.Guest;
import org.krism.hotel.Reservation;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class RoomBookingController implements Initializable {

    @FXML
    private Label backLabel;
    @FXML
    private JFXButton Logobtn;
    @FXML
    private Label usernameLabel;
    @FXML
    private Hyperlink logoutLink;
    @FXML
    private TextField NameField;
    @FXML
    private TextField PhoneField;
    @FXML
    private TextField EmailField;
    @FXML
    private TextField CityField;
    @FXML
    private TextField NationalityField;
    @FXML
    private TextField PassportField;
    @FXML
    private TextArea AddressField;
    @FXML
    private TextField CardNumField;
    @FXML
    private TextField CVCcodeField;
    @FXML
    private JFXButton submitButton;
    @FXML
    private JFXButton clearButton;
    @FXML
    private RadioButton economyType;
    @FXML
    private ToggleGroup roomtype;
    @FXML
    private RadioButton normalType;
    @FXML
    private RadioButton vipType;
    @FXML
    private RadioButton singleCapacity;
    @FXML
    private ToggleGroup roomCapacity;
    @FXML
    private RadioButton doubleCapacity;
    @FXML
    private RadioButton tripleCapacity;
    @FXML
    private JFXDatePicker CheckInDatePicker;
    @FXML
    private JFXDatePicker CheckoutDatePicker;
    @FXML
    private JFXButton searchRoomButtton;
    @FXML
    private JFXTextField roomIDField;

    CheckInController c = new CheckInController();
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
    private void goTO_check_in(Event event) {
        new org.krism.homepage.HomePageController().goTO_check_in(event);
    }

    @FXML
    private void goTo_room_booking(Event event) {
        new org.krism.homepage.HomePageController().goTo_room_booking(event);
    }

    @FXML
    private void goTo_cancel_booking(Event event) {
        new org.krism.homepage.HomePageController().goTo_cancel_booking(event);
    }

    @FXML
    private void goTO_check_out(Event event) {
        new org.krism.homepage.HomePageController().goTo_Check_out(event);
    }

    public boolean isFieldsEmpty() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
        if ("".equals(NameField.getText()) || "".equals(PhoneField.getText())
                || ("".equals(EmailField.getText())) || ("".equals(AddressField.getText()))
                || ("".equals(CityField.getText())) || ("".equals(NationalityField.getText()))
                || ("".equals(PassportField.getText())) || ("".equals(CardNumField.getText()))
                || ("".equals(CVCcodeField.getText())) || ("".equals(roomIDField.getText()))) {

            return true;
        } else {

            return false;
        }
    }

    public String getRoomTypeValue() {
        String RoomType = null;
        if (economyType.isSelected()) {
            RoomType = "Economy";
        } else if (normalType.isSelected()) {
            RoomType = "Normal";
        } else if (vipType.isSelected()) {
            RoomType = "Vip";
        }
        return RoomType;
    }

    public String getRoomCapacityValue() {
        String RoomCapacity = null;
        if (singleCapacity.isSelected()) {
            RoomCapacity = "Single";
        } else if (doubleCapacity.isSelected()) {
            RoomCapacity = "Double";
        } else if (tripleCapacity.isSelected()) {
            RoomCapacity = "Triple";
        }
        return RoomCapacity;
    }

    @FXML
    private void submitAction(ActionEvent event) {
        try {

            if (!isFieldsEmpty()) {
                if (getDifferenceDays(c.LocalDate_TO_Date(CheckInDatePicker.getValue()),
                        c.LocalDate_TO_Date(CheckoutDatePicker.getValue())) < 0) {
                    return;
                }
                Room room = new Room(getRoomTypeValue(), getRoomCapacityValue(),
                        c.LocalDate_TO_Date(CheckInDatePicker.getValue()),
                        c.LocalDate_TO_Date(CheckoutDatePicker.getValue()), false);

                Guest guest = new Guest(Integer.parseInt(roomIDField.getText()),
                        getDifferenceDays(c.LocalDate_TO_Date(CheckInDatePicker.getValue()),
                                c.LocalDate_TO_Date(CheckoutDatePicker.getValue())),
                        NameField.getText(), EmailField.getText(),
                        AddressField.getText(), CityField.getText(), NationalityField.getText(),
                        PassportField.getText(), PhoneField.getText(), CardNumField.getText(),
                        CVCcodeField.getText(), 0);
                guest.setFees(guest.CustomerRoomFees(room));
                reservation = new Reservation(room, guest);
                new org.krism.project.switchScreen().popUp(event, "/org/krism/RoomConfirmnData.fxml", 1014, 1010, "Confirmation Data", "/org/krism/img/icon.jpg");
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.OK);
                alert.setContentText("Заполните все поля!");
                alert.setHeaderText("Заполните все поля!");
                alert.setTitle("Ошибка");
                ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/org/krism/img/Error01.png"));
                alert.showAndWait();

            }

        } catch (Exception e) {
            System.out.println(e);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Заполните все поля!");
            alert.setHeaderText("Заполните все поля!");
            alert.setTitle("Ошибка!");
            alert.showAndWait();
        }

    }

    @FXML
    private void searchRoom(ActionEvent event) {

        try {
            if (!isFieldsEmpty()) {
                if (getDifferenceDays(c.LocalDate_TO_Date(CheckInDatePicker.getValue()),
                        c.LocalDate_TO_Date(CheckoutDatePicker.getValue())) < 0) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.OK);
                    alert.setContentText("Не валидная дата заселения и выселения!");
                    alert.setHeaderText("Выберите корректые даты!");
                    alert.setTitle("Ошибка");
                    ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/org/krism/img/Error01.png"));
                    alert.showAndWait();
                    return;
                }
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Заполните все поля!");
            alert.setHeaderText("Заполните все поля!");
            alert.setTitle("Ошибка!");
            alert.showAndWait();
        }

        Room room = Room.Search_available_rooms(getRoomTypeValue(), getRoomCapacityValue());
        if (room == null) {
            roomIDField.setText("Комнат не найдено!");
        } else {
            roomIDField.setText(room.getRoomID() + "");
        }
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
