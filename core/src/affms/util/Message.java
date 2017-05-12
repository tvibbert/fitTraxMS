package affms.util;

import org.joda.time.LocalDate;

public class Message implements Notification {
    private boolean is_immediate;
    private StringBuffer message;
    private LocalDate date;
    private LocalDate expires;
    private int message_id;
    
    public Message() {
        super();
    }

    @Override
    public void setMessage(StringBuffer message) {
        this.message = message;
    }

    @Override
    public void setDate(LocalDate date) {
        this.date =  date;
    }

    @Override
    public void setExpires(LocalDate expires) {
       this.expires = expires;
    }

    @Override
    public void setID(int id) {
        this.message_id = id;
    }

    @Override
    public int getID() {
        return message_id;
    }

    @Override
    public String getMessage() {
        return message.toString();
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public LocalDate getExpires() {
        return expires;
    }

    public void setIsImmediate(boolean is_immediate) {
        this.is_immediate = is_immediate;
    }

    public boolean isIsImmediate() {
        return is_immediate;
    }

}
