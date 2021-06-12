package com.company.Views;

import com.company.enums.Dates;
import com.company.model.*;
import com.company.repository.FixtureRepository;
import com.company.repository.ResultsRepository;
import com.company.repository.UserRepository;
import com.company.request.AllSportsApi;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class MainMenu {
   static Scanner scanner = new Scanner(System.in);

   private void preProccesor() {
       File clubsFile = new File("clubs.json");
       File fixtureFile = new File("Fixture.json");
       FixtureRepository fixtureRepository = new FixtureRepository();
       if (clubsFile.exists()&&fixtureFile.exists()) {
           List<Match> all = fixtureRepository.getAll();
           Date date = new Date();

           UserRepository userRepository = new UserRepository();

           for (Match match :
                   all) {

               if ( match.getDate().before(date) ) {
                   if ( match.getVisitorTeam().isEmpty() || match.getLocalTeam().isEmpty() ) {

                       match.assembleMatch();

                       match.pointsPlayers();

                   }

               }
           }
           Fixture fixture = new Fixture();
           fixture.setFixture(all);
           fixtureRepository.setFixture(fixture);
           fixtureRepository.save();
           Dates[] values = Dates.values();
           List<User> all1 = userRepository.getAll();
           List<Result> results = new ArrayList<>();
           ResultsRepository repository = new ResultsRepository();
           int points = 0;
           for (User us :
                   all1) {

               for (Dates d :
                       values) {
                   points = 0;

                   for (Player p :
                           us.getMyTeam().getPlayers()) {

                       points += fixtureRepository.searchPoints(p, d.getDate());
                   }

                   results.add(new Result(us.getName(), d.getDate(), points));
               }

               repository.setResults(results);
               repository.save();
           }
           for (User user :
                   all1) {
               List<Result> all2 = repository.getAll();
               points = 0;
               for (Result r :
                       all2) {

                   if ( r.getName().equals(user.getName()) ) {
                       points += r.getScore();
                   }
               }
               user.getMyTeam().setScore(points);
           }
           userRepository.setUsers(all1);
           userRepository.save();
       }
       else{
           AllSportsApi api = new AllSportsApi();

           try {
               api.toUpdate();
           } catch (IOException e) {
               e.printStackTrace();
           }
           Fixture fixture = new Fixture();
           fixture.doFixture();
           fixture.setDate();
           fixtureRepository.setFixture(fixture);
           boolean save = fixtureRepository.save();
           if (save) {
               System.out.println("se ha actualizado");
           }
       }
   }

   public void menuMain() {
        preProccesor();
        int s;
        int opcion=-1; //Guardaremos la opcion del usuario
        System.out.println("Gran DT Masters");
        System.out.println("1. Ingresar");
        System.out.println("2. Registrarse");
        System.out.println("3. Salir");


        try{
            opcion = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Debe ingresar un numero de opcion valida");
            scanner.nextLine();
        }

            scanner.reset();
            switch (opcion) {
                case 1:
                    System.out.println("Ingreso");
                    login();

                    break;
                case 2:
                    System.out.println("Registro");
                    regist();
                    menuMain();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nIngrese una opcion valida");
                    menuMain();
            }


    }

    ///Login
    private void login() {

        User u1 = new User();
        System.out.println("\nIngresar usuario ");
        scanner.skip("\n");
        String userName = scanner.nextLine();
        if(!new User().browsUser(userName)) {
            System.out.println("\nIngresar password ");
            String password =scanner.nextLine();
            u1 = u1.login(userName,
                    password);
            if (u1!= null) {
                System.out.println("\nSu usuario se ha conectado correctamente\n");
                UserMenu uMenu = new UserMenu(u1);
                uMenu.menu();
            } else {
                System.out.println("\nUsuario o password incorrecto. Volviendo al menu principal.\n");
                this.menuMain();
            }
        }
        else {
            if(userName.equalsIgnoreCase("admin")){
                System.out.println("\nIngresar password de admin");
                String password = scanner.nextLine();
                if (password.equalsIgnoreCase("admin")) {
                    new AdminMenu().menu();
                } else {
                    menuMain();
                }
            }
            else {
                System.out.println("Ese usuario no esta registrado");
                System.out.println("Desea registrarse ?Y/N");
                char c = scanner.next().charAt(0);
                if (c == 'y' || c == 'Y') {
                    regist();
                } else {
                    menuMain();
                }
            }
        }
    }

    ///Registro
    private void regist() {
        User u1 = new User();
        System.out.println("\nIngresar nombre de usuario");
        scanner.skip("\n");
        String nameUser = scanner.nextLine();
        if (u1.browsUser(nameUser)) {
            System.out.println("\nIngresar nombre ");
            String name = scanner.nextLine();
            System.out.println("\nIngresar apellido ");
            String surname = scanner.nextLine();
            System.out.println("\nIngresar password ");
            String password = scanner.nextLine();
            System.out.println("\nIngresar mail ");
            String mail = scanner.nextLine();
            System.out.println("\nIngresar nro telefonico ");
            int phone = scanner.nextInt();
            User u2 = new User(nameUser, password, name, surname, mail, phone);
            u2.register(u2);
            System.out.println("\nUsuario registrado correctamente\n\n");
            //char c = scanner.next().charAt(0);
            //if (c == 'y' || c == 'Y') {
            menuMain();
            }
        }
    }


