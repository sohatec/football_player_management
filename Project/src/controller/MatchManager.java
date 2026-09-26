
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
import util.Menu;
public class MatchManager {
    
    private final Scanner sc = new Scanner(System.in);
    
    // Tạo biến và hàm nhận data, để xài và truy cập vào data chung
    // Nếu private final DataManager data = new DataManager(); thì khi gọi
    // nó sẽ tạo mới và không truy cập vào data chung được
    private final DataManager dm;
    public MatchManager(DataManager dm){
        this.dm = dm;
    }

// ALL FUNCTION OF MATCH ///////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    
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
    
    // Search match by ID
    public void searchMatchId(){
        System.out.print("Input match ID: ");
        String id = sc.nextLine();
        boolean found = false;
        Menu.header5();
        for(MatchRecord m : dm.listMatch()){
            if(m.getMatchId().equals(id)){
                System.out.println(m.toString());
                found = true;
            }
        }
        if(!found) System.out.println("Not found !!!");
    }
    
    // Search match by date
    public void searchMatchDate(){
        LocalDate date = inputDate();
        boolean found = false;
        Menu.header5();
        for(MatchRecord m : dm.listMatch()){
            if(m.getDate().equals(date)){
                System.out.println(m.toString());
                found = true;
            }
        }
        if(!found) System.out.println("Not found !!!");
    }
    
    // Search match by opponent team
    public void searchMatchOpponent(){
        String oppo = inputOpponentTeam();
        boolean found = false;
        Menu.header5();
        for(MatchRecord m : dm.listMatch()){
            if(m.getOpponentTeam().equals(oppo)){
                System.out.println(m.toString());
                found = true;
            }
        }
        if(!found) System.out.println("Not found !!!");
    }
    
    // Search match by match type
    public void searchMatchType(){
        String type = inputMatchType();
        boolean found = false;
        Menu.header5();
        for(MatchRecord m : dm.listMatch()){
            if(m.getMatchType().equals(type)){
                System.out.println(m.toString());
                found = true;
            }
        }
        if(!found) System.out.println("Not found !!!");
    }
    
    // Update match date
    public void updateMatchDate(){
        System.out.print("Input match ID to update: ");
        String id = sc.nextLine().trim();
        boolean found = false;
        for(MatchRecord m : dm.listMatch()){
            if(m.getMatchId().equalsIgnoreCase(id)){
                m.setDate(inputDate());
                System.out.println("Update date successfully!");
                found = true;
                break;
            }
        }
        if(!found) System.out.println("Match ID not found !!!");
    }
    
    // Update match opponent team
    public void updateMatchOpponent(){
        System.out.print("Input match ID to update: ");
        String id = sc.nextLine().trim();
        boolean found = false;
        for(MatchRecord m : dm.listMatch()){
            if(m.getMatchId().equalsIgnoreCase(id)){
                m.setOpponentTeam(inputOpponentTeam());
                System.out.println("Update opponent team successfully!");
                found = true;
                break;
            }
        }
        if(!found) System.out.println("Match ID not found !!!");
    }
    
    // Update match type
    public void updateMatchType(){
        System.out.print("Input match ID to update: ");
        String id = sc.nextLine().trim();
        boolean found = false;
        for(MatchRecord m : dm.listMatch()){
            if(m.getMatchId().equalsIgnoreCase(id)){
                m.setMatchType(inputMatchType());
                System.out.println("Update match type successfully!");
                found = true;
                break;
            }
        }
        if(!found) System.out.println("Match ID not found !!!");
    }
    
    // Display all match record
    public void displayAllMatch(){
        if(dm.listMatch() == null || dm.listMatch().isEmpty()) {
            System.out.println("No match records available.");
            return;
        }
        Menu.header5();
        for(MatchRecord m : dm.listMatch()){
            System.out.println(m.toString());
        }
    }
    
// ALL FUNCTION OF PERFORMANCE /////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    
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
            }catch(NumberFormatException e){System.out.println(e.getMessage());}
        }
    }
    
    // Input red card
    public int inputRedCard(){
        while(true){
            try{
                System.out.print("Input number of red card: ");
                int red = Integer.parseInt(sc.nextLine());
                if(red >= 0) return red;
            }catch(NumberFormatException e){System.out.println(e.getMessage());}
        }
    }
    
    // Input yellow card
    public int inputYellowCard(){
        while(true){
            try{
                System.out.print("Input number of yellow card: ");
                int yellow = Integer.parseInt(sc.nextLine());
                if(yellow >= 0) return yellow;
            }catch(NumberFormatException e){System.out.println(e.getMessage());}
        }
    }
    
    // Input assist
    public int inputAssist(){
        while(true){
            try{
                System.out.print("Input number of assist: ");
                int assist = Integer.parseInt(sc.nextLine());
                if(assist >= 0) return assist;
            }catch(NumberFormatException e){System.out.println(e.getMessage());}
        }
    }
    
    // Input goal
    public int inputGoal(){
        while(true){
            try{
                System.out.print("Input number of goal: ");
                int goal = Integer.parseInt(sc.nextLine());
                if(goal >= 0) return goal;
            }catch(NumberFormatException e){System.out.println(e.getMessage());}
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
            if(id.substring(0, 2).equals("RG")){
                for(RegularPlayer rg : dm.listRegular()){
                    if(rg.getPlayerId().equals(id)) return id;
                }
            }else if(id.substring(0, 2).equals("ST")){
                for(StarPlayer st : dm.listStar()){
                    if(st.getPlayerId().equals(id)) return id;
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
        for(PerformanceRecord pfm : ma.getPerformances()){
            if(pfm.getPlayerId().equals(playerId))
                System.out.println(pfm.toString());
        }
    }
    
    // Updating performance goal
    public void updateGoal(){
        MatchRecord ma = getMatchRecord();
        String playerId = inputPlayerId();
        for(PerformanceRecord pfm : ma.getPerformances()){
            if(pfm.getPlayerId().equals(playerId))
                pfm.setGoals(inputGoal());
        }
    }
    
    // Updating performance assist
    public void updateAssist(){
        MatchRecord ma = getMatchRecord();
        String playerId = inputPlayerId();
        for(PerformanceRecord pfm : ma.getPerformances()){
            if(pfm.getPlayerId().equals(playerId))
                pfm.setAssist(inputAssist());
        }
    }
    
    // Updating performance yellow card
    public void updateYellow(){
        MatchRecord ma = getMatchRecord();
        String playerId = inputPlayerId();
        for(PerformanceRecord pfm : ma.getPerformances()){
            if(pfm.getPlayerId().equals(playerId))
                pfm.setYellowCard(inputYellowCard());
        }
    }
    
    // Updating performance red card
    public void updateRed(){
        MatchRecord ma = getMatchRecord();
        String playerId = inputPlayerId();
        for(PerformanceRecord pfm : ma.getPerformances()){
            if(pfm.getPlayerId().equals(playerId))
                pfm.setRedCard(inputRedCard());
        }
    }
    
    // Updating performance minutes player
    public void updateminutes(){
        MatchRecord ma = getMatchRecord();
        String playerId = inputPlayerId();
        for(PerformanceRecord pfm : ma.getPerformances()){
            if(pfm.getPlayerId().equals(playerId))
                pfm.setMinutesPlayer(inputMinutesPlayer());
        }
    }
    
    // Dispaly all performance in a match
    public void displayAllPerformance(){
        MatchRecord ma = getMatchRecord();
        Menu.header6();
        for(PerformanceRecord pfm : ma.getPerformances()){
            System.out.println(pfm.toString());
        }
    }
}
