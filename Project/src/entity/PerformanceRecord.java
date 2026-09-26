
package entity;

public class PerformanceRecord {
    private String marchId;
    private String playerId;
    private int goals;
    private int assist;
    private int yellowCard;
    private int redCard;
    private double minutesPlayer;

    public PerformanceRecord(String marchId, String playerId, int goals, int assist, 
                             int yellowCard, int redCard, double minutesPlayer){
        setMarchId(marchId);
        setPlayerId(playerId);
        setGoals(goals);
        setAssist(assist);
        setYellowCard(yellowCard);
        setRedCard(redCard);
        setMinutesPlayer(minutesPlayer);
    }

    public String getMarchId() {
        return marchId;
    }

    public final void setMarchId(String marchId) {
        this.marchId = marchId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public final void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public int getGoals() {
        return goals;
    }

    public final void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssist() {
        return assist;
    }

    public final void setAssist(int assist) {
        this.assist = assist;
    }

    public int getYellowCard() {
        return yellowCard;
    }

    public final void setYellowCard(int yellowCard) {
        this.yellowCard = yellowCard;
    }

    public int getRedCard() {
        return redCard;
    }

    public final void setRedCard(int redCard) {
        this.redCard = redCard;
    }

    public double getMinutesPlayer() {
        return minutesPlayer;
    }

    public final void setMinutesPlayer(double minutesPlayer) {
        this.minutesPlayer = minutesPlayer;
    }
    
    public int totalPoints() {
        int total = (goals * 5) + (assist * 3) - (yellowCard * 1) - (redCard * 3);
        return Math.max(0, total);
    }

    @Override
    public String toString(){
        return String.format("|%-10s|%-10s|%5d|%5d|%5d|%5d|%10.2f|\n", 
                           getMarchId(), getPlayerId(), getGoals(), getAssist(), 
                           getYellowCard(), getRedCard(), getMinutesPlayer());
    }
}