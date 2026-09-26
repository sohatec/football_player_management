
package controller;

import data.DataManager;
import entity.AttendanceRecord;
import entity.RegularPlayer;
import entity.StarPlayer;
import entity.TrainingRecord;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import util.Menu;

public class TrainingManager {
    // Tạo biến và hàm nhận data, để xài và truy cập vào data chung
    // Nếu private final DataManager data = new DataManager(); thì khi gọi
    // nó sẽ tạo mới và không truy cập vào data chung được.
    private final DataManager dm;
    public TrainingManager(DataManager dm){
        this.dm = dm;
    }
    
    private final Scanner sc = new Scanner(System.in);
    
// ALL FUNCTION OF TRAINING ////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    
    // Create training record
    public void createTraining(){
        String id = autoId();
        LocalDate date = inputDate();
        String location = inputLocation();
        String topic = inputTopic();
        dm.listTraining().add(new TrainingRecord(id, date, location, topic));
    }
    
    // Input topic
    public String inputTopic(){
        System.out.print("Input topic: ");
        return sc.nextLine();
    }
    
    // Input location
    public String inputLocation(){
        System.out.print("Input location: ");
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
        if(dm.listTraining() == null || dm.listTraining().isEmpty())
            return String.format("%s%04d", "TN", 1);
        TrainingRecord lastTrain = dm.listTraining().get(dm.listTraining().size() - 1);
        int lastNo = Integer.parseInt(lastTrain.getTrainingId().substring(2));
        return String.format("%s%04d", "TN", lastNo + 1);
    }
    
    // Searching training by ID
    public void searchTrainingId(){
        System.out.print("Input training ID: ");
        String id = sc.nextLine();
        boolean found = false;
        Menu.header7();
        for(TrainingRecord t : dm.listTraining()){
            if(t.getTrainingId().equals(id)){
                System.out.println(t.toString());
                found = true;
            }
        }
        if(!found) System.out.println("Not found !!!");
    }
    
    // Searching training by date
    public void searchTrainingDate(){
        LocalDate date = inputDate();
        boolean found = false;
        Menu.header7();
        for(TrainingRecord t : dm.listTraining()){
            if(t.getDate().equals(date)){
                System.out.println(t.toString());
                found = true;
            }
        }
        if(!found) System.out.println("Not found !!!");
    }
    
    // Searching training by location
    public void searchTrainingLocation(){
        String loca = inputLocation();
        boolean found = false;
        Menu.header7();
        for(TrainingRecord t : dm.listTraining()){
            if(t.getLocation().contains(loca)){
                System.out.println(t.toString());
                found = true;
            }
        }
        if(!found) System.out.println("Not found !!!");
    }
    
    // Searching training by topic
    public void searchTrainingTopic(){
        String topic = inputTopic();
        boolean found = false;
        Menu.header7();
        for(TrainingRecord t : dm.listTraining()){
            if(t.getTopic().contains(topic)){
                System.out.println(t.toString());
                found = true;
            }
        }
        if(!found) System.out.println("Not found !!!");
    }

    // Update training date
    public void updateTrainingDate(){
        System.out.print("Input training ID to update: ");
        String id = sc.nextLine().trim();
        boolean found = false;
        for(TrainingRecord t : dm.listTraining()){
            if(t.getTrainingId().equalsIgnoreCase(id)){
                t.setDate(inputDate());
                System.out.println("Update date successfully!");
                found = true;
                break;
            }
        }
        if(!found) System.out.println("Training ID not found !!!");
    }
    
    // Updating training location
    public void updateTrainingLocation(){
        System.out.print("Input training ID to update: ");
        String id = sc.nextLine().trim();
        boolean found = false;
        for(TrainingRecord t : dm.listTraining()){
            if(t.getTrainingId().equalsIgnoreCase(id)){
                t.setLocation(inputLocation());
                System.out.println("Update location successfully!");
                found = true;
                break;
            }
        }
        if(!found) System.out.println("Training ID not found !!!");
    }
    
    // Updating training topic
    public void updateTrainingTopic(){
        System.out.print("Input training ID to update: ");
        String id = sc.nextLine().trim();
        boolean found = false;
        for(TrainingRecord t : dm.listTraining()){
            if(t.getTrainingId().equalsIgnoreCase(id)){
                t.setTopic(inputTopic());
                System.out.println("Update topic successfully!");
                found = true;
                break;
            }
        }
        if(!found) System.out.println("Training ID not found !!!");
    }
    
    // Display all training record
    public void displayAllTraining(){
        if(dm.listTraining() == null || dm.listTraining().isEmpty()) {
            System.out.println("No training records available.");
            return;
        }
        Menu.header7();
        for(TrainingRecord t : dm.listTraining()){
            System.out.println(t.toString());
        }
    }
    
// ALL FUNCTION OF ATTENDANCE //////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    
    // Create attendance
    public void createAttendance(){
        TrainingRecord tnr = getTrainingRecord();
        String playerId = inputPlayerId();
        String attenOrAbsent = attendOrAbsent();
        tnr.getAttendance().add(new AttendanceRecord(playerId, attenOrAbsent));
    }
    
    // Input attend or absent
    public String attendOrAbsent(){
        int no;
        while(true){
            Menu.attenOrAbsent();
            try{
                no = Integer.parseInt(sc.nextLine());
                if(no == 1) return "Attend";
                if(no == 2) return "Absent";
                System.out.println("Invalid Only 1-2");
            }catch(NumberFormatException e){
                System.out.println("Invalid Only 1-2");
            }
        }
    }
    
    // Input player ID
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
    
    // Get training record
    public TrainingRecord getTrainingRecord(){
        while(true){
            System.out.print("Input Training ID: ");
            String id = sc.nextLine().trim();
            for(TrainingRecord t : dm.listTraining()){
                if(t.getTrainingId().equals(id)) return t;
            }
        }
    }
    
    // Searching Attendance record
    public void searchAttendance(){
        TrainingRecord tnr = getTrainingRecord();
        String playerId = inputPlayerId();
        for(AttendanceRecord atr : tnr.getAttendance()){
            if(atr.getPlayerId().equals(playerId))
                System.out.println(atr.toString());
        }
    }
    
    // Update attendance player ID
    public void updateAttendPlayerId(){
        TrainingRecord tnr = getTrainingRecord();
        String playerId = inputPlayerId();
        for(AttendanceRecord atr : tnr.getAttendance()){
            if(atr.getPlayerId().equals(playerId))
                atr.setPlayerId(inputPlayerId());
        }
    }
    
    // Update attendance attend or absent
    public void updateAttendOrAbsent(){
        TrainingRecord tnr = getTrainingRecord();
        String playerId = inputPlayerId();
        for(AttendanceRecord atr : tnr.getAttendance()){
            if(atr.getPlayerId().equals(playerId))
                atr.setAttendance(attendOrAbsent());
        }
    }
    
    // Dispaly all attendance in a training
    public void displayAllAttendance(){
        TrainingRecord tnr = getTrainingRecord();
        Menu.header4();
        for(AttendanceRecord atr : tnr.getAttendance()){
            System.out.println(atr.toString());
        }
    }
}
