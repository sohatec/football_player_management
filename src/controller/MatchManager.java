package controller;
import data.DataManager;
import entity.MatchRecord;
import entity.PerformanceRecord;
import entity.RegularPlayer;
import entity.StarPlayer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.function.DoubleToIntFunction;
import java.util.function.Predicate;

import util.Menu;
public class MatchManager {

    private final Scanner sc = new Scanner(System.in);

    // Declare a variable and a method to receive and access the shared data.
    // Initializing with "private final DataManager data = new DataManager();"
    // will create a new object, preventing access to the shared instance.
    private final DataManager dm;
    public MatchManager(DataManager dm){
        this.dm = dm;
    }

// ALL FUNCTION OF MATCH ///////////////////////////////////////////////////////
    // Create match record
    public void createMatch(){
        String id = autoId();
        LocalDate date = inputDate();
        String opponent = inputOpponentTeam();
        String matchType = inputMatchType();
        dm.listMatch().add(new MatchRecord(id, date, opponent, matchType));
    }

    // Input match type
    public String inputMatchType(){
        int no;
        while(true){
            try{
                Menu.menuMatchType();
                no = Integer.parseInt(sc.nextLine());
                if(no == 1) return "Friendly";
                if(no == 2) return "League";
                if(no == 3) return "Cup";
                System.out.println("Invalid Only 1-3");
            }catch(NumberFormatException e){
                System.out.println("Input Only 1-3");
            }
        }
    }

    // Input opponent team
    public String inputOpponentTeam(){
        System.out.print("Input opponent team: ");
        return sc.nextLine();
    }

    // Input date
    public LocalDate inputDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            System.out.print("Input date dd/MM/yyyy: ");
            String input = sc.nextLine().trim();
            try {
                LocalDate date = LocalDate.parse(input, formatter);
                if (date.getYear() >= 2000 && date.getYear() <= 2100)
                    return date;
                else System.out.println("Year is between 2000 and 2100! Please try again.");
            }catch (DateTimeParseException e) {
                System.out.println("Format invalid !!!");
            }
        }
    }

    // ID auto
    public String autoId(){
        if(dm.listMatch() == null || dm.listMatch().isEmpty())
            return String.format("%s%04d", "MA", 1);
        MatchRecord lastMatch = dm.listMatch().get(dm.listMatch().size() - 1);
        int lastNo = Integer.parseInt(lastMatch.getMatchId().substring(2));
        return String.format("%s%04d", "MA", lastNo + 1);
    }

    // This function support for search function
    private void searchMatchByCondition(Predicate<MatchRecord> condition) {
        boolean found = false;
        Menu.header5();
        for (MatchRecord m : dm.listMatch()) {
            if (condition.test(m)) {
                System.out.println(m.toString());
                found = true;
            }
        }
        if (!found)
            System.out.println("Not found !!!");
    }

    // Search match by ID
    public void searchMatchId() {
        System.out.print("Input match ID: ");
        String id = sc.nextLine().trim();
        searchMatchByCondition(m -> m.getMatchId().equalsIgnoreCase(id));
    }

    // Search match by date
    public void searchMatchDate() {
        LocalDate date = inputDate();
        searchMatchByCondition(m -> m.getDate().equals(date));
    }

    // Search match by opponent team
    public void searchMatchOpponent() {
        String oppo = inputOpponentTeam();
        searchMatchByCondition(m -> m.getOpponentTeam().equalsIgnoreCase(oppo));
    }

    // Search match by match type
    public void searchMatchType() {
        String type = inputMatchType();
        searchMatchByCondition(m -> m.getMatchType().equalsIgnoreCase(type));
    }

    public MatchRecord findMatchToUpdate(){
        System.out.print("Input match ID to update: ");
        String id = sc.nextLine().trim();
        for(MatchRecord m : dm.listMatch()){
            if(m.getMatchId().equalsIgnoreCase(id))
                return m;
        }
        return null;
    }

    // Update match date
    public void updateMatchDate(){
        MatchRecord m = findMatchToUpdate();
        if(m != null){
            m.setDate(inputDate());
            System.out.println("Update date successfully!");
        }else System.out.println("Match ID not found !!!");
    }

    // Update match opponent team
    public void updateMatchOpponent(){
        MatchRecord m = findMatchToUpdate();
        if(m != null){
            m.setOpponentTeam(inputOpponentTeam());
            System.out.println("Update date successfully!");
        }else System.out.println("Match ID not found !!!");
    }

    // Update match type
    public void updateMatchType(){
        MatchRecord m = findMatchToUpdate();
        if(m != null){
            m.setMatchType(inputMatchType());
            System.out.println("Update date successfully!");
        }else System.out.println("Match ID not found !!!");
    }

    // Display all match record
    public void displayAllMatch(){
        if(dm.listMatch() == null || dm.listMatch().isEmpty()) {
            System.out.println("No match records available.");
            return;
        }
        Menu.header5();
        for(MatchRecord m : dm.listMatch())
            System.out.println(m.toString());
    }

// ALL FUNCTION OF PERFORMANCE /////////////////////////////////////////////////
    // Create performance record
    public void createPerformance(){
        MatchRecord match = getMatchRecord();
        String playerId = inputPlayerId();
        int goals = inputGoal();
        int assist = inputAssist();
        int yellowCard = inputYellowCard();
        int redCard = inputRedCard();
        double minutesPlayer = inputMinutesPlayer();
        match.getPerformances().add(new PerformanceRecord(match.getMatchId(),
                playerId, goals, assist, yellowCard, redCard, minutesPlayer));
    }

    // Input minutes player
    public int inputMinutesPlayer(){
        while(true){
            try{
                System.out.print("Input minute player: ");
                int minute = Integer.parseInt(sc.nextLine());
                if(minute >= 0) return minute;
            }catch(NumberFormatException e){
                System.out.println("Input minute player: ");
            }
        }
    }

    // Input red card
    public int inputRedCard(){
        while(true){
            try{
                System.out.print("Input number of red card: ");
                int red = Integer.parseInt(sc.nextLine());
                if(red >= 0) return red;
            }catch(NumberFormatException e){
                System.out.println("Input number of red card: ");
            }
        }
    }

    // Input yellow card
    public int inputYellowCard(){
        while(true){
            try{
                System.out.print("Input number of yellow card: ");
                int yellow = Integer.parseInt(sc.nextLine());
                if(yellow >= 0) return yellow;
            }catch(NumberFormatException e){
                System.out.println("Input number of yellow card: ");
            }
        }
    }

    // Input assist
    public int inputAssist(){
        while(true){
            try{
                System.out.print("Input number of assist: ");
                int assist = Integer.parseInt(sc.nextLine());
                if(assist >= 0) return assist;
            }catch(NumberFormatException e){
                System.out.println("Input number of assist: ");
            }
        }
    }

    // Input goal
    public int inputGoal(){
        while(true){
            try{
                System.out.print("Input number of goal: ");
                int goal = Integer.parseInt(sc.nextLine());
                if(goal >= 0) return goal;
            }catch(NumberFormatException e){
                System.out.println("Input number of goal: ");
            }
        }
    }

    // Input player id
    public String inputPlayerId(){
        while(true){
            System.out.print("Input Player ID: ");
            String id = sc.nextLine().trim();
            if(id.length() < 2){
                System.out.println("ID invalid !");
                continue;
            }
            if(id.startsWith("RG")){
                for(RegularPlayer rg : dm.listRegular()){
                    if(rg.getPlayerId().equals(id))
                        return id;
                }
            }else if(id.startsWith("ST")){
                for(StarPlayer st : dm.listStar()){
                    if(st.getPlayerId().equals(id))
                        return id;
                }
            }
        }
    }

    // Get match record
    public MatchRecord getMatchRecord(){
        while(true){
            System.out.print("Input Match ID: ");
            String id = sc.nextLine().trim();
            for(MatchRecord m : dm.listMatch()){
                if(m.getMatchId().equals(id)) return m;
            }
        }
    }

    // Searching performance follow match and player ID
    public void searchPerformance(){
        MatchRecord ma = getMatchRecord();
        String playerId = inputPlayerId();
        Menu.header6();
        boolean flag = false;
        for(PerformanceRecord pfm : ma.getPerformances()){
            if(pfm.getPlayerId().equals(playerId)) {
                System.out.println(pfm);
                flag = true;
            }
        }
        if(!flag)
            System.out.println("Not found !!!");
    }

    public PerformanceRecord findPerformanceToUpdate(){
        MatchRecord ma = getMatchRecord();
        String playerId = inputPlayerId();
        for(PerformanceRecord pfm : ma.getPerformances()) {
            if (pfm.getPlayerId().equals(playerId))
                return pfm;
        }
        return null;
    }

    // Updating performance goal
    public void updateGoal(){
        PerformanceRecord p = findPerformanceToUpdate();
        if (p != null){
            p.setGoals(inputGoal());
            System.out.println("Update successfully!");
        }else System.out.println("Performance ID not found !!!");
    }

    // Updating performance assist
    public void updateAssist(){
        PerformanceRecord p = findPerformanceToUpdate();
        if (p != null){
            p.setAssist(inputAssist());
            System.out.println("Update successfully!");
        }else System.out.println("Performance ID not found !!!");
    }

    // Updating performance yellow card
    public void updateYellow(){
        PerformanceRecord p = findPerformanceToUpdate();
        if (p != null){
            p.setYellowCard(inputYellowCard());
            System.out.println("Update successfully!");
        }else System.out.println("Performance ID not found !!!");
    }

    // Updating performance red card
    public void updateRed(){
        PerformanceRecord p = findPerformanceToUpdate();
        if (p != null){
            p.setRedCard(inputRedCard());
            System.out.println("Update successfully!");
        }else System.out.println("Performance ID not found !!!");
    }

    // Updating performance minutes player
    public void updateMinutes(){
        PerformanceRecord p = findPerformanceToUpdate();
        if (p != null){
            p.setMinutesPlayer(inputMinutesPlayer());
            System.out.println("Update successfully!");
        }else System.out.println("Performance ID not found !!!");
    }

    // Display all performance in a match
    public void displayAllPerformance(){
        MatchRecord ma = getMatchRecord();
        Menu.header6();
        for(PerformanceRecord pfm : ma.getPerformances())
            System.out.println(pfm.toString());
    }
}