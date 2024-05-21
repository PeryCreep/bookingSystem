/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krism.viewusers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.krism.project.DataBase;
import org.krism.project.User;

public class ViewUsersController implements Initializable {

    @FXML
    private TableColumn<User, String> c1;
    @FXML
    private TableColumn<User, String> c2;
    @FXML
    private TableColumn<User, String> c3;
    @FXML
    private TableView<User> table;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        c1.setCellValueFactory(new PropertyValueFactory("username"));
        c2.setCellValueFactory(new PropertyValueFactory("password"));
        c3.setCellValueFactory(new PropertyValueFactory("is_admin"));
        List<User> users = DataBase.getUsers();
        table.getItems().addAll(users);
    }    

   

    @FXML
    private void goToUsers(Event event) {
        new org.krism.adduser.AddUserController().goToUsers(event);
    }

    
}
