/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.entity.EmploymentHistory;
import com.company.entity.User;
import com.mycompany.dao.inter.AbstractDAO;
import com.mycompany.dao.inter.EmploymentHistoryDaoInter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author group
 */
public class EmploymentHistoryDaoImpl extends AbstractDAO implements EmploymentHistoryDaoInter {

    

    public EmploymentHistory getEmploymentHistory(ResultSet rs) throws Exception{
    
        String header=rs.getString("header");
        String jobDescribtion=rs.getString("job_description");
        Date beginDate=rs.getDate("begin_date");
        Date endDate=rs.getDate("end_date");
        int userId=rs.getInt("user_id");
        EmploymentHistory emp=new EmploymentHistory(null, header, beginDate, endDate, jobDescribtion, new User(userId));
        
        return emp;
    }
    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId) {
    
        List<EmploymentHistory> result = new ArrayList<>();
        try ( Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement("select * from employment_history where user_id=?");
            stmt.setInt(1, userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {

                EmploymentHistory emp=getEmploymentHistory(rs);


                result.add(emp);
            }
//            rs.close();
//            stmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
