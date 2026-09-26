package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TrainingRecord {
    private String trainingId;
    private LocalDate date;
    private String location;
    private String topic;
    private List<AttendanceRecord> attendances;

    public TrainingRecord(String trainingId, LocalDate date, String location, String topic) {
        setTrainingId(trainingId);
        setDate(date);
        setLocation(location);
        setTopic(topic);
        setAttendance();
    }

    public String getTrainingId() {
        return trainingId;
    }

    public final void setTrainingId(String trainingId) {
        this.trainingId = trainingId;
    }

    public LocalDate getDate() {
        return date;
    }

    public final void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public final void setLocation(String location) {
        this.location = location;
    }

    public String getTopic() {
        return topic;
    }

    public final void setTopic(String topic) {
        this.topic = topic;
    }

    public List<AttendanceRecord> getAttendance() {
        return attendances;
    }

    public final void setAttendance() {
        this.attendances = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        return String.format("|%-10s|%-15s|%-60s|%-60s", 
                              trainingId, date, location, topic);
    }
}