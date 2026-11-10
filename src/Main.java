import controller.Cabinet;
import java.util.Scanner;
import util.Menu;

public class Main {

    private static Menu m;
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Load all file.bin
        Cabinet.task59();
        Cabinet.task63();
        Cabinet.task67();
        Cabinet.task71();
        Menu.banner();
        Menu.countDown("LOADING");

        int c1;
        do {
            c1 = getChoice(Menu::mainMenu, 8, "Only 0-8");
            switch (c1) {
                case 1: // Player Mangement
                    int c11;
                    do {
                        c11 = getChoice(Menu::playerManagement, 4,"Only 0-4");
                        switch (c11) {
                            case 1: // Creating Player
                                Cabinet.task1();
                                break;
                            case 2: // Seraching Player
                                int c112;
                                do {
                                    c112 = getChoice(Menu::searchingPlayer, 5,"Only 0-5");
                                    switch (c112) {
                                        case 1: // Search Player By ID
                                            Cabinet.task2();
                                            break;
                                        case 2: // Search Player By Name
                                            Cabinet.task3();
                                            break;
                                        case 3: // Search Player By Position
                                            Cabinet.task4();
                                            break;
                                        case 4: // Search Player By National
                                            Cabinet.task5();
                                            break;
                                        case 5: // Search Player By Status
                                            Cabinet.task6();
                                            break;
                                    }
                                } while (c112 != 0);
                                break;
                            case 3: // Updating Player
                                int c113;
                                do{
                                    c113 = getChoice(Menu::updatingPlayer, 7,"Only 0-7");
                                    switch(c113){
                                        case 1: // Update Name Player
                                            Cabinet.task7();
                                            break;
                                        case 2: // Update National Player
                                            Cabinet.task8();
                                            break;
                                        case 3: // Update Age Player
                                            Cabinet.task9();
                                            break;
                                        case 4: // Update Position Player
                                            Cabinet.task10();
                                            break;
                                        case 5: // Update Shirt Number Player
                                            Cabinet.task11();
                                            break;
                                        case 6: // Update Base Salary Player
                                            Cabinet.task12();
                                            break;
                                        case 7: // Update Status Player
                                            Cabinet.task13();
                                            break;
                                    }
                                }while(c113 != 0);
                                break;
                            case 4: // Display All Player
                                Cabinet.task14();
                                break;
                        }
                    } while (c11 != 0);
                    break;
                case 2: // Report Management
                    int c12;
                    do {
                        c12 = getChoice(Menu::report,4, "Only 0-4");
                        switch (c12) {
                            case 1: // Report Salary
                                Cabinet.task54_1();
                                break;
                            case 2: // Loading Salary_Report.txt
                                Cabinet.task54_2();
                                break;
                            case 3: // Report Ranking
                                Cabinet.task55_1();
                                break;
                            case 4: // Loading Ranking_Report.txt
                                Cabinet.task55_2();
                                break;
                        }
                    } while (c12 != 0);
                    break;
                case 3: // Salary Management
                    int c13;
                    do {
                        c13 = getChoice(Menu::salary_point, 2,"Only 0-2");
                        switch (c13) {
                            case 1: // Salary Of Player
                                int c131;
                                do {
                                    c131 = getChoice(Menu::salaryOfPlayer, 4,"Only 0-4");
                                    switch (c131) {
                                        case 1: // Regular Salary Month
                                            Cabinet.task15();
                                            break;
                                        case 2: // Star Salary Month
                                            Cabinet.task16();
                                            break;
                                        case 3: // Regular Salary Year
                                            Cabinet.task17();
                                            break;
                                        case 4: // Star Salary Year
                                            Cabinet.task18();
                                            break;
                                    }
                                } while (c131 != 0);
                                break;
                            case 2: // Points Of Player
                                int c132;
                                do {
                                    c132 = getChoice(Menu::pointsOfPlayer, 4,"Only 0-4");
                                    switch (c132) {
                                        case 1: // Regular Total Points Month
                                            Cabinet.task19();
                                            break;
                                        case 2: // Star Total Points Month
                                            Cabinet.task20();
                                            break;
                                        case 3: // Regular Total Points Year
                                            Cabinet.task21();
                                            break;
                                        case 4: // Star Total Points Year
                                            Cabinet.task22();
                                            break;
                                    }
                                } while (c132 != 0);
                                break;
                        }
                    } while (c13 != 0);
                    break;
                case 4:// Training Management
                    int c14;
                    do {
                        c14 = getChoice(Menu::trainingManagement, 4,"Only 0-4");
                        switch (c14) {
                            case 1: // Creating Training
                                Cabinet.task40();
                                break;
                            case 2: // Searching Training
                                int c142;
                                do {
                                    c142 = getChoice(Menu::searchingTraining,4, "Only 0-4");
                                    switch (c142) {
                                        case 1: // Searching Training ID
                                            Cabinet.task41();
                                            break;
                                        case 2: // Searching Training Date
                                            Cabinet.task42();
                                            break;
                                        case 3: // Searching Training Location
                                            Cabinet.task43();
                                            break;
                                        case 4: // Searching Training Topic
                                            Cabinet.task44();
                                            break;
                                    }
                                } while (c142 != 0);
                                break;
                            case 3: // Updating Training
                                int c143;
                                do {
                                    c143 = getChoice(Menu::updatingTraining, 3,"Only 0-3");
                                    switch (c143) {
                                        case 1: // Updating Training Date
                                            Cabinet.task45();
                                            break;
                                        case 2: // Updating Training Location
                                            Cabinet.task46();
                                            break;
                                        case 3: // Updating Training Topic
                                            Cabinet.task47();
                                            break;
                                    }
                                } while (c143 != 0);
                                break;
                            case 4: // Display All Training
                                Cabinet.task48();
                                break;
                        }
                    } while (c14 != 0);
                    break;
                case 5: // Matching Management
                    int c15;
                    do {
                        c15 = getChoice(Menu::matchingManagement, 4,"Only 0-4");
                        switch (c15) {
                            case 1: // Creating Match
                                Cabinet.task23();
                                break;
                            case 2: // Searching Match
                                int c152;
                                do {
                                    c152 = getChoice(Menu::searchingMatch, 4,"Only 0-4");
                                    switch (c152) {
                                        case 1: // Searching Match ID
                                            Cabinet.task24();
                                            break;
                                        case 2: // Searching Match Date
                                            Cabinet.task25();
                                            break;
                                        case 3: // Searching Match Opponent
                                            Cabinet.task26();
                                            break;
                                        case 4: // Searching Match Type
                                            Cabinet.task27();
                                            break;
                                    }
                                } while (c152 != 0);
                                break;
                            case 3: // Updating Match
                                int c153;
                                do {
                                    c153 = getChoice(Menu::updatingMatch,3, "Only 0-3");
                                    switch (c153) {
                                        case 1: // Updating Match Date
                                            Cabinet.task28();
                                            break;
                                        case 2: // Updating Match Oppnent
                                            Cabinet.task29();
                                            break;
                                        case 3: // Updating Match Type
                                            Cabinet.task30();
                                            break;
                                    }
                                } while (c153 != 0);
                                break;
                            case 4: // Display All Match
                                Cabinet.task31();
                                break;
                        }
                    } while (c15 != 0);
                    break;
                case 6: // Performance Management
                    int c16;
                    do {
                        c16 = getChoice(Menu::performanceManagement, 4,"Only 0-4");
                        switch (c16) {
                            case 1: // Creating Performance
                                Cabinet.task32();
                                break;
                            case 2: // Searching Performance
                                Cabinet.task33();
                                break;
                            case 3: // Updating Performance
                                int c163;
                                do {
                                    c163 = getChoice(Menu::updatingPerformance,5, "Only 0-5");
                                    switch (c163) {
                                        case 1: // Updating Performance Goal
                                            Cabinet.task34();
                                            break;
                                        case 2: // Updating Performance Assist
                                            Cabinet.task35();
                                            break;
                                        case 3: // Updating Performance Yellow
                                            Cabinet.task36();
                                            break;
                                        case 4: // Updating Performance Red
                                            Cabinet.task37();
                                            break;
                                        case 5: // Updating Performance Minutes
                                            Cabinet.task38();
                                            break;
                                    }
                                } while (c163 != 0);
                                break;
                            case 4: // Display All Performance
                                Cabinet.task39();
                                break;
                        }
                    } while (c16 != 0);
                    break;
                case 7: // Attendance management
                    int c17;
                    do {
                        c17 = getChoice(Menu::AttendanceManagement, 4,"Only 0-4");
                        switch (c17) {
                            case 1: // Creating Attendance
                                Cabinet.task49();
                                break;
                            case 2: // Searching Attendance
                                Cabinet.task50();
                                break;
                            case 3: // Updating Attendance
                                int c173;
                                do {
                                    c173 = getChoice(Menu::updatingAttendance, 2,"Only 0-2");
                                    switch (c173) {
                                        case 1: // Updating Attendance ID
                                            Cabinet.task51();
                                            break;
                                        case 2: // Updating Attend Or Absent
                                            Cabinet.task52();
                                            break;
                                    }
                                } while (c173 != 0);
                                break;
                            case 4: // Display All Attendance
                                Cabinet.task53();
                                break;
                        }
                    } while (c17 != 0);
                    break;
                case 8: // File
                    int c18;
                    do {
                        c18 = getChoice(Menu::file, 2,"Only 0-2");
                        switch (c18) {
                            case 1: // Save file.txt
                                int c181;
                                do {
                                    c181 = getChoice(Menu::saveFile, 4,"Only 0-4");
                                    switch (c181) {
                                        case 1: // Saving Regular_Player.txt
                                            Cabinet.task56();
                                            break;
                                        case 2: // Saving Star_Player.txt
                                            Cabinet.task60();
                                            break;
                                        case 3: // Saving Match_Record.txt
                                            Cabinet.task64();
                                            break;
                                        case 4: // Saving Training_Record.txt
                                            Cabinet.task68();
                                            break;
                                    }
                                } while (c181 != 0);
                                break;
                            case 2: // Load file.bin
                                int c182;
                                do {
                                    c182 = getChoice(Menu::loadFile, 4,"Only 0-4");
                                    switch (c182) {
                                        case 1: // Loading Regular_Player.txt
                                            Cabinet.task57();
                                            break;
                                        case 2: // Loading Star_Player.txt
                                            Cabinet.task61();
                                            break;
                                        case 3: // Loading Match_Record.txt
                                            Cabinet.task65();
                                            break;
                                        case 4: // Loading Training_Record.txt
                                            Cabinet.task69();
                                            break;
                                    }
                                } while (c182 != 0);
                                break;
                        }
                    } while (c18 != 0);
                    break;
            }
        } while (c1 != 0);

        // Save all file.bin
        Cabinet.task58();
        Cabinet.task62();
        Cabinet.task66();
        Cabinet.task70();
    }

    private static int getChoice(Runnable menuPrinter, int max, String errorMsg) {
        while (true) {
            menuPrinter.run();
            try {
                int num = Integer.parseInt(sc.nextLine().trim());
                if (num >= 0 && num <= max)
                    return num;
                else System.out.println(errorMsg);
            } catch (NumberFormatException e) {
                System.out.println(errorMsg);
            }
        }
    }
}