/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientInterface;

import com.afritrend.PatientModel.DiagnosisModel;
import java.util.List;
/**
 *
 * @author Xavier Khonje
 */
public interface IDiagnosis {
    String SaveDiagnosis(DiagnosisModel diagnosis);
    String UpdateDiagnosis(DiagnosisModel diagnosis);   
    List<DiagnosisModel> ViewDiagnosis();      
    List<DiagnosisModel> ViewPatientDiagnosis(String PatientID);      
}
