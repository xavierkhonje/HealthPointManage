/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientDataAccess;

import com.afritrend.PatientInterface.Ipatient_has_diagnosis;
import com.afritrend.PatientModel.Patient_has_DiagnosisModel;
import com.afritrend.common.config;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public class Patient_Has_DiagnosisDataAccess implements Ipatient_has_diagnosis{

    config config = new config();
    Connection conn = null;
    CallableStatement stmt = null;     
    
    @Override
    public String Savepatient_has_diagnosis(Patient_has_DiagnosisModel patient_has_diagnosis) {
            try
            {
                ResultSet rs = null;
                conn = config.DBConnect(); 
                String sql = "{CALL spHP_SavePatient_has_Diagnosis(?,?)}";    
                stmt = conn.prepareCall(sql);
                stmt.setString(1, patient_has_diagnosis.getPatientid());
                stmt.setString(2, patient_has_diagnosis.getDiagnosis());
                stmt.execute();
            }
            catch(Exception e)
            {
                return e.getMessage();
            }
            finally
            {
                return "Store Procedure Processed";
            }         
    }

    @Override
    public String Updatepatient_has_diagnosis(Patient_has_DiagnosisModel patient_has_diagnosis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Patient_has_DiagnosisModel> Viewpatient_has_diagnosis() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Deactivatepatient_has_diagnosis(Patient_has_DiagnosisModel patient_has_diagnosis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer Searchpatient_has_diagnosisID(String criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
