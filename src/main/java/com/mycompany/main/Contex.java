/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import com.company.dao.impl.UserDaoImpl;
import com.mycompany.dao.inter.UserDaoInter;

/**
 *
 * @author group
 */
public class Contex {
    
    public static UserDaoInter instanceUserDao(){
    
        return new UserDaoImpl();
    }
    
}
