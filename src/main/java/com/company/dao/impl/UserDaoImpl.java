/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.entity.Country;
import com.company.entity.User;
import com.mycompany.dao.inter.AbstractDAO;
import com.mycompany.dao.inter.UserDaoInter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author group
 */
public class UserDaoImpl extends AbstractDAO implements UserDaoInter {

    public User getUser(ResultSet rs) throws Exception{
    
        int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                int nationalityId = rs.getInt("nationality_id");
                int birthplaceId = rs.getInt("birthplace_id");
                String nationalitystr = rs.getString("nationality");
                String birthPlacestr = rs.getString("birthplace");
                Date birthDate=rs.getDate("birthdate");
                
                Country nationality=new Country(nationalityId,null,nationalitystr);
                Country birthPlace=new Country(birthplaceId,birthPlacestr,null);


                return new User(id, name, surname, email, phone,birthDate,nationality,birthPlace);
    }
    
    
    
    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        try ( Connection c = connect()) {

            Statement stmt = c.createStatement();
            stmt.execute("select "
                    +" u.*, "
                    +" n.nationality, "
                    +" c.name as birthplace "
                    +"from user u "
                    +"left join country n on u.nationality_id=n.id "
                    +"left join country c on u.birthplace_id=c.id");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {

                User u=getUser(rs);


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
    public boolean updateUser(User u) {
        try ( Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement("update user set name=?,surname=?,email=?,phone=? where id=?");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getPhone());
            stmt.setInt(5, u.getId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeUser(int id) {

        try ( Connection c = connect()) {

            Statement stmt = c.createStatement();
            return stmt.execute("delete from user  where id=1");
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public User getById(int userId) {
        User result = null;
        try ( Connection c = connect()) {

            Statement stmt = c.createStatement();
            stmt.execute("select "
                    +" u.*, "
                    +" n.nationality, "
                    +" c.name as birthplace "
                    +"from user u "
                    +"left join country n on u.nationality_id=n.id "
                    +"left join country c on u.birthplace_id=c.id where u.id="+userId);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {

                
                result=getUser(rs);
            }
//            rs.close();
//            stmt.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean addUser(User u) {
        try ( Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement("insert into user(name,surname,email,phone) values (?,?,?,?)");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getPhone());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }}

    
}
