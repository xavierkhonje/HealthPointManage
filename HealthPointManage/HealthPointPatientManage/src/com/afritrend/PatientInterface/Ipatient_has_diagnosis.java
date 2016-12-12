/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientInterface;

import com.afritrend.PatientModel.Patient_has_DiagnosisModel;
import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public interface Ipatient_has_diagnosis {
    String Savepatient_has_diagnosis(Patient_has_DiagnosisModel patient_has_diagnosis);
    String Updatepatient_has_diagnosis(Patient_has_DiagnosisModel patient_has_diagnosis);   
    List<Patient_has_DiagnosisModel> Viewpatient_has_diagnosis();
    String Deactivatepatient_has_diagnosis(Patient_has_DiagnosisModel patient_has_diagnosis);  
    Integer Searchpatient_has_diagnosisID (String criteria);      
}
