/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientDataAccess;

import com.afritrend.PatientInterface.ISource;
import com.afritrend.PatientModel.sourceModel;
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
public class SourceDataAccess implements ISource{
    config config = new config();
    Connection conn = null;
    CallableStatement stmt = null; 
    
    @Override
    public String SaveSource(sourceModel source) {
            try
            {
                ResultSet rs = null;
                conn = config.DBConnect(); 
                String sql = "{CALL spHP_Savesource(?,?)}";    
                stmt = conn.prepareCall(sql);
                stmt.setString(1, source.getCode());
                stmt.setString(2, source.getDescription());
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
    public String UpdateSource(sourceModel source) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<sourceModel> ViewSource() {
        List<sourceModel> allergylist =  new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GETsource}";    
            stmt = conn.prepareCall(sql);
            
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                sourceModel allergy = new sourceModel();
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
    public List<sourceModel> ViewSourceByID(String PatientID) {
        List<sourceModel> allergylist =  new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GETSourceByID(?)}";    
            stmt = conn.prepareCall(sql);
            stmt.setString(1, PatientID);
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                sourceModel allergy = new sourceModel();
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
