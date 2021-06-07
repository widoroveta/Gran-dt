package com.company.Views;

import com.company.model.*;
import com.company.repository.ClubRepository;
import com.company.repository.FixtureRepository;
import com.company.repository.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserMenu {
    private User user;
    private UserRepository userRepo=new UserRepository();
    private Scanner sc = new Scanner(System.in);
    private int s;


    //public UserMenu(User u){this.user=u;}


    public void menu() {
        System.out.println("\nHola " + user.getName() + ",que quieres hacer?");
        System.out.println("1)Ver mi perfil");
        System.out.println("2)Menu equipo");
        System.out.println("3)Menu de fixture");
        System.out.println("4)Cerrar sesion y volver al menu principal");
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
            case 4:
                new MainMenu().menuMain();
                break;

            default:
                System.out.println("Opcion no valida. Salir? si(1) o no(0)");
                s = sc.nextInt();
        }

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
            if(user.getMyTeam().getTeamName()==null){
                setTeamName();
            }//else{}

            System.out.println("\nMenu Equipo:");
            System.out.println("1)Ver Equipo.");
            System.out.println("2)Modificar Equipo.");
            System.out.println("3)Volver al menu anterior.");

            switch (sc.nextInt()){
                case 1:
                    viewTeam();
                    tMenu();
                    break;
                case 2:
                    modifyTeam();
                    break;
                case 3:
                    menu();
                    break;
            }
        }
        private void setTeamName(){
            String teamName;
            System.out.println("\nIngrese el nombre de su equipo por unica vez:");
            sc.skip("\n");
            teamName=sc.nextLine();
            MyTeam t1=user.getMyTeam();
            t1.setTeamName(teamName);
            t1.setMoney(70000);
            changeMyTeam(t1);
            tMenu();
        }
        //tMenu 1

        private void viewTeam(){
            //List <Player> pla =user.getMyTeam().getPlayers();
            System.out.println("\nNombre de tu equipo: "+user.getMyTeam().getTeamName());
            System.out.println("\nFondos: $"+user.getMyTeam().getMoney());
            if(!user.getMyTeam().getPlayers().isEmpty()){
            user.getMyTeam().getPlayers().stream().sorted().forEach(System.out::println);
        }
        else{
                System.out.println("No hay un equipo cargado");
            }
        }
        //tMenu 2
        private void modifyTeam () {
        System.out.println("\nModificacion de equipo:");
        System.out.println("1)Agregar Jugador.");
        System.out.println("2)Cambiar Jugador.");
        System.out.println("3)Elininar Jugador");
        //System.out.println("4)Cambiar nombre de tu equipo");
        System.out.println("5)Volver al menu anterior");
        switch (sc.nextInt()) {
            case 1:
                boolean accept=false;
                while(!accept){
                addPlayerTeam();
                System.out.println("Quieres seguir agregando juagdores?");
                char c = sc.next().charAt(0);
                if (c == 'n' || c == 'N') {
                    accept=true;
                }
                if (c == 'r' || c == 'R') {
                    modifyTeam();
                    }
                }
                break;

            case 2:
                changePlayerTeam();
                break;

            case 3:
                removePlayerTeam();
                break;

            /*case 4:
                changeTeamName();
                break;*/
            case 5:
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
                    System.out.println(i++ + ") Tipo:" + p.getClass().getSimpleName() + ", Nombre: " + p.getPlayerName() + ", Club: " + p.getClubName()+", Precio: "+p.getPrice());
                }
                System.out.println("\nSelecciona por numero");
                select = all.get(sc.nextInt());
                System.out.println("\nType:" + select.getClass().getSimpleName() + ", Name: " + select.getPlayerName() + ", Club: " + select.getClubName()+", Precio: "+select.getPrice());
                System.out.println("\nTu dinero: "+user.getMyTeam().getMoney()+"\nEs el que quieres seleccionar?Y/N R:volver");
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
        private void changeMyTeam(MyTeam t1){
            //boolean flag=false;
            List<User> all = userRepo.getAll();
            for (User u: all
                 ) {
                if(u.getUserName().equalsIgnoreCase(getUser().getUserName())){
                    all.remove(u);
                    getUser().setMyTeam(t1);
                    all.add(getUser());
                    break;
                }
            }
            userRepo.setUsers(all);
            userRepo.save();
        }

        private void addPlayerTeam(){
            Player player1 = searchPlayer();
            MyTeam t1= getUser().getMyTeam();
            t1.addPlayer(player1);
            changeMyTeam(t1);
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
            System.out.println("\nMenu Fixture:");
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
