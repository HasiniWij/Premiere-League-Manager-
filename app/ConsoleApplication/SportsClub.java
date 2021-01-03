package ConsoleApplication;

import java.io.Serializable;
import java.util.Objects;

public abstract class SportsClub implements Serializable {
    private String name;
    private String location;
    private int numOfDefeats;
    private int numOfWins;
    private int numOfDraws;

    public SportsClub(String name, String location){
        this.name=name;
        this.location=location;
    }
    public SportsClub(String name){
        this.name=name;
    }

    public void setName(String name){
        this.name=name;
    }
    public void setLocation(String location){
        this.location=location;
    }
    public void setNumOfDefeats(int numberOfDefeats){
        this.numOfDefeats =numberOfDefeats;
    }
    public void setNumOfWins(int numberOfWins){
        this.numOfWins =numberOfWins;
    }
    public void setNumOfDraws(int numberOfDraws){
        this.numOfDraws =numberOfDraws;
    }

    public String getName(){
        return name;
    }
    public String getLocation(){
        return location;
    }
    public int getNumOfDefeats(){
        return numOfDefeats;
    }
    public int getNumOfWins(){
        return numOfWins;
    }
    public int getNumOfDraws(){
        return numOfDraws;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SportsClub that = (SportsClub) o;
        return numOfDefeats == that.numOfDefeats &&
                numOfWins == that.numOfWins &&
                numOfDraws == that.numOfDraws &&
                Objects.equals(name, that.name) &&
                Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, numOfDefeats, numOfWins, numOfDraws);
    }

    @Override
    public String toString() {
        return  "name=" + name +
                ", location=" + location +
                ", numberOfDefeats=" + numOfDefeats +
                ", numberOfWins=" + numOfWins +
                ", numberOfDraws=" + numOfDraws +", ";
    }
}