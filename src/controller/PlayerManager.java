package controller;
import data.DataManager;
import entity.Player;
import entity.RegularPlayer;
import entity.StarPlayer;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import util.Menu;

public class PlayerManager {

    // Declare a variable and a method to receive and access the shared data.
    // Initializing with "private final DataManager data = new DataManager();"
    // will create a new object, preventing access to the shared instance.
    private final DataManager dm;
    private final Scanner sc = new Scanner(System.in);

    public PlayerManager(DataManager dm){
        this.dm = dm;
    }

    // Create Player
    public void createPlayer(int flag){
        String id = (flag == 1) ? autoId(dm.listRegular(), "RG") :  autoId(dm.listStar(), "ST");
        System.out.print("Input Name: ");
        String name =  inputText();
        System.out.print("Input National: ");
        String national = inputText();
        System.out.print("Input Age: ");
        int age = inputAge();
        String position = inputPosition();
        System.out.print("Input Shirt Number: ");
        int shirtNo;
        while(true){
            shirtNo = inputShirtNumber();
            if(isShirtNumberExist(shirtNo))
                System.out.println("Shirt Number Already! Input again.");
            else break;
        }
        System.out.print("Input Salary: ");
        double salary = inputSalary();
        String status = "Active";
        if(flag == 1)
            dm.listRegular().add(new RegularPlayer(id, name, age, national, position, shirtNo, salary, status));
        else
            dm.listStar().add(new StarPlayer(id, name, age, national, position, shirtNo, salary, status));
    }

    // Is Shirt Number Exist
    private boolean isShirtNumberExist(int shirtNo) {
        for (Player p : dm.listRegular())
            if (p.getShirtNumber() == shirtNo)
                return true;
        for (Player p : dm.listStar())
            if (p.getShirtNumber() == shirtNo)
                return true;
        return false;
    }

    // Get Target List
    private List<? extends Player> getTargetList(int flag) {
        return (flag == 1) ? dm.listRegular() : dm.listStar();
    }

    // Execute Search
    private void executeSearch(int flag, Predicate<Player> condition) {
        boolean found = false;
        Menu.header1();
        for (Player p : getTargetList(flag)) {
            if (condition.test(p)) {
                System.out.println(p.displayListOfPlayer());
                found = true;
            }
        }
        if (!found)
            System.out.println("Not found!");
    }

    // Search ID
    public void searchIdPlayer(int flag) {
        System.out.print("Input ID to search: ");
        String text = sc.nextLine().trim();
        executeSearch(flag, p -> p.getPlayerId().equalsIgnoreCase(text));
    }

    // Search Name
    public void searchNamePlayer(int flag) {
        System.out.print("Input Name to search: ");
        String text = sc.nextLine().trim();
        executeSearch(flag, p -> p.getName().toLowerCase().contains(text.toLowerCase())); // Dùng contains tìm cho dễ
    }

    // Search Position
    public void searchPositionPlayer(int flag) {
        System.out.print("Input Position to search: ");
        String text = sc.nextLine().trim();
        executeSearch(flag, p -> p.getPosition().equalsIgnoreCase(text));
    }

    // Search National
    public void searchNationalPlayer(int flag) {
        System.out.print("Input National to search: ");
        String text = sc.nextLine().trim();
        executeSearch(flag, p -> p.getNational().equalsIgnoreCase(text));
    }

    // Search Status
    public void searchStatusPlayer(int flag) {
        System.out.print("Input Status to search: ");
        String text = sc.nextLine().trim();
        executeSearch(flag, p -> p.getStatus().equalsIgnoreCase(text));
    }

    // Get Player For Update
    private Player getPlayerForUpdate(int flag) {
        while (true) {
            System.out.print("Input ID to update: ");
            String id = sc.nextLine().trim();
            Player p = checkId(getTargetList(flag), id);
            if (p != null)
                return p;
            System.out.println("ID not found !!!");
        }
    }

    // Update Name
    public void updateName(int flag) {
        Player p = getPlayerForUpdate(flag);
        if (p != null) {
            System.out.print("Input Name to update: ");
            p.setName(inputText());
            System.out.println("Update name successfully!");
        }
    }

    // Update National
    public void updateNational(int flag) {
        Player p = getPlayerForUpdate(flag);
        if (p != null) {
            System.out.print("Input National to update: ");
            p.setNational(inputText());
            System.out.println("Update national successfully!");
        }
    }

    // Update Age
    public void updateAge(int flag) {
        Player p = getPlayerForUpdate(flag);
        if (p != null) {
            System.out.print("Input Age to update: ");
            p.setAge(inputAge());
            System.out.println("Update age successfully!");
        }
    }

    // Update Position
    public void updatePosition(int flag) {
        Player p = getPlayerForUpdate(flag);
        if (p != null) {
            p.setPosition(inputPosition());
            System.out.println("Update position successfully!");
        }
    }

    // Update Shirt Number
    public void updateShirtNumber(int flag) {
        Player p = getPlayerForUpdate(flag);
        if (p != null) {
            System.out.print("Input Shirt Number to update: ");
            int shirtNo;
            while (true) {
                shirtNo = inputShirtNumber();
                if (isShirtNumberExist(shirtNo) && p.getShirtNumber() != shirtNo) {
                    System.out.println("Shirt Number Already! Input again.");
                } else break;
            }
            p.setShirtNumber(shirtNo);
            System.out.println("Update shirt number successfully!");
        }
    }

    // Update Salary
    public void updateSalary(int flag) {
        Player p = getPlayerForUpdate(flag);
        if (p != null) {
            System.out.print("Input Salary to update:");
            p.setBaseSalary(inputSalary());
            System.out.println("Update salary successfully!");
        }
    }

    // Update Status
    public void updateStatus(int flag) {
        Player p = getPlayerForUpdate(flag);
        if (p != null) {
            p.setStatus(inputStatus());
            System.out.println("Update status successfully!");
        }
    }

    // Display All Players
    public void displayAllPlayers(){
        if(dm.listRegular().isEmpty())
            System.out.println("No One In List Regular Player");
        else{
            for(RegularPlayer r : dm.listRegular()){
                System.out.println(r.displayListOfPlayer());}
        }
        if(dm.listStar().isEmpty())
            System.out.println("No One In List Star Player");
        else{
            for(StarPlayer s : dm.listStar()){
                System.out.println(s.displayListOfPlayer());}
        }
    }

    // Check ID
    public Player checkId(List<? extends Player> listPlayer, String id) {
        for (Player p : listPlayer) {
            if (p.getPlayerId().equalsIgnoreCase(id))
                return p;
        }
        return null;
    }

    // Input Text
    private String inputText() {
        String onlyAlpha = "^[a-zA-Z\\s]+$";
        while (true) {
            String text = sc.nextLine().trim();
            if (!text.isEmpty() && text.matches(onlyAlpha)){
                String[] word = text.toLowerCase().split("\\s+");
                StringBuilder sb = new StringBuilder();
                for(String s : word){
                    if(!s.isEmpty()){
                        sb.append(Character.toUpperCase(s.charAt(0)));
                        sb.append(s.substring(1));
                        sb.append(" ");
                    }
                }
                return sb.toString().trim();
            }
            System.out.println("Invalid - Only Letter");
        }
    }

    // Input Age
    public int inputAge() {
        while (true) {
            try {
                int age = Integer.parseInt(sc.nextLine());
                if (age >= 16 && age <= 45) return age;
                System.out.println("Invalid Only 16-45");
            } catch (NumberFormatException e) {
                System.out.println("Invalid Only 16-45");
            }
        }
    }

    // Input Position
    public String inputPosition(){
        int no;
        while(true){
            try{
                Menu.menuPlayerPositon();
                no = Integer.parseInt(sc.nextLine());
                if(no == 1)
                    return "Goalkeeper";
                if(no == 2)
                    return "Defender";
                if(no == 3)
                    return "Midfielder";
                if(no == 4)
                    return "Forward";
                System.out.println("Invalid Only 1-4");
            }catch(NumberFormatException e){
                System.out.println("Input Only 1-4");
            }
        }
    }

    // Input Shirt Number
    public int inputShirtNumber(){
        while(true){
            try{
                int shirtNo = Integer.parseInt(sc.nextLine());
                if(shirtNo >= 1 && shirtNo <= 99)
                    return shirtNo;
                System.out.println("Invalid Only 1-99");
            }catch(NumberFormatException e){
                System.out.println("Invalid Only 1-99");
            }
        }
    }

    // Input Salary
    public double inputSalary(){
        while(true){
            try{
                double salary = Double.parseDouble(sc.nextLine());
                if(salary > 0)
                    return salary;
                System.out.println("Invalid Only > 0");
            }catch(NumberFormatException e){
                System.out.println("Invalid Only > 0");
            }
        }
    }

    // Input Status
    public String inputStatus(){
        int no;
        while(true){
            Menu.menuStatus();
            try{
                no = Integer.parseInt(sc.nextLine());
                if(no == 1)
                    return "Active";
                if(no == 2)
                    return "Inactive";
                System.out.println("Invalid Only 1-2");
            }catch(NumberFormatException e){
                System.out.println("Invalid Only 1-2");
            }
        }
    }

    // Auto ID
    public <T extends Player> String autoId(List<T> listPlayer, String prefix){
        if(listPlayer == null || listPlayer.isEmpty())
            return String.format("%s%04d", prefix, 1);
        T lastPlayer = listPlayer.get(listPlayer.size() - 1);
        int lastNo = Integer.parseInt(lastPlayer.getPlayerId().substring(2));
        return String.format("%s%04d", prefix, lastNo + 1);
    }
}