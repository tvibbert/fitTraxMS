package affms.core;

import java.util.List;

public class Jurisdiction {
    private int famgrid;
    private int roleid;
    private List <String> pascodes;
    
    public Jurisdiction() {
        super();
    }

    public void setFamgrid(int famgrid) {
        this.famgrid = famgrid;
    }

    public int getFamgrid() {
        return famgrid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setPascodes(List<String> pascodes) {
        this.pascodes = pascodes;
    }

    public List<String> getPascodes() {
        return pascodes;
    }
}
