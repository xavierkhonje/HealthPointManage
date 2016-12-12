/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientInterface;

import com.afritrend.PatientModel.Patient_has_SourceModel;
import java.util.List;
/**
 *
 * @author Xavier Khonje
 */
public interface Ipatient_has_source {
    String Savepatient_has_source(Patient_has_SourceModel patient_has_source);
    String Updatepatient_has_source(Patient_has_SourceModel patient_has_source);   
    List<Patient_has_SourceModel> Viewpatient_has_source();
    String Deactivatepatient_has_source(Patient_has_SourceModel patient_has_source);  
    Integer Searchpatient_has_sourceID (String criteria);      
}
