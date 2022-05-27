package terminal.datacontainers;

public class PersonalityDataContainer {

    private String[] personalityTraits;
    private String[] ideal;
    private String[] bond;
    private String[] flaw;

    public String[] getPersonalityTraits() {
        return personalityTraits;
    }

    public String[] getIdeal() {
        return ideal;
    }

    public String[] getBond() {
        return bond;
    }

    public String[] getFlaw() {
        return flaw;
    }

    public void setPersonalityTraits(String[] personalityTraits) {
        this.personalityTraits = personalityTraits;
    }

    public void setIdeal(String[] ideal) {
        this.ideal = ideal;
    }

    public void setBond(String[] bond) {
        this.bond = bond;
    }

    public void setFlaw(String[] flaw) {
        this.flaw = flaw;
    }
}
