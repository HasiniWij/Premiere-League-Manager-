package ConsoleApplication;

import java.io.Serializable;
import java.util.Objects;

public class FootballClub extends SportsClub implements Comparable<FootballClub>, Serializable {

    private int numGoalsFor;
    private int numGoalsAgainst;
    private int numOfPoints;
    private int numOfMatchesPlayed;

    public FootballClub(String name, String location){
        super(name, location);
    }

    public void setNumGoalsFor(int numGoalsFor) { this.numGoalsFor = numGoalsFor;  }

    public void setNumGoalsAgainst(int numGoalsAgainst) {
        this.numGoalsAgainst = numGoalsAgainst;
    }

    public void setNumOfPoints(int numOfPoints) {
        this.numOfPoints = numOfPoints;
    }

    public void setNumOfMatchesPlayed(int numOfMatchesPlayed) {
        this.numOfMatchesPlayed = numOfMatchesPlayed;
    }


    public int getNumGoalsFor() {
        return numGoalsFor;
    }

    public int getNumGoalsAgainst() {
        return numGoalsAgainst;
    }

    public int getNumOfPoints() {
        return numOfPoints;
    }

    public int getNumOfMatchesPlayed() {
        return numOfMatchesPlayed;
    }

    public int getGoalDifference(){
        return  numGoalsFor- numGoalsAgainst;
    }

    @Override
    public int compareTo(FootballClub club) {

        int value= this.numOfPoints-club.numOfPoints;

        if (!(value ==0)) return value;

        return this.getGoalDifference()-club.getGoalDifference();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FootballClub club = (FootballClub) o;
        return numGoalsFor == club.numGoalsFor &&
                numGoalsAgainst == club.numGoalsAgainst &&
                numOfPoints == club.numOfPoints &&
                numOfMatchesPlayed == club.numOfMatchesPlayed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numGoalsFor, numGoalsAgainst, numOfPoints, numOfMatchesPlayed);
    }

    @Override
    public String toString() {
        return  super.toString()+" numGoalsFor= " + numGoalsFor +
                ", numGoalsAgainst= " + numGoalsAgainst +
                ", numOfPoints= " + numOfPoints +
                ", numOfMatchesPlayed= " + numOfMatchesPlayed;
    }


}