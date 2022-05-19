package valueobjects;

import exceptions.ArmorException;

import java.util.Objects;

/*
Armor:
    * Name
    * base Armor Class
    * With Dex: Bool
    * Max DexBonus
    * Minimum Strength -> Wenn nicht erfüllt, dann geht nicht ins Inventar
 */

public final class Armor {

    final String name;
    final int baseAC;
    final boolean withDex;
    final int maxDexBonus;
    final int minimumStrength;

    public Armor(String name, int baseAC, boolean withDex, int maxDexBonus, int minimumStrength) throws ArmorException {
        if (name != null && !name.equals("")) this.name = name;
        else throw new ArmorException("Invalid Name: " + name);

        if (baseAC > 0) this.baseAC = baseAC;
        else throw new ArmorException("Invaild base Armor Class: " + baseAC);

        this.withDex = withDex;

        if (maxDexBonus > 0) this.maxDexBonus = maxDexBonus;
        else throw new ArmorException("Invalid maximum Dexterity Bonus: " + maxDexBonus);

        if (minimumStrength > 0) this.minimumStrength = minimumStrength;
        else throw new ArmorException("Invalid minimum Strength: " + minimumStrength);
    }

    public String getName() {
        return name;
    }

    public int getBaseAC() {
        return baseAC;
    }

    public boolean isWithDex() {
        return withDex;
    }

    public int getMaxDexBonus() {
        return maxDexBonus;
    }

    public int getMinimumStrength() {
        return minimumStrength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Armor armor = (Armor) o;
        return baseAC == armor.baseAC && withDex == armor.withDex && maxDexBonus == armor.maxDexBonus && minimumStrength == armor.minimumStrength && Objects.equals(name, armor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, baseAC, withDex, maxDexBonus, minimumStrength);
    }

    @Override
    public String toString() {
        return "Armor{" +
                "name='" + name + '\'' +
                ", baseAC=" + baseAC +
                ", withDex=" + withDex +
                ", maxDexBonus=" + maxDexBonus +
                ", minimumStrength=" + minimumStrength +
                '}';
    }
}
