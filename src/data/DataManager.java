package data;

import entity.*;

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
import java.util.function.Function;

public class DataManager {

    private final List<RegularPlayer> list1 = new ArrayList<>();
    private final List<StarPlayer> list2 = new ArrayList<>();
    private final List<MatchRecord> list3 = new ArrayList<>();
    private final List<TrainingRecord> list4 = new ArrayList<>();

    public List<RegularPlayer> listRegular() {
        return list1;
    }

    public List<StarPlayer> listStar() {
        return list2;
    }

    public List<MatchRecord> listMatch() {
        return list3;
    }

    public List<TrainingRecord> listTraining() {
        return list4;
    }

    // Save TXT
    public <T> void saveTXT(String ms1, String ms2, List<T> list, Function<T, String> format) {
        File f = new File(ms1);
        try (FileWriter fw = new FileWriter(f);
             BufferedWriter bw = new BufferedWriter(fw);) {
            for (T r : list)
                bw.write(format.apply(r) + "\n");
            System.out.println(ms2);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Read TXT
    public void readTXT(String ms1, String ms2) {
        File f = new File(ms1);
        if (!f.exists()) {
            System.out.println(ms2);
        } else {
            try (FileReader fr = new FileReader(f);
                 BufferedReader br = new BufferedReader(fr)) {
                String line;
                while ((line = br.readLine()) != null)
                    System.out.println(line);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Save BIN
    public <T> void saveBIN(String ms1, List<T> list) {
        File f = new File(ms1);
        try (FileOutputStream fo = new FileOutputStream(f);
             ObjectOutputStream oo = new ObjectOutputStream(fo)) {
            oo.writeObject(list);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Read BIN
    public <T> void readBIN(String ms1, List<T> list) {
        File f = new File(ms1);
        if (!f.exists())
            System.out.print("");
        else {
            try (FileInputStream fi = new FileInputStream(f);
                 ObjectInputStream oo = new ObjectInputStream(fi)) {
                list.clear();
                List<T> dataFromFile = (List<T>) oo.readObject();
                list.addAll(dataFromFile);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Saving TXT Report
    public void saveTXTReport(String ms1, String ms2, String ms3) {
        File f = new File(ms1);
        try (FileWriter fw = new FileWriter(f);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(ms2);
            System.out.println(ms3);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}