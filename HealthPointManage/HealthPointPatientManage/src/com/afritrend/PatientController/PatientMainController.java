/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientController;

import com.afritrend.PatientDataAccess.AllergyDataAccess;
import com.afritrend.PatientDataAccess.CormobiditiesDataAccess;
import com.afritrend.PatientDataAccess.DiagnosisDataAccess;
import com.afritrend.PatientDataAccess.Patient_Has_ComorbiditiesDataAccess;
import com.afritrend.PatientDataAccess.SourceDataAccess;
import com.afritrend.PatientModel.AllergiesModel;
import com.afritrend.PatientModel.CormobiditiesModel;
import com.afritrend.PatientModel.DiagnosisModel;
import com.afritrend.PatientModel.Patient_has_comorbiditiesModel;
import com.afritrend.PatientModel.sourceModel;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Xavier Khonje
 */
public class PatientMainController implements Initializable {

    @FXML
    BorderPane MainBorderPane;
    
    @FXML
    MenuItem MnuLogout;
    
    @FXML
    ComboBox cbAllergies;
    
    @FXML
    ComboBox cbSource;
    
    @FXML
    ComboBox cbDiagnosis;
    
    @FXML
    ComboBox cbCormobidity;
    
    public String PatientID;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        PatientID = PatientSearchController.Patient_ID2;
        
        List<AllergiesModel> allergylist = new ArrayList();
        
        AllergyDataAccess allergydao = new AllergyDataAccess();
        allergylist = allergydao.ViewAllergy();
        
        cbAllergies.setPromptText("Choose Allergy");
        Iterator<AllergiesModel> allergyit = allergylist.iterator();
        while(allergyit.hasNext())
        {
            AllergiesModel allergies = new AllergiesModel();
            allergies = allergyit.next();
            cbAllergies.getItems().add(allergies.getCode());
        }
        
        //Source
        List<sourceModel> sourcelist = new ArrayList();
        SourceDataAccess sourcedao = new SourceDataAccess();
        sourcelist = sourcedao.ViewSource();
        
        cbSource.setPromptText("Choose Source");
        Iterator<sourceModel> sourceit = sourcelist.iterator();
        while(sourceit.hasNext())
        {
            sourceModel source = new sourceModel();
            source = sourceit.next();
            cbSource.getItems().add(source.getCode());
        }
        
        //Diagnosis
        DiagnosisDataAccess diagnosisdao = new DiagnosisDataAccess();
        List<DiagnosisModel> diagnosislist = new ArrayList();
        
        diagnosislist = diagnosisdao.ViewDiagnosis();
        Iterator<DiagnosisModel> diagit = diagnosislist.iterator();
        while(diagit.hasNext())
        {
            DiagnosisModel diagnosis = new DiagnosisModel();
            diagnosis = diagit.next();
            cbDiagnosis.getItems().add(diagnosis.getCode());
        }
        
        //Cormobidity
        CormobiditiesDataAccess cormodao = new CormobiditiesDataAccess();
        List<CormobiditiesModel> cormolist = new ArrayList();
        
        cormolist = cormodao.ViewCormobidities();
        Iterator<CormobiditiesModel> cormoit = cormolist.iterator();
        
        while(cormoit.hasNext())
        {
            CormobiditiesModel cormobidity = new CormobiditiesModel();
            cormobidity = cormoit.next();
            cbCormobidity.getItems().add(cormobidity.getCode());
        }
        
    }    
    
    public void ShowDemographics(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/PatientController/Demographics.fxml"));
            MainBorderPane.setCenter(root);
            System.out.println("Demographics comes here");
        }
        catch(Exception e)            
        {
            
        }
    }
    
    public void AdmitPatient(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/PatientController/AdmitPatient.fxml"));
            MainBorderPane.setCenter(root);
            System.out.println("Admit comes here");
        }
        catch(Exception e)            
        {
            
        }
    }    
    
    public void DischargePatient(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/PatientController/DischargePatient.fxml"));
            MainBorderPane.setCenter(root);
            System.out.println("Discharge comes here");
        }
        catch(Exception e)            
        {
            
        }
    } 
    
    public void NewPatient(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/PatientController/NewPatient.fxml"));
            MainBorderPane.setCenter(root);
            System.out.println("New Patient comes here");
        }
        catch(Exception e)            
        {
            
        }
    }    
    
    
    public void HomeMedication(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/PatientAdministration/HomeMedication.fxml"));
            MainBorderPane.setCenter(root);
            System.out.println("Home Medication comes here");
        }
        catch(Exception e)            
        {
            
        }
    }        
    
    
    public void HospitalPrescription(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/PatientAdministration/HospitalPrescription.fxml"));
            MainBorderPane.setCenter(root);
            System.out.println("Hospital Prescribe comes here");
        }
        catch(Exception e)            
        {
            
        }
    }    
    
    public void SpecialAntimicrobials(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/PatientAdministration/SpecialAntimicrobials.fxml"));
            MainBorderPane.setCenter(root);
            System.out.println("Special Antimicrobial comes here");
        }
        catch(Exception e)            
        {
            
        }
    }    
    
    public void Administration(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/PatientAdministration/Administer.fxml"));
            MainBorderPane.setCenter(root);
            System.out.println("Administer comes here");
        }
        catch(Exception e)            
        {
            
        }
    }    
    
    public void TTO(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/PatientAdministration/TTO.fxml"));
            MainBorderPane.setCenter(root);
            System.out.println("TTO comes here");
        }
        catch(Exception e)            
        {
            
        }
    }    
    
    public void DrugEntry(ActionEvent event)
    {
        //
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("/com/afritrend/PatientAdministration/DrugEntry.fxml"));
            MainBorderPane.setCenter(root);
            System.out.println("Drug Entry comes here");
        }
        catch(Exception e)            
        {
            System.out.println(e.getMessage());
        }
    }    
    
    public void SavePatient_has_Cormobidity(ActionEvent event)
    {
        //
        try
        {
            Patient_Has_ComorbiditiesDataAccess pat_cormo = new Patient_Has_ComorbiditiesDataAccess();
            Patient_has_comorbiditiesModel cormobidity = new Patient_has_comorbiditiesModel();
            cormobidity.setComorbidities(String.valueOf(cbCormobidity.getValue()));
            cormobidity.setPatientid(PatientID);
            
            pat_cormo.Savepatient_has_comorbidities(cormobidity);
            
        }
        catch(Exception e)            
        {
            System.out.println(e.getMessage());
        }
    }    
    
    public void SavePatient_has_Allergy(ActionEvent event)
    {
        //
        try
        {
            Patient_Has_ComorbiditiesDataAccess pat_cormo = new Patient_Has_ComorbiditiesDataAccess();
            Patient_has_comorbiditiesModel cormobidity = new Patient_has_comorbiditiesModel();
            cormobidity.setComorbidities(String.valueOf(cbCormobidity.getValue()));
            cormobidity.setPatientid(PatientID);
            
            pat_cormo.Savepatient_has_comorbidities(cormobidity);
            
        }
        catch(Exception e)            
        {
            System.out.println(e.getMessage());
        }
    }     
    
    public void SavePatient_has_Antimicrobial(ActionEvent event)
    {
        //
        try
        {
            Patient_Has_ComorbiditiesDataAccess pat_cormo = new Patient_Has_ComorbiditiesDataAccess();
            Patient_has_comorbiditiesModel cormobidity = new Patient_has_comorbiditiesModel();
            cormobidity.setComorbidities(String.valueOf(cbCormobidity.getValue()));
            cormobidity.setPatientid(PatientID);
            
            pat_cormo.Savepatient_has_comorbidities(cormobidity);
            
        }
        catch(Exception e)            
        {
            System.out.println(e.getMessage());
        }
    }     
    
    public void SavePatient_has_Diagnosis(ActionEvent event)
    {
        //
        try
        {
            Patient_Has_ComorbiditiesDataAccess pat_cormo = new Patient_Has_ComorbiditiesDataAccess();
            Patient_has_comorbiditiesModel cormobidity = new Patient_has_comorbiditiesModel();
            cormobidity.setComorbidities(String.valueOf(cbCormobidity.getValue()));
            cormobidity.setPatientid(PatientID);
            
            pat_cormo.Savepatient_has_comorbidities(cormobidity);
            
        }
        catch(Exception e)            
        {
            System.out.println(e.getMessage());
        }
    }     
    
    public void SavePatient_has_Source(ActionEvent event)
    {
        //
        try
        {
            Patient_Has_ComorbiditiesDataAccess pat_cormo = new Patient_Has_ComorbiditiesDataAccess();
            Patient_has_comorbiditiesModel cormobidity = new Patient_has_comorbiditiesModel();
            cormobidity.setComorbidities(String.valueOf(cbCormobidity.getValue()));
            cormobidity.setPatientid(PatientID);
            
            pat_cormo.Savepatient_has_comorbidities(cormobidity);
            
        }
        catch(Exception e)            
        {
            System.out.println(e.getMessage());
        }
    }     
    
    
    public void Logout(ActionEvent event)
    {
        try
        {
            Stage LoginStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/healthpointpatientmanage/HealthPoint.fxml"));
            Scene scene = new Scene(root);
            LoginStage.setMaximized(true);
            LoginStage.centerOnScreen();        
            LoginStage.initStyle(StageStyle.UNDECORATED);            
            LoginStage.setScene(scene);
            
            Stage stage = (Stage)MainBorderPane.getScene().getWindow();
            stage.close();
            
            LoginStage.show();
        }
        catch(Exception e)            
        {
            System.out.println(e.getMessage());
        }
    }      
    
}
