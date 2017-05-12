package affms.core;

import java.util.List;

public class FAManager extends Person {
    private int famgrid;
    private List <Role> roles;
    private Jurisdiction jurisdiction;


    public void setJurisdiction(Jurisdiction jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public Jurisdiction getJurisdiction() {
        return jurisdiction;
    }

    public FAManager() {
        super();
    }

   public void setFamgrid(int famgrid) {
        this.famgrid = famgrid;
    }

    public int getFamgrid() {
        return famgrid;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Role> getRoles() {
        return roles;
    }
}
