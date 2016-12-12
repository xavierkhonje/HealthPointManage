/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientDataAccess;

import com.afritrend.PatientInterface.Ipatient_has_comorbidities;
import com.afritrend.PatientModel.Patient_has_comorbiditiesModel;
import com.afritrend.common.config;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public class Patient_Has_ComorbiditiesDataAccess implements Ipatient_has_comorbidities{

    config config = new config();
    Connection conn = null;
    CallableStatement stmt = null;     
    
    @Override
    public String Savepatient_has_comorbidities(Patient_has_comorbiditiesModel patient_has_comorbidities) {
            try
            {
                ResultSet rs = null;
                conn = config.DBConnect(); 
                String sql = "{CALL spHP_SavePatient_has_Cormobidities(?,?)}";    
                stmt = conn.prepareCall(sql);
                stmt.setString(1, patient_has_comorbidities.getPatientid());
                stmt.setString(2, patient_has_comorbidities.getComorbidities());
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
    public String Updatepatient_has_comorbidities(Patient_has_comorbiditiesModel patient_has_comorbidities) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Patient_has_comorbiditiesModel> Viewpatient_has_comorbidities() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Deactivatepatient_has_comorbidities(Patient_has_comorbiditiesModel patient_has_comorbidities) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer Searchpatient_has_comorbiditiesID(String criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
