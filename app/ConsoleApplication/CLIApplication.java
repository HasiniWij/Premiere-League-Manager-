package ConsoleApplication;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class    CLIApplication {
    private static  PremierLeagueManager premierLeagueManager=PremierLeagueManager.getInstance();

    public static void main(String[] args) {
        menu:
        while(true){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter 1 to add a club\nEnter 2 to relegate a club\nEnter 3 to get statistics of a club\n" +
                    "Enter 4 to get the Premier League Table\nEnter 5 to add a match\nEnter 6 to Quit " );
            int choice;
            try {
                choice = sc.nextInt();
                switch (choice){
                    case(1):
                        addClub();
                        break;
                    case(2):
                        deleteClub();
                        break;
                    case(3):
                        getStatistic();
                        break;
                    case(4):
                        displayTable();
                        break;
                    case(5):
                        addMatch();
                        break;
                    case(6):
                        break menu;
                    default:
                        System.out.println("Invalid Option Please choose a option given bellow");
                        break;
                }
            } catch (InputMismatchException e){
                sc.next();
                System.out.println("Invalid Option Please choose a option given bellow");
            }
        }
    }

    private static void displayTable() {
//      loaded from file before the methods because GUI application may run at the same time
//        this prevent from the file getting overridden if changes
        premierLeagueManager.loadFile((new File("../files/premierLeagueFile.txt")));
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-37s %-7s %-7s %-7s %-7s %-7s %-7s %-7s %-7s\n", "Position","Club","Played","won","Drawn","Lost","GF","GA","GD","Points");

        System.out.println("\n-------------------------------------------------------------------------------------------------------------------");
        int count=1;

        for(FootballClub club:  premierLeagueManager.displayLeagueTable()){

            System.out.format("%-10s  %-37s %-7s %-7s %-7s %-7s %-7s %-7s %-7s %-7s\n",count,club.getName(),club.getNumOfMatchesPlayed(),
                    club.getNumOfWins(),club.getNumOfDraws(),club.getNumOfDefeats(),club.getNumGoalsFor(),
                    club.getNumGoalsAgainst(),club.getGoalDifference(),club.getNumOfPoints()+"\n");
            count++;
        }

        System.out.println("\n-------------------------------------------------------------------------------------------------------------------");
    }

    private static void getStatistic() {
        premierLeagueManager.loadFile((new File("../files/premierLeagueFile.txt")));
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the name of the club ");
        System.out.println(premierLeagueManager.displayClubStatistics(sc.nextLine().toLowerCase()));
    }

    private static void deleteClub() {
        premierLeagueManager.loadFile(new File("../files/premierLeagueFile.txt"));
        FootballClub removingClub = null;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the name of the club ");
        String clubName=sc.nextLine().toLowerCase();

        for(FootballClub club : premierLeagueManager.getPremierClubs()){
            if (club.getName().equals(clubName)){
                removingClub=club;
            }
        }

        if (removingClub!=null){
            System.out.println( "Are you sure you want to relegate this club(y/n)?\n"+removingClub.toString());
            String choice=sc.nextLine().toLowerCase();

//            only y, n,Y,N are taken as a user choice
            while(!choice.equals("y") && !choice.equals("n")){
                System.out.println("Wrong input, please enter y or n");
                choice=sc.nextLine();
            }
            if(choice.equals("y")) {
                System.out.println(premierLeagueManager.deleteClub(clubName));
                premierLeagueManager.saveFile((new File("../files/premierLeagueFile.txt")));
            }
        }
        else System.out.println("Club not found");
    }


    private static void addClub() {
        premierLeagueManager.loadFile((new File("../files/premierLeagueFile.txt")));
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the name of the club ");
        String name=sc.nextLine().trim();
        System.out.println("Enter the location");
        String location=sc.nextLine().trim();
        System.out.println(premierLeagueManager.createClub(name,location));
        premierLeagueManager.saveFile((new File("../files/premierLeagueFile.txt")));

    }
    private static void addMatch(){
        premierLeagueManager.loadFile((new File("../files/premierLeagueFile.txt")));

//      at least 2 clubs must be in premier League for a match
        if (premierLeagueManager.getPremierClubs().size()>=2){
            Scanner sc=new Scanner(System.in);

            System.out.println("Enter the name of 1st club ");
            String clubAName=sc.nextLine().toLowerCase();

            System.out.println("Enter the name of 2nd club ");
            String clubBName=sc.nextLine().toLowerCase();
            List <String> names=new ArrayList<>( );
            for(FootballClub club : premierLeagueManager.getPremierClubs()){
               names.add(club.getName()) ;
            }
            if(names.contains(clubAName)&& names.contains(clubBName)){

                try {
                    System.out.println("Enter the number of goals of 1st club");
                    int clubAGoal = sc.nextInt();
                    System.out.println("Enter the number of goals of 2nd club");
                    int clubBGoal = sc.nextInt();

                    System.out.println("Enter the day");
                    int day = sc.nextInt();
                    System.out.println("Enter the Month");
                    int month = sc.nextInt();
                    System.out.println("Enter the year");
                    int year = sc.nextInt();


                    LocalDate date = LocalDate.of(year, month, day);
                    System.out.println(premierLeagueManager.addMatch(clubAName, clubBName, clubAGoal, clubBGoal, date));
                    premierLeagueManager.saveFile((new File("../files/premierLeagueFile.txt")));

                } catch (InputMismatchException e) {
                    //if the user enter a character as integer
                    System.out.println("Invalid information entered");

                } catch (java.time.DateTimeException e) {
                    System.out.println("Invalid date entered");
                }
            }else {System.out.println("Invalid Club names");}
        }else System.out.println("please add 2 or more clubs to the premier league");
    }
}





