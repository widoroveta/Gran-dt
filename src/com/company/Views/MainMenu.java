package com.company.Views;

import java.util.Scanner;

import com.company.model.MyTeam;
import com.company.model.User;
import com.company.request.APIClass.Teams;

public class MainMenu {
    Scanner sn = new Scanner(System.in);
	public void menuMain(){
        int s;
        int opcion; //Guardaremos la opcion del usuario
        	System.out.println("Gran DT Masters");
            System.out.println("1. Ingresar");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
                do
                {
                    opcion = sn.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingreso");
                        login();
                        ///Llamar a la funcion login
                        break;
                    case 2:
                        System.out.println("Registro");
                        regist();
                        ///Llamar a la funcion regist
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("\nIngrese una opcion valida");
                }
        System.out.println("Salir? si(1) o no(0)");
        s=sn.nextInt();
        }while(s==0);
   }
	
///Login
    private void login(){

    	User u1=new User();
        System.out.println("\nIngresar nombre ");
    	String userName = sn.nextLine();
        System.out.println("\nIngresar contraseña ");
    	String password = sn.nextLine();
    	boolean l=u1.login(userName, password);
    	if(l)
    	{
    		///Su usuario se ha conectado correctamente
    		UserMenu u2=new UserMenu(u1);
    	}
    	else
    	{
    		///Su usuario no se ha conectado correctamente
    		this.menuMain();
    	}
    }
///Registro
    private void regist(){
    	User u1=new User();
        System.out.println("\nIngresar nombre de usuario");
    	String nameUser=sn.nextLine();
		if(u1.browsUser(nameUser))
		{
		System.out.println("\nIngresar nombre ");
		String name=sn.nextLine();
		System.out.println("\nIngresar apellido ");
		String surname=sn.nextLine();
	    System.out.println("\nIngresar contraseña ");
		String password=sn.nextLine();
	    System.out.println("\nIngresar mail ");
		String mail=sn.nextLine();
	    System.out.println("\nIngresar nro telefonico ");
		int phone=sn.nextInt();
		/*
		System.out.println("\nIngresar nombre del equipo ");
	    String team=sn.nextLine();
		*/
		User u2=new User(nameUser, password, name, surname, mail, phone);
		u2.register(u2);
		}
	}
}

