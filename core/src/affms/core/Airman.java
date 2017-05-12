package affms.core;

import java.util.List;

import org.joda.time.LocalDate;

public class Airman extends Person {
    private LocalDate  nextfa_due_date;
    private LocalDate not_current_date;
    private LocalDate fip_due_date;
    private LocalDate fip_attended_date;
    private boolean fip_needed;
    private double bmi;
    private double bfa;
    private String fit_rating;

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBfa(double bfa) {
        this.bfa = bfa;
    }

    public double getBfa() {
        return bfa;
    }

    public void setFit_rating(String fit_rating) {
        this.fit_rating = fit_rating;
    }

    public String getFit_rating() {
        return fit_rating;
    }
    private List <Exemption> exemptions;
    
    public Airman() {
        super();
    }

    public void setNextfa_due_date(LocalDate nextfa_due_date) {
        this.nextfa_due_date = nextfa_due_date;
    }

    public LocalDate getNextfa_due_date() {
        return nextfa_due_date;
    }

    public void setNot_current_date(LocalDate not_current_date) {
        this.not_current_date = not_current_date;
    }

    public LocalDate getNot_current_date() {
        return not_current_date;
    }

    public void setFip_due_date(LocalDate fip_due_date) {
        this.fip_due_date = fip_due_date;
    }

    public LocalDate getFip_due_date() {
        return fip_due_date;
    }

    public void setFip_attended_date(LocalDate fip_attended_date) {
        this.fip_attended_date = fip_attended_date;
    }

    public LocalDate getFip_attended_date() {
        return fip_attended_date;
    }

    public void setFip_needed(boolean fip_needed) {
        this.fip_needed = fip_needed;
    }

    public boolean isFip_needed() {
        return fip_needed;
    }

    public void setExemptions(List<Exemption> exemptions) {
        this.exemptions = exemptions;
    }

    public List<Exemption> getExemptions() {
        return exemptions;
    }
}
