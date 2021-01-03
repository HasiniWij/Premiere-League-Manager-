package ConsoleApplication;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PremierLeagueManager implements LeagueManager, Serializable {

    private static PremierLeagueManager manager=null;
    private static final int WIN_POINTS =3;
    private static final int DRAW_POINTS =1;
    private List<Match> matches=new ArrayList<>();


    private List<FootballClub> premierClubs =new ArrayList<>();

    private PremierLeagueManager(){}

    public static PremierLeagueManager getInstance(){
        if (manager==null){
//            Premier league is used and shared by GUIApplication and console Application
            synchronized (PremierLeagueManager.class){
                if(manager==null){
                    manager=new PremierLeagueManager();
                }
            }
        }
        return manager;
    }



    @Override
    public String createClub(String name, String location){
        if(validation(name) || validation(location)) {
            return "Invalid information ";
        }
    //  Premiere League consist of 20 clubs
        if (premierClubs.size()==20) {
            return "20 clubs are already added";
        }
        for (FootballClub club : premierClubs){
            if(club.getName().equals(name)){
                return "The club is already in the premiere league";
            }
        }
        premierClubs.add(new FootballClub(name.toLowerCase(),location.toLowerCase()));
        return name+" club successfully added";
    }


    @Override
    public String deleteClub(String name){

        for (FootballClub club : premierClubs){
            if(club.getName().equals(name)){
                premierClubs.remove(club);
                return name+" removed";
            }
        }
        return "Club not found";
    }

    @Override
    public String addMatch(String clubAName, String clubBName, int clubAGoal, int clubBGoal, LocalDate date){
        if(validation(clubAName )||validation(clubBName)){
            return "Invalid information ";
        }
        if (clubAGoal<0 || clubBGoal<0){
            return "Invalid number of goals entered";
        }
        FootballClub clubA = null;
        FootballClub clubB = null;

        for (FootballClub club : premierClubs)  {
            if (club.getName().equals(clubAName)) {
                clubA=club;
            }
            else if (club.getName().equals(clubBName)) {
                clubB=club;
            }
        }
//        winning points=3
//        draw points = 1
//        Defeat points=0
        if(clubA !=null && clubB !=null) {
            if(clubAGoal>clubBGoal){
                clubA.setNumOfWins(clubA.getNumOfWins()+1);
                clubB.setNumOfDefeats(clubB.getNumOfDefeats()+1);
                clubA.setNumOfPoints(clubA.getNumOfPoints()+ WIN_POINTS);
            }

            else if(clubAGoal==clubBGoal){
                clubA.setNumOfDraws(clubA.getNumOfDraws()+1);
                clubB.setNumOfDraws(clubB.getNumOfDraws()+1);
                clubA.setNumOfPoints(clubA.getNumOfPoints()+ DRAW_POINTS);
                clubB.setNumOfPoints(clubB.getNumOfPoints()+ DRAW_POINTS);
            }
            else{
                clubB.setNumOfWins(clubB.getNumOfWins()+1);
                clubA.setNumOfDefeats(clubA.getNumOfDefeats()+1);
                clubB.setNumOfPoints(clubB.getNumOfPoints()+ WIN_POINTS);
            }
            clubA.setNumGoalsAgainst(clubA.getNumGoalsAgainst()+clubBGoal);
            clubA.setNumGoalsFor(clubA.getNumGoalsFor()+clubAGoal);
            clubA.setNumOfMatchesPlayed(clubA.getNumOfMatchesPlayed()+1);

            clubB.setNumGoalsAgainst(clubB.getNumGoalsAgainst()+clubAGoal);
            clubB.setNumGoalsFor(clubB.getNumGoalsFor()+clubBGoal);
            clubB.setNumOfMatchesPlayed(clubB.getNumOfMatchesPlayed()+1);
            Match match=new Match(clubA,clubB,clubAGoal,clubBGoal,date);
            matches.add(match);
            return match.toString()+" Match successfully updated ";
        }
        else return "Invalid information";
    }

    @Override
    public String displayClubStatistics(String name){
        if(validation(name)){
            return "Invalid information ";
        }
//Goal difference is derived and not a field of FootballClub
        for (FootballClub club : premierClubs){
            if(club.getName().equals(name)){
                return club.toString() +", Goal Difference= "+ club.getGoalDifference();
            }
        }
        return "Club not found";
    }

    public List<FootballClub> displayLeagueTable() {
    //    premier league table must be sorted according to points bu default
        premierClubs.sort(Collections.reverseOrder());
        return getPremierClubs();
    }
    //    check whether a string only contain english letters
    private static boolean validation(String str){return ((str == null) || (!str.matches("^[\\p{L} .'-]+$"))); }

    public List<FootballClub> getPremierClubs(){
        return premierClubs;
    }

    public List<Match> getMatches(){return matches;}

    public String generateMatch() {

        Random rand = new Random();
        if (premierClubs.size()<2){
            return "Please add at least 2 clubs to the premier league ";
        }
//       2 random numbers are used to pick a random index from the list containing the premier league clubs
//       the 2 clubs with those 2 indexes are extracted
        int rand_int1 = rand.nextInt(premierClubs.size());
        int rand_int2 = rand.nextInt(premierClubs.size());
//        make sure tht the same club wont be chosen
        while(rand_int1==rand_int2){
            rand_int1=rand.nextInt(premierClubs.size());
        }

        String club1= premierClubs.get(rand_int1).getName();
        String club2= premierClubs.get(rand_int2).getName();
//      2 random numbers are used to get 2 random goals
//       Generate 2 randoms Goals in range 0 to 9
        return addMatch(club1, club2,rand.nextInt(10),rand.nextInt(10), LocalDate.now());
    }

    public List<Match> findMatchInDate(LocalDate date){
//       the matches played on the specified date are copied to the arrayList macthesOfDates and sent
        List<Match> matchesOfDay=new ArrayList<>();

        for (Match match : matches){
            if(match.getDate().compareTo(date)==0) {
                matchesOfDay.add(match);
            }
        }
        return matchesOfDay;
    }
    @Override
    public void saveFile(File file){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(manager);
        } catch (IOException e) { System.out.println("IO Exception"); }
        finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {System.out.println("IO Exception"); }
        }
    }
    @Override
    public void loadFile(File file){

        FileInputStream fileInputStream= null;
        if(file.exists()){
        try {
            fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            PremierLeagueManager pr=(PremierLeagueManager) objectInputStream.readObject();
            manager.premierClubs=pr.getPremierClubs();
            manager.matches=pr.getMatches();

        } catch (IOException | ClassNotFoundException  e) {
                System.out.println("File with the premierLeagueManager could not be loaded");
        }
        finally {
            try {
                    fileInputStream.close();
            }catch (IOException e) {System.out.println("IO Exception");}
        }
        }

    }
}

