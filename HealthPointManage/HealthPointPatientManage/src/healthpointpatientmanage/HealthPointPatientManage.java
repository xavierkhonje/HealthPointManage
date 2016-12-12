/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthpointpatientmanage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Xavier Khonje
 */
public class HealthPointPatientManage extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("HealthPoint.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add(this.getClass().getResource("/Resources/login.css").toExternalForm());
        
//        scene.getStylesheets().add(this.getClass().getResource("login.css").toExternalForm());
        
        stage.setMaximized(true);
        stage.centerOnScreen();        
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
