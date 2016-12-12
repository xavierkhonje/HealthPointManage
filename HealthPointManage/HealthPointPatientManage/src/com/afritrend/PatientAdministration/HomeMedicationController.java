/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientAdministration;

import com.afritrend.PatientController.PatientSearchController;
import com.afritrend.PatientDataAccess.HomeMedicationDataAccess;
import com.afritrend.PatientModel.HomeMedicationModel;
import com.afritrend.common.DataAccess.AutoDrugSearchDataAccess;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
public class HomeMedicationController implements Initializable {

    @FXML
    ComboBox cbDosageForm;
    
    @FXML
    ComboBox cbDrugName;
    
    @FXML
    ComboBox cbStrength;
    
    @FXML
    ComboBox cbIndication;
    
    @FXML
    ComboBox cbPlanOnSubmission;
    
    @FXML
    ComboBox cbChartered;
    
    @FXML
    ComboBox cbFrequency;
    
    @FXML
    ComboBox cbclass;
    
    @FXML
    TextField cbDuration;
    
    @FXML
    TextField txtDose;
    
    @FXML
    TextField txtRoute;
    
    @FXML
    TextField txtComment;
    
    @FXML
    TextField txtQuantity;
    
    @FXML
    DatePicker dpstartdate;
    
    @FXML
    DatePicker dpstopdate;
    
    String PatientID = PatientSearchController.Patient_ID2;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        AutoDrugSearchDataAccess drugclassdao = new AutoDrugSearchDataAccess();
        List<String> classlist = new ArrayList();
        
        classlist = drugclassdao.GetDrugClass();
        Iterator<String> classit = classlist.iterator();
        while(classit.hasNext())
        {
            String dclass = classit.next();
            cbclass.getItems().add(dclass);
        }
        
        cbIndication.getItems().addAll("Prophylactic","Emperical","Definitive");
        cbPlanOnSubmission.getItems().addAll("Continue","WithHold","Cease");
        cbChartered.getItems().addAll("YES","NO");
        cbFrequency.getItems().addAll("1","2","3","4");
    }    
    
    public void ShowDosageForms(ActionEvent event)
    {                
        AutoDrugSearchDataAccess drugclassdao = new AutoDrugSearchDataAccess();
        List<String> classlist = new ArrayList();
        
        classlist = drugclassdao.GetDosageForms();
        Iterator<String> classit = classlist.iterator();
        while(classit.hasNext())
        {
            String Doseform = classit.next();
            cbDosageForm.getItems().add(Doseform);
        }        
    }
    
    public void ShowDrugs(ActionEvent event)
    {
        AutoDrugSearchDataAccess drugclassdao = new AutoDrugSearchDataAccess();
        List<String> classlist = new ArrayList();
        
        String Dosage = String.valueOf(cbDosageForm.getValue());
        
        classlist = drugclassdao.GetDrugNamesByDosageForm(Dosage);
        Iterator<String> classit = classlist.iterator();
        while(classit.hasNext())
        {
            String DrugName = classit.next();
            cbDrugName.getItems().add(DrugName);
        }                  
    }
    
    public void ShowStrengths(ActionEvent event)
    {
        AutoDrugSearchDataAccess drugclassdao = new AutoDrugSearchDataAccess();
        List<String> classlist = new ArrayList();
        
        String Drug = String.valueOf(cbDrugName.getValue());
        
        classlist = drugclassdao.GetStrengthByDrugNames(Drug);
        Iterator<String> classit = classlist.iterator();
        while(classit.hasNext())
        {
            String Strength = classit.next();
            cbStrength.getItems().add(Strength);
        }         
    }
    
    public void SaveMeds(ActionEvent event)
    {
        try
        {
            String dosageform = String.valueOf(cbDosageForm.getValue());
            String DrugName = String.valueOf(cbDrugName.getValue());
            String Strength = String.valueOf(cbStrength.getValue());
            String Indication = String.valueOf(cbIndication.getValue());
            int Duration = Integer.valueOf(cbDuration.getText());
            String PlanOnSubmission = String.valueOf(cbPlanOnSubmission.getValue());
            String Chartered = String.valueOf(cbChartered.getValue());
            String Dose = txtDose.getText();
            String Route = txtRoute.getText();
            int Frequency = Integer.valueOf(String.valueOf(cbFrequency.getValue()));
            String Comment = txtComment.getText();
            String startdate = String.valueOf(dpstartdate.getValue());
            String stopdate = String.valueOf(dpstopdate.getValue());
            int Quantity = Integer.valueOf(txtQuantity.getText());
            String drugclass = String.valueOf(cbclass.getValue());
            
            HomeMedicationModel homemed = new HomeMedicationModel();
            homemed.setDrugName(DrugName);
            homemed.setIndication(Indication);
            homemed.setStartdate(startdate);
            homemed.setDuration(String.valueOf(Duration));
            homemed.setPlanonsubmission(PlanOnSubmission);
            homemed.setChartered(Chartered);
            homemed.setDose(Dose);
            homemed.setRoute(Route);
            homemed.setFrequency(Frequency);
            homemed.setPatientID(PatientID);
            
            HomeMedicationDataAccess homemeddao = new HomeMedicationDataAccess();
            homemeddao.SaveHomeMedication(homemed);
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}
