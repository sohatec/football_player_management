package entity;

import java.io.Serializable;

public abstract class Player implements Serializable{
    private static final long CCCD = 111L;
    
    private String playerId;
    private String name;
    private int age;
    private String national;
    private String position;
    private int shirtNumber;
    private double baseSalary;
    private String status;

    public Player() {
    }

    public Player(String playerId, String name, int age, String national,
                  String position, int shirtNumber, double baseSalary, 
                  String status){
        setPlayerId(playerId);
        setName(name);
        setAge(age);
        setNational(national);
        setPosition(position);
        setShirtNumber(shirtNumber);
        setBaseSalary(baseSalary);
        setStatus(status);
    }

    public String getPlayerId() {
        return playerId;
    }

    public final void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public final void setAge(int age) {
        this.age = age;
    }

    public String getNational() {
        return national;
    }

    public final void setNational(String national) {
        this.national = national;
    }

    public String getPosition() {
        return position;
    }

    public final void setPosition(String position) {
        this.position = position;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public final void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public final void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getStatus() {
        return status;
    }

    public final void setStatus(String status) {
        this.status = status;
    }

    public abstract String displayListOfPlayer();
    
    public abstract double salaryMonth(int totalPointsMonth);
    
    public abstract double salaryYear(int totalPointsYear);
    
    public abstract double bonusMonth(int totalPointsMonth);
    
    public abstract double bonusYear(int totalPointsYear);
}