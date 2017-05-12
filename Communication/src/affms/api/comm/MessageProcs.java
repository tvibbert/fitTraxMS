package affms.api.comm;


import affms.core.Person;

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

public class MessageProcs implements Database {
    private Connection conn;
    private DataSource ds;
    private String jndi = "AFFMS2DS";
    
    public MessageProcs() {
        super();
    }
    
    public MessageProcs(String jndi) {
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
    
    public Message searchByID(int id){
        Message msg = null;
        CallableStatement cst;
        ResultSet rs;
        LocalDate tmpdate;
        StringBuffer message;

        try {
            cst = conn.prepareCall("call search_message_byid(?,?)");
            cst.setInt(1, id);
            rs = (ResultSet) cst.getObject(2);

            do {
                msg = new Message();
                msg.setIsImmediate(rs.getBoolean("Alert"));
                msg.setID(id);
                tmpdate = new LocalDate(rs.getDate("created"));
                msg.setDate(tmpdate);
                tmpdate = new LocalDate(rs.getDate("expires"));
                msg.setExpires(tmpdate);
                message = new StringBuffer(rs.getString("message"));
                msg.setMessage(message);
            } while (rs.next());

        } catch (SQLException e) {
        }

        return msg;
    }
    
    public List<Message> searchByText(String mesg) {
        List<Message> msgs = null;
        Message msg = null;
        CallableStatement cst;
        ResultSet rs;
        LocalDate tmpdate;
        StringBuffer message;
        
        try {
               cst = conn.prepareCall("call search_message_bytext(?,?)");
                cst.setString(1, mesg);
                rs = (ResultSet) cst.getObject(2);


            do {
                msg = new Message();
                msg.setIsImmediate(rs.getBoolean("Alert"));
                msg.setID(rs.getInt("id"));
                tmpdate = new LocalDate(rs.getDate("created"));
                msg.setDate(tmpdate);
                tmpdate = new LocalDate(rs.getDate("expires"));
                msg.setExpires(tmpdate);
                message = new StringBuffer(rs.getString("message"));
                msg.setMessage(message);
                msgs.add(msg);
            } while (rs.next());

        } catch (SQLException e) {
        }

        return msgs;
    }
}
