package com.company.Views;

import com.company.model.*;
import com.company.repository.ClubRepository;
import com.company.repository.FixtureRepository;
import com.company.repository.UserRepository;

import java.util.*;

public class UserMenu {
    private User user;
    private UserRepository userRepo = new UserRepository();
    private Scanner sc = new Scanner(System.in);
    private int s;


    //public UserMenu(User u){this.user=u;}


    public void menu() {
        System.out.println("\nHola " + user.getName() + ",que quieres hacer?");
        System.out.println("1)Ver mi perfil");
        System.out.println("2)Menu equipo");
        System.out.println("3)Menu de fixture");
        System.out.println("4)Mostrar Top Ten");
        System.out.println("5)Cerrar sesion y volver al menu principal");
        System.out.println("Aprete cualquier otro numero para salir.");
        System.out.println("Ingrese una opcion");

        switch (sc.nextInt()) {
            case 1:
                System.out.println(viewUser());
                menu();
            case 2:
                menuTeam menuT = new menuTeam();
                menuT.tMenu();
                break;
            case 3:
                menuFixture menuF = new menuFixture();
                break;
            case 4:
                TopTen top=new TopTen();
                top.showTopTen();

                break;

                case 5:
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
    private class menuTeam {
        private ClubRepository cRepo = new ClubRepository();

        private Player playerAux = new Player();

        public menuTeam() {
        }

        private void tMenu() {
            if ( user.getMyTeam().getTeamName() == null ) {
                setTeamName();
            }//else{}

            System.out.println("\nMenu Equipo:");
            System.out.println("1)Ver Equipo.");
            System.out.println("2)Modificar Equipo.");
            System.out.println("3)Volver al menu anterior.");

            switch (sc.nextInt()) {
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

        private void setTeamName() {
            String teamName;
            System.out.println("\nIngrese el nombre de su equipo por unica vez:");
            sc.skip("\n");
            teamName = sc.nextLine();
            MyTeam t1 = user.getMyTeam();
            t1.setTeamName(teamName);
            t1.setMoney(40000);
            changeMyTeam(t1);
            tMenu();
        }
        //tMenu 1

        private void viewTeam() {
            //List <Player> pla =user.getMyTeam().getPlayers();
            System.out.println("\nNombre de tu equipo: " + user.getMyTeam().getTeamName());
            System.out.println("\nFondos: $" + user.getMyTeam().getMoney());
            if ( !user.getMyTeam().getPlayers().isEmpty() ) {
                user.getMyTeam().getPlayers().stream().sorted().forEach(System.out::println);
            } else {
                System.out.println("No hay un equipo cargado");
            }
        }

        //tMenu 2
        private void modifyTeam() {
            System.out.println("\nModificacion de equipo:");
            System.out.println("1)Agregar Jugador.");
            System.out.println("2)Cambiar Jugador.");
            System.out.println("3)Elininar Jugador");
            System.out.println("4)Volver al menu anterior");
            switch (sc.nextInt()) {
                case 1:
                    boolean accept = false;
                    while (!accept) {
                        addPlayerTeam();
                        System.out.println("Quieres seguir agregando juagdores?");
                        char c = sc.next().charAt(0);
                        if ( c == 'n' || c == 'N' ) {
                            accept = true;
                            modifyTeam();
                        }
                        if ( c == 'r' || c == 'R' ) {
                            modifyTeam();
                        }
                    }
                    break;

                case 2:
                    changePlayerTeam();
                    modifyTeam();
                    break;

                case 3:
                    removePlayerTeam();
                    modifyTeam();
                    break;

                case 4:
                    tMenu();
                    break;

                default:
                    System.out.println("Ingrese una opcion valida.");
                    modifyTeam();
            }
        }

        private Player searchPlayer() {
            List<Player> all = cRepo.getAll();
            Player select = null;
            boolean accept = false;
            while (!accept) {
                int i = 0;
                for (Player p :
                        all) {
                    System.out.println(i++ + ") Tipo:" + p.getClass().getSimpleName() + ", Nombre: " + p.getPlayerName() + ", Club: " + p.getClubName() + ", Precio: " + p.getPrice());
                }
                System.out.println("\nSelecciona por numero");
                select = all.get(sc.nextInt());
                System.out.println("\nType:" + select.getClass().getSimpleName() + ", Name: " + select.getPlayerName() + ", Club: " + select.getClubName() + ", Precio: " + select.getPrice());
                System.out.println("\nTu dinero: " + user.getMyTeam().getMoney() + "\nEs el que quieres seleccionar?Y/N R:volver");
                char c = sc.next().charAt(0);
                if ( c == 'y' || c == 'Y' ) {
                    accept = true;
                }
                if ( c == 'r' || c == 'R' ) {
                    modifyTeam();
                }

            }
            return select;
        }

        private Player searchPlayerTeam() {

            List<Player> all = user.getMyTeam().getPlayers();
            Player select = null;
            boolean accept = false;
            while (!accept) {
                int i = 0;
                for (Player p :
                        all) {
                    System.out.println(i++ + ") Tipo:" + p.getClass().getSimpleName() + ", Nombre: " + p.getPlayerName() + ", Club: " + p.getClubName() + ", Precio: " + p.getPrice());
                }
                System.out.println("\nSelecciona por numero");
                select = all.get(sc.nextInt());
                System.out.println("\nType:" + select.getClass().getSimpleName() + ", Name: " + select.getPlayerName() + ", Club: " + select.getClubName() + ", Precio: " + select.getPrice());
                System.out.println("\nTu dinero: " + user.getMyTeam().getMoney() + "\nEs el que quieres seleccionar?Y/N R:volver");
                char c = sc.next().charAt(0);
                if ( c == 'y' || c == 'Y' ) {
                    accept = true;
                }
                if ( c == 'r' || c == 'R' ) {
                    modifyTeam();
                }

            }
            return select;
        }


    private void changeMyTeam(MyTeam t1) {
        //boolean flag=false;
        List<User> all = userRepo.getAll();
        for (User u : all
        ) {
            if ( u.getUserName().equalsIgnoreCase(getUser().getUserName()) ) {
                all.remove(u);
                getUser().setMyTeam(t1);
                all.add(getUser());
                break;
            }
        }
        userRepo.setUsers(all);
        userRepo.save();
    }

    private void addPlayerTeam() {
        Player player1 = searchPlayer();
        MyTeam t1 = getUser().getMyTeam();
        t1.addPlayer(player1);
        changeMyTeam(t1);
    }

    private void changePlayerTeam() {
        Player player1=searchPlayerTeam();
        Player player2 = searchPlayer();
        MyTeam team= getUser().getMyTeam();
        team.change(player1, player2);
        changeMyTeam(team);
    }

    private void removePlayerTeam() {
        Player player=searchPlayerTeam();
        MyTeam team= getUser().getMyTeam();
        team.remove(player);
        changeMyTeam(team);
    }


}


//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
////////////////Menu Fixture Class
private class menuFixture {
    FixtureRepository fixtureRepository = new FixtureRepository();
    Date date = new Date();

    public menuFixture() {
        fMenu();
    }

    private void fMenu() {
        System.out.println("\nMenu Fixture:");
        System.out.println("1)Mostrar fixture completo:");
        System.out.println("2)Mostrar proximos partidos");
        System.out.println("3)Mostrar partidos anteriores");
        System.out.println("4)Volver al menu anterior");

        switch (sc.nextInt()) {
            case 1:
                showFixture();
                fMenu();
                break;
            case 2:
                showNextMatches();
                fMenu();
                break;
            case 3:
                showPrevMatches();
                fMenu();
                break;
            case 4:
                menu();
                break;
        }
    }

    //fMenu 1
    private void showFixture() {

        for (Match m :
                fixtureRepository.getAll()) {
            System.out.println(m.toStringOnlyViewMatch());
        }

    }

    //fMenu 2
    private void showNextMatches() {
        for (Match m :
                fixtureRepository.getAll()) {
            if ( m.getDate().after(date) ) {
                System.out.println(m.toStringOnlyViewMatch());
            }
        }
    }

    //fMenu 3
    private void showPrevMatches() {
        for (Match m :
                fixtureRepository.getAll()) {
            if ( m.getDate().before(date) ) {
                System.out.println(m.toString());
            }
        }
    }
}
//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
///////////TOP10
private class TopTen{
    UserRepository users=new UserRepository();
    List<User> topten=new ArrayList<>();
    public TopTen() {
    }

    public void setTopTen(){
        List<User> usersAll = users.getAll();
        Collections.sort(usersAll);
        if(usersAll.size()<10){
            this.topten=usersAll;
        }
        else if(usersAll.size()>=10){
            this.topten=usersAll.subList(0,10);
        }
    }

    public void showTopTen(){
        setTopTen();
        for (User u:
             this.topten) {
            System.out.println("User: "+u.getUserName()+"; Team Name: "+u.getMyTeam().getTeamName()+"; Score: "+u.getMyTeam().getScore());

        }
        menu();
    }

}

}
