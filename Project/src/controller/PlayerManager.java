package controller;
import data.DataManager;
import entity.Player;
import entity.RegularPlayer;
import entity.StarPlayer;
import java.util.List;
import java.util.Scanner;
import util.Menu;

public class PlayerManager {
    
    // Tạo biến và hàm nhận data, để xài và truy cập vào data chung
    // Nếu private final DataManager data = new DataManager(); thì khi gọi
    // nó sẽ tạo mới và không truy cập vào data chung được
    private final DataManager dm;
    public PlayerManager(DataManager dm){
        this.dm = dm;
    }
    
    private final Scanner sc = new Scanner(System.in);
    
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
            if(isShirtNumber(getTargetList(flag), shirtNo)){
            System.out.println("Shirt Number Already! Input again.");
            } else break;
        }
        
        System.out.print("Input Salary: ");
        double salary = inputSalary();
        
        String status = "Active";
        
        if(flag == 1) 
            dm.listRegular().add(new RegularPlayer(id, name, age, national, position, shirtNo, salary, status));
        else 
            dm.listStar().add(new StarPlayer(id, name, age, national, position, shirtNo, salary, status));
    }
    
    // Is Shirt Number
    private boolean isShirtNumber(List<? extends Player> list, int shirtNo){
        for(Player p : list)
            if(p.getShirtNumber() == shirtNo) return true;
        return false;
    }
    
    // Get Target List
    private List<? extends Player> getTargetList(int flag) {
        return (flag == 1) ? dm.listRegular() : dm.listStar();
    }

    // Search ID Player
    public void searchIdPlayer(int flag){
        System.out.print("Input ID to search: ");
        String id = sc.nextLine().trim();
        boolean found = false;
        Menu.header1();
        for (Player p : getTargetList(flag)) {
            if (p.getPlayerId().equals(id)) {
                System.out.println(p.displayListOfPlayer());
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Not found!");
    }

    // Search Name Player
    public void searchNamePlayer(int flag){
        System.out.print("Input Name to search: ");
        String name = sc.nextLine().trim();
        boolean found = false;
        Menu.header1();
        for (Player p : getTargetList(flag)) {
            if (p.getName().equals(name)) {
                System.out.println(p.displayListOfPlayer());
                found = true;
            }
        }
        if (!found) System.out.println("Not found!");
    }

    // Search Position Player
    public void searchPositionPlayer(int flag){
        System.out.print("Input Position to search: ");
        String position = sc.nextLine().trim();
        boolean found = false;
        Menu.header1();
        for (Player p : getTargetList(flag)) {
            if (p.getPosition().equals(position)) {
                System.out.println(p.displayListOfPlayer());
                found = true;
            }
        }
        if (!found) System.out.println("Not found!");
    }

    // Search National Player
    public void searchNationalPlayer(int flag){
        System.out.print("Input National to search: ");
        String national = sc.nextLine().trim();
        boolean found = false;
        Menu.header1();
        for (Player p : getTargetList(flag)) {
            if (p.getNational().equals(national)) {
                System.out.println(p.displayListOfPlayer());
                found = true;
            }
        }
        if (!found) System.out.println("Not found!");
    }

    // Search Status Player
    public void searchStatusPlayer(int flag){
        System.out.print("Input Status to search: ");
        String status = sc.nextLine().trim();
        boolean found = false;
        Menu.header1();
        for (Player p : getTargetList(flag)) {
            if (p.getStatus().equals(status)) {
                System.out.println(p.displayListOfPlayer());
                found = true;
            }
        }
        if (!found) System.out.println("Not found!");
    }

    // Update Name
    public void updateName(int flag) {
        while (true) {
            System.out.print("Input ID to update: ");
            String id = sc.nextLine().trim();
            Player p = (flag == 1) ? checkId(dm.listRegular(), id) : checkId(dm.listStar(), id);
            if (p == null) {
                System.out.println("ID invalid");
                continue; 
            }
            System.out.print("Input Name to update: ");
            String name = inputText();
            p.setName(name);
            break;
        }
    }
    
    // Update National
    public void updateNational(int flag) {
        while (true) {
            System.out.print("Input ID to update: ");
            String id = sc.nextLine().trim();
            Player p = (flag == 1) ? checkId(dm.listRegular(), id) : checkId(dm.listStar(), id);
            if (p == null) {
                System.out.println("ID invalid");
                continue;
            }
            System.out.print("Input National to update: ");
            String national = inputText();
            p.setNational(national);
            break;
        }
    }
    
    // Update Age
    public void updateAge(int flag) {
        while (true) {
            System.out.print("Input ID to update: ");
            String id = sc.nextLine().trim();
            Player p = (flag == 1) ? checkId(dm.listRegular(), id) : checkId(dm.listStar(), id);
            if (p == null) {
                System.out.println("ID invalid");
            } else {
                System.out.println("Input Age to update:");
                int age = inputAge(); 
                p.setAge(age); 
                break;
            }
        }
    }
    
    // Update Positon
    public void updatePosition(int flag) {
        while (true) {
            System.out.print("Input ID to update: ");
            String id = sc.nextLine().trim();
            Player p = (flag == 1) ? checkId(dm.listRegular(), id) : checkId(dm.listStar(), id);
            if (p == null)
                System.out.println("ID invalid");
            else {
                p.setPosition(inputPosition());
                System.out.println("Update position successfully!");
                break;
            }
        }
    }
    
    // Update Shirt Number
    public void updateShirtNumber(int flag) {
        while (true) {
            System.out.print("Input ID to update: ");
            String id = sc.nextLine().trim();
            Player p = (flag == 1) ? checkId(dm.listRegular(), id) : checkId(dm.listStar(), id);
            if (p == null)
                System.out.println("ID invalid");
            else {
                System.out.print("Input Shirt Number to update:");
                int shirtNo = inputShirtNumber();
                p.setShirtNumber(shirtNo);
                System.out.println("Update shirt number successfully!");
                break;
            }
        }
    }
    
    // Update Salary
    public void updateSalary(int flag) {
        while (true) {
            System.out.print("Input ID to update: ");
            String id = sc.nextLine().trim();
            Player p = (flag == 1) ? checkId(dm.listRegular(), id) : checkId(dm.listStar(), id);
            if (p == null)
                System.out.println("ID invalid");
            else {
                System.out.print("Input Salary to update:");
                double salary = inputSalary();
                p.setBaseSalary(salary);
                System.out.println("Update salary successfully!");
                break;
            }
        }
    }
    
    // Update Status
    public void updateStatus(int flag) {
        while (true) {
            System.out.print("Input ID to update: ");
            String id = sc.nextLine().trim();
            Player p = (flag == 1) ? checkId(dm.listRegular(), id) : checkId(dm.listStar(), id);
            if (p == null)
                System.out.println("ID invalid");
            else {
                String status = inputStatus();
                p.setStatus(status);
                System.out.println("Update status successfully!");
                break; 
            }
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
    public <T extends Player> T checkId(List<T> listPlayer, String id) {
        for (T p : listPlayer) {
            if (p.getPlayerId().equals(id))
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
                if(no == 1) return "Goalkeeper";
                if(no == 2) return "Defender";
                if(no == 3) return "Midfielder";
                if(no == 4) return "Forward";
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
                if(shirtNo >= 1 && shirtNo <= 99) return shirtNo;
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
                if(salary > 0) return salary;
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
                if(no == 1) return "Active";
                if(no == 2) return "Inactive";
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