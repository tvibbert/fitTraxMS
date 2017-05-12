package affms.util;

import org.joda.time.LocalDate;

public interface Notification {
    public void setMessage(StringBuffer message);
    public void setDate(LocalDate date);
    public void setExpires(LocalDate expires);
    public void setID(int id);
    public int getID();
    public String getMessage();
    public LocalDate getDate();
    public LocalDate getExpires();
    
}
