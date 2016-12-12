/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.common.DataAccess;

import com.afritrend.common.Interfaces.IAutoDrugSearch;
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
public class AutoDrugSearchDataAccess implements IAutoDrugSearch{

    config config = new config();
    Connection conn = null;
    CallableStatement stmt = null;     
    
    @Override
    public List<String> GetDosageForms() {
        List<String> dosagelist =  new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GETDosageForms}";    
            stmt = conn.prepareCall(sql);
            
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                String Dose = "";
                Dose = rs.getString("code");                
                dosagelist.add(Dose);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return dosagelist;         
    }

    @Override
    public List<String> GetDrugNamesByDosageForm(String DosageForm) {
        List<String> druglist =  new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GetDrugNamesByDosageForm(?)}";    
            stmt = conn.prepareCall(sql);
            stmt.setString(1, DosageForm);
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                String Drug = "";
                Drug = rs.getString("Drug");
                
                druglist.add(Drug);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return druglist;         
    }

    @Override
    public List<String> GetStrengthByDrugNames(String DrugName) {
        List<String> strengthlist =  new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GetStrengthByDrugNames(?)}";    
            stmt = conn.prepareCall(sql);
            stmt.setString(1, DrugName);
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                String Strength = "";
                Strength = rs.getString("Strength");
                
                strengthlist.add(Strength);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return strengthlist;        
    }

    @Override
    public List<String> GetDrugClass() {
        List<String> drugclasslist =  new ArrayList();
        
        try
        {
            conn = config.DBConnect(); 
            ResultSet rs = null;
            String sql = "{CALL spHP_GETDrugClasses}";    
            stmt = conn.prepareCall(sql);            
            stmt.execute();
            
            rs = stmt.getResultSet();
            
            while(rs.next())
            {
                String DrugClass = "";
                DrugClass = rs.getString("ClassName");                
                drugclasslist.add(DrugClass);
            }                        
        }
        catch(Exception e)
        {
            
        }        
        finally
        {
            
        }        
        
        return drugclasslist;         
    }
    
}
