package affms.core;

public class SitUps implements Component {
    static final String type = "SitUps";
    private int score;
    private int points_achieved;
    private boolean ismet;
    private boolean isexempt;
    private Exemption exemption;
    private String healthrisk;

    public SitUps() {
        super();
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public void setPoints(int points) {
        this.points_achieved = points;
    }

    @Override
    public void setIsMet(boolean ismet) {
        this.ismet = ismet;
    }

    @Override
    public void setHelathRisk(String risk) {
        this.healthrisk = risk;
    }

    @Override
    public int getPoints() {
        return points_achieved;
    }

    @Override
    public boolean getIsMet() {

        return ismet;
    }

    @Override
    public String getHealthRisk() {
        return healthrisk;
    }

    @Override
    public int getScore() {
        return score;
    }
    
    @Override
    public void setIsExempt(boolean isexempt) {
        this.isexempt = isexempt;
    }

    @Override
    public boolean getIsExempt() {
        return isexempt;
    }

    @Override
    public void setExemption(Exemption exemption) {
        this.exemption = exemption;
    }

    @Override
    public Exemption getExemption() {
        return exemption;
    }
}
