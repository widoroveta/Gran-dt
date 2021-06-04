package com.company.Views;

import com.company.model.User;

import java.util.Scanner;

public class UserMenu {
    private User user;
    private Scanner sc = new Scanner(System.in);
    private int s;

    public UserMenu(User user) {
        this.user = user;
    }

    public void menu() {
        System.out.println("Hola " + user.getName() + ",que quieres hacer?");
        System.out.println("1)Ver mi equipo");
        System.out.println("2)Modificar mi equipo");
        System.out.println("3)Ver mi perfil");
        System.out.println("4)Menu de fixture");
        System.out.println("Ingrese una opción");
        do {
            switch (sc.nextInt()) {
                case 1:
                    viewTeam();
                    break;
                case 2:
                    modifyTeam();
                    break;
                case 3:
                    System.out.println(viewUser());
                    break;
                case 4:
                    menuFixture();
                    break;
                default:
                    System.out.println("Opción no valida.");
            }
            System.out.println("Salir? si(1) o no(0)");
            s = sc.nextInt();
        } while (s == 0);
    }

    public String viewUser() {
        return user.toString();
    }

    public void viewTeam() {
        user.getMyTeam().getPlayers().stream().forEach(System.out::println);
    }

    public void modifyTeam() {
        System.out.println("Modificacion de equipo:");
        System.out.println("1)Agregar Jugador.");
        System.out.println("2)Modificar Jugador.");
        System.out.println("3)Elininar Jugador");
        System.out.println("ok");
        switch (sc.nextInt()) {
            case 1:
                //        user.getMyTeam().addPlayer(player);
                break;

            case 2:
                //        user.getMyTeam().change(player1, player2);
                break;
            case 3:
                //        user.getMyTeam().remove(player);
                break;
            default:
                System.out.println("Ingrese una opcion valida.");
        }
    }

    private void menuFixture() {
        System.out.println("Menu Fixture:");
        System.out.println("1)Mostrar fixture:");

        switch (sc.nextInt()) {
            case 1:
                showFixture();
                break;
        }
    }

    public String showFixture() {
        return "";
    }

}
