/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.Patient;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Xavier Khonje
 */
public class PatientCommon {
    
    public static void ShowPatientSearch()
    {
        try
        {
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UTILITY);
            stage.setTitle("Search Patient");

            VBox box = new VBox();
            
            Scene scene = new Scene(box);

            stage.setScene(scene);
            stage.showAndWait();
        }
        catch(Exception e)
        {
            
        }
        
    }
    
    public void RegisterPatient(Button NewPatientbtn)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/PatientController/PatientRegistration.fxml"));            
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UTILITY);
            stage.setTitle("Registration Patient");
            
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.showAndWait();            
        }
        catch(Exception e)
        {
            
        }
        
    }    
    
    public void EditPatient(String PatientID)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/PatientController/EditPatient.fxml"));            
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UTILITY);
            stage.setTitle("Registration Patient");
            
            Label lbl = new Label();
            lbl.setText(PatientID);
            VBox box =  new VBox();
            box.getChildren().add(lbl);
            
            Scene scene = new Scene(box);
            
            stage.setScene(scene);
            stage.showAndWait();            
        }
        catch(Exception e)
        {
            
        }        
    }      
    
    
    public void SelectPatient(Button SelectPatientbtn,String PatientID)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/PatientController/PatientMain.fxml"));                
            //Closing the old Scene
            Stage stage = (Stage)SelectPatientbtn.getScene().getWindow();    
            Scene Newscene = new Scene(root);
            stage.setTitle("Patient Registration System");
            stage.setScene(Newscene);
            stage.setMaximized(true);
        }
        catch(Exception e)
        {
            
        }
        
    }      
}
