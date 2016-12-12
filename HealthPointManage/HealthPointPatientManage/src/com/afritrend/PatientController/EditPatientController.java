/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class EditPatientController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TextField txtPatientID;
    
    @FXML
    Label lblid;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        PatientSearchController patsearchctrl = new PatientSearchController();
        String PatientID = patsearchctrl.Patient_ID;
        
        lblid.setText(PatientID);
        
        txtPatientID.setText(PatientID);
        txtPatientID.disableProperty();
        
        
    }    
    
}
