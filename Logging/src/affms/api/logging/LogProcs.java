package affms.api.logging;

import affms.util.LogEntry;
import affms.util.Message;
import affms.util.data.Database;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.Hashtable;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.sql.DataSource;

import org.joda.time.LocalDate;

public class LogProcs implements Database {
    private Connection conn;
    private DataSource ds;
    private String jndi = "AFFMS2DS";
    
    public LogProcs() {
        super();
    }
    
    public LogProcs(String jndi) {
        this.jndi = jndi;
        setConnection();
    }

    @Override
    public void setConnection() {
        try {
            Hashtable parms = new Hashtable();
            parms.put(Context.INITIAL_CONTEXT_FACTORY, "com.ibm.websphere.naming.WsnInitialContextFactory");
            InitialContext ctx = new InitialContext(parms);
            ds = (DataSource) ctx.lookup(jndi);
            conn = ds.getConnection();
        } catch (NamingException e) {
        } catch (SQLException e) {
        }
    }

    @Override
    public void closeConnection() {
        try {
            conn.close();
            ds = null;
        } catch (SQLException e) {
        }
    }
    
    public void addLogEntry(LogEntry entry){
        CallableStatement cst;
        
        try {
            cst = conn.prepareCall("call add_log_entry(?,?)");
            cst.setString(1, entry.getAsset());
            cst.setString(2, entry.getOperation());
            cst.setString(3,entry.getSeverity());
            cst.setDate(4, entry.getDate());
            cst.setTime(5, entry.getTime());

           cst.execute();

        } catch (SQLException e) {
        }
    }
    
    public List <LogEntry> searchByDate(LocalDate date){
        List<LogEntry> logs = null;
        LogEntry entry = null;
        CallableStatement cst;
        ResultSet rs;
        LocalDate tmpdate;
        StringBuffer message;
        
        try {
            cst = conn.prepareCall("call search_logs_byDate(?,?)");
            cst.setDate(1, date);
            rs = (ResultSet) cst.getObject(2);

            do {
                entry = new LogEntry();
                entry.setAsset(rs.getString("asset"));
                entry.setDate(date);
                entry.setTime(arg0);
                entry.setOperation(rs.getString("operation"));
                entry.setSeverity(rs.getString("severity"));
                message = new StringBuffer(rs.getString("message"));
                entry.setMessage(message);
                logs.add(entry);
            } while (rs.next());

        } catch (SQLException e) {
        }

        return logs;
        
    }
        
    public List <LogEntry> searchByDateTime(){
        List<LogEntry> logs = null;
        LogEntry entry = null;
        CallableStatement cst;
        ResultSet rs;
        LocalDate tmpdate;
        StringBuffer message;
        
        try {
            cst = conn.prepareCall("call search_logs_byDate(?,?)");
            cst.setDate(1, date);
            rs = (ResultSet) cst.getObject(2);

            do {
                entry = new LogEntry();
                entry.setAsset(rs.getString("asset"));
                entry.setDate(arg0);
                entry.setTime(arg0);
                entry.setOperation(rs.getString("operation"));
                entry.setSeverity(rs.getString("severity"));
                message = new StringBuffer(rs.getString("message"));
                entry.setMessage(message);
                logs.add(entry);
            } while (rs.next());

        } catch (SQLException e) {
        }

        return logs;
    }
    
    public List <LogEntry> searchByAssest(String asset){
        List<LogEntry> logs = null;
        LogEntry entry = null;
        CallableStatement cst;
        ResultSet rs;
        LocalDate tmpdate;
        StringBuffer message;
        
        try {
            cst = conn.prepareCall("call search_logs_byAsset(?,?)");
            cst.setString(1, asset);
            rs = (ResultSet) cst.getObject(2);

            do {
                entry = new LogEntry();
                entry.setAsset(asset);
                entry.setDate(arg0);
                entry.setTime(arg0);
                entry.setOperation(rs.getString("operation"));
                entry.setSeverity(rs.getString("severity"));
                message = new StringBuffer(rs.getString("message"));
                entry.setMessage(message);
                logs.add(entry);
            } while (rs.next());

        } catch (SQLException e) {
        }

        return logs;
    }
    
    public List <LogEntry> searchBySeverity(String severity){
        List<LogEntry> logs = null;
        LogEntry entry = null;
        CallableStatement cst;
        ResultSet rs;
        LocalDate tmpdate;
        StringBuffer message;
        
        try {
            cst = conn.prepareCall("call search_logs_bySeverity(?,?)");
            cst.setString(1, severity);
            rs = (ResultSet) cst.getObject(2);

            do {
                entry = new LogEntry();
                entry.setAsset(rs.getString("asset"));
                entry.setDate(agr0);
                entry.setTime(arg0);
                entry.setOperation(rs.getString("operation"));
                entry.setSeverity(severity);
                message = new StringBuffer(rs.getString("message"));
                entry.setMessage(message);
                logs.add(entry);
            } while (rs.next());

        } catch (SQLException e) {
        }

        return logs; 
    }
    
    public List <LogEntry> searchByOperation(String operation){
        List<LogEntry> logs = null;
        LogEntry entry = null;
        CallableStatement cst;
        ResultSet rs;
        LocalDate tmpdate;
        StringBuffer message;
        
        try {
            cst = conn.prepareCall("call search_logs_byOperation(?,?)");
            cst.setString(1, operation);
            rs = (ResultSet) cst.getObject(2);

            do {
                entry = new LogEntry();
                entry.setAsset(rs.getString("asset"));
                entry.setDate(arg0);
                entry.setTime(arg0);
                entry.setOperation(operation);
                entry.setSeverity(rs.getString("severity"));
                message = new StringBuffer(rs.getString("message"));
                entry.setMessage(message);
                logs.add(entry);
            } while (rs.next());

        } catch (SQLException e) {
        }

        return logs;
    }
    
    
}
