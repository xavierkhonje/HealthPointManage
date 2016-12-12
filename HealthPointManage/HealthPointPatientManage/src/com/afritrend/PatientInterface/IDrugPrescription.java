/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientInterface;

import com.afritrend.PatientModel.AntibioticPrescriptionModel;
import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public interface IDrugPrescription {
    String SaveDrugPrescription(AntibioticPrescriptionModel drugprescription, String PatientID,String DrugType);
    String UpdateDrugPrescription (AntibioticPrescriptionModel drugadministration);   
    String ReverseDrugPrescription(AntibioticPrescriptionModel drugadministration);   
    List<AntibioticPrescriptionModel> ViewDrugPrescription();    
    List<AntibioticPrescriptionModel> ViewPatientDrugPrescription(String PatientID);    
    List<AntibioticPrescriptionModel> SearchDrugPrescription(String PatientName, String DrugAdmissionDate, String DrugClass);     
}
