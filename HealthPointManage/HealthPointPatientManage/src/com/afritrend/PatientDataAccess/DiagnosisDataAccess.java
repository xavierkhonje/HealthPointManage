/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientDataAccess;

import com.afritrend.PatientInterface.IDiagnosis;
import com.afritrend.PatientModel.DiagnosisModel;
import com.afritrend.common.config;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xavier Khonje
 */
public class DiagnosisDataAccess implements IDiagnosis{

    config config = new config();
    Connection conn = null;
    CallableStatement stmt = null;     
    
    @Override
    public String SaveDiagnosis(DiagnosisModel diagnosis) {
            try
            {
                ResultSet rs = null;
                conn = config.DBConnect(); 
                String sql = "{CALL spHP_SaveDiagnosis(?,?)}";    
                stmt = conn.prepareCall(sql);
                stmt.setString(1, diagnosis.getCode());
                stmt.setString(2, diagnosis.getDescription());
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
    public String UpdateDiagnosis(DiagnosisModel diagnosis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DiagnosisModel> ViewDiagnosis() {
        List<DiagnosisModel> allergylist =  new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GETDiagnosis}";    
            stmt = conn.prepareCall(sql);
            
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                DiagnosisModel allergy = new DiagnosisModel();
                allergy.setCode(rs.getString("Code"));
                allergy.setDescription(rs.getString("Description"));
                
                allergylist.add(allergy);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return allergylist;           
    }

    @Override
    public List<DiagnosisModel> ViewPatientDiagnosis(String PatientID) {
        List<DiagnosisModel> allergylist =  new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GETDiagnosisByID(?)}";    
            stmt = conn.prepareCall(sql);
            stmt.setString(1, PatientID);
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                DiagnosisModel allergy = new DiagnosisModel();
                allergy.setCode(rs.getString("Code"));
                allergy.setDescription(rs.getString("Description"));
                
                allergylist.add(allergy);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return allergylist;         
    }
    
}
