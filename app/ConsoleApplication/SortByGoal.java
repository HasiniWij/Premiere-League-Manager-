package ConsoleApplication;

import java.util.Comparator;

public class SortByGoal implements Comparator<FootballClub> {
    @Override
    public int compare(FootballClub clubA, FootballClub clubB) {
        return clubA.getNumGoalsFor() - clubB.getNumGoalsFor();
    }
}








