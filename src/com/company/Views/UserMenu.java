package com.company.Views;

import com.company.model.User;

import java.util.Scanner;

public class UserMenu {
    private User user;
    private Scanner sc = new Scanner(System.in);
    private int s;

    public void menu() {
        System.out.println("Hola " + user.getName() + ",que quieres hacer?");
        System.out.println("1)Ver mi perfil");
        System.out.println("2)Menu equipo");
        System.out.println("3)Menu de fixture");
        System.out.println("Aprete cualquier otro numero para salir.");
        System.out.println("Ingrese una opcion");

        switch (sc.nextInt()) {
            case 1:
                System.out.println(viewUser());
                break;
            case 2:
                menuTeam menuT=new menuTeam();
                break;
            case 3:
                menuFixture menuF=new menuFixture();
                break;

            default:
                System.out.println("Opcion no valida. Salir? si(1) o no(0)");
                s = sc.nextInt();
        }

    }


    public UserMenu(User user) {
        this.user = user;
    }

    public String viewUser() {
        return user.toString();
    }

    private class menuTeam{

        public menuTeam(){tMenu();}

        private void tMenu(){
            System.out.println("Menu Equipo:");
            System.out.println("1)Ver Equipo.");
            System.out.println("2)Modificar Equipo.");
            System.out.println("3)Volver al menu anterior.");

            switch (sc.nextInt()){
                case 1:
                    viewTeam();
                    break;
                case 2:
                    modifyTeam();
                    break;
                case 3:
                    menu();
                    break;
            }
        }

        private void viewTeam(){
        user.getMyTeam().getPlayers().stream().forEach(System.out::println);
        }

        private void modifyTeam () {
        System.out.println("Modificacion de equipo:");
        System.out.println("1)Agregar Jugador.");
        System.out.println("2)Cambiar Jugador.");
        System.out.println("3)Elininar Jugador");
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
    }
    private class menuFixture {

        public menuFixture(){fMenu();}

        private void fMenu() {
            System.out.println("Menu Fixture:");
            System.out.println("1)Mostrar fixture completo:");
            System.out.println("2)Mostrar proximos partidos");
            System.out.println("3)Mostrar partidos anteriores");
            System.out.println("4)Volver al menu anterior");

            switch (sc.nextInt()) {
                case 1:
                    showFixture();
                    break;
                case 2:
                    showNextMatches();
                    break;
                case 3:
                    showPrevMatches();
                    break;
                case 4:
                    menu();
                    break;
            }
        }

        private String showFixture() {
            return "";
        }
        private void showNextMatches(){}

        private void showPrevMatches(){}
    }

}
