package affms.util;

public class About {
    private StringBuffer description;
    private double swft_release;
    private double ui_build;
    private double api_build;
    private double rules_build;
    private double rpt_release;
    
    public About() {
        super();
    }

    public void setDescription(StringBuffer description) {
        this.description = description;
    }

    public StringBuffer getDescription() {
        return description;
    }

    public void setSwft_release(double swft_release) {
        this.swft_release = swft_release;
    }

    public double getSwft_release() {
        return swft_release;
    }

    public void setUi_build(double ui_build) {
        this.ui_build = ui_build;
    }

    public double getUi_build() {
        return ui_build;
    }

    public void setApi_build(double api_build) {
        this.api_build = api_build;
    }

    public double getApi_build() {
        return api_build;
    }

    public void setRules_build(double rules_build) {
        this.rules_build = rules_build;
    }

    public double getRules_build() {
        return rules_build;
    }

    public void setRpt_release(double rpt_release) {
        this.rpt_release = rpt_release;
    }

    public double getRpt_release() {
        return rpt_release;
    }
}
