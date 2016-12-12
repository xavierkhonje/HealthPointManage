/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientInterface;

import com.afritrend.PatientModel.Patient_Model;
import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public interface IPatient {
    String SavePatient(Patient_Model patient, String Hosp, String Ward, String Warddpt);
    String UpdatePatient(Patient_Model Patient);   
    List<Patient_Model> ViewPatient();
    String DeactivateuPatient(Patient_Model Patient);  
    Integer SearchPatientID (String criteria);     
    Patient_Model SearchPatient (String PatientID);     
    List<Patient_Model> SearchPatient (String firstname, String middlename, String lastname, String patientid);     
}
