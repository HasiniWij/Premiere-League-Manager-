package controllers;

import ConsoleApplication.*;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.mvc.*;

import java.io.File;
import java.time.LocalDate;
import java.util.List;


public class PremierLeagueController extends Controller {

    private static PremierLeagueManager premierLeagueManager= PremierLeagueManager.getInstance();


    public Result matchForDate(String date) {
        LocalDate localDate = LocalDate.parse(date);
        premierLeagueManager.loadFile(new File("app\\files\\premierLeagueFile.txt"));
        List <Match>matches=premierLeagueManager.findMatchInDate(localDate);
        JsonNode jsonNode = Json.toJson(matches);
        return ok(jsonNode).as("application/json");
    }

    public Result viewTable(){
       premierLeagueManager.loadFile(new File("app\\files\\premierLeagueFile.txt"));
       List <FootballClub>clubs=premierLeagueManager.displayLeagueTable();
        JsonNode jsonNode = Json.toJson( clubs);
        return ok(jsonNode).as("application/json");
    }
    public Result clubByWin(){
        premierLeagueManager.loadFile(new File("app\\files\\premierLeagueFile.txt"));
        List <FootballClub>clubs=premierLeagueManager.displayLeagueTable();
        clubs.sort(new SortByWin().reversed());
        JsonNode jsonNode = Json.toJson( clubs);
        return ok(jsonNode).as("application/json");

    }

    public Result clubByGoal(){
        premierLeagueManager.loadFile(new File("app\\files\\premierLeagueFile.txt"));
        List <FootballClub>clubs=premierLeagueManager.displayLeagueTable();
        clubs.sort(new SortByGoal().reversed());
        JsonNode jsonNode = Json.toJson( clubs);
        return ok(jsonNode).as("application/json");

    }
    public Result viewMatch(){
        premierLeagueManager.loadFile(new File("app\\files\\premierLeagueFile.txt"));
        List <Match>matches=premierLeagueManager.getMatches();
        JsonNode jsonNode = Json.toJson(matches);
        return ok(jsonNode).as("application/json");
    }
    public Result generateMatch(){
        premierLeagueManager.loadFile(new File("app\\files\\premierLeagueFile.txt"));
        String match=premierLeagueManager.generateMatch();
        premierLeagueManager.saveFile(new File("app\\files\\premierLeagueFile.txt"));
        JsonNode jsonNode = Json.toJson( match);
        return ok(jsonNode).as("application/json");
    }
}
