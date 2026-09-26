package entity;

import java.io.Serializable;

public class RegularPlayer extends Player implements Serializable{
    public static final long CCCD = 222L;

    public RegularPlayer() {
    }
    
    public RegularPlayer(String playerId, String name, int age, String national,
                         String position, int shirtNumber, double baseSalary, String status) {
        super(playerId, name, age, national, position, shirtNumber, baseSalary, status);
    }

    @Override
    public String displayListOfPlayer(){
        return String.format("|%-10s|%-30s|%-5d|%-15s|%-12s|%-10d|%15.2f|%10s|", 
            super.getPlayerId(), super.getName(), super.getAge(), super.getNational(), 
            super.getPosition(), super.getShirtNumber(), super.getBaseSalary(), 
            super.getStatus());
    }
    
    @Override
    public double salaryMonth(int totalPointsMonth){
        return super.getBaseSalary() + bonusMonth(totalPointsMonth);
    }
    
    @Override
    public double salaryYear(int totalPointsYear){
        return super.getBaseSalary() * 12 + bonusYear(totalPointsYear);
    }
    
    @Override
    public double bonusMonth(int totalPointsMonth){
        return totalPointsMonth * 0;
    }
            
    @Override
    public double bonusYear(int totalPointsYear){
        return totalPointsYear * 0;
    }
}