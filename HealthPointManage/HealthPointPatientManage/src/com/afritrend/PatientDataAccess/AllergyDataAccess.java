/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.PatientDataAccess;

import com.afritrend.PatientInterface.IAllergies;
import com.afritrend.PatientModel.AllergiesModel;
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
public class AllergyDataAccess implements IAllergies{

    config config = new config();
    Connection conn = null;
    CallableStatement stmt = null;     
    
    @Override
    public String SaveAllergy(AllergiesModel Allergy) {
        try
        {
            ResultSet rs = null;
            conn = config.DBConnect(); 
            String sql = "{CALL spHP_SaveAllergies(?,?)}";    
            stmt = conn.prepareCall(sql);
            stmt.setString(1, Allergy.getCode());
            stmt.setString(2, Allergy.getDescription());
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
    public String UpdateAllergy(AllergiesModel Allergy) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AllergiesModel> ViewAllergy() {
        List<AllergiesModel> allergylist =  new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GETAllergies}";    
            stmt = conn.prepareCall(sql);
            
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                AllergiesModel allergy = new AllergiesModel();
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
    public List<AllergiesModel> ViewPatientAllergies(String PatientID) {
        List<AllergiesModel> allergylist =  new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GETAllergiesByID(?)}";    
            stmt = conn.prepareCall(sql);
            stmt.setString(1, PatientID);
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                AllergiesModel allergy = new AllergiesModel();
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
