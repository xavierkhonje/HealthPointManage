/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientInterface;
import com.afritrend.PatientModel.HomeMedicationModel;
import java.util.List;
/**
 *
 * @author Xavier Khonje
 */
public interface IHomeMedication {
    String SaveHomeMedication(HomeMedicationModel homemedication);
    String UpdateHomeMedication(HomeMedicationModel homemedication);   
    String ReverseHomeMedication(HomeMedicationModel homemedication);   
    List<HomeMedicationModel> ViewHomeMedication();    
    List<HomeMedicationModel> ViewPatientHomeMedication(String PatientID);    
    List<HomeMedicationModel> SearchHomeMedication(String PatientName, String DrugAdmissionDate, String DrugClass);    
}
