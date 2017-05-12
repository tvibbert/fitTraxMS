package affms.core;

import java.util.List;

public class FitnessAsessment {
    private double height;
    private double weight;
    private List <Component> components;
    private boolean isexempt;
    private Exemption exemption;
    private double compositescore;
    private Airman airman;

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setIsexempt(boolean isexempt) {
        this.isexempt = isexempt;
    }

    public boolean isIsexempt() {
        return isexempt;
    }

    public void setExemption(Exemption exemption) {
        this.exemption = exemption;
    }

    public Exemption getExemption() {
        return exemption;
    }

    public void setCompositescore(double compositescore) {
        this.compositescore = compositescore;
    }

    public double getCompositescore() {
        return compositescore;
    }

    public void setAirman(Airman airman) {
        this.airman = airman;
    }

    public Airman getAirman() {
        return airman;
    }

    public FitnessAsessment() {
        super();
    }
}
