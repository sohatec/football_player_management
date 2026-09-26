
package util;

public class Menu {

//  ALL MENU OF MAINING ////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    // Main menu
    public static void mainMenu(){
        System.out.println("=====================================");
        System.out.println("| (1) Player Management             |");
        System.out.println("| (2) Report Management             |");
        System.out.println("| (3) Salary Management             |");
        System.out.println("| (4) Training Management           |");
        System.out.println("| (5) Matching Management           |");
        System.out.println("| (6) Performance Management        |");
        System.out.println("| (7) Attendance Management         |");
        System.out.println("|-----------------------------------|");
        System.out.println("| (0) SHUTDOWN                      |");
        System.out.println("=====================================");
    }

//  ALL MENU OF PALYER /////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    // Menu player position
    public static void menuPlayerPositon(){
        System.out.println("===================");
        System.out.println("| (1) Goalkeeper  |");
        System.out.println("| (2) Defender    |");
        System.out.println("| (3) Midfielder  |");
        System.out.println("| (4) Forwar      |");
        System.out.println("===================");
    }
    
    // Menu status
    public static void menuStatus(){
        System.out.println("====================");
        System.out.println("| (1) Active       |");
        System.out.println("| (2) Inactive     |");
        System.out.println("====================");
    }
    
    // Salary and point
    public static void salary_point(){
        System.out.println("=====================================");
        System.out.println("| (1) Salary Of Player              |");
        System.out.println("| (2) Points Of Player              |");
        System.out.println("|-----------------------------------|");
        System.out.println("| (0) QUIT                          |");
        System.out.println("=====================================");
    }

    // Player management
    public static void playerManagement(){
        System.out.println("=====================================");
        System.out.println("| (1) Creating Player               |");
        System.out.println("| (2) Searching Player              |");
        System.out.println("| (3) Updating Player               |");
        System.out.println("| (4) Display All Player            |");
        System.out.println("|-----------------------------------|");
        System.out.println("| (0) QUIT                          |");
        System.out.println("=====================================");
    }

    // Searching player
    public static void searchingPlayer(){
        System.out.println("=====================================");
        System.out.println("| (1) Search Player By ID           |");
        System.out.println("| (2) Search Player By Name         |");
        System.out.println("| (3) Search Player By Positon      |");
        System.out.println("| (4) Search Player By National     |");
        System.out.println("| (5) Search Player By Status       |");
        System.out.println("|-----------------------------------|");
        System.out.println("| (0) QUIT                          |");
        System.out.println("=====================================");
    }
    
    // Updating player
    public static void updatingPlayer(){
        System.out.println("=====================================");
        System.out.println("| (1) Update Name Player            |");
        System.out.println("| (2) Update National Player        |");
        System.out.println("| (3) Update Age Player             |");
        System.out.println("| (4) Update Position Player        |");
        System.out.println("| (5) Update Shirt Number Player    |");
        System.out.println("| (6) Update Base Salary Player     |");
        System.out.println("| (7) Update Status Player          |");
        System.out.println("|-----------------------------------|");
        System.out.println("| (0) QUIT                          |");
        System.out.println("=====================================");
    }
     
    // Salary Of player
    public static void salaryOfPlayer(){
        System.out.println("=====================================");
        System.out.println("| (1) Regular Salary Month          |");
        System.out.println("| (2) Star Salary Month             |");
        System.out.println("| (3) Regular Salary Year           |");
        System.out.println("| (4) Star Salary Year              |");
        System.out.println("|-----------------------------------|");
        System.out.println("| (0) QUIT                          |");
        System.out.println("=====================================");
    }    
    
    // Points of player
    public static void pointsOfPlayer(){
        System.out.println("=====================================");
        System.out.println("| (1) Regular Total Points Month    |");
        System.out.println("| (2) Star Total Points Month       |");
        System.out.println("| (3) Regular Total Points Year     |");
        System.out.println("| (4) Star Total Points Year        |");
        System.out.println("|-----------------------------------|");
        System.out.println("| (0) QUIT                          |");
        System.out.println("=====================================");
    }
    
    // Menu type player
    public static void menuTypePlayer0(){
        System.out.println("=====================================");
        System.out.println("| (1) NEW REGULAR PLAYER            |");
        System.out.println("| (2) NEW STAR PLAYER               |");
        System.out.println("|-----------------------------------|");
        System.out.println("| (0) QUIT                          |");
        System.out.println("=====================================");
    }
    
    // Menu type player
    public static void menuTypePlayer(){
        System.out.println("=====================================");
        System.out.println("| (1) Regular Player                |");
        System.out.println("| (2) Star Player                   |");
        System.out.println("|-----------------------------------|");
        System.out.println("| (0) QUIT                          |");
        System.out.println("=====================================");
    }
    
    // Header for player
    public static void header1(){
        System.out.format("|%-10s|%-30s|%-5s|%-15s|%-12s|%-10s|%-15s|%-10s|\n",
                          "ID", "NAME", "AGE", "NATIONAL", "POSITION", 
                          "SHIRT NO", "SALARY", "STATUS");
    }
    
    // Header for salary
    public static void header2(){
        System.out.format("|%-10s|%-30s|%15s|\n", "ID", "NAME", "SALARY");
    }

    // Header for total points
    public static void header3(){
        System.out.format("|%-10s|%-30s|%15s|\n", "ID", "NAME", "TOTALPOINTS");
    }
    
// ALL MENU OF MATCH ///////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////    
    
    // Matching management
    public static void matchingManagement(){
        System.out.println("=====================================");
        System.out.println("| (1) Creating Match                |");
        System.out.println("| (2) Searching Match               |");
        System.out.println("| (3) Updating Match                |");
        System.out.println("| (4) Display All Match             |");
        System.out.println("|-----------------------------------|");
        System.out.println("| (0) QUIT                          |");
        System.out.println("=====================================");
    }

    // Searching match
    public static void searchingMatch(){
        System.out.println("=====================================");
        System.out.println("| (1) Searching Match ID            |");
        System.out.println("| (2) Searching Match Date          |");
        System.out.println("| (3) Searching Match Opponent      |");
        System.out.println("| (4) Searching Match Type          |");
        System.out.println("|-----------------------------------|");
        System.out.println("| (0) QUIT                          |");
        System.out.println("=====================================");
    }
    
    // Updating match
    public static void updatingMatch(){
        System.out.println("=====================================");
        System.out.println("| (1) Updating Match Date           |");
        System.out.println("| (2) Updating Match Opponent       |");
        System.out.println("| (3) Updating Match Type           |");
        System.out.println("|-----------------------------------|");
        System.out.println("| (0) QUIT                          |");
        System.out.println("=====================================");
    }
    
    // Menu type match
    public static void menuMatchType(){
        System.out.println("===================");
        System.out.println("| (1) Friendly    |");
        System.out.println("| (2) League      |");
        System.out.println("| (3) Cup         |");
        System.out.println("===================");
    }
    
    // Header for match
    public static void header5(){
        System.out.format("|%-10s|%-15s|%-20s|%-15s|\n", "MatchId", "Date", 
                          "Opponent Team", "Match Type");
    }
    
// ALL MENU OF PERFORMANCE /////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    // Performance management
    public static void performanceManagement(){
        System.out.println("=====================================");
        System.out.println("| (1) Creating Performance          |");
        System.out.println("| (2) Searching Performance         |");
        System.out.println("| (3) Updating Performance          |");
        System.out.println("| (4) Display All Performance       |");
        System.out.println("|-----------------------------------|");
        System.out.println("| (0) QUIT                          |");
        System.out.println("=====================================");
    }
    
    // Updating performance
    public static void updatingPerformance(){
        System.out.println("=====================================");
        System.out.println("| (1) Updating Performance Goal     |");
        System.out.println("| (2) Updating Performance Assist   |");
        System.out.println("| (3) Updating Performance Yellow   |");
        System.out.println("| (4) Updating Performance Red      |");
        System.out.println("| (5) Updating Performance Minutes  |");
        System.out.println("|-----------------------------------|");
        System.out.println("| (0) QUIT                          |");
        System.out.println("=====================================");
    }
    
    // Header for performance
    public static void header6(){
        System.out.format("|%-10s|%-10s|%-5s|%-5s|%-5s|%-5s|%-10s|\n", 
                          "Match ID", "Player ID", "Goals", "Assist",
                          "Yellow Card", "Red Card", "Minutes Player");
    }
    
// ALL PLAYER OF TRAINING //////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////    
    // Training management
    public static void trainingManagement(){
        System.out.println("=====================================");
        System.out.println("| (1) Creating Training             |");
        System.out.println("| (2) Searching Training            |");
        System.out.println("| (3) Updating Training             |");
        System.out.println("| (4) Display All Training          |");
        System.out.println("|-----------------------------------|");
        System.out.println("| (0) QUIT                          |");
        System.out.println("=====================================");
    }
    
    // Searching training
    public static void searchingTraining(){
        System.out.println("=====================================");
        System.out.println("| (1) Searching Training ID         |");
        System.out.println("| (2) Searching Training Date       |");
        System.out.println("| (3) Searching Training Location   |");
        System.out.println("| (4) Searching Training Topic      |");
        System.out.println("|-----------------------------------|");
        System.out.println("| (0) QUIT                          |");
        System.out.println("=====================================");
    }
    
    // Updating training
    public static void updatingTraining(){
        System.out.println("=====================================");
        System.out.println("| (1) Updating Training Date        |");
        System.out.println("| (2) Updating Training Location    |");
        System.out.println("| (3) Updating Training Topic       |");
        System.out.println("|-----------------------------------|");
        System.out.println("| (0) QUIT                          |");
        System.out.println("=====================================");
    }
    
    // Header for training session
    public static void header7(){
        System.out.format("|%-10s|%-15s|%-60s|%-60s|\n", "ID", "Date", 
                          "Location", "Topic");
    }
    
// ALL MENU OF ATTENDANCE //////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////    
    // Attendance management
    public static void AttendanceManagement(){
        System.out.println("=====================================");
        System.out.println("| (1) Creating Attendance           |");
        System.out.println("| (2) Searching Attendance          |");
        System.out.println("| (3) Updating Attendance           |");
        System.out.println("| (4) Display All Attendance        |");
        System.out.println("|-----------------------------------|");
        System.out.println("| (0) QUIT                          |");
        System.out.println("=====================================");
    }
    
    // Updating attendance
    public static void updatingAttendance(){
        System.out.println("=====================================");
        System.out.println("| (1) Updating Attendance ID        |");
        System.out.println("| (2) Updating Attend Or Absent     |");
        System.out.println("|-----------------------------------|");
        System.out.println("| (0) QUIT                          |");
        System.out.println("=====================================");
    }

    // Header for attendance
    public static void header4(){
        System.out.format("|%-15s|%-15s|\n", "Player ID", "Status");
    }
    
    // Menu attend or absent
    public static void attenOrAbsent(){
        System.out.println("===================");
        System.out.println("|  (1) Attend     |");
        System.out.println("|  (2) Absent     |");
        System.out.println("===================");
    }
    
// ALL MENU OF FILE ////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    // File
    public static void file(){
        System.out.println("=====================================");
        System.out.println("|  (1) Saving files                 |");
        System.out.println("|  (2) Loading files                |");
        System.out.println("|-----------------------------------|");
        System.out.println("|  (0) QUIT                         |");
        System.out.println("=====================================");
    }
    
    // Save file.txt
    public static void saveFile(){
        System.out.println("=====================================");
        System.out.println("|  (1) Saving Regular_Player.txt    |");
        System.out.println("|  (2) Saving Star_Player.txt       |");
        System.out.println("|  (3) Saving Match_Record.txt      |");
        System.out.println("|  (4) Saving Training_Record.txt   |");
        System.out.println("|-----------------------------------|");
        System.out.println("|  (0) QUIT                         |");
        System.out.println("=====================================");
    }
    
    // Load file.bin
    public static void loadFile(){
        System.out.println("=====================================");
        System.out.println("|  (1) Loading Regular_Player.txt   |");
        System.out.println("|  (2) Loading Star_Player.txt      |");
        System.out.println("|  (3) Loading Match_Record.txt     |");
        System.out.println("|  (4) Loading Training_Record.txt  |");
        System.out.println("|-----------------------------------|");
        System.out.println("|  (0) QUIT                         |");
        System.out.println("=====================================");
    }
    
// ALL MENU OF REPORT //////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    // Menu report
    public static void report(){
        System.out.println("=====================================");
        System.out.println("|  (1) Report Salary                |");
        System.out.println("|  (2) Loading Salary_Report.txt    |");
        System.out.println("|  (3) Report Ranking               |");
        System.out.println("|  (4) Loading Ranking_Report.txt   |");
        System.out.println("|-----------------------------------|");
        System.out.println("|  (0) QUIT                         |");
        System.out.println("=====================================");
    }
}
