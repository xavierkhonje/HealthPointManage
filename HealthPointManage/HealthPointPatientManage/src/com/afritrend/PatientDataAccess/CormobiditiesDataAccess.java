/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientDataAccess;

import com.afritrend.PatientInterface.IComorbidities;
import com.afritrend.PatientModel.CormobiditiesModel;
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
public class CormobiditiesDataAccess implements IComorbidities{

    config config = new config();
    Connection conn = null;
    CallableStatement stmt = null;      
    
    @Override
    public String SaveCormobidities(CormobiditiesModel cormobidities) {
            try
            {
                ResultSet rs = null;
                conn = config.DBConnect(); 
                String sql = "{CALL spHP_SaveComorbidities(?,?)}";    
                stmt = conn.prepareCall(sql);
                stmt.setString(1, cormobidities.getCode());
                stmt.setString(2, cormobidities.getDescription());
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
    public String UpdateCormobidities(CormobiditiesModel cormobidities) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CormobiditiesModel> ViewCormobidities() {
        List<CormobiditiesModel> allergylist =  new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GETcomorbidities}";    
            stmt = conn.prepareCall(sql);
            
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                CormobiditiesModel allergy = new CormobiditiesModel();
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
    public List<CormobiditiesModel> ViewPatientCormobidities(String PatientID) {
        List<CormobiditiesModel> allergylist =  new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GETcomorbidities}";    
            stmt = conn.prepareCall(sql);
            stmt.setString(1, PatientID);
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                CormobiditiesModel allergy = new CormobiditiesModel();
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
