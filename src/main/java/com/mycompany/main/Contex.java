/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import com.company.dao.impl.CountryDaoImpl;
import com.company.dao.impl.EmploymentHistoryDaoImpl;
import com.company.dao.impl.SkillDaoImpl;
import com.company.dao.impl.UserDaoImpl;
import com.company.dao.impl.UserSkillDaoImpl;
import com.mycompany.dao.inter.CountryDaoInter;
import com.mycompany.dao.inter.EmploymentHistoryDaoInter;
import com.mycompany.dao.inter.SkillDaoInter;
import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.dao.inter.UserSkillDaoInter;

/**
 *
 * @author group
 */
public class Contex {
    
    public static UserDaoInter instanceUserDao(){
    
        return new UserDaoImpl();
    }
    public static UserSkillDaoInter instanceUserSkillDao(){
    
        return new UserSkillDaoImpl();
    }
    public static EmploymentHistoryDaoInter instanceEmploymentHistoryDao(){
    
        return new EmploymentHistoryDaoImpl();
    }
    public static CountryDaoInter instanceCountryDao(){
    
        return new CountryDaoImpl();
    }
    public static SkillDaoInter instanceSkillDao(){
    
        return new SkillDaoImpl();
    }
    
}
