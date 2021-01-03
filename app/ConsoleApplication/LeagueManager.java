package ConsoleApplication;
import java.io.File;
import java.time.LocalDate;

interface LeagueManager{
    String createClub(String name, String location);
    String deleteClub(String name);
    String displayClubStatistics(String name);
    String addMatch(String clubAName, String clubBName, int clubAGoal, int clubBGoal, LocalDate date);
    void loadFile(File file);
    void saveFile(File file);

}