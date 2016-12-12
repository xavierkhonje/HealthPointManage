/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientInterface;

import com.afritrend.PatientModel.Patient_has_AntimicrobialsModel;
import java.util.List;
/**
 *
 * @author Xavier Khonje
 */
public interface Ipatient_has_Antimicrobials {
    String Savepatient_has_antimicrobials(Patient_has_AntimicrobialsModel patient_has_antimicrobials);
    String Updatepatient_has_antimicrobials(Patient_has_AntimicrobialsModel patient_has_antimicrobials);   
    List<Patient_has_AntimicrobialsModel> Viewpatient_has_antimicrobials();
    String Deactivatepatient_has_antimicrobials(Patient_has_AntimicrobialsModel patient_has_antimicrobials);  
    Integer Searchpatient_has_antimicrobialsID (String criteria);       
}
