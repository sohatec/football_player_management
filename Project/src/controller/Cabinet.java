
package controller;
import java.util.Scanner;
import util.Menu;
import data.DataManager;
public class Cabinet {
    
    // Tạo duy nhất DataManager ở đây để xài và truy cập data chung.
    // Mỗi class Manager đều có hàm để nhận data về dùng.
    // Hình thức này mới là xài chung data.
    // Ta tạo new DataManager rồi truyền vào các class manager kia để nó xài chung data
    public static DataManager dm = new DataManager();
    public static PlayerManager pm = new PlayerManager(dm);
    public static SalaryManager sm = new SalaryManager(dm);
    public static MatchManager mm = new MatchManager(dm);
    public static ReportManager rm = new ReportManager(dm);
    public static TrainingManager tm = new TrainingManager(dm);
    public static Scanner sc = new Scanner(System.in);
    
    // Task 1 
    public static void task1(){
        int c;
        try{
            do{
                Menu.menuTypePlayer0();
                c = Integer.parseInt(sc.nextLine());
                if (c == 1 || c == 2)
                    pm.createPlayer(c == 1 ? 1 : 2);
            }while(c != 0);
        }catch(NumberFormatException e){}
    }
    
    // Task 2
    public static void task2(){
        int c;
        try{
            do{
                Menu.menuTypePlayer();
                c = Integer.parseInt(sc.nextLine());
                if (c == 1 || c == 2)
                    pm.searchIdPlayer(c == 1 ? 1 : 2);
            }while(c != 0);
        }catch(NumberFormatException e){}
    }
    
    // Task 3
    public static void task3(){
        int c;
        try{
            do{
                Menu.menuTypePlayer();
                c = Integer.parseInt(sc.nextLine());
                if (c == 1 || c == 2)
                    pm.searchNamePlayer(c == 1 ? 1 : 2);
            }while(c != 0);
        }catch(NumberFormatException e){}
    }
    
    // Task 4
    public static void task4(){
        int c;
        try{
            do{
                Menu.menuTypePlayer();
                c = Integer.parseInt(sc.nextLine());
                if (c == 1 || c == 2)
                    pm.searchPositionPlayer(c == 1 ? 1 : 2);
            }while(c != 0);
        }catch(NumberFormatException e){}
    }
    
    // Task 5
    public static void task5(){
        int c;
        try{
            do{
                Menu.menuTypePlayer();
                c = Integer.parseInt(sc.nextLine());
                if (c == 1 || c == 2)
                    pm.searchNationalPlayer(c == 1 ? 1 : 2);
            }while(c != 0);
        }catch(NumberFormatException e){}
    }
    
    // Task 6
    public static void task6(){
        int c;
        try{
            do{
                Menu.menuTypePlayer();
                c = Integer.parseInt(sc.nextLine());
                if (c == 1 || c == 2)
                    pm.searchStatusPlayer(c == 1 ? 1 : 2);
            }while(c != 0);
        }catch(NumberFormatException e){}
    }
    
    // Task 7
    public static void task7(){
        int c;
        try{
            do{
                Menu.menuTypePlayer();
                c = Integer.parseInt(sc.nextLine());
                if (c == 1 || c == 2)
                pm.updateName(c == 1 ? 1 : 2);
            }while(c != 0);
        }catch(NumberFormatException e){}
    }
    
    // Task 8
    public static void task8(){
        int c;
        try{
            do{
                Menu.menuTypePlayer();
                c = Integer.parseInt(sc.nextLine());
                if (c == 1 || c == 2)
                pm.updateNational(c == 1 ? 1 : 2);
            }while(c != 0);
        }catch(NumberFormatException e){}
    }
    
    // Task 9
    public static void task9(){
        int c;
        try{
            do{
                Menu.menuTypePlayer();
                c = Integer.parseInt(sc.nextLine());
                if (c == 1 || c == 2)
                pm.updateAge(c == 1 ? 1 : 2);
            }while(c != 0);
        }catch(NumberFormatException e){}
    }
    
    // Task 10
    public static void task10(){
        int c;
        try{
            do{
                Menu.menuTypePlayer();
                c = Integer.parseInt(sc.nextLine());
                if (c == 1 || c == 2)
                pm.updatePosition(c == 1 ? 1 : 2);
            }while(c != 0);
        }catch(NumberFormatException e){}
    }
    
    // Task 11
    public static void task11(){
        int c;
        try{
            do{
                Menu.menuTypePlayer();
                c = Integer.parseInt(sc.nextLine());
                if (c == 1 || c == 2)
                pm.updateShirtNumber(c == 1 ? 1 : 2);
            }while(c != 0);
        }catch(NumberFormatException e){}
    }
    
    // Task 12
    public static void task12(){
        int c;
        try{
            do{
                Menu.menuTypePlayer();
                c = Integer.parseInt(sc.nextLine());
                if (c == 1 || c == 2)
                pm.updateSalary(c == 1 ? 1 : 2);
            }while(c != 0);
        }catch(NumberFormatException e){}
    }
    
    // Task 13
    public static void task13(){
        int c;
        try{
            do{
                Menu.menuTypePlayer();
                c = Integer.parseInt(sc.nextLine());
                if (c == 1 || c == 2)
                pm.updateStatus(c == 1 ? 1 : 2);
            }while(c != 0);
        }catch(NumberFormatException e){}
    }
    
    // Task 14
    public static void task14(){
        Menu.header1();
        pm.displayAllPlayers();
    }
    
    // Task 15
    public static void task15(){
        int month = inputMonth(), year = inputYear();
        String id = inputId();
        System.out.println(sm.regularSalaryMonth(id, month, year));
    }
    
    // Task 16
    public static void task16(){
        int month = inputMonth(), year = inputYear();
        String id = inputId();
        System.out.println(sm.starSalaryMonth(id, month, year));
    }
    
    // Task 17
    public static void task17(){
        int year = inputYear();
        String id = inputId();
        System.out.println(sm.regularSalaryYear(id, year));
    }
    
    // Task 18
    public static void task18(){
        int year = inputYear();
        String id = inputId();
        System.out.println(sm.starSalaryYear(id, year));
    }
    
    // Task 19
    public static void task19(){
        int month = inputMonth(), year = inputYear();
        String id = inputId();
        System.out.println(sm.totalPointsMonth(id, month, year));
    }
    
    // Task 20
    public static void task20(){
        int month = inputMonth(), year = inputYear();
        String id = inputId();
        System.out.println(sm.totalPointsMonth(id, month, year));
    }
    
    // Task 21
    public static void task21(){
        int year = inputYear();
        String id = inputId();
        System.out.println(sm.totalPointsYear(id, year));
    }
    
    // Task 22
    public static void task22(){
        int year = inputYear();
        String id = inputId();
        System.out.println(sm.totalPointsYear(id, year));
    }
    
    // Task 23
    public static void task23(){
        mm.createMatch();
    }
    
    // Task 24
    public static void task24(){
        mm.searchMatchId();
    }
    
    // Task 25
    public static void task25(){
        mm.searchMatchDate();
    }
    
    // Task 26
    public static void task26(){
        mm.searchMatchOpponent();
    }
    
    // Task 27
    public static void task27(){
        mm.searchMatchType();
    }
    
    // Task 28
    public static void task28(){
        mm.updateMatchDate();
    }
    
    // Task 29
    public static void task29(){
        mm.updateMatchOpponent();
    }
    
    // Task 30
    public static void task30(){
        mm.updateMatchType();
    }
    
    // Task 31
    public static void task31(){
        mm.displayAllMatch();
    }
    
    // Task 32
    public static void task32(){
        mm.createPerformance();
    }
    
    // Task 33
    public static void task33(){
        mm.searchPerformance();
    }
    
    // Task 34
    public static void task34(){
        mm.updateGoal();
    }
    
    // Task 35
    public static void task35(){
        mm.updateAssist();
    }
    
    // Task 36
    public static void task36(){
        mm.updateYellow();
    }
    
    // Task 37
    public static void task37(){
        mm.updateRed();
    }
    
    // Task 38
    public static void task38(){
        mm.updateminutes();
    }
    
    // Task 39
    public static void task39(){
        mm.displayAllPerformance();
    }
    
    // Task 40
    public static void task40(){
        tm.createTraining();
    }
    
    // Task 41
    public static void task41(){
        tm.searchTrainingId();
    }
    
    // Task 42
    public static void task42(){
        tm.searchTrainingDate();
    }
    
    // Task 43
    public static void task43(){
        tm.searchTrainingLocation();
    }
    
    // Task 44
    public static void task44(){
        tm.searchTrainingTopic();
    }
    
    // Task 45
    public static void task45(){
        tm.updateTrainingDate();
    }
    
    // Task 46
    public static void task46(){
        tm.updateTrainingLocation();
    }
    
    // Task 47
    public static void task47(){
        tm.updateTrainingTopic();
    }
    
    // Task 48
    public static void task48(){
        tm.displayAllTraining();
    }
    
    // Task 49
    public static void task49(){
        tm.createAttendance();
    }
    
    // Task 50
    public static void task50(){
        tm.searchAttendance();
    }
    
    // Task 51
    public static void task51(){
        tm.updateAttendPlayerId();
    }
    
    // Task 52
    public static void task52(){
        tm.updateAttendOrAbsent();
    }
    
    // Task 53
    public static void task53(){
        tm.displayAllAttendance();
    }
    
    // Task 54_1 Report 1
    public static void task54_1(){
        rm.report1();
    }
    
    // Task 54_2
    public static void task54_2(){
        dm.readSalaryReportTXT();
    }
    
    // Task 55_1 Report 2
    public static void task55_1(){
        rm.report2();
    }
    
    // Task 55_2
    public static void task55_2(){
        dm.readRankingReportTXT();
    }
    
    // Task 56
    public static void task56(){
        dm.saveRegularTXT();
    }
    
    // Task 57
    public static void task57(){
        dm.readRegularTXT();
    }
    
    // Task 58
    public static void task58(){
        dm.saveRegularBIN();
    }
    
    // Task 59
    public static void task59(){
        dm.readRegularBIN();
    }
    
    // Task 60
    public static void task60(){
        dm.saveStarTXT();
    }
    
    // Task 61
    public static void task61(){
        dm.readStarTXT();
    }
    
    // Task 62
    public static void task62(){
        dm.saveStarBIN();
    }
    
    // Task 63
    public static void task63(){
        dm.readStarBIN();
    }
    
    // Task 64
    public static void task64(){
        dm.saveMatchTXT();
    }
    
    // Task 65
    public static void task65(){
        dm.readMatchTXT();
    }
    
    // Task 66
    public static void task66(){
        dm.saveMatchBIN();
    }
    
    // Task 67
    public static void task67(){
        dm.readMatchBIN();
    }
    
    // Task 68
    public static void task68(){
        dm.saveTrainingTXT();
    }
    
    // Task 69
    public static void task69(){
        dm.readTrainingTXT();
    }
    
    // Task 70
    public static void task70(){
        dm.saveTrainingBIN();
    }
    
    // Task 71
    public static void task71(){
        dm.readTrainingBIN();
    }
    
    // Input year
    public static int inputYear(){
        int year = 2000;
        try{
            while(true){
                System.out.print("Input year: ");
                year = Integer.parseInt(sc.nextLine());
                if(2000 <= year && year <= 2100) break;
            }
        }catch(NumberFormatException e){}
        return year;
    }

    // Input month
    public static int inputMonth(){
        int month = 1;
        try{
            while(true){
                System.out.print("Input month: ");
                month = Integer.parseInt(sc.nextLine());
                if(1 <= month && month <= 12) break;
            }
        }catch(NumberFormatException e){}
        return month;
    }
    
    // Input id
    public static String inputId(){
        System.out.print("Input ID: ");
        return sc.nextLine();
    }
}