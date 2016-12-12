/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientInterface;

import com.afritrend.PatientModel.Patient_has_AllergiesModel;
import java.util.List;
/**
 *
 * @author Xavier Khonje
 */
public interface Ipatient_has_allergies {
    String Savepatient_has_allergies(Patient_has_AllergiesModel patient_has_allergies);
    String Updatepatient_has_allergies(Patient_has_AllergiesModel patient_has_allergies);   
    List<Patient_has_AllergiesModel> Viewpatient_has_allergies();
    String Deactivatepatient_has_allergies(Patient_has_AllergiesModel patient_has_allergies);  
    Integer Searchpatient_has_allergiesID (String criteria);      
    
}
