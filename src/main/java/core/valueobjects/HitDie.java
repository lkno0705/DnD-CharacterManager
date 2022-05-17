package core.valueobjects;

import java.util.Objects;

public final class HitDie {

    final int dieType;
    final int amount;

    public HitDie(int dieType, int amount) {
        this.dieType = dieType;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HitDie hitDie = (HitDie) o;
        return dieType == hitDie.dieType && amount == hitDie.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dieType, amount);
    }
}
