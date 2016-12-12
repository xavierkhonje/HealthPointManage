/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientController;

import static com.afritrend.PatientController.PatientSearchController.Patient_ID;
import com.afritrend.PatientDataAccess.DemographicsDataAccess;
import com.afritrend.PatientModel.Patient_Model;
import com.afritrend.PatientModel.demographicsModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class DemographicsController implements Initializable {

    @FXML
    ComboBox CultureResults;
    
    @FXML
    ComboBox CultureAssessment;
    
    @FXML
    ComboBox Gender;
    
    @FXML
    TextField Weight;
    
    @FXML
    TextField Age;
    
    @FXML
    DatePicker DateofBirth;
    
    @FXML
    DatePicker DateOfAdmission;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        Gender.setItems("Male","Female");
        Gender.getItems().addAll("MALE","FEMALE");
        CultureResults.getItems().addAll("YES","NO","RESULTS PEDING");
        CultureAssessment.getItems().addAll("SENT BEFORE ANTIBIOTIC","SENT BEFORE ANTIBIOTIC","NOT SENT");
    }    
    
    
    public void SaveDemographics(ActionEvent event)
    {
        String CultureAssess = (String)CultureResults.getValue();
        
        String CultureResult = (String)CultureResults.getValue();
        
        String PatientGender = (String)Gender.getValue();
        
        int PatientWeight = Integer.valueOf(Weight.getText());
        
        int PatientAge = Integer.valueOf(Age.getText());
        
        String DOB = String.valueOf(DateofBirth.getValue());
        
        String DOA = String.valueOf(DateOfAdmission.getValue());       
        //Validate the Details
        
        DemographicsDataAccess Demographicsdao = new DemographicsDataAccess();        
        demographicsModel demographics = new demographicsModel();
        
        demographics.setCultureAssessment(CultureAssess);
        demographics.setCultureResults(CultureResult);
        demographics.setGender(PatientGender);
        demographics.setWeight(PatientWeight);
        demographics.setAge(PatientAge);
        demographics.setDateofbirth(DOB);
        demographics.setDateOfAdmission(DOA);
        
        String PatID = PatientSearchController.Patient_ID2;
        
        Demographicsdao.Savedemographics(demographics, PatID);
        
        
    }
    
    public void UpdateDemographics(ActionEvent event)
    {
        
    }    
    
    public void ViewDemographics(ActionEvent event)
    {
        
    }    
    
}
