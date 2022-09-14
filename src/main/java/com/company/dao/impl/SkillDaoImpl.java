/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.entity.Country;
import com.company.entity.Skill;
import com.mycompany.dao.inter.AbstractDAO;
import com.mycompany.dao.inter.SkillDaoInter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author group
 */
public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter{

    public Skill getSkill(ResultSet rs) throws Exception{
    
        int id=rs.getInt("id");
        String name=rs.getString("name");
        
        Skill skill=new Skill(id, name);
        return skill;
    }
    @Override
    public List<Skill> getAll() {
    List<Skill> result = new ArrayList<>();
        try ( Connection c = connect()) {

            Statement stmt = c.createStatement();
            stmt.execute("select* from skill");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {

                Skill skill=getSkill(rs);


                result.add(skill);
            }
//            rs.close();
//            stmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;}

 
   
    
}
