package controller;
import data.DataManager;
import entity.*;
import java.util.List;

public class SalaryManager {

    // Declare a variable and a method to receive and access the shared data.
    // Initializing with "private final DataManager data = new DataManager();"
    // will create a new object, preventing access to the shared instance.
    private final DataManager dm;

    public SalaryManager(DataManager dm){
        this.dm = dm;
    }

    // Search Player by ID in shared list (No use empty object)
    private <T extends Player> T findPlayer(String playerId, List<T> list){
        for(T p : list) {
            if (p.getPlayerId().equals(playerId))
                return p;
        }
        return null;
    }

    // Total points in month
    public int totalPointsMonth(String playerId, int month, int year){
        int totalPoints = 0;
        for(MatchRecord m : dm.listMatch()){
            if(m.getDate().getYear() == year && m.getDate().getMonthValue() == month){
                for(PerformanceRecord p : m.getPerformances()){
                    if(p.getPlayerId().equals(playerId))
                        totalPoints += p.totalPoints();
                }
            }
        }
        return totalPoints;
    }

    // Total points in year
    public int totalPointsYear(String playerId, int year){
        int totalPoints = 0;
        for(MatchRecord m : dm.listMatch()){
            if(m.getDate().getYear() == year){
                for(PerformanceRecord p : m.getPerformances()){
                    if(p.getPlayerId().equals(playerId))
                        totalPoints += p.totalPoints();
                }
            }
        }
        return totalPoints;
    }

    // Regular salary month
    public <T extends Player> double salaryMonth(String playerId,int month, int year, List<T> list){
        T p = findPlayer(playerId, list);
        if(p == null){
            System.out.println("Regular Player ID not found !!!");
            return 0;
        }
        return p.salaryMonth(totalPointsMonth(playerId, month, year));
    }

    // Regular salary year
    public <T extends Player> double salaryYear(String playerId, int year, List<T> list){
        T p = findPlayer(playerId, list);
        if(p == null){
            System.out.println("Regular Player ID not found !!!");
            return 0;
        }
        return p.salaryYear(totalPointsYear(playerId, year));
    }
}