package controller;

import data.DataManager;
import entity.MatchRecord;
import entity.PerformanceRecord;
import entity.Player;
import entity.RegularPlayer;
import entity.StarPlayer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReportManager {
    // Declare a variable and a method to receive and access the shared data.
    // Initializing with "private final DataManager data = new DataManager();"
    // will create a new object, preventing access to the shared instance.
    private final DataManager dm;
    private final Scanner sc = new Scanner(System.in);

    public ReportManager(DataManager dm) {
        this.dm = dm;
    }

    // Total points month
    private int totalPointsMonth(String playerId, int month, int year) {
        int total = 0;
        for (MatchRecord m : dm.listMatch()) {
            if (m.getDate().getYear() == year && m.getDate().getMonthValue() == month) {
                for (PerformanceRecord p : m.getPerformances()) {
                    if (p.getPlayerId().equals(playerId)) {
                        total += p.totalPoints();
                    }
                }
            }
        }
        return total;
    }

    // Append Salary Row
    private double appendSalaryRow(StringBuilder sb, Player p, String type, int month, int year) {
        int points = totalPointsMonth(p.getPlayerId(), month, year);
        double bonus = p.bonusMonth(points);
        double salary = p.salaryMonth(points);
        sb.append(String.format("%-6s | %-30s | %12s | %15.2f | %10d | %15.2f | %15.2f\n",
                p.getPlayerId(), p.getName(), type, p.getBaseSalary(), points, bonus, salary));
        return salary;
    }

    // Report 1
    public void report1() {
        int year = inputNumber("Input year: ");
        int month = inputNumber("Input month: ");

        StringBuilder sb = new StringBuilder();
        sb.append("=========================================================================================================================\n");
        sb.append("                                                SUMMARY REPORT\n");
        sb.append("=========================================================================================================================\n");
        sb.append(String.format("%-6s | %-30s | %-12s | %-15s | %-10s | %-15s | %-15s\n",
                "ID", "Name", "Type", "Base Salary", "Point", "Bonus", "Salary Month"));
        sb.append("-------------------------------------------------------------------------------------------------------------------------\n");

        double total = 0;
        for (RegularPlayer r : dm.listRegular())
            total += appendSalaryRow(sb, r, "Regular", month, year);
        for (StarPlayer s : dm.listStar())
            total += appendSalaryRow(sb, s, "Star", month, year);

        sb.append("-------------------------------------------------------------------------------------------------------------------------\n");
        sb.append(String.format("TOTAL SPEND OF CLUB IN MONTH: %.2f\n", total));
        sb.append("=========================================================================================================================\n");

        System.out.print(sb); // Display on screen
        dm.saveTXTReport("Salary_Report.txt", sb.toString(), "Saved Salary Report TXT !!!"); // Auto save Salary_Report.txt
    }

    // Report 2
    public void report2() {
        Map<String, Integer> goals = new HashMap<>();
        for (MatchRecord m : dm.listMatch()) {
            for (PerformanceRecord p : m.getPerformances()) {
                String id = p.getPlayerId();
                int playerGoals = p.getGoals();
                if (goals.containsKey(id))
                    goals.put(id, goals.get(id) + playerGoals);
                else
                    goals.put(id, playerGoals);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\n=============================================================\n");
        sb.append("                TOP SCORER RANKINGS\n");
        sb.append("=============================================================\n");
        sb.append(String.format("%-4s | %-6s | %-30s | %-10s\n", "Rank", "ID", "Name", "Wining"));
        sb.append("-------------------------------------------------------------\n");
        int rank = 1;
        while (!goals.isEmpty()) {
            String topId = null;
            int topGoal = -1;
            for (Map.Entry<String, Integer> e : goals.entrySet())
                if (e.getValue() > topGoal) {
                    topGoal = e.getValue();
                    topId = e.getKey();
                }

            String name = findPlayerName(topId);
            sb.append(String.format("%4d | %6s | %30s | %10d\n", rank++, topId, name, topGoal));
            goals.remove(topId);
        }
        sb.append("=============================================================\n");
        System.out.print(sb); // Display on screen
        dm.saveTXTReport("Ranking_Report.txt", sb.toString(), "Saved Ranking Report TXT !!!"); // Auto save Ranking_Report.txt
    }

    // Find name player follow ID
    private String findPlayerName(String playerId) {
        if (playerId.startsWith("RG")) {
            for (RegularPlayer r : dm.listRegular())
                if (r.getPlayerId().equals(playerId))
                    return r.getName();
        }
        if (playerId.startsWith("ST")) {
            for (StarPlayer s : dm.listStar())
                if (s.getPlayerId().equals(playerId))
                    return s.getName();
        }
        return "Unknown";
    }

    // Input number
    public int inputNumber(String ms) {
        while (true) {
            System.out.print(ms);
            try {
                int number = Integer.parseInt(sc.nextLine());
                if (number <= 0)
                    System.out.println("Value > 0 and must be integer !!!");
                else
                    return number;
            } catch (NumberFormatException e) {
                System.out.println("Value > 0 and must be integer !!!");
            }
        }
    }
}