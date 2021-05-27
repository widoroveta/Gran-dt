package com.company.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Match {
    private int id;
    private String nameLocal;
    private String nameVisitor;
    private List<Player> localTeam = new ArrayList<>();
    private List<Player> visitorTeam = new ArrayList<>();
    private Date date;

    public Match() {
    }

    public Match(int id, String nameLocal, String nameVisitor) {
        this.id = id;
        this.nameLocal = nameLocal;
        this.nameVisitor = nameVisitor;

    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", nameLocal='" + nameLocal + '\'' +
                ", nameVisitor='" + nameVisitor + '\'' +
                ", localTeam=" + localTeam +
                ", visitorTeam=" + visitorTeam +
                ", date=" + date +
                '}';
    }

    public int scoreGoals(List<Player> team) {
        int goals = 0;
        for (Player p :
                team) {
            goals += p.getGoals();
        }
        return goals;
    }

    public void assembleMatch() {
        String nameLocal = this.getNameLocal();
        String nameVisitor = this.getNameVisitor();
        this.setLocalTeam(new Club().getTeam(nameLocal));
        this.setVisitorTeam(new Club().getTeam(nameVisitor));
        Player p = mvp();
        pointsPlayers();
        if (scoreGoals(this.visitorTeam) == 0) {
            for (Player player :
                    localTeam) {
                if (player instanceof Goalkeeper) {
                    ((Goalkeeper) player).setWithoutGoals(true);
                }
            }
        }
        if (scoreGoals(this.localTeam) == 0) {
            for (Player player :
                    visitorTeam) {
                if (player instanceof Goalkeeper) {
                    ((Goalkeeper) player).setWithoutGoals(true);
                }
            }
        }
        if (this.getLocalTeam().contains(p)) {
            int b = this.getLocalTeam().indexOf(p);
            this.getLocalTeam().get(b).setMvp(true);
        }
        if (this.getVisitorTeam().contains(p)) {
            int b = this.getVisitorTeam().indexOf(p);
            this.getVisitorTeam().get(b).setMvp(true);
        }
    }

    public Player mvp() {
        List<Player> players = new ArrayList<>();
        players.addAll(this.localTeam);
        players.addAll(this.visitorTeam);
        int random = (int) (Math.random() * ((players.size() - 1) - 1) + 1);
        return players.get(random);
    }

    public void pointsPlayers() {
        for (Player p :
                this.visitorTeam) {
            p.doPoints();

        }
        for(Player p:localTeam)
        {
            p.doPoints();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameLocal() {
        return nameLocal;
    }

    public void setNameLocal(String nameLocal) {
        this.nameLocal = nameLocal;
    }

    public String getNameVisitor() {
        return nameVisitor;
    }

    public void setNameVisitor(String nameVisitor) {
        this.nameVisitor = nameVisitor;
    }

    public List<Player> getLocalTeam() {
        return localTeam;
    }

    public void setLocalTeam(List<Player> localTeam) {
        this.localTeam = localTeam;
    }

    public List<Player> getVisitorTeam() {
        return visitorTeam;
    }

    public void setVisitorTeam(List<Player> visitorTeam) {
        this.visitorTeam = visitorTeam;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
