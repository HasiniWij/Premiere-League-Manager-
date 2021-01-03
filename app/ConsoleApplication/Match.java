package ConsoleApplication;

import java.io.Serializable;
import java.time.LocalDate;


public class Match implements Serializable,Comparable<Match> {
    private FootballClub clubA;
    private FootballClub clubB;
    private int clubAGoal;
    private int clubBGoal;
    private LocalDate date;


    public SportsClub getClubA() {
        return clubA;
    }

    public SportsClub getClubB() {
        return clubB;
    }

    public int getClubAGoal() {
        return clubAGoal;
    }

    public int getClubBGoal() {
        return clubBGoal;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setClubA(FootballClub clubA) {
        this.clubA = clubA;
    }

    public void setClubB(FootballClub clubB) {
        this.clubB = clubB;
    }

    public void setClubAGoal(int clubAGoal) {
        this.clubAGoal = clubAGoal;
    }

    public void setClubBGoal(int clubBGoal) {
        this.clubBGoal = clubBGoal;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return  date+" :    "+ clubA.getName() +" "+clubAGoal+" -  "+clubBGoal+" "+clubB.getName();
    }

    public Match(FootballClub clubA, FootballClub clubB, int clubAGoal, int clubBGoal, LocalDate date) {
        this.clubA = clubA;
        this.clubB = clubB;
        this.clubAGoal = clubAGoal;
        this.clubBGoal = clubBGoal;
        this.date = date;
    }

    @Override
    public int compareTo(Match match) {
        return this.getDate().compareTo(match.getDate());
    }
}