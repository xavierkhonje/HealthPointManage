/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientDataAccess;

import com.afritrend.PatientInterface.Ipatient_has_source;
import com.afritrend.PatientModel.Patient_has_SourceModel;
import com.afritrend.common.config;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public class Patient_Has_SourceDataAccess implements Ipatient_has_source{

    config config = new config();
    Connection conn = null;
    CallableStatement stmt = null;     
    
    @Override
    public String Savepatient_has_source(Patient_has_SourceModel patient_has_source) {
            try
            {
                ResultSet rs = null;
                conn = config.DBConnect(); 
                String sql = "{CALL spHP_SavePatient_has_Source(?,?)}";    
                stmt = conn.prepareCall(sql);
                stmt.setString(1, patient_has_source.getPatientid());
                stmt.setString(2, patient_has_source.getSourceid());
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
    public String Updatepatient_has_source(Patient_has_SourceModel patient_has_source) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Patient_has_SourceModel> Viewpatient_has_source() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Deactivatepatient_has_source(Patient_has_SourceModel patient_has_source) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer Searchpatient_has_sourceID(String criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
