package valueobjects;

import java.util.Objects;

public final class AgeRange {

    final int minimumAge;
    final int maximumAge;

    public AgeRange(int minimumAge, int maximumAge) {
        this.minimumAge = minimumAge;
        this.maximumAge = maximumAge;
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
}
