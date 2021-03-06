package com.company.model;

import com.company.repository.UserRepository;

import java.util.List;

public class User implements Comparable<User>{
    private String userName;
    private String password;
    private String name;
    private String surname;
    private String email;
    private int phone;
    private MyTeam myTeam;

    public User(String userName, String password, String name, String surname, String email, int phone) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.myTeam=new MyTeam();
    }

    public User() {
        this.myTeam=new MyTeam();
    }

    public User login(String userName, String password) {
        UserRepository userRepository = new UserRepository();
        User userLogin = null;
        List<User> all = userRepository.getAll();
        if (all==null) {
            return null;
        }
        for (User user :
                all) {
            if (user.getUserName().equalsIgnoreCase(userName)) {
                userLogin = user;
            }
        }
        if (userLogin != null) {
            return userLogin.getPassword().equals(password)?userLogin:null;

        } else {
            return null;
        }
    }

    public boolean browsUser(String userName) {
        UserRepository userRepository = new UserRepository();
        User userBrows;
        List<User> all = userRepository.getAll();
        if (all==null) {
            return true;
        }
        for (User user :
                all) {
            if (user.getUserName().equalsIgnoreCase(userName)) {
                userBrows = user;
                return false;
            }
        }
        return true;
    }


    public void register(User user) {
        UserRepository userRepository = new UserRepository();
        userRepository.add(user);

    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public MyTeam getMyTeam() {
        return myTeam;
    }

    public void setMyTeam(MyTeam myTeam) {
        this.myTeam = myTeam;
    }

    @Override
    public String toString() {
        return "\nUser{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", myTeam=" + myTeam +
                '}';
    }

    @Override
    public int compareTo(User u) {
        int result=0;
        if(this.getMyTeam().getScore()>u.getMyTeam().getScore())
            result=-1;
        else if(this.getMyTeam().getScore()<u.getMyTeam().getScore())
        {
            result=1;
        }
        return result;
    }
}
