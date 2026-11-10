package controller;

import java.util.Scanner;

import entity.MatchRecord;
import entity.RegularPlayer;
import entity.StarPlayer;
import entity.TrainingRecord;
import util.Menu;
import data.DataManager;

public class Cabinet {

    // Declare a variable and a method to receive and access the shared data.
    // Initializing with "private final DataManager data = new DataManager();"
    // will create a new object, preventing access to the shared instance.
    public static DataManager dm = new DataManager();
    public static PlayerManager pm = new PlayerManager(dm);
    public static SalaryManager sm = new SalaryManager(dm);
    public static MatchManager mm = new MatchManager(dm);
    public static ReportManager rm = new ReportManager(dm);
    public static TrainingManager tm = new TrainingManager(dm);
    public static Scanner sc = new Scanner(System.in);

    public static int chooseFlag(){
        int c;
        while (true) {
            try {
                Menu.menuTypePlayer();
                c = Integer.parseInt(sc.nextLine());
                if (c == 1 || c == 2)
                    return c;
            } catch (NumberFormatException e) {}
        }
    }

    // Task 1
    public static void task1() {
        pm.createPlayer(chooseFlag());
    }

    // Task 2
    public static void task2() {
        pm.searchIdPlayer(chooseFlag());
    }

    // Task 3
    public static void task3() {
        pm.searchNamePlayer(chooseFlag());
    }

    // Task 4
    public static void task4() {
        pm.searchPositionPlayer(chooseFlag());
    }

    // Task 5
    public static void task5() {
        pm.searchNationalPlayer(chooseFlag());
    }

    // Task 6
    public static void task6() {
        pm.searchStatusPlayer(chooseFlag());
    }

    // Task 7
    public static void task7() {
        pm.updateName(chooseFlag());
    }

    // Task 8
    public static void task8() {
        pm.updateNational(chooseFlag());
    }

    // Task 9
    public static void task9() {
        pm.updateAge(chooseFlag());
    }

    // Task 10
    public static void task10() {
        pm.updatePosition(chooseFlag());
    }

    // Task 11
    public static void task11() {
        pm.updateShirtNumber(chooseFlag());
    }

    // Task 12
    public static void task12() {
        pm.updateSalary(chooseFlag());
    }

    // Task 13
    public static void task13() {
        pm.updateStatus(chooseFlag());
    }

    // Task 14
    public static void task14() {
        Menu.header1();
        pm.displayAllPlayers();
    }

    // Task 15
    public static void task15() {
        int month = inputMonth(), year = inputYear();
        String id = inputId();
        System.out.println(sm.salaryMonth(id, month, year, dm.listRegular()));
    }

    // Task 16
    public static void task16() {
        int month = inputMonth(), year = inputYear();
        String id = inputId();
        System.out.println(sm.salaryMonth(id, month, year, dm.listStar()));
    }

    // Task 17
    public static void task17() {
        int year = inputYear();
        String id = inputId();
        System.out.println(sm.salaryYear(id, year, dm.listRegular()));
    }

    // Task 18
    public static void task18() {
        int year = inputYear();
        String id = inputId();
        System.out.println(sm.salaryYear(id, year, dm.listStar()));
    }

    // Task 19
    public static void task19() {
        int month = inputMonth(), year = inputYear();
        String id = inputId();
        System.out.println(sm.totalPointsMonth(id, month, year));
    }

    // Task 20
    public static void task20() {
        int month = inputMonth(), year = inputYear();
        String id = inputId();
        System.out.println(sm.totalPointsMonth(id, month, year));
    }

    // Task 21
    public static void task21() {
        int year = inputYear();
        String id = inputId();
        System.out.println(sm.totalPointsYear(id, year));
    }

    // Task 22
    public static void task22() {
        int year = inputYear();
        String id = inputId();
        System.out.println(sm.totalPointsYear(id, year));
    }

    // Task 23
    public static void task23() {
        mm.createMatch();
    }

    // Task 24
    public static void task24() {
        mm.searchMatchId();
    }

    // Task 25
    public static void task25() {
        mm.searchMatchDate();
    }

    // Task 26
    public static void task26() {
        mm.searchMatchOpponent();
    }

    // Task 27
    public static void task27() {
        mm.searchMatchType();
    }

    // Task 28
    public static void task28() {
        mm.updateMatchDate();
    }

    // Task 29
    public static void task29() {
        mm.updateMatchOpponent();
    }

    // Task 30
    public static void task30() {
        mm.updateMatchType();
    }

    // Task 31
    public static void task31() {
        mm.displayAllMatch();
    }

    // Task 32
    public static void task32() {
        mm.createPerformance();
    }

    // Task 33
    public static void task33() {
        mm.searchPerformance();
    }

    // Task 34
    public static void task34() {
        mm.updateGoal();
    }

    // Task 35
    public static void task35() {
        mm.updateAssist();
    }

    // Task 36
    public static void task36() {
        mm.updateYellow();
    }

    // Task 37
    public static void task37() {
        mm.updateRed();
    }

    // Task 38
    public static void task38() {
        mm.updateMinutes();
    }

    // Task 39
    public static void task39() {
        mm.displayAllPerformance();
    }

    // Task 40
    public static void task40() {
        tm.createTraining();
    }

    // Task 41
    public static void task41() {
        tm.searchTrainingId();
    }

    // Task 42
    public static void task42() {
        tm.searchTrainingDate();
    }

    // Task 43
    public static void task43() {
        tm.searchTrainingLocation();
    }

    // Task 44
    public static void task44() {
        tm.searchTrainingTopic();
    }

    // Task 45
    public static void task45() {
        tm.updateTrainingDate();
    }

    // Task 46
    public static void task46() {
        tm.updateTrainingLocation();
    }

    // Task 47
    public static void task47() {
        tm.updateTrainingTopic();
    }

    // Task 48
    public static void task48() {
        tm.displayAllTraining();
    }

    // Task 49
    public static void task49() {
        tm.createAttendance();
    }

    // Task 50
    public static void task50() {
        tm.searchAttendance();
    }

    // Task 51
    public static void task51() {
        tm.updateAttendPlayerId();
    }

    // Task 52
    public static void task52() {
        tm.updateAttendOrAbsent();
    }

    // Task 53
    public static void task53() {
        tm.displayAllAttendance();
    }

    // Task 54_1 Report 1
    public static void task54_1() {
        rm.report1();
    }

    // Task 54_2
    public static void task54_2() {
        dm.readTXT("Salary_Report.txt", "Salary Report TXT is not exist !!!");
    }

    // Task 55_1 Report 2
    public static void task55_1() {
        rm.report2();
    }

    // Task 55_2
    public static void task55_2() {
        dm.readTXT("Ranking_Report.txt", "Ranking Report TXT is not exist !!!");
    }

    // Task 56
    public static void task56() {
        dm.saveTXT("Regular_Player.txt", "Saved Regular Player TXT !!!", dm.listRegular(), RegularPlayer::displayListOfPlayer);
    }

    // Task 57
    public static void task57() {
        dm.readTXT("Regular_Player.txt", "Regular Player TXT is not exist !!!");
    }

    // Task 58
    public static void task58() {
        dm.saveBIN("Regular_Player.bin", dm.listRegular());
    }

    // Task 59
    public static void task59() {
        dm.readBIN("Regular_Player.bin", dm.listRegular());
    }

    // Task 60
    public static void task60() {
        dm.saveTXT("Star_Player.txt", "Saved Star Player TXT !!!", dm.listStar(), StarPlayer::displayListOfPlayer);
    }

    // Task 61
    public static void task61() {
        dm.readTXT("Star_Player.txt", "Star Player TXT is not exist !!!");
    }

    // Task 62
    public static void task62() {
        dm.saveBIN("Star_Player.bin", dm.listStar());
    }

    // Task 63
    public static void task63() {
        dm.readBIN("Star_Player.bin", dm.listStar());
    }

    // Task 64
    public static void task64() {
        dm.saveTXT("Match_Record.txt", "Saved Match Record TXT !!!", dm.listMatch(), MatchRecord::toString);
    }

    // Task 65
    public static void task65() {
        dm.readTXT("Match_Record.txt", "Match Record TXT is not exist !!!");
    }

    // Task 66
    public static void task66() {
        dm.saveBIN("Match_Record.bin", dm.listMatch());
    }

    // Task 67
    public static void task67() {
        dm.readBIN("Match_Record.bin", dm.listMatch());
    }

    // Task 68
    public static void task68() {
        dm.saveTXT("Training_Record.txt", "Saved Training Record TXT", dm.listTraining(), TrainingRecord::toString);
    }

    // Task 69
    public static void task69() {
        dm.readTXT("Training_Record.txt", "Training Record TXT is not exist !!!");
    }

    // Task 70
    public static void task70() {
        dm.saveBIN("Training_Record.bin", dm.listTraining());
    }

    // Task 71
    public static void task71() {
        dm.readBIN("Training_Record.bin", dm.listTraining());
    }

    // Input year
    public static int inputYear() {
        int year;
        while (true) {
            try {
                System.out.print("Input year: ");
                year = Integer.parseInt(sc.nextLine());
                if (2000 <= year && year <= 2100)
                    return year;
            } catch (NumberFormatException e) {}
        }
    }

    // Input month
    public static int inputMonth() {
        int month;
        while (true) {
            try {
                System.out.print("Input month: ");
                month = Integer.parseInt(sc.nextLine());
                if (1 <= month && month <= 12)
                    return month;
            } catch (NumberFormatException e) {}
        }
    }

    // Input id
    public static String inputId() {
        System.out.print("Input ID: ");
        return sc.nextLine();
    }
}