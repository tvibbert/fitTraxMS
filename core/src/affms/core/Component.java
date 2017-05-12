package affms.core;

public interface Component {
    public void setScore(int score);

    public void setPoints(int points);

    public void setIsMet(boolean ismet);

    public void setHelathRisk(String risk);

    public int getScore();

    public int getPoints();

    public boolean getIsMet();

    public String getHealthRisk();

    public void setIsExempt(boolean isexempt);

    public boolean getIsExempt();

    public void setExemption(Exemption exemption);

    public Exemption getExemption();
}
