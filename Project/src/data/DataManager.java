
package data;
import entity.MatchRecord;
import entity.RegularPlayer;
import entity.StarPlayer;
import entity.TrainingRecord;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

public class DataManager {
    
    // List 1
    private List<RegularPlayer> list1 = new ArrayList<>();
    
    // List 2
    private List<StarPlayer> list2 = new ArrayList<>();
    
    // List 3
    private List<MatchRecord> list3 = new ArrayList<>();
    
    // List 4
    private List<TrainingRecord> list4 = new ArrayList<>();
    
    // List Regular
    public List<RegularPlayer> listRegular(){
        return list1;
    }
    
    // List Star
    public List<StarPlayer> listStar(){
        return list2;
    }
    
    // List Match
    public List<MatchRecord> listMatch(){
        return list3;
    }
    
    // List Training
    public List<TrainingRecord> listTraining(){
        return list4;
    }
    
// DATA OF REGULAR PLAYER //////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    // Save Regular Player TXT
    public void saveRegularTXT(){
        File f = new File("Regular_Player.txt");
        try(FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);){
            for(RegularPlayer r : list1)
                bw.write(r.displayListOfPlayer());
            System.out.println("Saved Regular Player TXT !!!");
        }catch(IOException e){System.out.println(e.getMessage());}
    }
    
    // Read Reagular Player TXT
    public void readRegularTXT(){
        File f = new File("Regular_Player.txt");
        if(!f.exists()){
            System.out.println("Regular Player TXT is not exist !!!");
        }else{
            try(FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr)){
                String line;
                while((line = br.readLine()) != null)
                    System.out.println(line);
            }catch(IOException e){System.out.println(e.getMessage());}
        }
    }
    
    // Save Regular Player BIN
    public void saveRegularBIN(){
        File f = new File("Regular_Player.bin");
        try(FileOutputStream fo = new FileOutputStream(f);
            ObjectOutputStream oo = new ObjectOutputStream(fo)){
            oo.writeObject(list1);
        }catch(IOException e){System.out.println(e.getMessage());}
    }
    
    // Read Regular Player BIN
    public void readRegularBIN(){
        File f = new File("Regular_Player.bin");
        if(!f.exists()){
        }else{
            list1.clear();
            try(FileInputStream fi = new FileInputStream(f);
                ObjectInputStream oo = new ObjectInputStream(fi)){
                list1 = (ArrayList<RegularPlayer>) oo.readObject();
            }catch(IOException | ClassNotFoundException e){System.out.println(e.getMessage());}
        }
    }
    
// DATA OF STAR PLAYER /////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    // Save Star Player TXT
    public void saveStarTXT(){
        File f = new File("Star_Player.txt");
        try(FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw)){
            for(StarPlayer s : list2)
                bw.write(s.displayListOfPlayer());
            System.out.println("Saved Star Player TXT !!!");
        }catch(IOException e){System.out.println(e.getMessage());}
    }
    
    // Read Star Player TXT
    public void readStarTXT(){
        File f = new File("Star_Player.txt");
        if(!f.exists()){
            System.out.println("Star Player TXT is not exist !!!");
        }else{
            try(FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr)){
                String line;
                while((line = br.readLine()) != null)
                    System.out.println(line);
            }catch(IOException e){System.out.println(e.getMessage());}
        }
    }
    
    // Save Star Player BIN
    public void saveStarBIN(){
        File f = new File("Star_Player.bin");
        try(FileOutputStream fo = new FileOutputStream(f);
            ObjectOutputStream oo = new ObjectOutputStream(fo)){
            oo.writeObject(list2);
        }catch(IOException e){System.out.println(e.getMessage());}
    }
    
    // Read Star Player BIN
    public void readStarBIN(){
        File f = new File("Star_Player.bin");
        if(!f.exists()){
        }else{
            list2.clear();
            try(FileInputStream fi = new FileInputStream(f);
                ObjectInputStream oo = new ObjectInputStream(fi)){
                list2 = (ArrayList<StarPlayer>) oo.readObject();
            }catch(IOException | ClassNotFoundException e){System.out.println(e.getMessage());}
        }
    }
    
// DATA OF MATCHING ////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    // Save Matching TXT
    public void saveMatchTXT(){
        File f = new File("Match_Record.txt");
        try(FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw)){
                for(MatchRecord m : list3)
                    bw.write(m.toString());
            System.out.println("Saved Regular Player TXT !!!");
        }catch(IOException e){System.out.println(e.getMessage());}
    }
    
    // Read Matching TXT
    public void readMatchTXT(){
        File f = new File("Match_Record.txt");
        if(!f.exists()){
            System.out.println("Match Record TXT is not exist !");
        }else{
            try(FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr)){
                String line;
                while((line = br.readLine()) != null){
                    System.out.println(line);
                }
            }catch(IOException e){System.out.println(e.getMessage());}
        }
    }
    
    // Save Matching BIN
    public void saveMatchBIN(){
        File f = new File("Match_Record.bin");
        try(FileOutputStream fo = new FileOutputStream(f);
            ObjectOutputStream oo = new ObjectOutputStream(fo)){
            oo.writeObject(list3);
        }catch(IOException e){System.out.println(e.getMessage());}
    }
    
    // Read Matching BIN
    public void readMatchBIN(){
        File f = new File("Match_Record.bin");
        if(!f.exists()){
        }else{
            list3.clear();
            try(FileInputStream fi = new FileInputStream(f);
                ObjectInputStream oo = new ObjectInputStream(fi)){
                list3 = (ArrayList<MatchRecord>) oo.readObject();
            }catch(IOException | ClassNotFoundException e){System.out.println(e.getMessage());}
        }
    }
    
// DATA OF TRAINING ////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    // Save Training TXT
    public void saveTrainingTXT(){
        File f = new File("Training_Record.txt");
        try(FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw)){
                for(TrainingRecord t : list4)
                    bw.write(t.toString());
            System.out.println("Saved Training TXT !!!");
        }catch(IOException e){System.out.println(e.getMessage());}
    }
    
    // Read Training TXT
    public void readTrainingTXT(){
        File f = new File("Training_Record.txt");
        if(!f.exists()){
            System.out.println("Training Record TXT is not exist !");
        }else{
            try(FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr)){
                String line;
                while((line = br.readLine()) != null){
                    System.out.println(line);
                }
            }catch(IOException e){System.out.println(e.getMessage());}
        }
    }
    
    // Save Training BIN
    public void saveTrainingBIN(){
        File f = new File("Training_Record.bin");
        try(FileOutputStream fo = new FileOutputStream(f);
            ObjectOutputStream oo = new ObjectOutputStream(fo)){
            oo.writeObject(list4);
        }catch(IOException e){System.out.println(e.getMessage());}
    }
    
    // Read Training BIN
    public void readTrainingBIN(){
        File f = new File("Training_Record.bin");
        if(!f.exists()){
        }else{
            list4.clear();
            try(FileInputStream fi = new FileInputStream(f);
                ObjectInputStream oo = new ObjectInputStream(fi)){
                list4 = (ArrayList<TrainingRecord>) oo.readObject();
            }catch(IOException | ClassNotFoundException e){System.out.println(e.getMessage());}
        }
    }
    
// DATA OF REPORT //////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    // Saving Salary Report TXT
    public void saveSalaryReportTXT(String content){
        File f = new File("Salary_Report.txt");
        try(FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw)){
            bw.write(content);
            System.out.println("Saved Salary Report TXT !!!");
        }catch(IOException e){System.out.println(e.getMessage());}
    }

    // Loading Salary Report TXT
    public void readSalaryReportTXT(){
        File f = new File("Salary_Report.txt");
        if(!f.exists()){
            System.out.println("Salary Report TXT is not exist !!!");
        }else{
            try(FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr)){
                String line;
                while((line = br.readLine()) != null)
                    System.out.println(line);
            }catch(IOException e){System.out.println(e.getMessage());}
        }
    }

    // Saving Ranking Report TXT
    public void saveRankingReportTXT(String content){
        File f = new File("Ranking_Report.txt");
        try(FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw)){
            bw.write(content);
            System.out.println("Saved Ranking Report TXT !!!");
        }catch(IOException e){System.out.println(e.getMessage());}
    }

    // Loading Ranking Report TXT
    public void readRankingReportTXT(){
        File f = new File("Ranking_Report.txt");
        if(!f.exists()){
            System.out.println("Ranking Report TXT is not exist !!!");
        }else{
            try(FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr)){
                String line;
                while((line = br.readLine()) != null)
                    System.out.println(line);
            }catch(IOException e){System.out.println(e.getMessage());}
        }
    }
}