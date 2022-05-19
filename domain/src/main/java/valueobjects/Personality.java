package valueobjects;

import exceptions.PersonalityException;

import java.util.Arrays;

public final class Personality {

    final String[] personalityTraits;
    final String[] ideal;
    final String[] bond;
    final String[] flaw;

    public Personality(String[] personalityTraits, String[] ideal, String[] bond, String[] flaw) throws PersonalityException {
        if(personalityTraits != null) this.personalityTraits = personalityTraits;
        else throw new PersonalityException("Personality Traits can not be null");

        if (ideal != null) this.ideal = ideal;
        else throw new PersonalityException("Ideals can not be null");

        if(bond != null) this.bond = bond;
        else throw new PersonalityException("Bonds can not be null");

        if (flaw != null) this.flaw = flaw;
        else throw new PersonalityException("Flaws can not be null");
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

    @Override
    public String toString() {
        return "Personality{" +
                "personalityTraits=" + Arrays.toString(personalityTraits) +
                ", ideal=" + Arrays.toString(ideal) +
                ", bond=" + Arrays.toString(bond) +
                ", flaw=" + Arrays.toString(flaw) +
                '}';
    }
}
