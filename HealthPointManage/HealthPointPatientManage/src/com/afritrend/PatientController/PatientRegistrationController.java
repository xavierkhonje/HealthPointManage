/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientController;

import com.afritrend.PatientDataAccess.Patient_DataAccess;
import com.afritrend.PatientModel.Patient_Model;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class PatientRegistrationController implements Initializable {

    @FXML
    TextField txtPatientName;
    
    @FXML
    ComboBox cbHospitalName;
    
    @FXML
    ComboBox cbWardName;
            
    @FXML
    ComboBox cbDptName;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbHospitalName.getItems().addAll("QECH","THYOLO","ZOMBA");
        cbWardName.getItems().addAll("4AWard","PEDIATRICS","3BWARD","1A");
        cbDptName.getItems().addAll("SURGICAL","MEDICAL");
    }    
    
    
    public void RegisterPatient(ActionEvent event)
    {
        String PatientName = txtPatientName.getText();
        
        String HospitalName = (String)cbHospitalName.getValue();
        
        String WardName = (String)cbWardName.getValue();
        
        String DptName = (String)cbDptName.getValue();
        
        Patient_DataAccess patdao = new Patient_DataAccess();
        
        Patient_Model patient = new Patient_Model();
        patient.setPatientName(PatientName);
        patient.setPatientID("000001");
        
        patdao.SavePatient(patient, DptName, WardName, WardName);
    }
    
}
