/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.entity.Country;
import com.company.entity.EmploymentHistory;
import com.company.entity.User;
import com.mycompany.dao.inter.AbstractDAO;
import com.mycompany.dao.inter.CountryDaoInter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author group
 */
public class CountryDaoImpl extends AbstractDAO implements CountryDaoInter{

    public Country getCountry(ResultSet rs) throws Exception{
    
        int id=rs.getInt("id");
        String name=rs.getString("name");
        String nationality=rs.getString("nationality");
        
        Country coun=new Country(id, name, nationality);
        return coun;
    }
    @Override
    public List<Country> getAll() {
    
        List<Country> result = new ArrayList<>();
        try ( Connection c = connect()) {

            Statement stmt = c.createStatement();
            stmt.execute("select* from country");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {

                Country coun=getCountry(rs);


                result.add(coun);
            }
//            rs.close();
//            stmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

   
    
}
