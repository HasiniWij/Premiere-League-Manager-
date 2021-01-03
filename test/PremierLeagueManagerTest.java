import ConsoleApplication.PremierLeagueManager;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class PremierLeagueManagerTest {
    PremierLeagueManager manager = PremierLeagueManager.getInstance();


    @Test
    void testCreateClub() {
        int expected = manager.getPremierClubs().size() + 1;
        manager.createClub("everton", "uk");
        manager.createClub("everton", "uk");
        assertEquals(expected, manager.getPremierClubs().size());
    }

    @Test
    void testDeleteClub() {
        manager.createClub("aston", "abc stadium");
        int expected = manager.getPremierClubs().size() - 1;
        manager.deleteClub("aston");
        manager.deleteClub("abc");
        assertEquals(expected, manager.getPremierClubs().size());
    }

    @Test
    void testAddMatch() {
        LocalDate localDate = LocalDate.of(2020, 3, 20);
        manager.createClub("fulham", "uk");
        manager.createClub("southampton", "uk");
        int expected = manager.getMatches().size() + 1;
        manager.addMatch("fulham", "southampton", 2, 3, localDate);
        manager.addMatch("abc", "southampton", 2, 3, localDate);
        assertEquals(expected, manager.getMatches().size());
    }

    @Test
    void testGenerateMatch() {
        manager.generateMatch();
        manager.createClub("manchester city", "uk");
        manager.createClub("manchester united", "uk");
        int expected = manager.getMatches().size() + 1;
        manager.generateMatch();
        assertEquals(expected, manager.getMatches().size());
    }

    @Test
    void testFindMatchInDate() {
        LocalDate localDate1 = LocalDate.of(2020, 3, 20);
        LocalDate localDate2 = LocalDate.of(2019, 3, 10);
        manager.createClub("burnly", "uk");
        manager.createClub("crystal palace", "uk");
        manager.addMatch("burnly", "crystal palace", 2, 4, localDate1);
        manager.addMatch("burnly", "crystal palace", 3, 3, localDate2);
        manager.addMatch("burnly", "crystal palace", 4, 2, localDate2);
        assertEquals(2, manager.findMatchInDate(localDate2).size());
    }

    @Test
    void testSaveLoadFile(){
        manager.saveFile(new File("prTest.txt"));
        manager.loadFile(new File("prTest.txt"));
    }

}

