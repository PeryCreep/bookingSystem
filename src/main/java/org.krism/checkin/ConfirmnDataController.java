package org.krism.checkin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import org.krism.hotel.Reservation;
import org.krism.hotel.Room;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.krism.project.DataBase;

import static org.krism.utils.ConvertUtils.convertCapacity;
import static org.krism.utils.ConvertUtils.convertType;

/**
 * FXML Controller class
 *
 * @author UpToDate
 */
public class ConfirmnDataController implements Initializable {

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
    private JFXButton Save_Button;
    @FXML
    private JFXButton CancelButton;
    @FXML
    private Label Room_Type;
    @FXML
    private Label CheckOutLabel;
    @FXML
    private Label Room_Capacity;
    @FXML
    private JFXTextField roomIDField;
    @FXML
    private Label Number_of_Nights;
    @FXML
    private Label Night_Cost;

    @FXML
    private ImageView LogoImg;
    @FXML
    private Label emptyLabel;
    @FXML
    private Label CheckInLabel;
    @FXML
    private Label Total_fees;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Reservation reservation = CheckInController.reservation;

        NameField.setText(reservation.getGuest().getName());
        PhoneField.setText(reservation.getGuest().getPhoneNo());
        EmailField.setText(reservation.getGuest().getEmail());
        AddressField.setText(reservation.getGuest().getAddress());
        CityField.setText(reservation.getGuest().getCity());
        NationalityField.setText(reservation.getGuest().getNationality());
        PassportField.setText(reservation.getGuest().getPassportNumber());
        CardNumField.setText(reservation.getGuest().getCardNumber());
        CVCcodeField.setText(reservation.getGuest().getCardPass());
        Room_Type.setText(convertType(reservation.getRoom().getRoom_Type()));
        Room_Capacity.setText(convertCapacity(reservation.getRoom().getRoom_capacity()));
        roomIDField.setText(reservation.getGuest().getRoomID() + "");
        CheckOutLabel.setText(CheckInController.Date_TO_LocalDate(reservation.getRoom().getCheck_Out_Date()) + "");
        CheckInLabel.setText(CheckInController.Date_TO_LocalDate(reservation.getRoom().getCheck_In_Date()) + "");
        Number_of_Nights.setText(reservation.getGuest().getNumberOfDaysStayed() + "");
        Night_Cost.setText(reservation.getRoom().nightCost(reservation.getRoom()) + "");
        Total_fees.setText(reservation.getGuest().getFees()+ "");

    }

    @FXML
    private void SaveButtonAction(ActionEvent event) {
        Reservation reservation = CheckInController.reservation;

        Room.CheckIn(reservation.getGuest(), reservation.getRoom(), 
                reservation.getGuest().getRoomID());

        new org.krism.homepage.HomePageController().goTO_check_in(event);
        ((Stage) NameField.getScene().getWindow()).close();
    }

    @FXML
    private void CancelAction(ActionEvent event) {
        ((Stage) NameField.getScene().getWindow()).close();
    }   

}
