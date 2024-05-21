package org.krism.homepage;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDecorator;
import org.krism.hotel.Room;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import static org.krism.login.LoginController.decorator;
import static org.krism.login.LoginController.window;
import org.krism.project.DataBase;
import org.krism.project.Paths;
import org.krism.project.switchScreen;

/**
 * FXML Controller class
 *
 * @author UpToDate
 */
public class HomePageController implements Initializable {

    @FXML
    private JFXButton check_in_Buttton;
    @FXML
    private JFXButton check_out_Buttton;
    @FXML
    private JFXButton room_booking_Buttton;
    @FXML
    private JFXButton cancel_booking_Buttton;
    @FXML
    private Label usernameLabel11;
    @FXML
    private Label usernameLabel1;
    @FXML
    private Label usernameLabel111;
    @FXML
    private Label rank_Label;
    @FXML
    private JFXButton roomBTN;
    @FXML
    private JFXButton guestsBTN;

    public static JFXDecorator  decorator1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usernameLabel1.setText(org.krism.login.LoginController.user.getUsername());

        if (org.krism.login.LoginController.user.isIs_admin() == true) {
            rank_Label.setText("Админ");
        } else {
            rank_Label.setText("Работник");
        }
    }

    @FXML
    public void logout(Event event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Paths.LOGINVIEW));
            Stage window2 = new Stage();
            JFXDecorator decorator = new JFXDecorator(window2, root, false, false, true);
            Scene scene = new Scene(decorator);
            String uri = getClass().getResource("/org/krism/style.css").toExternalForm();
            scene.getStylesheets().add(uri);
            int width = 690, height = 620;
            window2.setScene(scene);
            window2.setMaxHeight(height);
            window2.setMinHeight(height);
            window2.setMaxWidth(width);
            window2.setMinWidth(width);
            Image icon = new Image(getClass().getResourceAsStream("/org/krism/img/login_icon.png"));
            window2.getIcons().add(icon);
            window2.show();
            root.requestFocus();
            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

        } catch (Exception ex) {
            System.out.println("Ошибка!");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    @FXML
    public void goTO_check_in(Event event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Paths.CHECKINVIEW));
            window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Заселение");
            decorator.setContent(root);
            decorator.setTitle("Заселение");
            root.requestFocus();
        } catch (Exception ex) {
            System.out.println("Ошибка!");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    @FXML
    public void goTo_room_booking(Event event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Paths.ROOMBOOKINGVIEW));
            window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Бронирование");
            decorator.setContent(root);
            decorator.setTitle("Бронирование");
            root.requestFocus();
        } catch (Exception ex) {
            System.out.println("Ошибка!");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    @FXML
    public void goTo_cancel_booking(Event event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Paths.CANCELBOOKINGVIEW));
            window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Отмена бронирования");
            decorator.setContent(root);
            decorator.setTitle("Отмена бронирования");
            root.requestFocus();
        } catch (Exception ex) {
            System.out.println("Ошибка!");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    @FXML
    public void goTo_Check_out(Event event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Paths.CHECKOUTVIEW));
            window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Выселение");
            decorator.setContent(root);
            decorator.setTitle("Выселение");
            root.requestFocus();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    @FXML
    public void goTo_Users(Event event) {
        if (org.krism.login.LoginController.user.isIs_admin()) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(Paths.USERSVIEW));
                Stage window2 = new Stage();
                decorator1 = new JFXDecorator(window2, root, false, false, true);
                Scene scene = new Scene(decorator1);
                String uri = getClass().getResource("/org/krism/style.css").toExternalForm();
                scene.getStylesheets().add(uri);
                int width = 690, height = 620;
                window2.setScene(scene);
                window2.setMaxHeight(height);
                window2.setMinHeight(height);
                window2.setMaxWidth(width);
                window2.setMinWidth(width);
                Image icon = new Image(getClass().getResourceAsStream("/org/krism/img/login_icon.png"));
                window2.getIcons().add(icon);
                window2.show();
                root.requestFocus();
            } catch (Exception ex) {
                System.out.println("Ошибка!");
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.OK);
            alert.setHeaderText("Только админ может редактировать!");
            alert.setTitle("Ошибка");
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/org/krism/img/Error01.png"));
            alert.showAndWait();
        }
    }

    @FXML
    public void goTo_Rooms(Event event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Paths.ROOMSVIEW));
            window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Комнаты");
            decorator.setContent(root);
            decorator.setTitle("Комнаты");
            root.requestFocus();
        } catch (Exception ex) {
            System.out.println("Ошибка!");
            switchScreen.Load_Error_Alert("Комнаты",ex.getMessage());
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    @FXML
    public void goTo_Guests(Event event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Paths.GUESTSVIEW));
            window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Гости");
            decorator.setContent(root);
            decorator.setTitle("Гости");
            root.requestFocus();
        } catch (Exception ex) {
            System.out.println("Ошибка!");
            switchScreen.Load_Error_Alert("Гости",ex.getMessage());
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        
    }
}
