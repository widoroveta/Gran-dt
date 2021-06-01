package com.company.Views;

import com.company.model.Club;
import com.company.model.Player;
import com.company.repository.ClubRepository;
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
      /*  try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/
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
            print.println("4)Fixture");
            print.println("5)Resultados");
            switch (scanner.nextInt()) {
                case 1:
                    modifyPLayer();
                    break;
            }

        }

        private void modifyPLayer() {

            List<Player> all = clubRepository.getAll();
            Player select;
            boolean accept = false;
            while (accept == false) {
                int i = 0;
                for (Player p :
                        all) {
                    System.out.println(i++ + ") Type:" + p.getClass().getSimpleName() + "  Name: " + p.getPlayerName() + " Club: " + p.getClubName());
                }
                print.println("\nSelecciona por numero");
                 select = all.get(scanner.nextInt());
                System.out.println("\nType:" + select.getClass().getSimpleName() + "  Name: " + select.getPlayerName() + " Club: " + select.getClubName());
                System.out.println("\nEs el que quieres seleccionar?Y/N R:volver");
              char c=  scanner.next().charAt(0);
                if( c=='y' ||c=='Y')
                {
                    accept=true;
                }
                if (c=='r' ||c=='R')
                {
                    modification();
                }
            }
        }

        private void changeName(Player player){
            Player player1=player;
            print.println("Que nombre desear ponerle al jugador?");
           player1.setPlayerName(scanner.nextLine());
           for (Club c:
                   clubRepository.getClubs()) {
                if(c.getPlayerList().contains(player))
                {
                    int index=c.getPlayerList().indexOf(player);
                    c.getPlayerList().set(index,player1);
                }
            }
           clubRepository.save();

        }
    }
}

