/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientInterface;

import com.afritrend.PatientModel.demographicsModel;
import java.util.List;
/**
 *
 * @author Xavier Khonje
 */
public interface IDemographics {
    String Savedemographics(demographicsModel demographics, String PatientID);
    String Updatedemographics(demographicsModel demographics);   
    List<demographicsModel> Viewdemographics();
    String Deactivateudemographics(demographicsModel demographics);  
    Integer SearchdemographicsID (String criteria);      
    demographicsModel SearchPatientdemographics (String PatientID);      
}
