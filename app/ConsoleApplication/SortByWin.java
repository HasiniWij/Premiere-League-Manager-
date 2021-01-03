package ConsoleApplication;

import java.util.Comparator;

public class SortByWin implements Comparator<FootballClub>{
        @Override
        public int compare(FootballClub clubA, FootballClub clubB) {
            return (clubA.getNumOfWins()-clubB.getNumOfWins());
        }


}
