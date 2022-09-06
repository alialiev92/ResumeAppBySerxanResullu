/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import com.company.bean.User;
import com.mycompany.dao.inter.UserDaoInter;
import java.util.List;

/**
 *
 * @author group
 */
public class Main {

    

    public static void main(String[] args) throws Exception {
        UserDaoInter userDao=Contex.instanceUserDao();
        List<User>list=userDao.getAll();
//        userDao.removeUser(1);
//        List<User>list2=userDao.getAll();
        System.out.println("list="+list);
//        System.out.println("list2="+list2);

//          User u=userDao.getById(2);
//          u.setName("Ali");
//          userDao.updateUser(u);
            User u=new User(0,"Ruzgar","Aliyev","tttt@gmail.com","5552222");
            userDao.addUser(u);

    }

}
