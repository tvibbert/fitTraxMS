package affms.api.search;

import affms.core.Person;

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

public class SearchProcs implements Database {
    private Connection conn;
    private DataSource ds;
    private String jndi = "AFFMS2DS";

    public SearchProcs() {
        super();
        setConnection();
    }

    public SearchProcs(String jndi) {
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

    public Person searchBySSID(String ssid) {
        Person person = null;
        CallableStatement cst;
        ResultSet rs;

        try {
            cst = conn.prepareCall("call search_person_byssid(?,?)");
            cst.setString(1, ssid);
            rs = (ResultSet) cst.getObject(2);

            do {
                person = new Person();
                person.setFirstname(rs.getString("first_name"));
                person.setFirstname(rs.getString("last_name"));
                person.setSsid(ssid);
            } while (rs.next());

        } catch (SQLException e) {
        }

        return person;
    }

    public List<Person> searchByName(String first, String last) {
        List<Person> people = null;
        Person person = null;
        CallableStatement cst;
        ResultSet rs;

        try {
            if (first.length() == 0 || first.equalsIgnoreCase("")) {
                cst = conn.prepareCall("call search_person_bylastname(?,?)");
                cst.setString(1, last);
                rs = (ResultSet) cst.getObject(2);

            } else if (last.length() == 0 || last.equalsIgnoreCase("")) {
                cst = conn.prepareCall("call search_person_byfirstname(?,?)");
                cst.setString(1, first);
                rs = (ResultSet) cst.getObject(2);
            } else {
                cst = conn.prepareCall("call search_person_byname(?,?,?)");
                cst.setString(1, first);
                cst.setString(2, last);
                rs = (ResultSet) cst.getObject(3);
            }

            do {
                person = new Person();
                person.setFirstname(rs.getString("first_name"));
                person.setFirstname(rs.getString("last_name"));
                person.setSsid(rs.getString("ssid"));
                people.add(person);
            } while (rs.next());

        } catch (SQLException e) {
        }

        return people;
    }

    public List<Person> searchByPASCode(List<String> pascodes) {
        List<Person> people = null;
        Person person = null;
        String pascodelist = "";
        CallableStatement cst;
        ResultSet rs;


        for (String tmp : pascodes) {
            pascodelist = pascodelist + "'" + tmp + ",";
        }

       
       if (pascodelist.endsWith(",")){
           pascodelist = pascodelist.substring(pascodelist.length() -1);
           
       }
        try {
            cst = conn.prepareCall("call search_person_bypascode(?,?)");
            cst.setString(1, pascodelist);
            rs = (ResultSet) cst.getObject(2);


            do {
                person = new Person();
                person.setFirstname(rs.getString("first_name"));
                person.setFirstname(rs.getString("last_name"));
                person.setSsid(rs.getString("ssid"));
                people.add(person);
            } while (rs.next());

        } catch (SQLException e) {
        }

        return people;
    }


}
