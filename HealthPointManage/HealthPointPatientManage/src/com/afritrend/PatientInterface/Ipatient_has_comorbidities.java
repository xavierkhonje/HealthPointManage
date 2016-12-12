/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientInterface;

import com.afritrend.PatientModel.Patient_has_comorbiditiesModel;
import java.util.List;
/**
 *
 * @author Xavier Khonje
 */
public interface Ipatient_has_comorbidities {
    String Savepatient_has_comorbidities(Patient_has_comorbiditiesModel patient_has_comorbidities);
    String Updatepatient_has_comorbidities(Patient_has_comorbiditiesModel patient_has_comorbidities);   
    List<Patient_has_comorbiditiesModel> Viewpatient_has_comorbidities();
    String Deactivatepatient_has_comorbidities(Patient_has_comorbiditiesModel patient_has_comorbidities);  
    Integer Searchpatient_has_comorbiditiesID (String criteria);    
}
