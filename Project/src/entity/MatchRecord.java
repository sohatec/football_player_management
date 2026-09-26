package entity;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MatchRecord {
    private String matchId;
    private LocalDate date;
    private String opponentTeam;
    private String matchType; 
    private List<PerformanceRecord> performances;

    public MatchRecord(String matchId, LocalDate date, String opponentTeam, String matchType) {
        setMatchId(matchId);
        setDate(date);
        setOpponentTeam(opponentTeam);
        setMatchType(matchType);
        setPerformances();
    }

    public String getMatchId() {
        return matchId;
    }

    public final void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public LocalDate getDate() {
        return date;
    }

    public final void setDate(LocalDate date) {
        this.date = date;
    }

    public String getOpponentTeam() {
        return opponentTeam;
    }

    public final void setOpponentTeam(String opponentTeam) {
        this.opponentTeam = opponentTeam;
    }

    public String getMatchType() {
        return matchType;
    }

    public final void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public List<PerformanceRecord> getPerformances() {
        return performances;
    }

    public final void setPerformances() {
        this.performances = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatDate = (date != null) ? date.format(formatter) : "null";
        return String.format("|%-10s|%15s|%20s|%15s|", 
                            matchId, formatDate, opponentTeam, matchType);
    }
}