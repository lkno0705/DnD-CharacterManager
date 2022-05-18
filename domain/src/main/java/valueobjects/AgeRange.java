package valueobjects;

import exceptions.AgeRangeException;

import java.util.Objects;

public final class AgeRange {

    final int minimumAge;
    final int maximumAge;

    public AgeRange(int minimumAge, int maximumAge) throws AgeRangeException {
        if (minimumAge > 0) this.minimumAge = minimumAge;
        else throw new AgeRangeException("Invalid minimum Age: " + minimumAge);

        if (maximumAge > 0 && maximumAge > this.minimumAge) this.maximumAge = maximumAge;
        else throw new AgeRangeException("Invalid maximum Age: " + maximumAge);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgeRange ageRange = (AgeRange) o;
        return minimumAge == ageRange.minimumAge && maximumAge == ageRange.maximumAge;
    }

    @Override
    public int hashCode() {
        return Objects.hash(minimumAge, maximumAge);
    }

    public int getMinimumAge() {
        return minimumAge;
    }

    public int getMaximumAge() {
        return maximumAge;
    }
}
