package valueobjects;

import exceptions.HitDieException;

import java.util.Arrays;
import java.util.Objects;

public final class HitDie {

    final int dieType;
    final int amount;

    public HitDie(int dieType, int amount) throws HitDieException {
        if (isValidDie(dieType)) this.dieType = dieType;
        else throw new HitDieException("Invalid DieType: d" + dieType);
        if (amount > 0) this.amount = amount;
        else throw  new HitDieException("Invalid Amount, amount not > 0");
    }

    public int getDieType() {
        return dieType;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HitDie hitDie = (HitDie) o;
        return dieType == hitDie.dieType && amount == hitDie.amount;
    }

    private boolean isValidDie(int dieType){
        final int[] allowedDieTypes = {4, 6, 8, 10, 12, 20};
        return Arrays.stream(allowedDieTypes).anyMatch(die -> die == dieType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dieType, amount);
    }

    @Override
    public String toString() {
        return "HitDie{" +
                "dieType=" + dieType +
                ", amount=" + amount +
                '}';
    }
}
