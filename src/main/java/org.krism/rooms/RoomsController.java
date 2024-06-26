/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krism.rooms;

import com.jfoenix.controls.JFXButton;
import org.krism.hotel.Room;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.krism.project.DataBase;
import org.krism.project.User;

public class RoomsController implements Initializable {

    @FXML
    private Label backLabel;
    @FXML
    private JFXButton Logobtn;
    @FXML
    private Label usernameLabel;
    @FXML
    private Hyperlink logoutLink;
    @FXML
    private TableView<Room> tabel2;
    @FXML
    private TableColumn<Room, String> c1;
    @FXML
    private TableColumn<Room, String> c2;
    @FXML
    private TableColumn<Room, String> c3;
    @FXML
    private TableColumn<Room, String> c4;
    @FXML
    private TableColumn<Room, String> c5;
    @FXML
    private TableColumn<Room, String> c6;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        List<Room> Rooms = DataBase.getrooms();

        for (int i = 0; i < Rooms.size(); i++) {
            System.out.println("aa" + Rooms.get(i));
        }
        c1.setCellValueFactory(new PropertyValueFactory("roomID"));
        c2.setCellValueFactory(new PropertyValueFactory("room_Type"));
        c3.setCellValueFactory(new PropertyValueFactory("room_capacity"));
        c4.setCellValueFactory(new PropertyValueFactory("Check_In_Date"));
        c5.setCellValueFactory(new PropertyValueFactory("Check_Out_Date"));
        c6.setCellValueFactory(new PropertyValueFactory("isEmpty"));
        try {
            tabel2.getItems().addAll(Rooms);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    private void goTo_Rooms(ActionEvent event) {
        new org.krism.homepage.HomePageController().goTo_Rooms(event);    
    }

    @FXML
    private void goTo_guests(ActionEvent event) {
         new org.krism.homepage.HomePageController().goTo_Guests(event);
    }

}
