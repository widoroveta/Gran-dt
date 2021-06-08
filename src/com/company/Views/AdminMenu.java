package com.company.Views;

import com.company.model.*;
import com.company.repository.ClubRepository;
import com.company.repository.FixtureRepository;
import com.company.repository.ResultsRepository;
import com.company.repository.UserRepository;
import com.company.request.AllSportsApi;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {
    private static final PrintStream print = System.out;
    private static Scanner scanner = new Scanner(System.in);

    public AdminMenu() {
    }

    public void menu() {

        print.println("Bienvenido admin");
        print.println("Que quiere hacer?");
        print.println("1)Actualizar ");
        print.println("2)Modificar");
        print.println("3)Eliminar");
        print.println("4)Ver datos");
        print.println("5)Volver al menu principal");
        switch (this.scanner.nextInt()) {
            case 1:
                update();
                break;
            case 2:
                ModificationMenuAdmin modificationMenuAdmin = new ModificationMenuAdmin();
                modificationMenuAdmin.modification();
                break;
            case 3:
                new RemoveMenuAdmin().menuRemove();
                break;
            case 4:
                new ViewMenuAdmin().viewMenu();
                break;
            case 5:
                new MainMenu().menuMain();
                break;
        }
    }

    public void update() {
        AllSportsApi api = new AllSportsApi();
        try {
            api.toUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FixtureRepository fixtureRepository = new FixtureRepository();
        Fixture fixture = new Fixture();
        fixture.doFixture();
        fixture.setDate();
        fixtureRepository.setFixture(fixture);
        boolean save = fixtureRepository.save();
        if (save) {
            print.println("se ha actualizado");
            menu();
        }


    }


    /////
    private class RemoveMenuAdmin {
        public RemoveMenuAdmin() {
        }

        public void menuRemove() {
            print.println("Menu de eliminacion");
            print.println("Que quieres eliminar?");
            print.println("1)Un jugador");
            print.println("2)un club");
            print.println("3)un usuario ");
            print.println("4)un partido ");
            print.println("5)un resultado ");
            print.println("6)Volver al menu ");
            switch (scanner.nextInt()) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;

                case 6:
                    break;

            }

        }
    }

    private class ModificationMenuAdmin {
        ClubRepository clubRepository = new ClubRepository();

        public ModificationMenuAdmin() {

        }

        public void modification() {
            print.println("Que desea modificar?");
            print.println("1)Jugadores");
            print.println("2)Clubes");
            print.println("3)Partidos");
            print.println("4)Resultados");
            print.println("5)Volver al menu");
            switch (scanner.nextInt()) {
                case 1:
                    modifyPLayer();
                    break;
                case 2:
                    modifyClub();
                    break;
                case 3:
                    modifyMatch();
                    break;
                case 4:
                    menu();
                    break;


            }

        }

        private void modifyMatch() {
            FixtureRepository fixtureRepository = new FixtureRepository();
            List<Match> all = fixtureRepository.getAll();
            Match select = null;
            boolean accept = false;
            while (!accept) {
                for (Match m : all) {
                    System.out.println(m);
                }
                print.println("seleccione el partido por id");
                select = all.get(scanner.nextInt());
                print.println(select);
                print.println("Es este el partido a modificar?Y/N R:Volver");
                char c = scanner.next().charAt(0);
                if (c == 'y' || c == 'Y') {
                    accept = true;
                }
                if (c == 'r' || c == 'R') {
                    modification();
                }
            }

            print.println("1)Cambiar jugador del mismo equipo");
            print.println("2)Cambiar jugador de otro equipo");
            print.println("3)Modificar la fecha ");
            print.println("4)Volver al menu");

            switch (scanner.nextInt()) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }

        }


        private void modifyClub() {
            List<Club> clubs = clubRepository.getClubs();
            Club select;
            boolean accept = false;
            while (!accept) {
                int i = 0;
                for (Club c : clubs) {
                    print.println("\n" + i++ + ") Nombre del club: " + c.getClub());
                }
                print.println("\nSelecciona por numero");
                select = clubs.get(scanner.nextInt());
                print.println("\nNombre del club: " + select.getClub());
                print.println("\nEs el que quieres seleccionar?Y/N R:volver");
                char c = scanner.next().charAt(0);
                if (c == 'y' || c == 'Y') {
                    print.println("Quieres Cambiar nombre del club?y/n R:Volver");
                    c = scanner.next().charAt(0);
                    if (c == 'y' || c == 'Y') {
                        System.out.println("escribe el nombre del club");
                        scanner.skip("\n");
                        select.setClub(scanner.nextLine());
                        boolean b = changeNameClub(select);
                        if (b) {
                            print.println("se ha cambiado el nombre correctamente");

                        } else {
                            print.println("no se ha cambiado correctamente");
                        }
                        menu();
                    }
                    if (c == 'r' || c == 'R') {
                        modification();
                    }
                }
                if (c == 'r' || c == 'R') {
                    modification();
                }


            }

        }


        private void modifyPLayer() {
            List<Player> all = clubRepository.getAll();
            Player select = null;
            boolean accept = false;
            while (!accept) {
                int i = 0;
                for (Player p :
                        all) {
                    System.out.println(i++ + ") Tipo:" + p.getClass().getSimpleName() + "  Nombre: " + p.getPlayerName() + " Club: " + p.getClubName());
                }
                print.println("\nSelecciona por numero");
                select = all.get(scanner.nextInt());
                print.println("\nType:" + select.getClass().getSimpleName() + "  Name: " + select.getPlayerName() + " Club: " + select.getClubName());
                print.println("\nEs el que quieres seleccionar?Y/N R:volver");
                char c = scanner.next().charAt(0);
                if (c == 'y' || c == 'Y') {
                    accept = true;
                }
                if (c == 'r' || c == 'R') {
                    modification();
                }

            }

            print.println("1)Cambiar nombre");
            print.println("2)Cambiar numero");
            print.println("3)Cambiar precio");
            print.println("4)Volver al Menu");

            switch (scanner.nextInt()) {
                case 1:
                    changeName(select);

                    break;
                case 2:
                    changeNumber(select);
                    break;
                case 3:
                    changePrice(select);
                    break;
                case 4:
                    menu();
                    break;

            }

        }

        public boolean changeNameClub(Club select) {
            Club c = select;
            int index = -1;
            List<Club> clubs = clubRepository.getClubs();
            if (clubs.contains(select)) {
                index = clubs.indexOf(select);
                print.println("Que nombre queres ponerle al club?");
                c.setClub(scanner.nextLine());
                clubs.set(index, c);

                return clubRepository.save();
            }

            return false;
        }

        private void changePrice(Player player) {

            try {
                Player player1 = null;
                player1 = (Player) player.clone();
                print.println("Que precio desear ponerle al jugador?");
                player1.setPrice(scanner.nextInt());
                changePlayer(player, player1);
                System.out.println("cambio realizado");
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            menu();
        }

        private void changeNumber(Player player) {

            try {
                Player player1 = null;
                player1 = (Player) player.clone();
                print.println("Que numero desear ponerle al jugador?");
                player1.setPlayerNumber(scanner.nextInt());

                changePlayer(player, player1);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }

            System.out.println("cambio realizado");
            menu();
        }

        private void changePlayer(Player player1, Player player2) {

            int index = -1;
            int i = -1;
            List<Club> clubs = clubRepository.getClubs();
            System.out.println(clubs);
            for (Club c :
                    clubs) {
                i++;
                if (c.getClub().equals(player1.getClubName())) {
                    for (Player player : c.getPlayerList()) {
                        if (player.getPlayerName().equals(player1.getPlayerName())) {
                            index = c.getPlayerList().indexOf(player);
                            break;
                        }
                    }
                }
            }
            clubs.get(i).getPlayerList().remove(player1);
            clubs.get(i).getPlayerList().set(index, player2);


            clubRepository.setClubs(clubs);
            clubRepository.save();
        }

        private void changeName(Player player) {


            try {
                Player player1 = new Player();
                player1 = (Player) player.clone();
                print.println("Que nombre desear ponerle al jugador?");
                scanner.skip("\n");
                player1.setPlayerName(scanner.nextLine());
                changePlayer(player, player1);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }


            System.out.println("cambio realizado");
            menu();
        }

        private Player selectPlayerInMatch(Match m) {
            int i = 0;
            print.println("Local team");
            for (Player p :
                    m.getLocalTeam()) {
                print.println(i++ + ") Nombre: " + p.getPlayerName() + "Posicion: " + p.getClass().getSimpleName());
            }
            i = 0;
            print.println("Visitor team");
            for (Player p :
                    m.getVisitorTeam()) {
                print.println(i++ + ") Nombre: " + p.getPlayerName() + "Posicion: " + p.getClass().getSimpleName());
            }
            print.println("Selecciona 1 para local y 2 para visitante");
            int i2 = scanner.nextInt();
            if (i2 == 1) {
                print.println("Que jugador quiere modificar del equipo Local?");
                int i1 = scanner.nextInt();
                print.println(m.getLocalTeam().get(i1));
                print.println("\nEs el que quieres seleccionar?Y/N R:volver");
                char c = scanner.next().charAt(0);
                if (c == 'y' || c == 'Y') {

                    return m.getLocalTeam().get(i1);
                }
                if (c == 'r' || c == 'R') {
                    modification();
                }
            } else {
                if (i == 2) {
                    print.println("Que jugador quiere modificar del equipo Visitante?");
                    int i1 = scanner.nextInt();
                    print.println(m.getVisitorTeam().get(i1));
                    print.println("\nEs el que quieres seleccionar?Y/N R:volver");
                    char c = scanner.next().charAt(0);
                    if (c == 'y' || c == 'Y') {

                        return m.getVisitorTeam().get(i1);
                    }
                    if (c == 'r' || c == 'R') {
                        modification();
                    }
                }
            }
            return null;
        }

        private void changeInMatchPlayer(Match m, Player player1, Player player2) {
            FixtureRepository fixtureRepository = new FixtureRepository();
            List<Match> all = fixtureRepository.getAll();
            int i = all.indexOf(m);
            if (i > 0) {
                if (all.get(i).getVisitorTeam().contains(player1)) {
                    all.get(i).getVisitorTeam().remove(player1);
                    all.get(i).getVisitorTeam().set(i, player2);
                } else {
                    if (all.get(i).getLocalTeam().contains(player1)) {
                        all.get(i).getLocalTeam().remove(player1);
                        all.get(i).getLocalTeam().set(i, player2);
                    }
                }
            } else {
                print.println("algo andubo mal");
                menu();
            }

        }

        private void changePlayerSameClub(Match m) {
            Player player = selectPlayerInMatch(m);
            List<Club> clubs = new ClubRepository().getClubs();
            int i = 0;
            if (player != null) {
                if (player.getClubName().equals(m.getNameLocal())) {
                    for (Player p :
                            new ClubRepository().searchByName(m.getNameLocal()).getPlayerList()) {
                        print.println(i++ + ") Nombre: " + p.getPlayerName() + "Posicion: " + p.getClass().getSimpleName());
                    }

                }
                if (player.getClubName().equals(m.getNameVisitor())) {
                    for (Player p :
                            new ClubRepository().searchByName(m.getNameVisitor()).getPlayerList()) {
                        print.println(i++ + ") Nombre: " + p.getPlayerName() + "Posicion: " + p.getClass().getSimpleName());
                    }
                }


            }
        }
    }

    private class ViewMenuAdmin {

        public ViewMenuAdmin() {
        }

        public void viewMenu() {
            ClubRepository clubRepository =new ClubRepository();
            print.println("Menu de datos ");
            print.println("Que quieres ver");
            print.println("1)Jugadores");
            print.println("2)Clubes");
            print.println("3)Usuarios ");
            print.println("4)Partidos ");
            print.println("5)Resultados ");
            print.println("6)Volver al menu ");
            switch (scanner.nextInt()) {

                case 1:
                  System.out.println( clubRepository.getAll());
                exitViews();
                  break;
                case 2:
                    System.out.println(clubRepository.getClubs());
                    exitViews();
                    break;
                case 3:
                    UserRepository repository=new UserRepository();
                    print.println(repository.getAll());
               exitViews();
                    break;
                case 4:
                    FixtureRepository fixtureRepository=new FixtureRepository();
                    print.println(fixtureRepository.getAll());
                    break;
                case 5:
                    ResultsRepository repository1 =new ResultsRepository();
                    print.println(repository1.getAll());
                    break;

                case 6:
                    menu();
                    break;

            }

        }
        public void exitViews() {
            print.println("Aprete y para volver al menu de vistas y n para volver al menu principal de admin");
            char c = scanner.next().charAt(0);
            if (c == 'y' || c == 'Y') {

               viewMenu();
            }
            if (c == 'n' || c == 'N') {
                menu();
            }
        }
    }

}