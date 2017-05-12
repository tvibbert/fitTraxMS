package affms.core;

import org.joda.time.LocalDate;

public class Exemption {
    private String type;
    private String category;
    private LocalDate start_date;
    private LocalDate end_date;
    private StringBuffer notes;
    
    public Exemption() {
        super();
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setNotes(StringBuffer notes) {
        this.notes = notes;
    }

    public StringBuffer getNotes() {
        return notes;
    }
}
