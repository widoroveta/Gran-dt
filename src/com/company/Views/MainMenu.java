package com.company.Views;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
    	 
        Scanner sn = new Scanner(System.in);
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
                        ///Llamar a la funcion login
                        break;
                    case 2:
                        System.out.println("Registro");
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
    public void login(String nombre,String contraseña){

    }
///Registro
    public void regist(String nombre,String contraseña){

    }
}
