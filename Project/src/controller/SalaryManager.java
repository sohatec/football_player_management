
package controller;
import data.DataManager;
import entity.MatchRecord;
import entity.PerformanceRecord;
import entity.RegularPlayer;
import entity.StarPlayer;
public class SalaryManager {
    
    // Tạo biến và hàm nhận data, để xài và truy cập vào data chung
    // Nếu private final DataManager data = new DataManager(); thì khi gọi
    // nó sẽ tạo mới và không truy cập vào data chung được
    private final DataManager dm;
    public SalaryManager(DataManager dm){
        this.dm = dm;
    }
    
     // Tìm Regular Player theo ID trong danh sách chung (KHÔNG dùng object rỗng)
    private RegularPlayer findRegular(String playerId){
        for(RegularPlayer p : dm.listRegular()){
            if(p.getPlayerId().equals(playerId)) return p;
        }
        return null;
    }

    // Tìm Star Player theo ID trong danh sách chung (KHÔNG dùng object rỗng)
    private StarPlayer findStar(String playerId){
        for(StarPlayer p : dm.listStar()){
            if(p.getPlayerId().equals(playerId)) return p;
        }
        return null;
    }
    
    // Total points in month
    public int totalPointsMonth(String playerId, int month, int year){
        int totalPoints = 0;
        for(MatchRecord m : dm.listMatch()){
            if(m.getDate().getYear() == year && m.getDate().getMonthValue() == month){
                for(PerformanceRecord p : m.getPerformances()){
                    if(p.getPlayerId().equals(playerId)){
                        totalPoints += p.totalPoints();
                    }
                }
            }
        }
        return totalPoints;
    }
    
    // Total points in year
    public int totalPointsYear(String playerId, int year){
        int totalPoints = 0;
        for(MatchRecord m : dm.listMatch()){
            if(m.getDate().getYear() == year){
               for(PerformanceRecord p : m.getPerformances()){
                    if(p.getPlayerId().equals(playerId)){
                        totalPoints += p.totalPoints();
                    }
                } 
            }
        }
        return totalPoints;
    }
    
    // Regular salary month
    public double regularSalaryMonth(String playerId,int month, int year){
        RegularPlayer p = findRegular(playerId);
        if(p == null){
            System.out.println("Regular Player ID not found !!!");
            return 0;
        }
        return p.salaryMonth(totalPointsMonth(playerId, month, year));
    }
    
    // Star salary month
    public double starSalaryMonth(String playerId,int month, int year){
        StarPlayer p = findStar(playerId);
        if(p == null){
            System.out.println("Star Player ID not found !!!");
            return 0;
        }
        return p.salaryMonth(totalPointsMonth(playerId, month, year));
    }
    
    // Regular salary year
    public double regularSalaryYear(String playerId, int year){
        RegularPlayer p = findRegular(playerId);
        if(p == null){
            System.out.println("Regular Player ID not found !!!");
            return 0;
        }
        return p.salaryYear(totalPointsYear(playerId, year));
    }
    
    // Star salary year
    public double starSalaryYear(String playerId, int year){
        StarPlayer p = findStar(playerId);
        if(p == null){
            System.out.println("Star Player ID not found !!!");
            return 0;
        }
        return p.salaryYear(totalPointsYear(playerId, year));
    }
}
