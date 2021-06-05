package com.company.Views;

import com.company.model.Player;
import com.company.model.User;
import com.company.repository.ClubRepository;

import java.util.List;
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
                menu();
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
    //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    ///////////////Menu Team Class
    private class menuTeam{
        private ClubRepository cRepo=new ClubRepository();
        private Player playerAux=new Player();

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
        //tMenu 1
        private void viewTeam(){
        user.getMyTeam().getPlayers().stream().forEach(System.out::println);
        }
        //tMenu 2
        private void modifyTeam () {
        System.out.println("Modificacion de equipo:");
        System.out.println("1)Agregar Jugador.");
        System.out.println("2)Cambiar Jugador.");
        System.out.println("3)Elininar Jugador");
        System.out.println("4)Volver al menu anterior");
        switch (sc.nextInt()) {
            case 1:
                addPlayerTeam();
                break;

            case 2:
                changePlayerTeam();
                break;
            case 3:
                removePlayerTeam();
                break;
            case 4:
                tMenu();
                break;
            default:
                System.out.println("Ingrese una opcion valida.");
                modifyTeam();
            }
        }
        private Player searchPlayer(){
            List<Player> all = cRepo.getAll();
            Player select = null;
            boolean accept = false;
            while (!accept) {
                int i = 0;
                for (Player p :
                        all) {
                    System.out.println(i++ + ") Tipo:" + p.getClass().getSimpleName() + "  Nombre: " + p.getPlayerName() + " Club: " + p.getClubName());
                }
                System.out.println("\nSelecciona por numero");
                select = all.get(sc.nextInt());
                System.out.println("\nType:" + select.getClass().getSimpleName() + "  Name: " + select.getPlayerName() + " Club: " + select.getClubName());
                System.out.println("\nEs el que quieres seleccionar?Y/N R:volver");
                char c = sc.next().charAt(0);
                if (c == 'y' || c == 'Y') {
                    accept = true;
                }
                if (c == 'r' || c == 'R') {
                    modifyTeam();
                }

            }
            return select;
        }
        private void addPlayerTeam(){
            //cRepo.getAll().stream().forEach(System.out::println);
            //user.getMyTeam().addPlayer()
            Player player1 = searchPlayer();
            user.getMyTeam().addPlayer(player1);
            System.out.println(user.getMyTeam());
        }

        private void changePlayerTeam(){
            //        user.getMyTeam().change(player1, player2);
        }

        private void removePlayerTeam(){
            //        user.getMyTeam().remove(player);
        }

    }
    //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    ////////////////Menu Fixture Class
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
        //fMenu 1
        private String showFixture() {
            return "";
        }
        //fMenu 2
        private void showNextMatches(){}
        //fMenu 3
        private void showPrevMatches(){}
    }
    //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
}
