# ⚽ Football Player Management System
This project is football player management system.<br>
You need to enter the some informations of players, trainings, matchings, performances, attendances to manage these informations<br>
the application has many menu as UI for user choose easily, inform error when you input incorrectly<br>
this application has some functions such as create, search, update, calculating salary of month and year<br>
one can save all information in file .txt, .bin for each type, and can download, upload for reading, writing<br>
This application is for all ages, anyone can install and use. Especially for football player manager.

## 🌟 Main features
* Player Management: Create new players and display the full list of players in the team.  
* Player Search: Search for players by multiple criteria: ID, Name, Position, National, Status.  
*Player Update: Update player information including Name, National, Age, Position, Shirt Number, Base Salary, Status.  
* Salary Calculation: Calculate player salaries by month and by year, distinguishing between the two groups: Regular Player and Star Player.  
* Points Calculation: Calculate the total points of players by month and by year for both regular and star players.  
* Match Management: Create new matches and display the full list of saved matches.  
* Match Search: Search for matches by ID, Date, Opponent, Type.  
* Match Update: Edit match information including match date (Date), opponent (Opponent), and match type (Type).  
* Performance Management: Create new performance records for players in each match, look them up, and display the full list.  
* Performance Update: Update performance details including Goal, Assist, Yellow Card, Red Card, Minutes Played.  
* Training Management: Create new training sessions and display the full list of sessions.  
* Training Search: Search for training sessions by ID, Date, Location, Topic.  
* Training Update: Edit training session information including training date (Date), location (Location), and topic (Topic).  
* Attendance Management: Create new attendance records, look up attendance, and display the full list.  
* Attendance Update: Update the attendance ID (ID) and the player’s attendance status (Attend / Absent).  
* Salary Report: Export the salary report and reload its content from the Salary_Report.txt file.  
* Ranking Report: Export the player ranking report and reload its content from the Ranking_Report.txt file.  
* Save Text Files: Save data to text files: Regular_Player.txt, Star_Player.txt, Match_Record.txt, Training_Record.txt.  
* Load Text Files: Load data from text files back into the program for reuse.  
* Auto Load/Save Binary & Console UI: Automatically load all data from .bin files on startup and save it again on exit;  

## 🛠️ Technology used
The project is written in Java programming language<br>
Using IntelliJ IDEA 2026.2.3 and Amazon Corretto JDK 21.0.12<br>
Use file .txt, .bin<br>
The project does not use any database management systems or connect to databases<br>

## 🚀 Install and run
1 -- Open CMD or Git Bash at the location where you want to save the project,<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;then enter the following command to download the project:<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;git clone [https://github.com/sohatec/football_player_management.git](https://github.com/sohatec/football_player_management.git)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;The download folder name should be "football_player_management".<br>
2 -- Open any Java-supported IDE such as IntelliJ IDEA, Eclipse, NetBeans, and use JDK 21.<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Open the project named football_player_management, access src/Main.java, and then run it.<br>

## 💡 Usage Flow
When running the application, you can execute tasks by calling the task functions of the Cabinet class.<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Task 1 – Create Player  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Task 2–6 – Search Player  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Task 7–13 – Update Player  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Task 14 – Display All Players  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Task 15–16 – Monthly Salary  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Task 17–18 – Yearly Salary  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Task 19–22 – Total Points  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Task 23 – Create Match  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Task 24–27 – Search Match  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Task 28–30 – Update Match  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Task 31 – Display All Matches  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Task 32–33 – Create and Search Performance  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Task 34–38 – Update Performance  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Task 39 – Display All Performance  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Task 40 – Create Training  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Task 41–44 – Search Training  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Task 45–47 – Update Training  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Task 48 – Display All Training  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Task 49–53 – Attendance Management  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Task 54–55 – Reports  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Task 56–57, 60–61, 64–65, 68–69 – Save/Load TXT Files  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Task 58–59, 62–63, 66–67, 70–71 – Save/Load BIN Files  

## 🐳 Docker
Condition: You must install Docker Desktop software.  
Open Git Bash/CMD then enter this commend to download and run app.  
'docker run -it --rm henrylecode/moto_racing:1.0'  
Docker Hub: [https://hub.docker.com/r/henrylecode/moto_racing](https://hub.docker.com/r/henrylecode/moto_racing)

## 📂 Directory structure
src/  
├── controller/<br>
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;├── Cabinet.java<br>
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── RacingManager.java<br>
├── data/<br>
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── DataRacing.java<br>
├── entity/<br>
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;├── Aprilia.java<br>
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;├── Ducati.java<br>
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;├── Honda.java<br>
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;├── MotoGp.java<br>
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;├── Racing.java<br>
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── Yamaha.java<br>
├── menu/<br>
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── Menu.java<br>
└── Main.java<br>

## 🖼️ Images
![Image of game](https://github.com/sohatec/moto_racing/blob/main/images/1.png?raw=true)<br>
![Image of game](https://github.com/sohatec/moto_racing/blob/main/images/2.png?raw=true)<br>
![Image of game](https://github.com/sohatec/moto_racing/blob/main/images/3.png?raw=true)<br>
![Image of game](https://github.com/sohatec/moto_racing/blob/main/images/4.png?raw=true)<br>

## 🧑‍💻 Members
1. Vuong Tran Hieu Nghia - Analyze<br>
2. Henry Lecode - Coding<br>

## 📄 License
This project is copyrighted by **Vuong Tran Hieu Nghia** and distributed under the **MIT License**.<br>
You may use, learn from, and modify the source code freely, but please retain the original copyright notice.<br>
See details in the file [LICENSE](LICENSE)
