package core.valueobjects;

import java.util.Arrays;

public final class Personality {

    final String[] personalityTraits;
    final String[] ideal;
    final String[] bond;
    final String[] flaw;

    public Personality(String[] personalityTraits, String[] ideal, String[] bond, String[] flaw) {
        this.personalityTraits = personalityTraits;
        this.ideal = ideal;
        this.bond = bond;
        this.flaw = flaw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personality that = (Personality) o;
        return Arrays.equals(personalityTraits, that.personalityTraits) && Arrays.equals(ideal, that.ideal) && Arrays.equals(bond, that.bond) && Arrays.equals(flaw, that.flaw);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(personalityTraits);
        result = 31 * result + Arrays.hashCode(ideal);
        result = 31 * result + Arrays.hashCode(bond);
        result = 31 * result + Arrays.hashCode(flaw);
        return result;
    }
}
