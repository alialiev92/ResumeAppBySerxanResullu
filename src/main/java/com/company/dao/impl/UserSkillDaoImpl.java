/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;
import com.mycompany.dao.inter.AbstractDAO;
import com.mycompany.dao.inter.UserSkillDaoInter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author group
 */
public class UserSkillDaoImpl extends AbstractDAO implements UserSkillDaoInter {

    

    public UserSkill getUserSkill(ResultSet rs) throws Exception{
    
        int userSkillId=rs.getInt("userSkillId");
        int userId=rs.getInt("id");
        int skillId=rs.getInt("skill_id");
        String skillName=rs.getString("skill_name");
        int power=rs.getInt("power");
        
        return new UserSkill(userSkillId,new User(userId),new Skill(skillId,skillName),power);
    }
    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
    
        List<UserSkill> result = new ArrayList<>();
        try ( Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement("select us.id as userSkillId,u.*,us.skill_id,s.name as skill_name,us.power from user_skill us" +
                                                        " left join user u on us.user_id=u.id" +
                                                        " left join skill s on us.skill_id=s.id" +
                                                        " where us.user_id=?");
            stmt.setInt(1, userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {

                UserSkill u=getUserSkill(rs);


                result.add(u);
            }
//            rs.close();
//            stmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean removeUserSkill(int id) {
        try ( Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement("delete from user_skill  where id=?");
            stmt.setInt(1, id);
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addUserSkill(UserSkill u) {

        try ( Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement("insert into user_skill(skill_id,user_id,power) values (?,?,?)");
            stmt.setInt(1, u.getUser().getId());
            stmt.setInt(2, u.getSkill().getId());
            stmt.setInt(3, u.getPower());

            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean updateUserSkill(UserSkill u) {

        try ( Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement("update user_skill set user_id=? skill_id=? power=? where id=?");
            stmt.setInt(1, u.getUser().getId());
            stmt.setInt(2, u.getSkill().getId());
            stmt.setInt(3, u.getPower());
            stmt.setInt(4, u.getId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
