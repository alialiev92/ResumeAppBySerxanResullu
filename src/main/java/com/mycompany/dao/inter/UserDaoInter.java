/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.dao.inter;

import com.company.bean.User;
import java.util.List;

/**
 *
 * @author group
 */
public interface UserDaoInter {
    
    public List<User> getAll();
    public User getById(int id);
    public boolean updateUser(User u);
    public boolean removeUser(int id);
    
}
