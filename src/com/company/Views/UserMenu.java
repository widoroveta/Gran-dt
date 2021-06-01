package com.company.Views;

import com.company.model.User;

public class UserMenu {
    private User user;
    public  void menu(){
        System.out.println("Hola "+ user.getName()+ ",que quieres hacer?");
        System.out.println("1)Ver mi equipo");
        System.out.println("2)Modificar mi equipo");
        System.out.println("3)Ver mi perfil");
        System.out.println("4)Menu de fixture");
        System.out.println("");
    }

}
