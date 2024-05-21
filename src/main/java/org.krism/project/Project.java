package org.krism.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * Точка входа в приложение
 */
public class Project extends Application {

    @Override
    public void start(Stage stage) {
        try {
            // Запуск launcherScene из папки ресурсы
            Parent root = FXMLLoader.load(getClass().getResource(Paths.LAUNCHERVIEW));
            // Создание сцены для отображение картинки
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.UNDECORATED);
            
                
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            System.out.println("Ошибка запуска");
        }
    }
    public static void main(String[] args) {
        //Запуск приложения
        launch(args);
    }

}
