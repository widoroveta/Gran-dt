package com.company.Views;

import com.company.model.Club;
import com.company.model.Fixture;
import com.company.model.Match;
import com.company.model.Player;
import com.company.repository.ClubRepository;
import com.company.repository.FixtureRepository;
import com.company.request.AllSportsApi;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {
    PrintStream print = System.out;
    Scanner scanner = new Scanner(System.in);

    public AdminMenu() {
    }

    public void menu() {

        print.println("Bienvenido admin");
        print.println("Que quiere hacer?");
        print.println("1)Actualizar ");
        print.println("2)Modificar");
        print.println("3)Eliminar");
        print.println("4)Ver datos");
        switch (this.scanner.nextInt()) {
            case 1:
                update();
                break;
            case 2:
                ModificationMenuAdmin modificationMenuAdmin = new ModificationMenuAdmin();
                modificationMenuAdmin.modification();
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
    private class removeMenuAdmin{

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

            }

        }

        private void modifyMatch() {
            FixtureRepository fixtureRepository = new FixtureRepository();
            List<Match> all = fixtureRepository.getAll();
            Match select = null;
            boolean accept = false;
            while (accept == false) {
                for (Match m : all) {
                    System.out.println(m);
                }
                print.println("seleccione el partido por id");
                select = all.get(scanner.nextInt());
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

            switch (scanner.nextInt()) {
                case 1:
                    break;
            }

        }


        private void modifyClub() {
            List<Club> clubs = clubRepository.getClubs();
            Club select;
            boolean accept = false;
            while (accept == false) {
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
                        select.setClub(scanner.nextLine());
                        boolean b = changeNameClub(select);
                            if(b)
                            {
                                print.println("se ha cambiado el nombre correctamente");

                            }
                            else{
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

        public boolean changeNameClub(Club select) {
            Club c = select;
            int index = 0;
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

        private void modifyPLayer() {
            List<Player> all = clubRepository.getAll();
            Player select = null;
            boolean accept = false;
            while (accept == false) {
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

        private void changePrice(Player player) {
            Player player1 = player;
            print.println("Que precio desear ponerle al jugador?");
            player1.setPrice(scanner.nextInt());
            changePlayer(player, player1);
        }

        private void changeNumber(Player player) {
            Player player1 = player;
            print.println("Que numero desear ponerle al jugador?");
            player1.setPlayerNumber(scanner.nextInt());
            changePlayer(player, player1);
        }

        private void changePlayer(Player player1, Player player2) {
            for (Club c :
                    clubRepository.getClubs()) {
                if (c.getPlayerList().contains(player1)) {
                    int index = c.getPlayerList().indexOf(player1);
                    c.getPlayerList().set(index, player2);
                }
            }
            clubRepository.save();
        }

        private void changeName(Player player) {
            Player player1 = player;
            print.println("Que nombre desear ponerle al jugador?");
            player1.setPlayerName(scanner.nextLine());
            changePlayer(player, player1);
        }
    }
}

