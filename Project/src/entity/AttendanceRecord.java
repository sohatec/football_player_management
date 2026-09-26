
package entity;
public class AttendanceRecord {
    private String playerId;
    private String attendance;

    public AttendanceRecord(String playerId, String attendance) {
        setPlayerId(playerId);
        setAttendance(attendance);
    }

    public String getPlayerId() {
        return playerId;
    }

    public final void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getAttendance() {
        return attendance;
    }

    public final void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    @Override
    public String toString() {
        return String.format("|%-15s|%-15s|", getPlayerId(), getAttendance());
    }
}
