package affms.util;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

public class LogEntry {
    private LocalDate date;
    private LocalTime time;
    private String asset;
    private String operation;
    private String severity;

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public String getAsset() {
        return asset;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getSeverity() {
        return severity;
    }

    public void setMessage(StringBuffer message) {
        this.message = message;
    }

    public StringBuffer getMessage() {
        return message;
    }
    private StringBuffer message;
    
    public LogEntry() {
        super();
    }
}
