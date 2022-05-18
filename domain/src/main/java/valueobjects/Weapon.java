package valueobjects;

import exceptions.WeaponException;

import java.util.Objects;

/*
Weapon:
    * Namen
    * DamageDie
        DieType -> Welcher Würfel
        Amount
    * isFinesse -> Use Strength or Dexterity modifier for Attack Rolls & Damage Rolls
 */

public final class Weapon {

    final String name;
    final HitDie damageDie;
    final boolean isFinesse;

    public Weapon(String name, HitDie damageDie, boolean isFinesse) throws WeaponException {
        if (name != null && !name.equals("")) this.name = name;
        else throw new WeaponException("Invalid Name: " + name);

        if (damageDie != null) this.damageDie = damageDie;
        else throw new WeaponException("Invalid damage Die");

        this.isFinesse = isFinesse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weapon weapon = (Weapon) o;
        return isFinesse == weapon.isFinesse && Objects.equals(name, weapon.name) && Objects.equals(damageDie, weapon.damageDie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, damageDie, isFinesse);
    }
}
