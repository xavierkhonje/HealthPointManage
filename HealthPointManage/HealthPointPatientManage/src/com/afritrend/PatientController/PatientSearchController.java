/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientController;

import com.afritrend.Patient.PatientCommon;
import com.afritrend.PatientDataAccess.Patient_DataAccess;
import com.afritrend.PatientModel.Patient_Model;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class PatientSearchController implements Initializable {

    @FXML
    TableView<Patient_Model> patient;
    
    @FXML
    Label lblfirstname;
    
    @FXML
    Label lblmiddlename;
    
    @FXML
    Label lbllastname;
    
    @FXML
    Label lblpatientid;
    
    @FXML
    ImageView PatientProfile;
    
    @FXML
    Button SelectPatientbtn;
    
    @FXML
    Button NewPatientbtn;
    
    
    public static String Patient_ID;
    
    public static String Patient_ID2;// = "ID2";
    /**
     * Initializes the controller class.
     */
    
    @FXML
    private void RegisterPatient(ActionEvent event)
    {
        PatientCommon patcommon = new PatientCommon();
        patcommon.RegisterPatient(NewPatientbtn);
    }
    
    @FXML
    private void SearchPatient(ActionEvent event)
    {
        
        ObservableList<Patient_Model> Patients = FXCollections.observableArrayList();  
        
        TableColumn<Patient_Model, String> IDColumn = new TableColumn<>("Patient ID");
        IDColumn.setMinWidth (200);    
        IDColumn.setCellValueFactory(new PropertyValueFactory<>("patientID"));  
                
        TableColumn<Patient_Model, String> NameColumn = new TableColumn<>("Patient Name");
        NameColumn.setMinWidth (200);    
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("patientName"));             
        
        Patient_DataAccess patientdao = new Patient_DataAccess();
        List<Patient_Model> patientlist = patientdao.ViewPatient();
        
        Iterator<Patient_Model> patit = patientlist.iterator();
        while(patit.hasNext())
        {
            Patient_Model patient = new Patient_Model();
            patient = patit.next();
            Patients.add(new Patient_Model(patient.getPatientID(),patient.getPatientName()));
        }
                
        patient.setItems(Patients);
        patient.getColumns().addAll(IDColumn,NameColumn);
    }    
    
    public void EditPatient(ActionEvent event)
    {
        ObservableList<Patient_Model> PatientSelected, AllPatients;
//        AllPatients = patient.getItems();
        PatientSelected = patient.getSelectionModel().getSelectedItems();
        
        String PatientID = lblpatientid.getText();  
        if(PatientID.equals(""))
        {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Select Patient, Show Details First");

            alert.showAndWait();               
        }
        else
        {
            Patient_Model pat = new Patient_Model();
            pat = PatientSelected.get(0);
        
            Patient_ID = pat.getPatientID();
            
            PatientCommon patcommon = new PatientCommon();
            patcommon.EditPatient(Patient_ID);
        }        
        

             
    }
    
    public void ViewDetailsPatient(ActionEvent event)
    {
        ObservableList<Patient_Model> PatientSelected, AllPatients;
//        AllPatients = patient.getItems();
        PatientSelected = patient.getSelectionModel().getSelectedItems();
        
        Patient_Model pat = new Patient_Model();
        pat = PatientSelected.get(0);
        
        lblfirstname.setText(pat.getPatientName());
        lblmiddlename.setText(pat.getPatientName());
        lbllastname.setText(pat.getPatientName());
        lblpatientid.setText(pat.getPatientID());         
    }    
    
    public void SelectPatient(ActionEvent event)
    {
        ObservableList<Patient_Model> PatientSelected, AllPatients;
//        AllPatients = patient.getItems();
        PatientSelected = patient.getSelectionModel().getSelectedItems();             
        
        String PatientID = lblpatientid.getText();  
        Patient_ID2 = PatientID;
        if(PatientID.equals(""))
        {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Select Patient, Show Details First");

            alert.showAndWait();               
        }
        else
        {
            //Close the Search Screen and move to the Main Screen
            PatientCommon common = new PatientCommon();
            common.SelectPatient(SelectPatientbtn,PatientID);
        }
        
        Patient_Model pat = new Patient_Model();
        pat = PatientSelected.get(0);
                
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO        
    }    
    
}
